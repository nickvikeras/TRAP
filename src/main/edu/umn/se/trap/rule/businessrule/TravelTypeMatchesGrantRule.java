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

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.form.FormGrant;
import edu.umn.se.trap.form.FormUser;
import edu.umn.se.trap.form.GrantSet;
import edu.umn.se.trap.form.TrapForm;
import edu.umn.se.trap.form.Trip;
import edu.umn.se.trap.rule.AbstractRule;

/**
 * @author Mark
 * 
 */
public class TravelTypeMatchesGrantRule extends AbstractRule
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

            GrantSet grantSet = form.getGrantSet();

            if (grantSet == null)
            {
                throw new TrapException(
                        "Invalid TrapForm object: grantSet was null.");
            }

            Set<FormGrant> grants = grantSet.getGrants();

            if (grants == null)
            {
                throw new TrapException(
                        "Invalid TrapForm object: grants was null.");
            }

            Trip trip = form.getTrip();

            if (trip == null)
            {
                throw new TrapException(
                        "Invalid TrapForm object:trip was null.");
            }

            checkExportGrantCitizen(grants, trip);

        }
        else
        {
            throw new TrapException("Invalid TrapForm object: form was null.");
        }

    }

    /**
     * @param grants
     * @param trip
     * @throws TrapException
     */
    protected void checkExportGrantCitizen(Set<FormGrant> grants, Trip trip)
            throws TrapException
    {

        boolean cseSponsored = trip.isTravelTypeCseSponsored();
        boolean dtcSponsored = trip.isTravelTypeDtcSponsored();
        boolean nonSponsored = trip.isTravelTypeNonsponsored();

        /*
         * Iterate over the set and throw an error if any of the grants are
         * non-export.
         */

        Iterator<FormGrant> grantIter = grants.iterator();

        while (grantIter.hasNext())
        {
            FormGrant grant = grantIter.next();

            if (StringUtils.equals(grant.getAccountType(), "Sponsored"))
            {
                // Throw an error if the grant is not sponsored by Dtc or Cse.
                if (!(cseSponsored || dtcSponsored))
                {

                    throw new TrapException(
                            "A trip must be sponsored by Dtc or CSE to charge to a sponsored grant.");

                }

            }
            else if (StringUtils.equals(grant.getAccountType(), "Non-sponsored"))
            {
                // Throw an error if the trip is sponsored and trying to charge
                // to a non-sponsored grant.
                if (!nonSponsored)
                {
                    throw new TrapException(
                            "A trip must be non-sponsored to charge to a non-sponsored grant.");
                }
            }
        }

    }

}
