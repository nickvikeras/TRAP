	
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

import java.text.ParseException;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.db.CurrencyDB;
import edu.umn.se.trap.util.TrapErrors;

/**
 * @author Andrew
 *
 */

public class ClearSavedFormsSystemTest extends AbstractSystemTest {
	
    /* (non-Javadoc)
     * @see edu.umn.se.trap.AbstractSystemTest#setUp()
     */
    @Before
    public void setUp() throws Exception
    {
        super.setUp();
    }

    /* (non-Javadoc)
     * @see edu.umn.se.trap.AbstractSystemTest#tearDown()
     */
    @After
    public void tearDown() throws Exception
    {
        super.tearDown();
    }
	    
    //Create and save a valid form then load it
    @Test
    public void ClearSavedFormsTest() throws Exception
    {
    	//Create several forms and save them
    	Map<String, String> input = getBasicFormInput();
    	Map<String, String> input2 = getBasicFormInput();
    	Map<String, String> input3 = getBasicFormInput();
    	Map<String, String> input4 = getBasicFormInput();
    	Map<String, String> input5 = getBasicFormInput();
    	Map<String, String> input6 = getBasicFormInput();
    	
    	//public Integer saveFormData(Map<String, String> formData, String description)

    	int[] formIDs = new int[6];
    	String description = "desc";

        try
        {
        	int numForms =0;
        	
        	formIDs[0]= testProcessor.saveFormData(input, description);
        	formIDs[1]= testProcessor.saveFormData(input2, description);
        	formIDs[2]= testProcessor.saveFormData(input3, description);
        	formIDs[3]= testProcessor.saveFormData(input4, description);
        	formIDs[4]= testProcessor.saveFormData(input5, description);
        	formIDs[5]= testProcessor.saveFormData(input6, description);
       	
        	testProcessor.clearSavedForms();
        	       	
        	Map<Integer, TravelFormMetadata> savedForms = testProcessor
        			.getSavedForms();
        	Set<Integer> keys = savedForms.keySet();
        	
        	int formNums = savedForms.size();
        	
        	if ( formNums != 0 ){
        		fail ("There shouldn't be any forms in the database!");
        	}
        	
        	
    
        }
        catch (TrapException e)
        {
	
        	fail("An exception should not  have been thrown");
        }
        
    	
    	
    }
    

    

    
    

}
