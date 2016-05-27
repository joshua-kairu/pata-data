package com.jlt.patadata;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.commons.lang3.ArrayUtils;

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

// begin fragment ChooseDatasetFragment
// allows the user to choose a dataset
public class ChooseDatasetFragment extends Fragment {

    /** CONSTANTS */

    /** VARIABLES */

    /** Line Chart Animation Listeners */

    private LineChartAnimationListener lineChartAnimationListener; // listener for the line chart's animation

    /** Request URL Listeners */

    private RequestURLListener requestURLListener; // a listener of the request URL

    /** Selected Dataset Name Listeners */

    private SelectedDatasetListener selectedDatasetNameListener; // listener for the selected dataset's name

    /** Spinners */

    private Spinner

            datasetsSpinner, // spinner for the datasets
            startYearSpinner, // spinner for the start years
            endYearSpinner; // spinner for the end years


    /**
     * CONSTRUCTOR
     */

    // empty constructor for fragment subclasses
    public ChooseDatasetFragment() {
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
        // 1. initialize the request URL
        // 2. initialize the selected dataset name listener
        // 3. initialize the line chart animation listener

        // 0. super things

        super.onAttach( context );

        // 1. initialize the request URL

        // try to initialize the request URL

        try { requestURLListener = ( RequestURLListener ) getActivity(); }

        // problems of casting

        catch ( ClassCastException e ) { Log.e( getClass().getSimpleName(), getActivity().toString() + " must implement RequestURLListener." ); }

        // 2. initialize the selected dataset name listener

        // try to initialize the selected dataset name listener

        try { selectedDatasetNameListener = ( SelectedDatasetListener ) getActivity(); }

        // problems of casting

        catch ( ClassCastException e ) { Log.e( getClass().getSimpleName(), getActivity().toString() + " must implement SelectedDatasetListener." ); }

        // 3. initialize the line chart animation listener

        // try to initialize the line chart animation listener

        try { lineChartAnimationListener = ( LineChartAnimationListener ) getActivity(); }

        // problems of casting

        catch ( ClassCastException e ) { Log.e( getClass().getSimpleName(), getActivity().toString() + " must implement LineChartAnimationListener." ); }

    } // end onAttach

    @Override
    // begin onCreateView
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        // 0. use the choose dataset layout
        // 0a. make the line chart not animated
        // 1. initialize UI
        // 1a. initialize the datasets spinner
        // 1a1. create an ArrayAdapter using the World Bank datasets and a default spinner layout
        // 1a2. specify the layout to use when the list of choices appears
        // 1a3. apply the adapter to the spinner
        // 1a4. set as selected the first item on the spinner
        // 1b. initialize the start year spinner
        // 1b1. create an ArrayAdapter using the start years and a default spinner layout
        // 1b2. specify the layout to use when the list of choices appears
        // 1b3. apply the adapter to the spinner
        // 1b4. set as selected the first item on the spinner
        // 1c. initialize the end year spinner
        // 1c1. create an ArrayAdapter using the end years and a default spinner layout
        // 1c2. specify the layout to use when the list of choices appears
        // 1c3. apply the adapter to the spinner
        // 1c4. set as selected the first item on the spinner
        // 1d. initialize the search fab
        // 1d1. when the fab is touched
        // 1d1a. validate the spinner choices and act accordingly
        // 2. return the root view

        // 0. use the choose dataset layout

        View rootView = inflater.inflate( R.layout.fragment_choose_dataset, container, false );

        // 0a. make the line chart not animated

        lineChartAnimationListener.onSetChartAnimated( false );

        // 1. initialize UI -> done in initializeUI

        initializeUI( rootView );

        // 2. return the root view

