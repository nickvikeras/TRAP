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

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.db.CurrencyDB;
import edu.umn.se.trap.db.GrantDB;
import edu.umn.se.trap.db.PerDiemDB;
import edu.umn.se.trap.db.UserDB;
import edu.umn.se.trap.db.UserGrantDB;

/**
 * @author nick
 *
 */
public class SubmitForms15DaysAfterTripSystemTest extends AbstractSystemTest
{

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        GregorianCalendar arrivalCal = new GregorianCalendar();
        arrivalCal.add(GregorianCalendar.DAY_OF_MONTH, -16);
        super.arrivalDate = arrivalCal.getTime();
        GregorianCalendar departureCal = new GregorianCalendar();
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, -20);
        super.departureDate = departureCal.getTime();
        super.testProcessor = new TravelFormProcessor(new UserDB(),
                new PerDiemDB(), new GrantDB(), new UserGrantDB(),
                new CurrencyDB());
        super.testProcessor.clearSavedForms();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testArrivalDateMoreThan15Days() throws Exception
    {
        super.testProcessor.setUser("linc001");
        String description = "my form description";
        try{
        SystemTestUtil.submitFormData(getBasicFormInput(), description,
                super.testProcessor, getBasicFormOutput());
        }
        catch(TrapException e){
            assertTrue(e.getMessage().contains("Forms must be filed no more than"));
            return;
        }
        fail("An exception should have been thrown.");
    }

}
