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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.umn.se.trap.form.Expense;
import edu.umn.se.trap.form.ExpenseType;
import edu.umn.se.trap.form.FormGrant;
import edu.umn.se.trap.form.GrantSet;
import edu.umn.se.trap.form.Location;
import edu.umn.se.trap.form.TransportationExpense;
import edu.umn.se.trap.form.Trip;

/**
 * @author nick
 * 
 */
public class TrapTestUtil
{
    public static Map<String, String> getSampleInput1()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("USER_NAME", "linc001");
        map.put("ARRIVAL_DATETIME", "20121112 235900");
        map.put("DEPARTURE_DATETIME", "20121108 100000");
        map.put("TRAVEL_TYPE_CSE_SPONSORED", "yes");
        map.put("EMERGENCY_CONTACT_NAME", "Greg Gay");
        map.put("EMERGENCY_CONTACT_PHONE", "765-432-1098");
        map.put("JUSTIFICATION_CONFERENCE_TITLE",
                "SE2012: 26th IEEE/ACM International Conference on Automated Software Engineering");
        map.put("JUSTIFICATION_PRESENTED", "no");
        map.put("JUSTIFICATION_SPONSORED", "Learn about research in the field.");
        map.put("NUM_GRANTS", "1");
        map.put("GRANT1_ACCOUNT", "010101010101");
        map.put("GRANT1_PERCENT", "100");
        map.put("NUM_OTHER_EXPENSES", "2");
        map.put("OTHER1_DATE", "20121003");
        map.put("OTHER1_JUSTIFICATION", "Conference Registration");
        map.put("OTHER1_AMOUNT", "450");
        map.put("OTHER1_CURRENCY", "USD");
        map.put("OTHER2_DATE", "20121003");
        map.put("OTHER2_JUSTIFICATION", "Workshop Registration");
        map.put("OTHER2_AMOUNT", "100");
        map.put("OTHER2_CURRENCY", "USD");
        map.put("NUM_DAYS", "5");
        map.put("DAY1_LUNCH_CITY", "Des Moines");
        map.put("DAY1_LUNCH_STATE", "IA");
        map.put("DAY1_LUNCH_COUNTRY", "USA");
        map.put("DAY1_DINNER_CITY", "Kansas City");
        map.put("DAY1_DINNER_STATE", "MO");
        map.put("DAY1_DINNER_COUNTRY", "USA");
        map.put("DAY1_LODGING_CITY", "Lawrence");
        map.put("DAY1_LODGING_STATE", "KS");
        map.put("DAY1_LODGING_COUNTRY", "USA");
        map.put("DAY1_LODGING_AMOUNT", "86.31");
        map.put("DAY1_LODGING_CURRENCY", "USD");
        map.put("DAY2_DINNER_CITY", "Lawrence");
        map.put("DAY2_DINNER_STATE", "KS");
        map.put("DAY2_DINNER_COUNTRY", "USA");
        map.put("DAY2_LODGING_CITY", "Lawrence");
        map.put("DAY2_LODGING_STATE", "KS");
        map.put("DAY2_LODGING_COUNTRY", "USA");
        map.put("DAY2_LODGING_AMOUNT", "86.31");
        map.put("DAY2_LODGING_CURRENCY", "USD");
        map.put("DAY3_LODGING_CITY", "Lawrence");
        map.put("DAY3_LODGING_STATE", "KS");
        map.put("DAY3_LODGING_COUNTRY", "USA");
        map.put("DAY3_LODGING_AMOUNT", "86.31");
        map.put("DAY3_LODGING_CURRENCY", "USD");
        map.put("DAY4_DINNER_CITY", "Lawrence");
        map.put("DAY4_DINNER_STATE", "KS");
        map.put("DAY4_DINNER_COUNTRY", "USA");
        map.put("DAY4_LODGING_CITY", "Lawrence");
        map.put("DAY4_LODGING_STATE", "KS");
        map.put("DAY4_LODGING_COUNTRY", "USA");
        map.put("DAY4_LODGING_AMOUNT", "86.31");
        map.put("DAY4_LODGING_CURRENCY", "USD");
        map.put("DAY5_DINNER_CITY", "Des Moines");
        map.put("DAY5_DINNER_STATE", "IA");
        map.put("DAY5_DINNER_COUNTRY", "USA");
        map.put("NUM_TRANSPORTATION", "6");
        map.put("TRANSPORTATION1_DATE", "20121108");
        map.put("TRANSPORTATION1_TYPE", "PARKING");
        map.put("TRANSPORTATION1_AMOUNT", "12.00");
        map.put("TRANSPORTATION1_CURRENCY", "USD");
        map.put("TRANSPORTATION2_DATE", "20121109");
        map.put("TRANSPORTATION2_TYPE", "PARKING");
        map.put("TRANSPORTATION2_AMOUNT", "13.00");
        map.put("TRANSPORTATION2_CURRENCY", "USD");
        map.put("TRANSPORTATION3_DATE", "20121110");
        map.put("TRANSPORTATION3_TYPE", "PARKING");
        map.put("TRANSPORTATION3_AMOUNT", "12.00");
        map.put("TRANSPORTATION3_CURRENCY", "USD");
        map.put("TRANSPORTATION4_DATE", "20121110");
        map.put("TRANSPORTATION4_TYPE", "PARKING");
        map.put("TRANSPORTATION4_AMOUNT", "22");
        map.put("TRANSPORTATION4_CURRENCY", "USD");
        map.put("TRANSPORTATION5_DATE", "20121110");
        map.put("TRANSPORTATION5_TYPE", "TOLL");
        map.put("TRANSPORTATION5_AMOUNT", "1.65");
        map.put("TRANSPORTATION5_CURRENCY", "USD");
        map.put("TRANSPORTATION6_DATE", "20121110");
        map.put("TRANSPORTATION6_TYPE", "TOLL");
        map.put("TRANSPORTATION6_AMOUNT", "1.60");
        map.put("TRANSPORTATION6_CURRENCY", "USD");
        return map;
    }

    public static Map<String, String> getSampleInputMissingJustification()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("USER_NAME", "linc001");
        map.put("ARRIVAL_DATETIME", "20121112 235900");
        map.put("DEPARTURE_DATETIME", "20121108 100000");
        map.put("TRAVEL_TYPE_CSE_SPONSORED", "yes");
        map.put("EMERGENCY_CONTACT_NAME", "Greg Gay");
        map.put("EMERGENCY_CONTACT_PHONE", "765-432-1098");
        map.put("JUSTIFICATION_CONFERENCE_TITLE",
                "SE2012: 26th IEEE/ACM International Conference on Automated Software Engineering");
        map.put("JUSTIFICATION_PRESENTED", "no");

        /*
         * Removed input:
         */

        // map.put("JUSTIFICATION_SPONSORED",
        // "Learn about research in the field.");

        map.put("NUM_GRANTS", "1");
        map.put("GRANT1_ACCOUNT", "010101010101");
        map.put("GRANT1_PERCENT", "100");
        map.put("NUM_OTHER_EXPENSES", "2");
        map.put("OTHER1_DATE", "20121003");
        map.put("OTHER1_JUSTIFICATION", "Conference Registration");
        map.put("OTHER1_AMOUNT", "450");
        map.put("OTHER1_CURRENCY", "USD");
        map.put("OTHER2_DATE", "20121003");
        map.put("OTHER2_JUSTIFICATION", "Workshop Registration");
        map.put("OTHER2_AMOUNT", "100");
        map.put("OTHER2_CURRENCY", "USD");
        map.put("NUM_DAYS", "5");
        map.put("DAY1_LUNCH_CITY", "Des Moines");
        map.put("DAY1_LUNCH_STATE", "IA");
        map.put("DAY1_LUNCH_COUNTRY", "USA");
        map.put("DAY1_DINNER_CITY", "Kansas City");
        map.put("DAY1_DINNER_STATE", "MO");
        map.put("DAY1_DINNER_COUNTRY", "USA");
        map.put("DAY1_LODGING_CITY", "Lawrence");
        map.put("DAY1_LODGING_STATE", "KS");
        map.put("DAY1_LODGING_COUNTRY", "USA");
        map.put("DAY1_LODGING_AMOUNT", "86.31");
        map.put("DAY1_LODGING_CURRENCY", "USD");
        map.put("DAY2_DINNER_CITY", "Lawrence");
        map.put("DAY2_DINNER_STATE", "KS");
        map.put("DAY2_DINNER_COUNTRY", "USA");
        map.put("DAY2_LODGING_CITY", "Lawrence");
        map.put("DAY2_LODGING_STATE", "KS");
        map.put("DAY2_LODGING_COUNTRY", "USA");
        map.put("DAY2_LODGING_AMOUNT", "86.31");
        map.put("DAY2_LODGING_CURRENCY", "USD");
        map.put("DAY3_LODGING_CITY", "Lawrence");
        map.put("DAY3_LODGING_STATE", "KS");
        map.put("DAY3_LODGING_COUNTRY", "USA");
        map.put("DAY3_LODGING_AMOUNT", "86.31");
        map.put("DAY3_LODGING_CURRENCY", "USD");
        map.put("DAY4_DINNER_CITY", "Lawrence");
        map.put("DAY4_DINNER_STATE", "KS");
        map.put("DAY4_DINNER_COUNTRY", "USA");
        map.put("DAY4_LODGING_CITY", "Lawrence");
        map.put("DAY4_LODGING_STATE", "KS");
        map.put("DAY4_LODGING_COUNTRY", "USA");
        map.put("DAY4_LODGING_AMOUNT", "86.31");
        map.put("DAY4_LODGING_CURRENCY", "USD");
        map.put("DAY5_DINNER_CITY", "Des Moines");
        map.put("DAY5_DINNER_STATE", "IA");
        map.put("DAY5_DINNER_COUNTRY", "USA");
        map.put("NUM_TRANSPORTATION", "6");
        map.put("TRANSPORTATION1_DATE", "20121108");
        map.put("TRANSPORTATION1_TYPE", "PARKING");
        map.put("TRANSPORTATION1_AMOUNT", "12.00");
        map.put("TRANSPORTATION1_CURRENCY", "USD");
        map.put("TRANSPORTATION2_DATE", "20121109");
        map.put("TRANSPORTATION2_TYPE", "PARKING");
        map.put("TRANSPORTATION2_AMOUNT", "13.00");
        map.put("TRANSPORTATION2_CURRENCY", "USD");
        map.put("TRANSPORTATION3_DATE", "20121110");
        map.put("TRANSPORTATION3_TYPE", "PARKING");
        map.put("TRANSPORTATION3_AMOUNT", "12.00");
        map.put("TRANSPORTATION3_CURRENCY", "USD");
        map.put("TRANSPORTATION4_DATE", "20121110");
        map.put("TRANSPORTATION4_TYPE", "PARKING");
        map.put("TRANSPORTATION4_AMOUNT", "22");
        map.put("TRANSPORTATION4_CURRENCY", "USD");
        map.put("TRANSPORTATION5_DATE", "20121110");
        map.put("TRANSPORTATION5_TYPE", "TOLL");
        map.put("TRANSPORTATION5_AMOUNT", "1.65");
        map.put("TRANSPORTATION5_CURRENCY", "USD");
        map.put("TRANSPORTATION6_DATE", "20121110");
        map.put("TRANSPORTATION6_TYPE", "TOLL");
        map.put("TRANSPORTATION6_AMOUNT", "1.60");
        map.put("TRANSPORTATION6_CURRENCY", "USD");
        return map;
    }

    public static Map<String, String> getSampleInputMissingExpenseLocation(
            String city, String state, String country)
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("USER_NAME", "linc001");
        map.put("ARRIVAL_DATETIME", "20121112 235900");
        map.put("DEPARTURE_DATETIME", "20121108 100000");
        map.put("TRAVEL_TYPE_CSE_SPONSORED", "yes");
        map.put("EMERGENCY_CONTACT_NAME", "Greg Gay");
        map.put("EMERGENCY_CONTACT_PHONE", "765-432-1098");
        map.put("JUSTIFICATION_CONFERENCE_TITLE",
                "SE2012: 26th IEEE/ACM International Conference on Automated Software Engineering");
        map.put("JUSTIFICATION_PRESENTED", "no");
        map.put("JUSTIFICATION_SPONSORED", "Learn about research in the field.");
        map.put("NUM_GRANTS", "1");
        map.put("GRANT1_ACCOUNT", "010101010101");
        map.put("GRANT1_PERCENT", "100");
        map.put("NUM_OTHER_EXPENSES", "2");
        map.put("OTHER1_DATE", "20121003");
        map.put("OTHER1_JUSTIFICATION", "Conference Registration");
        map.put("OTHER1_AMOUNT", "450");
        map.put("OTHER1_CURRENCY", "USD");
        map.put("OTHER2_DATE", "20121003");
        map.put("OTHER2_JUSTIFICATION", "Workshop Registration");
        map.put("OTHER2_AMOUNT", "100");
        map.put("OTHER2_CURRENCY", "USD");
        map.put("NUM_DAYS", "5");
        map.put("DAY1_LUNCH_CITY", "Des Moines");
        map.put("DAY1_LUNCH_STATE", "IA");
        map.put("DAY1_LUNCH_COUNTRY", "USA");

        /*
         * Input under test:
         */
        map.put("DAY1_DINNER_STATE", state); // MO
        map.put("DAY1_DINNER_CITY", city); // Kansas City
        map.put("DAY1_DINNER_COUNTRY", country); // USA

        map.put("DAY1_LODGING_CITY", "Lawrence");
        map.put("DAY1_LODGING_STATE", "KS");
        map.put("DAY1_LODGING_COUNTRY", "USA");
        map.put("DAY1_LODGING_AMOUNT", "86.31");
        map.put("DAY1_LODGING_CURRENCY", "USD");
        map.put("DAY2_DINNER_CITY", "Lawrence");
        map.put("DAY2_DINNER_STATE", "KS");
        map.put("DAY2_DINNER_COUNTRY", "USA");
        map.put("DAY2_LODGING_CITY", "Lawrence");
        map.put("DAY2_LODGING_STATE", "KS");
        map.put("DAY2_LODGING_COUNTRY", "USA");
        map.put("DAY2_LODGING_AMOUNT", "86.31");
        map.put("DAY2_LODGING_CURRENCY", "USD");
        map.put("DAY3_LODGING_CITY", "Lawrence");
        map.put("DAY3_LODGING_STATE", "KS");
        map.put("DAY3_LODGING_COUNTRY", "USA");
        map.put("DAY3_LODGING_AMOUNT", "86.31");
        map.put("DAY3_LODGING_CURRENCY", "USD");
        map.put("DAY4_DINNER_CITY", "Lawrence");
        map.put("DAY4_DINNER_STATE", "KS");
        map.put("DAY4_DINNER_COUNTRY", "USA");
        map.put("DAY4_LODGING_CITY", "Lawrence");
        map.put("DAY4_LODGING_STATE", "KS");
        map.put("DAY4_LODGING_COUNTRY", "USA");
        map.put("DAY4_LODGING_AMOUNT", "86.31");
        map.put("DAY4_LODGING_CURRENCY", "USD");
        map.put("DAY5_DINNER_CITY", "Des Moines");
        map.put("DAY5_DINNER_STATE", "IA");
        map.put("DAY5_DINNER_COUNTRY", "USA");
        map.put("NUM_TRANSPORTATION", "6");
        map.put("TRANSPORTATION1_DATE", "20121108");
        map.put("TRANSPORTATION1_TYPE", "PARKING");
        map.put("TRANSPORTATION1_AMOUNT", "12.00");
        map.put("TRANSPORTATION1_CURRENCY", "USD");
        map.put("TRANSPORTATION2_DATE", "20121109");
        map.put("TRANSPORTATION2_TYPE", "PARKING");
        map.put("TRANSPORTATION2_AMOUNT", "13.00");
        map.put("TRANSPORTATION2_CURRENCY", "USD");
        map.put("TRANSPORTATION3_DATE", "20121110");
        map.put("TRANSPORTATION3_TYPE", "PARKING");
        map.put("TRANSPORTATION3_AMOUNT", "12.00");
        map.put("TRANSPORTATION3_CURRENCY", "USD");
        map.put("TRANSPORTATION4_DATE", "20121110");
        map.put("TRANSPORTATION4_TYPE", "PARKING");
        map.put("TRANSPORTATION4_AMOUNT", "22");
        map.put("TRANSPORTATION4_CURRENCY", "USD");
        map.put("TRANSPORTATION5_DATE", "20121110");
        map.put("TRANSPORTATION5_TYPE", "TOLL");
        map.put("TRANSPORTATION5_AMOUNT", "1.65");
        map.put("TRANSPORTATION5_CURRENCY", "USD");
        map.put("TRANSPORTATION6_DATE", "20121110");
        map.put("TRANSPORTATION6_TYPE", "TOLL");
        map.put("TRANSPORTATION6_AMOUNT", "1.60");
        map.put("TRANSPORTATION6_CURRENCY", "USD");
        return map;
    }

    public static Map<String, String> getSampleInputNoSponsorship()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("USER_NAME", "linc001");
        map.put("ARRIVAL_DATETIME", "20121112 235900");
        map.put("DEPARTURE_DATETIME", "20121108 100000");
        map.put("TRAVEL_TYPE_CSE_SPONSORED", "no");
        map.put("EMERGENCY_CONTACT_NAME", "Greg Gay");
        map.put("EMERGENCY_CONTACT_PHONE", "765-432-1098");
        map.put("JUSTIFICATION_CONFERENCE_TITLE",
                "SE2012: 26th IEEE/ACM International Conference on Automated Software Engineering");
        map.put("JUSTIFICATION_PRESENTED", "no");
        map.put("JUSTIFICATION_SPONSORED", "Learn about research in the field.");
        map.put("NUM_GRANTS", "1");
        map.put("GRANT1_ACCOUNT", "010101010101");
        map.put("GRANT1_PERCENT", "100");
        map.put("NUM_OTHER_EXPENSES", "2");
        map.put("OTHER1_DATE", "20121003");
        map.put("OTHER1_JUSTIFICATION", "Conference Registration");
        map.put("OTHER1_AMOUNT", "450");
        map.put("OTHER1_CURRENCY", "USD");
        map.put("OTHER2_DATE", "20121003");
        map.put("OTHER2_JUSTIFICATION", "Workshop Registration");
        map.put("OTHER2_AMOUNT", "100");
        map.put("OTHER2_CURRENCY", "USD");
        map.put("NUM_DAYS", "5");
        map.put("DAY1_LUNCH_CITY", "Des Moines");
        map.put("DAY1_LUNCH_STATE", "IA");
        map.put("DAY1_LUNCH_COUNTRY", "USA");
        map.put("DAY1_DINNER_CITY", "Kansas City");
        map.put("DAY1_DINNER_STATE", "MO");
        map.put("DAY1_DINNER_COUNTRY", "USA");
        map.put("DAY1_LODGING_CITY", "Lawrence");
        map.put("DAY1_LODGING_STATE", "KS");
        map.put("DAY1_LODGING_COUNTRY", "USA");
        map.put("DAY1_LODGING_AMOUNT", "86.31");
        map.put("DAY1_LODGING_CURRENCY", "USD");
        map.put("DAY2_DINNER_CITY", "Lawrence");
        map.put("DAY2_DINNER_STATE", "KS");
        map.put("DAY2_DINNER_COUNTRY", "USA");
        map.put("DAY2_LODGING_CITY", "Lawrence");
        map.put("DAY2_LODGING_STATE", "KS");
        map.put("DAY2_LODGING_COUNTRY", "USA");
        map.put("DAY2_LODGING_AMOUNT", "86.31");
        map.put("DAY2_LODGING_CURRENCY", "USD");
        map.put("DAY3_LODGING_CITY", "Lawrence");
        map.put("DAY3_LODGING_STATE", "KS");
        map.put("DAY3_LODGING_COUNTRY", "USA");
        map.put("DAY3_LODGING_AMOUNT", "86.31");
        map.put("DAY3_LODGING_CURRENCY", "USD");
        map.put("DAY4_DINNER_CITY", "Lawrence");
        map.put("DAY4_DINNER_STATE", "KS");
        map.put("DAY4_DINNER_COUNTRY", "USA");
        map.put("DAY4_LODGING_CITY", "Lawrence");
        map.put("DAY4_LODGING_STATE", "KS");
        map.put("DAY4_LODGING_COUNTRY", "USA");
        map.put("DAY4_LODGING_AMOUNT", "86.31");
        map.put("DAY4_LODGING_CURRENCY", "USD");
        map.put("DAY5_DINNER_CITY", "Des Moines");
        map.put("DAY5_DINNER_STATE", "IA");
        map.put("DAY5_DINNER_COUNTRY", "USA");
        map.put("NUM_TRANSPORTATION", "6");
        map.put("TRANSPORTATION1_DATE", "20121108");
        map.put("TRANSPORTATION1_TYPE", "PARKING");
        map.put("TRANSPORTATION1_AMOUNT", "12.00");
        map.put("TRANSPORTATION1_CURRENCY", "USD");
        map.put("TRANSPORTATION2_DATE", "20121109");
        map.put("TRANSPORTATION2_TYPE", "PARKING");
        map.put("TRANSPORTATION2_AMOUNT", "13.00");
        map.put("TRANSPORTATION2_CURRENCY", "USD");
        map.put("TRANSPORTATION3_DATE", "20121110");
        map.put("TRANSPORTATION3_TYPE", "PARKING");
        map.put("TRANSPORTATION3_AMOUNT", "12.00");
        map.put("TRANSPORTATION3_CURRENCY", "USD");
        map.put("TRANSPORTATION4_DATE", "20121110");
        map.put("TRANSPORTATION4_TYPE", "PARKING");
        map.put("TRANSPORTATION4_AMOUNT", "22");
        map.put("TRANSPORTATION4_CURRENCY", "USD");
        map.put("TRANSPORTATION5_DATE", "20121110");
        map.put("TRANSPORTATION5_TYPE", "TOLL");
        map.put("TRANSPORTATION5_AMOUNT", "1.65");
        map.put("TRANSPORTATION5_CURRENCY", "USD");
        map.put("TRANSPORTATION6_DATE", "20121110");
        map.put("TRANSPORTATION6_TYPE", "TOLL");
        map.put("TRANSPORTATION6_AMOUNT", "1.60");
        map.put("TRANSPORTATION6_CURRENCY", "USD");
        return map;
    }

    /*
     * Sample Expense Utils
     */

    public static Expense getSampleExpenseDodGrantHertzRule(String rentalPlace)
    {

        Set<FormGrant> grants = new HashSet<FormGrant>();

        FormGrant grant1 = new FormGrant("test account 1", "Sponsored", "DOD",
                500.00, "noExport", null, null);

        grants.add(grant1);

        GrantSet grantSet = new GrantSet(grants);

        Date date = new Date();

        Location location = new Location("Minneapolis", "Minnesota",
                "United States");

        TransportationExpense transportationExpense = new TransportationExpense(
                ExpenseType.TRANSPORTATION, date, 40.34, location, grantSet,
                "needed rental car", "CAR", rentalPlace, 53, true);

        return transportationExpense;
    }

    public static Expense getSampleExpenseDodGrantNoBreakfast()
    {

        Set<FormGrant> grants = new HashSet<FormGrant>();

        FormGrant grant1 = new FormGrant("test account 1", "Sponsored", "DOD",
                500.00, "noExport", null, null);

        grants.add(grant1);

        GrantSet grantSet = new GrantSet(grants);

        Date date = new Date();

        Location location = new Location("Minneapolis", "Minnesota",
                "United States");

        Expense expense = new Expense(ExpenseType.BREAKFAST, date, 13.34,
                location, grantSet, "I was hungry");

        return expense;
    }

    public static Expense getSampleExpenseDodGrantNoForeign(String country)
    {

        Set<FormGrant> grants = new HashSet<FormGrant>();

        FormGrant grant1 = new FormGrant("test account 1", "Sponsored", "DOD",
                500.00, "noExport", null, null);

        grants.add(grant1);

        GrantSet grantSet = new GrantSet(grants);

        Date date = new Date();

        Location location = new Location("Generic", "Place", country);

        TransportationExpense transportationExpense = new TransportationExpense(
                ExpenseType.TRANSPORTATION, date, 40.34, location, grantSet,
                "needed rental car", "CAR", "Hertz", 53, true);

        return transportationExpense;
    }

    public static Expense getSampleExpenseForeignGrantForeignTravel(
            String organizationType, String country)
    {

        Set<FormGrant> grants = new HashSet<FormGrant>();

        FormGrant grant1 = new FormGrant("test account 1", "Sponsored", "DOD",
                500.00, organizationType, null, null);

        grants.add(grant1);

        GrantSet grantSet = new GrantSet(grants);

        Date date = new Date();

        Location location = new Location("Generic", "Place", country);

        TransportationExpense transportationExpense = new TransportationExpense(
                ExpenseType.TRANSPORTATION, date, 40.34, location, grantSet,
                "needed rental car", "CAR", "Hertz", 53, true);

        return transportationExpense;
    }

    public static Expense getSampleExpenseNihNoFood(ExpenseType type)
    {

        Set<FormGrant> grants = new HashSet<FormGrant>();

        FormGrant grant1 = new FormGrant("test account 1", "Sponsored", "Nih",
                500.00, "noExport", null, null);

        grants.add(grant1);

        GrantSet grantSet = new GrantSet(grants);

        Date date = new Date();

        Location location = new Location("Minneapolis", "Minnesota",
                "United States");

        Expense expense = new Expense(type, date, 40.34, location, grantSet,
                "needed rental car");

        return expense;
    }

    public static Expense getSampleExpenseNihPublicTransitOrAirfare(
            String type, ExpenseType expenseType)
    {

        Set<FormGrant> grants = new HashSet<FormGrant>();

        FormGrant grant1 = new FormGrant("test account 1", "Sponsored", "Nih",
                500.00, "noExport", null, null);

        grants.add(grant1);

        GrantSet grantSet = new GrantSet(grants);

        Date date = new Date();

        Location location = new Location("Minneapolis", "Minnesota",
                "United States");

        TransportationExpense transportationExpense = new TransportationExpense(
                expenseType, date, 40.34, location, grantSet,
                "needed rental car", type, "Hertz", 53, true);

        return transportationExpense;
    }

    public static List<Expense> getSampleExpenseHotelOvernight()
    {

        Set<FormGrant> grants = new HashSet<FormGrant>();

        FormGrant grant1 = new FormGrant("test account 1", "Sponsored", "Nih",
                500.00, "noExport", null, null);

        grants.add(grant1);

        GrantSet grantSet = new GrantSet(grants);

        Date date = new Date();

        Location location = new Location("Minneapolis", "Minnesota",
                "United States");

        Expense expense = new Expense(ExpenseType.LODGING, date, 40.34,
                location, grantSet, "I was sleepy.");

        List<Expense> expenseList = new ArrayList<Expense>();

        expenseList.add(expense);

        return expenseList;
    }

    public static List<Expense> getSampleExpensesValidDollarAmounts(
            double price1, double price2, double price3)
    {

        Set<FormGrant> grants = new HashSet<FormGrant>();

        FormGrant grant1 = new FormGrant("test account 1", "Sponsored", "Nih",
                500.00, "noExport", null, null);

        grants.add(grant1);

        GrantSet grantSet = new GrantSet(grants);

        Date date = new Date();

        Location location1 = new Location("Minneapolis", "Minnesota",
                "United States");

        Expense expense1 = new Expense(ExpenseType.LODGING, date, price1,
                location1, grantSet, "I was sleepy.");

        Expense expense2 = new Expense(ExpenseType.BREAKFAST, date, price2,
                location1, grantSet, null);

        Expense expense3 = new Expense(ExpenseType.OTHER, date, price3,
                location1, grantSet, null);

        List<Expense> expenseList = new ArrayList<Expense>();

        expenseList.add(expense1);
        expenseList.add(expense2);
        expenseList.add(expense3);

        return expenseList;
    }

    public static Expense getSampleExpenseSponsoredOtherExpense(
            String justification)
    {

        Set<FormGrant> grants = new HashSet<FormGrant>();

        FormGrant grant1 = new FormGrant("test account 1", "Sponsored", "DOD",
                500.00, "noExport", null, null);

        grants.add(grant1);

        GrantSet grantSet = new GrantSet(grants);

        Date date = new Date();

        Location location = new Location("Generic", "Place", "USA");

        Expense otherExpense = new Expense(ExpenseType.OTHER, date, 50,
                location, grantSet, "Alcohol");

        return otherExpense;
    }

    public static Expense getSampleExpenseNonDodGrantNationalRule(
            String rentalPlace)
    {

        Set<FormGrant> grants = new HashSet<FormGrant>();

        FormGrant grant1 = new FormGrant("test account 1", "non-Sponsored",
                null, 500.00, "noExport", null, null);

        grants.add(grant1);

        GrantSet grantSet = new GrantSet(grants);

        Date date = new Date();

        Location location = new Location("Minneapolis", "Minnesota",
                "United States");

        TransportationExpense transportationExpense = new TransportationExpense(
                ExpenseType.TRANSPORTATION, date, 40.34, location, grantSet,
                "needed rental car", "CAR", rentalPlace, 53, true);

        return transportationExpense;
    }

    public static List<Expense> getSampleExpenseBaggageClaim(Double expense)
    {

        Set<FormGrant> grants = new HashSet<FormGrant>();

        FormGrant grant1 = new FormGrant("test account 1", "non-Sponsored",
                null, 500.00, "noExport", null, null);

        grants.add(grant1);

        GrantSet grantSet = new GrantSet(grants);

        Date date = new Date();

        Location location = new Location("Minneapolis", "Minnesota",
                "United States");

        TransportationExpense transportationExpense = new TransportationExpense(
                ExpenseType.TRANSPORTATION, date, expense, location, grantSet,
                "needed checked bags", "BAGGAGE", "American Airlines", 53, true);

        List<Expense> expenseList = new ArrayList<Expense>();

        expenseList.add(transportationExpense);

        return expenseList;

    }

    public static List<Expense> getSampleExpenseNumBaggageClaim(int moreClaims)
    {

        Set<FormGrant> grants = new HashSet<FormGrant>();

        FormGrant grant1 = new FormGrant("test account 1", "non-Sponsored",
                null, 500.00, "noExport", null, null);

        grants.add(grant1);

        GrantSet grantSet = new GrantSet(grants);

        Date date = new Date();

        Location location = new Location("Minneapolis", "Minnesota",
                "United States");

        List<Expense> expenseList = new ArrayList<Expense>();

        if (moreClaims == 1)
        {

            for (int i = 0; i < 5; i++)
            {
                TransportationExpense transportationExpense = new TransportationExpense(
                        ExpenseType.TRANSPORTATION, date, 100, location,
                        grantSet, "needed checked bags", "BAGGAGE",
                        "American Airlines", 53, true);
                expenseList.add(transportationExpense);
            }

            for (int i = 0; i < 4; i++)
            {
                TransportationExpense transportationExpense = new TransportationExpense(
                        ExpenseType.TRANSPORTATION, date, 100, location,
                        grantSet, "needed checked bags", "AIR",
                        "American Airlines", 53, true);
                expenseList.add(transportationExpense);
            }

        }

        if (moreClaims == 0)
        {

            for (int i = 0; i < 5; i++)
            {
                TransportationExpense transportationExpense = new TransportationExpense(
                        ExpenseType.TRANSPORTATION, date, 100, location,
                        grantSet, "needed checked bags", "BAGGAGE",
                        "American Airlines", 53, true);
                expenseList.add(transportationExpense);
            }

            for (int i = 0; i < 5; i++)
            {
                TransportationExpense transportationExpense = new TransportationExpense(
                        ExpenseType.TRANSPORTATION, date, 100, location,
                        grantSet, "needed checked bags", "AIR",
                        "American Airlines", 53, true);
                expenseList.add(transportationExpense);
            }

        }

        if (moreClaims == -1)
        {

            for (int i = 0; i < 4; i++)
            {
                TransportationExpense transportationExpense = new TransportationExpense(
                        ExpenseType.TRANSPORTATION, date, 100, location,
                        grantSet, "needed checked bags", "BAGGAGE",
                        "American Airlines", 53, true);
                expenseList.add(transportationExpense);
            }

            for (int i = 0; i < 5; i++)
            {
                TransportationExpense transportationExpense = new TransportationExpense(
                        ExpenseType.TRANSPORTATION, date, 100, location,
                        grantSet, "needed checked bags", "AIR",
                        "American Airlines", 53, true);
                expenseList.add(transportationExpense);
            }

        }

        return expenseList;

    }

    public static List<Expense> getSampleExpensePersonalandCarRental(
            Date personal, Date rental)
    {

        Set<FormGrant> grants = new HashSet<FormGrant>();

        FormGrant grant1 = new FormGrant("test account 1", "non-Sponsored",
                null, 500.00, "noExport", null, null);

        grants.add(grant1);

        GrantSet grantSet = new GrantSet(grants);

        Location location = new Location("Minneapolis", "Minnesota",
                "United States");

        TransportationExpense transportationExpense = new TransportationExpense(
                ExpenseType.TRANSPORTATION, personal, 50, location, grantSet,
                "needed checked bags", "CAR", "National", 53, true);

        TransportationExpense personalExpense = new TransportationExpense(
                ExpenseType.TRANSPORTATION, rental, 50, location, grantSet,
                "needed checked bags", "CAR", "National", 53, true);

        List<Expense> expenseList = new ArrayList<Expense>();

        expenseList.add(transportationExpense);
        expenseList.add(personalExpense);

        return expenseList;

    }

    public static List<Expense> getSampleExpenseArrivalandDeparture(
            Date expenseDate)
    {

        Set<FormGrant> grants = new HashSet<FormGrant>();

        FormGrant grant1 = new FormGrant("test account 1", "non-Sponsored",
                null, 500.00, "noExport", null, null);

        grants.add(grant1);

        GrantSet grantSet = new GrantSet(grants);

        Location location = new Location("Minneapolis", "Minnesota",
                "United States");

        Expense expense = new Expense(ExpenseType.LODGING, expenseDate, 40.34,
                location, grantSet, "I was sleepy.");

        List<Expense> expenseList = new ArrayList<Expense>();

        expenseList.add(expense);

        return expenseList;

    }

    /*
     * Set FormGrant rules
     */

    public static Set<FormGrant> getSampleGrantsSponsorshipType(
            String sponsorship)
    {
        Set<FormGrant> grants = new HashSet<FormGrant>();

        FormGrant grant1 = new FormGrant("test account 1", sponsorship, null,
                500.00, "noExport", null, null);

        grants.add(grant1);


        return grants;
    }

}
