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
import java.util.List;
import java.util.Set;

import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import edu.umn.se.trap.TrapException;
import edu.umn.se.trap.form.Expense;
import edu.umn.se.trap.form.ExpenseType;
import edu.umn.se.trap.form.FormGrant;
import edu.umn.se.trap.form.FormUser;
import edu.umn.se.trap.form.GrantSet;
import edu.umn.se.trap.form.TransportationExpense;
import edu.umn.se.trap.form.TransportationType;
import edu.umn.se.trap.form.TrapForm;
import edu.umn.se.trap.rule.AbstractRule;
/**
 * @author Andrew
 * 
 */
public class GrantAuthorizationRule extends AbstractRule
{
    @Override
    public void validateRule(TrapForm form) throws TrapException
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
        
        checkGrantAuthorization(grants, formUser);
        
        
    }
    /**
     * @param grants, formUser
     * @throws TrapException
     */
    protected void checkGrantAuthorization(Set<FormGrant> grants, FormUser formUser )
            throws TrapException
    {
        Iterator<FormGrant> grantIter = grants.iterator();
        
        String user = formUser.getFullName();
               
        while (grantIter.hasNext())
        {
            FormGrant grant = grantIter.next();
            
            boolean authorizedFlag = false;

            String[] authorized = grant.getAuthorizedPayees();
            
            
            
            for ( int i=0; i<authorized.length; i++ ){
                if ( StringUtils.equalsIgnoreCase ( user, authorized[i] ) ) {
                    authorizedFlag = true;
                }
            }
            
            if ( authorizedFlag != true ){
                throw new TrapException(
                        "Invalid Grant request: User is not authorized to use this grant");
            }
            

         }

        

       }
    
    
  
}

