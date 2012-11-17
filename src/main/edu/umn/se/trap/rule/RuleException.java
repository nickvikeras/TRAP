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
package edu.umn.se.trap.rule;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nick
 * 
 */
public class RuleException extends Exception
{

    private static final long serialVersionUID = 4897858169466010776L;
    List<String> messages = new ArrayList<String>();

    public void addMessage(String message)
    {
	messages.add(message);
    }

    @Override
    public String getMessage()
    {
	StringBuilder builder = new StringBuilder();
	for (int i = 0; i < messages.size(); i++)
	{
	    builder.append(messages.get(i));
	    if (i != messages.size() - 1)
	    {
		builder.append(",");
		builder.append(" ");
	    }
	}
	return builder.toString();
    }

    public int getNumMessages()
    {
	return messages.size();
    }
}
