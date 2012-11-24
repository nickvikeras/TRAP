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
package edu.umn.se.trap.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.TravelFormMetadata;
import edu.umn.se.trap.TravelFormProcessorIntf.FORM_STATUS;
import edu.umn.se.trap.db.orm.DatabaseAccessor;
import edu.umn.se.trap.db.orm.Grant;
import edu.umn.se.trap.db.orm.PerDiem;
import edu.umn.se.trap.db.orm.User;
import edu.umn.se.trap.db.orm.UserGrant;

/**
 * @author mark
 * 
 */
public class FormFactory
{

    public static TrapForm getNewForm(final Map<String, String> formData, String description, DatabaseAccessor dbAccessor) throws TrapException
    {
        Integer id = generateId();
        return getNewForm(formData, description, id, dbAccessor);
    }

    public static TrapForm getNewForm(final Map<String, String> formData, String description, Integer id, DatabaseAccessor dbAccessor) throws TrapException
    {
        try
        {
            TravelFormMetadata travelFormMetaData = new TravelFormMetadata(description, FORM_STATUS.DRAFT);
            GrantSet grantSet = getNewGrantSet(formData, dbAccessor);
            FormUser user = getNewUser(formData, dbAccessor);
            Trip trip = getNewTrip(formData);
            List<Expense> expenses = getNewExpenseList(formData, dbAccessor);
            Map<String, Double> accountToPercentMap = getNewAccountToPercentMap(formData);
            return new TrapForm(id, formData, null, travelFormMetaData, grantSet, user, trip, expenses, accountToPercentMap);
        } catch (Exception e)
        {
            throw new TrapException("Error parsing input");
        }
    }

    /**
     * @param formData
     * @return
     */
    private static Map<String, Double> getNewAccountToPercentMap(Map<String, String> formData) throws Exception
    {
        Map<String, Double> accountToPercentMap = new HashMap<String, Double>();
        Integer numGrants = Integer.parseInt(formData.get(TrapInputKeys.NUM_GRANTS));
        for (int i = 0; i < numGrants; i++)
        {
            String accountNumber = formData.get(String.format(TrapInputKeys.GRANTd_ACCOUNT, i + 1));
            Double percentToCharge = Double.parseDouble(formData.get(String.format(TrapInputKeys.GRANTd_ACCOUNT, i + 1)));
            accountToPercentMap.put(accountNumber, percentToCharge);
        }
        return accountToPercentMap;
    }

