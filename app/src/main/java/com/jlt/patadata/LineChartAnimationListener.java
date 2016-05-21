package com.jlt.patadata;

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

// begin interface LineChartAnimationListener
// used for listening for when the line chart has been animated
public interface LineChartAnimationListener {

    /** CONSTANTS */

    /** VARIABLES */

    /** METHODS */

    /** Getters and Setters */

    /** Overrides */

    /** Other Methods */

    // getter for if the line chart has been animated once

    public boolean isChartAnimatedOnce();

    // setter for when the chart has been animated

    public void onSetChartAnimated( boolean chartAnimated );

} // end interface SelectedDatasetListener
