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

/** This class is just used to store form data in a map.
 * @author nick
 * 
 */
public class FormDB
{
    private Map<Integer, FormData> map = new HashMap<Integer, FormData>();

    /**
     * Save a form. The saved form will not persist past TRAP's execution.
     * @param form
     * @param id
     */
    public void saveForm(FormData form, Integer id)
    {
        map.put(id, form);
    }

    /**
     * Retrieve a previously saved or completed form.
     * @param formId
     * @return
     */
    public FormData getForm(Integer formId)
    {
        FormData formData = map.get(formId);
        return formData;

    }

    /**
     * Get a Map with a key of a form's id and  a value of it's metadata for all forms that have been saved for completed.
     * @return
     */
    public Map<Integer, TravelFormMetadata> getSavedForms()
    {
        Map<Integer, TravelFormMetadata> savedForms = new HashMap<Integer, TravelFormMetadata>();
        for (Entry<Integer, FormData> entry : map.entrySet())
        {
            savedForms.put(entry.getKey(), entry.getValue().getMetadata());
        }
        return savedForms;
    }

    /**
     * 
     */
    public void clear()
    {
        map.clear();

    }
}
