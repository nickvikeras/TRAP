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
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.db.CurrencyDB;
import edu.umn.se.trap.db.GrantDB;
import edu.umn.se.trap.db.PerDiemDB;
import edu.umn.se.trap.db.UserDB;
import edu.umn.se.trap.db.UserGrantDB;
import edu.umn.se.trap.util.TrapDateUtil;
import edu.umn.se.trap.util.TrapErrors;

/**
 * @author nick
 *
 */
public class HotelMustHave2DayTripSystemTest extends AbstractSystemTest
{

    @Before
    public void setUp() throws Exception{
        GregorianCalendar arrivalCal = new GregorianCalendar();
        arrivalCal.add(GregorianCalendar.DAY_OF_MONTH, -6);
        GregorianCalendar departureCal = new GregorianCalendar();
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, -6);
        arrivalCal.add(GregorianCalendar.HOUR_OF_DAY, 2);
        this.departureDate = departureCal.getTime();
        this.arrivalDate = arrivalCal.getTime();
        this.testProcessor = new TravelFormProcessor(new UserDB(),
                new PerDiemDB(), new GrantDB(), new UserGrantDB(),
                new CurrencyDB());
        this.testProcessor.clearSavedForms();
    }
    
    @Test
    public void test1DayTripWithLodging() throws Exception
    {
        Map<String, String> formData = new HashMap<String, String>();
        formData.put("USER_NAME", "linc001");
        formData.put("DEPARTURE_DATETIME",
                TrapDateUtil.printDateTime(departureDate));
        formData.put("ARRIVAL_DATETIME",
                TrapDateUtil.printDateTime(arrivalDate));

        formData.put("TRAVEL_TYPE_CSE_SPONSORED", "yes");
        formData.put("EMERGENCY_CONTACT_NAME", "Greg Gay");
        formData.put("EMERGENCY_CONTACT_PHONE", "765-432-1098");
        formData.put("JUSTIFICATION_CONFERENCE_TITLE",
                "ASE2012: 26th IEEE/ACM International Conference on "
                        + "Automated Software Engineering");
        formData.put("JUSTIFICATION_PRESENTED", "no");
        formData.put("JUSTIFICATION_SPONSORED",
                "Learn about research in the field.");
        formData.put("NUM_GRANTS", "1");
        formData.put("GRANT1_ACCOUNT", "010101010101");
        formData.put("GRANT1_PERCENT", "100");
        formData.put("NUM_OTHER_EXPENSES", "2");
        formData.put("OTHER1_DATE", "20121003");
        formData.put("OTHER1_JUSTIFICATION", "Conference Registration");
        formData.put("OTHER1_AMOUNT", "450.00");
        formData.put("OTHER1_CURRENCY", "USD");
        formData.put("OTHER2_DATE", "20121003");
        formData.put("OTHER2_JUSTIFICATION", "Workshop Registration");
        formData.put("OTHER2_AMOUNT", "100");
        formData.put("OTHER2_CURRENCY", "USD");
        formData.put("NUM_DAYS", "1");
        formData.put("DAY1_LUNCH_CITY", "Des Moines");
        formData.put("DAY1_LUNCH_STATE", "IA");
        formData.put("DAY1_LUNCH_COUNTRY", "USA");
        formData.put("DAY1_DINNER_CITY", "Kansas City");
        formData.put("DAY1_DINNER_STATE", "MO");
        formData.put("DAY1_DINNER_COUNTRY", "USA");
        formData.put("DAY1_LODGING_CITY", "Lawrence");
        formData.put("DAY1_LODGING_STATE", "KS");
        formData.put("DAY1_LODGING_COUNTRY", "USA");
        formData.put("DAY1_LODGING_AMOUNT", "86.31");
        formData.put("DAY1_LODGING_CURRENCY", "USD");
        
        super.testProcessor.setUser("linc001");
        String description = "my form description";
        
        // TODO
        Printer.print(formData, null);
        
        try
        {
            SystemTestUtil.submitFormData(formData, description,
                    super.testProcessor, null);
        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.LODGING_EXPENSE_1_DAY, e.getMessage());
           return;
        }
        fail("An exception should have been thrown");
    }

}
