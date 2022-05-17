package com.example.cruisecontrol.hysteresis;

import com.example.cruisecontrol.cruisecontrol.exceptions.UnableToFindHysteresisForNegativeSpeedException;
import com.example.cruisecontrol.cruisecontrol.hysteresis.impls.DefaultHysteresisImplementation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DefaultHysteresisImplementationTest {

    @Test
    void calculateHysteresisRange() throws UnableToFindHysteresisForNegativeSpeedException {

        DefaultHysteresisImplementation hysteresis = new DefaultHysteresisImplementation();

        Integer[] expectedRange = {8,12};
        Integer[] actualRange  = hysteresis.calculateHysteresisRange(8, 10);

        assertArrayEquals(expectedRange, actualRange, "The expected range doesn't match with the actual range output");


    }

    @Test
    void calculateHysteresisRangeWithSpeedDiffMoreThanFive() throws UnableToFindHysteresisForNegativeSpeedException {
        DefaultHysteresisImplementation hysteresis = new DefaultHysteresisImplementation();

        Integer[] expected = {15,25};
        Integer[] actual  = hysteresis.calculateHysteresisRange(8,  14);

        assertArrayEquals(expected, actual, "The expected range doesn't match with the actual range output");


    }

    @Test
    void calculateHysteresisRangeWithSpeedDiffMoreThanTwo() throws UnableToFindHysteresisForNegativeSpeedException {
        DefaultHysteresisImplementation hysteresis = new DefaultHysteresisImplementation();

        Integer[] expected = {8,12};
        Integer[] actual  = hysteresis.calculateHysteresisRange(10,  12);

        assertArrayEquals(expected, actual, "The expected range doesn't match with the actual range output");

    }

    @Test
    void calculateHysteresisRangeWithNegativeSpeed() throws UnableToFindHysteresisForNegativeSpeedException {
        DefaultHysteresisImplementation hysteresis = new DefaultHysteresisImplementation();

        Integer[] expected = {8,12};
        Integer[] actual  = hysteresis.calculateHysteresisRange(10,  -2);

        assertArrayEquals(expected, actual, "The expected range doesn't match with the actual range output");

    }

    @Test
    void recomputeThrottleLevel() throws UnableToFindHysteresisForNegativeSpeedException {
        DefaultHysteresisImplementation hysteresis = new DefaultHysteresisImplementation();

       Boolean expected = false;
       Boolean actual = hysteresis.recomputeThrottleLevel( 6, 10 );

        assertEquals(expected, actual, "The expected boolean value  doesn't match with the actual range output");

    }

    @Test
    void recomputeThrottleLevelWithDifferenceInSpeedMoreThanFive() throws UnableToFindHysteresisForNegativeSpeedException {
        DefaultHysteresisImplementation hysteresis = new DefaultHysteresisImplementation();

        Boolean expected = false;
        Boolean actual = hysteresis.recomputeThrottleLevel( 6, 13 );

        assertEquals(expected, actual, "The expected boolean value  doesn't match with the actual range output");

    }

}
