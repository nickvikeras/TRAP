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
package edu.umn.se.trap;

import java.util.Map;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.util.TrapDateUtil;
import edu.umn.se.trap.util.TrapErrors;

/**
 * @author nick
 * 
 */
public class RentalPersonalCarSystemTest extends AbstractSystemTest
{

    @Test
    public void testRentalAndPersonal()
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();
        input.put("TRANSPORTATION6_TYPE", "Car");
        input.put("TRANSPORTATION6_RENTAL", "yes");
        input.put("TRANSPORTATION6_CURRENCY", "USD");
        input.put("TRANSPORTATION5_TYPE", "Car");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (Exception e)
        {
            assertEquals(TrapErrors.PERSONAL_RENTAL_CAR, e.getMessage());
        }
    }

    @Test
    public void testJustRental()
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();
        input.put("TRANSPORTATION6_TYPE", "CAR");
        input.put("TRANSPORTATION6_RENTAL", "yes");
        input.put("TRANSPORTATION6_CURRENCY", "USD");
        input.put("TRANSPORTATION6_CARRIER", "National");
        output.put("TRANSPORTATION6_TYPE", "CAR");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (Exception e)
        {
            fail("No exception should have been thrown");
        }
    }

    @Test
    public void testJustPersonal()
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();
        input.put("TRANSPORTATION5_TYPE", "Car");
        output.put("TRANSPORTATION5_TYPE", "Car");

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (Exception e)
        {
            fail("No exception should have been thrown");
        }
    }

}
