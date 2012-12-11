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

package edu.umn.se.trap.rule.businessrule;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.form.Expense;
import edu.umn.se.trap.form.ExpenseType;
import edu.umn.se.trap.form.TransportationExpense;
import edu.umn.se.trap.form.TrapForm;
import edu.umn.se.trap.rule.AbstractRule;
import edu.umn.se.trap.util.TrapErrors;

/**
 * @author Andrew
 * 
 */
public class NumBaggageClaimsRule extends AbstractRule
{

    @Override
    public void validateRule(TrapForm form) throws TrapException
    {
        if (form != null)
        {
            checkNumBaggageClaims(form.getExpenses());

        }
        else
        {
            throw new TrapException("Invalid TrapForm object: form was null.");
        }
    }

    /**
     * @param expenses
     * @throws TrapException
     */
    protected void checkNumBaggageClaims(List<Expense> expenses)
            throws TrapException
    {

        int numClaims = 0;
        int numFlights = 0;

        for (Expense expense : expenses)
        {
            if (expense.getType().equals(ExpenseType.TRANSPORTATION))
            {

                if (StringUtils.equalsIgnoreCase(
                        ((TransportationExpense) expense)
                                .getTranportationType(), "BAGGAGE")
                        || StringUtils.equalsIgnoreCase(
                                ((TransportationExpense) expense)
                                        .getTranportationType(), "LUGGAGE"))
                {
                    numClaims++;

                }
                if (StringUtils.equalsIgnoreCase(
                        ((TransportationExpense) expense)
                                .getTranportationType(), "AIR"))
                {
                    numFlights++;

                }
            }
        }

        if (numFlights < numClaims)
        {
            throw new TrapException(TrapErrors.INVALID_NUM_BAGGAGE);
        }

    }

}
