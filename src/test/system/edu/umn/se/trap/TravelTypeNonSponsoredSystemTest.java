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
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.util.TrapErrors;
import edu.umn.se.trap.util.TrapInputKeys;

/**
 * @author nick
 * 
 */
public class TravelTypeNonSponsoredSystemTest extends AbstractSystemTest
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

    // non-sponsored travel, non-sponsored grant
    @Test
    public void testNonSponsoredGrantAndTravel() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();
        
        input.put("GRANT1_ACCOUNT", "99999");
        output.put("GRANT1_ACCOUNT", "99999");

        input.put(TrapInputKeys.TRAVEL_TYPE_NONSPONSORED, "yes");
        output.put(TrapInputKeys.TRAVEL_TYPE_NONSPONSORED, "yes");
        
        input.put(TrapInputKeys.JUSTIFICATION_NONSPONSORED, "blah");
        output.put(TrapInputKeys.JUSTIFICATION_NONSPONSORED, "blah");
        
        input.remove(TrapInputKeys.TRAVEL_TYPE_CSE_SPONSORED);
        output.remove(TrapInputKeys.TRAVEL_TYPE_CSE_SPONSORED);
        
        input.remove(TrapInputKeys.JUSTIFICATION_SPONSORED);
        output.remove(TrapInputKeys.JUSTIFICATION_SPONSORED);
        
        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            fail("No expception should have been thrown");
        }
    }

    // non-sponsored travel, sponsored grant
    @Test
    public void testNonSponsoredTravelNotGrant() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();
        input.put(TrapInputKeys.TRAVEL_TYPE_NONSPONSORED, "yes");
        output.put(TrapInputKeys.TRAVEL_TYPE_NONSPONSORED, "yes");
        input.put(TrapInputKeys.JUSTIFICATION_NONSPONSORED, "blah");
        output.put(TrapInputKeys.JUSTIFICATION_NONSPONSORED, "blah");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.NO_GRANTS_FOR_TRAVEL_TYPE, e.getMessage());
            return;
        }
        fail("An expception should have been thrown");
    }

    // sponsored travel, non-sponsored grant
    @Test
    public void testNonSponsoredGrantNotTravel() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();
        input.put("GRANT1_ACCOUNT", "99999");
        output.put("GRANT1_ACCOUNT", "99999");
        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.NON_SPONSORED, e.getMessage());
            return;
        }
        fail("An expception should have been thrown");
    }

    // sponsored travel, sponsored grant
    @Test
    public void testSponsoredTravelNotGrant() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            fail("No expception should have been thrown");
        }
    }

}
