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

import edu.umn.se.trap.form.Form;

/**
 * @author nick
 * 
 */
public class FormChecker
{
    private List<AbstractRule> rules = new ArrayList<AbstractRule>();
    
    public void addRule(AbstractRule rule){
	rules.add(rule);
    }

    public void fireRules(Form form) throws RuleException
    {
	RuleException ruleException = new RuleException();
	for (AbstractRule rule : rules)
	{
	    ruleException.addMessage(rule.validateRule(form));
	}
	if (ruleException.getNumMessages() > 0)
	{
	    throw ruleException;
	}
    }
}
