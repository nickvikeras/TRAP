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

import java.util.Comparator;

/**
 * @author nick
 * 
 */
public class DayComparator implements Comparator<Day>
{

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(Day arg0, Day arg1)
    {
        if (arg0.getDate().getTime() < arg1.getDate().getTime())
        {
            return -1;
        }
        else if (arg0.getDate().getTime() == arg1.getDate().getTime())
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

}
