package com.jlt.patadata;

import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
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

// begin fragment SettingsActivity
// handles settings
public class SettingsActivity extends PreferenceFragment {

    /** CONSTANTS */

    /** VARIABLES */

    /**
     * CONSTRUCTOR
     */

    // empty constructor for fragment subclasses
    public SettingsActivity() {
    }

    /** METHODS */

    /** Getters and Setters */

    @Override
    // begin onCreate
    public void onCreate( @Nullable Bundle savedInstanceState ) {

        // 0. super things
        // 1. load preferences from XML

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. load preferences from XML

        addPreferencesFromResource( R.xml.xml_preferences );

    } // end onCreate

    /**
     * Overrides
     */



    @Override
    // begin onCreateView
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        return null;

    } // end onCreateView

    /** Other Methods */

} // end fragment SettingsActivity