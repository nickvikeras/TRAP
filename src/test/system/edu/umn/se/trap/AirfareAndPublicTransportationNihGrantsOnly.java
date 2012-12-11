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
public class AirfareAndPublicTransportationNihGrantsOnly extends
        AbstractSystemTest
{

    /* (non-Javadoc)
     * @see edu.umn.se.trap.AbstractSystemTest#setUp()
     */
    @Before
    public void setUp() throws Exception
    {
        super.setUp();
    }

    /* (non-Javadoc)
     * @see edu.umn.se.trap.AbstractSystemTest#tearDown()
     */
    @After
    public void tearDown() throws Exception
    {
        super.tearDown();
    }

    @Test
    public void testNihPublicTransportationAirfareAndBaggage() throws Exception
    {

        Map<String, String> input = getNoFoodInput();
        Map<String, String> output = getNoFoodOutput();
        
        input.put("GRANT1_ACCOUNT", "835938467");
        input.put("TRANSPORTATION2_TYPE", "AIR");
        input.put("TRANSPORTATION2_AMOUNT", "313.00");
        input.put("TRANSPORTATION2_CARRIER", "Spirit");
        input.put("TRANSPORTATION3_TYPE", "BAGGAGE");

        output.put("GRANT1_ACCOUNT", "835938467");
        output.put("TRANSPORTATION2_TYPE", "AIR");
        output.put("TRANSPORTATION2_TOTAL", "313.00");
        output.put("TRANSPORTATION3_TYPE", "BAGGAGE");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "1257.49");
        output.put("TOTAL_REIMBURSEMENT", "1257.49");
        
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
    public void testNoNihPublicTransportationAirfareAndBaggage() throws Exception
    {

        Map<String, String> input = getNoFoodInput();
        Map<String, String> output = getNoFoodOutput();
        
        input.put("TRANSPORTATION2_TYPE", "AIR");
        input.put("TRANSPORTATION2_AMOUNT", "313.00");
        input.put("TRANSPORTATION2_CARRIER", "Spirit");
        input.put("TRANSPORTATION3_TYPE", "BAGGAGE");

        output.put("TRANSPORTATION2_TYPE", "AIR");
        output.put("TRANSPORTATION2_TOTAL", "313.00");
        output.put("TRANSPORTATION3_TYPE", "BAGGAGE");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "1257.49");
        output.put("TOTAL_REIMBURSEMENT", "1257.49");
        
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
    public void testNoNihNonPublicTransportationAirfareAndBaggage() throws Exception
    {

        Map<String, String> input = getNoFoodInput();
        Map<String, String> output = getNoFoodOutput();
        
        input.put("TRANSPORTATION2_TYPE", "PARKING");
        input.put("TRANSPORTATION2_AMOUNT", "13.00");

        output.put("TRANSPORTATION2_TYPE", "PARKING");
        output.put("TRANSPORTATION2_TOTAL", "13.00");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "957.49");
        output.put("TOTAL_REIMBURSEMENT", "957.49");
        
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
    public void testNihNonPublicTransportationAirfareAndBaggage() throws Exception
    {

        Map<String, String> input = getNoFoodInput();
        Map<String, String> output = getNoFoodOutput();
        
        input.put("GRANT1_ACCOUNT", "835938467");
        input.put("TRANSPORTATION2_TYPE", "PARKING");
        input.put("TRANSPORTATION2_AMOUNT", "13.00");
        input.put("TRANSPORTATION2_CARRIER", "Spirit");
        
        output.put("GRANT1_ACCOUNT", "835938467");
        output.put("TRANSPORTATION2_TYPE", "PARKING");
        output.put("TRANSPORTATION2_TOTAL", "13.00");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "957.49");
        output.put("TOTAL_REIMBURSEMENT", "957.49");
      
        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);

            if (Double.parseDouble(output.get("DAY5_TOTAL")) > 0)
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

}