    /**
     * @param formData
     * @param dbAccessor
     * @return
     */
    private static List<Expense> getNewExpenseList(Map<String, String> formData, DatabaseAccessor dbAccessor) throws Exception
    {
        List<Expense> expenses = new ArrayList<Expense>();
        final int numDays = Integer.parseInt(formData.get(TrapInputKeys.NUM_DAYS));
        for (int i = 0; i < numDays; i++)
        {
            Date date = TrapDateUtil.parseTrapDateTime(formData.get(TrapInputKeys.DEPARTURE_DATETIME));
            // get date for this day.
            date.setTime(date.getTime() + ((3600 * 24) * i));
            String breakfastCity = formData.get(String.format(TrapInputKeys.DAYa_BREAKFAST_CITY, i + 1));
            String breakfastState = formData.get(String.format(TrapInputKeys.DAYa_BREAKFAST_STATE, i + 1));
            String breakfastCountry = formData.get(String.format(TrapInputKeys.DAYa_BREAKFAST_COUNTRY, i + 1));
            PerDiem breakfastPerDiem = getPerDiem(breakfastCity, breakfastState, breakfastCountry, dbAccessor);
            if (breakfastPerDiem != null)
            {
                Expense expense = new Expense(ExpenseType.BREAKFAST, date, breakfastPerDiem.getBreakfastRate(), new Location(breakfastCity, breakfastState, breakfastCountry), getNewGrantSet(formData, dbAccessor), null);
                expenses.add(expense);
            }

            String lunchCity = formData.get(String.format(TrapInputKeys.DAYa_LUNCH_CITY, i + 1));
            String lunchState = formData.get(String.format(TrapInputKeys.DAYa_LUNCH_STATE, i + 1));
            String lunchCountry = formData.get(String.format(TrapInputKeys.DAYa_LUNCH_COUNTRY, i + 1));
            PerDiem lunchPerDiem = getPerDiem(lunchCity, lunchState, lunchCountry, dbAccessor);
            if (lunchPerDiem != null)
            {
                Expense expense = new Expense(ExpenseType.LUNCH, date, breakfastPerDiem.getLunchRate(), new Location(lunchCity, lunchState, lunchCountry), getNewGrantSet(formData, dbAccessor), null);
                expenses.add(expense);
            }

            String dinnerCity = formData.get(String.format(TrapInputKeys.DAYa_DINNER_CITY, i + 1));
            String dinnerState = formData.get(String.format(TrapInputKeys.DAYa_DINNER_STATE, i + 1));
            String dinnerCountry = formData.get(String.format(TrapInputKeys.DAYa_DINNER_COUNTRY, i + 1));
            PerDiem dinnerPerDiem = getPerDiem(dinnerCity, dinnerState, dinnerCountry, dbAccessor);
            if (dinnerPerDiem != null)
            {
                Expense expense = new Expense(ExpenseType.DINNER, date, breakfastPerDiem.getDinnerRate(), new Location(dinnerCity, dinnerState, dinnerCountry), getNewGrantSet(formData, dbAccessor), null);
                expenses.add(expense);
            }
            String incidentalCity = formData.get(String.format(TrapInputKeys.DAYa_INCIDENTAL_CITY, i + 1));
            String incidentalState = formData.get(String.format(TrapInputKeys.DAYa_INCIDENTAL_STATE, i + 1));
            String incidentalCountry = formData.get(String.format(TrapInputKeys.DAYa_INCIDENTAL_COUNTRY, i + 1));
            PerDiem incidentalPerdiem = getPerDiem(incidentalCity, incidentalState, incidentalCountry, dbAccessor);
            if (incidentalPerdiem != null)
            {
                Double incidentalAmount = Double.parseDouble(formData.get(String.format(TrapInputKeys.DAYa_INCIDENTAL_AMOUNT, i + 1)));
                String incidentalCurrency = formData.get(String.format(TrapInputKeys.DAYa_INCIDENTAL_CURRENCY, i + 1));
                String incidentalJustification = formData.get(String.format(TrapInputKeys.DAYa_INCIDENTAL_JUSTIFICATION, i + 1));
                Double incidentalAmountUSD = dbAccessor.getUsd(incidentalCurrency, incidentalAmount, date);
                if (incidentalAmount > incidentalPerdiem.getIncidentalCeiling())
                {
                    throw new TrapException("Incidental amount too high");
                }
                Expense expense = new Expense(ExpenseType.INCIDENTAL, date, incidentalAmountUSD, new Location(incidentalCity, incidentalState, incidentalCountry), getNewGrantSet(formData, dbAccessor), incidentalJustification);
                expenses.add(expense);
            }

            String lodgingCity = formData.get(String.format(TrapInputKeys.DAYa_LODGING_CITY, i + 1));
            String lodgingState = formData.get(String.format(TrapInputKeys.DAYa_LODGING_STATE, i + 1));
            String lodgingCountry = formData.get(String.format(TrapInputKeys.DAYa_LODGING_COUNTRY, i + 1));
            PerDiem lodgingPerDiem = getPerDiem(lodgingCity, lodgingState, lodgingCountry, dbAccessor);
            if (lodgingPerDiem != null)
            {
                double lodgingAmount = Double.parseDouble(formData.get(String.format(TrapInputKeys.DAYa_LODGING_AMOUNT, i + 1)));
                String lodgingCurrency = formData.get(String.format(TrapInputKeys.DAYa_LODGING_CURRENCY, i + 1));
                Double lodgingAmountUSD = dbAccessor.getUsd(lodgingCurrency, lodgingAmount, date);
                if (lodgingAmountUSD > lodgingPerDiem.getLodgingCeiling())
                {
                    throw new TrapException("lodging amount too high");
                }
                Expense expense = new Expense(ExpenseType.LODGING, date, lodgingAmountUSD, new Location(lodgingCity, lodgingState, lodgingCountry), getNewGrantSet(formData, dbAccessor), null);
                expenses.add(expense);
            }

        }

        final int numXport = Integer.parseInt(formData.get(TrapInputKeys.NUM_TRANSPORTATION));
        for (int i = 0; i < numXport; i++)
        {
            Date transportationDate = TrapDateUtil.parseTrapDate(formData.get(String.format(TrapInputKeys.TRANSPORTATIONb_DATE, i + 1)));
            String transportationType = formData.get(String.format(TrapInputKeys.TRANSPORTATIONb_TYPE, i + 1));
            boolean isRental = StringUtils.equals(formData.get(String.format(TrapInputKeys.TRANSPORTATIONb_RENTAL, i + 1)), null);
            String carrier = formData.get(String.format(TrapInputKeys.TRANSPORTATIONb_CARRIER, i + 1));
            String milesTravelStr = formData.get(String.format(TrapInputKeys.TRANSPORTATIONb_MILES_TRAVELED, i + 1));
            Integer milesTraveled = null;
            if (milesTravelStr != null)
            {
                milesTraveled  = Integer.parseInt(milesTravelStr);
            }
            double transportationAmount = Double.parseDouble(formData.get(String.format(TrapInputKeys.TRANSPORTATIONb_AMOUNT, i + 1)));
            String transportationCurrensy = formData.get(String.format(TrapInputKeys.TRANSPORTATIONb_CURRENCY, i + 1));
            double transportationAmountUSD = dbAccessor.getUsd(transportationCurrensy, transportationAmount, transportationDate);
            Expense expense = new TransportationExpense(ExpenseType.TRANSPORTATION, transportationDate, transportationAmountUSD, null, getNewGrantSet(formData, dbAccessor), null, transportationType, carrier, milesTraveled, isRental);
            expenses.add(expense);
        }

        /*
         * NUM_OTHER_EXPENSES
         */
        final int numOther = Integer.parseInt(formData.get(TrapInputKeys.NUM_OTHER_EXPENSES));
        for (int i = 0; i < numOther; i++)
        {
            Date otherDate = TrapDateUtil.parseTrapDate(formData.get(String.format(TrapInputKeys.OTHERc_DATE, i + 1)));
            String otherJustification = formData.get(String.format(TrapInputKeys.OTHERc_JUSTIFICATION, i + 1));
            Double otherAmount = Double.parseDouble(formData.get(String.format(TrapInputKeys.OTHERc_AMOUNT, i + 1)));
            String otherCurrency = formData.get(String.format(TrapInputKeys.OTHERc_CURRENCY, i + 1));
            Double otherAmountUSD = dbAccessor.getUsd(otherCurrency, otherAmount, otherDate);
            Expense expense = new Expense(ExpenseType.OTHER, otherDate, otherAmountUSD, null, getNewGrantSet(formData, dbAccessor), otherJustification);
            expenses.add(expense);
        }

        return expenses;
    }

