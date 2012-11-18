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
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.db.CurrencyDB;
import edu.umn.se.trap.db.FormDB;
import edu.umn.se.trap.db.GrantDB;
import edu.umn.se.trap.db.KeyNotFoundException;
import edu.umn.se.trap.db.PerDiemDB;
import edu.umn.se.trap.db.UserDB;
import edu.umn.se.trap.db.UserGrantDB;
import edu.umn.se.trap.form.TrapDateUtil;

/**
 * @author nick
 * 
 */
public class DatabaseAccessor
{
    private UserDB userDB;
    private PerDiemDB perDiemDB;
    private GrantDB grantDB;
    private UserGrantDB userGrantDB;
    private CurrencyDB currencyDB;
    private FormDB formDB = new FormDB();

    /**
     * @param userDB
     * @param perDiemDB
     * @param grantDB
     * @param userGrantDB
     * @param currencyDB
     * @param formDB
     */
    public DatabaseAccessor(UserDB userDB, PerDiemDB perDiemDB, GrantDB grantDB, UserGrantDB userGrantDB, CurrencyDB currencyDB)
    {
        super();
        this.userDB = userDB;
        this.perDiemDB = perDiemDB;
        this.grantDB = grantDB;
        this.userGrantDB = userGrantDB;
        this.currencyDB = currencyDB;
    }

    /**
     * @return the formDB
     */
    public FormDB getFormDB()
    {
        return formDB;
    }

    public User getUser(String userName) throws TrapException
    {
        try
        {
            List<String> userInfo = userDB.getUserInfo(userName);
            String fullName = userInfo.get(1);
            String email = userInfo.get(2);
            String employeeId = userInfo.get(3);
            String citizenship = userInfo.get(4);
            String visaStatus = userInfo.get(5);
            boolean paidByUniversity = StringUtils.equalsIgnoreCase(userInfo.get(6), "yes");
            return new User(userName, fullName, email, employeeId, citizenship, visaStatus, paidByUniversity);
        } catch (KeyNotFoundException e)
        {
            throw new TrapException("");
        }

    }

    public PerDiem getDomesticPerdiem(String state) throws TrapException
    {
        try
        {
            List<Double> perDiem = perDiemDB.getDomesticPerDiem(state);
            Double breakfastRate = perDiem.get(0);
            Double lunchRate = perDiem.get(1);
            Double dinnerRate = perDiem.get(2);
            Double incidentalCeiling = perDiem.get(3);
            Double lodgingCeiling = perDiem.get(4);
            return new PerDiem(breakfastRate, lunchRate, dinnerRate, incidentalCeiling, lodgingCeiling);
        } catch (KeyNotFoundException e)
        {
            throw new TrapException("Cannot find perDiem info");
        }
    }

    public PerDiem getDomesticPerdiem(String city, String state) throws TrapException
    {
        try
        {
            List<Double> perDiem = perDiemDB.getDomesticPerDiem(city, state);
            Double breakfastRate = perDiem.get(0);
            Double lunchRate = perDiem.get(1);
            Double dinnerRate = perDiem.get(2);
            Double incidentalCeiling = perDiem.get(3);
            Double lodgingCeiling = perDiem.get(4);
            return new PerDiem(breakfastRate, lunchRate, dinnerRate, incidentalCeiling, lodgingCeiling);
        } catch (KeyNotFoundException e)
        {
            throw new TrapException("Cannot find perDiem info");
        }
    }

    public PerDiem getIntlPerdiem(String country) throws TrapException
    {
        try
        {
            List<Double> perDiem = perDiemDB.getInternationalPerDiem(country);
            Double breakfastRate = perDiem.get(0);
            Double lunchRate = perDiem.get(1);
            Double dinnerRate = perDiem.get(2);
            Double incidentalCeiling = perDiem.get(3);
            Double lodgingCeiling = perDiem.get(4);
            return new PerDiem(breakfastRate, lunchRate, dinnerRate, incidentalCeiling, lodgingCeiling);
        } catch (KeyNotFoundException e)
        {
            throw new TrapException("Cannot find perDiem info");
        }
    }

    public PerDiem getIntlPerdiem(String city, String country) throws TrapException
    {
        try
        {
            List<Double> perDiem = perDiemDB.getInternationalPerDiem(city, country);
            Double breakfastRate = perDiem.get(0);
            Double lunchRate = perDiem.get(1);
            Double dinnerRate = perDiem.get(2);
            Double incidentalCeiling = perDiem.get(3);
            Double lodgingCeiling = perDiem.get(4);
            return new PerDiem(breakfastRate, lunchRate, dinnerRate, incidentalCeiling, lodgingCeiling);
        } catch (KeyNotFoundException e)
        {
            throw new TrapException("Cannot find perDiem info");
        }
    }

    public Grant getGrant(String accountName) throws TrapException
    {
        try
        {
            List<Object> grantInfo = grantDB.getGrantInfo(accountName);
            String accountType = (String) grantInfo.get(1);
            String fundingOrganization = (String) grantInfo.get(2);
            String organizationType = (String) grantInfo.get(3);
            double accountBalance = (Double) grantInfo.get(4);
            return new Grant(accountName, accountType, fundingOrganization, organizationType, accountBalance);
        } catch (KeyNotFoundException e)
        {
            throw new TrapException("Cannot find perDiem info");
        }
    }

    public UserGrant getUserGrant(String accountName) throws TrapException
    {
        try
        {
            List<String> userGrantInfo = userGrantDB.getUserGrantInfo(accountName);
            String grantAdmin = userGrantInfo.get(1);
            String[] authorizedPayees = StringUtils.split(userGrantInfo.get(2), ", ");
            return new UserGrant(accountName, grantAdmin, authorizedPayees);
        } catch (KeyNotFoundException e)
        {
            throw new TrapException("Cannot find perDiem info");
        }
    }

    public double getUsd(String currency, double amount, Date date) throws TrapException
    {
        try
        {
            if (StringUtils.equals(currency, "USD"))
            {
                return amount;
            } else
            {
                Double conversionRate = currencyDB.getConversion(currency, TrapDateUtil.printDate(date));
                return conversionRate.doubleValue() * amount;
            }

        } catch (KeyNotFoundException e)
        {
            throw new TrapException("Cannot find perDiem info");
        }
    }
}