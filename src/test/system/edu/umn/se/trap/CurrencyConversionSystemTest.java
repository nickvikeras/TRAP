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
public class CurrencyConversionSystemTest extends AbstractSystemTest
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
    public void testValidInConversion()
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();


        input.put("OTHER1_AMOUNT", "15");
        input.put("OTHER1_CURRENCY", "eur");

        output.put("GRANT1_AMOUNT_TO_CHARGE", "623.24");
        output.put("TOTAL_REIMBURSEMENT", "623.24");
        output.put("OTHER1_TOTAL", "27.00");
                
        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);

            double inputEur = Double.parseDouble(input.get("OTHER1_AMOUNT"));

            double conversion = 1.80;

            double outputUsd = Double.parseDouble(output.get("OTHER1_TOTAL"));

            assertTrue(inputEur * conversion == outputUsd);
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

        input.put("OTHER1_DATE", "20121003");
        input.put("OTHER1_JUSTIFICATION", "Conference Registration");
        input.put("OTHER1_AMOUNT", "15.00");
        input.put("OTHER1_CURRENCY", "zam");
        Printer.print(input, output);

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);

        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.CANNOT_FIND_CURRENCY_INFO, e.getMessage());
            return;
        }
        fail("an exception should have been caught because we used a made-up currency");
    }

}
