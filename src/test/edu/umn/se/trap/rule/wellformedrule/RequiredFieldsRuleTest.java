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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.TrapTestUtil;
import edu.umn.se.trap.db.CurrencyDB;
import edu.umn.se.trap.db.GrantDB;
import edu.umn.se.trap.db.PerDiemDB;
import edu.umn.se.trap.db.UserDB;
import edu.umn.se.trap.db.UserGrantDB;
import edu.umn.se.trap.db.orm.DatabaseAccessor;
import edu.umn.se.trap.form.FormFactory;
import edu.umn.se.trap.form.TrapForm;
import edu.umn.se.trap.rule.AbstractRule;

/**
 * @author Mark
 * 
 */
public class RequiredFieldsRuleTest
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
    public void testBasicForm()
    {
        DatabaseAccessor dbAccessor = new DatabaseAccessor(new UserDB(),
                new PerDiemDB(), new GrantDB(), new UserGrantDB(),
                new CurrencyDB());
        try
        {
            TrapForm form = FormFactory.getNewForm(
                    TrapTestUtil.getSampleInput1(), "sample trap input",
                    dbAccessor);

            AbstractRule rule = new RequiredFieldsRule();

            rule.validateRule(form);
        }
        catch (TrapException TE)
        {
            fail("Failure: " + TE.getMessage());
        }
        catch (Exception E)
        {
            fail("Unexpected failure: " + E.getMessage());
        }
    }

    @Test
    public void testMissingJustification()
    {
        DatabaseAccessor dbAccessor = new DatabaseAccessor(new UserDB(),
                new PerDiemDB(), new GrantDB(), new UserGrantDB(),
                new CurrencyDB());
        try
        {
            TrapForm form = FormFactory.getNewForm(
                    TrapTestUtil.getSampleInputMissingJustification(),
                    "sample trap input", dbAccessor);

            AbstractRule rule = new RequiredFieldsRule();

            rule.validateRule(form);
        }
        catch (TrapException TE)
        {
        }
        catch (Exception E)
        {
            fail("Unexpected failure: " + E.getMessage());
        }
    }
    
    @Test
    public void testMissingExpenseLocationMissingCity()
    {
        DatabaseAccessor dbAccessor = new DatabaseAccessor(new UserDB(),
                new PerDiemDB(), new GrantDB(), new UserGrantDB(),
                new CurrencyDB());
        try
        {
            TrapForm form = FormFactory.getNewForm(
                    TrapTestUtil.getSampleInputMissingExpenseLocation(null, "MO", "USA"),
                    "sample trap input", dbAccessor);

            AbstractRule rule = new RequiredFieldsRule();

            rule.validateRule(form);

            fail("Failure: TrapException was not thrown.");
        }
        catch (TrapException TE)
        {
        }
        catch (Exception E)
        {
            fail("Unexpected failure: " + E.getMessage());
        }
    }
    
    @Test
    public void testMissingExpenseLocationMissingState()
    {
        DatabaseAccessor dbAccessor = new DatabaseAccessor(new UserDB(),
                new PerDiemDB(), new GrantDB(), new UserGrantDB(),
                new CurrencyDB());
        try
        {
            TrapForm form = FormFactory.getNewForm(
                    TrapTestUtil.getSampleInputMissingExpenseLocation("Kansas City", null, "USA"),
                    "sample trap input", dbAccessor);

            AbstractRule rule = new RequiredFieldsRule();

            rule.validateRule(form);

            fail("Failure: TrapException was not thrown.");
        }
        catch (TrapException TE)
        {
        }
        catch (Exception E)
        {
            fail("Unexpected failure: " + E.getMessage());
        }
    }
    
    @Test
    public void testMissingExpenseLocationMissingCountry()
    {
        DatabaseAccessor dbAccessor = new DatabaseAccessor(new UserDB(),
                new PerDiemDB(), new GrantDB(), new UserGrantDB(),
                new CurrencyDB());
        try
        {
            TrapForm form = FormFactory.getNewForm(
                    TrapTestUtil.getSampleInputMissingExpenseLocation("Kansas City", "MO", null),
                    "sample trap input", dbAccessor);

            AbstractRule rule = new RequiredFieldsRule();

            rule.validateRule(form);

            fail("Failure: TrapException was not thrown.");
        }
        catch (TrapException TE)
        {
        }
        catch (Exception E)
        {
            fail("Unexpected failure: " + E.getMessage());
        }
    }
    
    @Test
    public void testMissingExpenseLocationCityOnly()
    {
        DatabaseAccessor dbAccessor = new DatabaseAccessor(new UserDB(),
                new PerDiemDB(), new GrantDB(), new UserGrantDB(),
                new CurrencyDB());
        try
        {
            TrapForm form = FormFactory.getNewForm(
                    TrapTestUtil.getSampleInputMissingExpenseLocation("Kansas City", null, null),
                    "sample trap input", dbAccessor);

            AbstractRule rule = new RequiredFieldsRule();

            rule.validateRule(form);

            fail("Failure: TrapException was not thrown.");
        }
        catch (TrapException TE)
        {
        }
        catch (Exception E)
        {
            fail("Unexpected failure: " + E.getMessage());
        }
    }

    @Test
    public void testMissingNoSponsorship()
    {
        DatabaseAccessor dbAccessor = new DatabaseAccessor(new UserDB(),
                new PerDiemDB(), new GrantDB(), new UserGrantDB(),
                new CurrencyDB());
        try
        {
            TrapForm form = FormFactory.getNewForm(
                    TrapTestUtil.getSampleInputNoSponsorship(),
                    "sample trap input", dbAccessor);

            AbstractRule rule = new RequiredFieldsRule();

            rule.validateRule(form);

            fail("Failure: TrapException was not thrown.");
        }
        catch (TrapException TE)
        {
        }
        catch (Exception E)
        {
            fail("Unexpected failure: " + E.getMessage());
        }
    }

}
