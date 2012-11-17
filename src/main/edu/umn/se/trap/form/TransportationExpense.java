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
 * @author mark
 * 
 */
public class TransportationExpense extends Expense
{

    // Public member variables:
    private TransportationType tranportationType;
    private String carrier;
    private int milesTraveled;

    /**
     * @param type
     * @param date
     * @param amount
     * @param currency
     * @param location
     * @param eligibleGrants
     * @param justification
     */
    public TransportationExpense(ExpenseType type, Date date, double amount,
	    String currency, Location location, GrantSet eligibleGrants,
	    String justification, TransportationType tranportationType,
	    String carrier, int milesTraveled)
    {
	super(type, date, amount, currency, location, eligibleGrants, justification);
	this.tranportationType = tranportationType;
	this.carrier = carrier;
	this.milesTraveled = milesTraveled;
    }

    // Getters and setters:

    /**
     * @return the tranportationType
     */
    public TransportationType getTranportationType()
    {
	return tranportationType;
    }

    /**
     * @param tranportationType
     *            the tranportationType to set
     */
    public void setTranportationType(TransportationType tranportationType)
    {
	this.tranportationType = tranportationType;
    }

    /**
     * @return the carrier
     */
    public String getCarrier()
    {
	return carrier;
    }

    /**
     * @param carrier
     *            the carrier to set
     */
    public void setCarrier(String carrier)
    {
	this.carrier = carrier;
    }

    /**
     * @return the milesTraveled
     */
    public int getMilesTraveled()
    {
	return milesTraveled;
    }

    /**
     * @param milesTraveled
     *            the milesTraveled to set
     */
    public void setMilesTraveled(int milesTraveled)
    {
	this.milesTraveled = milesTraveled;
    }

}