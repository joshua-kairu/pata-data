package com.jlt.patadata;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

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

// begin activity MainActivity
// is the main activity orchestrating the fragments
public class MainActivity extends AppCompatActivity implements RequestURLListener, SelectedDatasetNameListener {

    /** CONSTANTS */

    public static final String

    ARGUMENT_REQUEST_URL = "ARGUMENT_REQUEST_URL", // identifier for the request url argument

    ARGUMENT_RESPONSE_JSON_STRING = "ARGUMENT_RESPONSE_JSON_STRING", // identifier for the response JSON string argument

    FRAGMENT_CHOOSE_DATASET = "FRAGMENT_CHOOSE_DATASET", // name to identify the choosing dataset fragment in the back stack

    FRAGMENT_DISPLAY_DATASET = "FRAGMENT_DISPLAY_DATASET"; // name to identify the display dataset fragment in the back stack

    /** VARIABLES */

    /** METHODS */

    /** Strings */

    private String

    requestURL, // the request URL

    selectedDatasetName; // the name of the selected dataset


    /** Getters and Setters */

    /** Overrides */

    @Override
    // begin onCreate
    public void onCreate( Bundle savedInstanceState ) {

        // 0. super things
        // 1. use the main activity layout
        // 2. start off the choose dataset fragment
        // 2a. add the choose dataset fragment to the backstack

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. use the main activity layout

        setContentView( R.layout.activity_main );

        // 2. start off the choose dataset fragment

        ChooseDatasetFragment chooseDatasetFragment = new ChooseDatasetFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager

                .beginTransaction()

                .add( R.id.m_fl_content, chooseDatasetFragment )

                // 2a. add the choose dataset fragment to the backstack

                .addToBackStack( FRAGMENT_CHOOSE_DATASET )

                .commit();

        // 3. add the choose dataset fragment to the backstack



    } // end onCreate

    @Override
    // begin onCreateOptionsMenu
    public boolean onCreateOptionsMenu( Menu menu ) {

        // 0. use the empty options menu
        // 1. return super things

        // 0. use the empty options menu

        getMenuInflater().inflate( R.menu.menu_activity_main, menu );

        // 1. return super things

        return super.onCreateOptionsMenu( menu );

    } // end onCreateOptionsMenu

    @Override
    // begin onBackPressed
    public void onBackPressed() {

        // 0. if the current fragment is the choose dataset fragment
        // 0a. finish
        // 1. if the current fragment is the display dataset fragment (or the error fragment?)
        // 1a. go back to the choose dataset fragment

        FragmentManager fragmentManager = getSupportFragmentManager();

        // 0. if the current fragment is the choose dataset fragment

        // if for if the current fragment is the choose dataset fragment
        if( fragmentManager.getBackStackEntryAt( fragmentManager.getBackStackEntryCount() - 1 ).getName().equals( FRAGMENT_CHOOSE_DATASET ) == true )

        // 0a. finish

        { finish(); }

        // 1. if the current fragment is the display dataset fragment (or the error fragment?)

        // begin else if for when the current fragment is the display dataset fragment
        else if ( fragmentManager.getBackStackEntryAt( fragmentManager.getBackStackEntryCount() - 1 ).getName().equals( FRAGMENT_DISPLAY_DATASET ) == true ) {

            // 1a. go back to the choose dataset fragment

            fragmentManager

                    .beginTransaction()

                    .replace( R.id.m_fl_content, new ChooseDatasetFragment() )

                    .addToBackStack( MainActivity.FRAGMENT_CHOOSE_DATASET )

                    .commit();

        } // end else if for when the current fragment is the display dataset fragment

    } // end onBackPressed

    @Override
    // onSetRequestURL
    // initialize the request URL
    public void onSetRequestURL( String requestURL ) { this.requestURL = requestURL; }

    @Override
    // getRequestURL
    public String getRequestURL() { return requestURL; }

    @Override
    // getSelectedDatasetName
    public String getSelectedDatasetName() { return selectedDatasetName; }

    @Override
    // onSetSelectedDatasetName
    public void onSetSelectedDatasetName( String datasetName ) { selectedDatasetName = datasetName; }

    /**
     * Other Methods
     */

    // begin method initializeUI
    private int initializeUI() {

return -1;
    } // end method initializeUI

} // end activity MainActivity