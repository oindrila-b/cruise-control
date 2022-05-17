package com.example.cruisecontrol.cruisecontrol.throttle.impls;

import com.example.cruisecontrol.cruisecontrol.exceptions.UnableToFindHysteresisForNegativeSpeedException;
import com.example.cruisecontrol.cruisecontrol.quantizer.Quantizer;
import com.example.cruisecontrol.cruisecontrol.quantizer.impls.DefaultQuantizer;
import com.example.cruisecontrol.cruisecontrol.throttle.ThrottleController;

public class DefaultThrottleController implements ThrottleController {

    Quantizer<Integer> quantizer = new DefaultQuantizer();
    Integer cruiseSpeed;


    @Override
    public Double calculateThrottle(Integer currentSpeed) throws UnableToFindHysteresisForNegativeSpeedException {
       Integer throttleLevel =  quantizer.quantize(currentSpeed);
        return null;
    }

    @Override
    public void setCruiseSpeed(Integer cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }
}
