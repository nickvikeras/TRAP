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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.TrapTestUtil;
import edu.umn.se.trap.form.Expense;
import edu.umn.se.trap.form.FormGrant;
import edu.umn.se.trap.form.FormUser;
import edu.umn.se.trap.rule.grantrule.DodGrantHertzRule;

/**
 * @author Andrew
 * 
 */
public class ExportGrantCitizenRuleTest
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
        Set<FormGrant> grants = new HashSet<FormGrant>();

        FormGrant grant1 = new FormGrant("test account 1", "Sponsored", "Nih",
                500.00, "noExport", null, null);

        grants.add(grant1);

        FormUser user = new FormUser("linc001", "Greg Gay", "765-432-1098",
                "Ron Smith", "smith@umn.edu", "8790111", "US", "NA", true);

        try
        {
            ExportGrantCitizenRule rule = new ExportGrantCitizenRule();

            rule.checkExportGrantCitizen(grants, user);

        }
        catch (TrapException E)
        {

        }
    }

    @Test
    public void testFail() throws TrapException
    {
        Set<FormGrant> grants = new HashSet<FormGrant>();

        FormGrant grant1 = new FormGrant("test account 1", "government", "Nih",
                500.00, "noExport", null, null);

        grants.add(grant1);

        FormUser user = new FormUser("linc001", "Greg Gay", "765-432-1098",
                "Ron Smith", "smith@umn.edu", "8790111", "Icelandic", "NA", true);

        try
        {

            ExportGrantCitizenRule rule = new ExportGrantCitizenRule();

            rule.checkExportGrantCitizen(grants, user);
            
            fail("An invalid grant did not throw an error.");
        }
        catch (TrapException E)
        {

        }

    }

}
