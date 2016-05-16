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
 *
 */


// begin interface RequestURLListener
// takes care of a request for a World Bank URL and its response
public interface RequestURLListener {

    /** METHODS */

    // onSetRequestURL
    // sets the request URL
    public void onSetRequestURL( String requestURL );

    // getRequestURL
    // gets the request URL
    public String getRequestURL();


} // end interface RequestURLListener
