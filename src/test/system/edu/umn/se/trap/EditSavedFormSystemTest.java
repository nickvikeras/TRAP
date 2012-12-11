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
import edu.umn.se.trap.util.TrapDateUtil;
import edu.umn.se.trap.util.TrapErrors;

/**
 * @author Andrew
 * 
 */

public class EditSavedFormSystemTest extends AbstractSystemTest
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

    // Create and save a valid form
    @Test
    public void EditValidFormTest() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();
        testProcessor.saveFormData(input, "desc");

        Map<Integer, TravelFormMetadata> savedForms = testProcessor
                .getSavedForms();
        Set<Integer> keys = savedForms.keySet();
        Integer testKey = 0;
        for (Integer key : keys)
        {

            testKey = key;
        }

        Map<String, String> testMap = testProcessor.getSavedFormData(testKey);
        testMap.put("OTHER1_JUSTIFICATION", "Conference Fee");
        output.put("OTHER1_JUSTIFICATION", "Conference Fee");

        Printer.printOutput(output);

        try
        {
            SystemTestUtil.submitFormData(testMap, "desc", testProcessor,
                    output);
        }
        catch (TrapException e)
        {
            fail("No expception should have been thrown");
        }

    }

}
