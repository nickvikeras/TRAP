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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

import edu.umn.se.trap.TravelFormMetadata;
import edu.umn.se.trap.TravelFormProcessorIntf.FORM_STATUS;
import edu.umn.se.trap.calculator.TrapException;

/**
 * @author mark
 * 
 */
public class FormFactory
{

    public static TrapForm getNewForm(final Map<String, String> formData, String description) throws TrapException
    {
	Integer id = generateId();
	return getNewForm(formData, description, id);
    }

    public static TrapForm getNewForm(final Map<String, String> formData, String description, Integer id) throws TrapException
    {
	try
	{
	    TravelFormMetadata travelFormMetaData = new TravelFormMetadata(description, FORM_STATUS.DRAFT);
	    GrantSet grantSet = getNewGrantSet(formData);
	    User user = getNewUser(formData);
	    Trip trip = getNewTrip(formData);
	    List<Expense> expenses = getNewExpenseList(formData);
	    Map<Integer, Double> accountToPercentMap = getNewAccountToPercentMap(formData);
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
    private static Map<Integer, Double> getNewAccountToPercentMap(Map<String, String> formData) throws Exception
    {
	Map<Integer, Double> accountToPercentMap = new HashMap<Integer, Double>();
	Integer numGrants = Integer.parseInt(formData.get(TrapInputKeys.NUM_GRANTS));
	for (int i = 0; i < numGrants; i++)
	{
	    Integer accountNumber = Integer.parseInt(formData.get(String.format(TrapInputKeys.GRANTd_ACCOUNT, i)));
	    Double percentToCharge = Double.parseDouble(formData.get(String.format(TrapInputKeys.GRANTd_ACCOUNT, i)));
	    accountToPercentMap.put(accountNumber, percentToCharge);
	}
	return accountToPercentMap;
    }

    /**
     * @param formData
     * @return
     */
    private static List<Expense> getNewExpenseList(Map<String, String> formData) throws Exception
    {
	// TODO Auto-generated method stub
	return null;
    }

    /**
     * @param formData
     * @return
     */
    private static User getNewUser(Map<String, String> formData) throws Exception
    {
	String userName = formData.get(TrapInputKeys.USER_NAME);
	String emergencyContactName = formData.get(TrapInputKeys.EMERGENCY_CONTACT_NAME);
	String emergencyContactPhone = formData.get(TrapInputKeys.EMERGENCY_CONTACT_PHONE);
	return new User(userName, emergencyContactName, emergencyContactPhone);
    }

    /**
     * @param formData
     * @return
     */
    private static GrantSet getNewGrantSet(Map<String, String> formData) throws Exception
    {
	// TODO Auto-generated method stub
	return null;
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
	Date departureDateTime = getTrapDateTime(formData.get(TrapInputKeys.ARRIVAL_DATETIME));
	Date arrivalDateTime = getTrapDateTime(formData.get(TrapInputKeys.ARRIVAL_DATETIME));
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

    /**
     * @param string
     * @return
     * @throws TrapException
     */
    private static Date getTrapDateTime(final String dateString) throws ParseException
    {
	final String formatString = "yyyymmdd hhMMss";
	return parseDate(dateString, formatString);
    }

    /**
     * @param string
     * @return
     * @throws TrapException
     */
    private static Date getTrapDate(final String dateString) throws ParseException
    {
	final String formatString = "yyyymmdd";
	return parseDate(dateString, formatString);
    }

    private static Date parseDate(final String dateString, final String formatString) throws ParseException
    {
	DateFormat dateFormat = new SimpleDateFormat(formatString);
	return dateFormat.parse(dateString);

    }

}