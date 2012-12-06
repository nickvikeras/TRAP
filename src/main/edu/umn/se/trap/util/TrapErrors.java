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

}
