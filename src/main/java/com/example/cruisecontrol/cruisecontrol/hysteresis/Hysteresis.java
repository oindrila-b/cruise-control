package com.example.cruisecontrol.cruisecontrol.hysteresis;

import com.example.cruisecontrol.cruisecontrol.exceptions.UnableToFindHysteresisForNegativeSpeedException;

public interface Hysteresis {

    Integer[] calculateHysteresisRange(Integer previousSpeed , Integer speed) throws UnableToFindHysteresisForNegativeSpeedException;

    Boolean recomputeThrottleLevel(Integer previousSpeed ,Integer speed) throws UnableToFindHysteresisForNegativeSpeedException;

}
