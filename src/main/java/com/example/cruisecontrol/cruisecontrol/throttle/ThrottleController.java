package com.example.cruisecontrol.cruisecontrol.throttle;

import com.example.cruisecontrol.cruisecontrol.exceptions.UnableToFindHysteresisForNegativeSpeedException;
import lombok.Setter;

public interface ThrottleController {


     Double calculateThrottle(final Integer currentSpeed) throws UnableToFindHysteresisForNegativeSpeedException;

     void setCruiseSpeed(final  Integer cruiseSpeed);
}
