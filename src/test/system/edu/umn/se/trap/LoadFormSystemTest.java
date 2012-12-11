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

public class LoadFormSystemTest extends AbstractSystemTest
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

    // Create and save a valid form then load it
    @Test
    public void LoadValidFormTest() throws Exception
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

    // Try to load a form that doesn't exist
    @Test
    public void LoadImaginaryFormTest() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        Map<Integer, TravelFormMetadata> savedForms = testProcessor
                .getSavedForms();
        Set<Integer> keys = savedForms.keySet();
        int badID = 0;

        // Find the form id we need.
        for (Integer key : keys)
        {
            badID = key + 1;
        }

        try
        {
            Map<String, String> badForm = testProcessor.getSavedFormData(badID);
        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.NO_FORM_WITH_ID_0_FOUND, e.getMessage());
            return;
        }
        fail("An exception should have been thrown");

    }

}
