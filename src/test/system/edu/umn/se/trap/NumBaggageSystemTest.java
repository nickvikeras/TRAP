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
 * @author nick
 * 
 */
public class NumBaggageSystemTest extends AbstractSystemTest
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
    public void testValidNumBaggage()
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();
        input.put("TRANSPORTATION5_TYPE", "AIR");
        input.put("TRANSPORTATION5_CARRIER", "DELTA");
        input.put("TRANSPORTATION6_TYPE", "BAGGAGE");
        output.put("TRANSPORTATION6_TYPE", "BAGGAGE");
        output.put("TRANSPORTATION5_TYPE", "AIR");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (Exception e)
        {
            fail("No expception should have been thrown");
        }
    }

    @Test
    public void testInvalidNumBaggage()
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();
        input.put("TRANSPORTATION5_TYPE", "AIR");
        input.put("TRANSPORTATION5_CARRIER", "DELTA");
        input.put("TRANSPORTATION6_TYPE", "BAGGAGE");
        output.put("TRANSPORTATION6_TYPE", "BAGGAGE");
        input.put("TRANSPORTATION4_TYPE", "BAGGAGE");
        output.put("TRANSPORTATION4_TYPE", "BAGGAGE");
        output.put("TRANSPORTATION5_TYPE", "AIR");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (Exception e)
        {
            assertEquals(TrapErrors.INVALID_NUM_BAGGAGE, e.getMessage());
            return;
        }
        fail("an exception should have been caught.");
    }

}
