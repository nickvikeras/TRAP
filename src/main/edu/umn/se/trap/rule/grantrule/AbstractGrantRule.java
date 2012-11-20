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

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.form.Expense;
import edu.umn.se.trap.form.TrapForm;
import edu.umn.se.trap.rule.AbstractRule;

/**
 * @author nick
 * 
 */
public abstract class AbstractGrantRule extends AbstractRule
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
        for (Expense expense : form.getExpenses())
        {
            removeGrants(expense);
            if (expense.getEligibleGrants().getGrants().isEmpty())
            {
                throw new TrapException("No grants can cover one or more expenses.");
            }
        }
    }

    /**
     * @param expense
     */
    protected abstract void removeGrants(Expense expense);

}
