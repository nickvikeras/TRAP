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
 * @author nick
 * 
 */
public class Day
{
    private Date date;
    private Double total;
    private Double incidentalTotal;
    private String incidentalJustification;
    /**
     * @param date
     * @param total
     * @param incidentalTotal
     * @param incidentalJustification
     */
    public Day(Date date, Double total, Double incidentalTotal,
            String incidentalJustification)
    {
        super();
        this.date = date;
        this.total = total;
        this.incidentalTotal = incidentalTotal;
        this.incidentalJustification = incidentalJustification;
    }
    /**
     * @return the date
     */
    public Date getDate()
    {
        return date;
    }
    /**
     * @param date the date to set
     */
    public void setDate(Date date)
    {
        this.date = date;
    }
    /**
     * @return the total
     */
    public Double getTotal()
    {
        return total;
    }
    /**
     * @param total the total to set
     */
    public void setTotal(Double total)
    {
        this.total = total;
    }
    /**
     * @return the incidentalTotal
     */
    public Double getIncidentalTotal()
    {
        return incidentalTotal;
    }
    /**
     * @param incidentalTotal the incidentalTotal to set
     */
    public void setIncidentalTotal(Double incidentalTotal)
    {
        this.incidentalTotal = incidentalTotal;
    }
    /**
     * @return the incidentalJustification
     */
    public String getIncidentalJustification()
    {
        return incidentalJustification;
    }
    /**
     * @param incidentalJustification the incidentalJustification to set
     */
    public void setIncidentalJustification(String incidentalJustification)
    {
        this.incidentalJustification = incidentalJustification;
    }
}
