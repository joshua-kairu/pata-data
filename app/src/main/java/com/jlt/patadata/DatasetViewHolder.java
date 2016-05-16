package com.jlt.patadata;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

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
 */


// begin class DatasetViewHolder
// holds each dataset in recycler view
public class DatasetViewHolder extends RecyclerView.ViewHolder {

    /** CONSTANTS */

    /** VARIABLES */

    /** Text Views */

    public TextView
            yearTextView, // the year text view
            valueTextView; // the value text view

    /** CONSTRUCTOR */

    // begin constructor
    public DatasetViewHolder( View itemView ) {

        // 0. super things
        // 1. initialize the year text view
        // 2. initialize the value text view

        // 0. super things

        super( itemView );

        // 1. initialize the year text view

        yearTextView = ( TextView ) itemView.findViewById( R.id.idli_tv_year );

        // 2. initialize the value text view

        valueTextView = ( TextView ) itemView.findViewById( R.id.idli_tv_value );

    } // end constructor

    /** METHODS */

    /** Getters and Setters */

    /** Overrides */

    /** Other Methods */

} // end class DatasetViewHolder