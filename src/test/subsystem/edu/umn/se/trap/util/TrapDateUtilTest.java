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
package edu.umn.se.trap.util;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.util.TrapDateUtil;

/**
 * @author nick
 * 
 */
public class TrapDateUtilTest
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
     * Test method for
     * {@link edu.umn.se.trap.form.TrapDateUtil#printDate(java.util.Date)}.
     */
    @Test
    public void testPrintDate()
    {
        Date date = new Date(0);
        assertEquals("19691231", TrapDateUtil.printDate(date));
    }

    /**
     * Test method for
     * {@link edu.umn.se.trap.form.TrapDateUtil#printDateTime(java.util.Date)}.
     */
    @Test
    public void testPrintDateTime()
    {
        Date date = new Date(0);
        assertEquals("19691231 180000", TrapDateUtil.printDateTime(date));
    }

}
