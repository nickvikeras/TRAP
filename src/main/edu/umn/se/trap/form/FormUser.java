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

/**
 * @author mark
 * 
 */
public class FormUser
{

    // Public member variables:
    private String userName;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String fullName;
    private String email;
    private String employeeId;
    private String citizenship;
    private String visaStatus;
    private boolean paidByUniversity;

    /**
     * @param userName
     * @param emergencyContactName
     * @param emergencyContactPhone
     * @param fullName
     * @param email
     * @param employeeId
     * @param citizenship
     * @param visaStatus
     * @param paidByUniversity
     */
    public FormUser(String userName, String emergencyContactName, String emergencyContactPhone, String fullName, String email, String employeeId, String citizenship, String visaStatus, boolean paidByUniversity)
    {
        super();
        this.userName = userName;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
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
     * @return the emergencyContactName
     */
    public String getEmergencyContactName()
    {
        return emergencyContactName;
    }

    /**
     * @param emergencyContactName
     *            the emergencyContactName to set
     */
    public void setEmergencyContactName(String emergencyContactName)
    {
        this.emergencyContactName = emergencyContactName;
    }

    /**
     * @return the emergencyContactPhone
     */
    public String getEmergencyContactPhone()
    {
        return emergencyContactPhone;
    }

    /**
     * @param emergencyContactPhone
     *            the emergencyContactPhone to set
     */
    public void setEmergencyContactPhone(String emergencyContactPhone)
    {
        this.emergencyContactPhone = emergencyContactPhone;
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
     * @return the employeeId
     */
    public String getEmployeeId()
    {
        return employeeId;
    }

    /**
     * @param employeeId
     *            the employeeId to set
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
     * @return the paidByUniversity
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