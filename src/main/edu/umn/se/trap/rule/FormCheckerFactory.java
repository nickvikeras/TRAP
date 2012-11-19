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

import edu.umn.se.trap.rule.wellformedrule.ArrivalAfterDepartureRule;

/**
 * @author nick
 * 
 */
public class FormCheckerFactory
{
    public static FormChecker createWellFormedChecker()
    {
        FormChecker checker = new FormChecker();
        checker.addRule(new ArrivalAfterDepartureRule());
        return checker;
    }

    public static FormChecker createBusinessRuleChecker()
    {
        FormChecker checker = new FormChecker();
        // add rules here with checker.addRule(rule);
        return checker;
    }

    public static FormChecker createGrantRuleChecker()
    {
        FormChecker checker = new FormChecker();
        // add rules here with checker.addRule(rule);
        return checker;
    }
}
