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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.TrapException;

/**
 * @author Mark
 * 
 *         JUnit test for USCarrierRule
 * 
 */
public class USCarrierRuleTest
{

    private final String[] USCARRIERS = { "Southwest", "Alaska Airlines",
            "American", "Delta", "Frontier", "Great Lakes", "Spirit",
            "Sun County", "United", "US Airways" };

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
    public void testAllUSCarriers()
    {

        try
        {
            USCarrierRule rule = new USCarrierRule();

            for (int i = 0; i < USCARRIERS.length; i++)
            {
                if (!rule.checkCarrierString(USCARRIERS[i]))
                {
                    fail("A valid US air carrier returned false.");
                }
            }
        }
        catch (Exception E)
        {
            fail("Unknown error.");
        }

    }

    @Test
    public void testNoneUSCarriers()
    {
        USCarrierRule rule = new USCarrierRule();

        if (rule.checkCarrierString("Fake Airways"))
        {
            fail("An invalid air carrier returned true.");
        }

        if (rule.checkCarrierString(null))
        {
            fail("An invalid air carrier returned true.");
        }

    }

    @Test
    public void testCaseInsensitivity()
    {
        USCarrierRule rule = new USCarrierRule();

        if (!rule.checkCarrierString("sun countY"))
        {
            fail("Method did not recognize valid US air carrier.");
        }

    }

}
