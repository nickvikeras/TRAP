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

import java.util.HashMap;
import java.util.Map;

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
        map.put("JUSTIFICATION_CONFERENCE_TITLE", "SE2012: 26th IEEE/ACM International Conference on Automated Software Engineering");
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
        map.put("DAY1_LODGING_COUINTRY", "USA");
        map.put("DAY1_LODGING_AMOUNT", "86.31");
        map.put("DAY1_LODGING_CURRENCY", "USD");
        map.put("DAY2_DINNER_CITY", "Lawrence");
        map.put("DAY2_DINNER_STATE", "KS");
        map.put("DAY2_DINNER_COUNTRY", "USA");
        map.put("DAY2_LODGING_CITY", "Lawrence");
        map.put("DAY2_LODGING_STATE", "KS");
        map.put("DAY2_LODGING_COUINTRY", "USA");
        map.put("DAY2_LODGING_AMOUNT", "86.31");
        map.put("DAY2_LODGING_CURRENCY", "USD");
        map.put("DAY3_LODGING_CITY", "Lawrence");
        map.put("DAY3_LODGING_STATE", "KS");
        map.put("DAY3_LODGING_COUINTRY", "USA");
        map.put("DAY3_LODGING_AMOUNT", "86.31");
        map.put("DAY3_LODGING_CURRENCY", "USD");
        map.put("DAY4_DINNER_CITY", "Lawrence");
        map.put("DAY4_DINNER_STATE", "KS");
        map.put("DAY4_DINNER_COUNTRY", "USA");
        map.put("DAY4_LODGING_CITY", "Lawrence");
        map.put("DAY4_LODGING_STATE", "KS");
        map.put("DAY4_LODGING_COUINTRY", "USA");
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
}