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
import edu.umn.se.trap.calculator.TrapCalculator;
import edu.umn.se.trap.calculator.TrapException;
import edu.umn.se.trap.db.CurrencyDB;
import edu.umn.se.trap.db.GrantDB;
import edu.umn.se.trap.db.KeyNotFoundException;
import edu.umn.se.trap.db.PerDiemDB;
import edu.umn.se.trap.db.UserDB;
import edu.umn.se.trap.db.UserGrantDB;
import edu.umn.se.trap.db.orm.DatabaseAccessor;
import edu.umn.se.trap.form.FormFactory;
import edu.umn.se.trap.form.TrapForm;
import edu.umn.se.trap.rule.FormChecker;
import edu.umn.se.trap.rule.FormCheckerFactory;

/**
 * @author nick
 * 
 */
public class TravelFormProcessorImpl implements TravelFormProcessorIntf
{
    private String userId;
    private DatabaseAccessor databaseAccessor;
    
    /**
    * Constructor -- uses parameters to allow for unit testing.
    * @param userDB the user database table abstraction.
    * @param perDiemDB the perDiem DB table abstraction.
    * @param grantDB the grant DB table abstraction.
    * @param userGrantDB the user to grant DB table abstraction.
    * @param currencyDB the table abstraction for the currency DB. */
    public TravelFormProcessorImpl(UserDB userDB, PerDiemDB perDiemDB, GrantDB grantDB, UserGrantDB userGrantDB, CurrencyDB currencyDB)
    {
	this.databaseAccessor = new DatabaseAccessor(userDB, perDiemDB, grantDB, userGrantDB, currencyDB);
    }


    /**
     * 
     */
    @Override
    public void setUser(String userId) throws Exception
    {
	this.userId = userId;

    }

    /*
     * (non-Javadoc)
     * 
     * @see edu.umn.se.trap.TravelFormProcessorIntf#getUser()
     */
    @Override
    public String getUser()
    {
	return userId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see edu.umn.se.trap.TravelFormProcessorIntf#getSavedForms()
     */
    @Override
    public Map<Integer, TravelFormMetadata> getSavedForms() throws Exception
    {
	return databaseAccessor.getFormDB().getSavedForms();
    }

    /*
     * (non-Javadoc)
     * 
     * @see edu.umn.se.trap.TravelFormProcessorIntf#clearSavedForms()
     */
    @Override
    public void clearSavedForms() throws Exception
    {
	databaseAccessor.getFormDB().clear();

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.umn.se.trap.TravelFormProcessorIntf#getSavedFormData(java.lang.Integer
     * )
     */
    @Override
    public Map<String, String> getSavedFormData(Integer formId)
	    throws Exception
    {
	TrapForm form = databaseAccessor.getFormDB().getForm(formId);
	if(form == null){
	    throw new TrapException("No form with id " + formId + " found.");
	}
	return form.getFormInput();
    }

    /*
     * (non-Javadoc)
     * 
     * @see edu.umn.se.trap.TravelFormProcessorIntf#saveFormData(java.util.Map,
     * java.lang.String)
     */
    @Override
    public Integer saveFormData(Map<String, String> formData, String description)
	    throws Exception
    {
	TrapForm form = FormFactory.getNewForm(formData, description, databaseAccessor);
	databaseAccessor.getFormDB().saveForm(form);
	return form.getFormId();
    }

    /*
     * (non-Javadoc)
     * 
     * @see edu.umn.se.trap.TravelFormProcessorIntf#saveFormData(java.util.Map,
     * java.lang.Integer)
     */
    @Override
    public Integer saveFormData(Map<String, String> formData, Integer id)
	    throws Exception
    {
	TrapForm form = databaseAccessor.getFormDB().getForm(id);
	form = FormFactory.getNewForm(formData, form.getFormMetaData().description, id, databaseAccessor);
	databaseAccessor.getFormDB().saveForm(form);
	return form.getFormId();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.umn.se.trap.TravelFormProcessorIntf#submitFormData(java.lang.Integer)
     */
    @Override
    public void submitFormData(Integer formId) throws Exception
    {
	TrapForm form = databaseAccessor.getFormDB().getForm(formId);
	FormChecker wellFormedChecker = FormCheckerFactory.createWellFormedChecker();
	FormChecker businessRuleChecker = FormCheckerFactory.createBusinessRuleChecker();
	FormChecker grantRuleChecker = FormCheckerFactory.createGrantRuleChecker();
	
	wellFormedChecker.fireRules(form);
	businessRuleChecker.fireRules(form);
	grantRuleChecker.fireRules(form);
	
	Map<Integer, Double> amountsToCharge = TrapCalculator.calculateAmountsToCharge(form);	
	chargeAccounts(amountsToCharge);	
	form.buildOutput(amountsToCharge);
    }

    /**
     * @param amountsToCharge
     */
    private void chargeAccounts(Map<Integer, Double> amountsToCharge)
    {
	//for( Entry<Integer, Double> entry : amountsToCharge.entrySet()){
	    
	//}
	//this.grantDB.updateAccountBalance(accountName, newBalance)
	
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.umn.se.trap.TravelFormProcessorIntf#getCompletedForm(java.lang.Integer
     * )
     */
    @Override
    public Map<String, String> getCompletedForm(Integer formId)
	    throws TrapException
    {
	Map<String, String> completedForm  = null;
	try
	{
	   completedForm = databaseAccessor.getFormDB().getForm(formId).getFormOutput();

	} 
	catch (KeyNotFoundException e)
	{
	    throw new TrapException("Form with ID " + formId + " not found.");
	}
	if (completedForm == null)
	{
	    throw new TrapException("Form has not been completed.");
	}
	return completedForm;
    }

}
