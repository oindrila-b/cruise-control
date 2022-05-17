package com.example.cruisecontrol.cruisecontrol.exceptions;

public class UnableToFindHysteresisForNegativeSpeedException extends Exception{

    public UnableToFindHysteresisForNegativeSpeedException(){
        super("Unable to find Hysteresis Range for the given Negative speed");
    }
}
