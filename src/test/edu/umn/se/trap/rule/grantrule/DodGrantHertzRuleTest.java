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

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.TrapTestUtil;
import edu.umn.se.trap.form.Expense;

/**
 * @author Mark
 * 
 */
public class DodGrantHertzRuleTest
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
        Expense testExpense = TrapTestUtil
                .getSampleExpenseDodGrantHertzRule("Hertz");

        DodGrantHertzRule rule = new DodGrantHertzRule();

        rule.removeGrants(testExpense, null);

        if (testExpense.getEligibleGrants().getGrants().isEmpty())
        {
            fail("Grant was improperly deleted.");
        }
    }

    @Test
    public void testFail() throws TrapException
    {
        Expense testExpense = TrapTestUtil
                .getSampleExpenseDodGrantHertzRule("Enterprise Rent-A-Car");

        DodGrantHertzRule rule = new DodGrantHertzRule();

        rule.removeGrants(testExpense, null);

        if (!testExpense.getEligibleGrants().getGrants().isEmpty())
        {
            fail("Grant was not deleted.");
        }
    }

}