        return rootView;

    } // end onCreateView

    @Override
    // begin onCreateOptionsMenu
    public void onCreateOptionsMenu( Menu menu, MenuInflater inflater ) {

        // 0. inflate menu for showing the settings option
        // 1. super things

        // 0. inflate menu for showing the settings option

        inflater.inflate( R.menu.menu_choose_dataset_fragment, menu );

        // 1. super things

        super.onCreateOptionsMenu( menu, inflater );

    } // end onCreateOptionsMenu

    @Override
    // begin onOptionsItemSelected
    public boolean onOptionsItemSelected( MenuItem item ) {

        // 0. if the settings option is selected
        // 0a. switch to the settings activity
        // 1. else
        // 1a. super things

        // 0. if the settings option is selected

        // begin if for if the settings are chosen
        if ( item.getItemId() == R.id.action_chart_dataset_display_fragment_settings ) {

            // 0a. switch to the settings activity

            Intent settingsIntent = new Intent( getActivity(), SettingsActivity.class );

            getActivity().startActivity( settingsIntent );

            return true;

        } // end if for if the settings are chosen

        // 1. else

        // 1a. super things

        // else for otherwise
        else { return super.onOptionsItemSelected( item ); }

    } // end onOptionsItemSelected

    /** Other Methods */

    // begin method initializeUI
    private void initializeUI( View rootView ) {

        // 1. initialize UI
        // 1a. initialize the datasets spinner
        // 1a1. create an ArrayAdapter using the World Bank datasets and a default spinner layout
        // 1a2. specify the layout to use when the list of choices appears
        // 1a3. apply the adapter to the spinner
        // 1a4. set as selected the first item on the spinner
        // 1b. initialize the start year spinner
        // 1b1. create an ArrayAdapter using the start years and a default spinner layout
        // 1b2. specify the layout to use when the list of choices appears
        // 1b3. apply the adapter to the spinner
        // 1b4. set as selected the first item on the spinner
        // 1c. initialize the end year spinner
        // 1c1. create an ArrayAdapter using the end years and a default spinner layout
        // 1c2. specify the layout to use when the list of choices appears
        // 1c3. apply the adapter to the spinner
        // 1c4. set as selected the first item on the spinner
        // 1d. initialize the search fab
        // 1d1. when the fab is touched
        // 1d1a. validate the spinner choices and act accordingly
        // 1e. set the bar title to be the name of the app

        // 1a. initialize the datasets spinner

        datasetsSpinner = ( Spinner ) rootView.findViewById( R.id.fcd_s_datasets );

        // 1a1. create an ArrayAdapter using the World Bank datasets and a default spinner layout

        ArrayAdapter< String > datasetsArrayAdapter = new ArrayAdapter< String >(

                getActivity(),

                android.R.layout.simple_spinner_item,

                WorldBankJSONUtils.RequestQueryBuilder.getDatasetValues() );

        // 1a2. specify the layout to use when the list of choices appears

        datasetsArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        // 1a3. apply the adapter to the spinner

        datasetsSpinner.setAdapter( datasetsArrayAdapter );

        // 1a4. set as selected the first item on the spinner

        datasetsSpinner.setSelection( 0 );

        // 1b. initialize the start year spinner

        startYearSpinner = ( Spinner ) rootView.findViewById( R.id.fcd_s_start_year );

        // 1b1. create an ArrayAdapter using the start years and a default spinner layout

        ArrayAdapter< Integer > yearsArrayAdapter = new ArrayAdapter< Integer >(

                getActivity(),

                android.R.layout.simple_spinner_item,

                ArrayUtils.toObject( WorldBankJSONUtils.getDatasetYearsAsString() ) );

        // 1b2. specify the layout to use when the list of choices appears

        yearsArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        // 1b3. apply the adapter to the spinner

        startYearSpinner.setAdapter( yearsArrayAdapter );

        // 1b4. set as selected the first item on the spinner

        startYearSpinner.setSelection( 0 );

        // 1c. initialize the end year spinner

        endYearSpinner = ( Spinner ) rootView.findViewById( R.id.fcd_s_end_year );

        // 1c1. create an ArrayAdapter using the end years and a default spinner layout

        // 1c2. specify the layout to use when the list of choices appears

        // 1c3. apply the adapter to the spinner

        endYearSpinner.setAdapter( yearsArrayAdapter );

        // 1c4. set as selected the first item on the spinner

        endYearSpinner.setSelection( 0 );

        // 1d. initialize the search fab

        FloatingActionButton searchFloatingActionButton = ( FloatingActionButton ) rootView.findViewById( R.id.fcd_fab_search );

        // 1d1. when the fab is touched

        // begin searchFloatingActionButton.setOnClickListener
        searchFloatingActionButton.setOnClickListener(

                // begin new View.OnClickListener
                new View.OnClickListener() {

                    @Override
                    // begin onClick
                    public void onClick( View view ) {

                        // 1d1a. validate the spinner choices and act accordingly

                        validateChoicesAndAct();

                    } // end onClick

                } // end new View.OnClickListener

        ); // end searchFloatingActionButton.setOnClickListener

        // 1e. set the bar title to be the name of the app

        ( ( AppCompatActivity ) ( getActivity() ) ).getSupportActionBar().setTitle( R.string.app_name );

    } // end method initializeUI

    // begin method validateChoicesAndAct
    // checks if the choices in the spinners are good enough for a query build
    private void validateChoicesAndAct() {

        // 0. if the start year is greater than the end year
        // 0a. toast the user of this
        // 0b. terminate
        // 1. else if the start year is equal to the end year
        // 1a. toast the user of this
        // 1b. build a query with the end year
        // 1c. start waiting for a result from that query
        // 1d. store the selected dataset name with the appropriate listener
        // 2. otherwise the start year is less than the end year
        // 2a. build a query with both years
        // 2b. start waiting for a result from that query
        // 2c. store the selected dataset name with the appropriate listener

        String selectedDataset = datasetsSpinner.getSelectedItem().toString();
        int selectedStartYear = ( Integer ) startYearSpinner.getSelectedItem();
        int selectedEndYear = ( Integer ) endYearSpinner.getSelectedItem();

        // 0. if the start year is greater than the end year

        // begin if for if the selected start year is less than the selected end year
        if( selectedStartYear > selectedEndYear ) {

            // 0a. toast the user of this

            Toast.makeText( getActivity(), "Please make the start year smaller than the end year. :-)", Toast.LENGTH_LONG ).show();

            // 0b. terminate

        } // end if for if the selected start year is less than the selected end year

        // 1. else if the start year is equal to the end year

        // begin else if for when the selected start year is the same as the selected end year
        else if( selectedStartYear == selectedEndYear ) {

            // 1a. toast the user of this

            Toast.makeText( getActivity(), "The start year is the same as the end year but we'll make the most of it. . . ;-)", Toast.LENGTH_LONG ).show();

            // 1b. build a query with the end year

            String requestURL = WorldBankJSONUtils.RequestQueryBuilder.getRequestQueryURL( selectedDataset, selectedEndYear );

            Log.e( "validateChoicesAndAct: ", "requestURL = " + requestURL  );

            // 1c. start waiting for a result from that query

            requestURLListener.onSetRequestURL( requestURL );

            WaitingFragment waitingFragment = new WaitingFragment();

            FragmentManager fragmentManager = getFragmentManager();

            fragmentManager

                    .beginTransaction()

                    .setCustomAnimations( R.anim.slide_in_from_right, R.anim.slide_out_to_left )

                    .replace( R.id.m_fl_content, waitingFragment )

                    .commit();

            // 1d. store the selected dataset name with the appropriate listener

            selectedDatasetNameListener.onSetSelectedDatasetName( selectedDataset );

        } // end else if for when the selected start year is the same as the selected end year

        // 2. otherwise the start year is less than the end year

        // begin else for when the selected start year is less than the selected end year
        else {

            // 2a. build a query with both years

            String requestURL = WorldBankJSONUtils.RequestQueryBuilder.getRequestQueryURL( selectedDataset, selectedStartYear, selectedEndYear );

            // 2b. start waiting for a result from that query

            requestURLListener.onSetRequestURL( requestURL );

            WaitingFragment waitingFragment = new WaitingFragment();

            FragmentManager fragmentManager = getFragmentManager();

            fragmentManager

                    .beginTransaction()

                    .setCustomAnimations( R.anim.slide_in_from_right, R.anim.slide_out_to_left )

                    .replace( R.id.m_fl_content, waitingFragment )

                    .commit();

            // 2c. store the selected dataset name with the appropriate listener

            selectedDatasetNameListener.onSetSelectedDatasetName( selectedDataset );

        } // end else for when the selected start year is less than the selected end year

    } // end method validateChoicesAndAct

} // end fragment ChooseDatasetFragment