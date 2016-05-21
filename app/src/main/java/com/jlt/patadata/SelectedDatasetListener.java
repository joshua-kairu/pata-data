package com.jlt.patadata;

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

// begin interface SelectedDatasetListener
// used for when the dataset has been selected and we need to store the dataset's particulars
public interface SelectedDatasetListener {

    /** CONSTANTS */

    /** VARIABLES */

    /** METHODS */

    /** Getters and Setters */

    /** Overrides */

    /** Other Methods */

    // getter for the selected dataset name

    public String getSelectedDatasetName();

    // setter for the dataset name

    public void onSetSelectedDatasetName( String datasetName );

    // getter for the selected dataset's start year

    public int getSelectedDatasetStartYear();

    // setter for the selected dataset's start year

    public void onSetSelectedDatasetStartYear( int datasetStartYear );

    // getter for the selected dataset's end year

    public int getSelectedDatasetEndYear();

    // setter for the dataset's end year

    public void onSetSelectedDatasetEndYear( int datasetEndYear );

} // end interface SelectedDatasetListener
