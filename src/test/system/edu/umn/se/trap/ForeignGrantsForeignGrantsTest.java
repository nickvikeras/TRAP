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
public class ForeignGrantsForeignGrantsTest extends AbstractSystemTest
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
    public void testForeignTravelForeignGrant() throws Exception
    {

        Map<String, String> input = getForeignAndDomesticTravelInput();
        Map<String, String> output = getForeignAndDomesticTravelOutput();

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);

        }
        catch (TrapException e)
        {
            fail("No exception should have been thrown: " + e.getMessage());
        }

        // TODO
        Printer.print(input, output);
    }
    
    @Test
    public void testForeignTravelNoForeignGrant() throws Exception
    {

        Map<String, String> input = getForeignAndDomesticTravelInput();
        Map<String, String> output = getForeignAndDomesticTravelOutput();
        
        input.put("NUM_GRANTS", "1");
        input.put("GRANT1_PERCENT", "100");
        input.remove("GRANT2_ACCOUNT");
        input.remove("GRANT2_PERCENT");
        
        output.put("NUM_GRANTS", "1");
        output.put("GRANT1_PERCENT", "100");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "957.49");
        output.remove("GRANT2_ACCOUNT");
        output.remove("GRANT2_PERCENT");
        output.remove("GRANT2_AMOUNT_TO_CHARGE");
        output.remove("GRANT2_APPROVER_NAME");

        
        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);

        }
        catch (TrapException e)
        {
            fail("No exception should have been thrown: " + e.getMessage());
        }

        // TODO
        Printer.print(input, output);
    }
    
    @Test
    public void testNoForeignTravelForeignGrant() throws Exception
    {

        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();
        
        input.put("GRANT1_ACCOUNT", "777555111");
        
        output.put("GRANT1_ACCOUNT", "777555111");

        // TODO
        Printer.print(input, output);
        
        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);

        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.NO_GRANTS_FOR_EXPENSE, e.getMessage());
            return;
        }
    }

}
