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
import edu.umn.se.trap.form.TransportationType;
import edu.umn.se.trap.form.TrapForm;
import edu.umn.se.trap.rule.AbstractRule;
import edu.umn.se.trap.util.TrapErrors;
import edu.umn.se.trap.util.TrapUtil;

/**
 * @author Mark
 * 
 *         From the TRAP Design Document:
 * 
 *         Requirement: 11 
 *         Description: This rule checks that a US air carrier
 *         is being used.
 * 
 */
public class USCarrierRule extends AbstractRule
{
    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.umn.se.trap.rule.AbstractRule#validateRule(edu.umn.se.trap.form.TrapForm
     * )
     */
    @Override
    public void validateRule(TrapForm form) throws TrapException
    {
        if (form != null)
        {
            checkCarrier(form.getExpenses());

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
    protected void checkCarrier(List<Expense> expenses) throws TrapException
    {

        for (Expense expense : expenses)
        {
            if (expense.getType().equals(ExpenseType.TRANSPORTATION))
            {
                // Check to see that the expense is an AIR type.
                if (StringUtils.equalsIgnoreCase(
                        ((TransportationExpense) expense)
                                .getTranportationType(), "AIR"))
                {

                    // Check to see that the air carrier is a US Carrier.
                    if (checkCarrierString(((TransportationExpense) expense)
                            .getCarrier()))
                    {
                    }
                    else
                    {
                        throw new TrapException(
                                TrapErrors.US_CARRIER_ONLY);
                    }
                }
            }
        }

    }

    /**
     * @param carrier
     */
    protected boolean checkCarrierString(String carrier)
    {

        // Return false if the carrier is not one of the US carriers.

        for (int i = 0; i < TrapUtil.USCARRIERS.length; i++)
        {
            if (StringUtils.equalsIgnoreCase(carrier,TrapUtil.USCARRIERS[i]))
            {
                return true;
            }
        }

        return false;
    }

}
