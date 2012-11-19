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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.rule.wellformedrule.ArrivalAfterDepartureRule;

/**
 * @author Mark
 *
 */
public class FileDeadlineRuleTest
{

    private final int numberOfMillesecondsInADay = 86400000;
    
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
    public void testNormalCase()
    {
        FileDeadlineRule rule = new FileDeadlineRule();
        try
        {
            rule.checkDeadline(new Date(0), new Date(1));
        } catch (TrapException e)
        {
            fail("The form was filed too long after the arrival date");
        }
    }
    
    @Test
    public void testBadCase()
    {
        FileDeadlineRule rule = new FileDeadlineRule();
        try
        {
            rule.checkDeadline(new Date(0), new Date((rule.getDEADLINE_DAYS()*numberOfMillesecondsInADay) + 1));
            fail("The form passed even though the form was filed too late");
        } catch (TrapException e)
        {
        }
    }
    
    @Test
    public void testEdgeCase()
    {
        FileDeadlineRule rule = new FileDeadlineRule();
        try
        {
            rule.checkDeadline(new Date(0), new Date(rule.getDEADLINE_DAYS()));
        } catch (TrapException e)
        {
            fail("The form was filed too long after the arrival date");
        }
    }

    @Test
    public void testNegativeCase()
    {
        FileDeadlineRule rule = new FileDeadlineRule();
        try
        {
            rule.checkDeadline(new Date(5), new Date(0));
        } catch (TrapException e)
        {
            fail("The form was filed too long after the arrival date");
        }
    }
}
