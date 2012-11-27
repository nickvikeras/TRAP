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

import edu.umn.se.trap.form.FormGrant;

/**
 * @author nick
 *
 */
public class FormGrantComparator implements Comparator<FormGrant>
{

    /* (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(FormGrant o1, FormGrant o2)
    {
        if(o1.getAccountBalance() < o2.getAccountBalance()){
            return -1;
        }
        else if(o1.getAccountBalance() == o2.getAccountBalance()){
            return 0;
        }
        else return 1;
       
    }

}
