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

/**
 * @author nick
 * 
 */
public class User
{
    private String userName;
    private String fullName;
    private String email;
    private String employeeId;
    private String citizenship;
    private String visaStatus;
    private boolean paidByUniversity;

    /**
     * @param userName
     * @param fullName
     * @param email
     * @param employeeId
     * @param citizenship
     * @param visaStatus
     * @param paidByUniversity
     */
    public User(String userName, String fullName, String email, String employeeId, String citizenship, String visaStatus, boolean paidByUniversity)
    {
        super();
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.employeeId = employeeId;
        this.citizenship = citizenship;
        this.visaStatus = visaStatus;
        this.paidByUniversity = paidByUniversity;
    }

    /**
     * @return the userName
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * @return the fullName
     */
    public String getFullName()
    {
        return fullName;
    }

    /**
     * @param fullName
     *            the fullName to set
     */
    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return the eMPLOYEE_ID
     */
    public String getEmployeeId()
    {
        return employeeId;
    }

    /**
     * @param eMPLOYEE_ID
     *            the eMPLOYEE_ID to set
     */
    public void setEmployeeId(String employeeId)
    {
        this.employeeId = employeeId;
    }

    /**
     * @return the citizenship
     */
    public String getCitizenship()
    {
        return citizenship;
    }

    /**
     * @param citizenship
     *            the citizenship to set
     */
    public void setCitizenship(String citizenship)
    {
        this.citizenship = citizenship;
    }

    /**
     * @return the visaStatus
     */
    public String getVisaStatus()
    {
        return visaStatus;
    }

    /**
     * @param visaStatus
     *            the visaStatus to set
     */
    public void setVisaStatus(String visaStatus)
    {
        this.visaStatus = visaStatus;
    }

    /**
     * @return the pAID_BY_UNIVERSITY
     */
    public boolean isPaidByUniversity()
    {
        return paidByUniversity;
    }

    /**
     * @param paidByUniversity
     *            the paidByUniversity to set
     */
    public void setPaidByUniversity(boolean paidByUniversity)
    {
        this.paidByUniversity = paidByUniversity;
    }
}
