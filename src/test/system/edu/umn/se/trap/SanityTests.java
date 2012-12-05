/**
 * Copyright (c) 2012, Ian De Silva
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

package edu.umn.se.trap;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import edu.umn.se.trap.util.TrapDateUtil;

/**
 * This is a test class for various black box tests. These tests will try to
 * cover the entire scope of information that TRAP can handle.
 * 
 * This test class is built around central tests that use getUser and
 * submitFormData such that every test can use different pairs of input and
 * output maps.
 * 
 * @author Mark
 */
public class SanityTests extends AbstractSystemTest
{
    /**
     * Generates an input form.
     * 
     * @return a valid travel input form for use in testing
     */
    public static Map<String, String> getInputForm2()
    {
        Map<String, String> formData = new HashMap<String, String>();
        formData.put("USER_NAME", "linc001");
        formData.put("ARRIVAL_DATETIME", "20121202 235900");
        formData.put("DEPARTURE_DATETIME", "20121128 100000");

        formData.put("TRAVEL_TYPE_CSE_SPONSORED", "yes");
        formData.put("EMERGENCY_CONTACT_NAME", "Greg Gay");
        formData.put("EMERGENCY_CONTACT_PHONE", "765-432-1098");
        formData.put("JUSTIFICATION_CONFERENCE_TITLE",
                "ASE2012: 26th IEEE/ACM International Conference on "
                        + "Automated Software Engineering");
        formData.put("JUSTIFICATION_PRESENTED", "no");
        formData.put("JUSTIFICATION_SPONSORED",
                "Learn about research in the field.");
        formData.put("NUM_GRANTS", "1");
        formData.put("GRANT1_ACCOUNT", "010101010101");
        formData.put("GRANT1_PERCENT", "100");
        formData.put("NUM_OTHER_EXPENSES", "2");
        formData.put("OTHER1_DATE", "20121003");
        formData.put("OTHER1_JUSTIFICATION", "Conference Registration");
        formData.put("OTHER1_AMOUNT", "450.00");
        formData.put("OTHER1_CURRENCY", "USD");
        formData.put("OTHER2_DATE", "20121003");
        formData.put("OTHER2_JUSTIFICATION", "Workshop Registration");
        formData.put("OTHER2_AMOUNT", "100.00");
        formData.put("OTHER2_CURRENCY", "USD");
        formData.put("NUM_DAYS", "5");
        formData.put("DAY1_LUNCH_CITY", "Minneapolis");
        formData.put("DAY1_LUNCH_STATE", "MN");
        formData.put("DAY1_LUNCH_COUNTRY", "USA");
        formData.put("DAY1_DINNER_CITY", "Minneapolis");
        formData.put("DAY1_DINNER_STATE", "MN");
        formData.put("DAY1_DINNER_COUNTRY", "USA");
        formData.put("DAY1_INCIDENTAL_CITY", "Minneapolis");
        formData.put("DAY1_INCIDENTAL_STATE", "MN");
        formData.put("DAY1_INCIDENTAL_COUNTRY", "USA");
        formData.put("DAY1_INCIDENTAL_AMOUNT", "2.00");
        formData.put("DAY1_INCIDENTAL_CURRENCY", "USD");
        formData.put("DAY1_INCIDENTAL_JUSTIFICATION",
                "A really good justification");
        formData.put("DAY1_LODGING_CITY", "Minneapolis");
        formData.put("DAY1_LODGING_STATE", "MN");
        formData.put("DAY1_LODGING_COUNTRY", "USA");
        formData.put("DAY1_LODGING_AMOUNT", "86.31");
        formData.put("DAY1_LODGING_CURRENCY", "USD");
        formData.put("DAY2_DINNER_CITY", "Lawrence");
        formData.put("DAY2_DINNER_STATE", "KS");
        formData.put("DAY2_DINNER_COUNTRY", "USA");
        formData.put("DAY2_LODGING_CITY", "Lawrence");
        formData.put("DAY2_LODGING_STATE", "KS");
        formData.put("DAY2_LODGING_COUNTRY", "USA");
        formData.put("DAY2_LODGING_AMOUNT", "86.31");
        formData.put("DAY2_LODGING_CURRENCY", "USD");
        formData.put("DAY3_LODGING_CITY", "Lawrence");
        formData.put("DAY3_LODGING_STATE", "KS");
        formData.put("DAY3_LODGING_COUNTRY", "USA");
        formData.put("DAY3_LODGING_AMOUNT", "86.31");
        formData.put("DAY3_LODGING_CURRENCY", "USD");
        formData.put("DAY4_DINNER_CITY", "Lawrence");
        formData.put("DAY4_DINNER_STATE", "KS");
        formData.put("DAY4_DINNER_COUNTRY", "USA");
        formData.put("DAY4_LODGING_CITY", "Lawrence");
        formData.put("DAY4_LODGING_STATE", "KS");
        formData.put("DAY4_LODGING_COUNTRY", "USA");
        formData.put("DAY4_LODGING_AMOUNT", "86.31");
        formData.put("DAY4_LODGING_CURRENCY", "USD");
        formData.put("DAY5_DINNER_CITY", "Des Moines");
        formData.put("DAY5_DINNER_STATE", "IA");
        formData.put("DAY5_DINNER_COUNTRY", "USA");
        formData.put("NUM_TRANSPORTATION", "8");
        formData.put("TRANSPORTATION1_DATE", "20121128");
        formData.put("TRANSPORTATION1_TYPE", "PARKING");
        formData.put("TRANSPORTATION1_AMOUNT", "12.00");
        formData.put("TRANSPORTATION1_CURRENCY", "USD");
        formData.put("TRANSPORTATION1_DATE", "20121128");
        formData.put("TRANSPORTATION1_TYPE", "GAS");
        formData.put("TRANSPORTATION1_AMOUNT", "20.00");
        formData.put("TRANSPORTATION1_CURRENCY", "USD");
        formData.put("TRANSPORTATION2_DATE", "20121129");
        formData.put("TRANSPORTATION2_TYPE", "AIR");
        formData.put("TRANSPORTATION2_AMOUNT", "213.00");
        formData.put("TRANSPORTATION2_CURRENCY", "USD");
        formData.put("TRANSPORTATION2_DATE", "20121129");
        formData.put("TRANSPORTATION2_TYPE", "BAGGAGE");
        formData.put("TRANSPORTATION2_AMOUNT", "5.00");
        formData.put("TRANSPORTATION2_CURRENCY", "USD");
        formData.put("TRANSPORTATION3_DATE", "20121130");
        formData.put("TRANSPORTATION3_TYPE", "TAXI");
        formData.put("TRANSPORTATION3_AMOUNT", "12.00");
        formData.put("TRANSPORTATION3_CURRENCY", "USD");
        formData.put("TRANSPORTATION4_DATE", "20121130");
        formData.put("TRANSPORTATION4_TYPE", "RAIL");
        formData.put("TRANSPORTATION4_AMOUNT", "22");
        formData.put("TRANSPORTATION4_CURRENCY", "USD");
        formData.put("TRANSPORTATION5_DATE", "20121130");
        formData.put("TRANSPORTATION5_TYPE", "TOLL");
        formData.put("TRANSPORTATION5_AMOUNT", "1.65");
        formData.put("TRANSPORTATION5_CURRENCY", "USD");
        formData.put("TRANSPORTATION6_DATE", "20121130");
        formData.put("TRANSPORTATION6_TYPE", "TOLL");
        formData.put("TRANSPORTATION6_AMOUNT", "1.60");
        formData.put("TRANSPORTATION6_CURRENCY", "USD");

        return formData;
    }

