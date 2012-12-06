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

import java.util.Date;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.form.TrapForm;
import edu.umn.se.trap.rule.AbstractRule;
import edu.umn.se.trap.util.TrapErrors;

/**
 * This class ensures the arrival date is after the departure date
 * 
 * @author nick
 * 
 */
public class ArrivalAfterDepartureRule extends AbstractRule
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
            checkDates(form.getTrip().getDepartureDateTime(), form.getTrip()
                    .getArrivalDateTime());
        }
        else
        {
            throw new TrapException("Invalid TrapForm object: form was null.");
        }
    }

    /**
     * ensures the arrival date is after the departure date. Throws a
     * TrapException if not;
     * 
     * @param departureDateTime
     * @param arrivalDateTime
     * @throws TrapException
     */
    protected void checkDates(Date departureDateTime, Date arrivalDateTime)
            throws TrapException
    {
        if (arrivalDateTime.getTime() <= departureDateTime.getTime())
        {
            throw new TrapException(
                    TrapErrors.INVALID_ARRIVAL_DEPARTURE);
        }

    }

}
