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
 * Mimics the grant database.
 * 
 * @author ggay
 *
 */
public class GrantDB
{
    /**
     * This type enumerates the fields of the {@link ArrayList} with the grant 
     * information.
     */
    public static enum GRANT_FIELDS
    {
        ACCOUNT_NUMBER,                 /* Account number */
        ACCOUNT_TYPE,                   /* Account type (Sponsored vs Non-sponsored)*/
        FUNDING_ORGANIZATION,           /* Funding organization */
        ORGANIZATION_TYPE,              /* Organization type 
                                         * (i.e., government, industry, noExport, ngo, foreign) */
        ACCOUNT_BALANCE;                /* Account balance */
    };
    
    Map<String, List<Object>> grantInfo = new HashMap<String, List<Object>>();
    
    /**
     * Constructor.  Sets up the object.
     */
    public GrantDB()
    {
    	/* Example 1: Sponsored Grant */
        ArrayList<Object> grant = new ArrayList<Object>();
        grant.add("010101010101");		/* Account number */
        grant.add("sponsored");			/* Account type */
        grant.add("DARPA"); 			/* Funding organization */
        grant.add("government");		/* Organization type 
        								 * (i.e., government, industry) */
        grant.add((double)2500000);		/* Account balance */
        
        this.grantInfo.put((String) grant.get(GRANT_FIELDS.ACCOUNT_NUMBER.ordinal()), 
                            grant);
        
        /* Example 2: Non-sponsored funds */
        ArrayList<Object> grant2 = new ArrayList<Object>();
        grant2.add("99999");				/* Account number */
        grant2.add("non-sponsored");		/* Account type */
        grant2.add(null); 				/* Funding organization */
        grant2.add("mixed");				/* Organization type */
        grant2.add((double)98000);		/* Account balance */
        
        this.grantInfo.put((String) grant2.get(GRANT_FIELDS.ACCOUNT_NUMBER.ordinal()), 
                           grant2);
        
        /* Example 2: Non-sponsored funds */
        ArrayList<Object> grant3 = new ArrayList<Object>();
        grant3.add("11223344");                /* Account number */
        grant3.add("sponsored");        /* Account type */
        grant3.add(null);               /* Funding organization */
        grant3.add("noExport");                /* Organization type */
        grant3.add((double)50000000);      /* Account balance */
        
        this.grantInfo.put((String) grant3.get(GRANT_FIELDS.ACCOUNT_NUMBER.ordinal()), 
                grant3);
        
        /* Dod Grant Account */
        ArrayList<Object> grant4 = new ArrayList<Object>();
        grant4.add("62735842");                /* Account number */
        grant4.add("sponsored");        /* Account type */
        grant4.add("DOD");               /* Funding organization */
        grant4.add("noExport");                /* Organization type */
        grant4.add((double)63005301.42);      /* Account balance */
        
        this.grantInfo.put((String) grant4.get(GRANT_FIELDS.ACCOUNT_NUMBER.ordinal()), 
                grant4);
        
        /* Foreign Grant Account */
        ArrayList<Object> grant5 = new ArrayList<Object>();
        grant5.add("777555111");                /* Account number */
        grant5.add("sponsored");        /* Account type */
        grant5.add("ForeignGrant");               /* Funding organization */
        grant5.add("foreign");                /* Organization type */
        grant5.add((double)63005301.42);      /* Account balance */
        
        this.grantInfo.put((String) grant5.get(GRANT_FIELDS.ACCOUNT_NUMBER.ordinal()), 
                grant5);
        
        /* Nih Grant Account */
        ArrayList<Object> grant6 = new ArrayList<Object>();
        grant6.add("835938467");                /* Account number */
        grant6.add("sponsored");        /* Account type */
        grant6.add("NIH");               /* Funding organization */
        grant6.add("noExport");                /* Organization type */
        grant6.add((double)63005301.42);      /* Account balance */
        
        this.grantInfo.put((String) grant6.get(GRANT_FIELDS.ACCOUNT_NUMBER.ordinal()), 
                grant6);
        
        /* Low Funds Account */
        ArrayList<Object> grant7 = new ArrayList<Object>();
        grant7.add("111551335674");      /* Account number */
        grant7.add("sponsored");         /* Account type */
        grant7.add("Generic");             /* Funding organization */
        grant7.add("government");        /* Organization type 
                                         * (i.e., government, industry) */
        grant7.add((double)50);     /* Account balance */
        
        this.grantInfo.put((String) grant7.get(GRANT_FIELDS.ACCOUNT_NUMBER.ordinal()), 
                            grant7);
        
        /* Low Funds Foreign Account */
        ArrayList<Object> grant8 = new ArrayList<Object>();
        grant8.add("700554324");      /* Account number */
        grant8.add("sponsored");         /* Account type */
        grant8.add("Low Foreign");             /* Funding organization */
        grant8.add("foreign");        /* Organization type 
                                         * (i.e., government, industry) */
        grant8.add((double)900);     /* Account balance */
        
        this.grantInfo.put((String) grant8.get(GRANT_FIELDS.ACCOUNT_NUMBER.ordinal()), 
                grant8);
        
        /* Low Funds Account 2 */
        ArrayList<Object> grant9 = new ArrayList<Object>();
        grant9.add("444337883");      /* Account number */
        grant9.add("sponsored");         /* Account type */
        grant9.add("Generic2");             /* Funding organization */
        grant9.add("government");        /* Organization type 
                                         * (i.e., government, industry) */
        grant9.add((double)900);     /* Account balance */
        
        this.grantInfo.put((String) grant9.get(GRANT_FIELDS.ACCOUNT_NUMBER.ordinal()), 
                grant9);

    }
    
    /**
     * Gets the grant information as a list of strings.
     * @param accountName  the funding account number to be retrieved.
     * @return  a list containing the grant information.  This contains the
     *      account type, funding organization, organization type, and account 
     *      balance.
     * @throws KeyNotFoundException  if the specified user name could not be 
     *      found in the database.
     */
    public List<Object> getGrantInfo(String accountName) throws KeyNotFoundException
    {
    	
        List<Object> grantInfo = this.grantInfo.get(accountName.toLowerCase());
        if(grantInfo == null)
        {
            throw new KeyNotFoundException("Could not find funding source, " + 
                    accountName +
                    ", in grant DB.");
        }
        return grantInfo;
    }
    
    
    /**
     * Update the account balance for a given account.
     * @param accountName  the account number to be updated.
     * @param newBalance  the new balance of the account.
     * @throws KeyNotFoundException  if the specified user name could not be 
     *      found in the database.
     */
    public void updateAccountBalance(String accountName, Double newBalance) 
            throws KeyNotFoundException
    {
        List<Object> grantInfo = this.grantInfo.get(accountName);
        if(grantInfo == null)
        {
            throw new KeyNotFoundException("Could not find funding source, " + 
                    accountName +
                    ", in grant DB.");
        }

        grantInfo.set(GRANT_FIELDS.ACCOUNT_BALANCE.ordinal(), newBalance);
        this.grantInfo.put(accountName, grantInfo);
    }
}
