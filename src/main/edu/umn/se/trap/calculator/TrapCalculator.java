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
package edu.umn.se.trap.calculator;

import java.util.HashMap;
import java.util.Map;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.form.Expense;
import edu.umn.se.trap.form.FormGrant;
import edu.umn.se.trap.form.TrapForm;

/** TrapCalculator is a class for calculating the amount to charge each grant.
 * @author nick
 * 
 */
public class TrapCalculator
{
    /**
     * Returns a map of account numbers to the amount trap should charge to each account.
     * @param form
     * @return
     * @throws TrapException
     */
    public static Map<String, Double> calculateAmountsToCharge(TrapForm form)
            throws TrapException
    {
        //this was my fancy algorithm for trying to figure out the "hard" problem. 
        //I will leave it here, commented out, incase the reqs change 
        // Map<String, Double> accountNumToChargeAmount = new HashMap<String,
        // Double>();
        // List<Expense> expenses = form.getExpenses();
        // java.util.Collections.sort(expenses, new ExpenseComparator());
        // Set<FormGrant> formGrants = form.getGrantSet().getGrants();
        // List<FormGrant> formGrantList = Arrays.asList((FormGrant[])
        // formGrants.toArray());
        // java.util.Collections.sort(formGrantList, new FormGrantComparator());
        // for (Expense expense : expenses)
        // {
        // for (FormGrant grant : formGrantList)
        // {
        // if (expense.getEligibleGrants()
        // .contains(grant.getAccountName()))
        // {
        // String accountToCharge = grant.getAccountName();
        // Double amountToCharge = expense.getAmount();
        // grant.setAccountBalance(grant.getAccountBalance() - amountToCharge);
        // if(grant.getAccountBalance() < 0){
        // throw new
        // TrapException("Grants do not have enough available funds to cover all expenses");
        // }
        // Double amount = accountNumToChargeAmount.get(accountToCharge);
        // if(amount != null){
        // amountToCharge += amount;
        // }
        // java.util.Collections.sort(formGrantList, new FormGrantComparator());
        // accountNumToChargeAmount.put(accountToCharge, amountToCharge);
        // break;
        // }
        // }
        //
        // }
        // return accountNumToChargeAmount;

        double grandTotal = 0;
        for (Expense expense : form.getExpenses())
        {
            double amount = expense.getAmount();
            grandTotal += amount;
        }
        Map<String, Double> accountNumToChargeAmount = new HashMap<String, Double>();
        for (FormGrant grant : form.getGrantSet().getGrants())
        {
            double percent = form.getAccountToPercentMap().get(
                    grant.getAccountName()) / 100;
            double grantAmount = percent * grandTotal;
            accountNumToChargeAmount.put(grant.getAccountName(), grantAmount);
        }
        return accountNumToChargeAmount;
    }
}
