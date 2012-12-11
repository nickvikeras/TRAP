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
public class IncidentalCoverageTests extends AbstractSystemTest
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
    public void testIncidentalCoverageAmountTooHigh() throws Exception
    {
        Map<String, String> input = getIncidentalInput();
        Map<String, String> output = getIncidentalOutput();

        // TODO
        Printer.print(input, output);

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);

        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.INCIDENTAL_AMOUNT_TOO_HIGH, e.getMessage());
            return;
        }
    }

    @Test
    public void testIncidentalCoverage() throws Exception
    {
        Map<String, String> input = getIncidentalInput();
        Map<String, String> output = getIncidentalOutput();

        input.put("DAY1_INCIDENTAL_AMOUNT", "4.00");

        output.put("DAY1_TOTAL", "115.81");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "1050.24");
        output.put("TOTAL_REIMBURSEMENT", "1050.24");

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
    public void testIncidentalCoverageCityOnly() throws Exception
    {
        Map<String, String> input = getIncidentalInput();
        Map<String, String> output = getIncidentalOutput();

        input.put("DAY1_INCIDENTAL_AMOUNT", "4.00");
        input.remove("DAY1_INCIDENTAL_STATE");
        input.remove("DAY1_INCIDENTAL_COUNTRY");

        output.put("DAY1_TOTAL", "115.81");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "1050.24");
        output.put("TOTAL_REIMBURSEMENT", "1050.24");

        // TODO
        Printer.print(input, output);

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);

        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.INCIDENTAL_AMOUNT_GREATER_THAN_ZERO,
                    e.getMessage());
            return;
        }
    }

    @Test
    public void testIncidentalCoverageStateOnly() throws Exception
    {
        Map<String, String> input = getIncidentalInput();
        Map<String, String> output = getIncidentalOutput();

        input.put("DAY1_INCIDENTAL_AMOUNT", "4.00");
        input.remove("DAY1_INCIDENTAL_CITY");
        input.remove("DAY1_INCIDENTAL_COUNTRY");

        output.put("NUM_DESTINATIONS", "4");
        output.put("DESTINATION2_STATE", "IA");
        output.remove("DESTINATION2_CITY");
        output.remove("DESTINATION2_COUNTRY");
        output.put("DESTINATION3_CITY", "Kansas City");
        output.put("DESTINATION3_STATE", "MO");
        output.put("DESTINATION3_COUNTRY", "USA");
        output.put("DESTINATION4_CITY", "Lawrence");
        output.put("DESTINATION4_STATE", "KS");
        output.put("DESTINATION4_COUNTRY", "USA");

        output.put("DAY1_TOTAL", "115.81");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "1050.24");
        output.put("TOTAL_REIMBURSEMENT", "1050.24");

        // TODO
        Printer.print(input, output);

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
    public void testIncidentalCoverageCountryOnly() throws Exception
    {
        Map<String, String> input = getIncidentalInput();
        Map<String, String> output = getIncidentalOutput();

        input.put("DAY1_INCIDENTAL_AMOUNT", "4.00");
        input.remove("DAY1_INCIDENTAL_STATE");
        input.remove("DAY1_INCIDENTAL_CITY");

        output.put("NUM_DESTINATIONS", "4");
        output.put("DESTINATION3_COUNTRY", "USA");
        output.remove("DESTINATION3_CITY");
        output.remove("DESTINATION3_STATE");
        output.put("DESTINATION2_CITY", "Kansas City");
        output.put("DESTINATION2_STATE", "MO");
        output.put("DESTINATION2_COUNTRY", "USA");
        output.put("DESTINATION4_CITY", "Lawrence");
        output.put("DESTINATION4_STATE", "KS");
        output.put("DESTINATION4_COUNTRY", "USA");

        output.put("DAY1_TOTAL", "115.81");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "1050.24");
        output.put("TOTAL_REIMBURSEMENT", "1050.24");

        // TODO
        Printer.print(input, output);

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
    public void testIncidentalCoverageInvalidCountry() throws Exception
    {
        Map<String, String> input = getIncidentalInput();
        Map<String, String> output = getIncidentalOutput();

        input.put("DAY1_INCIDENTAL_AMOUNT", "4.00");
        input.remove("DAY1_INCIDENTAL_STATE");
        input.remove("DAY1_INCIDENTAL_CITY");
        input.put("DAY1_INCIDENTAL_COUNTRY", "zimbabwe");

        output.put("NUM_DESTINATIONS", "4");
        output.put("DESTINATION3_COUNTRY", "zimbabwe");
        output.remove("DESTINATION3_CITY");
        output.remove("DESTINATION3_STATE");
        output.put("DESTINATION2_CITY", "Kansas City");
        output.put("DESTINATION2_STATE", "MO");
        output.put("DESTINATION2_COUNTRY", "USA");
        output.put("DESTINATION4_CITY", "Lawrence");
        output.put("DESTINATION4_STATE", "KS");
        output.put("DESTINATION4_COUNTRY", "USA");

        output.put("DAY1_TOTAL", "115.81");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "1050.24");
        output.put("TOTAL_REIMBURSEMENT", "1050.24");

        // TODO
        Printer.print(input, output);

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);

        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.CANNOT_FIND_PERDIEM_INFO, e.getMessage());
            return;
        }

    }

}
