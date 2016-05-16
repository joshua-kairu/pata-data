package com.jlt.patadata;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

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


// begin fragment DisplayDatasetFragment
// displays the dataset
public class DisplayDatasetFragment extends Fragment {

    /** CONSTANTS */

    /** VARIABLES */

    /** Strings */

    private String responseJSONString; // the string having the responded JSON

    /**
     * CONSTRUCTOR
     */

    // empty constructor for fragment subclasses
    public DisplayDatasetFragment() {
    }

    /** METHODS */

    /** Getters and Setters */

    /**
     * Overrides
     */

    @Override
    // begin onCreateView
    public View onCreateView( final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        // 0. inflate the display datasets layout
        // 1. get the datasets from the response JSON
        // 2. initialize the recycler view
        // 2a. make this the recycler's layout manager
        // 2b. use the dataset view holder as the adapter
        // 3. when the fab is clicked
        // 3a. go to choosing a dataset
        // 4. return the inflated view

        // 0. inflate the display datasets layout

        View rootView = inflater.inflate( R.layout.fragment_display_datasets, container, false );

        // 1. get the datasets from the response JSON

        ArrayList< Dataset > datasets = WorldBankJSONUtils.getDatasetsFromJSON( getArguments().getString( MainActivity.ARGUMENT_RESPONSE_JSON_STRING ) );

        // 2. initialize the recycler view

        RecyclerView recyclerView = ( RecyclerView ) rootView.findViewById( R.id.fdd_rv_display );

        // 2a. make this the recycler's layout manager

        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );

        // 2b. use the dataset view holder as the adapter

        DatasetAdapter datasetAdapter = new DatasetAdapter( datasets );

        recyclerView.setAdapter( datasetAdapter );

        // 3. when the fab is clicked

        FloatingActionButton floatingActionButton = ( FloatingActionButton ) rootView.findViewById( R.id.fdd_fab_edit );

        // begin floatingActionButton.setOnClickListener
        floatingActionButton.setOnClickListener(

                // begin new View.OnClickListener
                new View.OnClickListener() {

                    @Override
                    // begin onClick
                    public void onClick( View v ) {

                        // 3a. go to choosing a dataset

                        FragmentManager fragmentManager = getFragmentManager();

                        fragmentManager

                                .beginTransaction()

                                .replace( R.id.m_fl_content, new ChooseDatasetFragment() )

                                .commit();

                    } // end onClick

                } // end new View.OnClickListener

        ); // end floatingActionButton.setOnClickListener

        // 4. return the inflated view

        return rootView;

    } // end onCreateView

    // getter for the responseJSONString
    public String getResponseJSONString() { return responseJSONString; }

    // setter for the responseJSONString
    public void setResponseJSONString( String responseJSONString ) { this.responseJSONString = responseJSONString; }

    /** Other Methods */

} // end fragment DisplayDatasetFragment