    /**
     * Generates a valid output form without the FORM_SUBMISSION_DATETIME field.
     * 
     * @return a valid travel output form for use in testing
     */
    public static Map<String, String> getOutputForm2()
    {
        Map<String, String> formData = new HashMap<String, String>();

        formData.put("NAME", "Lincoln, Abraham");
        formData.put("USER_NAME", "linc001");
        formData.put("EMAIL", "linc001@umn.edu");
        formData.put("CITIZENSHIP", "United States");

        // We omit this because we have to check it separately.
        // formData.put("FORM_SUBMISSION_DATETIME",
        // "This one depends on the test");
        formData.put("DEPARTURE_DATETIME", "20121128 100000");
        formData.put("ARRIVAL_DATETIME", "20121202 235900");
        formData.put("PAID_BY_UNIVERSITY", "yes");
        formData.put("EMERGENCY_CONTACT_NAME", "Greg Gay");
        formData.put("EMERGENCY_CONTACT_PHONE", "765-432-1098");
        formData.put("TRAVEL_TYPE_CSE_SPONSORED", "yes");
        formData.put("JUSTIFICATION_CONFERENCE_TITLE",
                "ASE2012: 26th IEEE/ACM International Conference on "
                        + "Automated Software Engineering");
        formData.put("JUSTIFICATION_PRESENTED", "no");
        formData.put("JUSTIFICATION_SPONSORED",
                "Learn about research in the field.");
        formData.put("NUM_DESTINATIONS", "3");
        formData.put("DESTINATION1_CITY", "Des Moines");
        formData.put("DESTINATION1_STATE", "IA");
        formData.put("DESTINATION1_COUNTRY", "USA");
        formData.put("DESTINATION2_CITY", "Kansas City");
        formData.put("DESTINATION2_STATE", "MO");
        formData.put("DESTINATION2_COUNTRY", "USA");
        formData.put("DESTINATION3_CITY", "Lawrence");
        formData.put("DESTINATION3_STATE", "KS");
        formData.put("DESTINATION3_COUNTRY", "USA");
        formData.put("NUM_DAYS", "5");
        formData.put("DAY1_DATE", "20121128");
        formData.put("DAY1_TOTAL", "111.81");
        formData.put("DAY1_INCIDENTAL_TOTAL", "10.00");
        formData.put("DAY1_INCIDENTAL_JUSTIFICATION",
                "A really good justification");
        formData.put("DAY2_DATE", "20121129");
        formData.put("DAY2_TOTAL", "109.31");
        formData.put("DAY3_DATE", "20121130");
        formData.put("DAY3_TOTAL", "86.31");
        formData.put("DAY4_DATE", "20121201");
        formData.put("DAY4_TOTAL", "109.31");
        formData.put("DAY5_DATE", "20121202");
        formData.put("DAY5_TOTAL", "17.25");
        formData.put("NUM_TRANSPORTATION", "6");
        formData.put("TRANSPORTATION1_DATE", "20121128");
        formData.put("TRANSPORTATION1_TYPE", "PARKING");
        formData.put("TRANSPORTATION1_TOTAL", "12.00");
        formData.put("TRANSPORTATION1_DATE", "20121128");
        formData.put("TRANSPORTATION1_TYPE", "GAS");
        formData.put("TRANSPORTATION1_MILES_TRAVELED", "4");
        formData.put("TRANSPORTATION1_TOTAL", "20.00");
        formData.put("TRANSPORTATION2_DATE", "20121129");
        formData.put("TRANSPORTATION2_TYPE", "AIR");
        formData.put("TRANSPORTATION2_CARRIER", "Delta");
        formData.put("TRANSPORTATION2_TOTAL", "213.00");
        formData.put("TRANSPORTATION2_DATE", "20121129");
        formData.put("TRANSPORTATION2_TYPE", "BAGGAGE");
        formData.put("TRANSPORTATION2_TOTAL", "5.00");
        formData.put("TRANSPORTATION3_DATE", "20121130");
        formData.put("TRANSPORTATION3_TYPE", "TAXI");
        formData.put("TRANSPORTATION3_TOTAL", "12.00");
        formData.put("TRANSPORTATION4_DATE", "20121130");
        formData.put("TRANSPORTATION4_TYPE", "RAIL");
        formData.put("TRANSPORTATION4_TOTAL", "22.00");
        formData.put("TRANSPORTATION5_DATE", "20121130");
        formData.put("TRANSPORTATION5_TYPE", "TOLL");
        formData.put("TRANSPORTATION5_TOTAL", "1.65");
        formData.put("TRANSPORTATION6_DATE", "20121130");
        formData.put("TRANSPORTATION6_TYPE", "TOLL");
        formData.put("TRANSPORTATION6_TOTAL", "1.60");
        formData.put("NUM_OTHER_EXPENSES", "2");
        formData.put("OTHER1_DATE", "20121003");
        formData.put("OTHER1_JUSTIFICATION", "Conference Registration");
        formData.put("OTHER1_TOTAL", "450.00");
        formData.put("OTHER2_DATE", "20121003");
        formData.put("OTHER2_JUSTIFICATION", "Workshop Registration");
        formData.put("OTHER2_TOTAL", "100.00");
        formData.put("NUM_GRANTS", "1");
        formData.put("GRANT1_ACCOUNT", "010101010101");
        formData.put("GRANT1_PERCENT", "100");
        formData.put("GRANT1_AMOUNT_TO_CHARGE", "1046.24");
        formData.put("GRANT1_APPROVER_NAME", "heimd001");
        formData.put("TOTAL_REIMBURSEMENT", "1273.24");

        return formData;
    }

    /**
     * @throws Exception
     */
    @Test
    public void testCase1() throws Exception
    {
        super.testProcessor.setUser("linc001");
        String description = "my form description";
        SystemTestUtil.submitFormData(getBasicFormInput(), description,
                super.testProcessor, getBasicFormOutput());
    }

    /**
     * @throws Exception
     */
    @Test
    public void testCase2() throws Exception
    {

        super.testProcessor.setUser("linc001");
        String description = "my form description";
        SystemTestUtil.submitFormData(getInputForm2(), description,
                super.testProcessor, getOutputForm2());

    }
}
