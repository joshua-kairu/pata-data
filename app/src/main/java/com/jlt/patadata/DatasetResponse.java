package com.jlt.patadata;

import java.util.ArrayList;

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

// begin class DatasetResponse
// represents the whole response gotten from the World Bank API
public class DatasetResponse {

    /** CONSTANTS */

    /** VARIABLES */

    /** Array Lists */

    private ArrayList< Dataset > datasets; // the datasets

    /** Preambles */

    private Preamble preamble; // the preamble

    /** CONSTRUCTOR */

    // begin constructor
    public DatasetResponse(

            int preambleCurrentPage, int preambleTotalPages, int preambleDatasetsPerPage, int preambleTotalDatasets,

            ArrayList< Dataset > datasets ) {

        setPreamble( new Preamble( preambleCurrentPage, preambleTotalPages, preambleDatasetsPerPage, preambleTotalDatasets ) );

        setDatasets( datasets );

    } // end constructor

    /** METHODS */

    /** Getters and Setters */

    // getter for the datasets
    public ArrayList< Dataset > getDatasets() { return datasets; }

    // setter for the datasets
    public void setDatasets( ArrayList< Dataset > datasets ) { this.datasets = datasets; }

    // getter for the preamble
    public Preamble getPreamble() { return preamble; }

    // setter for the preamble
    public void setPreamble( Preamble preamble ) { this.preamble = preamble; }

    /** Overrides */

    /** Other Methods */

    // begin method sortDatasets
    // sorts the datasets in a certain way
    public ArrayList< Dataset > sortDatasets( String sortMethod ) {

        // not yet implemented as of th-05-05-2016

        return getDatasets();

    } // end method sortDatasets

} // end class DatasetResponse