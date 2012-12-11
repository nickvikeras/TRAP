//        formData.put("DEPARTURE_DATETIME",
//                TrapDateUtil.printDateTime(departureDate));
//        formData.put("ARRIVAL_DATETIME",
//                TrapDateUtil.printDateTime(arrivalDate));

package edu.umn.se.trap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umn.se.trap.util.TrapDateUtil;

public class TripNumDaysSystemTest extends AbstractSystemTest {
	
	  /* (non-Javadoc)
     * @see edu.umn.se.trap.AbstractSystemTest#setUp()
     */
    @Before
    public void setUp() throws Exception
    {
        super.setUp();
    }

    /* (non-Javadoc)
     * @see edu.umn.se.trap.AbstractSystemTest#tearDown()
     */
    @After
    public void tearDown() throws Exception
    {
        super.tearDown();
    }
	    
    
    //Create and save a valid form
    @Test
    public void SaveValidDatesTest() throws Exception
    {
    	Map<String, String> input = getBasicFormInput();
    	Map<String, String> output = getBasicFormOutput();
    	
        input.put("DEPARTURE_DATETIME",
                TrapDateUtil.printDateTime(departureDate));
        input.put("ARRIVAL_DATETIME",
                TrapDateUtil.printDateTime(arrivalDate));
       
    	
    	
    	
        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            fail("No exception should have been thrown");
        }
    	
    	
    	
    }
    
    //Create and save a valid form
    @Test
    public void SaveInValidDatesTest() throws Exception
    {
    	Map<String, String> input = getBasicFormInput();
    	Map<String, String> output = getBasicFormOutput();
    	
    	
        input.put("DEPARTURE_DATETIME",
                TrapDateUtil.printDateTime(arrivalDate));
        input.put("ARRIVAL_DATETIME",
                TrapDateUtil.printDateTime(departureDate));
       
    	
    	
    	
        try
        {
            SystemTestUtil.submitFormData(input, "desc", testProcessor, output);
        }
        catch (TrapException e)
        {
            assertEquals(TrapException.class, e.getMessage());
            return; 
        }
        fail("An exception should have been thrown");
    	
    	
    }


}
