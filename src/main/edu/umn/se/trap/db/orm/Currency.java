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

import java.util.Date;

/**
 * @author nick
 * 
 */
public class Currency
{
    private String currency;
    private Date date;
    private Double conversionRate;

    /**
     * @param currency
     * @param date
     * @param conversionRate
     */
    public Currency(String currency, Date date, Double conversionRate)
    {
        super();
        this.currency = currency;
        this.date = date;
        this.conversionRate = conversionRate;
    }

    /**
     * @return the currency
     */
    public String getCurrency()
    {
        return currency;
    }

    /**
     * @param currency
     *            the currency to set
     */
    public void setCurrency(String currency)
    {
        this.currency = currency;
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
     * @return the conversionRate
     */
    public Double getConversionRate()
    {
        return conversionRate;
    }

    /**
     * @param conversionRate
     *            the conversionRate to set
     */
    public void setConversionRate(Double conversionRate)
    {
        this.conversionRate = conversionRate;
    }
}
