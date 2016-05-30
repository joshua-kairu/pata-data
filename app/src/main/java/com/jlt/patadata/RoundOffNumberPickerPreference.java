package com.jlt.patadata;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;

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

// begin class RoundOffNumberPickerPreference
// allows a user to choose a number for rounding off to
public class RoundOffNumberPickerPreference extends DialogPreference {

    /** CONSTANTS */

    /** VARIABLES */

    /* Number Pickers */

    private NumberPicker numberPicker; // a number picker

    /* Primitives */

    private int

    minimumNumber; // the minimum number

    private int currentNumber; // the current preference number

    private int maximumNumber, // the maximum number

    defaultRoundOff; // the default round off

    /** CONSTRUCTOR */

    // begin constructor
    public RoundOffNumberPickerPreference( Context context, AttributeSet attrs ) {

        // 0. super things
        // 1. use the number picker layout
        // 2. set the OK button text
        // 3. set the Cancel button text
        // 4. do not use an icon for the dialog
        // 5. use the minimum from the round off array
        // 6. use the maximum from the round off array
        // 7. use the default round off from XML

        // 0. super things

        super( context, attrs );

        // 1. use the number picker layout

        setDialogLayoutResource( R.layout.preference_number_picker_round_off );

        // 2. set the OK button text

        setPositiveButtonText( android.R.string.ok );

        // 3. set the Cancel button text

        setNegativeButtonText( android.R.string.cancel );

        // 4. do not use an icon for the dialog

        setDialogIcon( null );

        // 5. use the minimum from the round off array

        int[] roundOffArray = context.getResources().getIntArray( R.array.preference_decimal_place_array_values );

        setMinimumNumber( roundOffArray[ 0 ] );

        // 6. use the maximum from the round off array

        setMaximumNumber( roundOffArray[ roundOffArray.length - 1 ] );

        // 7. use the default round off from XML

        setDefaultRoundOff( context.getResources().getInteger( R.integer.preference_default_round_off ) );

    } // end constructor

    /** METHODS */

    /** Getters and Setters */

    // getter for the minimumNumber
    private int getMinimumNumber() { return minimumNumber; }

    // setter for the minimumNumber
    private void setMinimumNumber( int minimumNumber ) { this.minimumNumber = minimumNumber; }

    // getter for the maximumNumber
    private int getMaximumNumber() { return maximumNumber; }

    // setter for the maximumNumber
    private void setMaximumNumber( int maximumNumber ) { this.maximumNumber = maximumNumber; }

    // getter for the currentNumber
    public int getCurrentNumber() {
        return currentNumber;
    }

    // setter for the currentNumber
    public void setCurrentNumber( int currentNumber ) {
        this.currentNumber = currentNumber;
    }

    // getter for the defaultRoundOff
    private int getDefaultRoundOff() { return defaultRoundOff; }

    // setter for the defaultRoundOff
    private void setDefaultRoundOff( int defaultRoundOff ) { this.defaultRoundOff = defaultRoundOff; }

    /** Overrides */

    @Override
    // begin onCreateDialogView
    protected View onCreateDialogView() {

        // 0. initialize the dialog with the number picker view
        // 1. get the number picker
        // 2. initialize the number picker
        // 2a. start and end values
        // 2b. current value should be the persisted one
        // 3. return the view

        // 0. initialize the dialog with the number picker view

        LayoutInflater layoutInflater = ( LayoutInflater ) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        View rootView = layoutInflater.inflate( R.layout.preference_number_picker_round_off, null );

        // 1. get the number picker

        numberPicker = ( NumberPicker ) rootView.findViewById( R.id.pnpro_np_round_off_numbers );

        // 2. initialize the number picker

        // 2a. start and end values

        numberPicker.setMinValue( getMinimumNumber() );

        numberPicker.setMaxValue( getMaximumNumber() );

        // 2b. current value should be the persisted one

        // persisted values are in string form
        // convert to integer so as to display on the number picker
        numberPicker.setValue( getPersistedInt( getDefaultRoundOff() ) );

        // 3. return the view

        return rootView;

    } // end onCreateDialogView

