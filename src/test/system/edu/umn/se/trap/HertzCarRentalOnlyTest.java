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

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.util.TrapDateUtil;
import edu.umn.se.trap.util.TrapErrors;

/**
 * @author Mark
 * 
 */
public class HertzCarRentalOnlyTest extends AbstractSystemTest
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
    public void testDodGrantHertzRental() throws Exception
    {

        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        Date transportationDate = new Date(departureDate.getTime());
        GregorianCalendar transportationCal = new GregorianCalendar();
        transportationCal.setTime(transportationDate);
        input.put("TRANSPORTATION1_DATE",
                TrapDateUtil.printDate(transportationCal.getTime()));
        input.put("TRANSPORTATION1_TYPE", "CAR");
        input.put("TRANSPORTATION1_AMOUNT", "48.66");
        input.put("TRANSPORTATION1_CURRENCY", "USD");
        input.put("TRANSPORTATION1_RENTAL", "yes");
        input.put("TRANSPORTATION1_CARRIER", "Hertz");

        input.put("GRANT1_ACCOUNT", "62735842");

        output.put("TRANSPORTATION1_TYPE", "CAR");
        output.put("TRANSPORTATION1_TOTAL", "48.66");
        output.put("GRANT1_ACCOUNT", "62735842");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "1082.90");
        output.put("TOTAL_REIMBURSEMENT", "1082.90");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);

            if (Double.parseDouble(output.get("TRANSPORTATION1_TOTAL")) < Double
                    .parseDouble(input.get("TRANSPORTATION1_AMOUNT")))
            {
                fail("The grant should not have been removed from the form.");
            }
        }
        catch (TrapException e)
        {
            fail("No exception should have been thrown: " + e.getMessage());
        }

        // TODO
        Printer.print(input, output);
    }

    @Test
    public void testDodGrantNonHertzRental() throws Exception
    {

        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        Date transportationDate = new Date(departureDate.getTime());
        GregorianCalendar transportationCal = new GregorianCalendar();
        transportationCal.setTime(transportationDate);
        input.put("TRANSPORTATION1_DATE",
                TrapDateUtil.printDate(transportationCal.getTime()));
        input.put("TRANSPORTATION1_TYPE", "CAR");
        input.put("TRANSPORTATION1_AMOUNT", "48.66");
        input.put("TRANSPORTATION1_CURRENCY", "USD");
        input.put("TRANSPORTATION1_RENTAL", "yes");
        input.put("TRANSPORTATION1_CARRIER", "National");

        input.put("GRANT1_ACCOUNT", "62735842");

        output.put("TRANSPORTATION1_TYPE", "CAR");
        output.put("TRANSPORTATION1_TOTAL", "48.66");
        output.put("GRANT1_ACCOUNT", "62735842");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "1082.90");
        output.put("TOTAL_REIMBURSEMENT", "1082.90");

        // TODO
        Printer.print(input, output);

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);

            if (Double.parseDouble(output.get("TRANSPORTATION1_TOTAL")) > 0)
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

    @Test
    public void testNonDodGrantHertzRental() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        Date transportationDate = new Date(departureDate.getTime());
        GregorianCalendar transportationCal = new GregorianCalendar();
        transportationCal.setTime(transportationDate);
        input.put("TRANSPORTATION1_DATE",
                TrapDateUtil.printDate(transportationCal.getTime()));
        input.put("TRANSPORTATION1_TYPE", "CAR");
        input.put("TRANSPORTATION1_AMOUNT", "48.66");
        input.put("TRANSPORTATION1_CURRENCY", "USD");
        input.put("TRANSPORTATION1_RENTAL", "yes");
        input.put("TRANSPORTATION1_CARRIER", "Hertz");

        input.put("GRANT1_ACCOUNT", "010101010101");

        output.put("TRANSPORTATION1_TYPE", "CAR");
        output.put("TRANSPORTATION1_TOTAL", "48.66");
        output.put("GRANT1_ACCOUNT", "010101010101");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "1082.90");
        output.put("TOTAL_REIMBURSEMENT", "1082.90");
        
        // TODO
        Printer.print(input, output);

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);

            if (Double.parseDouble(output.get("TRANSPORTATION1_TOTAL")) > 0)
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

    @Test
    public void testNonDodNonHertz() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        Date transportationDate = new Date(departureDate.getTime());
        GregorianCalendar transportationCal = new GregorianCalendar();
        transportationCal.setTime(transportationDate);
        input.put("TRANSPORTATION1_DATE",
                TrapDateUtil.printDate(transportationCal.getTime()));
        input.put("TRANSPORTATION1_TYPE", "CAR");
        input.put("TRANSPORTATION1_AMOUNT", "48.66");
        input.put("TRANSPORTATION1_CURRENCY", "USD");
        input.put("TRANSPORTATION1_RENTAL", "yes");
        input.put("TRANSPORTATION1_CARRIER", "National");

        input.put("GRANT1_ACCOUNT", "010101010101");

        output.put("TRANSPORTATION1_TYPE", "CAR");
        output.put("TRANSPORTATION1_TOTAL", "48.66");
        output.put("GRANT1_ACCOUNT", "010101010101");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "1082.90");
        output.put("TOTAL_REIMBURSEMENT", "1082.90");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);

            if (Double.parseDouble(output.get("TRANSPORTATION1_TOTAL")) < Double
                    .parseDouble(input.get("TRANSPORTATION1_AMOUNT")))
            {
                fail("The grant should not have been removed from the form.");
            }

        }
        catch (TrapException e)
        {
            fail("No exception should have been thrown: " + e.getMessage());
        }

        // TODO
        Printer.print(input, output);
    }

}
