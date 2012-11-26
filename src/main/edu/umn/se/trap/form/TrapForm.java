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
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.print.attribute.standard.Destination;

import org.apache.commons.lang3.StringUtils;

import edu.umn.se.trap.TrapOutputKeys;
import edu.umn.se.trap.TravelFormMetadata;

/**
 * @author nick
 * 
 */
public class TrapForm
{

    // Private member variables:
    private Integer formId;
    private Map<String, String> formInput;
    private Map<String, String> formOutput;
    private TravelFormMetadata formMetaData;
    private GrantSet grantSet;
    private FormUser user;
    private Trip trip;
    private List<Expense> expenses;
    private Map<String, Double> accountToPercentMap;
    private Date submissionDate;
    private List<Destination> destinations;

    /**
     * @param formId
     * @param formInput
     * @param formOutput
     * @param formMetaData
     * @param grantSet
     * @param user
     * @param trip
     * @param expenses
     * @param accountToPercentMap
     */
    public TrapForm(Integer formId, Map<String, String> formInput,
            Map<String, String> formOutput, TravelFormMetadata formMetaData,
            GrantSet grantSet, FormUser user, Trip trip,
            List<Expense> expenses, Map<String, Double> accountToPercentMap,
            Date submissionDate)
    {
        super();
        this.formId = formId;
        this.formInput = formInput;
        this.formOutput = formOutput;
        this.formMetaData = formMetaData;
        this.grantSet = grantSet;
        this.user = user;
        this.trip = trip;
        this.expenses = expenses;
        this.accountToPercentMap = accountToPercentMap;
        this.submissionDate = submissionDate;
    }

  
    public List<Expense> getExpensesForType(ExpenseType type)
    {
        List<Expense> expenses = new ArrayList<Expense>();
        for (Expense expense : getExpenses())
        {
            if (expense.getType() == type)
            {
                expenses.add(expense);
            }
        }
        return expenses;
    }

    public List<Day> getDays()
    {
        Date departureDate = getTrip().getDepartureDateTime();
        List<Day> days = new ArrayList<Day>();
        for (int i = 0; i < trip.getNumDays(); i++)
        {

            Calendar cal = new GregorianCalendar();
            cal.setTime(departureDate);
            cal.add(Calendar.DAY_OF_MONTH, i);
            Date date = cal.getTime();
            Double total = 0.0;
            Double incidentalTotal = 0.0;
            String incidentalJustification = "";
            for (Expense expense : getExpenses())
            {
                if (TrapUtil.sameDay(date, expense.getDate()))
                {
                    if (!expense.getType().equals(ExpenseType.TRANSPORTATION))
                    {
                        total += expense.getAmount();
                    }
                    if (expense.getType() == ExpenseType.INCIDENTAL)
                    {
                        incidentalTotal += expense.getAmount();
                        incidentalJustification += expense.getJustification();
                    }
                }
            }
            days.add(new Day(date, total, incidentalTotal,
                    incidentalJustification));
        }
        return days;
    }

    public List<Location> getLocations()
    {
        Set<Location> locations = new HashSet<Location>();
        for (Expense expense : getExpenses())
        {
            if (expense.getLocation() != null)
            {
                locations.add(expense.getLocation());
            }
        }
        List<Location> locationList = new ArrayList<Location>();
        locationList.addAll(locations);
        return locationList;
    }

    /**
     * @return the formId
     */
    public Integer getFormId()
    {
        return formId;
    }

    /**
     * @return the formInput
     */
    public Map<String, String> getFormInput()
    {
        return formInput;
    }

    /**
     * @param formInput
     *            the formInput to set
     */
    public void setFormInput(Map<String, String> formInput)
    {
        this.formInput = formInput;
    }

    /**
     * @return the formOutput
     */
    public Map<String, String> getFormOutput()
    {
        return formOutput;
    }

    /**
     * @param formOutput
     *            the formOutput to set
     */
    public void setFormOutput(Map<String, String> formOutput)
    {
        this.formOutput = formOutput;
    }

    /**
     * @return the formMetaData
     */
    public TravelFormMetadata getFormMetaData()
    {
        return formMetaData;
    }

    /**
     * @param formMetaData
     *            the formMetaData to set
     */
    public void setFormMetaData(TravelFormMetadata formMetaData)
    {
        this.formMetaData = formMetaData;
    }

    /**
     * @return the grantSet
     */
    public GrantSet getGrantSet()
    {
        return grantSet;
    }

    /**
     * @param grantSet
     *            the grantSet to set
     */
    public void setGrantSet(GrantSet grantSet)
    {
        this.grantSet = grantSet;
    }

    /**
     * @return the user
     */
    public FormUser getUser()
    {
        return user;
    }

    /**
     * @param user
     *            the user to set
     */
    public void setUser(FormUser user)
    {
        this.user = user;
    }

    /**
     * @return the trip
     */
    public Trip getTrip()
    {
        return trip;
    }

    /**
     * @param trip
     *            the trip to set
     */
    public void setTrip(Trip trip)
    {
        this.trip = trip;
    }

    /**
     * @return the expenses
     */
    public List<Expense> getExpenses()
    {
        return expenses;
    }

    /**
     * @param expenses
     *            the expenses to set
     */
    public void setExpenses(List<Expense> expenses)
    {
        this.expenses = expenses;
    }

    /**
     * @return the submissionDate
     */
    public Date getSubmissionDate()
    {
        return submissionDate;
    }

    /**
     * @param submissionDate
     *            the submissionDate to set
     */
    public void setSubmissionDate(Date submissionDate)
    {
        this.submissionDate = submissionDate;
    }

    public Map<String, Double> getAccountToPercentMap()
    {
        return this.accountToPercentMap;
    }

}
