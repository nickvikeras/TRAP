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

import java.util.Map;

/**
 * @author Mark
 * 
 *         This class is to help print input and output forms. NOT TO BE
 *         INCLUDED IN THE FINAL BUILD.
 * 
 */
public class Printer
{

    /**
     * Prints the input and output map for documentation.
     * 
     * @param input
     * @param output
     */
    public static void print(Map<String, String> input,
            Map<String, String> output)
    {

        System.out.println("Test Inputs:");
        System.out.println("USER_NAME\t" + input.get("USER_NAME"));
        System.out.println("DEPARTURE_DATETIME\t"
                + input.get("DEPARTURE_DATETIME"));
        System.out
                .println("ARRIVAL_DATETIME\t" + input.get("ARRIVAL_DATETIME"));
        System.out.println("TRAVEL_TYPE_CSE_SPONSORED\t"
                + input.get("TRAVEL_TYPE_CSE_SPONSORED"));
        System.out.println("TRAVEL_TYPE_DTC_SPONSORED\t"
                + input.get("TRAVEL_TYPE_DTC_SPONSORED"));
        System.out.println("TRAVEL_TYPE_NONSPONSORED\t"
                + input.get("TRAVEL_TYPE_NONSPONSORED"));
        System.out.println("EMERGENCY_CONTACT_NAME\t"
                + input.get("EMERGENCY_CONTACT_NAME"));
        System.out.println("EMERGENCY_CONTACT_PHONE\t"
                + input.get("EMERGENCY_CONTACT_PHONE"));
        System.out.println("JUSTIFICATION_CONFERENCE_TITLE\t"
                + input.get("JUSTIFICATION_CONFERENCE_TITLE"));
        System.out.println("JUSTIFICATION_PRESENTED\t"
                + input.get("JUSTIFICATION_PRESENTED"));
        System.out.println("JUSTIFICATION_PRESENTATION_TITLE\t"
                + input.get("JUSTIFICATION_PRESENTATION_TITLE"));
        System.out.println("JUSTIFICATION_PRESENTATION_ABSTRACT\t"
                + input.get("JUSTIFICATION_PRESENTATION_ABSTRACT"));
        System.out.println("JUSTIFICATION_PRESENTATION_ACKNOWLEDGEMENT\t"
                + input.get("JUSTIFICATION_PRESENTATION_ACKNOWLEDGEMENT"));
        System.out.println("JUSTIFICATION_NONSPONSORED\t"
                + input.get("JUSTIFICATION_NONSPONSORED"));
        System.out.println("JUSTIFICATION_SPONSORED\t"
                + input.get("JUSTIFICATION_SPONSORED"));
        System.out.println("NUM_DAYS\t" + input.get("NUM_DAYS"));

        for (int i = 0; i < Integer.parseInt(input.get("NUM_DAYS")); i++)
        {
            if (input.get("DAY" + i + "_BREAKFAST_CITY") != null)
            {
                System.out.println("DAY" + i + "_BREAKFAST_CITY\t"
                        + input.get("DAY" + i + "_BREAKFAST_CITY"));
            }

            if (input.get("DAY" + i + "_BREAKFAST_STATE") != null)
            {
                System.out.println("DAY" + i + "_BREAKFAST_STATE\t"
                        + input.get("DAY" + i + "_BREAKFAST_STATE"));
            }

            if (input.get("DAY" + i + "_BREAKFAST_COUNTRY") != null)
            {
                System.out.println("DAY" + i + "_BREAKFAST_COUNTRY\t"
                        + input.get("DAY" + i + "_BREAKFAST_COUNTRY"));
            }

            if (input.get("DAY" + i + "_LUNCH_CITY") != null)
            {
                System.out.println("DAY" + i + "_LUNCH_CITY\t"
                        + input.get("DAY" + i + "_LUNCH_CITY"));
            }

            if (input.get("DAY" + i + "_LUNCH_STATE") != null)
            {
                System.out.println("DAY" + i + "_LUNCH_STATE\t"
                        + input.get("DAY" + i + "_LUNCH_STATE"));
            }

            if (input.get("DAY" + i + "_LUNCH_COUNTRY") != null)
            {
                System.out.println("DAY" + i + "_LUNCH_COUNTRY\t"
                        + input.get("DAY" + i + "_LUNCH_COUNTRY"));
            }

            if (input.get("DAY" + i + "_DINNER_CITY") != null)
            {
                System.out.println("DAY" + i + "_DINNER_CITY\t"
                        + input.get("DAY" + i + "_DINNER_CITY"));
            }

            if (input.get("DAY" + i + "_DINNER_STATE") != null)
            {
                System.out.println("DAY" + i + "_DINNER_STATE\t"
                        + input.get("DAY" + i + "_DINNER_STATE"));
            }

            if (input.get("DAY" + i + "_DINNER_COUNTRY") != null)
            {
                System.out.println("DAY" + i + "_DINNER_COUNTRY\t"
                        + input.get("DAY" + i + "_DINNER_COUNTRY"));
            }

            if (input.get("DAY" + i + "_INCIDENTAL_CITY") != null)
            {
                System.out.println("DAY" + i + "_INCIDENTAL_CITY\t"
                        + input.get("DAY" + i + "_INCIDENTAL_CITY"));
            }

            if (input.get("DAY" + i + "_INCIDENTAL_STATE") != null)
            {
                System.out.println("DAY" + i + "_INCIDENTAL_STATE\t"
                        + input.get("DAY" + i + "_INCIDENTAL_STATE"));
            }

            if (input.get("DAY" + i + "_INCIDENTAL_COUNTRY") != null)
            {
                System.out.println("DAY" + i + "_INCIDENTAL_COUNTRY\t"
                        + input.get("DAY" + i + "_INCIDENTAL_COUNTRY"));
            }

            if (input.get("DAY" + i + "_INCIDENTAL_AMOUNT") != null)
            {
                System.out.println("DAY" + i + "_INCIDENTAL_AMOUNT\t"
                        + input.get("DAY" + i + "_INCIDENTAL_AMOUNT"));
            }

            if (input.get("DAY" + i + "_INCIDENTAL_CURRENCY") != null)
            {
                System.out.println("DAY" + i + "_INCIDENTAL_CURRENCY\t"
                        + input.get("DAY" + i + "_INCIDENTAL_CURRENCY"));
            }

            if (input.get("DAY" + i + "_INCIDENTAL_JUSTIFICATION") != null)
            {
                System.out.println("DAY" + i + "_INCIDENTAL_JUSTIFICATION\t"
                        + input.get("DAY" + i + "_INCIDENTAL_JUSTIFICATION"));
            }

            if (input.get("DAY" + i + "_LODGING_CITY") != null)
            {
                System.out.println("DAY" + i + "_LODGING_CITY\t"
                        + input.get("DAY" + i + "_LODGING_CITY"));
            }

            if (input.get("DAY" + i + "_LODGING_STATE") != null)
            {
                System.out.println("DAY" + i + "_LODGING_STATE\t"
                        + input.get("DAY" + i + "_LODGING_STATE"));
            }

            if (input.get("DAY" + i + "_LODGING_COUNTRY") != null)
            {
                System.out.println("DAY" + i + "_LODGING_COUNTRY\t"
                        + input.get("DAY" + i + "_LODGING_COUNTRY"));
            }

            if (input.get("DAY" + i + "_LODGING_AMOUNT") != null)
            {
                System.out.println("DAY" + i + "_LODGING_AMOUNT\t"
                        + input.get("DAY" + i + "_LODGING_AMOUNT"));
            }

            if (input.get("DAY" + i + "_LODGING_CURRENCY") != null)
            {
                System.out.println("DAY" + i + "_LODGING_CURRENCY\t"
                        + input.get("DAY" + i + "_LODGING_CURRENCY"));
            }

        }

        System.out.println("NUM_TRANSPORTATION\t"
                + input.get("NUM_TRANSPORTATION"));

        for (int i = 0; i < Integer.parseInt(input.get("NUM_TRANSPORTATION")); i++)
        {

            if (input.get("TRANSPORTATION" + i + "_DATE") != null)
            {
                System.out.println("TRANSPORTATION" + i + "_DATE\t"
                        + input.get("TRANSPORTATION" + i + "_DATE"));
            }

            if (input.get("TRANSPORTATION" + i + "_TYPE") != null)
            {
                System.out.println("TRANSPORTATION" + i + "_TYPE\t"
                        + input.get("TRANSPORTATION" + i + "_TYPE"));
            }

            if (input.get("TRANSPORTATION" + i + "_RENTAL") != null)
            {
                System.out.println("TRANSPORTATION" + i + "_RENTAL\t"
                        + input.get("TRANSPORTATION" + i + "_RENTAL"));
            }

            if (input.get("TRANSPORTATION" + i + "_CARRIER") != null)
            {
                System.out.println("TRANSPORTATION" + i + "_CARRIER\t"
                        + input.get("TRANSPORTATION" + i + "_CARRIER"));
            }

            if (input.get("TRANSPORTATION" + i + "_MILES_TRAVELED") != null)
            {
                System.out.println("TRANSPORTATION" + i + "_MILES_TRAVELED\t"
                        + input.get("TRANSPORTATION" + i + "_MILES_TRAVELED"));
            }

            if (input.get("TRANSPORTATION" + i + "_AMOUNT") != null)
            {
                System.out.println("TRANSPORTATION" + i + "_AMOUNT\t"
                        + input.get("TRANSPORTATION" + i + "_AMOUNT"));
            }

            if (input.get("TRANSPORTATION" + i + "_CURRENCY") != null)
            {
                System.out.println("TRANSPORTATION" + i + "_CURRENCY\t"
                        + input.get("TRANSPORTATION" + i + "_CURRENCY"));
            }

        }

        System.out.println("NUM_OTHER_EXPENSES\t"
                + input.get("NUM_OTHER_EXPENSES"));

        for (int i = 0; i < Integer.parseInt(input.get("NUM_OTHER_EXPENSES")); i++)
        {

            if (input.get("OTHER" + i + "_DATE") != null)
            {
                System.out.println("OTHER" + i + "_DATE\t"
                        + input.get("OTHER" + i + "_DATE"));
            }

            if (input.get("OTHER" + i + "_JUSTIFICATION") != null)
            {
                System.out.println("OTHER" + i + "_JUSTIFICATION\t"
                        + input.get("OTHER" + i + "_JUSTIFICATION"));
            }

            if (input.get("OTHER" + i + "_AMOUNT") != null)
            {
                System.out.println("OTHER" + i + "_AMOUNT\t"
                        + input.get("OTHER" + i + "_AMOUNT"));
            }

            if (input.get("OTHER" + i + "_CURRENCY") != null)
            {
                System.out.println("OTHER" + i + "_CURRENCY\t"
                        + input.get("OTHER" + i + "_CURRENCY"));
            }

        }

        System.out.println("NUM_GRANTS\t" + input.get("NUM_GRANTS"));

        for (int i = 0; i < Integer.parseInt(input.get("NUM_GRANTS")); i++)
        {

            if (input.get("GRANT" + i + "_ACCOUNT") != null)
            {
                System.out.println("GRANT" + i + "_ACCOUNT\t"
                        + input.get("GRANT" + i + "_ACCOUNT"));
            }

            if (input.get("GRANT" + i + "_PERCENT") != null)
            {
                System.out.println("GRANT" + i + "_PERCENT\t"
                        + input.get("GRANT" + i + "_PERCENT"));
            }

        }

        System.out.println("Expected Results:");

        printOutput(output);
    }

