package com.jlt.patadata;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

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

// begin fragment ErrorFragment
// displays the error message and allows the user, from the action bar, to
// edit the request or
// refresh the request
public class ErrorFragment extends Fragment {

    /** CONSTANTS */

    /** VARIABLES */

    /** Request URL Listeners */

//    private RequestURLListener requestURLListener; // a listener of the request URL

    /**
     * CONSTRUCTOR
     */

    // empty constructor for fragment subclasses
    public ErrorFragment() {
    }

    /** METHODS */

    /** Getters and Setters */

    /**
     * Overrides
     */

    @Override
    // begin onCreate
    public void onCreate( Bundle savedInstanceState ) {

        // 0. super things
        // 1. register need for options menu

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. register need for options menu

        setHasOptionsMenu( true );

    } // end onCreate

    @Override
    // begin onAttach
    public void onAttach( Context context ) {

        // 0. super things
        // 1. initialize the request URL

        // 0. super things

        super.onAttach( context );

        // 1. initialize the request URL

        // try to initialize the request URL

//        try { requestURLListener = ( RequestURLListener ) getActivity(); }
//
//        // problems of casting
//
//        catch ( ClassCastException e ) { Log.e( getClass().getSimpleName(), getActivity().toString() + " must implement RequestURLListener." ); }

    } // end onAttach

    @Override
    // begin onCreateView
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        // 0. use the error layout

        // 0. use the error layout

        return inflater.inflate( R.layout.fragment_error, container, false );

    } // end onCreateView

    @Override
    // begin onCreateOptionsMenu
    public void onCreateOptionsMenu( Menu menu, MenuInflater inflater ) {

        // 0. inflate menu items for use in the action bar
        // 1. super things

        // 0. inflate menu items for use in the action bar

        inflater.inflate( R.menu.menu_error_fragment, menu );

        // 1. super things

        super.onCreateOptionsMenu( menu, inflater );

    } // end onCreateOptionsMenu

    @Override
    // begin onOptionsItemSelected
    public boolean onOptionsItemSelected( MenuItem item ) {

        // 0. if edit is selected
        // 0a. switch to the choosing dataset fragment
        // 0b. add the choose dataset fragment to the backstack
        // 1. if refresh is selected
        // 1a. switch to the waiting fragment
        // 2. else
        // 2a. super things

        // begin switch to determine which item was selected
        switch ( item.getItemId() ) {

            // 0. if edit is selected

            case R.id.action_error_fragment_edit:

                // 0a. switch to the choosing dataset fragment

                FragmentManager fragmentManager = getFragmentManager();

                fragmentManager

                        .beginTransaction()

                        .replace( R.id.m_fl_content, new ChooseDatasetFragment() )

                        // 0b. add the choose dataset fragment to the backstack

                        .addToBackStack( null )

                        .commit();

                return true;

            // 1. if refresh is selected

            case R.id.action_error_fragment_refresh:

                // 1a. switch to the waiting fragment

                WaitingFragment waitingFragment = new WaitingFragment();

                fragmentManager = getFragmentManager();

                fragmentManager

                        .beginTransaction()

                        .replace( R.id.m_fl_content, waitingFragment )

                        .commit();

                return true;

            // 2. else

            default:

                // 2a. super things

                return super.onOptionsItemSelected( item );

        } // end switch to determine which item was selected

    } // end onOptionsItemSelected

    /** Other Methods */

} // end fragment ErrorFragment