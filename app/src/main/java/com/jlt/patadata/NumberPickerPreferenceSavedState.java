package com.jlt.patadata;

import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;

/**
 *
 * Pata Data - Displays World Bank JSON on Kenya
 *
 * Copyright (C) 2016 Kairu Joshua Wambugu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 */

// begin class NumberPickerPreferenceSavedState
// handles state changes such as orientation change
public class NumberPickerPreferenceSavedState extends Preference.BaseSavedState {

    /** CONSTANTS */

    /* Creators */

    public static final

    // begin Parcelable.Creator< NumberPickerPreferenceSavedState > CREATOR = new Parcelable.Creator< NumberPickerPreferenceSavedState >
    Parcelable.Creator< NumberPickerPreferenceSavedState > CREATOR = new Parcelable.Creator< NumberPickerPreferenceSavedState >() {

        @Override
        // begin createFromParcel
        // creates a new NumberPickerPreferenceSavedState from the given Parcel
        // whose data had previously been written by writeToParcel()
        public NumberPickerPreferenceSavedState createFromParcel( Parcel source ) {

            return new NumberPickerPreferenceSavedState( source );

        } // end createFromParcel

        @Override
        // begin newArray
        // creates a new array of NumberPickerPreferenceSavedStates.
        public NumberPickerPreferenceSavedState[] newArray( int size ) {

            return new NumberPickerPreferenceSavedState[ size ];

        } // end newArray

    }; // end Parcelable.Creator< NumberPickerPreferenceSavedState > CREATOR = new Parcelable.Creator< NumberPickerPreferenceSavedState >

    /** VARIABLES */

    /* Primitives */

    private int value; // hold's the setting's current value

    /** CONSTRUCTOR */

    // constructor
    // does super things
    public NumberPickerPreferenceSavedState( Parcelable superState ) { super( superState ); }

    // begin parcel constructor
    public NumberPickerPreferenceSavedState( Parcel source ) {
        
        // 0. super things
        // 1. get the current preference's value (from the parcelable)

        // 0. super things
        
        super( source );

        // 1. get the current preference's value (from the parcelable)

        //
        setValue( source.readInt() );

    } // end parcel constructor

    /** METHODS */

    /** Getters and Setters */

    // getter for the value
    public int getValue() { return value; }

    // setter for the value
    public void setValue( int value ) { this.value = value; }

    /** Overrides */

    @Override
    // begin writeToParcel
    // flattens this object in to a Parcel.
    // dest - The Parcel in which the object should be written.
    // flags - Additional flags about how the object should be written. May be 0 or PARCELABLE_WRITE_RETURN_VALUE.
    public void writeToParcel( Parcel dest, int flags ) {

        // 0. super things
        // 1. write the preference's value to the destination parcel

        // 0. super things

        super.writeToParcel( dest, flags );

        // 1. write the preference's value to the destination parcel

        dest.writeInt( getValue() );

    } // end writeToParcel

    /** Other Methods */

} // end class NumberPickerPreferenceSavedState