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

import static org.junit.Assert.assertEquals;
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
public class CitizenshipSystemTest extends AbstractSystemTest
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
    public void testValidCitizenNoExport()
    {
        Map<String, String> input = super.getBasicFormInput();
        Map<String, String> output = super.getBasicFormOutput();

        input.put("GRANT1_ACCOUNT", "11223344");
        output.put("GRANT1_ACCOUNT", "11223344");
        


        try
        {
            SystemTestUtil.submitFormData(input, "description", testProcessor,
                    output);
        }
        catch (Exception e)
        {
            fail("TRAP threw an exception when a US citizen tried using a non-export grant");
        }
    }

    @Test
    public void testNonCitizenNoExport() throws Exception
    {
        Map<String, String> input = super.getBasicFormInput();
        Map<String, String> output = super.getBasicFormOutput();

        input.put(TrapInputKeys.USER_NAME, "china001");
        input.put("GRANT1_ACCOUNT", "11223344");
        output.put(TrapInputKeys.VISA_STATUS, "valid");
        output.put("GRANT1_ACCOUNT", "11223344");
        output.put("NAME", "China, Bob");
        output.put("USER_NAME", "china001");
        output.put("EMAIL", "china001@umn.edu");
        output.put("CITIZENSHIP", "China");



        try
        {
            SystemTestUtil.submitFormData(input, "description", testProcessor,
                    output);
        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.NONCITIZEN_EXPORT, e.getMessage());
            return;
        }
        fail("An exception should have been caught because a non citizen used a non-export grant.");
    }

    @Test
    public void testCitizenRegularGrant()
    {
        Map<String, String> input = super.getBasicFormInput();
        Map<String, String> output = super.getBasicFormOutput();


        try
        {
            SystemTestUtil.submitFormData(input, "description", testProcessor,
                    output);
        }
        catch (Exception e)
        {
            fail("TRAP threw an exception when a US citizen tried using a non-export grant");
        }
    }

    @Test
    public void testNonCitizenRegularGrant() throws Exception
    {
        Map<String, String> input = super.getBasicFormInput();
        Map<String, String> output = super.getBasicFormOutput();

        input.put(TrapInputKeys.USER_NAME, "china001");
        output.put(TrapInputKeys.VISA_STATUS, "valid");
        output.put("NAME", "China, Bob");
        output.put("USER_NAME", "china001");
        output.put("EMAIL", "china001@umn.edu");
        output.put("CITIZENSHIP", "China");
        
        
        // TODO
        Printer.print(input, output);

        try
        {
            SystemTestUtil.submitFormData(input, "description", testProcessor,
                    output);
        }
        catch (TrapException e)
        {
            fail("TRAP threw an exception when a US citizen tried using a non-export grant");
        }
    }

}
