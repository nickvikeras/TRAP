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
package edu.umn.se.trap.form;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.TrapTestUtil;
import edu.umn.se.trap.db.CurrencyDB;
import edu.umn.se.trap.db.GrantDB;
import edu.umn.se.trap.db.KeyNotFoundException;
import edu.umn.se.trap.db.PerDiemDB;
import edu.umn.se.trap.db.UserDB;
import edu.umn.se.trap.db.UserGrantDB;
import edu.umn.se.trap.db.orm.DatabaseAccessor;

/**
 * @author nick
 *
 */
public class FormFactoryTest
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

    /**
     * Test method for {@link edu.umn.se.trap.form.TrapFormFactory#getNewForm(java.util.Map, java.lang.String, edu.umn.se.trap.db.orm.DatabaseAccessor)}.
     * @throws KeyNotFoundException 
     */
    @Test
    public void testGetNewFormMapOfStringStringStringDatabaseAccessor() throws KeyNotFoundException
    {
        DatabaseAccessor dbAccessor = new DatabaseAccessor(new UserDB(), new PerDiemDB(), new GrantDB(), new UserGrantDB(), new CurrencyDB());
        try
        {
            TrapForm form = TrapFormFactory.getNewForm(TrapTestUtil.getSampleInput1(), "sample trap input", 1, dbAccessor);
            assertNotNull(form);
            assertNotNull(form.getFormId());
            assertNotNull(form.getFormInput());
            assertEquals("United States", form.getUser().getCitizenship());
            assertEquals("linc001@umn.edu", form.getUser().getEmail());
           
        } catch (TrapException e)
        {
            fail("failed to parse input");
        }
    }

    /**
     * Test method for {@link edu.umn.se.trap.form.TrapFormFactory#getNewForm(java.util.Map, java.lang.String, java.lang.Integer, edu.umn.se.trap.db.orm.DatabaseAccessor)}.
     */
    @Test
    public void testGetNewFormMapOfStringStringStringIntegerDatabaseAccessor()
    {
        //fail("Not yet implemented");
    }

}
