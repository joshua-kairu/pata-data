package com.jlt.patadata;

import android.content.SharedPreferences;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.os.Bundle;

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
public class SettingsActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    /** CONSTANTS */

    /** VARIABLES */

    /** METHODS */

    /** Getters and Setters */

    /**
     * Overrides
     */

    @Override
    // begin onCreate
    // credits: http://stackoverflow.com/questions/531427/how-do-i-display-the-current-value-of-an-android-preference-in-the-preference-su
    public void onCreate( @Nullable Bundle savedInstanceState ) {

        // 0. super things
        // 1. load preferences from XML
        // 2. initialize summaries

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. load preferences from XML

        addPreferencesFromResource( R.xml.xml_preferences );

        // 2. initialize summaries

        initializeSummaries( getPreferenceScreen() );

    } // end onCreate

    @Override
    // begin onResume
    protected void onResume() {

        // 0. super things
        // 1. register a callback to be invoked whenever a user changes a pref

        // 0. super things

        super.onResume();

        // 1. register a callback to be invoked whenever a user changes a pref

        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener( this );

    } // end onResume

    @Override
    // begin onPause
    protected void onPause() {

        // 0. super things
        // 1. unregister pref change listener to reduce sys overhead

        // 0. super things

        super.onPause();

        // 1. unregister pref change listener to reduce sys overhead

        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener( this );

    } // end onPause

    @Override
    // begin onSharedPreferenceChanged
    // called when a shared preference is changed, added, or removed
    public void onSharedPreferenceChanged( SharedPreferences sharedPreferences, String key ) {

        // 0. if the changed preference is the animation one
        // 0a. show the changed animation frequency in the animation preference summary
        // 1. if the changed preference is the round off one
        // 1a. show the changed round off in the round off preference summary

        // 0. if the changed preference is the animation one

        // begin if for if the changed pref's key is the animation one
        if ( key.equals( MainActivity.PREFERENCE_LIST_CHART_ANIMATION_FREQUENCY ) == true ) {

            Preference chartAnimationFrequencyPreference = findPreference( key );

            // 0a. show the changed animation frequency in the animation preference summary

            chartAnimationFrequencyPreference.setSummary(
                    getResources().getString( R.string.preference_chart_animation_frequency_summary,
                                              MainActivity.translatePreference( this, sharedPreferences.getString( key, getResources().getString( R.string.preference_problem ) ) )
                                               )
            );

        } // end if for if the changed pref's key is the animation one

        // 1. if the changed preference is the round off one

        // begin if for if the changed pref's the round off one
        if ( key.equals( MainActivity.PREFERENCE_NUMBER_PICKER_ROUND_OFF ) == true ) {

            Preference roundOffPreference = findPreference( key );

            // 1a. show the changed round off in the round off preference summary

            int roundOffDecimalPlace = sharedPreferences.getInt( key, -2 );

            roundOffPreference.setSummary(
                    getResources().getString(

                            // sanitize the output so that it does not say one decimal places ;-)
                            ( roundOffDecimalPlace != 1 ) ? R.string.preference_round_off_summary_not_one : R.string.preference_round_off_summary_one,
                            roundOffDecimalPlace )

            );

        } // end if for if the changed pref's the round off one

    } // end onSharedPreferenceChanged

    /** Other Methods */

    // begin method initializeSummaries
    private void initializeSummaries( Preference preference ) {

        // 0. if the passed preference is a preference group
        // 0a. get each preference from the group so as to update it
        // 1. else the passed preference is an actual preference
        // 1a. update it as needed

        // 0. if the passed preference is a preference group

        // if for if the parameter preference is a preference group
        if ( preference instanceof PreferenceGroup ) {

            // 0a. get each preference from the group so as to update it

            PreferenceGroup preferenceGroup = ( PreferenceGroup ) preference;

            // for to go through all the preferences in the preference group
            for( int i = 0; i < preferenceGroup.getPreferenceCount(); i++ )
            { initializeSummaries( preferenceGroup.getPreference( i ) ); }

        } // end for if the parameter preference is a preference group

        // 1. else the passed preference is an actual preference

        // 1a. update it as needed

        else{ updatePreferenceSummary( preference ); }

    } // end method initializeSummaries

    // begin method updatePreferenceSummary
    // updates the summary of the passed preference
    private void updatePreferenceSummary ( Preference preference ) {

        // 0. if the passed pref is a list
        // 0a. set its summary as the list's current entry
        // 1. if the passed pref is a round off picker
        // 1a. set its summary as the selected round off decimal place(s)

        // 0. if the passed pref is a list

        // begin if for if the pref is a list
        if ( preference instanceof ListPreference ) {

            ListPreference listPreference = ( ListPreference ) preference;

            // 0a. set its summary as the list's current entry

            preference.setSummary( listPreference.getEntry() );

        } // end if for if the pref is a list

        // 1. if the passed pref is a round off picker

        // begin if for if the pref is a number picker
        if ( preference instanceof RoundOffNumberPickerPreference ) {

            RoundOffNumberPickerPreference numberPickerPreference = ( RoundOffNumberPickerPreference ) preference;

            // 1a. set its summary as the selected round off decimal place(s)

            int roundOffDecimalPlace = numberPickerPreference.getCurrentNumber();

            preference.setSummary(

                    getResources().getString(

                            // sanitize the output so that it does not say one decimal places ;-)
                            ( roundOffDecimalPlace != 1 ) ? R.string.preference_round_off_summary_not_one : R.string.preference_round_off_summary_one,
                            roundOffDecimalPlace

                    )

            );

        } // end if for if the pref is a number picker

    } // end method updatePreferenceSummary

} // end fragment SettingsActivity