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
package RequiredFieldSystemTest;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.AbstractSystemTest;
import edu.umn.se.trap.SystemTestUtil;
import edu.umn.se.trap.util.TrapInputKeys;

/**
 * @author nick
 * 
 */
public class RequiredFieldSystemTest extends AbstractSystemTest
{

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testNoCitizenship() throws Exception
    {
        Map<String, String> input = getBasicFormInput();
        Map<String, String> output = getBasicFormOutput();

        input.put(TrapInputKeys.USER_NAME, "nocit001");
        super.testProcessor.setUser("linc001");
        String description = "my form description";
        try
        {
            SystemTestUtil.submitFormData(input, description,
                    super.testProcessor, output);
        }
        catch (Exception e)
        {
            return;
        }
        fail("An exception should have been thrown.");
    }

}
