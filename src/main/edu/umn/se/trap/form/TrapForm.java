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

import java.util.List;
import java.util.Map;

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
            GrantSet grantSet, FormUser user, Trip trip, List<Expense> expenses,
            Map<String, Double> accountToPercentMap)
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
    }

    public void buildOutput(Map<Integer, Double> accountAmountMap){
	
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

}
