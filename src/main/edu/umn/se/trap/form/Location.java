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

import org.apache.commons.lang3.StringUtils;

/**
 * @author Mark
 * 
 *         Contains the city, state, country for a Trap expense.
 * 
 */
public class Location
{

    // Public member variables:
    private String city;
    private String state;
    private String country;

    // Getters and setters:

    /**
     * @param city
     * @param state
     * @param country
     */
    public Location(String city, String state, String country)
    {
        super();
        this.city = city;
        this.state = state;
        this.country = country;
    }

    /**
     * @return the city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState()
    {
        return state;
    }

    /**
     * @param state
     *            the state to set
     */
    public void setState(String state)
    {
        this.state = state;
    }

    /**
     * @return the country
     */
    public String getCountry()
    {
        return country;
    }

    /**
     * @param country
     *            the country to set
     */
    public void setCountry(String country)
    {
        this.country = country;
    }

    @Override
    public boolean equals(Object location)
    {
        if (location instanceof Location)
        {
            return StringUtils.equalsIgnoreCase(this.city,
                    ((Location) location).getCity())
                    && StringUtils.equalsIgnoreCase(this.country,
                            ((Location) location).getCountry())
                    && StringUtils.equalsIgnoreCase(this.state,
                            ((Location) location).getState());
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        String s = "";
        if (city != null)
        {
            s += city.toLowerCase();
        }
        if (state != null)
        {
            s += state.toLowerCase();
        }
        if (country != null)
        {
            s += country.toLowerCase();
        }
        return s.hashCode();
    }
}