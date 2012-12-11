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

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.util.TrapErrors;
import edu.umn.se.trap.util.TrapInputKeys;

/**
 * @author nick
 * 
 */
public class AuthorizedPayeeSystemTest extends AbstractSystemTest
{

    @Test
    public void testNonAuthorizedPayee() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        input.put("GRANT1_ACCOUNT", "99999");
        output.put("GRANT1_ACCOUNT", "99999");

        input.put(TrapInputKeys.TRAVEL_TYPE_NONSPONSORED, "yes");
        output.put(TrapInputKeys.TRAVEL_TYPE_NONSPONSORED, "yes");

        input.put(TrapInputKeys.JUSTIFICATION_NONSPONSORED, "blah");
        output.put(TrapInputKeys.JUSTIFICATION_NONSPONSORED, "blah");

        input.remove(TrapInputKeys.TRAVEL_TYPE_CSE_SPONSORED);
        output.remove(TrapInputKeys.TRAVEL_TYPE_CSE_SPONSORED);

        input.remove(TrapInputKeys.JUSTIFICATION_SPONSORED);
        output.remove(TrapInputKeys.JUSTIFICATION_SPONSORED);

        input.put(TrapInputKeys.USER_NAME, "china001");
        output.put(TrapInputKeys.VISA_STATUS, "valid");
        output.put("NAME", "China, Bob");
        output.put("USER_NAME", "china001");
        output.put("EMAIL", "china001@umn.edu");
        output.put("CITIZENSHIP", "China");
        
        // TODO
        Printer.print(input, output);

        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.USER_NOT_AUTORIZED, e.getMessage());
            return;
        }
        fail("An Exception should have been thrown");
        
    }

}
