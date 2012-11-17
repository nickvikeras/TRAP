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

import java.util.Date;


/**
 * @author mark
 * 
 */
public class Trip
{
    
    // Public member variables:
    private Date departureDateTime;
    private Date arrivalDateTime;
    private boolean travelTypeCseSponsored;
    private boolean travelTypeDtcSponsored;
    private boolean travelTypeNonsponsored;
    private String justificationConferenceTitle;
    private boolean justificationPresented;
    private String justificationPresentationTitle;
    private String justificationPresentationAbstract;
    private String justificationPresentationAcknowledgement;
    private String justificationNonsponsored;
    private String justificationSponsored;
    private int numDays;
    
 // Getters and setters:
    
    /**
     * @return the departureDateTime
     */
    public Date getDepartureDateTime()
    {
        return departureDateTime;
    }
    
    /**
     * @param departureDateTime the departureDateTime to set
     */
    public void setDepartureDateTime(Date departureDateTime)
    {
        this.departureDateTime = departureDateTime;
    }
    
    /**
     * @return the arrivalDateTime
     */
    public Date getArrivalDateTime()
    {
        return arrivalDateTime;
    }
    
    /**
     * @param arrivalDateTime the arrivalDateTime to set
     */
    public void setArrivalDateTime(Date arrivalDateTime)
    {
        this.arrivalDateTime = arrivalDateTime;
    }
    
    /**
     * @return the travelTypeCseSponsored
     */
    public boolean isTravelTypeCseSponsored()
    {
        return travelTypeCseSponsored;
    }
    
    /**
     * @param travelTypeCseSponsored the travelTypeCseSponsored to set
     */
    public void setTravelTypeCseSponsored(boolean travelTypeCseSponsored)
    {
        this.travelTypeCseSponsored = travelTypeCseSponsored;
    }
    
    /**
     * @return the travelTypeDtcSponsored
     */
    public boolean isTravelTypeDtcSponsored()
    {
        return travelTypeDtcSponsored;
    }
    
    /**
     * @param travelTypeDtcSponsored the travelTypeDtcSponsored to set
     */
    public void setTravelTypeDtcSponsored(boolean travelTypeDtcSponsored)
    {
        this.travelTypeDtcSponsored = travelTypeDtcSponsored;
    }
    
    /**
     * @return the travelTypeNonsponsored
     */
    public boolean isTravelTypeNonsponsored()
    {
        return travelTypeNonsponsored;
    }
    
    /**
     * @param travelTypeNonsponsored the travelTypeNonsponsored to set
     */
    public void setTravelTypeNonsponsored(boolean travelTypeNonsponsored)
    {
        this.travelTypeNonsponsored = travelTypeNonsponsored;
    }
    
    /**
     * @return the justificationConferenceTitle
     */
    public String getJustificationConferenceTitle()
    {
        return justificationConferenceTitle;
    }
    
    /**
     * @param justificationConferenceTitle the justificationConferenceTitle to set
     */
    public void setJustificationConferenceTitle(String justificationConferenceTitle)
    {
        this.justificationConferenceTitle = justificationConferenceTitle;
    }
    
    /**
     * @return the justificationPresented
     */
    public boolean isJustificationPresented()
    {
        return justificationPresented;
    }
    
    /**
     * @param justificationPresented the justificationPresented to set
     */
    public void setJustificationPresented(boolean justificationPresented)
    {
        this.justificationPresented = justificationPresented;
    }
    
    /**
     * @return the justificationPresentationTitle
     */
    public String getJustificationPresentationTitle()
    {
        return justificationPresentationTitle;
    }
    
    /**
     * @param justificationPresentationTitle the justificationPresentationTitle to set
     */
    public void setJustificationPresentationTitle(
            String justificationPresentationTitle)
    {
        this.justificationPresentationTitle = justificationPresentationTitle;
    }
    
    /**
     * @return the justificationPresentationAbstract
     */
    public String getJustificationPresentationAbstract()
    {
        return justificationPresentationAbstract;
    }
    
    /**
     * @param justificationPresentationAbstract the justificationPresentationAbstract to set
     */
    public void setJustificationPresentationAbstract(
            String justificationPresentationAbstract)
    {
        this.justificationPresentationAbstract = justificationPresentationAbstract;
    }
    
    /**
     * @return the justificationPresentationAcknowledgement
     */
    public String getJustificationPresentationAcknowledgement()
    {
        return justificationPresentationAcknowledgement;
    }
    
    /**
     * @param justificationPresentationAcknowledgement the justificationPresentationAcknowledgement to set
     */
    public void setJustificationPresentationAcknowledgement(
            String justificationPresentationAcknowledgement)
    {
        this.justificationPresentationAcknowledgement = justificationPresentationAcknowledgement;
    }
    
    /**
     * @return the justificationNonsponsored
     */
    public String getJustificationNonsponsored()
    {
        return justificationNonsponsored;
    }
    
    /**
     * @param justificationNonsponsored the justificationNonsponsored to set
     */
    public void setJustificationNonsponsored(String justificationNonsponsored)
    {
        this.justificationNonsponsored = justificationNonsponsored;
    }
    
    /**
     * @return the justificationSponsored
     */
    public String getJustificationSponsored()
    {
        return justificationSponsored;
    }
    
    /**
     * @param justificationSponsored the justificationSponsored to set
     */
    public void setJustificationSponsored(String justificationSponsored)
    {
        this.justificationSponsored = justificationSponsored;
    }
    
    /**
     * @return the numDays
     */
    public int getNumDays()
    {
        return numDays;
    }
    
    /**
     * @param numDays the numDays to set
     */
    public void setNumDays(int numDays)
    {
        this.numDays = numDays;
    }

}