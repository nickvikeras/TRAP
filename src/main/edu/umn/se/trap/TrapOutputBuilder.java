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
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import edu.umn.se.trap.form.Day;
import edu.umn.se.trap.form.DayComparator;
import edu.umn.se.trap.form.Expense;
import edu.umn.se.trap.form.ExpenseType;
import edu.umn.se.trap.form.FormGrant;
import edu.umn.se.trap.form.Location;
import edu.umn.se.trap.form.TransportationExpense;
import edu.umn.se.trap.form.TrapDateUtil;
import edu.umn.se.trap.form.TrapForm;
import edu.umn.se.trap.form.TrapUtil;

/**
 * @author nick
 * 
 */
public class TrapOutputBuilder
{

    /**
     * @param form
     * @param amountsToCharge
     * @return
     */
    public static Map<String, String> buildOut(TrapForm form,
            Map<String, Double> amountsToCharge)
    {

        Map<String, String> output = new HashMap<String, String>();
        putIfNotNull(output, TrapOutputKeys.NAME, form.getUser().getFullName());
        putIfNotNull(output, TrapOutputKeys.USER_NAME, form.getUser()
                .getUserName());
        putIfNotNull(output, TrapOutputKeys.EMAIL, form.getUser().getEmail());
        putIfNotNull(output, TrapOutputKeys.CITIZENSHIP, form.getUser()
                .getCitizenship());
        putIfNotNull(output, TrapOutputKeys.VISA_STATUS, form.getUser()
                .getVisaStatus());
        putIfNotNull(output, TrapOutputKeys.FORM_SUBMISSION_DATETIME,
                TrapDateUtil.printDateTime(form.getSubmissionDate()));
        putIfNotNull(output, TrapOutputKeys.DEPARTURE_DATETIME,
                TrapDateUtil.printDateTime(form.getTrip()
                        .getDepartureDateTime()));
        putIfNotNull(output, TrapOutputKeys.ARRIVAL_DATETIME,
                TrapDateUtil.printDateTime(form.getTrip().getArrivalDateTime()));
        putIfNotNull(output, TrapOutputKeys.PAID_BY_UNIVERSITY,
                TrapUtil.boolToYesNo(form.getUser().isPaidByUniversity()));
        putIfNotNull(output, TrapOutputKeys.EMERGENCY_CONTACT_NAME, form
                .getUser().getEmergencyContactName());
        putIfNotNull(output, TrapOutputKeys.EMERGENCY_CONTACT_PHONE, form
                .getUser().getEmergencyContactPhone());
        if (form.getTrip().isTravelTypeCseSponsored())
        {
            putIfNotNull(output, TrapOutputKeys.TRAVEL_TYPE_CSE_SPONSORED,
                    TrapUtil.boolToYesNo(form.getTrip()
                            .isTravelTypeCseSponsored()));
        }
        if (form.getTrip().isTravelTypeDtcSponsored())
        {
            putIfNotNull(output, TrapOutputKeys.TRAVEL_TYPE_DTC_SPONSORED,
                    TrapUtil.boolToYesNo(form.getTrip()
                            .isTravelTypeDtcSponsored()));
        }
        if (form.getTrip().isTravelTypeNonsponsored())
        {
            putIfNotNull(output, TrapOutputKeys.TRAVEL_TYPE_NONSPONSORED,
                    TrapUtil.boolToYesNo(form.getTrip()
                            .isTravelTypeNonsponsored()));
        }
        putIfNotNull(output, TrapOutputKeys.JUSTIFICATION_CONFERENCE_TITLE,
                form.getTrip().getJustificationConferenceTitle());
        putIfNotNull(output, TrapOutputKeys.JUSTIFICATION_PRESENTED,
                TrapUtil.boolToYesNo(form.getTrip().isJustificationPresented()));
        putIfNotNull(output, TrapOutputKeys.JUSTIFICATION_PRESENTATION_TITLE,
                form.getTrip().getJustificationPresentationTitle());
        putIfNotNull(output,
                TrapOutputKeys.JUSTIFICATION_PRESENTATION_ABSTRACT, form
                        .getTrip().getJustificationPresentationAbstract());
        putIfNotNull(output,
                TrapOutputKeys.JUSTIFICATION_PRESENTATION_ACKNOWLEDGEMENT, form
                        .getTrip()
                        .getJustificationPresentationAcknowledgement());
        putIfNotNull(output, TrapOutputKeys.JUSTIFICATION_NONSPONSORED, form
                .getTrip().getJustificationNonsponsored());
        putIfNotNull(output, TrapOutputKeys.JUSTIFICATION_SPONSORED, form
                .getTrip().getJustificationSponsored());

        List<Location> locations = form.getLocations();
        putIfNotNull(output, TrapOutputKeys.NUM_DESTINATIONS,
                String.valueOf(locations.size()));
        int i = 1;
        for (Location location : locations)
        {
            putIfNotNull(output,
                    String.format(TrapOutputKeys.DESTINATIONa_CITY, i),
                    location.getCity());
            putIfNotNull(output,
                    String.format(TrapOutputKeys.DESTINATIONa_STATE, i),
                    location.getState());
            putIfNotNull(output,
                    String.format(TrapOutputKeys.DESTINATIONa_COUNTRY, i),
                    location.getCountry());
            i++;
        }

        List<Day> days = form.getDays();
        java.util.Collections.sort(days, new DayComparator());
        i = 1;
        for (Day day : days)
        {
            putIfNotNull(output, String.format(TrapOutputKeys.DAYa_DATE, i),
                    TrapDateUtil.printDate(day.getDate()));
            putIfNotNull(output, String.format(TrapOutputKeys.DAYa_TOTAL, i),
                    TrapUtil.formatDouble(day.getTotal()));
            putIfNotNull(output,
                    String.format(TrapOutputKeys.DAYa_INCIDENTAL_TOTAL, i),
                    TrapUtil.formatDouble(day.getIncidentalTotal()));
            putIfNotNull(output, String.format(
                    TrapOutputKeys.DAYa_INCIDENTAL_JUSTIFICATION, i),
                    day.getIncidentalJustification());
            i++;
        }

        List<Expense> travelExpenses = form
                .getExpensesForType(ExpenseType.TRANSPORTATION);
        putIfNotNull(output, TrapOutputKeys.NUM_TRANSPORTATION,
                String.valueOf(travelExpenses.size()));
        i = 1;
        for (Expense expense : travelExpenses)
        {
            TransportationExpense tExpense = (TransportationExpense) expense;
            putIfNotNull(output,
                    String.format(TrapOutputKeys.TRANSPORTATIONb_DATE, i),
                    TrapDateUtil.printDate(tExpense.getDate()));
            putIfNotNull(output,
                    String.format(TrapOutputKeys.TRANSPORTATIONb_TYPE, i),
                    tExpense.getTranportationType());
            putIfNotNull(output,
                    String.format(TrapOutputKeys.TRANSPORTATIONb_TOTAL, i),
                    TrapUtil.formatDouble(tExpense.getAmount()));
            i++;
        }

        List<Expense> otherExpenses = form
                .getExpensesForType(ExpenseType.OTHER);
        putIfNotNull(output, TrapOutputKeys.NUM_OTHER_EXPENSES,
                String.valueOf(otherExpenses.size()));
        i = 1;
        for (Expense expense : otherExpenses)
        {
            putIfNotNull(output, String.format(TrapOutputKeys.OTHERc_DATE, i),
                    TrapDateUtil.printDate(expense.getDate()));
            putIfNotNull(output,
                    String.format(TrapOutputKeys.OTHERc_JUSTIFICATION, i),
                    expense.getJustification());
            putIfNotNull(output, String.format(TrapOutputKeys.OTHERc_TOTAL, i),
                    TrapUtil.formatDoubleNoDecimals(expense.getAmount()));
            i++;
        }

        putIfNotNull(output, TrapOutputKeys.NUM_GRANTS,
                String.valueOf(form.getGrantSet().getGrants().size()));
        i = 1;
        for (FormGrant grant : form.getGrantSet().getGrants())
        {
            putIfNotNull(output,
                    String.format(TrapOutputKeys.GRANTd_ACCOUNT, i),
                    grant.getAccountName());
            putIfNotNull(output,
                    String.format(TrapOutputKeys.GRANTd_PERCENT, i),
                    TrapUtil.formatDoubleNoDecimals(form
                            .getAccountToPercentMap().get(
                                    grant.getAccountName())));
            putIfNotNull(output, String.format(
                    TrapOutputKeys.GRANTd_AMOUNT_TO_CHARGE, i),
                    TrapUtil.formatDouble(amountsToCharge.get(grant
                            .getAccountName())));
            putIfNotNull(output,
                    String.format(TrapOutputKeys.GRANTd_APPROVER_NAME, i),
                    grant.getGrantAdmin());
            i++;
        }

        double total = 0;
        for (Entry<String, Double> entry : amountsToCharge.entrySet())
        {
            total += entry.getValue();
        }
        putIfNotNull(output, TrapOutputKeys.TOTAL_REIMBURSEMENT,
                TrapUtil.formatDouble(total));
        putIfNotNull(output, TrapOutputKeys.NUM_DAYS,
                String.valueOf(form.getTrip().getNumDays()));

        for (Entry<String, String> entry : output.entrySet())
        {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        
        return output;

    }

    /**
     * @param output
     * @param numDays
     * @param valueOf
     */
    private static void putIfNotNull(Map<String, String> output, String key,
            String value)
    {
        if (value != null && !StringUtils.equals(value, "")
                && !StringUtils.equals(value, "0.0")
                && !StringUtils.equals(value, "0.00")
                && !StringUtils.equals(value, "0"))
        {
            output.put(key, value);
        }

    }

}
