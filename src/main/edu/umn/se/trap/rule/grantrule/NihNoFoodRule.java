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

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.form.Expense;
import edu.umn.se.trap.form.ExpenseType;
import edu.umn.se.trap.form.FormGrant;
import edu.umn.se.trap.form.GrantSet;
import edu.umn.se.trap.form.TransportationExpense;

/**
 * @author Mark
 *
 */
public class NihNoFoodRule extends AbstractGrantRule
{

    /* (non-Javadoc)
     * @see edu.umn.se.trap.rule.grantrule.AbstractGrantRule#removeGrants(edu.umn.se.trap.form.Expense)
     */
    @Override
    protected void removeGrants(Expense expense) throws TrapException
    {
        
        if (expense != null)
        {
            checkNihFood(expense);

        }
        else
        {
            throw new TrapException(
                    "Invalid TrapForm object: expense was null.");
        }

    }

    /**
     * @param expense
     * @throws TrapException 
     */
    private void checkNihFood(Expense expense) throws TrapException
    {
        
        /*
         * Check to make sure the expense is a food expense.
         */
        if (expense.getType().equals(ExpenseType.BREAKFAST) || expense.getType().equals(ExpenseType.LUNCH) || expense.getType().equals(ExpenseType.DINNER))
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

            Iterator<FormGrant> grantIter = grants.iterator();

            while (grantIter.hasNext())
            {
                FormGrant grant = grantIter.next();

                if (StringUtils.equalsIgnoreCase(
                        grant.getFundingOrganization(), "NIH"))
                {
                    // Remove the grant if it is a NIH grant.
                    grantSet.removeGrant(grant.getAccountName());
                }
            }
            
        }
        
    }

}
