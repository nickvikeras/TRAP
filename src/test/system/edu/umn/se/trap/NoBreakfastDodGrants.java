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

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.util.TrapErrors;

/**
 * @author Mark
 * 
 */
public class NoBreakfastDodGrants extends AbstractSystemTest
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
    public void testDodBreakfast() throws Exception
    {

        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        input.put("DAY1_BREAKFAST_CITY", "minneapolis");
        input.put("DAY1_BREAKFAST_STATE", "mn");
        input.put("DAY1_BREAKFAST_COUNTRY", "united states");

        input.put("GRANT1_ACCOUNT", "62735842");

        output.put("DAY1_TOTAL", "117.06");
        output.put("GRANT1_ACCOUNT", "62735842");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "1082.90");
        output.put("TOTAL_REIMBURSEMENT", "1082.90");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);

            if (Double.parseDouble(output.get("DAY1_TOTAL")) > 110.06)
            {
                fail("This expense should not have any grants covering it.");
            }
        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.NO_GRANTS_FOR_EXPENSE, e.getMessage());
            return;
        }

    }

    @Test
    public void testDodNoBreakfast() throws Exception
    {

        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        input.put("GRANT1_ACCOUNT", "62735842");

        output.put("GRANT1_ACCOUNT", "62735842");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "1046.24");
        output.put("TOTAL_REIMBURSEMENT", "1046.24");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);

        }
        catch (TrapException e)
        {
            fail("No exception should have been thrown: " + e.getMessage());
        }

    }

    @Test
    public void testNoDodBreakfast() throws Exception
    {

        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        input.put("DAY1_BREAKFAST_CITY", "minneapolis");
        input.put("DAY1_BREAKFAST_STATE", "mn");
        input.put("DAY1_BREAKFAST_COUNTRY", "usa");

        input.put("GRANT1_ACCOUNT", "010101010101");

        output.put("DAY1_TOTAL", "117.06");
        output.put("GRANT1_ACCOUNT", "010101010101");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "1051.49");
        output.put("TOTAL_REIMBURSEMENT", "1051.49");

        output.put("NUM_DESTINATIONS", "4");
        output.put("DESTINATION1_CITY", "Des Moines");
        output.put("DESTINATION1_STATE", "IA");
        output.put("DESTINATION1_COUNTRY", "USA");
        output.put("DESTINATION2_CITY", "minneapolis");
        output.put("DESTINATION2_STATE", "mn");
        output.put("DESTINATION2_COUNTRY", "usa");
        output.put("DESTINATION3_CITY", "Kansas City");
        output.put("DESTINATION3_STATE", "MO");
        output.put("DESTINATION3_COUNTRY", "USA");
        output.put("DESTINATION4_CITY", "Lawrence");
        output.put("DESTINATION4_STATE", "KS");
        output.put("DESTINATION4_COUNTRY", "USA");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);

        }
        catch (TrapException e)
        {
            fail("No exception should have been thrown: " + e.getMessage());
        }

    }

    @Test
    public void testNoDodNoBreakfast() throws Exception
    {

        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        input.put("GRANT1_ACCOUNT", "010101010101");

        output.put("DAY1_TOTAL", "111.81");
        output.put("GRANT1_ACCOUNT", "010101010101");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "1046.24");
        output.put("TOTAL_REIMBURSEMENT", "1046.24");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);

        }
        catch (TrapException e)
        {
            fail("No exception should have been thrown: " + e.getMessage());
        }

    }

}
