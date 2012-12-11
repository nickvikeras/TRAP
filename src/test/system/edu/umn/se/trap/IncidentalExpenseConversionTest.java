/*
    Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License. 
 */
package edu.umn.se.trap;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.db.CurrencyDB;
import edu.umn.se.trap.util.TrapErrors;

/**
 * @author Andrew
 * 
 */
public class IncidentalExpenseConversionTest extends AbstractSystemTest
{

    /*
     * (non-Javadoc)
     * 
     * @see edu.umn.se.trap.AbstractSystemTest#setUp()
     */
    @Before
    public void setUp() throws Exception
    {
        super.setUp();
    }

    /*
     * (non-Javadoc)
     * 
     * @see edu.umn.se.trap.AbstractSystemTest#tearDown()
     */
    @After
    public void tearDown() throws Exception
    {
        super.tearDown();
    }

    @Test
    public void testValidConversion()
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        input.put("DAY1_INCIDENTAL_CURRENCY", "euro");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (Exception e)
        {
            fail("No exception should have been thrown: " + e.getMessage());
        }
    }

    public void testValidInConversion()
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        /*
         * formData.put("DAY1_INCIDENTAL_CITY", "Minneapolis");
         * formData.put("DAY1_INCIDENTAL_STATE", "MN");
         * formData.put("DAY1_INCIDENTAL_COUNTRY", "USA");
         * formData.put("DAY1_INCIDENTAL_AMOUNT", "2.00");
         * formData.put("DAY1_INCIDENTAL_CURRENCY", "USD");
         * formData.put("DAY1_INCIDENTAL_JUSTIFICATION",
         * "A really good justification");
         */
        input.put("ARRIVAL_DATETIME", "20121202 235900");
        input.put("DEPARTURE_DATETIME", "20121016 100000");

        input.put("DAY1_INCIDENTAL_CITY", "Minneapolis");
        input.put("DAY1_INCIDENTAL_STATE", "MN");
        input.put("DAY1_INCIDENTAL_COUNTRY", "USA");
        input.put("DAY1_INCIDENTAL_AMOUNT", "10");
        input.put("DAY1_INCIDENTAL_CURRENCY", "euro");
        input.put("DAY1_INCIDENTAL_JUSTIFICATION",
                "A really good justification");

        output.put("DAY1_INCIDENTAL_TOTAL", "");
        /*
         * private static void checkOutput(Map<String, String> actualOut,
         * Calendar earliestFormSubmissionTime, Map<String, String>
         * expectOutput) throws ParseException
         */

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (Exception e)
        {
            fail("No exception should have been thrown");
        }
    }

    @Test
    public void testInvalidCurrency() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        input.put("DAY1_INCIDENTAL_CITY", "Minneapolis");
        input.put("DAY1_INCIDENTAL_STATE", "MN");
        input.put("DAY1_INCIDENTAL_COUNTRY", "USA");
        input.put("DAY1_INCIDENTAL_AMOUNT", "12.00");
        input.put("DAY1_INCIDENTAL_CURRENCY", "zam");
        input.put("DAY1_INCIDENTAL_JUSTIFICATION",
                "A really good justification");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            // KeyNotFoundException
            assertEquals(TrapErrors.CANNOT_FIND_CURRENCY_INFO, e.getMessage());
            return;
        }
        fail("an exception should have been caught because we used a made-up currency");
    }

    @Test
    public void testZeroAmount() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        input.put("DAY1_INCIDENTAL_CITY", "Minneapolis");
        input.put("DAY1_INCIDENTAL_STATE", "MN");
        input.put("DAY1_INCIDENTAL_COUNTRY", "USA");
        input.put("DAY1_INCIDENTAL_AMOUNT", "0");
        input.put("DAY1_INCIDENTAL_CURRENCY", "USD");
        input.put("DAY1_INCIDENTAL_JUSTIFICATION",
                "A really good justification");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.INCIDENTAL_AMOUNT_GREATER_THAN_ZERO, e.getMessage());
            return;
        }
        fail("an exception should have been caught because we used 0 as the value of the expense");
    }

    @Test
    public void testNegativeAmount() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        input.put("DAY1_INCIDENTAL_CITY", "Minneapolis");
        input.put("DAY1_INCIDENTAL_STATE", "MN");
        input.put("DAY1_INCIDENTAL_COUNTRY", "USA");
        input.put("DAY1_INCIDENTAL_AMOUNT", "-10.00");
        input.put("DAY1_INCIDENTAL_CURRENCY", "USD");
        input.put("DAY1_INCIDENTAL_JUSTIFICATION",
                "A really good justification");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.INCIDENTAL_AMOUNT_GREATER_THAN_ZERO, e.getMessage());
            return;
        }
        fail("an exception should have been caught because we used 0 as the value of the expense");
    }

}