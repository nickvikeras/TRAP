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

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.print.attribute.standard.Destination;

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
    public TrapForm(Integer formId, Map<String, String> formInput, Map<String, String> formOutput, TravelFormMetadata formMetaData, GrantSet grantSet, FormUser user, Trip trip, List<Expense> expenses, Map<String, Double> accountToPercentMap, Date submissionDate)
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

    public void buildOutput(Map<String, Double> accountAmountMap)
    {
        Map<String, String> output = new HashMap<String, String>();
        output.put(TrapOutputKeys.USER_NAME, getUser().getUserName());
        output.put(TrapOutputKeys.EMAIL, getUser().getEmail());
        output.put(TrapOutputKeys.CITIZENSHIP, getUser().getCitizenship());
        output.put(TrapOutputKeys.VISA_STATUS, getUser().getVisaStatus());
        output.put(TrapOutputKeys.FORM_SUBMISSION_DATETIME, TrapDateUtil.printDateTime(getSubmissionDate()));
        output.put(TrapOutputKeys.DEPARTURE_DATETIME, TrapDateUtil.printDateTime(getTrip().getDepartureDateTime()));
        output.put(TrapOutputKeys.ARRIVAL_DATETIME, TrapDateUtil.printDateTime(getTrip().getDepartureDateTime()));
        output.put(TrapOutputKeys.PAID_BY_UNIVERSITY, TrapUtil.boolToYesNo(getUser().isPaidByUniversity()));
        output.put(TrapOutputKeys.EMERGENCY_CONTACT_NAME, getUser().getEmergencyContactName());
        output.put(TrapOutputKeys.EMERGENCY_CONTACT_PHONE, getUser().getEmergencyContactPhone());
        output.put(TrapOutputKeys.TRAVEL_TYPE_CSE_SPONSORED, TrapUtil.boolToYesNo(getTrip().isTravelTypeCseSponsored()));
        output.put(TrapOutputKeys.TRAVEL_TYPE_DTC_SPONSORED, TrapUtil.boolToYesNo(getTrip().isTravelTypeDtcSponsored()));
        output.put(TrapOutputKeys.TRAVEL_TYPE_NONSPONSORED, TrapUtil.boolToYesNo(getTrip().isTravelTypeNonsponsored()));
        output.put(TrapOutputKeys.JUSTIFICATION_CONFERENCE_TITLE, getTrip().getJustificationConferenceTitle());
        output.put(TrapOutputKeys.JUSTIFICATION_PRESENTED, TrapUtil.boolToYesNo(getTrip().isJustificationPresented()));
        output.put(TrapOutputKeys.JUSTIFICATION_PRESENTATION_TITLE, getTrip().getJustificationPresentationTitle());
        output.put(TrapOutputKeys.JUSTIFICATION_PRESENTATION_ABSTRACT, getTrip().getJustificationPresentationAbstract());
        output.put(TrapOutputKeys.JUSTIFICATION_PRESENTATION_ACKNOWLEDGEMENT, getTrip().getJustificationPresentationAcknowledgement());
        output.put(TrapOutputKeys.JUSTIFICATION_NONSPONSORED, getTrip().getJustificationNonsponsored());
        output.put(TrapOutputKeys.JUSTIFICATION_SPONSORED, getTrip().getJustificationSponsored());
        
    }
    
//    public List<Day> getDays()
//    { 
//        
//    }
    
    public List<Location> getLocations()
    {
       Set<Location> locations = new HashSet<Location>();
        for(Expense expense : getExpenses()){
            if(expense.getLocation() != null){
                locations.add(expense.getLocation());
            }
        }
        return Arrays.asList((Location[]) locations.toArray());
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

}
