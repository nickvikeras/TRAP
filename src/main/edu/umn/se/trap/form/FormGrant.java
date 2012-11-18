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


/**
 * @author mark
 * 
 */
public class FormGrant
{

    // Public member variables:
    private String accountName;
    private String accountType;
    private String fundingOrganization;
    private Double accountBalance;

    // Getters and setters:
    
    /**
     * @param accountNumber
     * @param accountType
     * @param fundingOrganization
     * @param accountBalance
     */
    public FormGrant(String accountName, String accountType,
            String fundingOrganization, Double accountBalance)
    {
	super();
	this.accountName = accountName;
	this.accountType = accountType;
	this.fundingOrganization = fundingOrganization;
	this.accountBalance = accountBalance;
    }

    /**
     * @return the accountNumber
     */
    public String getAccountName()
    {
        return accountName;
    }

    /**
     * @param accountNumber
     *            the accountNumber to set
     */
    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }

    /**
     * @return the accountType
     */
    public String getAccountType()
    {
        return accountType;
    }

    /**
     * @param accountType
     *            the accountType to set
     */
    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    /**
     * @return the fundingOrganization
     */
    public String getFundingOrganization()
    {
        return fundingOrganization;
    }

    /**
     * @param fundingOrganization
     *            the fundingOrganization to set
     */
    public void setFundingOrganization(String fundingOrganization)
    {
        this.fundingOrganization = fundingOrganization;
    }

    /**
     * @return the accountBalance
     */
    public Double getAccountBalance()
    {
        return accountBalance;
    }

    /**
     * @param accountBalance
     *            the accountBalance to set
     */
    public void setAccountBalance(Double accountBalance)
    {
        this.accountBalance = accountBalance;
    }

}