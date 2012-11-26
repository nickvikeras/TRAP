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

import edu.umn.se.trap.rule.businessrule.BaggageCostLimitRule;
import edu.umn.se.trap.rule.businessrule.ExportGrantCitizenRule;
import edu.umn.se.trap.rule.businessrule.FileDeadlineRule;
import edu.umn.se.trap.rule.businessrule.GrantAuthorizationRule;
import edu.umn.se.trap.rule.businessrule.HotelOvernightRule;
import edu.umn.se.trap.rule.businessrule.ItemizedCostsBetweenDatesRule;
import edu.umn.se.trap.rule.businessrule.NumBaggageClaimsRule;
import edu.umn.se.trap.rule.businessrule.PersonalAndRentalCarRule;
import edu.umn.se.trap.rule.businessrule.TravelTypeMatchesGrantRule;
import edu.umn.se.trap.rule.businessrule.USCarrierRule;
import edu.umn.se.trap.rule.businessrule.VisaStatusRule;
import edu.umn.se.trap.rule.grantrule.DodGrantHertzRule;
import edu.umn.se.trap.rule.grantrule.DodNoBreakfastRule;
import edu.umn.se.trap.rule.grantrule.DodNoForeignRule;
import edu.umn.se.trap.rule.grantrule.ForeignGrantsForeignTravelOnlyRule;
import edu.umn.se.trap.rule.grantrule.NihNoFoodRule;
import edu.umn.se.trap.rule.grantrule.NihOnlyPublicTransitOrAirfareRule;
import edu.umn.se.trap.rule.grantrule.NonDodGrantNationalRule;
import edu.umn.se.trap.rule.grantrule.SponsoredNoAlcoholRule;
import edu.umn.se.trap.rule.grantrule.SponsoredNoInternetRule;
import edu.umn.se.trap.rule.wellformedrule.ArrivalAfterDepartureRule;
import edu.umn.se.trap.rule.wellformedrule.RequiredFieldsRule;
import edu.umn.se.trap.rule.wellformedrule.ValidDollarAmountRule;

/**
 * @author nick
 * @author Mark
 * 
 *         Creates the checkers for every rule.
 * 
 */
public class FormCheckerFactory
{
    public static FormChecker createWellFormedChecker()
    {
        FormChecker checker = new FormChecker();

        checker.addRule(new RequiredFieldsRule());
        checker.addRule(new ValidDollarAmountRule());
        checker.addRule(new ArrivalAfterDepartureRule());

        return checker;

    }

    public static FormChecker createBusinessRuleChecker()
    {
        FormChecker checker = new FormChecker();

        checker.addRule(new BaggageCostLimitRule());
        checker.addRule(new ExportGrantCitizenRule());
        checker.addRule(new FileDeadlineRule());
        checker.addRule(new GrantAuthorizationRule());
        checker.addRule(new HotelOvernightRule());
        checker.addRule(new ItemizedCostsBetweenDatesRule());
        checker.addRule(new NumBaggageClaimsRule());
        checker.addRule(new PersonalAndRentalCarRule());
        checker.addRule(new TravelTypeMatchesGrantRule());
        checker.addRule(new USCarrierRule());
        checker.addRule(new VisaStatusRule());

        return checker;
    }

    public static FormChecker createGrantRuleChecker()
    {
        FormChecker checker = new FormChecker();

        checker.addRule(new DodGrantHertzRule());
        checker.addRule(new DodNoBreakfastRule());
        checker.addRule(new DodNoForeignRule());
        checker.addRule(new ForeignGrantsForeignTravelOnlyRule());
        checker.addRule(new NihNoFoodRule());
        checker.addRule(new NihOnlyPublicTransitOrAirfareRule());
        checker.addRule(new NonDodGrantNationalRule());
        checker.addRule(new SponsoredNoAlcoholRule());
        checker.addRule(new SponsoredNoInternetRule());

        return checker;
    }
}
