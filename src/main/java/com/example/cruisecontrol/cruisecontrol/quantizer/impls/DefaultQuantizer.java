package com.example.cruisecontrol.cruisecontrol.quantizer.impls;

import com.example.cruisecontrol.cruisecontrol.exceptions.UnableToFindHysteresisForNegativeSpeedException;
import com.example.cruisecontrol.cruisecontrol.hysteresis.impls.DefaultHysteresisImplementation;
import com.example.cruisecontrol.cruisecontrol.quantizer.Quantizer;
import lombok.extern.slf4j.Slf4j;

/*
* The DefaultQuantizer class implements the interface Quantizer<Integer>
*  */
@Slf4j
public class DefaultQuantizer implements Quantizer<Integer> {

    private Integer previousResult = null;
    private  Integer previousSpeed = null;
    private DefaultHysteresisImplementation hysteresis = new DefaultHysteresisImplementation();


    /*
    *  The quantize method is used to calculate the throttle
    *    level based on the hysteresis range and the provided range of throttle level
    * */


    @Override
    public Integer quantize(Integer speed) throws UnableToFindHysteresisForNegativeSpeedException {
        Integer throttleLevel = null;
        if (previousResult == null){
            throttleLevel =  getThrottleBasedOnSpeed(speed);
            previousSpeed = speed;
            previousResult = throttleLevel;
            return throttleLevel;
        } else {
            if ( hysteresis.recomputeThrottleLevel(previousSpeed, speed)){
                throttleLevel = getThrottleBasedOnSpeed(speed);
                previousResult = throttleLevel;
                previousSpeed = speed;
                   return throttleLevel;
            } else {
                previousSpeed = speed;
                return previousResult;
            }
        }

    }

    /*
    This private method returns the throttle level based on the
    range within which the speed belongs to.
     */

    private Integer getThrottleBasedOnSpeed(Integer speed){

                if (speed >= 0 && speed <= 10){
                    return  1;
                } else if(speed >= 11 && speed <= 20) {
                    return  2;
                }else if (speed >= 21 && speed <= 30) {
                    return  3;
                } else if (speed >= 31 && speed <= 40)  {
                    return 4;
                }else if (speed >= 41 && speed <= 50) {
                    return 5;
                }else if (speed >= 51 && speed <= 60) {
                    return 6;
                } else if (speed >= 61 && speed <= 70) {
                    return 7;
                } else if (speed > 70) {
                    return 7;
                }else {
                    return 0;
                }
    }

}
