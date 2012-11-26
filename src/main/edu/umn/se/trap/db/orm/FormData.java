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

import java.util.Map;

import edu.umn.se.trap.TravelFormMetadata;

/**
 * @author nick
 *
 */
public class FormData
{
    private Map<String, String> input;
    private Map<String, String> output;
    private TravelFormMetadata metadata;
    /**
     * @param input
     * @param output
     * @param metadata
     */
    public FormData(Map<String, String> input, Map<String, String> output,
            TravelFormMetadata metadata)
    {
        super();
        this.input = input;
        this.output = output;
        this.metadata = metadata;
    }
    /**
     * @return the input
     */
    public Map<String, String> getInput()
    {
        return input;
    }
    /**
     * @param input the input to set
     */
    public void setInput(Map<String, String> input)
    {
        this.input = input;
    }
    /**
     * @return the output
     */
    public Map<String, String> getOutput()
    {
        return output;
    }
    /**
     * @param output the output to set
     */
    public void setOutput(Map<String, String> output)
    {
        this.output = output;
    }
    /**
     * @return the metadata
     */
    public TravelFormMetadata getMetadata()
    {
        return metadata;
    }
    /**
     * @param metadata the metadata to set
     */
    public void setMetadata(TravelFormMetadata metadata)
    {
        this.metadata = metadata;
    }
}
