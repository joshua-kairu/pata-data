package com.jlt.patadata;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Copyright 2016 Kairu Joshua Wambugu
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * <p/>
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * <p/>
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// begin class GsonRequest
public class GsonRequest< T > extends Request< T > {

    /** CONSTANTS */

    /** VARIABLES */

    /** Classes */

    private final Class< T > aClass; // a class

    /** Gsons */

    private final Gson gson = new Gson();

    /** Listeners */

    private final Response.Listener< T > listener; // a listener for the response

    /** Maps */

    private final Map< String, String > headers;

    /** CONSTRUCTOR */
    // begin constructor
    public GsonRequest( String inputUrl, Class< T > inputClass, Map< String, String > inputRequestHeaders, Response.Listener< T > responseListener, Response.ErrorListener errorListener ) {

        // 0. make a GET request
        // 1. return the parsed object from JSON

        super( Method.GET, inputUrl, errorListener );

        aClass = inputClass; // input class will be reflected by Gson
        listener = responseListener;
        headers = inputRequestHeaders; // a Map of request headers

    } // end constructor

    /** METHODS */

    /** Getters and Setters */

    /** Overrides */

    @Override
    // deliverResponse
    // delivers the response by calling the listener's onResponse
    protected void deliverResponse( T response ) { listener.onResponse( response ); }

    @Override
    // getHeaders
    public Map< String, String > getHeaders() throws AuthFailureError { return ( headers != null ) ? headers : super.getHeaders(); }

    @Override
    // begin parseNetworkResponse
    // parse the network's response and returns the necessary data
    protected Response<T> parseNetworkResponse( NetworkResponse networkResponse ) {

        // begin try to try parse
        try {

            // 0. convert the received byte array into a string using the HTTP header charset
            // 1. convert the string to the class specified by the T parameter
            // 2. return said class

            //  0. convert the received byte array into a string using the HTTP header charset

            String jsonString = new String( networkResponse.data, HttpHeaderParser.parseCharset( networkResponse.headers ) );

            // 1. convert the string to the class specified by the T parameter
            // 2. return said class

            return Response.success( gson.fromJson( jsonString, aClass ), HttpHeaderParser.parseCacheHeaders( networkResponse ) );

        } // end try to try parse

        // catch problems with the HTTP parsing
        catch ( UnsupportedEncodingException e ) { return Response.error( new ParseError( e ) ); }

        // catch issues with malformed json
        catch ( JsonSyntaxException e ) { return Response.error( new ParseError( e ) ); }

    } // end parseNetworkResponse

    /** Other Methods */

} // end class GsonRequest