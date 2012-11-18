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
package edu.umn.se.trap.db.orm;

/**
 * @author nick
 * 
 */
public class PerDiem
{
    private Double breakfastRate;
    private Double lunchRate;
    private Double dinnerRate;
    private Double incidentalCeiling;
    private Double lodgingCeiling;

    /**
     * @param breakfastRate
     * @param lunchRate
     * @param dinnerRate
     * @param incidentalCeiling
     * @param lodgingCeiling
     */
    public PerDiem(Double breakfastRate, Double lunchRate, Double dinnerRate, Double incidentalCeiling, Double lodgingCeiling)
    {
	super();
	this.breakfastRate = breakfastRate;
	this.lunchRate = lunchRate;
	this.dinnerRate = dinnerRate;
	this.incidentalCeiling = incidentalCeiling;
	this.lodgingCeiling = lodgingCeiling;
    }

    /**
     * @return the breakfastRate
     */
    public Double getBreakfastRate()
    {
	return breakfastRate;
    }

    /**
     * @param breakfastRate
     *            the breakfastRate to set
     */
    public void setBreakfastRate(Double breakfastRate)
    {
	this.breakfastRate = breakfastRate;
    }

    /**
     * @return the lunchRate
     */
    public Double getLunchRate()
    {
	return lunchRate;
    }

    /**
     * @param lunchRate
     *            the lunchRate to set
     */
    public void setLunchRate(Double lunchRate)
    {
	this.lunchRate = lunchRate;
    }

    /**
     * @return the dinnerRate
     */
    public Double getDinnerRate()
    {
	return dinnerRate;
    }

    /**
     * @param dinnerRate
     *            the dinnerRate to set
     */
    public void setDinnerRate(Double dinnerRate)
    {
	this.dinnerRate = dinnerRate;
    }

    /**
     * @return the incidentalCeiling
     */
    public Double getIncidentalCeiling()
    {
	return incidentalCeiling;
    }

    /**
     * @param incidentalCeiling
     *            the incidentalCeiling to set
     */
    public void setIncidentalCeiling(Double incidentalCeiling)
    {
	this.incidentalCeiling = incidentalCeiling;
    }

    /**
     * @return the lodgingCeiling
     */
    public Double getLodgingCeiling()
    {
	return lodgingCeiling;
    }

    /**
     * @param lodgingCeiling
     *            the lodgingCeiling to set
     */
    public void setLodgingCeiling(Double lodgingCeiling)
    {
	this.lodgingCeiling = lodgingCeiling;
    }
}
