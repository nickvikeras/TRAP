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
public class Grant
{

    // Public member variables:
    private Integer accountNumber;
    private AccountType accountType;
    private String fundingOrganization;
    private Double accountBalance;

    // Getters and setters:
    
    /**
     * @return the accountNumber
     */
    public Integer getAccountNumber()
    {
        return accountNumber;
    }

    /**
     * @param accountNumber
     *            the accountNumber to set
     */
    public void setAccountNumber(Integer accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the accountType
     */
    public AccountType getAccountType()
    {
        return accountType;
    }

    /**
     * @param accountType
     *            the accountType to set
     */
    public void setAccountType(AccountType accountType)
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