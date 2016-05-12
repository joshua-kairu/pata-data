package com.jlt.patadata;

/**
 * Copyright 2016 Kairu Joshua Wambugu
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * <p/>
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * <p/>
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// begin class Indicator
// represents an indicator for a World Bank data set
public class Indicator {

    /** CONSTANTS */

    /** VARIABLES */

    /** Strings */

    private String id; // string for the indicator's ID
    private String value; // string for the value of the indicator (which is the unit)

    /** CONSTRUCTOR */

    // begin constructor
    public Indicator( String id, String value ) {

        setId( id );

        setValue( value );

    } // end constructor

    /** METHODS */

    /** Getters and Setters */

    // getter for the ID
    public String getId() { return id; }

    // setter for the ID
    public void setId( String id ) { this.id = id; }

    // getter for the value
    private String getValue() { return value; }

    // setter for the value
    public void setValue( String value ) { this.value = value; }

    /** Overrides */

    @Override
    public String toString() { return "[Indicator: ID = " + getId() + " Unit: " + getUnit()+ "]"; }

    /** Other Methods */

    // getter for the unit of the indicator
    public String getUnit() { return getValue(); }

} // end class Indicator