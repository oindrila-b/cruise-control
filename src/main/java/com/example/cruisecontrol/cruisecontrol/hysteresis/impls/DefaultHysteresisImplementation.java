package com.example.cruisecontrol.cruisecontrol.hysteresis.impls;

import com.example.cruisecontrol.cruisecontrol.exceptions.UnableToFindHysteresisForNegativeSpeedException;
import com.example.cruisecontrol.cruisecontrol.hysteresis.Hysteresis;

public class DefaultHysteresisImplementation implements Hysteresis {

    /*
    * This method calculates the hysteresis range
    * based on the current speed and previous speed
    * If the current speed is 5 units greater or smaller than
    *  the previous speed , increase range value by 5
    * */

    @Override
    public Integer[] calculateHysteresisRange( Integer previousSpeed ,Integer speed) throws UnableToFindHysteresisForNegativeSpeedException {
        Integer[] range = new Integer[2];
            if (speed >  (previousSpeed+5)  || speed <  (previousSpeed-5)  ) {
                Integer rangeLimit = rangeLimit(speed);
                if (rangeLimit != 0) {
                    range[0] = rangeLimit - 5;
                    range[1] = rangeLimit + 5;
                } else {
                    throw new UnableToFindHysteresisForNegativeSpeedException();
                }
            } else {

                Integer rangeLimit = rangeLimit(previousSpeed);
                range[0] = rangeLimit - 2;
                range[1] = rangeLimit + 2;
            }
    return  range;
    }

    
    /* This method return a boolean value true if the current
    *  speed goes beyond the range fpr the range limit
    *  else if it stays within the range then
    *   it returns false
    * */

    @Override
    public Boolean recomputeThrottleLevel(Integer previousSpeed ,Integer speed) throws UnableToFindHysteresisForNegativeSpeedException {
        Integer[] range = calculateHysteresisRange(previousSpeed, speed);

        if (speed > range[0] && speed < range[1] ){
            return false;
        } else {
            return true;
        }

    }

        /*
        * This private method calculates what
        *  range should be considered while calculating the
        * hysteresis range
        */

    private Integer rangeLimit(Integer speed){
        if (speed >= 0 && speed <= 10){
            return  10;
        } else if(speed >= 11 && speed <= 20) {
            return  20;
        }else if (speed >= 21 && speed <= 30) {
            return  30;
        } else if (speed >= 31 && speed <= 40)  {
            return 40;
        }else if (speed >= 41 && speed <= 50) {
            return 50;
        }else if (speed >= 51 && speed <= 60) {
            return 60;
        } else if (speed >= 61 && speed <= 70) {
            return 70;
        } else if (speed > 70) {
            return 7;
        } else{
            return 0;
        }
    }
}
