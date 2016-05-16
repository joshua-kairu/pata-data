package com.jlt.patadata;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *
 * Pata Data - Displays World Bank JSON on Kenya
 *
 * Copyright (C) 2016 Kairu Joshua Wambugu
 *
 * <p/>
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

// begin fragment EmptyFragment
// the fragment that appears first time
// it displays the fact that no dataset has been chosen
public class EmptyFragment extends Fragment {

    /** CONSTANTS */

    /** VARIABLES */

    /** Floating Action Buttons */

    private FloatingActionButton selectDatasetFloatingActionButton; // fab to select a dataset

    /**
     * CONSTRUCTOR
     */

    // empty constructor for fragment subclasses
    public EmptyFragment() {}

    /** METHODS */

    /** Getters and Setters */

    /**
     * Overrides
     */

    @Override
    // begin onCreateView
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        // 0. inflate the view of this fragment from the empty fragment drawable
        // 1. register the create fab
        // 2. when the fab is clicked
        // 2a. take the user to choosing a dataset
        // 3. return the inflated view

        // 0. inflate the view of this fragment from the empty fragment drawable

        View rootView = inflater.inflate( R.layout.fragment_empty, container, false );

        // 1. register the create fab

        selectDatasetFloatingActionButton = ( FloatingActionButton ) rootView.findViewById( R.id.fem_fab_choose_dataset );

        // 2. when the fab is clicked

        // begin selectDatasetFloatingActionButton.setOnClickListener
        selectDatasetFloatingActionButton.setOnClickListener(

                // begin new View.OnClickListener
                new View.OnClickListener() {

                    @Override
                    // begin onClick
                    public void onClick( View v ) {

//                        Intent chooseDatasetIntent = new Intent();
//
//                        FragmentManager fragmentManager = getActivity().getFragmentManager();

                        // 2a. take the user to choosing a dataset

                        FragmentManager fragmentManager = getFragmentManager();

                        fragmentManager

                                .beginTransaction()

                                .replace( R.id.m_fl_content, new ChooseDatasetFragment() )

                                .commit();

                    } // end onClick

                } // end new View.OnClickListener

        ); // end selectDatasetFloatingActionButton.setOnClickListener

        // 3. return the inflated view

        return rootView;

    } // end onCreateView

    @Override
    // begin onDestroyView
    public void onDestroyView() {

        // 0. nullify the choose dataset fab
        // 1. super things

        // 0. nullify the choose dataset fab

        selectDatasetFloatingActionButton = null;

        // 1. super things

        super.onDestroyView();

    } // end onDestroyView

    /** Other Methods */

} // end fragment EmptyFragment