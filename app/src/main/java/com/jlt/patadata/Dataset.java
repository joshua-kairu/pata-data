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

// begin class Dataset
// represents a World Bank dataset
public class Dataset {

    /** CONSTANTS */

    /** VARIABLES */

    /** Countrys */

    private Country country; // the country of the dataset

    /** Indicators */

    private Indicator indicator; // the dataset's indicator

    /** Primitives */

    private double value; // the value of the data in the dataset

    private int decimal; // the number of decimal places to round off the data to

    /** Strings */

    private String date; // the date of represented by this dataset, which is the dataset's year

    /** CONSTRUCTOR */

    // begin constructor
    public Dataset(

            String countryId, String countryName,

            String indicatorId, String indicatorUnits,

            double value, int decimal, String year ) {

        setCountry( new Country( countryId, countryName ) );

        setIndicator( new Indicator( indicatorId, indicatorUnits ) );

        setValue( value ); setDecimal( decimal ); setDate( year );

    } // end constructor

    /** METHODS */

    /** Getters and Setters */

    // getter for the country
    public Country getCountry() { return country; }

    // setter for the country
    public void setCountry( Country country ) { this.country = country; }

    // getter for the indicator
    public Indicator getIndicator() { return indicator; }

    // setter for the indicator
    public void setIndicator( Indicator indicator ) { this.indicator = indicator; }

    // getter for the value
    public double getValue() { return value; }

    // setter for the value
    private void setValue( double value ) { this.value = value; }

    // getter for the number of decimal places
    private int getDecimal() { return decimal; }

    // setter for the number of decimal places
    private void setDecimal( int decimal ) { this.decimal = decimal; }

    // getter for the date
    private String getDate() { return date; }

    // setter for the date
    private void setDate( String date ) { this.date = date; }

    /** Overrides */

    @Override
    // begin toString
    public String toString() {

        return "{" +
                indicator.toString() + " " +
                country.toString() +
                " value: " + getValue() +
                " number of decimal places: " + getNumberOfDecimalPlaces() +
                " year: " + getYear() +
                "}\n";

    } // end toString

    /** Other Methods */

    // getter for the number of decimal places
    public int getNumberOfDecimalPlaces() { return getDecimal(); }

    // getter for the year
    public int getYear() { return Integer.parseInt( getDate() ); }

} // end class Dataset