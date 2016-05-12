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

// begin class Preamble
// represents the preamble in the dataset response
public class Preamble {

    /** CONSTANTS */

    /** VARIABLES */

    /** Primitives */

    private int page; // the current page of the whole dataset response
    private int pages; // the total pages of the whole dataset response
    private int per_page; // the number of datasets in each page of the whole dataset response
    private int total; // the total datasets of the whole dataset response

    /** CONSTRUCTOR */

    // begin constructor
    public Preamble( int currentPage, int totalPages, int datasetsPerPage, int totalDatasets ) {

        setPage( currentPage );
        setPages( totalPages );
        setPer_page( datasetsPerPage );
        setTotal( totalDatasets );

    } // end constructor

    /** METHODS */

    /** Getters and Setters */

    // getter for the current page
    public int getPage() { return page; }

    // setter for the current page
    public void setPage( int page ) { this.page = page; }

    // getter for the total pages
    public int getPages() { return pages; }

    // setter for the total pages
    public void setPages( int pages ) { this.pages = pages; }

    // getter for the datasets per page
    public int getPer_page() { return per_page; }

    // setter for the datasets per page
    public void setPer_page( int per_page ) { this.per_page = per_page; }

    // getter for the total datasets
    public int getTotal() { return total; }

    // setter for the total datasets
    public void setTotal( int total ) { this.total = total; }

    /** Overrides */

    /** Other Methods */

} // end class Preamble