    /**
     * @param breakfastCity
     * @param breakfastState
     * @param breakfastCountry
     * @return
     * @throws TrapException
     */
    private static PerDiem getPerDiem(String city, String state, String country, DatabaseAccessor dbAccessor) throws TrapException
    {
        PerDiem perDiem = null;
        if (state != null)
        {
            if (city != null)
            {
                dbAccessor.getDomesticPerdiem(city, state);
            } else
            {
                dbAccessor.getDomesticPerdiem(state);
            }
        } else if (country != null)
        {
            if (city != null)
            {
                perDiem = dbAccessor.getIntlPerdiem(city, country);
            } else
            {
                perDiem = dbAccessor.getIntlPerdiem(country);
            }
        }
        return perDiem;
    }

    /**
     * @param formData
     * @return
     */
    private static FormUser getNewUser(Map<String, String> formData, DatabaseAccessor dbAccessor) throws Exception
    {
        String userName = formData.get(TrapInputKeys.USER_NAME);
        String emergencyContactName = formData.get(TrapInputKeys.EMERGENCY_CONTACT_NAME);
        String emergencyContactPhone = formData.get(TrapInputKeys.EMERGENCY_CONTACT_PHONE);
        User user = dbAccessor.getUser(userName);
        return new FormUser(userName, emergencyContactName, emergencyContactPhone, user.getFullName(), user.getEmail(), user.getEmployeeId(), user.getCitizenship(), user.getVisaStatus(), user.isPaidByUniversity());
    }

