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

/**
 * Mimics the currency conversion database.
 * 
 * @author ggay
 *
 */
public class CurrencyDB
{
    /**
     * This type enumerates the fields of the {@link ArrayList} with the conversion 
     * information.
     */
    public static enum CURRENCY_FIELDS
    {
        CURRENCY,               /* Currency to be converted */
        DATE,               	/* Date of conversion */
    };
    
    Map<Currency, Double> currencyInfo = new HashMap<Currency, Double>();
    
    /**
     * This type combines the currency code and date into a single key for  
     * indexing purposes.
     */
    public class Currency implements Comparable<Currency>
    {
        public String currencyCode;
        public String date;
    	
        /**
         * Constructor.  Sets up the object.
         */
        public Currency(String c, String d)
        {
            this.currencyCode=c;
            this.date=d;
        }

        /**
         * Compares equality of two Currency objects.
         * @param object to compare to.
         * @return a Boolean indicating equality.
         */
        @Override
        public boolean equals(Object o)
        {
            if(o==this) return true;
            if(o==null || !(o instanceof Currency)) return false;
            Currency c= Currency.class.cast(o);
            return this.currencyCode.equals(c.currencyCode) && this.date.equals(c.date);
        }

        /**
         * Check the hashcode of a Currency object for equality purposes
         * @return integer hashcode for this Currency object.
         */
        @Override
        public int hashCode()
        {
        	return this.currencyCode.hashCode()*3+this.date.hashCode()*5;
        }
        
      /**
       * Compares two Currency objects for ordering purposes
       * @param Currency to compare to.
       * @return a negative integer, zero, or a positive integer as this 
       * object is less than, equal to, or greater than the specified object.
       */
       public int compareTo(Currency c)
       {
           if(c==this) return 0;
           int code= this.currencyCode.compareTo(c.currencyCode);
           if(code!=0) return code;
           return this.date.compareTo(c.date);
        }

    }
    
