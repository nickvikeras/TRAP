/**
 * Copyright (c) 2012, Ian De Silva, Gregory Gay
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 * 
 * - Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice, 
 *   this list of conditions and the following disclaimer in the documentation 
 *   and/or other materials provided with the distribution.
 * - Neither the name of the University of Minnesota nor the names of its 
 *   contributors may be used to endorse or promote products derived from this 
 *   software without specific prior written permission.
 *   
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 */
package edu.umn.se.trap.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Mimics the database of meal/incidental per diems.
 * 
 * @author ggay
 * 
 */
public class PerDiemDB
{
    /**
     * This type enumerates the fields of the {@link ArrayList} with the per
     * diem information.
     */
    public static enum RATE_FIELDS
    {
        BREAKFAST_RATE, /* Breakfast rate in USD */
        LUNCH_RATE, /* Lunch rate in USD */
        DINNER_RATE, /* Dinner rate in USD */
        INCIDENTAL_CEILING, /* Incidental ceiling in USD */
        LODGING_CEILING; /* Lodging ceiling in USD */
    };

    Map<Location, List<Double>> perDiemInfo = new HashMap<Location, List<Double>>();

    /**
     * This type combines the city, state, and country into a single key for
     * indexing purposes.
     */
    public class Location implements Comparable<Location>
    {
        public String city;
        public String state;
        public String country;

        /**
         * Constructor. Sets up the object.
         */
        public Location(String ci, String s, String co)
        {
            this.city = ci;
            this.state = s;
            this.country = co;
        }

        /**
         * Compares equality of two Location objects.
         * 
         * @param object
         *            to compare to.
         * @return a Boolean indicating equality.
         */
        @Override
        public boolean equals(Object o)
        {
            if (o == this)
                return true;
            if (o == null || !(o instanceof Location))
                return false;
            Location l = Location.class.cast(o);
            return city.equals(l.city) && state.equals(l.state)
                    && country.equals(l.country);
        }

        /**
         * Check the hashcode of a Location object for equality purposes
         * 
         * @return integer hashcode for this Location object.
         */
        @Override
        public int hashCode()
        {
            return this.city.hashCode() * 3 + this.state.hashCode() * 5
                    + this.country.hashCode() * 7;
        }

        /**
         * Compares two Location objects for ordering purposes
         * 
         * @param Location
         *            to compare to.
         * @return a negative integer, zero, or a positive integer as this
         *         object is less than, equal to, or greater than the specified
         *         object.
         */
        public int compareTo(Location l)
        {
            if (l == this)
                return 0;
            int c = city.compareTo(l.city);
            if (c != 0)
                return c;
            int s = state.compareTo(l.state);
            if (s != 0)
                return s;
            return country.compareTo(l.country);
        }

    }

    /**
     * Constructor. Sets up the object.
     */
    public PerDiemDB()
    {
        /* Example 1: Domestic */

        Location location = new Location("minneapolis", /* City. */
        "mn", /* State. Only applicable for domestic travel. */
        "united states"); /* Country */
        ArrayList<Double> rates = new ArrayList<Double>();
        rates.add(7.0); /* Breakfast rate in USD */
        rates.add(12.0); /* Lunch rate in USD */
        rates.add(26.0); /* Dinner rate in USD */
        rates.add(5.0); /* Incidental ceiling in USD */
        rates.add(150.0); /* Lodging ceiling in USD */

        this.perDiemInfo.put(location, rates);

        /* Example 2: International, specific city */

        Location location2 = new Location("zurich", "", "switzerland");
        ArrayList<Double> rates2 = new ArrayList<Double>();
        rates2.add(12.0); /* Breakfast rate in USD */
        rates2.add(25.0); /* Lunch rate in USD */
        rates2.add(50.0); /* Dinner rate in USD */
        rates2.add(20.0); /* Incidental ceiling in USD */
        rates2.add(225.0); /* Lodging ceiling in USD */

        this.perDiemInfo.put(location2, rates2);

        /* Example 3: International, country rate */

        Location location3 = new Location("", "", "switzerland");
        ArrayList<Double> rates3 = new ArrayList<Double>();
        rates3.add(10.0); /* Breakfast rate in USD */
        rates3.add(20.0); /* Lunch rate in USD */
        rates3.add(40.0); /* Dinner rate in USD */
        rates3.add(20.0); /* Incidental ceiling in USD */
        rates3.add(250.0); /* Hotel ceiling in USD */

        this.perDiemInfo.put(location3, rates3);

        Location location4 = new Location("des moines", "ia", "united states");
        ArrayList<Double> rates4 = new ArrayList<Double>();
        rates4.add(7.0); /* Breakfast rate in USD */
        rates4.add(11.0); /* Lunch rate in USD */
        rates4.add(23.0); /* Dinner rate in USD */
        rates4.add(5.0); /* Incidental ceiling in USD */
        rates4.add(150.0); /* Hotel ceiling in USD */

        this.perDiemInfo.put(location4, rates4);
        
        Location location7 = new Location("", "ia", "");
        
        this.perDiemInfo.put(location7, rates4);
        
        Location location8 = new Location("", "", "usa");
        
        this.perDiemInfo.put(location8, rates4);
        
        Location location9 = new Location("", "ia", "united states");
        
        this.perDiemInfo.put(location9, rates4);

        // NOTE, I'm using the same rates here. If the rates change for 1,
        // even at runtime, they will all change!

        // Same rates for Kansas City, MO
        Location location5 = new Location("kansas city", "mo", "united states");
        this.perDiemInfo.put(location5, rates4);

        // Same rates for Lawrence, KS
        Location location6 = new Location("lawrence", "ks", "united states");
        this.perDiemInfo.put(location6, rates4);

        this.perDiemInfo.put(location3, rates3);
    }

