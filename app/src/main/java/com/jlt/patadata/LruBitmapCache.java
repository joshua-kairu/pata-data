package com.jlt.patadata;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

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

// begin class LruBitmapCache
// implements an in-memory LRU bitmap cache to cache (image) files directly to disk
public class LruBitmapCache extends LruCache< String, Bitmap > implements ImageLoader.ImageCache {

    /** CONSTANTS */

    /** VARIABLES */

    /** CONSTRUCTOR */

    // base constructor
    public LruBitmapCache( int maxSize ) { super( maxSize ); }

    // context based constructor
    public LruBitmapCache( Context context ) { this( getCacheSize( context ) ); }

    /** METHODS */

    /** Getters and Setters */

    /** Overrides */

    @Override
    public Bitmap getBitmap(String url) {
        return null;
    }

    @Override
    // putBitmap in cache
    public void putBitmap( String url, Bitmap bitmap ) { put( url, bitmap ); }

    @Override
    // sizeOf
    protected int sizeOf( String key, Bitmap value ) { return value.getRowBytes() * value.getHeight(); }

    /** Other Methods */

    /** Static Methods */

    // begin method getCacheSize
    // returns a cache size equal to approximately 3 screens worth of images
    public static int getCacheSize( Context context ) {

        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();

        final int screenWidth = displayMetrics.widthPixels;
        final int screenHeight = displayMetrics.heightPixels;

        // we assume that each pixel needs 4 bytes
        final int screenBytes = screenWidth * screenHeight * 4;

        // we need 3 screens
        return screenBytes * 3;

    } // end method getCacheSize

} // end class LruBitmapCache