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

import java.util.Date;

/**
 * @author Mark
 * 
 *         Contains all of the information about a Trap expense.
 * 
 */
public class Expense
{

    // private member variables:
    private Date date;
    private double amount;
    private Location location;
    private GrantSet eligibleGrants;
    private String justification;
    private ExpenseType type;

    /**
     * @param type
     * @param date
     * @param amount
     * @param currency
     * @param location
     * @param eligibleGrants
     * @param justification
     */
    public Expense(ExpenseType type, Date date, double amount,
            Location location, GrantSet eligibleGrants, String justification)
    {
        super();
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.location = location;
        this.eligibleGrants = eligibleGrants;
        this.justification = justification;
    }

    // Getters and setters:

    /**
     * @return the type
     */
    public ExpenseType getType()
    {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(ExpenseType type)
    {
        this.type = type;
    }

    /**
     * @return the date
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * @return the amount
     */
    public double getAmount()
    {
        return amount;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    /**
     * @return the location
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * @param location
     *            the location to set
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }

    /**
     * @return the eligibleGrants
     */
    public GrantSet getEligibleGrants()
    {
        return eligibleGrants;
    }

    /**
     * @param eligibleGrants
     *            the eligibleGrants to set
     */
    public void setEligibleGrants(GrantSet eligibleGrants)
    {
        this.eligibleGrants = eligibleGrants;
    }

    /**
     * @return the justification
     */
    public String getJustification()
    {
        return justification;
    }

    /**
     * @param justification
     *            the justification to set
     */
    public void setJustification(String justification)
    {
        this.justification = justification;
    }

}