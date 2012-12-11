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
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.db.CurrencyDB;
import edu.umn.se.trap.util.TrapErrors;

/**
 * @author Andrew
 * 
 */
public class NumDestinationsSystemTest extends AbstractSystemTest
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
    public void testCityMost() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        input.put("DESTINATION1_CITY", "Des Moines");
        input.put("DESTINATION2_CITY", "Des Moines");
        input.put("DESTINATION3_CITY", "Des Moines");
        input.put("DESTINATION4_CITY", "Des Moines");
        input.put("DESTINATION5_CITY", "Des Moines");
        input.put("DESTINATION6_CITY", "Des Moines");
        input.put("DESTINATION7_CITY", "Des Moines");

        output.put("DESTINATION1_CITY", "Des Moines");
        output.put("DESTINATION2_CITY", "Des Moines");
        output.put("DESTINATION3_CITY", "Des Moines");
        output.put("DESTINATION4_CITY", "Des Moines");
        output.put("DESTINATION5_CITY", "Des Moines");
        output.put("DESTINATION6_CITY", "Des Moines");
        output.put("DESTINATION7_CITY", "Des Moines");

        output.put("NUM_DESTINATIONS", "7");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            fail("No exception should have been thrown");
        }
    }

    @Test
    public void testStateMost() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        output.put("NUM_DESTINATIONS", "3");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            fail("No exception should have been thrown");
        }
    }

    @Test
    public void testCountryMost() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        input.put("DESTINATION1_COUNTRY", "USA");
        input.put("DESTINATION2_COUNTRY", "CAN");
        input.put("DESTINATION3_COUNTRY", "UKD");
        input.put("DESTINATION4_COUNTRY", "GER");
        input.put("DESTINATION5_COUNTRY", "RUS");

        output.put("DESTINATION1_COUNTRY", "USA");
        output.put("DESTINATION2_COUNTRY", "CAN");
        output.put("DESTINATION3_COUNTRY", "UKD");
        output.put("DESTINATION4_COUNTRY", "GER");
        output.put("DESTINATION5_COUNTRY", "RUS");

        output.put("NUM_DESTINATIONS", "5");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            fail("No exception should have been thrown");
        }
    }

    @Test
    public void AllEqual() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        output.put("NUM_DESTINATIONS", "5");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            fail("No exception should have been thrown");
        }
    }

}
