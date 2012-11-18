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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.umn.se.trap.TrapException;

/**
 * @author nick
 * 
 */
public class TrapDateUtil
{
    private static final String formatDateTimeString = "yyyymmdd hhMMss";
    private static final String formatDateString = "yyyymmdd";

    /**
     * @param string
     * @return
     * @throws TrapException
     */
    public static Date parseTrapDateTime(final String dateString) throws TrapException
    {
        DateFormat dateFormat = new SimpleDateFormat(formatDateTimeString);
        try
        {
            return dateFormat.parse(dateString);
        } catch (ParseException e)
        {
            throw new TrapException("unparseable date");
        }
    }

    /**
     * @param string
     * @return
     * @throws TrapException
     */
    public static Date parseTrapDate(final String dateString) throws TrapException
    {
        DateFormat dateFormat = new SimpleDateFormat(formatDateString);
        try
        {
            return dateFormat.parse(dateString);
        } catch (ParseException e)
        {
            throw new TrapException("unparseable date");
        }
    }

    /**
     * @param date
     * @return
     * @throws TrapException
     */
    public static String printDate(Date date)
    {
        DateFormat dateFormat = new SimpleDateFormat(formatDateString);
        return dateFormat.format(date);
    }

    /**
     * @param date
     * @return
     * @throws TrapException
     */
    public static String printDateTime(Date date)
    {
        DateFormat dateFormat = new SimpleDateFormat(formatDateTimeString);
        return dateFormat.format(date);
    }

}
