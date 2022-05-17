package com.example.cruisecontrol.quantizer;

import com.example.cruisecontrol.cruisecontrol.exceptions.UnableToFindHysteresisForNegativeSpeedException;
import com.example.cruisecontrol.cruisecontrol.quantizer.impls.DefaultQuantizer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/*
*   This test class is for the implementation of the DefaultQuantizer.
*  The test cases here work for positive expected values.
*   The rangeLimitTest uses the quantize method to calculate the throttle level
*
* */

public class DefaultQuantizerTest {

    @Test
    void test() {
        System.out.println("This test works");
    }

   /*
    *   The rangeLimitTest uses the quantize method
    *   From the instance  of  DefaultQuantizer class
    *   to calculate the throttle level for each speed input
    * It also  throws the UnableToFindHysteresisForNegativeSpeedException
    * when it is unable to calculate the throttle level based on the hysteresis range
   */

    @Test
      void rangeLimitTest() throws UnableToFindHysteresisForNegativeSpeedException {
        DefaultQuantizer  quantizer =  new DefaultQuantizer();
        Integer expected = 1;
        Integer actual = quantizer.quantize(9);

        assertEquals(expected, actual, "The quantize method should return the correct throttle value ");

        Integer expectedValue = 1;
        Integer actualValue = quantizer.quantize(11);
        assertEquals(expectedValue, actualValue, "The quantize method should return the correct throttle value ");


        Integer expectedvalue = 2;
        Integer actualvalue = quantizer.quantize(15);
        assertEquals(expectedvalue, actualvalue, "The quantize method should return the correct throttle value ");



    }

    /*
     *   The rangeLimitTestWithNegativeValue uses the quantize method
     *   From the instance  of  DefaultQuantizer class
     *   to calculate the throttle level for each speed input,
     * however here the inputs are mostly negative in nature. It also
     * throws the UnableToFindHysteresisForNegativeSpeedException
     * when it is unable to calculate the throttle level based on the hysteresis range
     */

    @Test
    void rangeLimitTestWithNegativeValue() throws UnableToFindHysteresisForNegativeSpeedException {
        DefaultQuantizer  quantizer =  new DefaultQuantizer();
        Integer expected = 0;
        Integer actual = quantizer.quantize(-20);

        assertEquals(expected, actual, "The quantize method should return the correct throttle value ");

        Integer expectedValue = 2;
        Integer actualValue = quantizer.quantize(-20);

        assertEquals(expectedValue, actualValue, "The quantize method should return the correct throttle value ");

    }


}
