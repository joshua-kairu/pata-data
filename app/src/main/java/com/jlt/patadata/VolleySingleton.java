package com.jlt.patadata;
/**
 * Created by joshua on 5/3/16.
 */

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

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

// begin application VolleySingleton
public class VolleySingleton {

    /** CONSTANTS */

    /** Contexts */

    private static Context context; // the context

    /** Volley Singletons */

    private static VolleySingleton myVolleyInstance;

    /** VARIABLES */

    /** Image Loaders */

//    private ImageLoader imageLoader; // image loader to load images via volley

    /** Request Queues */

    private RequestQueue requestQueue; // the request queue

    /** CONSTRUCTOR */

    // begin constructor for VolleySingleton
    private VolleySingleton( Context aContext ) {

        context = aContext;

        requestQueue = getRequestQueue();

        // begin imageLoader = new ImageLoader
//        imageLoader = new ImageLoader(
//
//                requestQueue,
//
//                // begin new ImageLoader.ImageCache< String, Bitmap >
//                new ImageLoader.ImageCache() {
//
//                    private final LruCache< String, Bitmap > lruCache = new LruCache< String, Bitmap >( 20 );
//
//                    @Override
//                    // method getBitmap
//                    public Bitmap getBitmap( String url ) { return lruCache.get( url ); }
//
//                    @Override
//                    // method putBitmap
//                    public void putBitmap( String url, Bitmap bitmap ) { lruCache.put( url, bitmap ); }
//
//                } // end new ImageLoader.ImageCache< String, Bitmap >
//
//        ); // end imageLoader = new ImageLoader

//        imageLoader = new ImageLoader( requestQueue, new LruBitmapCache( context ) );

    } // end constructor for VolleySingleton

    /** METHODS */

    /** Getters and Setters */

    // begin getter for request queue
    public RequestQueue getRequestQueue() {

        // begin if for if the request queue is null
        if( requestQueue == null ) {

            // use getApplicationContext so as to
            // avoid leaking the Activity or BroadcastReceiver if someone passes one in
            requestQueue = Volley.newRequestQueue( context.getApplicationContext() );

        } // end if for if the request queue is null

        return requestQueue;

    } // end getter for request queue

//    // getter for the image loader
//    public ImageLoader getImageLoader() { return imageLoader; }

    /** Overrides */

    /**
     * Other Methods
     */

    // begin method addToRequestQueue
    public < T > void addToRequestQueue( Request< T > request ) {

        getRequestQueue().add( request );

    } // end method addToRequestQueue

    /**
     * Static Methods
     */

    // begin getInstance
    public static VolleySingleton getInstance( Context aContext ) {

        if ( myVolleyInstance == null ) { myVolleyInstance = new VolleySingleton( aContext ); }

        return myVolleyInstance;

    } // end getInstance

} // end application MySingleton
