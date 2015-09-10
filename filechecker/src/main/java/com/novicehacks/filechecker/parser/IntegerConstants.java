package com.novicehacks.filechecker.parser;

/**
 * Integer Constant variables that are used across the application.
 * 
 * @author Sharath Chand Bhaskara for NoviceHacks!
 *
 */
public enum IntegerConstants {

    PrimeForHashcodeCalculations (53);

    private Integer value;

    IntegerConstants (Integer value) {
        this.value = value;
    }

    public Integer value() {
        return this.value;
    }

}
