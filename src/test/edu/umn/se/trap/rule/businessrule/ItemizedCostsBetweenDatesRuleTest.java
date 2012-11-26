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
import edu.umn.se.trap.form.TrapDateUtil;
import edu.umn.se.trap.rule.grantrule.DodGrantHertzRule;
import edu.umn.se.trap.form.Trip;

/**
 * @author Andrew
 * 
 */
public class ItemizedCostsBetweenDatesRuleTest
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
    public void testSuccess() throws TrapException
    {

        Date arrival = TrapDateUtil.parseTrapDate("20120901 111111");
        Date depart = TrapDateUtil.parseTrapDate("20120900 111111");
        Date edate = TrapDateUtil.parseTrapDate("20120901 110000");

        try
        {
            List<Expense> testExpense = TrapTestUtil
                    .getSampleExpenseArrivalandDeparture(edate);

            ItemizedCostsBetweenDatesRule rule = new ItemizedCostsBetweenDatesRule();

            rule.checkItemizedCosts(depart, arrival, testExpense);

        }
        catch (TrapException E)
        {

        }
    }

    @Test
    public void testFail() throws TrapException
    {
        Date arrival = TrapDateUtil.parseTrapDate("20120901 111111");
        Date depart = TrapDateUtil.parseTrapDate("20120900 111111");
        Date edate = TrapDateUtil.parseTrapDate("20120902 110000");

        try
        {
            List<Expense> testExpense = TrapTestUtil
                    .getSampleExpenseArrivalandDeparture(edate);

            ItemizedCostsBetweenDatesRule rule = new ItemizedCostsBetweenDatesRule();

            rule.checkItemizedCosts(depart, arrival, testExpense);

            fail("An invalid expense did not throw an error.");
        }
        catch (TrapException E)
        {

        }

    }

}
