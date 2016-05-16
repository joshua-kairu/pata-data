package com.jlt.patadata;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

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

// begin class DatasetAdapter
// populates the dataset recycler view
public class DatasetAdapter extends RecyclerView.Adapter< DatasetViewHolder > {

    /** CONSTANTS */

    /** VARIABLES */

    /** Datasets */

    private ArrayList< Dataset > datasets; // the datasets

    /** CONSTRUCTOR */

    // constructor
    // initializes the datasets
    public DatasetAdapter( ArrayList< Dataset > datasets ) { this.datasets = datasets; }

    /** METHODS */

    /** Getters and Setters */

    /** Overrides */

    @Override
    // begin onCreateViewHolder
    public DatasetViewHolder onCreateViewHolder( ViewGroup parent, int viewType ) {

        // 0. get the parent context
        // 1. get an inflater from the parent context
        // 2. inflate the individual dataset in list layout
        // 3. return a new dataset view holder instance

        // 0. get the parent context

        Context context = parent.getContext();

        // 1. get an inflater from the parent context

        LayoutInflater layoutInflater = LayoutInflater.from( context );

        // 2. inflate the individual dataset in list layout

        View datasetView = layoutInflater.inflate( R.layout.individual_dataset_list_item, parent, false );

        // 3. return a new dataset view holder instance

        DatasetViewHolder datasetViewHolder = new DatasetViewHolder( datasetView );
        return datasetViewHolder;

    } // end onCreateViewHolder

    @Override
    // begin onBindViewHolder
    public void onBindViewHolder( DatasetViewHolder datasetViewHolder, int position ) {

        // 0. get the dataset object based on the position
        // 1. set layout views based on the gotten dataset

        // 0. get the dataset object based on the position

        Dataset dataset = datasets.get( position );

        // 1. set layout views based on the gotten dataset

        TextView yearTextView = datasetViewHolder.yearTextView;
        yearTextView.setText( String.valueOf( dataset.getYear() ) );

        TextView valueTextView = datasetViewHolder.valueTextView;
        valueTextView.setText( String.valueOf( dataset.getValue() ) );

    } // end onBindViewHolder

    @Override
    // getItemCount
    // total count of items
    public int getItemCount() { return datasets.size(); }

    /** Other Methods */

} // end class DatasetAdapter