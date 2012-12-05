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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @author nick
 * 
 */
public class SystemTestUtil
{
    /**
     * * Method for {@link TravelFormProcessorIntf#saveFormData(Map, String)} ,
     * {@link TravelFormProcessorIntf#getSavedForms()}, and
     * {@link TravelFormProcessorIntf#submitFormData(Integer)}.
     * <p />
     * This will save a new form, ensure that it exists in the list and then
     * submit the form checking that the output is what we expect.
     * 
     * @param inputFormData
     * @param description
     * @param testProcessor
     * @param expectedOut
     * @throws Exception
     */
    
    private static final String DATE_TIME_FORMAT = "yyyyMMdd HHmmss";
    
    public static void submitFormData(Map<String, String> inputFormData,
            String description, TravelFormProcessorIntf testProcessor,
            Map<String, String> expectedOut) throws Exception
    {
        // We need this later.
        Calendar then = Calendar.getInstance();

        // Save the form data, expecting no exception.
        testProcessor.saveFormData(inputFormData, description);

        Map<Integer, TravelFormMetadata> savedForms = testProcessor
                .getSavedForms();

        Set<Integer> keys = savedForms.keySet();
        Integer formId = null;

        // Find the form id we need.
        for (Integer key : keys)
        {
            TravelFormMetadata metadata = savedForms.get(key);
            if (metadata != null && description.equals(metadata.description))
            {
                // The form id was found, store it and break.
                formId = key;
                break;
            }
        }

        // If the form id was not found.
        if (formId == null)
        {
            fail("The saved form was not found with description '"
                    + description + "'.");
        }
        // Otherwise, we have a valid form id.

        // Now, we need to submit the form -- The test will fail if an exception
        // is thrown by submit.
        testProcessor.submitFormData(formId);

        // If we get here, the submission should have succeeded. Get the
        // completed form.
        Map<String, String> actualOut = testProcessor.getCompletedForm(formId);

        checkOutput(actualOut, then, expectedOut);
    }

    /**
     * Check the output to see if it matches what we expect.
     * 
     * @param actualOut
     *            the form that was emitted by TRAP
     * @param earliestFormSubmissionTime
     *            the earliest possible submission time to use in checking our
     *            times.
     * @param expectOutput
     * @throws ParseException
     */
    private static void checkOutput(Map<String, String> actualOut,
            Calendar earliestFormSubmissionTime,
            Map<String, String> expectOutput) throws ParseException
    {
        assertNotNull(actualOut);

        // Check that they have the same size (assuming we are missing 1 field
        // in
        // our expected output, the form submission date)
        assertEquals(expectOutput.size() + 1, actualOut.size());

        // Now, check each key.
        for (String key : expectOutput.keySet())
        {
            String expectedValue = expectOutput.get(key);
            String actualValue = actualOut.get(key);

            assertNotNull(actualValue);

            assertEquals(expectedValue, actualValue);
        }

        // Check the form submission date
        String formSubmissionDate = actualOut.get("FORM_SUBMISSION_DATETIME");

        assertNotNull(formSubmissionDate);

        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
        Date submissionDate = dateFormat.parse(formSubmissionDate);

        Calendar submissionDateCal = Calendar.getInstance();
        submissionDateCal.setTime(submissionDate);

        // Fail if submissionDate occurs before the earliest possible submission
        // time
        // if(earliestFormSubmissionTime != null &&
        // submissionDateCal.before(earliestFormSubmissionTime))
        // {
        // fail("The form submission time is incorrect.  It is shown " +
        // "as submitted before we started the submission.");
        // }

        Calendar now = Calendar.getInstance();

        // Fail if the submission date occurs after the current time.
        if (submissionDateCal.after(now))
        {
            fail("The form submission time is incorrect.  It is shown "
                    + "as submitted after the current time.");
        }

        // We passed the output check.
    }
}
