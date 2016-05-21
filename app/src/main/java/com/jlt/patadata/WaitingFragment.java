package com.jlt.patadata;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

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

// begin fragment WaitingFragment
// waits for the fetching of the data to complete
public class WaitingFragment extends Fragment {

    /** CONSTANTS */

    /** VARIABLES */

    /** Request URL Listeners */

    private RequestURLListener requestURLListener; // a listener of the request URL

    /** Response JSON Listeners */

    private ResponseJSONListener responseJSONListener; // listener for the response JSON

    /**
     * CONSTRUCTOR
     */

    // empty constructor for fragment subclasses
    public WaitingFragment() {
    }

    /** METHODS */

    /** Getters and Setters */

    @Override
    // begin onAttach
    public void onAttach( Context context ) {

        // 0. super things
        // 1. initialize the request URL listener
        // 2. initialize the response JSON listener

        // 0. super things

        super.onAttach( context );

        // 1. initialize the request URL listener

        // try to initialize the request URL listener

        try { requestURLListener = ( RequestURLListener ) getActivity(); }

        // problems of casting

        catch ( ClassCastException e ) { Log.e( getClass().getSimpleName(), getActivity().toString() + " must implement RequestURLListener." ); }

        // 2. initialize the response JSON listener

        // try to initialize the response JSON listener

        try { responseJSONListener = ( ResponseJSONListener ) getActivity(); }

        // problems of casting

        catch ( ClassCastException e ) { Log.e( getClass().getSimpleName(), getActivity().toString() + " must implement ResponseJSONListener." ); }


    } // end onAttach

    /**
     * Overrides
     */



    @Override
    // begin onCreateView
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        // 0. inflate the layout with the waiting layout
        // 1. return inflated layout

        // 0. inflate the layout with the waiting layout

        // 1. return inflated layout

        return inflater.inflate( R.layout.fragment_loading, container, false );

    } // end onCreateView

    @Override
    // begin onStart
    public void onStart() {

        // 0. super things
        // 1. use the Volley singleton to attempt to get the JSON from World Bank
        // 1a. create a JSON array request based on the URL
        // 1a1.if the request is successful
        // 1a1a. store the response string for use across fragments
        // 1a1b. start the fragment for displaying datasets in chart form
        // 1b2. if the request has failed
        // 1b2a. start the fragment for showing an error
        // 1c. add the request to the request queue

        // 0. super things

        super.onStart();

        // 1. use the Volley singleton to attempt to get the JSON from World Bank

        // 1a. create a JSON array request based on the URL

        // begin JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(

                Request.Method.GET,

                requestURLListener.getRequestURL(),

                null,

                // begin new Response.Listener< JSONArray >
                new Response.Listener< JSONArray >() {

                    @Override
                    // begin onResponse
                    public void onResponse( JSONArray response ) {

                        // 1a1.if the request is successful
                        // 1a1a. store the response string for use across fragments

                        responseJSONListener.onSetResponseJSON( response.toString() );

                        Log.e( "onResponse: ", response.toString() );

                        // 1a1b. start the fragment for displaying datasets in chart form

                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                        fragmentManager

                                .beginTransaction()

                                .replace( R.id.m_fl_content, new ChartDisplayDatasetFragment() )

                                .addToBackStack( MainActivity.FRAGMENT_CHART_DISPLAY_DATASET )

                                .commit();

                    } // end onResponse

                }, // end new Response.Listener< JSONArray >

                // begin new Response.ErrorListener
                new Response.ErrorListener() {

                    @Override
                    // begin onErrorResponse
                    public void onErrorResponse( VolleyError error ) {

                        // 1b2. if the request has failed

                        // 1b2a. start the fragment for showing an error

                        FragmentManager fragmentManager = getFragmentManager();

                        fragmentManager

                                .beginTransaction()

                                .replace( R.id.m_fl_content, new ErrorFragment() )

                                .commit();

                    } // end onErrorResponse

                } // end new Response.ErrorListener

        ); // end JsonArrayRequest jsonArrayRequest = new JsonArrayRequest

        // 1c. add the request to the request queue

        VolleySingleton.getInstance( getActivity() ).addToRequestQueue( jsonArrayRequest );

    } // end onStart

    /** Other Methods */

} // end fragment WaitingFragment