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

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.TrapTestUtil;
import edu.umn.se.trap.form.Expense;
import edu.umn.se.trap.rule.grantrule.DodGrantHertzRule;

/**
 * @author Andrew
 * 
 */
public class PersonalAndRentalCarRuleTest
{
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
    }

    
    @Test
    public void sameDate() throws TrapException
    {
        
        try
        {
            Date personal = new Date(200000);
            List<Expense> testExpense = TrapTestUtil
                    .getSampleExpensePersonalandCarRental(personal, personal);

            NumBaggageClaimsRule rule = new NumBaggageClaimsRule();

            rule.checkNumBaggageClaims(testExpense);
                    
            
        }
        catch (TrapException E){
            
        }
    }
    @Test
    public void differentDate() throws TrapException
    {
        
        try
        {
            Date personal = new Date (200000);
            Date rental = new Date (20000);
            List<Expense> testExpense = TrapTestUtil
                    .getSampleExpensePersonalandCarRental(personal, rental);

            NumBaggageClaimsRule rule = new NumBaggageClaimsRule();

            rule.checkNumBaggageClaims(testExpense);
                    
            
        }
        catch (TrapException E){
            
        }
    }





}
