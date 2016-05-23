package com.jlt.patadata;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
 *
 */

// begin fragment TableDisplayDatasetFragment
// displays the dataset in table form
public class TableDisplayDatasetFragment extends Fragment {

    /** CONSTANTS */

    /** VARIABLES */

    /** Response JSON Listeners */

    private ResponseJSONListener responseJSONListener; // listener for the response JSON

    /** Selected Dataset Name Listeners */

    private SelectedDatasetListener selectedDatasetNameListener; // listener for the selected dataset's name

    /**
     * CONSTRUCTOR
     */

    // empty constructor for fragment subclasses
    public TableDisplayDatasetFragment() {
    }

    /** METHODS */

    /** Getters and Setters */

    /**
     * Overrides
     */

    @Override
    // begin onCreate
    public void onCreate( @Nullable Bundle savedInstanceState ) {

        // 0. super things
        // 1. register the context menu

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. register the context menu

        setHasOptionsMenu( true );

    } // end onCreate

    @Override
    // begin onAttach
    public void onAttach( Context context ) {

        // 0. super things
        // 1. initialize the selected dataset name listener
        // 2. initialize the response JSON listener

        // 0. super things

        super.onAttach( context );

        // 1. initialize the selected dataset name listener

        // try to initialize the selected dataset name listener

        try { selectedDatasetNameListener = ( SelectedDatasetListener ) getActivity(); }

        // problems of casting

        catch ( ClassCastException e ) { Log.e( getClass().getSimpleName(), getActivity().toString() + " must implement SelectedDatasetListener." ); }

        // 2. initialize the response JSON listener

        // try to initialize the response JSON listener

        try { responseJSONListener = ( ResponseJSONListener ) getActivity(); }

        // problems of casting

        catch ( ClassCastException e ) { Log.e( getClass().getSimpleName(), getActivity().toString() + " must implement ResponseJSONListener." ); }

    } // end onAttach

    @Override
    // begin onCreateView
    public View onCreateView( final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        // 0. inflate the display datasets layout
        // 0a. put the selected dataset's name on the bar
        // 1. get the datasets from the response JSON
        // 2. initialize the recycler view
        // 2a. make this the recycler's layout manager
        // 2b. use the dataset view holder as the adapter
        // 3. when the fab is clicked
        // 3a. go to choosing a dataset
        // 3b. add the choose dataset fragment to the backstack
        // 4. return the inflated view

        // 0. inflate the display datasets layout

        View rootView = inflater.inflate( R.layout.fragment_table_display_datasets, container, false );

        // 0a. put the selected dataset's name on the bar

        ( ( AppCompatActivity ) getActivity() ).getSupportActionBar().setTitle( selectedDatasetNameListener.getSelectedDatasetName() );

        // 1. get the datasets from the response JSON

        ArrayList< Dataset > datasets = WorldBankJSONUtils.getDatasetsFromJSON( responseJSONListener.getResponseJSON(), WorldBankJSONUtils.SORT_ASCENDING );

        // 2. initialize the recycler view

        RecyclerView recyclerView = ( RecyclerView ) rootView.findViewById( R.id.fdd_rv_display );

        // 2a. make this the recycler's layout manager

        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );

        // 2b. use the dataset view holder as the adapter

        DatasetAdapter datasetAdapter = new DatasetAdapter( datasets );

        recyclerView.setAdapter( datasetAdapter );

        // 3. when the fab is clicked

//        FloatingActionButton floatingActionButton = ( FloatingActionButton ) rootView.findViewById( R.id.fdd_fab_edit );

//        // begin floatingActionButton.setOnClickListener
//        floatingActionButton.setOnClickListener(
//
//                // begin new View.OnClickListener
//                new View.OnClickListener() {
//
//                    @Override
//                    // begin onClick
//                    public void onClick( View v ) {
//
//                        // 3a. go to choosing a dataset
//
//                        FragmentManager fragmentManager = getFragmentManager();
//
//                        fragmentManager
//
//                                .beginTransaction()
//
//                                .add( R.id.m_fl_content, new ChooseDatasetFragment() )
//
//                                // 3b. add the choose dataset fragment to the backstack
//
//                                .addToBackStack( null )
//
//                                .commit();
//
//                    } // end onClick
//
//                } // end new View.OnClickListener
//
//        ); // end floatingActionButton.setOnClickListener

        // 4. return the inflated view

        return rootView;

    } // end onCreateView

    @Override
    // begin onCreateOptionsMenu
    public void onCreateOptionsMenu( Menu menu, MenuInflater inflater ) {

        // 0. inflate menu for showing the chart selection option
        // 1. super things

        // 0. inflate menu for showing the chart selection option

        inflater.inflate( R.menu.menu_table_dataset_display_fragment, menu );

        // 1. super things

        super.onCreateOptionsMenu( menu, inflater );

    } // end onCreateOptionsMenu

    @Override
    // begin onOptionsItemSelected
    public boolean onOptionsItemSelected( MenuItem item ) {

        // 0. if the chart option is selected,
        // 0a. switch to the chart fragment
        // 0b. add the chart fragment to the backstack
        // 1. else
        // 1a. super things

        // 0. if the chart option is selected,

        // begin if for if the selected item is the chart one
        if ( item.getItemId() == R.id.action_table_dataset_display_fragment_chart ) {

            // 0a. switch to the chart fragment

            FragmentManager fragmentManager = getFragmentManager();

            fragmentManager

                    .beginTransaction()

                    .replace( R.id.m_fl_content, new ChartDisplayDatasetFragment() )

                    // 0b. add the chart fragment to the backstack

                    .addToBackStack( MainActivity.FRAGMENT_CHART_DISPLAY_DATASET )

                    .commit();

            return true;

        } // end if for if the selected item is the chart one

        // 1. else

        // 1a. super things

        // else for otherwise
        else { return super.onOptionsItemSelected( item ); }

    } // end onOptionsItemSelected

    /** Other Methods */

} // end fragment TableDisplayDatasetFragment