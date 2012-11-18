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
package edu.umn.se.trap.db.orm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.calculator.TrapException;
import edu.umn.se.trap.db.CurrencyDB;
import edu.umn.se.trap.db.GrantDB;
import edu.umn.se.trap.db.PerDiemDB;
import edu.umn.se.trap.db.UserDB;
import edu.umn.se.trap.db.UserGrantDB;
import edu.umn.se.trap.form.TrapDateUtil;

/**
 * @author nick
 * 
 */
public class DatabaseAccessorTest
{

    DatabaseAccessor dbAccessor = new DatabaseAccessor(new UserDB(), new PerDiemDB(), new GrantDB(), new UserGrantDB(), new CurrencyDB());

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
     * {@link edu.umn.se.trap.db.orm.DatabaseAccessor#getUser(java.lang.String)}
     * .
     */
    @Test
    public void testGetUser()
    {
	try
	{
	    User user = dbAccessor.getUser("linc001");
	    assertNotNull(user);
	    assertEquals(user.getUserName(), "linc001");
	    assertEquals(user.getFullName(), "Lincoln, Abraham");
	    assertEquals(user.getEmployeeId(), "1849304");
	    assertEquals(user.getEmail(), "linc001@umn.edu");
	    assertEquals(user.getCitizenship(), "United States");
	    assertNull(user.getVisaStatus());
	    assertTrue(user.isPaidByUniversity());
	} catch (TrapException e)
	{
	    fail("User not found.");
	}

    }

    /**
     * Test method for
     * {@link edu.umn.se.trap.db.orm.DatabaseAccessor#getDomesticPerdiem(java.lang.String)}
     * .
     */
    @Test
    public void testGetDomesticPerdiemString()
    {
	try
	{
	    PerDiem perDiem = dbAccessor.getDomesticPerdiem("colorado");
	    assertNotNull(perDiem);
	    assertTrue(8.0 == perDiem.getBreakfastRate().doubleValue());
	    assertTrue(13.0 == perDiem.getLunchRate().doubleValue());
	    assertTrue(27.0 == perDiem.getDinnerRate().doubleValue());
	    assertTrue(6.0 == perDiem.getIncidentalCeiling().doubleValue());
	    assertTrue(151.0 == perDiem.getLodgingCeiling().doubleValue());
	} catch (TrapException e)
	{
	    fail("per diem not found");
	}
    }

    /**
     * Test method for
     * {@link edu.umn.se.trap.db.orm.DatabaseAccessor#getDomesticPerdiem(java.lang.String, java.lang.String)}
     * .
     */
    @Test
    public void testGetDomesticPerdiemStringString()
    {
	try
	{
	    PerDiem perDiem = dbAccessor.getDomesticPerdiem("minneapolis", "minnesota");
	    assertNotNull(perDiem);
	    assertTrue(7.0 == perDiem.getBreakfastRate().doubleValue());
	    assertTrue(12.0 == perDiem.getLunchRate().doubleValue());
	    assertTrue(26.0 == perDiem.getDinnerRate().doubleValue());
	    assertTrue(5.0 == perDiem.getIncidentalCeiling().doubleValue());
	    assertTrue(150.0 == perDiem.getLodgingCeiling().doubleValue());
	} catch (TrapException e)
	{
	    fail("per diem not found");
	}
    }

    /**
     * Test method for
     * {@link edu.umn.se.trap.db.orm.DatabaseAccessor#getIntlPerdiem(java.lang.String)}
     * .
     */
    @Test
    public void testGetIntlPerdiemString()
    {
	PerDiem perDiem;
	try
	{
	    perDiem = dbAccessor.getIntlPerdiem("switzerland");
	    assertNotNull(perDiem);
	    assertTrue(10.0 == perDiem.getBreakfastRate().doubleValue());
	    assertTrue(20.0 == perDiem.getLunchRate().doubleValue());
	    assertTrue(40.0 == perDiem.getDinnerRate().doubleValue());
	    assertTrue(20.0 == perDiem.getIncidentalCeiling().doubleValue());
	    assertTrue(250.0 == perDiem.getLodgingCeiling().doubleValue());
	} catch (TrapException e)
	{
	    fail("perDiem not found");
	}
    }

    /**
     * Test method for
     * {@link edu.umn.se.trap.db.orm.DatabaseAccessor#getIntlPerdiem(java.lang.String, java.lang.String)}
     * .
     */
    @Test
    public void testGetIntlPerdiemStringString()
    {
	try
	{
	    PerDiem perDiem = dbAccessor.getIntlPerdiem("zurich", "switzerland");
	    assertNotNull(perDiem);
	    assertTrue(12.0 == perDiem.getBreakfastRate().doubleValue());
	    assertTrue(25.0 == perDiem.getLunchRate().doubleValue());
	    assertTrue(50.0 == perDiem.getDinnerRate().doubleValue());
	    assertTrue(20.0 == perDiem.getIncidentalCeiling().doubleValue());
	    assertTrue(225.0 == perDiem.getLodgingCeiling().doubleValue());
	} catch (TrapException e)
	{
	    fail("per diem not found");
	}
    }

    /**
     * Test method for
     * {@link edu.umn.se.trap.db.orm.DatabaseAccessor#getGrant(java.lang.String)}
     * .
     */
    @Test
    public void testGetGrant()
    {
	try
	{
	    Grant grant = dbAccessor.getGrant("010101010101");
	    assertNotNull(grant);
	    assertEquals("010101010101", grant.getAccountNumber());
	    assertEquals("sponsored", grant.getAccountType());
	    assertEquals("DARPA", grant.getFundingOrganization());
	    assertEquals("government", grant.getOrganizationType());
	} catch (TrapException e)
	{
	    fail("grant not found");
	}
    }

    /**
     * Test method for
     * {@link edu.umn.se.trap.db.orm.DatabaseAccessor#getUserGrant(java.lang.String)}
     * .
     */
    @Test
    public void testGetUserGrant()
    {
	try
        {
	    UserGrant userGrant = dbAccessor.getUserGrant("010101010101");
	    assertNotNull(userGrant);
	    assertEquals("010101010101", userGrant.getAccountNumber());
	    assertEquals(userGrant.getGrantAdmin(), "heimd001");
	    String[] payees = {"linc001","gayxx067"};
	    for(int i = 0; i < payees.length; i++){
		assertEquals(payees[i], userGrant.getAuthorizedPayees()[i]);
	    }
        } catch (TrapException e)
        {
	   fail("userGrant not found");
        }
    }

    /**
     * Test method for
     * {@link edu.umn.se.trap.db.orm.DatabaseAccessor#getUsd(java.lang.String, double, java.util.Date)}
     * .
     */
    @Test
    public void testGetUsd()
    {
        try
        {
            double usdValue = dbAccessor.getUsd("eur", 10.0, TrapDateUtil.parseTrapDate("20121130"));
            assertTrue(18.0 == usdValue);
        } catch (TrapException e)
        {
	    fail("conversion not found");
        } 
    }

}
