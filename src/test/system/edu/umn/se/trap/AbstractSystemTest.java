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


import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;

import edu.umn.se.trap.db.CurrencyDB;
import edu.umn.se.trap.db.GrantDB;
import edu.umn.se.trap.db.PerDiemDB;
import edu.umn.se.trap.db.UserDB;
import edu.umn.se.trap.db.UserGrantDB;
import edu.umn.se.trap.util.TrapDateUtil;

/**
 * @author nick
 * 
 */
public abstract class AbstractSystemTest
{
    protected TravelFormProcessor testProcessor;
    protected Date arrivalDate;
    protected Date departureDate;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        GregorianCalendar arrivalCal = new GregorianCalendar();
        arrivalCal.add(GregorianCalendar.DAY_OF_MONTH, -6);
        this.arrivalDate = arrivalCal.getTime();
        GregorianCalendar departureCal = new GregorianCalendar();
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, -10);
        this.departureDate = departureCal.getTime();
        this.testProcessor = new TravelFormProcessor(new UserDB(),
                new PerDiemDB(), new GrantDB(), new UserGrantDB(),
                new CurrencyDB());
        this.testProcessor.clearSavedForms();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
    }

    protected Map<String, String> getBasicFormInput()
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
        formData.put("NUM_DAYS", "5");
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
        formData.put("DAY2_DINNER_CITY", "Lawrence");
        formData.put("DAY2_DINNER_STATE", "KS");
        formData.put("DAY2_DINNER_COUNTRY", "USA");
        formData.put("DAY2_LODGING_CITY", "Lawrence");
        formData.put("DAY2_LODGING_STATE", "KS");
        formData.put("DAY2_LODGING_COUNTRY", "USA");
        formData.put("DAY2_LODGING_AMOUNT", "86.31");
        formData.put("DAY2_LODGING_CURRENCY", "USD");
        formData.put("DAY3_LODGING_CITY", "Lawrence");
        formData.put("DAY3_LODGING_STATE", "KS");
        formData.put("DAY3_LODGING_COUNTRY", "USA");
        formData.put("DAY3_LODGING_AMOUNT", "86.31");
        formData.put("DAY3_LODGING_CURRENCY", "USD");
        formData.put("DAY4_DINNER_CITY", "Lawrence");
        formData.put("DAY4_DINNER_STATE", "KS");
        formData.put("DAY4_DINNER_COUNTRY", "USA");
        formData.put("DAY4_LODGING_CITY", "Lawrence");
        formData.put("DAY4_LODGING_STATE", "KS");
        formData.put("DAY4_LODGING_COUNTRY", "USA");
        formData.put("DAY4_LODGING_AMOUNT", "86.31");
        formData.put("DAY4_LODGING_CURRENCY", "USD");
        formData.put("DAY5_DINNER_CITY", "Des Moines");
        formData.put("DAY5_DINNER_STATE", "IA");
        formData.put("DAY5_DINNER_COUNTRY", "USA");
        formData.put("NUM_TRANSPORTATION", "6");
        GregorianCalendar departureCal = new GregorianCalendar();
        departureCal.setTime(departureDate);
        formData.put("TRANSPORTATION1_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION1_TYPE", "PARKING");
        formData.put("TRANSPORTATION1_AMOUNT", "12.00");
        formData.put("TRANSPORTATION1_CURRENCY", "USD");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("TRANSPORTATION2_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION2_TYPE", "PARKING");
        formData.put("TRANSPORTATION2_AMOUNT", "13.00");
        formData.put("TRANSPORTATION2_CURRENCY", "USD");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("TRANSPORTATION3_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION3_TYPE", "PARKING");
        formData.put("TRANSPORTATION3_AMOUNT", "12.00");
        formData.put("TRANSPORTATION3_CURRENCY", "USD");
        formData.put("TRANSPORTATION4_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION4_TYPE", "PARKING");
        formData.put("TRANSPORTATION4_AMOUNT", "22");
        formData.put("TRANSPORTATION4_CURRENCY", "USD");
        formData.put("TRANSPORTATION5_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION5_TYPE", "TOLL");
        formData.put("TRANSPORTATION5_AMOUNT", "1.65");
        formData.put("TRANSPORTATION5_CURRENCY", "USD");
        formData.put("TRANSPORTATION6_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION6_TYPE", "TOLL");
        formData.put("TRANSPORTATION6_AMOUNT", "1.60");
        formData.put("TRANSPORTATION6_CURRENCY", "USD");

        return formData;
    }

    protected Map<String, String> getBasicFormOutput()
    {
        Map<String, String> formData = new HashMap<String, String>();

        formData.put("NAME", "Lincoln, Abraham");
        formData.put("USER_NAME", "linc001");
        formData.put("EMAIL", "linc001@umn.edu");
        formData.put("CITIZENSHIP", "United States");

        // We omit this because we have to check it separately.
        // formData.put("FORM_SUBMISSION_DATETIME",
        // "This one depends on the test");
        formData.put("DEPARTURE_DATETIME",
                TrapDateUtil.printDateTime(departureDate));
        formData.put("ARRIVAL_DATETIME",
                TrapDateUtil.printDateTime(arrivalDate));
        formData.put("PAID_BY_UNIVERSITY", "yes");
        formData.put("EMERGENCY_CONTACT_NAME", "Greg Gay");
        formData.put("EMERGENCY_CONTACT_PHONE", "765-432-1098");
        formData.put("TRAVEL_TYPE_CSE_SPONSORED", "yes");
        formData.put("JUSTIFICATION_CONFERENCE_TITLE",
                "ASE2012: 26th IEEE/ACM International Conference on "
                        + "Automated Software Engineering");
        formData.put("JUSTIFICATION_PRESENTED", "no");
        formData.put("JUSTIFICATION_SPONSORED",
                "Learn about research in the field.");
        formData.put("NUM_DESTINATIONS", "3");
        formData.put("DESTINATION1_CITY", "Des Moines");
        formData.put("DESTINATION1_STATE", "IA");
        formData.put("DESTINATION1_COUNTRY", "USA");
        formData.put("DESTINATION2_CITY", "Kansas City");
        formData.put("DESTINATION2_STATE", "MO");
        formData.put("DESTINATION2_COUNTRY", "USA");
        formData.put("DESTINATION3_CITY", "Lawrence");
        formData.put("DESTINATION3_STATE", "KS");
        formData.put("DESTINATION3_COUNTRY", "USA");
        formData.put("NUM_DAYS", "5");
        GregorianCalendar departureCal = new GregorianCalendar();
        departureCal.setTime(departureDate);
        formData.put("DAY1_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY1_TOTAL", "111.81");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("DAY2_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY2_TOTAL", "109.31");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("DAY3_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY3_TOTAL", "86.31");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("DAY4_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY4_TOTAL", "109.31");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("DAY5_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY5_TOTAL", "17.25");
        formData.put("NUM_TRANSPORTATION", "6");
        departureCal.setTime(departureDate);
        formData.put("TRANSPORTATION1_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION1_TYPE", "PARKING");
        formData.put("TRANSPORTATION1_TOTAL", "12.00");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("TRANSPORTATION2_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION2_TYPE", "PARKING");
        formData.put("TRANSPORTATION2_TOTAL", "13.00");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("TRANSPORTATION3_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION3_TYPE", "PARKING");
        formData.put("TRANSPORTATION3_TOTAL", "12.00");
        formData.put("TRANSPORTATION4_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION4_TYPE", "PARKING");
        formData.put("TRANSPORTATION4_TOTAL", "22.00");
        formData.put("TRANSPORTATION5_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION5_TYPE", "TOLL");
        formData.put("TRANSPORTATION5_TOTAL", "1.65");
        formData.put("TRANSPORTATION6_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION6_TYPE", "TOLL");
        formData.put("TRANSPORTATION6_TOTAL", "1.60");
        formData.put("NUM_OTHER_EXPENSES", "2");
        formData.put("OTHER1_DATE", "20121003");
        formData.put("OTHER1_JUSTIFICATION", "Conference Registration");
        formData.put("OTHER1_TOTAL", "450.00");
        formData.put("OTHER2_DATE", "20121003");
        formData.put("OTHER2_JUSTIFICATION", "Workshop Registration");
        formData.put("OTHER2_TOTAL", "100.00");
        formData.put("NUM_GRANTS", "1");
        formData.put("GRANT1_ACCOUNT", "010101010101");
        formData.put("GRANT1_PERCENT", "100");
        formData.put("GRANT1_AMOUNT_TO_CHARGE", "1046.24");
        formData.put("GRANT1_APPROVER_NAME", "heimd001");
        formData.put("TOTAL_REIMBURSEMENT", "1046.24");

        return formData;

    }
    
    protected Map<String, String> getNoFoodInput()
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
        formData.put("NUM_DAYS", "5");
        formData.put("DAY1_LODGING_CITY", "Lawrence");
        formData.put("DAY1_LODGING_STATE", "KS");
        formData.put("DAY1_LODGING_COUNTRY", "USA");
        formData.put("DAY1_LODGING_AMOUNT", "86.31");
        formData.put("DAY1_LODGING_CURRENCY", "USD");
        formData.put("DAY2_LODGING_CITY", "Lawrence");
        formData.put("DAY2_LODGING_STATE", "KS");
        formData.put("DAY2_LODGING_COUNTRY", "USA");
        formData.put("DAY2_LODGING_AMOUNT", "86.31");
        formData.put("DAY2_LODGING_CURRENCY", "USD");
        formData.put("DAY3_LODGING_CITY", "Lawrence");
        formData.put("DAY3_LODGING_STATE", "KS");
        formData.put("DAY3_LODGING_COUNTRY", "USA");
        formData.put("DAY3_LODGING_AMOUNT", "86.31");
        formData.put("DAY3_LODGING_CURRENCY", "USD");
        formData.put("DAY4_LODGING_CITY", "Lawrence");
        formData.put("DAY4_LODGING_STATE", "KS");
        formData.put("DAY4_LODGING_COUNTRY", "USA");
        formData.put("DAY4_LODGING_AMOUNT", "86.31");
        formData.put("DAY4_LODGING_CURRENCY", "USD");
        formData.put("NUM_TRANSPORTATION", "6");
        GregorianCalendar departureCal = new GregorianCalendar();
        departureCal.setTime(departureDate);
        formData.put("TRANSPORTATION1_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION1_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION1_AMOUNT", "12.00");
        formData.put("TRANSPORTATION1_CURRENCY", "USD");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("TRANSPORTATION2_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION2_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION2_AMOUNT", "13.00");
        formData.put("TRANSPORTATION2_CURRENCY", "USD");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("TRANSPORTATION3_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION3_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION3_AMOUNT", "12.00");
        formData.put("TRANSPORTATION3_CURRENCY", "USD");
        formData.put("TRANSPORTATION4_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION4_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION4_AMOUNT", "22");
        formData.put("TRANSPORTATION4_CURRENCY", "USD");
        formData.put("TRANSPORTATION5_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION5_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION5_AMOUNT", "1.65");
        formData.put("TRANSPORTATION5_CURRENCY", "USD");
        formData.put("TRANSPORTATION6_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION6_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION6_AMOUNT", "1.60");
        formData.put("TRANSPORTATION6_CURRENCY", "USD");

        return formData;
    }

    protected Map<String, String> getNoFoodOutput()
    {
        Map<String, String> formData = new HashMap<String, String>();

        formData.put("NAME", "Lincoln, Abraham");
        formData.put("USER_NAME", "linc001");
        formData.put("EMAIL", "linc001@umn.edu");
        formData.put("CITIZENSHIP", "United States");

        // We omit this because we have to check it separately.
        // formData.put("FORM_SUBMISSION_DATETIME",
        // "This one depends on the test");
        formData.put("DEPARTURE_DATETIME",
                TrapDateUtil.printDateTime(departureDate));
        formData.put("ARRIVAL_DATETIME",
                TrapDateUtil.printDateTime(arrivalDate));
        formData.put("PAID_BY_UNIVERSITY", "yes");
        formData.put("EMERGENCY_CONTACT_NAME", "Greg Gay");
        formData.put("EMERGENCY_CONTACT_PHONE", "765-432-1098");
        formData.put("TRAVEL_TYPE_CSE_SPONSORED", "yes");
        formData.put("JUSTIFICATION_CONFERENCE_TITLE",
                "ASE2012: 26th IEEE/ACM International Conference on "
                        + "Automated Software Engineering");
        formData.put("JUSTIFICATION_PRESENTED", "no");
        formData.put("JUSTIFICATION_SPONSORED",
                "Learn about research in the field.");
        formData.put("NUM_DESTINATIONS", "1");
        formData.put("DESTINATION1_CITY", "Lawrence");
        formData.put("DESTINATION1_STATE", "KS");
        formData.put("DESTINATION1_COUNTRY", "USA");
        formData.put("NUM_DAYS", "5");
        GregorianCalendar departureCal = new GregorianCalendar();
        departureCal.setTime(departureDate);
        formData.put("DAY1_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY1_TOTAL", "86.31");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("DAY2_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY2_TOTAL", "86.31");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("DAY3_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY3_TOTAL", "86.31");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("DAY4_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY4_TOTAL", "86.31");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("DAY5_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("NUM_TRANSPORTATION", "6");
        departureCal.setTime(departureDate);
        formData.put("TRANSPORTATION1_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION1_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION1_TOTAL", "12.00");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("TRANSPORTATION2_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION2_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION2_TOTAL", "13.00");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("TRANSPORTATION3_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION3_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION3_TOTAL", "12.00");
        formData.put("TRANSPORTATION4_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION4_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION4_TOTAL", "22.00");
        formData.put("TRANSPORTATION5_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION5_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION5_TOTAL", "1.65");
        formData.put("TRANSPORTATION6_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION6_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION6_TOTAL", "1.60");
        formData.put("NUM_OTHER_EXPENSES", "2");
        formData.put("OTHER1_DATE", "20121003");
        formData.put("OTHER1_JUSTIFICATION", "Conference Registration");
        formData.put("OTHER1_TOTAL", "450.00");
        formData.put("OTHER2_DATE", "20121003");
        formData.put("OTHER2_JUSTIFICATION", "Workshop Registration");
        formData.put("OTHER2_TOTAL", "100.00");
        formData.put("NUM_GRANTS", "1");
        formData.put("GRANT1_ACCOUNT", "010101010101");
        formData.put("GRANT1_PERCENT", "100");
        formData.put("GRANT1_AMOUNT_TO_CHARGE", "957.49");
        formData.put("GRANT1_APPROVER_NAME", "heimd001");
        formData.put("TOTAL_REIMBURSEMENT", "957.49");

        return formData;

    }
    
    protected Map<String, String> getForeignAndDomesticTravelInput()
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
        formData.put("NUM_GRANTS", "2");
        formData.put("GRANT1_ACCOUNT", "010101010101");
        formData.put("GRANT1_PERCENT", "75");
        formData.put("GRANT2_ACCOUNT", "777555111");
        formData.put("GRANT2_PERCENT", "25");
        formData.put("NUM_OTHER_EXPENSES", "2");
        formData.put("OTHER1_DATE", "20121003");
        formData.put("OTHER1_JUSTIFICATION", "Conference Registration");
        formData.put("OTHER1_AMOUNT", "450.00");
        formData.put("OTHER1_CURRENCY", "USD");
        formData.put("OTHER2_DATE", "20121003");
        formData.put("OTHER2_JUSTIFICATION", "Workshop Registration");
        formData.put("OTHER2_AMOUNT", "100");
        formData.put("OTHER2_CURRENCY", "USD");
        formData.put("NUM_DAYS", "5");
        formData.put("DAY1_LODGING_CITY", "Lawrence");
        formData.put("DAY1_LODGING_STATE", "KS");
        formData.put("DAY1_LODGING_COUNTRY", "USA");
        formData.put("DAY1_LODGING_AMOUNT", "86.31");
        formData.put("DAY1_LODGING_CURRENCY", "USD");
        formData.put("DAY2_LODGING_CITY", "Lawrence");
        formData.put("DAY2_LODGING_STATE", "KS");
        formData.put("DAY2_LODGING_COUNTRY", "USA");
        formData.put("DAY2_LODGING_AMOUNT", "86.31");
        formData.put("DAY2_LODGING_CURRENCY", "USD");
        formData.put("DAY3_LODGING_CITY", "Lawrence");
        formData.put("DAY3_LODGING_STATE", "KS");
        formData.put("DAY3_LODGING_COUNTRY", "USA");
        formData.put("DAY3_LODGING_AMOUNT", "86.31");
        formData.put("DAY3_LODGING_CURRENCY", "USD");
        formData.put("DAY4_LODGING_CITY", "Zurich");
        formData.put("DAY4_LODGING_COUNTRY", "Switzerland");
        formData.put("DAY4_LODGING_AMOUNT", "86.31");
        formData.put("DAY4_LODGING_CURRENCY", "USD");
        formData.put("NUM_TRANSPORTATION", "6");
        GregorianCalendar departureCal = new GregorianCalendar();
        departureCal.setTime(departureDate);
        formData.put("TRANSPORTATION1_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION1_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION1_AMOUNT", "12.00");
        formData.put("TRANSPORTATION1_CURRENCY", "USD");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("TRANSPORTATION2_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION2_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION2_AMOUNT", "13.00");
        formData.put("TRANSPORTATION2_CURRENCY", "USD");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("TRANSPORTATION3_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION3_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION3_AMOUNT", "12.00");
        formData.put("TRANSPORTATION3_CURRENCY", "USD");
        formData.put("TRANSPORTATION4_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION4_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION4_AMOUNT", "22");
        formData.put("TRANSPORTATION4_CURRENCY", "USD");
        formData.put("TRANSPORTATION5_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION5_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION5_AMOUNT", "1.65");
        formData.put("TRANSPORTATION5_CURRENCY", "USD");
        formData.put("TRANSPORTATION6_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION6_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION6_AMOUNT", "1.60");
        formData.put("TRANSPORTATION6_CURRENCY", "USD");

        return formData;
    }

    protected Map<String, String> getForeignAndDomesticTravelOutput()
    {
        Map<String, String> formData = new HashMap<String, String>();

        formData.put("NAME", "Lincoln, Abraham");
        formData.put("USER_NAME", "linc001");
        formData.put("EMAIL", "linc001@umn.edu");
        formData.put("CITIZENSHIP", "United States");

        // We omit this because we have to check it separately.
        // formData.put("FORM_SUBMISSION_DATETIME",
        // "This one depends on the test");
        formData.put("DEPARTURE_DATETIME",
                TrapDateUtil.printDateTime(departureDate));
        formData.put("ARRIVAL_DATETIME",
                TrapDateUtil.printDateTime(arrivalDate));
        formData.put("PAID_BY_UNIVERSITY", "yes");
        formData.put("EMERGENCY_CONTACT_NAME", "Greg Gay");
        formData.put("EMERGENCY_CONTACT_PHONE", "765-432-1098");
        formData.put("TRAVEL_TYPE_CSE_SPONSORED", "yes");
        formData.put("JUSTIFICATION_CONFERENCE_TITLE",
                "ASE2012: 26th IEEE/ACM International Conference on "
                        + "Automated Software Engineering");
        formData.put("JUSTIFICATION_PRESENTED", "no");
        formData.put("JUSTIFICATION_SPONSORED",
                "Learn about research in the field.");
        formData.put("NUM_DESTINATIONS", "2");        
        formData.put("DESTINATION1_CITY", "Zurich");
        formData.put("DESTINATION1_COUNTRY", "Switzerland");
        formData.put("DESTINATION2_CITY", "Lawrence");
        formData.put("DESTINATION2_STATE", "KS");
        formData.put("DESTINATION2_COUNTRY", "USA");
        formData.put("NUM_DAYS", "5");
        GregorianCalendar departureCal = new GregorianCalendar();
        departureCal.setTime(departureDate);
        formData.put("DAY1_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY1_TOTAL", "86.31");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("DAY2_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY2_TOTAL", "86.31");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("DAY3_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY3_TOTAL", "86.31");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("DAY4_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY4_TOTAL", "86.31");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("DAY5_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("NUM_TRANSPORTATION", "6");
        departureCal.setTime(departureDate);
        formData.put("TRANSPORTATION1_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION1_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION1_TOTAL", "12.00");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("TRANSPORTATION2_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION2_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION2_TOTAL", "13.00");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("TRANSPORTATION3_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION3_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION3_TOTAL", "12.00");
        formData.put("TRANSPORTATION4_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION4_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION4_TOTAL", "22.00");
        formData.put("TRANSPORTATION5_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION5_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION5_TOTAL", "1.65");
        formData.put("TRANSPORTATION6_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION6_TYPE", "PUBLIC_TRANSPORTATION");
        formData.put("TRANSPORTATION6_TOTAL", "1.60");
        formData.put("NUM_OTHER_EXPENSES", "2");
        formData.put("OTHER1_DATE", "20121003");
        formData.put("OTHER1_JUSTIFICATION", "Conference Registration");
        formData.put("OTHER1_TOTAL", "450.00");
        formData.put("OTHER2_DATE", "20121003");
        formData.put("OTHER2_JUSTIFICATION", "Workshop Registration");
        formData.put("OTHER2_TOTAL", "100.00");
        formData.put("NUM_GRANTS", "2");
        formData.put("GRANT1_ACCOUNT", "010101010101");
        formData.put("GRANT1_PERCENT", "75");
        formData.put("GRANT1_AMOUNT_TO_CHARGE", "718.12");
        formData.put("GRANT1_APPROVER_NAME", "heimd001");
        formData.put("GRANT2_ACCOUNT", "777555111");
        formData.put("GRANT2_PERCENT", "25");
        formData.put("GRANT2_AMOUNT_TO_CHARGE", "239.37");
        formData.put("GRANT2_APPROVER_NAME", "heimd001");
        formData.put("TOTAL_REIMBURSEMENT", "957.49");

        return formData;

    }
    
    protected Map<String, String> getIncidentalInput()
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
        formData.put("NUM_DAYS", "5");
        formData.put("DAY1_LUNCH_CITY", "Des Moines");
        formData.put("DAY1_LUNCH_STATE", "IA");
        formData.put("DAY1_LUNCH_COUNTRY", "USA");
        formData.put("DAY1_DINNER_CITY", "Kansas City");
        formData.put("DAY1_DINNER_STATE", "MO");
        formData.put("DAY1_DINNER_COUNTRY", "USA");
        formData.put("DAY1_INCIDENTAL_CITY", "Des Moines");
        formData.put("DAY1_INCIDENTAL_STATE", "IA");
        formData.put("DAY1_INCIDENTAL_COUNTRY", "USA");
        formData.put("DAY1_INCIDENTAL_AMOUNT", "7.00");
        formData.put("DAY1_INCIDENTAL_CURRENCY", "USD");
        formData.put("DAY1_INCIDENTAL_JUSTIFICATION", "desc");        
        formData.put("DAY1_LODGING_CITY", "Lawrence");
        formData.put("DAY1_LODGING_STATE", "KS");
        formData.put("DAY1_LODGING_COUNTRY", "USA");
        formData.put("DAY1_LODGING_AMOUNT", "86.31");
        formData.put("DAY1_LODGING_CURRENCY", "USD");
        formData.put("DAY2_DINNER_CITY", "Lawrence");
        formData.put("DAY2_DINNER_STATE", "KS");
        formData.put("DAY2_DINNER_COUNTRY", "USA");
        formData.put("DAY2_LODGING_CITY", "Lawrence");
        formData.put("DAY2_LODGING_STATE", "KS");
        formData.put("DAY2_LODGING_COUNTRY", "USA");
        formData.put("DAY2_LODGING_AMOUNT", "86.31");
        formData.put("DAY2_LODGING_CURRENCY", "USD");
        formData.put("DAY3_LODGING_CITY", "Lawrence");
        formData.put("DAY3_LODGING_STATE", "KS");
        formData.put("DAY3_LODGING_COUNTRY", "USA");
        formData.put("DAY3_LODGING_AMOUNT", "86.31");
        formData.put("DAY3_LODGING_CURRENCY", "USD");
        formData.put("DAY4_DINNER_CITY", "Lawrence");
        formData.put("DAY4_DINNER_STATE", "KS");
        formData.put("DAY4_DINNER_COUNTRY", "USA");
        formData.put("DAY4_LODGING_CITY", "Lawrence");
        formData.put("DAY4_LODGING_STATE", "KS");
        formData.put("DAY4_LODGING_COUNTRY", "USA");
        formData.put("DAY4_LODGING_AMOUNT", "86.31");
        formData.put("DAY4_LODGING_CURRENCY", "USD");
        formData.put("DAY5_DINNER_CITY", "Des Moines");
        formData.put("DAY5_DINNER_STATE", "IA");
        formData.put("DAY5_DINNER_COUNTRY", "USA");
        formData.put("NUM_TRANSPORTATION", "6");
        GregorianCalendar departureCal = new GregorianCalendar();
        departureCal.setTime(departureDate);
        formData.put("TRANSPORTATION1_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION1_TYPE", "PARKING");
        formData.put("TRANSPORTATION1_AMOUNT", "12.00");
        formData.put("TRANSPORTATION1_CURRENCY", "USD");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("TRANSPORTATION2_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION2_TYPE", "PARKING");
        formData.put("TRANSPORTATION2_AMOUNT", "13.00");
        formData.put("TRANSPORTATION2_CURRENCY", "USD");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("TRANSPORTATION3_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION3_TYPE", "PARKING");
        formData.put("TRANSPORTATION3_AMOUNT", "12.00");
        formData.put("TRANSPORTATION3_CURRENCY", "USD");
        formData.put("TRANSPORTATION4_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION4_TYPE", "PARKING");
        formData.put("TRANSPORTATION4_AMOUNT", "22");
        formData.put("TRANSPORTATION4_CURRENCY", "USD");
        formData.put("TRANSPORTATION5_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION5_TYPE", "TOLL");
        formData.put("TRANSPORTATION5_AMOUNT", "1.65");
        formData.put("TRANSPORTATION5_CURRENCY", "USD");
        formData.put("TRANSPORTATION6_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION6_TYPE", "TOLL");
        formData.put("TRANSPORTATION6_AMOUNT", "1.60");
        formData.put("TRANSPORTATION6_CURRENCY", "USD");

        return formData;
    }

    protected Map<String, String> getIncidentalOutput()
    {
        Map<String, String> formData = new HashMap<String, String>();

        formData.put("NAME", "Lincoln, Abraham");
        formData.put("USER_NAME", "linc001");
        formData.put("EMAIL", "linc001@umn.edu");
        formData.put("CITIZENSHIP", "United States");

        // We omit this because we have to check it separately.
        // formData.put("FORM_SUBMISSION_DATETIME",
        // "This one depends on the test");
        formData.put("DEPARTURE_DATETIME",
                TrapDateUtil.printDateTime(departureDate));
        formData.put("ARRIVAL_DATETIME",
                TrapDateUtil.printDateTime(arrivalDate));
        formData.put("PAID_BY_UNIVERSITY", "yes");
        formData.put("EMERGENCY_CONTACT_NAME", "Greg Gay");
        formData.put("EMERGENCY_CONTACT_PHONE", "765-432-1098");
        formData.put("TRAVEL_TYPE_CSE_SPONSORED", "yes");
        formData.put("JUSTIFICATION_CONFERENCE_TITLE",
                "ASE2012: 26th IEEE/ACM International Conference on "
                        + "Automated Software Engineering");
        formData.put("JUSTIFICATION_PRESENTED", "no");
        formData.put("JUSTIFICATION_SPONSORED",
                "Learn about research in the field.");
        formData.put("NUM_DESTINATIONS", "3");
        formData.put("DESTINATION1_CITY", "Des Moines");
        formData.put("DESTINATION1_STATE", "IA");
        formData.put("DESTINATION1_COUNTRY", "USA");
        formData.put("DESTINATION2_CITY", "Kansas City");
        formData.put("DESTINATION2_STATE", "MO");
        formData.put("DESTINATION2_COUNTRY", "USA");
        formData.put("DESTINATION3_CITY", "Lawrence");
        formData.put("DESTINATION3_STATE", "KS");
        formData.put("DESTINATION3_COUNTRY", "USA");
        formData.put("NUM_DAYS", "5");
        GregorianCalendar departureCal = new GregorianCalendar();
        departureCal.setTime(departureDate);
        formData.put("DAY1_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY1_TOTAL", "116.81");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("DAY1_INCIDENTAL_TOTAL", "4.00");
        formData.put("DAY1_INCIDENTAL_JUSTIFICATION", "desc");
        formData.put("DAY2_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY2_TOTAL", "109.31");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("DAY3_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY3_TOTAL", "86.31");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("DAY4_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY4_TOTAL", "109.31");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("DAY5_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("DAY5_TOTAL", "17.25");
        formData.put("NUM_TRANSPORTATION", "6");
        departureCal.setTime(departureDate);
        formData.put("TRANSPORTATION1_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION1_TYPE", "PARKING");
        formData.put("TRANSPORTATION1_TOTAL", "12.00");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("TRANSPORTATION2_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION2_TYPE", "PARKING");
        formData.put("TRANSPORTATION2_TOTAL", "13.00");
        departureCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        formData.put("TRANSPORTATION3_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION3_TYPE", "PARKING");
        formData.put("TRANSPORTATION3_TOTAL", "12.00");
        formData.put("TRANSPORTATION4_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION4_TYPE", "PARKING");
        formData.put("TRANSPORTATION4_TOTAL", "22.00");
        formData.put("TRANSPORTATION5_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION5_TYPE", "TOLL");
        formData.put("TRANSPORTATION5_TOTAL", "1.65");
        formData.put("TRANSPORTATION6_DATE",
                TrapDateUtil.printDate(departureCal.getTime()));
        formData.put("TRANSPORTATION6_TYPE", "TOLL");
        formData.put("TRANSPORTATION6_TOTAL", "1.60");
        formData.put("NUM_OTHER_EXPENSES", "2");
        formData.put("OTHER1_DATE", "20121003");
        formData.put("OTHER1_JUSTIFICATION", "Conference Registration");
        formData.put("OTHER1_TOTAL", "450.00");
        formData.put("OTHER2_DATE", "20121003");
        formData.put("OTHER2_JUSTIFICATION", "Workshop Registration");
        formData.put("OTHER2_TOTAL", "100.00");
        formData.put("NUM_GRANTS", "1");
        formData.put("GRANT1_ACCOUNT", "010101010101");
        formData.put("GRANT1_PERCENT", "100");
        formData.put("GRANT1_AMOUNT_TO_CHARGE", "1051.24");
        formData.put("GRANT1_APPROVER_NAME", "heimd001");
        formData.put("TOTAL_REIMBURSEMENT", "1051.24");

        return formData;

    }

}
