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
public class InternetNonSponsoredGrantsOnlyTest extends AbstractSystemTest
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
    public void testInternetSponsored() throws Exception
    {

        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();
        
        input.put("OTHER2_JUSTIFICATION", "Internet");
        
        output.put("OTHER2_JUSTIFICATION", "Internet");

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
    
    @Test
    public void testWifiSponsored() throws Exception
    {

        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();
        
        input.put("OTHER2_JUSTIFICATION", "Wifi");
        
        output.put("OTHER2_JUSTIFICATION", "Wifi");

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
    
    @Test
    public void testInternetNonSponsored() throws Exception
    {

        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();
        
        input.put("OTHER2_JUSTIFICATION", "Internet");
        input.put("JUSTIFICATION_NONSPONSORED", "Learn about research in the field.");
        input.remove("JUSTIFICATION_SPONSORED");
        input.remove("TRAVEL_TYPE_CSE_SPONSORED");
        input.put("TRAVEL_TYPE_NONSPONSORED", "yes");
        input.put("GRANT1_ACCOUNT", "99999");
        
        output.put("OTHER2_JUSTIFICATION", "Internet");
        output.put("JUSTIFICATION_NONSPONSORED", "Learn about research in the field.");
        output.remove("JUSTIFICATION_SPONSORED");
        output.remove("TRAVEL_TYPE_CSE_SPONSORED");
        output.put("TRAVEL_TYPE_NONSPONSORED", "yes");
        output.put("GRANT1_ACCOUNT", "99999");

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

}
