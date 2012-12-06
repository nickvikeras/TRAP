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
package edu.umn.se.trap.rule.wellformedrule;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.form.Expense;
import edu.umn.se.trap.form.ExpenseType;
import edu.umn.se.trap.form.FormGrant;
import edu.umn.se.trap.form.FormUser;
import edu.umn.se.trap.form.GrantSet;
import edu.umn.se.trap.form.Location;
import edu.umn.se.trap.form.TrapForm;
import edu.umn.se.trap.form.Trip;
import edu.umn.se.trap.rule.AbstractRule;
import edu.umn.se.trap.util.TrapErrors;

/**
 * @author Mark
 * 
 *         From the TRAP Design Document:
 * 
 *         Requirement: 12 Description: This rule checks that all required
 *         fields are filled out.
 * 
 */
public class RequiredFieldsRule extends AbstractRule
{

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.umn.se.trap.rule.AbstractRule#validateRule(edu.umn.se.trap.form.TrapForm
     * )
     */
    @Override
    public void validateRule(TrapForm form) throws TrapException
    {
        if (form != null)
        {
            checkRequiredFields(form);

        }
        else
        {
            throw new TrapException("Invalid TrapForm object: form was null.");
        }

    }

    /**
     * @param form
     * @throws TrapException
     * 
     *             Check each major part of the form.
     * 
     */
    private void checkRequiredFields(TrapForm form) throws TrapException
    {

        if (form.getUser() != null)
        {
            checkUser(form.getUser());
        }
        else
        {
            throw new TrapException("Invalid TrapForm object: user was null.");
        }

        if (form.getTrip() != null)
        {
            checkTrip(form.getTrip());
        }
        else
        {
            throw new TrapException("Invalid TrapForm object: trip was null.");
        }

        if (form.getExpenses() != null)
        {
            checkExpenses(form.getExpenses());
        }
        else
        {
            throw new TrapException(
                    "Invalid TrapForm object: expenses was null.");
        }

        if (form.getGrantSet() != null)
        {
            checkGrants(form.getGrantSet());
        }
        else
        {
            throw new TrapException(
                   "Invalid TrapForm object: grantSet was null.");
        }
    }

    /**
     * @param grantSet
     * @throws TrapException
     * 
     *             Check the accountName of each grant.
     * 
     */
    private void checkGrants(GrantSet grantSet) throws TrapException
    {
        Set<FormGrant> grants = grantSet.getGrants();

        if (grants == null)
        {
            throw new TrapException(
                    TrapErrors.NO_GRANTS);
        }

        Iterator<FormGrant> grantIter = grants.iterator();

        while (grantIter.hasNext())
        {
            FormGrant grant = grantIter.next();

            if (grant.getAccountName() == null)
            {
                throw new TrapException(
                        TrapErrors.NO_ACCOUNT_NUMBER);
            }
        }

    }

    /**
     * @param expenses
     * @throws TrapException
     * 
     *             Check that the date, type, and location fields are not empty.
     * 
     */
    private void checkExpenses(List<Expense> expenses) throws TrapException
    {
        if (expenses != null && !expenses.isEmpty())
        {
            for (Expense expense : expenses)
            {

                if (expense.getDate() == null)
                {
                    throw new TrapException(
                            TrapErrors.NO_EXPENSE_DATE);
                }

                if (expense.getType() == null)
                {
                    throw new TrapException(
                            TrapErrors.NO_EXPENSE_TYPE);
                }
                else
                {
                    if (expense.getType().equals(ExpenseType.INCIDENTAL)
                            || expense.getType().equals(ExpenseType.OTHER))
                    {
                        if (expense.getJustification() == null)
                        {
                            throw new TrapException(
                                    TrapErrors.NO_JUSTIFICATION);
                        }
                    }
                }

                Location location = expense.getLocation();

                if (!expense.getType().equals(ExpenseType.OTHER)
                        && !expense.getType()
                                .equals(ExpenseType.TRANSPORTATION)
                        && location == null)
                {
                    throw new TrapException(
                            TrapErrors.NO_EXPENSE_LOCATION);
                }

            }
        }
        else
        {
            throw new TrapException(
                    TrapErrors.NO_EXPENSES);
        }

    }

    /**
     * @param trip
     * @throws TrapException
     * 
     *             Checks that each field of the trip is not empty. Some fields
     *             are checked depending on a boolean argument within trip.
     * 
     */
    private void checkTrip(Trip trip) throws TrapException
    {
        if ((trip.getDepartureDateTime() == null))
        {
            throw new TrapException(
                    "Required field missing: departure date/time.");
        }

        if ((trip.getArrivalDateTime() == null))
        {
            throw new TrapException(
                    TrapErrors.NO_DEPARTURE_TIME );
        }

        if (!(trip.isTravelTypeCseSponsored()
                || trip.isTravelTypeDtcSponsored() || trip
                    .isTravelTypeNonsponsored()))
        {
            throw new TrapException(
                    TrapErrors.NO_TRAVEL_TYPE);
        }

        if (trip.getJustificationConferenceTitle() == null)
        {
            throw new TrapException(TrapErrors.NO_CONF_TITLE);
        }

        if (trip.isTravelTypeCseSponsored() || trip.isTravelTypeDtcSponsored())
        {
            if (trip.getJustificationSponsored() == null)
            {
                throw new TrapException(
                        TrapErrors.NO_JUSTIFICATION);
            }
        }

        if (trip.isTravelTypeNonsponsored())
        {
            if (trip.getJustificationNonsponsored() == null)
            {
                throw new TrapException(
                        TrapErrors.NO_JUSTIFICATION);
            }
        }

        if (trip.isJustificationPresented())
        {
            if (trip.getJustificationPresentationTitle() == null)
            {
                throw new TrapException(
                        TrapErrors.PRES_TITLE);
            }

            if (trip.getJustificationPresentationAbstract() == null)
            {
                throw new TrapException(
                        TrapErrors.NO_ABSTRACT);
            }

            if (trip.getJustificationPresentationAcknowledgement() == null)
            {
                throw new TrapException(
                        TrapErrors.MISSING_ACKNOWLEDGEMENT);
            }
        }

    }

    /**
     * @param user
     * @throws TrapException
     * 
     *             Checks to make sure the user name and the citizenship/visa
     *             status is not empty.
     * 
     */
    private void checkUser(FormUser user) throws TrapException
    {

        if ((user.getUserName() == null))
        {
            throw new TrapException(TrapErrors.NO_X500);
        }

        if (user.getCitizenship() == null)
        {
            throw new TrapException(
                    TrapErrors.NO_CITIZENSHIP);
        }

        if (!StringUtils.equalsIgnoreCase(user.getCitizenship(),
                "United States")
                && !StringUtils.equalsIgnoreCase(user.getCitizenship(), "USA")
                && user.getVisaStatus() == null)
        {
            throw new TrapException(TrapErrors.NO_VISA_STATUS);
        }
    }

}
