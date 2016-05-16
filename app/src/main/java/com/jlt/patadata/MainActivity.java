package com.jlt.patadata;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;

import java.util.Arrays;

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
public class MainActivity extends AppCompatActivity implements RequestURLListener {

    /** CONSTANTS */

    public static final String

            ARGUMENT_REQUEST_URL = "ARGUMENT_REQUEST_URL", // identifier for the request url argument

            ARGUMENT_RESPONSE_JSON_STRING = "ARGUMENT_RESPONSE_JSON_STRING"; // identifier for the response JSON string argument

    /** VARIABLES */

    /** METHODS */

    /** Strings */

    private String requestURL; // the request URL

    /** Getters and Setters */

    /** Overrides */

    @Override
    // begin onCreate
    public void onCreate( Bundle savedInstanceState ) {

        // 0. super things
        // 1. use the main activity layout
        // 2. start off the empty fragment

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. use the main activity layout

        setContentView( R.layout.activity_main );

        // 2. start off the empty fragment

        EmptyFragment emptyFragment = new EmptyFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager

                .beginTransaction()

                .add( R.id.m_fl_content, emptyFragment )

                .commit();

        Log.e( getClass().getSimpleName(), "onCreate: finished adding the emptyFragment" );

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
    // onSetRequestURL
    // initialize the request URL
    public void onSetRequestURL( String requestURL ) { this.requestURL = requestURL; }

    @Override
    // getRequestURL
    public String getRequestURL() { return requestURL; }

    /**
     * Other Methods
     */

    // begin method initializeUI
    private int initializeUI() {

return -1;
    } // end method initializeUI

} // end activity MainActivity