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

import java.util.Date;
import java.util.List;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.form.Expense;
import edu.umn.se.trap.form.ExpenseType;
import edu.umn.se.trap.form.TrapForm;
import edu.umn.se.trap.form.Trip;
import edu.umn.se.trap.rule.AbstractRule;
import edu.umn.se.trap.util.TrapDateUtil;

/**
 * @author Mark
 * 
 *         From the TRAP Design Document:
 * 
 *         Requirement: 14
 *         Description: This rule checks that all itemized costs fall between
 *         the departure date and the arrival date.
 * 
 */
public class ItemizedCostsBetweenDatesRule extends AbstractRule
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
            Trip trip = form.getTrip();

            if (trip == null)
            {
                throw new TrapException(
                        "Invalid TrapForm object: trip was null.");
            }

            Date arrivalTime = trip.getArrivalDateTime();

            if (arrivalTime == null)
            {
                throw new TrapException(
                        "Invalid TrapForm object: arrivalDateTime was null.");
            }

            Date departureTime = trip.getDepartureDateTime();

            if (departureTime == null)
            {
                throw new TrapException(
                        "Invalid TrapForm object: departureDateTime was null.");
            }

            List<Expense> expenses = form.getExpenses();

            if (expenses == null)
            {
                throw new TrapException(
                        "Invalid TrapForm object: expenses was null.");
            }

            checkItemizedCosts(departureTime, arrivalTime, expenses);
        }
        else
        {

            throw new TrapException("Invalid TrapForm object: form was null.");

        }

    }

    /**
     * @param arrivalTime
     * @param departureTime
     * @param expenses
     * @throws TrapException
     */
    protected void checkItemizedCosts(Date departureTime, Date arrivalTime,
            List<Expense> expenses) throws TrapException
    {

        // Check the date of each expense.
        for (Expense expense : expenses)
        {
            arrivalTime = TrapDateUtil.parseTrapDate(TrapDateUtil
                    .printDate(arrivalTime));
            departureTime = TrapDateUtil.parseTrapDate(TrapDateUtil
                    .printDate(departureTime));
            Date expenseDate = TrapDateUtil.parseTrapDate(TrapDateUtil
                    .printDate(expense.getDate()));
            if (expense.getType() != ExpenseType.OTHER)
            {
                if ((expenseDate.getTime() > arrivalTime.getTime())
                        || (expenseDate.getTime() < departureTime.getTime()))
                {
                    throw new TrapException(
                            "Expenses cannot be claimed outside of the dates of the trip.");
                }
            }
        }

    }

}
