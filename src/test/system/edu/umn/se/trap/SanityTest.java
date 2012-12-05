/**
 * Copyright (c) 2012, Ian De Silva
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 * 
 * - Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice, 
 *   this list of conditions and the following disclaimer in the documentation 
 *   and/or other materials provided with the distribution.
 * - Neither the name of the University of Minnesota nor the names of its 
 *   contributors may be used to endorse or promote products derived from this 
 *   software without specific prior written permission.
 *   
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 */

package edu.umn.se.trap;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import edu.umn.se.trap.util.TrapDateUtil;

/**
 * This is a test class for various black box tests. These tests will try to
 * cover the entire scope of information that TRAP can handle.
 * 
 * This test class is built around central tests that use getUser and
 * submitFormData such that every test can use different pairs of input and
 * output maps.
 * 
 * @author Mark
 */
public class SanityTest extends AbstractSystemTest
{
    /**
     * @throws Exception
     */
    @Test
    public void testSanity() throws Exception
    {
        super.testProcessor.setUser("linc001");
        String description = "my form description";
        SystemTestUtil.submitFormData(getBasicFormInput(), description,
                super.testProcessor, getBasicFormOutput());
    }

}
