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

package edu.umn.se.trap.rule.grantrule;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.form.Expense;
import edu.umn.se.trap.form.ExpenseType;
import edu.umn.se.trap.form.FormGrant;
import edu.umn.se.trap.form.GrantSet;
import edu.umn.se.trap.form.Location;
import edu.umn.se.trap.form.TransportationExpense;
import edu.umn.se.trap.form.TrapForm;

/**
 * @author Andrew
 * 
 */

public class ForeignGrantsForeignTravelOnlyRule extends AbstractGrantRule
{

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.umn.se.trap.rule.AbstractRule#validateRule(edu.umn.se.trap.form.TrapForm
     * )
     */
    @Override
    public void removeGrants(Expense expense, TrapForm form)
            throws TrapException
    {

        if (expense != null)
        {
            checkExpenseGrants(expense, form.getExpenses());

        }
        else
        {
            throw new TrapException(
                    "Invalid TrapForm object: expense was null.");
        }

    }

    /**
     * @param expenses
     * @param expenses
     * @throws TrapException
     */
    protected void checkExpenseGrants(Expense expense, List<Expense> expenses)
            throws TrapException
    {

        Location location = expense.getLocation();

        /*
         * If a transportation or other expense has the same date as any other
         * type of expense, then it must have the same location.
         */
        if (location == null
                && (expense.getType().equals(ExpenseType.TRANSPORTATION) || expense
                        .getType().equals(ExpenseType.OTHER)))
        {
            for (Expense ex : expenses)
            {
                if (!(ex.getType().equals(ExpenseType.TRANSPORTATION) || ex
                        .getType().equals(ExpenseType.OTHER)))
                {
                    if (expense.getDate().equals(ex.getDate()))
                    {
                        location = ex.getLocation();
                    }
                }
            }
        }

        if (location != null)
        {

            if (StringUtils.equalsIgnoreCase(location.getCountry(), "USA")
                    || StringUtils.equalsIgnoreCase(location.getCountry(),
                            "United States"))
            {
                GrantSet grantSet = expense.getEligibleGrants();

                if (grantSet == null)
                {
                    throw new TrapException(
                            "Invalid TrapForm object: grantSet was null.");
                }

                Set<FormGrant> grants = grantSet.getGrants();

                if (grants == null)
                {
                    throw new TrapException(
                            "Invalid TrapForm object: grants was null.");
                }

                Set<FormGrant> newGrants = new HashSet<FormGrant>();

                for (FormGrant grant : grants)
                {

                    if (!StringUtils.equalsIgnoreCase(
                            grant.getOrganizationType(), "foreign"))
                    {
                        // Add domestic grants to the newGrants object.
                        newGrants.add(grant);
                    }
                }
                
                // Set the newGrants for the grantSet.
                grantSet.setGrants(newGrants);

            }
        }

    }

}
