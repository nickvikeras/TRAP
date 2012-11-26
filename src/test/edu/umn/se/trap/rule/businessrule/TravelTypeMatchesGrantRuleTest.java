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

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.TrapTestUtil;
import edu.umn.se.trap.form.FormGrant;
import edu.umn.se.trap.form.Trip;

/**
 * @author Mark
 *
 */
public class TravelTypeMatchesGrantRuleTest
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
    public void testCorrectSponsorship()
    {
        try
        {
            Set<FormGrant> grants = TrapTestUtil.getSampleGrantsSponsorshipType("sponsored");
            Trip trip = new Trip(null, null, true, false, true, null, false, null, null, null, null, null, 1);
            
            TravelTypeMatchesGrantRule rule = new TravelTypeMatchesGrantRule();
            
            rule.checkExportGrantCitizen(grants, trip);
        }
        catch(TrapException E)
        {
            fail("A matching sponsorship grant failed.");
        }
    }
    
    @Test
    public void testIncorrectSponsorship()
    {
        try
        {
            Set<FormGrant> grants = TrapTestUtil.getSampleGrantsSponsorshipType("sponsored");
            Trip trip = new Trip(null, null, false, false, true, null, false, null, null, null, null, null, 1);
            
            TravelTypeMatchesGrantRule rule = new TravelTypeMatchesGrantRule();
            
            rule.checkExportGrantCitizen(grants, trip);
            
            fail("An invalid grant passed through the rule.");
        }
        catch(TrapException E)
        {
            
        }
    }
    
    @Test
    public void testIncorrectNonSponsorship()
    {
        try
        {
            Set<FormGrant> grants = TrapTestUtil.getSampleGrantsSponsorshipType("Non-sponsored");
            Trip trip = new Trip(null, null, true, true, false, null, false, null, null, null, null, null, 1);
            
            TravelTypeMatchesGrantRule rule = new TravelTypeMatchesGrantRule();
            
            rule.checkExportGrantCitizen(grants, trip);
            
            fail("An invalid grant passed through the rule.");
        }
        catch(TrapException E)
        {
            
        }
    }

}
