package com.jlt.patadata;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

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

// begin fragment ChartDisplayDatasetFragment
// displays the dataset in chart form
public class ChartDisplayDatasetFragment extends Fragment {

    /** CONSTANTS */

    /** VARIABLES */

    /** Line Chart Animation Listeners */

    private LineChartAnimationListener lineChartAnimationListener; // listener for the line chart's animation

    /** PreferencesInterface */

    private PreferencesInterface preferencesInterface; // a preferences interface

    /** Response JSON Listeners */

    private ResponseJSONListener responseJSONListener; // listener for the response JSON

    /** Selected Dataset Name Listeners */

    private SelectedDatasetListener selectedDatasetListener; // listener for the selected dataset

    /**
     * CONSTRUCTOR
     */

    // empty constructor for fragment subclasses
    public ChartDisplayDatasetFragment() {
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
        // 3. initialize the line chart animation listener
        // 4. initialize the preferences interface

        // 0. super things

        super.onAttach( context );

        // 1. initialize the selected dataset name listener

        // try to initialize the selected dataset name listener

        try { selectedDatasetListener = ( SelectedDatasetListener ) getActivity(); }

        // problems of casting

        catch ( ClassCastException e ) { Log.e( getClass().getSimpleName(), getActivity().toString() + " must implement SelectedDatasetListener." ); }

        // 2. initialize the response JSON listener

        // try to initialize the response JSON listener

        try { responseJSONListener = ( ResponseJSONListener ) getActivity(); }

        // problems of casting

        catch ( ClassCastException e ) { Log.e( getClass().getSimpleName(), getActivity().toString() + " must implement ResponseJSONListener." ); }

        // 3. initialize the line chart animation listener

        // try to initialize the line chart animation listener

        try { lineChartAnimationListener = ( LineChartAnimationListener ) getActivity(); }

        // problems of casting

        catch ( ClassCastException e ) { Log.e( getClass().getSimpleName(), getActivity().toString() + " must implement LineChartAnimationListener." ); }

        // 4. initialize the preferences interface

        // try to initialize the preferences interface

        try { preferencesInterface = ( PreferencesInterface ) getActivity(); }

        // problems of casting

        catch ( ClassCastException e ) { Log.e( getClass().getSimpleName(), getActivity().toString() + " must implement PreferencesInterface." ); }

    } // end onAttach

