package com.example.cruisecontrol.cruisecontrol.quantizer;

import com.example.cruisecontrol.cruisecontrol.exceptions.UnableToFindHysteresisForNegativeSpeedException;

public interface Quantizer <T>{

    T quantize(T speed) throws UnableToFindHysteresisForNegativeSpeedException;
}
