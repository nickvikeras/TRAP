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
import java.util.Map.Entry;

import edu.umn.se.trap.calculator.TrapCalculator;
import edu.umn.se.trap.db.CurrencyDB;
import edu.umn.se.trap.db.FormData;
import edu.umn.se.trap.db.GrantDB;
import edu.umn.se.trap.db.PerDiemDB;
import edu.umn.se.trap.db.UserDB;
import edu.umn.se.trap.db.UserGrantDB;
import edu.umn.se.trap.db.orm.DatabaseAccessor;
import edu.umn.se.trap.form.TrapForm;
import edu.umn.se.trap.form.TrapFormFactory;
import edu.umn.se.trap.output.TrapOutputBuilder;
import edu.umn.se.trap.rule.FormChecker;
import edu.umn.se.trap.rule.FormCheckerFactory;

/** Implements the provided TravelFormProcessoriIntf
 * @author nick
 * 
 */
public class TravelFormProcessor implements TravelFormProcessorIntf
{
    private String userId;
    private DatabaseAccessor databaseAccessor;

    /**
     * Constructor -- uses parameters to allow for unit testing.
     * 
     * @param userDB
     *            the user database table abstraction.
     * @param perDiemDB
     *            the perDiem DB table abstraction.
     * @param grantDB
     *            the grant DB table abstraction.
     * @param userGrantDB
     *            the user to grant DB table abstraction.
     * @param currencyDB
     *            the table abstraction for the currency DB.
     */
    public TravelFormProcessor(UserDB userDB, PerDiemDB perDiemDB,
            GrantDB grantDB, UserGrantDB userGrantDB, CurrencyDB currencyDB)
    {
        this.databaseAccessor = new DatabaseAccessor(userDB, perDiemDB,
                grantDB, userGrantDB, currencyDB);
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
        FormData data = databaseAccessor.getFormDB().getForm(formId);
        if (data == null || data.getInput() == null)
        {
            throw new TrapException("No form with id " + formId + " found.");
        }
        return data.getInput();
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
        TravelFormMetadata metaData = new TravelFormMetadata();
        metaData.description = description;
        metaData.status = FORM_STATUS.DRAFT;
        FormData data = new FormData(formData, null, metaData);
        Integer formId = generateFormId();
        databaseAccessor.getFormDB().saveForm(data, formId);
        return formId;
    }

    /**
     * @return
     */
    private Integer generateFormId()
    {
        return new Integer((int) Math.floor((Math.random() * 100000000)));
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
        FormData savedData = databaseAccessor.getFormDB().getForm(id);
        savedData.setInput(formData);
        databaseAccessor.getFormDB().saveForm(savedData, id);
        return id;
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

        //

        FormData data = databaseAccessor.getFormDB().getForm(formId);
        TrapForm form = TrapFormFactory.getNewForm(data.getInput(),
                data.getMetadata().description, formId, databaseAccessor);
        FormChecker wellFormedChecker = FormCheckerFactory
                .createWellFormedChecker();
        FormChecker businessRuleChecker = FormCheckerFactory
                .createBusinessRuleChecker();
        FormChecker grantRuleChecker = FormCheckerFactory
                .createGrantRuleChecker();

        wellFormedChecker.fireRules(form);
        businessRuleChecker.fireRules(form);
        grantRuleChecker.fireRules(form);

        Map<String, Double> amountsToCharge = TrapCalculator
                .calculateAmountsToCharge(form);
        chargeAccounts(amountsToCharge);

        Map<String, String> output = TrapOutputBuilder.buildOutput(form,
                amountsToCharge);

        data.setOutput(output);
        data.getMetadata().status = FORM_STATUS.SUBMITTED;
        databaseAccessor.getFormDB().saveForm(data, formId);
    }

    /**
     * @param amountsToCharge
     * @throws TrapException
     */
    private void chargeAccounts(Map<String, Double> amountsToCharge)
            throws TrapException
    {
        for (Entry<String, Double> entry : amountsToCharge.entrySet())
        {
            String accountName = entry.getKey();
            Double amountToCharge = entry.getValue();
            this.databaseAccessor.chargeAccount(accountName, amountToCharge);
        }

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

        FormData data = databaseAccessor.getFormDB().getForm(formId);
        if (data == null || data.getOutput() == null)
        {
            throw new TrapException("Form has not been completed.");
        }

        return data.getOutput();
    }

}
