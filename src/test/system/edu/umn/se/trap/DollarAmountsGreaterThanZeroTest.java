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
public class DollarAmountsGreaterThanZeroTest extends AbstractSystemTest
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
    public void testInValidExpensesNegative() throws Exception
    {

        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        Date transportationDate = new Date(departureDate.getTime());
        GregorianCalendar transportationCal = new GregorianCalendar();
        transportationCal.setTime(transportationDate);
        input.put("TRANSPORTATION1_DATE",
                TrapDateUtil.printDate(transportationCal.getTime()));
        input.put("TRANSPORTATION1_TYPE", "PARKING");
        input.put("TRANSPORTATION1_AMOUNT", "-0.99");
        input.put("TRANSPORTATION1_CURRENCY", "USD");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.VALID_DOLLAR_AMOUNT, e.getMessage());
            return;
        }
        fail("An expception should have been thrown");
    }

    @Test
    public void testInValidExpensesZero() throws Exception
    {

        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        Date otherDate = new Date(arrivalDate.getTime());
        GregorianCalendar otherCal = new GregorianCalendar();
        otherCal.roll(GregorianCalendar.DAY_OF_MONTH, false);
        otherCal.setTime(otherDate);
        int number = Integer.parseInt(input.get("NUM_OTHER_EXPENSES")) + 1;
        input.put("NUM_OTHER_EXPENSES", String.format("%d", number));
        input.put("OTHER" + number + "_DATE",
                TrapDateUtil.printDate(otherCal.getTime()));
        input.put("OTHER" + number + "_JUSTIFICATION", "Free Drinks!");
        input.put("OTHER" + number + "_AMOUNT", "0.00");
        input.put("OTHER" + number + "_CURRENCY", "USD");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.VALID_DOLLAR_AMOUNT, e.getMessage());
            return;
        }
        fail("An expception should have been thrown");
    }

    @Test
    public void testValidExpenses() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();
        input.put("DAY1_BREAKFAST_CITY", "Des Moines");
        input.put("DAY1_BREAKFAST_STATE", "IA");
        input.put("DAY1_BREAKFAST_COUNTRY", "USA");

        output.put("DAY1_TOTAL", "117.06");
        output.put("GRANT1_AMOUNT_TO_CHARGE", "1051.49");
        output.put("TOTAL_REIMBURSEMENT", "1051.49");

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
