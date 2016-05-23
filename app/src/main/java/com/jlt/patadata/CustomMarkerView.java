package com.jlt.patadata;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;

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

// begin class CustomMarkerView
// a custom marker view for when an item in the chart is selected
public class CustomMarkerView extends MarkerView {

    /** CONSTANTS */

    /** VARIABLES */

    /** Text Views */

    private TextView

    yearTextView, // text view to show the year

    valueTextView; // text view to show the value

    /** CONSTRUCTOR */

    // begin constructor
    public CustomMarkerView ( Context context, int layoutResource ) {

        // 0. super things
        // 1. initialize text views

        // 0. super things

        super( context, layoutResource );

        // 1. initialize text views

        yearTextView = ( TextView ) findViewById( R.id.cm_tv_year );
        valueTextView = ( TextView ) findViewById( R.id.cm_tv_value );

    } // end constructor

    /** METHODS */

    /** Getters and Setters */

    /** Overrides */

    @Override
    // begin refreshContent
    // called every time the marker is redrawn
    public void refreshContent( Entry entry, Highlight highlight ) {

        // 0. show the year
        // 1 . show the value

        // 0. show the year

        yearTextView.setText( String.valueOf( WorldBankJSONUtils.DATASET_START_YEAR + entry.getXIndex() ) );

        // 1 . show the value

        valueTextView.setText( String.valueOf( entry.getVal() ) );

    } // end refreshContent

    @Override
    // begin getXOffset
    public int getXOffset( float xPosition ) {

        // 0. center the marker horizontally

        // 0. center the marker horizontally

        return -( getWidth() / 2 );

    } // end getXOffset

    @Override
    // begin getYOffset
    public int getYOffset( float yPosition ) {

        // 0. place the marker above the selected value

        // 0. place the marker above the selected value

        return -getHeight();

    } // end getYOffset

    /** Other Methods */

} // end class CustomMarkerView