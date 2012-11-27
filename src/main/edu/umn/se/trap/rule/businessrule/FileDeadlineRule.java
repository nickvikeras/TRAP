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
package edu.umn.se.trap.rule.businessrule;

import java.util.Date;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.form.FormUser;
import edu.umn.se.trap.form.TrapForm;
import edu.umn.se.trap.form.Trip;
import edu.umn.se.trap.rule.AbstractRule;

/**
 * @author Mark
 * 
 *         From the TRAP Design Document:
 * 
 *         Requirement: 7 
 *         Description: A form must be submitted 15 days after
 *         the arrival date. This rule checks that.
 * 
 */
public class FileDeadlineRule extends AbstractRule
{

    private final int DEADLINE_DAYS = 15;

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
            Trip trip = form.getTrip();

            if (trip == null)
            {
                throw new TrapException(
                        "Invalid TrapForm object: trip was null.");
            }

            Date arrivalTime = trip.getArrivalDateTime();

            if (arrivalTime == null)
            {
                throw new TrapException(
                        "Invalid TrapForm object: arrivalDateTime was null.");
            }

            Date current = new Date();

            checkDeadline(arrivalTime, current);
        }
        else
        {

            throw new TrapException("Invalid TrapForm object: form was null.");

        }

    }

    /**
     * @param arrival
     * @param current
     * @throws TrapException
     */
    protected void checkDeadline(Date arrival, Date current)
            throws TrapException
    {

        // Get the number of milleseconds in DEADLINE_DAYS.
        Integer deadlineTime = DEADLINE_DAYS * 86400000;

        /*
         * Check to see if the time between the current time and the arrival
         * time is greater than the deadline time. If so, throw an error.
         */
        if ((current.getTime() - arrival.getTime()) > deadlineTime)
        {
            throw new TrapException("Forms must be filed no more than "
                    + DEADLINE_DAYS + " after the arrival time.");
        }

    }

    /**
     * @return the dEADLINE_DAYS
     */
    protected int getDEADLINE_DAYS()
    {
        return DEADLINE_DAYS;
    }

}
