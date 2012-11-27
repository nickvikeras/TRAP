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
package edu.umn.se.trap.util;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * static Utility functions for TRAP
 * 
 * @author nick
 * 
 */
public class TrapUtil
{

    /** return "yes" if true, "no" if false.
     * 
     * @param b
     * @return
     */
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
     * return a string with the double formated as "0.00"
     * @param d
     * @return
     */
    public static String formatDouble(Double d)
    {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(d);
    }

}
