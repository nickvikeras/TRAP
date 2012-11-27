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
package edu.umn.se.trap.form;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Mark
 * 
 *         Stores the set of grants. Has functionality to remove grants as
 *         needed.
 * 
 */
public class GrantSet
{

    // Public member variables:
    private Set<FormGrant> grants;

    /**
     * @param grants
     */
    public GrantSet(Set<FormGrant> grants)
    {
        this.grants = grants;
    }

    /**
     * @param accountName
     * 
     * Method for removing grants from the set. For the convenience of the calculator.
     */
    public void removeGrant(String accountName)
    {
        FormGrant grantToRemove = null;
        for (FormGrant grant : grants)
        {
            if (grant.getAccountName().equals(accountName))
            {
                grantToRemove = grant;
            }
        }
        if (grantToRemove != null)
        {
            grants.remove(grantToRemove);
        }
    }

    /**
     * @return the grants
     */
    public Set<FormGrant> getGrants()
    {
        return grants;
    }

    /**
     * @param accountName
     * @return
     */
    public boolean contains(String accountName)
    {
        for (FormGrant fg : this.grants)
        {
            if (StringUtils.equals(fg.getAccountName(), accountName))
            {
                return true;
            }
        }
        return false;
    }

}