    @Override
    // begin onCreateView
    // credits: MPAndroidChart, Envato Tuts Plus
    public View onCreateView( final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        // 0. inflate the chart display datasets layout
        // 0a. put the selected dataset's name on the bar
        // 1. get the datasets from the response JSON
        // 2. set up the chart
        // 2a. create an array list of line entries from the dataset's years and values
        // 2b. create a chart dataset from the entries
        // 2c. define an array list of x axis labels containing all the years found in the fetched dataset
        // 2d. create the chart
        // 2e. set chart data from what we have already defined
        // 2e1. do not draw values on the line chart's data
        // 2f. set a chart description optionally
        // 2g. use colors optionally
        // 2h. animate the X axis
        // 2h1. if the user prefers to have the chart animate once
        // 2h1a. if the chart has not yet animated
        // 2h1a1. animate the X axis
        // 2h1a2. flip the flag to show that the chart has been animated
        // 2h2. else
        // 2h2a. animate always
        // 2i. put the X axis on the bottom
        // 2j. draw only the left Y axis
        // 2k. Y Axis starts at 0
        // 2l. set a marker to use every time a value is highlighted
        // 3. return the inflated view

        // 0. inflate the chart display datasets layout

        View rootView = inflater.inflate( R.layout.fragment_chart_display_datasets, container, false );

        // 0a. put the selected dataset's name on the bar

        ( ( AppCompatActivity ) getActivity() ).getSupportActionBar().setTitle( selectedDatasetListener.getSelectedDatasetName() );

        // 1. get the datasets from the response JSON

        ArrayList< Dataset > datasets = WorldBankJSONUtils.getDatasetsFromJSON( responseJSONListener.getResponseJSON(), WorldBankJSONUtils.SORT_ASCENDING );

        // 2. set up the chart

        // 2a. create an array list of line entries from the dataset's years and values

        ArrayList< Entry > lineChartEntries = new ArrayList<>();

        // use a for to do this

        for ( int i = 0; i < datasets.size(); i++ ) { lineChartEntries.add( new Entry( ( float ) datasets.get( i ).getValue(), i ) ); }

        // 2b. create a chart dataset from the entries

        LineDataSet lineDataSet = new LineDataSet( lineChartEntries, selectedDatasetListener.getSelectedDatasetName() );

        // 2c. define an array list of x axis labels containing all the years found in the fetched dataset

        ArrayList< String > lineChartLabels = new ArrayList<>();

        // use a for to do this

        for ( Dataset worldBankDataset : datasets ) { lineChartLabels.add( String.valueOf( worldBankDataset.getYear() ) ); }

        // 2d. create the chart

        LineChart lineChart = ( LineChart ) rootView.findViewById( R.id.fcdd_lc_datasets );

        // 2e. set chart data from what we have already defined

        LineData lineChartData = new LineData( lineChartLabels, lineDataSet );

        lineChart.setData( lineChartData );

        // 2e1. do not draw values on the line chart's data

        lineChartData.setDrawValues( false );

        // 2f. set a chart description

        lineChart.setDescription( "" );

        // 2g. use colors optionally

        lineDataSet.setColors( ColorTemplate.COLORFUL_COLORS );

        // 2h. animate the X axis

        // 2h1. if the user prefers to have the chart animate once

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences( getActivity() );

        String lineChartAnimationFrequencyPreference = sharedPreferences.getString( MainActivity.PREFERENCE_LIST_CHART_ANIMATION_FREQUENCY, null );

        // begin if for if the user prefers to have the chart animate once
        if( lineChartAnimationFrequencyPreference.equals( MainActivity.PREFERENCE_CHART_ANIMATE_ONCE ) == true ) {

            // 2h1a. if the chart has not yet animated

            // begin if for if the chart has not yet animated
            if ( lineChartAnimationListener.isChartAnimatedOnce() == false ) {

                // 2h1a1. animate the X axis

                lineChart.animateX( 5000 );

                // 2h1a2. flip the flag to show that the chart has been animated

                lineChartAnimationListener.onSetChartAnimated( true );

            } // end if for if the chart has not yet animated

        } // end if for if the user prefers to have the chart animate once

        // 2h2. else

        // 2h2a. animate always

        // else for when the user prefers the chart animated always
        else { lineChart.animateX( 5000 ); }

        // 2i. put the X axis on the bottom

        lineChart.getXAxis().setPosition( XAxis.XAxisPosition.BOTTOM );

        // 2j. draw only the left Y axis

        lineChart.getAxisRight().setEnabled( false );

        // 2k. Y Axis starts at 0

        lineChart.getAxisLeft().setAxisMinValue( 0f );

        // 2l. set a marker to use every time a value is highlighted

        CustomMarkerView customMarkerView = new CustomMarkerView( getActivity(), R.layout.custom_marker );

        lineChart.setMarkerView( customMarkerView );

        // 3. return the inflated view

        return rootView;

    } // end onCreateView

    @Override
    // begin onCreateOptionsMenu
    public void onCreateOptionsMenu( Menu menu, MenuInflater inflater ) {

        // 0. inflate menu for showing the table selection option
        // 1. super things

        // 0. inflate menu for showing the table selection option

        inflater.inflate( R.menu.menu_chart_dataset_display_fragment, menu );

        // 1. super things

        super.onCreateOptionsMenu( menu, inflater );

    } // end onCreateOptionsMenu

    @Override
    // begin onOptionsItemSelected
    public boolean onOptionsItemSelected( MenuItem item ) {

        // 0. if the table option is selected,
        // 0a. switch to the table fragment
        // 0b. add the table fragment to the backstack
        // 1. else if the settings option is selected
        // 1a. switch to the settings activity
        // 2. else
        // 2a. super things

        // 0. if the table option is selected,

        // begin if for if the selected item is the table one
        if ( item.getItemId() == R.id.action_chart_dataset_display_fragment_table ) {

            // 0a. switch to the table fragment

            FragmentManager fragmentManager = getFragmentManager();

            fragmentManager

                    .beginTransaction()

                    .setCustomAnimations( R.anim.slide_in_from_right, R.anim.slide_out_to_left )

                    .replace( R.id.m_fl_content, new TableDisplayDatasetFragment() )

                    // 0b. add the table fragment to the backstack

                    .addToBackStack( MainActivity.FRAGMENT_TABLE_DISPLAY_DATASET )

                    .commit();

            return true;

        } // end if for if the selected item is the table one

        // 1. else if the settings option is selected

        // begin else if for when the settings are chosen
        else if ( item.getItemId() == R.id.action_chart_dataset_display_fragment_settings ) {

            // 1a. switch to the settings activity

            Intent settingsIntent = new Intent( getActivity(), SettingsActivity.class );

            getActivity().startActivity( settingsIntent );

            return true;

        } // end else if for when the settings are chosen

        // 2. else

        // 2a. super things

        // else for otherwise
        else { return super.onOptionsItemSelected( item ); }

    } // end onOptionsItemSelected

    /** Other Methods */

} // end fragment ChartDisplayDatasetFragment