    @Override
    // begin onDialogClosed
    protected void onDialogClosed( boolean positiveResult ) {

        // 0. if the user touched OK
        // 0a. save the selected number

        // 0. if the user touched OK

        // begin if for if the positive result is true
        if ( positiveResult == true ) {

            // 0a. save the selected number

            persistInt( numberPicker.getValue() );

        } // end if for if the positive result is true

    } // end onDialogClosed

    @Override
    // begin onSetInitialValue
    // Implement this to set the initial value of the Preference
    protected void onSetInitialValue( boolean restorePersistedValue, Object defaultValue ) {

        // 0. if we are to restore the persisted value
        // 0a. restore existing state
        // 1. else we are not
        // 1a. use the default value passed in

        // 0. if we are to restore the persisted value

        // 0a. restore existing state

        // default value is stored as a string
        // needs to be converted to an integer
        if ( restorePersistedValue == true ) {

            // the persisted value is an integer
            setCurrentNumber( getPersistedInt( getDefaultRoundOff() ) ); }

        // 1. else we are not

        // 1a. use the default value passed in

        else { setCurrentNumber( ( Integer ) defaultValue ); persistInt( getCurrentNumber() ); }

    } // end onSetInitialValue

    @Override
    // begin onGetDefaultValue
    // Called when a Preference is being inflated and the default value attribute needs to be read.
    protected Object onGetDefaultValue( TypedArray typedArray, int index ) {

        return typedArray.getInteger( index, defaultRoundOff );

    } // end onGetDefaultValue

    @Override
    // begin onSaveInstanceState
    protected Parcelable onSaveInstanceState() {

        // 0. get the super state
        // 1. if this preference is persistent (continually saved)
        // 1a. no need to save instance state (since it's persistent)
        // use superclass state
        // 2. create instance of number preference saved state
        // 3. set the number preference saved state's value to be the current number on the picker
        // 4. return the number preference saved state

        // 0. get the super state

        final Parcelable superState = super.onSaveInstanceState();

        // 1. if this preference is persistent (continually saved)

        // 1a. no need to save instance state (since it's persistent)
        // use superclass state

        if ( isPersistent() == true ) { return superState; }

        // 2. create instance of number preference saved state
        final NumberPickerPreferenceSavedState numberPickerPreferenceSavedState = new NumberPickerPreferenceSavedState( superState );

        // 3. set the number preference saved state's value to be the current number on the picker

        numberPickerPreferenceSavedState.setValue( getCurrentNumber() );

        // 4. return the number preference saved state

        return numberPickerPreferenceSavedState;

    } // end onSaveInstanceState

    @Override
    // begin onRestoreInstanceState
    protected void onRestoreInstanceState( Parcelable state ) {

        // 0. if we didn't save state during onSaveInstanceState
        // 0a. call super class
        // 0b. terminate
        // 1. cast the state parameter to the number picker state
        // 2. pass the cast state to superclass
        // 3. set this preference's widget to reflect the restored state

        // 0. if we didn't save state during onSaveInstanceState

        // we did not save state if
        // parameter state is null or if
        // parameter state is not of the number picker state class

        // begin if for if parameter state is null or of parameter state class is not number picker state
        if ( state == null ||
             state.getClass().equals( NumberPickerPreferenceSavedState.class ) == false ) {

            // 0a. call super class

            super.onRestoreInstanceState( state );

            // 0b. terminate

            return;

        } // end if for if parameter state is null or of parameter state class is not number picker state

        // 1. cast the state parameter to the number picker state

        NumberPickerPreferenceSavedState numberPickerPreferenceSavedState = ( NumberPickerPreferenceSavedState ) state;

        // 2. pass the cast state to superclass

        super.onRestoreInstanceState( numberPickerPreferenceSavedState.getSuperState() );

        // 3. set this preference's widget to reflect the restored state

        numberPicker.setValue( numberPickerPreferenceSavedState.getValue() );

    } // end onRestoreInstanceState

    /** Other Methods */

} // end class RoundOffNumberPickerPreference