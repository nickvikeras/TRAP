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

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author nick
 * 
 */
public class TrapUtil
{

    public static String boolToYesNo(boolean b)
    {
        String s = "no";
        if (b)
        {
            s = "yes";
        }
        return s;
    }

    /**
     * @param date
     * @param date2
     * @return
     */
    public static boolean sameDay(Date date1, Date date2)
    {
        if (date1 == null || date2 == null)
        {
            return false;
        }
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal2
                        .get(Calendar.DAY_OF_YEAR);
        return sameDay;

    }
    
    public static String formatDouble(Double d) {        
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(d);
    }

}
