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
package edu.umn.se.trap.util;

/**
 * @author nick
 * 
 */
public class TrapErrors
{

    public static final String NONCITIZEN_EXPORT = "Only U.S. citizens can use non-export grants";
    public static final String PERSONAL_RENTAL_CAR = "Invalid Car Usage: Personal and Rental Vehicle Expense on Same Day";
    public static final String INVALID_BAGGAGE_COST = "Invalid Baggage Claim: Cost exceeds maximum amount";
    public static final String INVALID_NUM_BAGGAGE = "Invalid Number of Baggage Claims: More claims than flights.";
    public static final String NON_SPONSORED = "A trip must be non-sponsored to charge to a non-sponsored grant.";
    public static final String NO_GRANTS_FOR_TRAVEL_TYPE = "No grants exist in the order for one or more travel types.";
    public static final String USER_NOT_AUTORIZED = "Invalid Grant request: User is not authorized to use this grant";
    public static final String INVALID_VISA = "Invalid citizenship and visa status";
    public static final String US_CARRIER_ONLY = "Invalid Air Carrier: Not a US Air Carrier.";
    public static final String INVALID_ARRIVAL_DEPARTURE = "Departure time must come before arrival time";
    public static final String LODGING_EXPENSE_1_DAY = "Lodging expenses cannot be claimed for a trip less than 1 day.";
    public static final String NO_CITIZENSHIP = "Required field missing: citizenship status";
    public static final String NO_VISA_STATUS = "Required field missing: visa status";
    public static final String NO_X500 = "Required field missing: x500 user name";
    public static final String MISSING_ACKNOWLEDGEMENT = "Required field missing: presentation acknowledgement.";
    public static final String NO_GRANTS = "Required field missing: grant list was empty.";
    public static final String NO_ACCOUNT_NUMBER = "Required field missing: grant account number was empty.";
    public static final String NO_EXPENSE_DATE = "Required field missing: expense date/time.";
    public static final String NO_EXPENSE_TYPE = "Required field missing: expense type.";
    public static final String NO_JUSTIFICATION = "Required field missing: justification.";
    public static final String NO_EXPENSE_LOCATION = "Required field missing: expense location.";
    public static final String NO_EXPENSES = "Required field missing: the expense list is empty.";
    public static final String NO_DEPARTURE_TIME = "Required field missing: arrival date/time.";
    public static final String NO_TRAVEL_TYPE = "Required field missing: travel sponsorship type.";
    public static final String NO_CONF_TITLE = "Required field missing: conference title.";
    public static final String PRES_TITLE = "Required field missing: presentation title.";
    public static final String NO_ABSTRACT = "Required field missing: presentation abstract.";
    public static final String EXPENSES_BETWEEN_DATES = "Expenses cannot be claimed outside of the dates of the trip.";
    public static final String VALID_DOLLAR_AMOUNT = "Invalid Expense: Amount must be greater than 0";
    public static final String NO_GRANTS_FOR_EXPENSE = "No grants can cover one or more expenses.";
    public static final String NOT_ENOUGH_MONEY_IN_ACCOUNT = "not enough money in account";

}
