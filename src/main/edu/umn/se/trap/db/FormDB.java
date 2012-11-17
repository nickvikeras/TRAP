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
package edu.umn.se.trap.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import edu.umn.se.trap.TravelFormMetadata;
import edu.umn.se.trap.form.Form;

/**
 * @author nick
 * 
 */
public class FormDB
{
    private Map<Integer, Form> map = new HashMap<Integer, Form>();

    public void saveForm(Form form)
    {
	map.put(form.getFormId(), form);
    }

    public Form getForm(Integer formId) throws KeyNotFoundException
    {
	Form form = map.get(formId);
	if (form == null)
	{
	    throw new KeyNotFoundException();
	}
	return form;

    }

    public Map<Integer, TravelFormMetadata> getSavedForms()
    {
	Map<Integer, TravelFormMetadata> savedForms = new HashMap<Integer, TravelFormMetadata>();
	for (Entry<Integer, Form> entry : map.entrySet())
	{
	    savedForms.put(entry.getKey(), entry.getValue().getFormMetaData());
	}
	return savedForms;
    }
}
