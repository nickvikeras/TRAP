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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Test;

import edu.umn.se.trap.util.TrapErrors;
import edu.umn.se.trap.util.TrapInputKeys;

/**
 * @author nick
 *
 */
public class MustHaveVisaToBeReimbursedSystemTest extends AbstractSystemTest
{


    @Test
    public void testInvalidVisa() throws Exception
    {
        Map<String, String> input = super.getBasicFormInput();
        Map<String, String> output = super.getBasicFormOutput();

        input.put(TrapInputKeys.USER_NAME, "canada001");
        output.put(TrapInputKeys.VISA_STATUS, "valid");
        output.put("NAME", "Canada, Northern");
        output.put("USER_NAME", "canada001");
        output.put("EMAIL", "canada001@umn.edu");
        output.put("CITIZENSHIP", "canada");
        

        try
        {
            SystemTestUtil.submitFormData(input, "description", testProcessor,
                    output);
        }
        catch (TrapException e)
        {
            assertEquals(TrapErrors.INVALID_VISA, e.getMessage());
            return;
        }
        fail("An exception should have been caught.");
    }

}
