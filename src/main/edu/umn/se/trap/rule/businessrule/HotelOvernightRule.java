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

/**
 * @author Mark
 * 
 *         From the TRAP Design Document:
 * 
 *         Requirement: 10 
 *         Description: This rule checks that a hotel is not
 *         claimed for a trip less than one day long.
 * 
 */
public class HotelOvernightRule extends AbstractRule
{

    private final int DAY_LENGTH = 86400000;

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

            checkHotel(departureTime, arrivalTime, expenses);
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
    protected void checkHotel(Date departureTime, Date arrivalTime,
            List<Expense> expenses) throws TrapException
    {

        // Only consider trips that are less than 1 day (24 hours).
        if ((arrivalTime.getTime() - departureTime.getTime()) < DAY_LENGTH)
        {
            for (Expense expense : expenses)
            {
                if (expense.getType().equals(ExpenseType.LODGING))
                {
                    throw new TrapException(
                            "Lodging expenses cannot be claimed for a trip less than 1 day.");
                }
            }
        }

    }

}
