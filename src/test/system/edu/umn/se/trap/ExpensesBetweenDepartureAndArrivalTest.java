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
public class ExpensesBetweenDepartureAndArrivalTest extends AbstractSystemTest
{

    /*
     * (non-Javadoc)
     * 
     * @see edu.umn.se.trap.AbstractSystemTest#setUp()
     */
    /**
     * @throws java.lang.Exception
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
    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
        super.tearDown();
    }

    @Test
    public void testInValidExpensesPreviousDay() throws Exception
    {

        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        Date transportationDate = new Date(departureDate.getTime());
        GregorianCalendar transportationCal = new GregorianCalendar();
        transportationCal.setTime(transportationDate);
        transportationCal.roll(GregorianCalendar.DAY_OF_MONTH, false);
        input.put("TRANSPORTATION1_DATE",
                TrapDateUtil.printDate(transportationCal.getTime()));
        input.put("TRANSPORTATION1_TYPE", "PARKING");
        input.put("TRANSPORTATION1_AMOUNT", "12.00");
        input.put("TRANSPORTATION1_CURRENCY", "USD");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.EXPENSES_BETWEEN_DATES, e.getMessage());
            return;
        }
        fail("An expception should have been thrown");
    }

    @Test
    public void testInValidExpensesNextDay() throws Exception
    {

        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        Date transportationDate = new Date(arrivalDate.getTime());
        GregorianCalendar transportationCal = new GregorianCalendar();
        transportationCal.setTime(transportationDate);
        transportationCal.roll(GregorianCalendar.DAY_OF_MONTH, true);
        input.put("TRANSPORTATION1_DATE",
                TrapDateUtil.printDate(transportationCal.getTime()));
        input.put("TRANSPORTATION1_TYPE", "PARKING");
        input.put("TRANSPORTATION1_AMOUNT", "12.00");
        input.put("TRANSPORTATION1_CURRENCY", "USD");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.EXPENSES_BETWEEN_DATES, e.getMessage());
            return;
        }
        fail("An expception should have been thrown");
    }

    @Test
    public void testValidExpenses() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        Date transportationDate = new Date(departureDate.getTime());
        GregorianCalendar transportationCal = new GregorianCalendar();
        transportationCal.setTime(transportationDate);
        input.put("TRANSPORTATION1_DATE",
                TrapDateUtil.printDate(transportationCal.getTime()));
        input.put("TRANSPORTATION1_TYPE", "PARKING");
        input.put("TRANSPORTATION1_AMOUNT", "12.00");
        input.put("TRANSPORTATION1_CURRENCY", "USD");

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
