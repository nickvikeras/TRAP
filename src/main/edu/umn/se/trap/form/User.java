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
public class User
{

    // Public member variables:
    public String userName;
    public String emergencyContactName;
    public String emergencyContactPhone;
    
    // Getters and setters:
    
    /**
     * @return the userName
     */
    public String getUserName()
    {
        return userName;
    }
    
    /**
     * @param userName the userName to set
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
     * @param emergencyContactName the emergencyContactName to set
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
     * @param emergencyContactPhone the emergencyContactPhone to set
     */
    public void setEmergencyContactPhone(String emergencyContactPhone)
    {
        this.emergencyContactPhone = emergencyContactPhone;
    }
    
}