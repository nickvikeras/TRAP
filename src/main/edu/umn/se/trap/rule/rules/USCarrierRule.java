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

package edu.umn.se.trap.rule.rules;

import java.util.List;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.form.Expense;
import edu.umn.se.trap.form.TransportationExpense;
import edu.umn.se.trap.form.TransportationType;
import edu.umn.se.trap.form.TrapForm;
import edu.umn.se.trap.rule.AbstractRule;

public class USCarrierRule extends AbstractRule
{

    @Override
    public String validateRule(TrapForm form) throws TrapException
    {
        if(form != null) 
        {
            
            List<Expense> expenses = form.getExpenses();
            
            for(Expense expense : expenses) 
            {
                if(expense instanceof TransportationExpense)
                {
                    // Check to see that the expense is an AIR type.
                    if(((TransportationExpense) expense).getTranportationType().equals("AIR")) 
                    {
                        
                        // TODO: Check to see that the air carrier is a US Carrier.
                        if(((TransportationExpense) expense).getCarrier().equals(""))
                        {
                            
                            return "Rule approved";
                            
                        }
                        else
                        {
                            throw new TrapException("Invalid Air Carrier: Not a US Air Carrier.");
                        }
                    }
                }
            }
        }
        else 
        {
            throw new TrapException("Invalid TrapForm object: form was null.");
        }
       
        return null;
    }

}
