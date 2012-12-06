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

import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.form.FormGrant;
import edu.umn.se.trap.form.FormUser;
import edu.umn.se.trap.form.GrantSet;
import edu.umn.se.trap.form.TrapForm;
import edu.umn.se.trap.rule.AbstractRule;
import edu.umn.se.trap.util.TrapErrors;

/**
 * @author Mark
 * 
 *         From the TRAP Design Document:
 * 
 *         Requirement: 1 Description: The user must be a US citizen in order to
 *         use a non-export grant. This rule will check this.
 * 
 */
public class ExportGrantCitizenRule extends AbstractRule
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

            FormUser formUser = form.getUser();

            if (formUser == null)
            {
                throw new TrapException(
                        "Invalid TrapForm object: user was null.");
            }

            checkExportGrantCitizen(grants, formUser);

        }
        else
        {
            throw new TrapException("Invalid TrapForm object: form was null.");
        }

    }

    /**
     * @param grants
     * @param formUser
     * @throws TrapException
     */
    protected void checkExportGrantCitizen(Set<FormGrant> grants,
            FormUser formUser) throws TrapException
    {

        if (formUser.getCitizenship().equalsIgnoreCase("united states")
                || formUser.getCitizenship().equalsIgnoreCase("usa"))
        {
            return;
        }
        else
        {
            for (FormGrant grant : grants)
            {
                if (StringUtils.equalsIgnoreCase(grant.getOrganizationType(),
                        "noExport"))
                {
                    throw new TrapException(
                            TrapErrors.NONCITIZEN_EXPORT);
                }
            }

        }

    }

}