    /**
     * Prints only the output map. For use with the expected or the actual
     * output maps.
     * 
     * @param output
     */
    public static void printOutput(Map<String, String> output)
    {

        System.out.println("NAME\t" + output.get("NAME"));
        System.out.println("USER_NAME\t" + output.get("USER_NAME"));
        System.out.println("EMAIL\t" + output.get("EMAIL"));
        System.out.println("CITIZENSHIP\t" + output.get("CITIZENSHIP"));
        System.out.println("VISA_STATUS\t" + output.get("VISA_STATUS"));
        System.out.println("FORM_SUBMISSION_DATETIME\t"
                + output.get("FORM_SUBMISSION_DATETIME"));
        System.out.println("DEPARTURE_DATETIME\t"
                + output.get("DEPARTURE_DATETIME"));
        System.out.println("ARRIVAL_DATETIME\t"
                + output.get("ARRIVAL_DATETIME"));
        System.out.println("PAID_BY_UNIVERSITY\t"
                + output.get("PAID_BY_UNIVERSITY"));
        System.out.println("EMERGENCY_CONTACT_NAME\t"
                + output.get("EMERGENCY_CONTACT_NAME"));
        System.out.println("EMERGENCY_CONTACT_PHONE\t"
                + output.get("EMERGENCY_CONTACT_PHONE"));
        System.out.println("TRAVEL_TYPE_CSE_SPONSORED\t"
                + output.get("TRAVEL_TYPE_CSE_SPONSORED"));
        System.out.println("TRAVEL_TYPE_DTC_SPONSORED\t"
                + output.get("TRAVEL_TYPE_DTC_SPONSORED"));
        System.out.println("TRAVEL_TYPE_NONSPONSORED\t"
                + output.get("TRAVEL_TYPE_NONSPONSORED"));
        System.out.println("JUSTIFICATION_CONFERENCE_TITLE\t"
                + output.get("JUSTIFICATION_CONFERENCE_TITLE"));
        System.out.println("JUSTIFICATION_PRESENTED\t"
                + output.get("JUSTIFICATION_PRESENTED"));
        System.out.println("JUSTIFICATION_PRESENTATION_TITLE\t"
                + output.get("JUSTIFICATION_PRESENTATION_TITLE"));
        System.out.println("JUSTIFICATION_PRESENTATION_ABSTRACT\t"
                + output.get("JUSTIFICATION_PRESENTATION_ABSTRACT"));
        System.out.println("JUSTIFICATION_PRESENTATION_ACKNOWLEDGEMENT\t"
                + output.get("JUSTIFICATION_PRESENTATION_ACKNOWLEDGEMENT"));
        System.out.println("JUSTIFICATION_NONSPONSORED\t"
                + output.get("JUSTIFICATION_NONSPONSORED"));
        System.out.println("JUSTIFICATION_SPONSORED\t"
                + output.get("JUSTIFICATION_SPONSORED"));
        System.out.println("NUM_DESTINATIONS\t"
                + output.get("NUM_DESTINATIONS"));

        for (int i = 0; i < Integer.parseInt(output.get("NUM_DESTINATIONS")); i++)
        {
            if (output.get("DESTINATION" + i + "_CITY") != null)
            {
                System.out.println("DESTINATION" + i + "_CITY\t"
                        + output.get("DESTINATION" + i + "_CITY"));
            }

            if (output.get("DESTINATION" + i + "_STATE") != null)
            {
                System.out.println("DESTINATION" + i + "_STATE\t"
                        + output.get("DESTINATION" + i + "_STATE"));
            }

            if (output.get("DESTINATION" + i + "_COUNTRY") != null)
            {
                System.out.println("DESTINATION" + i + "_COUNTRY\t"
                        + output.get("DESTINATION" + i + "_COUNTRY"));
            }
        }

        System.out.println("NUM_DAYS\t" + output.get("NUM_DAYS"));

        for (int i = 0; i < Integer.parseInt(output.get("NUM_DAYS")); i++)
        {
            if (output.get("DAY" + i + "_DATE") != null)
            {
                System.out.println("DAY" + i + "_DATE\t"
                        + output.get("DAY" + i + "_DATE"));
            }

            if (output.get("DAY" + i + "_TOTAL") != null)
            {
                System.out.println("DAY" + i + "_TOTAL\t"
                        + output.get("DAY" + i + "_TOTAL"));
            }

            if (output.get("DAY" + i + "_INCIDENTAL_TOTAL") != null)
            {
                System.out.println("DAY" + i + "_INCIDENTAL_TOTAL\t"
                        + output.get("DAY" + i + "_INCIDENTAL_TOTAL"));
            }

            if (output.get("DAY" + i + "_INCIDENTAL_JUSTIFICATION") != null)
            {
                System.out.println("DAY" + i + "_INCIDENTAL_JUSTIFICATION\t"
                        + output.get("DAY" + i + "_INCIDENTAL_JUSTIFICATION"));
            }
        }

        System.out.println("NUM_TRANSPORTATION\t"
                + output.get("NUM_TRANSPORTATION"));

        for (int i = 0; i < Integer.parseInt(output.get("NUM_TRANSPORTATION")); i++)
        {

            if (output.get("TRANSPORTATION" + i + "_DATE") != null)
            {
                System.out.println("TRANSPORTATION" + i + "_DATE\t"
                        + output.get("TRANSPORTATION" + i + "_DATE"));
            }

            if (output.get("TRANSPORTATION" + i + "_TYPE") != null)
            {
                System.out.println("TRANSPORTATION" + i + "_TYPE\t"
                        + output.get("TRANSPORTATION" + i + "_TYPE"));
            }

            if (output.get("TRANSPORTATION" + i + "_TOTAL") != null)
            {
                System.out.println("TRANSPORTATION" + i + "_TOTAL\t"
                        + output.get("TRANSPORTATION" + i + "_TOTAL"));
            }

        }

        System.out.println("NUM_OTHER_EXPENSES\t"
                + output.get("NUM_OTHER_EXPENSES"));

        for (int i = 0; i < Integer.parseInt(output.get("NUM_OTHER_EXPENSES")); i++)
        {

            if (output.get("OTHER" + i + "_DATE") != null)
            {
                System.out.println("OTHER" + i + "_DATE\t"
                        + output.get("OTHER" + i + "_DATE"));
            }

            if (output.get("OTHER" + i + "_JUSTIFICATION") != null)
            {
                System.out.println("OTHER" + i + "_JUSTIFICATION\t"
                        + output.get("OTHER" + i + "_JUSTIFICATION"));
            }

            if (output.get("OTHER" + i + "_AMOUNT") != null)
            {
                System.out.println("OTHER" + i + "_AMOUNT\t"
                        + output.get("OTHER" + i + "_AMOUNT"));
            }

        }

        System.out.println("NUM_GRANTS\t" + output.get("NUM_GRANTS"));

        for (int i = 0; i < Integer.parseInt(output.get("NUM_GRANTS")); i++)
        {

            if (output.get("GRANT" + i + "_ACCOUNT") != null)
            {
                System.out.println("GRANT" + i + "_ACCOUNT\t"
                        + output.get("GRANT" + i + "_ACCOUNT"));
            }

            if (output.get("GRANT" + i + "_PERCENT") != null)
            {
                System.out.println("GRANT" + i + "_PERCENT\t"
                        + output.get("GRANT" + i + "_PERCENT"));
            }

            if (output.get("GRANT" + i + "_AMOUNT_TO_CHARGE") != null)
            {
                System.out.println("GRANT" + i + "_AMOUNT_TO_CHARGE\t"
                        + output.get("GRANT" + i + "_AMOUNT_TO_CHARGE"));
            }

            if (output.get("GRANT" + i + "_APPROVER_NAME") != null)
            {
                System.out.println("GRANT" + i + "_APPROVER_NAME\t"
                        + output.get("GRANT" + i + "_APPROVER_NAME"));
            }

        }

        System.out.println("TOTAL_REIMBURSEMENT\t"
                + output.get("TOTAL_REIMBURSEMENT"));

    }

}
