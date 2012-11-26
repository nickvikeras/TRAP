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
package edu.umn.se.trap.rule.wellformedrule;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.TrapTestUtil;
import edu.umn.se.trap.form.Expense;
import edu.umn.se.trap.rule.AbstractRule;

/**
 * @author Mark
 * 
 */
public class ValidDollarAmountRuleTest
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
    public void testValidAmounts()
    {
        try
        {
            List<Expense> expenses = TrapTestUtil
                    .getSampleExpensesValidDollarAmounts(5.34, 7.45, 200.00);

            ValidDollarAmountRule rule = new ValidDollarAmountRule();

            rule.checkValidDollarAmounts(expenses);
        }
        catch (TrapException E)
        {
            fail("Error returned on valid dollar amounts.");
        }
    }

    @Test
    public void testZeroAmount()
    {
        try
        {
            List<Expense> expenses = TrapTestUtil
                    .getSampleExpensesValidDollarAmounts(0.00, 7.45, 200.00);

            ValidDollarAmountRule rule = new ValidDollarAmountRule();

            rule.checkValidDollarAmounts(expenses);

            fail("The rule passes with an invalid dollar amount.");
        }
        catch (TrapException E)
        {

        }
    }

    @Test
    public void testNegativeAmount()
    {
        try
        {
            List<Expense> expenses = TrapTestUtil
                    .getSampleExpensesValidDollarAmounts(-4.00, 7.45, 200.00);

            ValidDollarAmountRule rule = new ValidDollarAmountRule();

            rule.checkValidDollarAmounts(expenses);

            fail("The rule passes with an invalid dollar amount.");
        }
        catch (TrapException E)
        {

        }
    }

    @Test
    public void testMultipleInvalid()
    {
        try
        {
            List<Expense> expenses = TrapTestUtil
                    .getSampleExpensesValidDollarAmounts(-4.00, 0.00, 200.00);

            ValidDollarAmountRule rule = new ValidDollarAmountRule();

            rule.checkValidDollarAmounts(expenses);

            fail("The rule passes with an invalid dollar amount.");
        }
        catch (TrapException E)
        {

        }
    }
}