    /**
     * @param formData
     * @param dbAccessor
     * @return
     */
    private static GrantSet getNewGrantSet(Map<String, String> formData, DatabaseAccessor dbAccessor) throws Exception
    {
        int numGrants = Integer.parseInt(formData.get(TrapInputKeys.NUM_GRANTS));
        Set<FormGrant> grants = new HashSet<FormGrant>();
        for (int i = 0; i < numGrants; i++)
        {
            String accountName = formData.get(String.format(TrapInputKeys.GRANTd_ACCOUNT, i + 1));
            Grant grant = dbAccessor.getGrant(accountName);
            UserGrant ug = dbAccessor.getUserGrant(accountName);
            FormGrant formGrant = new FormGrant(accountName, grant.getAccountType(), grant.getFundingOrganization(), grant.getAccountBalance(), grant.getOrganizationType(), ug.getGrantAdmin(), ug.getAuthorizedPayees());
            grants.add(formGrant);
        }
        return new GrantSet(grants);
    }

    /**
     * @return
     */
    private static Integer generateId()
    {
        return new Integer((int) Math.floor((Math.random() * 100000000)));
    }

    /**
     * @param formData
     * @return
     * @throws TrapException
     */
    private static Trip getNewTrip(Map<String, String> formData) throws Exception
    {
        Date departureDateTime = TrapDateUtil.parseTrapDateTime(formData.get(TrapInputKeys.DEPARTURE_DATETIME));
        Date arrivalDateTime = TrapDateUtil.parseTrapDateTime(formData.get(TrapInputKeys.ARRIVAL_DATETIME));
        boolean travelTypeCseSponsored = StringUtils.equals(formData.get(TrapInputKeys.TRAVEL_TYPE_CSE_SPONSORED), "yes");
        boolean travelTypeDtcSponsored = StringUtils.equals(formData.get(TrapInputKeys.TRAVEL_TYPE_DTC_SPONSORED), "yes");
        boolean travelTypeNonsponsored = StringUtils.equals(formData.get(TrapInputKeys.TRAVEL_TYPE_NONSPONSORED), "yes");
        String justificationConferenceTitle = formData.get(TrapInputKeys.JUSTIFICATION_CONFERENCE_TITLE);
        boolean justificationPresented = StringUtils.equals(formData.get(TrapInputKeys.JUSTIFICATION_PRESENTED), "yes");
        String justificationPresentationTitle = formData.get(TrapInputKeys.JUSTIFICATION_PRESENTATION_TITLE);
        String justificationPresentationAbstract = formData.get(TrapInputKeys.JUSTIFICATION_PRESENTATION_ABSTRACT);
        String justificationPresentationAcknowledgement = formData.get(TrapInputKeys.JUSTIFICATION_PRESENTATION_ACKNOWLEDGEMENT);
        String justificationNonsponsored = formData.get(TrapInputKeys.JUSTIFICATION_NONSPONSORED);
        String justificationSponsored = formData.get(TrapInputKeys.JUSTIFICATION_SPONSORED);
        int numDays = Integer.parseInt(formData.get(TrapInputKeys.NUM_DAYS));
        return new Trip(departureDateTime, arrivalDateTime, travelTypeCseSponsored, travelTypeDtcSponsored, travelTypeNonsponsored, justificationConferenceTitle, justificationPresented, justificationPresentationTitle, justificationPresentationAbstract, justificationPresentationAcknowledgement, justificationNonsponsored, justificationSponsored, numDays);
    }
}