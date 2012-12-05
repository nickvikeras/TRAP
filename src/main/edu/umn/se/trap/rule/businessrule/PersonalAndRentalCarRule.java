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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.form.Expense;
import edu.umn.se.trap.form.ExpenseType;
import edu.umn.se.trap.form.TransportationExpense;
import edu.umn.se.trap.form.TrapForm;
import edu.umn.se.trap.rule.AbstractRule;
import edu.umn.se.trap.util.TrapDateUtil;
import edu.umn.se.trap.util.TrapErrors;

/**
 * @author Andrew
 * 
 */
public class PersonalAndRentalCarRule extends AbstractRule
{

    @Override
    public void validateRule(TrapForm form) throws TrapException
    {
        if (form != null)
        {
            checkCarRentals(form.getExpenses());

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
    protected void checkCarRentals(List<Expense> expenses) throws TrapException
    {
        ArrayList<TransportationExpense> personal = new ArrayList<TransportationExpense>(
                expenses.size());
        ArrayList<TransportationExpense> rental = new ArrayList<TransportationExpense>(
                expenses.size());

        for (Expense expense : expenses)
        {
            if (expense.getType().equals(ExpenseType.TRANSPORTATION))
            {

                if (StringUtils.equalsIgnoreCase(
                        ((TransportationExpense) expense)
                                .getTranportationType(), "Car"))
                {
                    if (((TransportationExpense) expense).isRental())
                    {
                        rental.add(((TransportationExpense) expense));
                    }

                    else
                    {
                        personal.add(((TransportationExpense) expense));
                    }

                }
            }
        }
        personal.trimToSize();
        rental.trimToSize();

        if (rental.size() != 0 && personal.size() != 0)
        {
            for (TransportationExpense pcar : personal)
            {
                for (TransportationExpense rcar : rental)
                {
                    if (TrapDateUtil.sameDay(pcar.getDate(), rcar.getDate()))
                    {
                        throw new TrapException(TrapErrors.PERSONAL_RENTAL_CAR);
                    }

                }

            }

        }

    }

}