    /**
     * Gets domestic per diem rates as a list of strings.
     * 
     * @param city
     *            the name of the city where a meal was purchased.
     * @param state
     *            the state where the meal was purchased.
     * @return a list containing the per diem rates, broken down by type. This
     *         contains breakfast, lunch, dinner, and incidentals - all in USD.
     *         A null or empty list returned from this method should be treated
     *         as an invalid city/state pairing.
     * @throws KeyNotFoundException
     *             if the specified city/state pairing could not be found in the
     *             database.
     */
    public List<Double> getDomesticPerDiem(String city, String state)
            throws KeyNotFoundException
    {
        Location location = new Location(city.toLowerCase(),
                state.toLowerCase(), "united states");
        List<Double> rateInfo = this.perDiemInfo.get(location);
        if (rateInfo == null)
        {
            throw new KeyNotFoundException("Could not find city, " + city
                    + ", in the database.");
        }
        return rateInfo;
    }

    /**
     * Gets domestic per diem rates as a list of strings.
     * 
     * @param state
     *            the state where the meal was purchased.
     * @return a list containing the per diem rates, broken down by type. This
     *         contains breakfast, lunch, dinner, incidentals, and lodging - all
     *         in USD. A null or empty list returned from this method should be
     *         treated as an invalid state input. The {@link RATE_FIELDS} enum
     *         is provided to help you index the list.
     * @throws KeyNotFoundException
     *             if the specified state could not be found in the database.
     */
    public List<Double> getDomesticPerDiem(String state)
            throws KeyNotFoundException
    {
        Location location = new Location("", state.toLowerCase(),
                "united states");
        List<Double> rateInfo = this.perDiemInfo.get(location);
        if (rateInfo == null)
        {
            throw new KeyNotFoundException("Could not find state, " + state
                    + ", in the database.");
        }
        return rateInfo;
    }

    /**
     * Gets international per diem rates as a list of strings.
     * 
     * @param city
     *            the name of the city where a meal was purchased.
     * @param country
     *            the country where the meal was purchased.
     * @return a list containing the per diem rates, broken down by type. This
     *         contains breakfast, lunch, dinner, incidentals, and lodging - all
     *         in USD. A null or empty list returned from this method should be
     *         treated as an invalid city/country pairing. The
     *         {@link RATE_FIELDS} enum is provided to help you index the list.
     * @throws KeyNotFoundException
     *             if the specified city/country pairing could not be found in
     *             the database.
     */
    public List<Double> getInternationalPerDiem(String city, String country)
            throws KeyNotFoundException
    {
        Location location = new Location(city.toLowerCase(), "",
                country.toLowerCase());
        List<Double> rateInfo = this.perDiemInfo.get(location);
        if (rateInfo == null)
        {
            throw new KeyNotFoundException("Could not find city, " + city
                    + ", in the database.");
        }
        return rateInfo;
    }

    /**
     * Gets international per diem rates as a list of strings.
     * 
     * @param country
     *            the country where the meal was purchased.
     * @return a list containing the per diem rates, broken down by type. This
     *         contains breakfast, lunch, dinner, and incidentals - all in USD.
     *         A null or empty list returned from this method should be treated
     *         as an invalid country input. The {@link RATE_FIELDS} enum is
     *         provided to help you index the list.
     * @throws KeyNotFoundException
     *             if the specified country could not be found in the database.
     */
    public List<Double> getInternationalPerDiem(String country)
            throws KeyNotFoundException
    {
        Location location = new Location("", "", country.toLowerCase());
        List<Double> rateInfo = this.perDiemInfo.get(location);
        if (rateInfo == null)
        {
            throw new KeyNotFoundException("Could not find country, " + country
                    + ", in the database.");
        }
        return rateInfo;
    }
}
