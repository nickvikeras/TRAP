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

import java.util.List;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.form.Expense;
import edu.umn.se.trap.form.TrapForm;
import edu.umn.se.trap.rule.AbstractRule;

/** All GrantRules should extend this class.
 * @author nick
 * 
 */
public abstract class AbstractGrantRule extends AbstractRule
{

   /** For each expense, remove any grants from the expense's grant set, that the expense is not eligible for.
    * @param form
    */
    @Override
    public void validateRule(TrapForm form) throws TrapException
    {
        List<Expense> expenses = form.getExpenses();
        for (Expense expense : expenses)
        {
            removeGrants(expense, form);
            if (expense.getEligibleGrants().getGrants().isEmpty())
            {
                throw new TrapException("No grants can cover one or more expenses.");
            }
        }
    }

    /**
     * @param expense
     * @param form TODO
     */
    protected abstract void removeGrants(Expense expense, TrapForm form) throws TrapException;

}
