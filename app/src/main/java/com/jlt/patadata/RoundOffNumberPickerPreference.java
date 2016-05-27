package com.jlt.patadata;

import android.content.Context;
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

    private static final int DEFAULT_ROUND_OFF = 2; // the default round off

    /** VARIABLES */

    /* Number Pickers */

    private NumberPicker numberPicker; // a number picker

    /* Primitives */

    private int

    minimumNumber, // the minimum number

    maximumNumber; // the maximum number

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

    } // end constructor

    /** METHODS */

    /** Getters and Setters */

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

        numberPicker = ( NumberPicker ) rootView.findViewById( R.id.pnp_np );

        // 2. initialize the number picker

        // 2a. start and end values

        numberPicker.setMinValue( getMinimumNumber() );

        numberPicker.setMaxValue( getMaximumNumber() );

        // 2b. current value should be the persisted one

        numberPicker.setValue( getPersistedInt( DEFAULT_ROUND_OFF ) );

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

    /** Other Methods */

    // getter for the minimumNumber
    private int getMinimumNumber() { return minimumNumber; }

    // setter for the minimumNumber
    private void setMinimumNumber( int minimumNumber ) { this.minimumNumber = minimumNumber; }

    // getter for the maximumNumber
    private int getMaximumNumber() { return maximumNumber; }

    // setter for the maximumNumber
    private void setMaximumNumber( int maximumNumber ) { this.maximumNumber = maximumNumber; }

} // end class RoundOffNumberPickerPreference