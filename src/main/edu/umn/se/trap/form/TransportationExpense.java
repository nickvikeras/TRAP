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
    private String tranportationType;
    private String carrier;
    private int milesTraveled;
    private boolean isRental;

    /**
     * @param type
     * @param date
     * @param amount
     * @param currency
     * @param location
     * @param eligibleGrants
     * @param justification
     */
    public TransportationExpense(ExpenseType type, Date date, double amount, Location location, GrantSet eligibleGrants, String justification, String tranportationType, String carrier, int milesTraveled, boolean isRental)
    {
	super(type, date, amount, location, eligibleGrants, justification);
	this.tranportationType = tranportationType;
	this.carrier = carrier;
	this.milesTraveled = milesTraveled;
	this.setRental(isRental);
    }

    // Getters and setters:

    /**
     * @return the tranportationType
     */
    public String getTranportationType()
    {
	return tranportationType;
    }

    /**
     * @param tranportationType
     *            the tranportationType to set
     */
    public void setTranportationType(String tranportationType)
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

    /**
     * @return the isRental
     */
    public boolean isRental()
    {
	return isRental;
    }

    /**
     * @param isRental the isRental to set
     */
    public void setRental(boolean isRental)
    {
	this.isRental = isRental;
    }

}