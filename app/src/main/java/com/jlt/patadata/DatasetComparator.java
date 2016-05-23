package com.jlt.patadata;

import java.io.Serializable;
import java.util.Comparator;

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

// begin class DatasetComparator
// implements Comparator to compare between datasets
public class DatasetComparator implements Comparator< Dataset >, Serializable {

    /** CONSTANTS */

    /** VARIABLES */

    /** Strings */

    private String sortMethod; // the how we are supposed to sort this

    /** CONSTRUCTOR */
    // begin constructor
    // initialize the method we will use to sort
    public DatasetComparator( String sortMethod ) {

        this.sortMethod = sortMethod;

    } // begin constructor

    /** METHODS */

    /** Getters and Setters */

    /** Overrides */

    @Override
    // begin compare
    // an integer < 0 if lhs is less than rhs, 0 if they are equal, and > 0 if lhs is greater than rhs.
    public int compare( Dataset leftHandSideDataset, Dataset rightHandSideDataset ) {

        // 0. initialize the integers we will be returning
        // 1. if the sort method is ascending
        // 1a. if the left dataset has a smaller year than the right dataset, return less than
        // 1b. if the left dataset has a year equal to that of the right dataset, return are equal
        // 1c. if the left dataset has a larger year than the right dataset, return greater than
        // 2. if the sort method is descending
        // 1a. if the left dataset has a smaller year than the right dataset, return greater than
        // 1b. if the left dataset has a year equal to that of the right dataset, return are equal
        // 1c. if the left dataset has a larger year than the right dataset, return less than

        // 0. initialize the integers we will be returning

        final int
                LESS_THAN = -1,
                ARE_EQUAL = 0,
                GREATER_THAN = 1;

        // 1. if the sort method is ascending

        // begin if for if we are sorting ascending
        if ( sortMethod.equals( WorldBankJSONUtils.SORT_ASCENDING ) == true ) {

            // 1a. if the left dataset has a smaller year than the right dataset, return less than

            if ( leftHandSideDataset.getYear() < rightHandSideDataset.getYear() ) { return LESS_THAN; }

            // 1b. if the left dataset has a year equal to that of the right dataset, return are equal

            else if ( leftHandSideDataset.getYear() == rightHandSideDataset.getYear() ) { return ARE_EQUAL; }

            // 1c. if the left dataset has a larger year than the right dataset, return greater than

            else { return GREATER_THAN; }

        } // end if for if we are sorting ascending

        // 2. if the sort method is descending

        // begin else for when we are sorting descending
        else {

            // 1a. if the left dataset has a smaller year than the right dataset, return greater than

            if ( leftHandSideDataset.getYear() < rightHandSideDataset.getYear() ) { return GREATER_THAN; }

            // 1b. if the left dataset has a year equal to that of the right dataset, return are equal

            else if ( leftHandSideDataset.getYear() == rightHandSideDataset.getYear() ) { return ARE_EQUAL; }

            // 1c. if the left dataset has a larger year than the right dataset, return less than

            else { return LESS_THAN; }

        } // end else for when we are sorting descending

    } // end compare

    /** Other Methods */

} // end class DatasetComparator