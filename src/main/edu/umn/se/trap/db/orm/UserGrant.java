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
package edu.umn.se.trap.db.orm;

import java.util.List;

/**
 * @author nick
 *
 */
public class UserGrant
{
    private String accountNumber;
    private String grantAdmin;
    private String[] authorizedPayees;
    /**
     * @param accountNumber
     * @param grantAdmin
     * @param authorizedPayees
     */
    public UserGrant(String accountNumber, String grantAdmin, String[] authorizedPayees)
    {
	super();
	this.accountNumber = accountNumber;
	this.grantAdmin = grantAdmin;
	this.authorizedPayees = authorizedPayees;
    }
    /**
     * @return the accountNumber
     */
    public String getAccountNumber()
    {
        return accountNumber;
    }
    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }
    /**
     * @return the grantAdmin
     */
    public String getGrantAdmin()
    {
        return grantAdmin;
    }
    /**
     * @param grantAdmin the grantAdmin to set
     */
    public void setGrantAdmin(String grantAdmin)
    {
        this.grantAdmin = grantAdmin;
    }
    /**
     * @return the authorizedPayees
     */
    public String[] getAuthorizedPayees()
    {
        return authorizedPayees;
    }
    /**
     * @param authorizedPayees the authorizedPayees to set
     */
    public void setAuthorizedPayees(String[] authorizedPayees)
    {
        this.authorizedPayees = authorizedPayees;
    }

}
