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

/**
 * @author nick
 *
 */
public class TravelFormProcessorImpl implements TravelFormProcessorIntf
{
    private String userId;
    
    /**
     * 
     */
    @Override
    public void setUser(String userId) throws Exception
    {
	this.userId = userId;

    }

    /* (non-Javadoc)
     * @see edu.umn.se.trap.TravelFormProcessorIntf#getUser()
     */
    @Override
    public String getUser()
    {
	return userId;
    }

    /* (non-Javadoc)
     * @see edu.umn.se.trap.TravelFormProcessorIntf#getSavedForms()
     */
    @Override
    public Map<Integer, TravelFormMetadata> getSavedForms() throws Exception
    {
	// TODO Auto-generated method stub
	return null;
    }

    /* (non-Javadoc)
     * @see edu.umn.se.trap.TravelFormProcessorIntf#clearSavedForms()
     */
    @Override
    public void clearSavedForms() throws Exception
    {
	// TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see edu.umn.se.trap.TravelFormProcessorIntf#getSavedFormData(java.lang.Integer)
     */
    @Override
    public Map<String, String> getSavedFormData(Integer formId)
	    throws Exception
    {
	// TODO Auto-generated method stub
	return null;
    }

    /* (non-Javadoc)
     * @see edu.umn.se.trap.TravelFormProcessorIntf#saveFormData(java.util.Map, java.lang.String)
     */
    @Override
    public Integer saveFormData(Map<String, String> formData, String description)
	    throws Exception
    {
	// TODO Auto-generated method stub
	return null;
    }

    /* (non-Javadoc)
     * @see edu.umn.se.trap.TravelFormProcessorIntf#saveFormData(java.util.Map, java.lang.Integer)
     */
    @Override
    public Integer saveFormData(Map<String, String> formData, Integer id)
	    throws Exception
    {
	// TODO Auto-generated method stub
	return null;
    }

    /* (non-Javadoc)
     * @see edu.umn.se.trap.TravelFormProcessorIntf#submitFormData(java.lang.Integer)
     */
    @Override
    public void submitFormData(Integer formId) throws Exception
    {
	// TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see edu.umn.se.trap.TravelFormProcessorIntf#getCompletedForm(java.lang.Integer)
     */
    @Override
    public Map<String, String> getCompletedForm(Integer formId)
	    throws Exception
    {
	// TODO Auto-generated method stub
	return null;
    }

}