    /**
     * Constructor.  Sets up the object.
     */
    public CurrencyDB()
    {
        Currency entry1 = new Currency("eur", /* Currency to be converted */
                                       "20121009");		/* Date */
        Double value=1.5;				/* USD value of 1 unit of that currency 
         									(i.e. 1 EURO = 1.5 USD)*/
        this.currencyInfo.put(entry1, value);
  
        Currency entry2 = new Currency("eur","20121010");
        value=1.50;
        this.currencyInfo.put(entry2, value);
        Currency entry3 = new Currency("eur","20121011");
        value=1.51;
        this.currencyInfo.put(entry3, value);
        Currency entry4 = new Currency("eur","20121012");
        value=1.60;
        this.currencyInfo.put(entry4, value);
        Currency entry5 = new Currency("eur","20121013");
        value=1.58;
        this.currencyInfo.put(entry5, value);
        Currency entry6 = new Currency("eur","20121014");
        value=1.56;
        this.currencyInfo.put(entry6, value);
        Currency entry7 = new Currency("eur","20121015");
        value=1.50;
        this.currencyInfo.put(entry7, value);
        Currency entry8 = new Currency("eur","20121016");
        value=1.70;
        this.currencyInfo.put(entry8, value);
        Currency entry9 = new Currency("eur","20121017");
        value=1.69;
        this.currencyInfo.put(entry9, value);
        Currency entry10 = new Currency("eur","20121018");
        value=1.68;
        this.currencyInfo.put(entry10, value);
        Currency entry11 = new Currency("eur","20121019");
        value=1.68;
        this.currencyInfo.put(entry11, value);
        Currency entry12 = new Currency("eur","20121020");
        value=1.69;
        this.currencyInfo.put(entry12, value);
        Currency entry13 = new Currency("eur","20121021");
        value=1.75;
        this.currencyInfo.put(entry13, value);
        Currency entry14 = new Currency("eur","20121022");
        value=1.70;
        this.currencyInfo.put(entry14, value);
        Currency entry15 = new Currency("eur","20121023");
        value=1.69;
        this.currencyInfo.put(entry15, value);
        Currency entry16 = new Currency("eur","20121024");
        value=1.50;
        this.currencyInfo.put(entry16, value);
        Currency entry17 = new Currency("eur","20121025");
        value=1.50;
        this.currencyInfo.put(entry17, value);
        Currency entry18 = new Currency("eur","20121026");
        value=1.51;
        this.currencyInfo.put(entry18, value);
        Currency entry19 = new Currency("eur","20121027");
        value=1.51;
        this.currencyInfo.put(entry19, value);
        Currency entry20 = new Currency("eur","20121028");
        value=1.50;
        this.currencyInfo.put(entry20, value);
        Currency entry21 = new Currency("eur","20121029");
        value=1.55;
        this.currencyInfo.put(entry21, value);
        Currency entry22 = new Currency("eur","20121030");
        value=1.50;
        this.currencyInfo.put(entry22, value);
        Currency entry23 = new Currency("eur","20121031");
        value=1.60;
        this.currencyInfo.put(entry23, value);
        Currency entry24 = new Currency("eur","20121101");
        value=2.00;
        this.currencyInfo.put(entry24, value);
        Currency entry25 = new Currency("eur","20121102");
        value=2.01;
        this.currencyInfo.put(entry25, value);
        Currency entry26 = new Currency("eur","20121103");
        value=2.00;
        this.currencyInfo.put(entry26, value);
        Currency entry27 = new Currency("eur","20121104");
        value=1.98;
        this.currencyInfo.put(entry27, value);
        Currency entry28 = new Currency("eur","20121105");
        value=1.97;
        this.currencyInfo.put(entry28, value);
        Currency entry29 = new Currency("eur","20121106");
        value=1.95;
        this.currencyInfo.put(entry29, value);
        Currency entry30 = new Currency("eur","20121107");
        value=1.80;
        this.currencyInfo.put(entry30, value);
        Currency entry31 = new Currency("eur","20121108");
        value=1.70;
        this.currencyInfo.put(entry31, value);
        Currency entry32 = new Currency("eur","20121109");
        value=1.71;
        this.currencyInfo.put(entry32, value);
        Currency entry33 = new Currency("eur","20121110");
        value=1.69;
        this.currencyInfo.put(entry33, value);
        Currency entry34 = new Currency("eur","20121111");
        value=1.69;
        this.currencyInfo.put(entry34, value);
        Currency entry35 = new Currency("eur","20121112");
        value=1.71;
        this.currencyInfo.put(entry35, value);
        Currency entry36 = new Currency("eur","20121113");
        value=1.69;
        this.currencyInfo.put(entry36, value);
        Currency entry37 = new Currency("eur","20121114");
        value=1.65;
        this.currencyInfo.put(entry37, value);
        Currency entry38 = new Currency("eur","20121115");
        value=1.66;
        this.currencyInfo.put(entry38, value);
        Currency entry39 = new Currency("eur","20121116");
        value=1.75;
        this.currencyInfo.put(entry39, value);
        Currency entry40 = new Currency("eur","20121117");
        value=1.75;
        this.currencyInfo.put(entry40, value);
        Currency entry41 = new Currency("eur","20121118");
        value=2.00;
        this.currencyInfo.put(entry41, value);
        Currency entry42 = new Currency("eur","20121119");
        value=2.10;
        this.currencyInfo.put(entry42, value);
        Currency entry43 = new Currency("eur","20121120");
        value=2.09;
        this.currencyInfo.put(entry43, value);
        Currency entry44 = new Currency("eur","20121121");
        value=2.10;
        this.currencyInfo.put(entry44, value);
        Currency entry45 = new Currency("eur","20121122");
        value=2.08;
        this.currencyInfo.put(entry45, value);
        Currency entry46 = new Currency("eur","20121123");
        value=2.05;
        this.currencyInfo.put(entry46, value);
        Currency entry47 = new Currency("eur","20121124");
        value=2.00;
        this.currencyInfo.put(entry47, value);
        Currency entry48 = new Currency("eur","20121125");
        value=1.98;
        this.currencyInfo.put(entry48, value);
        Currency entry49 = new Currency("eur","20121126");
        value=1.99;
        this.currencyInfo.put(entry49, value);
        Currency entry50 = new Currency("eur","20121127");
        value=1.89;
        this.currencyInfo.put(entry50, value);
        Currency entry51 = new Currency("eur","20121128");
        value=1.80;
        this.currencyInfo.put(entry51, value);
        Currency entry52 = new Currency("eur","20121129");
        value=1.81;
        this.currencyInfo.put(entry52, value);
        Currency entry53 = new Currency("eur","20121130");
        value=1.80;
        this.currencyInfo.put(entry53, value);
    }
    
    /**
     * Gets the USD value of a currency given a date.
     * @param currency  the currency to be converted.
     * @param date the date of the transaction
     * @return  The USD value for one unit of the specified currency 
     * 			on the given date
     * @throws KeyNotFoundException  if the specified currency or date could not be 
     *      found in the database.
     */
    public Double getConversion(String currency, String date) throws KeyNotFoundException
    {
    	Currency conversion = new Currency(currency.toLowerCase(),date); 
    	Double value = this.currencyInfo.get(conversion);
        if(value == null)
        {
            throw new KeyNotFoundException("Could not find either currency, " + 
                    currency +
                    " or date " + date + " in currency DB.");
        }
        return value;
    }
}
