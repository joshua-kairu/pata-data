package com.jlt.patadata;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;

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

// begin class WorldBankJSONUtils
// has some utility methods to manipulate worold bank JSON
public class WorldBankJSONUtils {

    /** CONSTANTS */

    public static final int DATASET_START_YEAR = 1960; // the first year that has a dataset at World Bank

    /** VARIABLES */

    /** CONSTRUCTOR */

    /** METHODS */

    /** Getters and Setters */

    /** Overrides */

    /** Other Methods */

    // begin method getPreamble
    // gets the preamble from the input JSON string
    // we assume the input JSON is gotten from the World Bank API
    public static Preamble getPreamble( String inputJSON ) {

        // 0. get the preamble's JSON string
        // 1. return a preamble from that string

        // 0. get the preamble's JSON string
        // 1. return a preamble from that string

        Gson gson = new Gson();

        return gson.fromJson( getPreambleJSONString( inputJSON ), Preamble.class );

    } // end method getPreamble

    // begin method getDatasetsFromJSON
    public static ArrayList< Dataset > getDatasetsFromJSON( String inputJSON ) {

        // 0. get the JSON string representing the datasets
        // 1. return a list of datasets from that string

        Gson gson = new Gson();

        Type collectionType = new TypeToken< Collection < Dataset > >(){}.getType();
        return gson.fromJson( getDatasetsJSONString( inputJSON ), collectionType );

    } // end method getDatasetsFromJSON

    // begin method getPreambleJSONString
    // gets the string representation of the preamble JSON
    private static String getPreambleJSONString( String inputJSON ) {

        // preamble looks like this
        // [{"page":1,"pages":1,"per_page":"100","total":56},[{"indicator"
        // [<{"page":1,"pages":1,"per_page":"100","total":56}>,[{"indicator"
        // < and > show where the preamble starts and ends respectively

        // 0. initialize the return string
        // 1. read everything up to and including the second opening square bracket ([)
        // 2. remove the first [
        // 3. remove the last [
        // 4. remove the last comma (,)
        // 5. return the resultant string

        // 0. initialize the return string

        String returnedString = "";

        // 1. read everything up to and including the second opening square bracket ([)

        int numberOfSquareBrackets = 0; int i = 0;

        // begin while to go through the read JSON as long as the number of square brackets read is less than two
        while( numberOfSquareBrackets < 2 ) {

            // 0. read a character in the array
            // 1. if the character is a square bracket
            // 1a. increment the number of square brackets read by 1
            // 2. add the read character to the string to be returned
            // 3. increment the counter by 1

            // 0. read a character in the array

            Character readCharacter = inputJSON.charAt( i );

            // 1. if the character is a square bracket
            // 1a. increment the number of square brackets read by 1

            if( readCharacter == '[' ) { numberOfSquareBrackets++; }

            // 2. add the read character to the string to be returned

            returnedString += readCharacter;

            // 3. increment the counter by 1

            i++;

        } // end while to go through the read JSON as long as the number of square brackets read is less than two

        // 2. remove the first [

        returnedString = returnedString.substring( 1 );

        // 3. remove the last [

        returnedString = returnedString.substring( 0, returnedString.length() - 1 );

        // 4. remove the last comma (,)

        returnedString = returnedString.substring( 0, returnedString.length() - 1 );

        // 5. return the resultant string

        return returnedString;

    } // end method getPreambleJSONString

    // begin method getDatasetsJSONString
    // gets the JSON string representing the datasets
    private static String getDatasetsJSONString( String inputJSON ) {

        // 0. initialize the return string
        // 1. remove the preamble from the whole JSON
        // 2. remove the first [ and , from the remaining JSON
        // 3. remove the last ] from the remaining JSON
        // 4. return the remaining JSON

        // 0. initialize the return string

        String returnString = "";

        // 1. remove the preamble from the whole JSON

        returnString = inputJSON.replace( getPreambleJSONString( inputJSON ), "" );

        // 2. remove the first [ and , from the remaining JSON

        returnString = returnString.substring( 2 );

        // 3. remove the last ] from the remaining JSON

        returnString = returnString.substring( 0, returnString.length() - 1 );

        // 4. return the remaining JSON

        return returnString;

    } // end method getDatasetsJSONString

    // begin method getDatasetYearsAsString
    // returns an array of integers that represent all the years covered in the World Bank datasets
    // from 1960 to now
    public static int[] getDatasetYearsAsString() {

        // 0. get the current year
        // 1. get the number of years between now and datasets' start year, including datasets' start year
        // 2. use this number as the length of the array to return
        // 3. populate the array with the years from datasets' start year to now
        // 4. return the array

        // 0. get the current year

        Calendar currentCalendar = Calendar.getInstance();

        int currentYear = currentCalendar.get( Calendar.YEAR );

        // 1. get the number of years between now and datasets' start year, including datasets' start year

        int numberOfYears = ( currentYear - DATASET_START_YEAR ) + 1;

        // 2. use this number as the length of the array to return

        int[] yearsArray = new int[ numberOfYears ];

        // 3. populate the array with the years from datasets' start year to now

        // for to do the population
        for( int i = 0; i < yearsArray.length; i++ ) { yearsArray[ i ] = DATASET_START_YEAR + i; }

        // 4. return the array

        return yearsArray;

    } // end method getDatasetYearsAsString

    /** INNER CLASSES */

    // begin class RequestQueryBuilder
    // creates a query based on a request
    public static class RequestQueryBuilder {

        // to get the dataset on "Agricultural irrigated land (% of total agricultural land)"
        // with 100 entries per page
        // containing entries from 1960 to 2016
        // in JSON form

        // the query looks like: http://api.worldbank.org/countries/KEN/indicators/AG.LND.IRIG.AG.ZS?per_page=100&date=1960:2016&format=json

        /** CONSTANTS */

        /** Strings */

        // Strings for building the query

        private static String

        BASE_URL = "http://api.worldbank.org/countries/KEN/indicators/", // the base URL

        QUESTION_MARK = "?", // the question mark

        PER_PAGE = "per_page=100", // number of entries per page - 100 per page for now

        AMPERSAND = "&", // the ampersand

        COLON = ":", // the colon used for dates

        FORMAT = "format=json"; // the format of the entries - JSON for now

        // Strings for the indicators

        public static String

        AGRI_IRIG_LAND_PERCENT_TOTAL_AGRI_LAND_VALUE = "Agricultural irrigated land (% of total agricultural land)",
        AGRI_IRIG_LAND_PERCENT_TOTAL_AGRI_LAND_ID = "AG.LND.IRIG.AG.ZS",

        AGRI_LAND_PERCENT_LAND_AREA_VALUE = "Agricultural land (% of land area)",
        AGRI_LAND_PERCENT_LAND_AREA_ID = "AG.LND.AGRI.ZS",

        AGRI_MACH_TRACTORS_PER_100_SQKM_ARABLE_LAND_VALUE = "Agricultural machinery, tractors per 100 sq. km of arable land",
        AGRI_MACH_TRACTORS_PER_100_SQKM_ARABLE_LAND_ID = "AG.LND.TRAC.ZS",

        AGRI_METHANE_EMISSIONS_PERCENT_TOTAL_VALUE = "Agricultural methane emissions (% of total)",
        AGRI_METHANE_EMISSIONS_PERCENT_TOTAL_ID = "EN.ATM.METH.AG.ZS",

        AGRI_NOX_EMISSIONS_PERCENT_TOTAL_VALUE = "Agricultural nitrous oxide emissions (% of total)",
        AGRI_NOX_EMISSIONS_PERCENT_TOTAL_ID = "EN.ATM.NOXE.AG.ZS",

        AGRI_VALUE_ADD_PER_WORKER_CONSTANT_2005_USD_VALUE = "Agriculture value added per worker (constant 2005 US$)",
        AGRI_VALUE_ADD_PER_WORKER_CONSTANT_2005_USD_ID = "EA.PRD.AGRI.KD",

        AGRI_VALUE_ADD_PERCENT_GDP_VALUE = "Agriculture, value added (% of GDP)",
        AGRI_VALUE_ADD_PERCENT_GDP_ID = "NV.AGR.TOTL.ZS",

        ARABLE_LAND_PERCENT_LAND_AREA_VALUE = "Arable land (% of land area)",
        ARABLE_LAND_PERCENT_LAND_AREA_ID = "AG.LND.ARBL.ZS",

        ARABLE_LAND_HA_PER_PERSON_VALUE = "Arable land (hectares per person)",
        ARABLE_LAND_HA_PER_PERSON_ID = "AG.LND.ARBL.HA.PC",

        CEREAL_YIELD_KG_PER_HA_VALUE = "Cereal yield (kg per hectare)",
        CEREAL_YIELD_KG_PER_HA_ID = "AG.YLD.CREL.KG",

//        Consumer price index (2010 = 100)

//        Depth of the food deficit (kilocalories per person per day)

//        Droughts, floods, extreme temperatures (% of population, average 1990-2009)

        EMPL_AGRI_PERCENT_TOTAL_EMPL_VALUE = "Employment in agriculture (% of total employment)",
        EMPL_AGRI_PERCENT_TOTAL_EMPL_ID = "SL.AGR.EMPL.ZS",

        EMPL_AGRI_FE_PERCENT_TOTAL_EMPL_VALUE = "Employment in agriculture, female (% of total employment)",
        EMPL_AGRI_FE_PERCENT_TOTAL_EMPL_ID = "SL.AGR.EMPL.FE.ZS",

        EMPL_AGRI_MA_PERCENT_TOTAL_EMPL_VALUE = "Employment in agriculture, male (% of total employment)",
        EMPL_AGRI_MA_PERCENT_TOTAL_EMPL_ID = "SL.AGR.EMPL.MA.ZS",

//        Food exports (% of merchandise exports)

//        Food imports (% of merchandise exports)

        FOOD_PROD_INDEX_VALUE = "Food production index (2004-2006 = 100)",
        FOOD_PROD_INDEX_ID = "AG.PRD.FOOD.XD",

        INFL_CONS_PRICES_ANNUAL_PERCENT_VALUE = "Inflation, consumer prices (annual %)",
        INFL_CONS_PRICES_ANNUAL_PERCENT_ID = "FP.CPI.TOTL.ZG",

        LAND_CEREAL_PROD_HA_VALUE = "Land under cereal production (hectares)",
        LAND_CEREAL_PROD_HA_ID = "AG.LND.CREL.HA",

        PERM_CROPLAND_PERCENT_LAND_AREA_VALUE = "Permanent cropland (% of land area)",
        PERM_CROPLAND_PERCENT_LAND_AREA_ID = "AG.LND.CROP.ZS",

        PREV_STUNT_HEIGHT_FOR_AGE_PERCENT_KIDS_UNDER_FIVE_VALUE = "Prevalence of stunting, height for age (% of children under 5)",
        PREV_STUNT_HEIGHT_FOR_AGE_PERCENT_KIDS_UNDER_FIVE_ID = "SH.STA.STNT.ZS",

//        PREV_STUNT_HEIGHT_FOR_AGE_FE_PERCENT_KIDS_UNDER_FIVE_VALUE = "Prevalence of stunting, height for age, female (% of children under 5)",
//        PREV_STUNT_HEIGHT_FOR_AGE_FE_PERCENT_KIDS_UNDER_FIVE_id = "SH.STA.STNT.ZS",

//        Prevalence of stunting, height for age, female (% of children under 5)

//        Prevalence of stunting, height for age, male (% of children under 5)

//        Prevalence of wasting, weight for height (% of children under 5)

//        Prevalence of wasting, weight for height, female (% of children under 5)

//        Prevalence of wasting, weight for height, male (% of children under 5)

        RES_DEV_EXPE_PERCENT_GDP_VALUE = "Research and development expenditure (% of GDP)",
        RES_DEV_EXPE_PERCENT_GDP_ID = "GB.XPD.RSDV.GD.ZS",

        RESEARCHERS_IN_RND_PER_MILLION_VALUE = "Researchers in R&D (per million people)",
        RESEARCHERS_IN_RND_PER_MILLION_ID = "SP.POP.SCIE.RD.P6",

        SHARE_WOMEN_WAGE_EMPL_NON_AGRI_PERCENT_NON_AGRI_EMPL_VALUE = "Share of women in wage employment in the nonagricultural sector (% of total nonagricultural employment)",
        SHARE_WOMEN_WAGE_EMPL_NON_AGRI_PERCENT_NON_AGRI_EMPL_ID = "SL.EMP.INSV.FE.ZS";

//        Subsidies and other transfers (% of expense)

//        Subsidies and other transfers (current LCU)

//        Total fisheries production (metric tons)

        /** VARIABLES */

        /** CONSTRUCTOR */

        /** METHODS */

        /** Getters and Setters */

        /** Overrides */

        /** Other Methods */

        // begin method getHashMap
        // creates a hash map of the possible queries and returns it
        // the hash map maps a value to an ID
        private static HashMap< String, String > getHashMap() {

            // 0. initialize the hashmap
            // 1. manually create the mappings
            // 2. return the hashmap

            // 0. initialize the hashmap

            HashMap< String, String > returnHashMap = new HashMap< String, String >();

            // 1. manually create the mappings

            returnHashMap.put( AGRI_IRIG_LAND_PERCENT_TOTAL_AGRI_LAND_VALUE, AGRI_IRIG_LAND_PERCENT_TOTAL_AGRI_LAND_ID );

            returnHashMap.put( AGRI_LAND_PERCENT_LAND_AREA_VALUE, AGRI_LAND_PERCENT_LAND_AREA_ID );

            returnHashMap.put( AGRI_MACH_TRACTORS_PER_100_SQKM_ARABLE_LAND_VALUE, AGRI_MACH_TRACTORS_PER_100_SQKM_ARABLE_LAND_ID );

            returnHashMap.put( AGRI_METHANE_EMISSIONS_PERCENT_TOTAL_VALUE, AGRI_METHANE_EMISSIONS_PERCENT_TOTAL_ID );

            returnHashMap.put( AGRI_NOX_EMISSIONS_PERCENT_TOTAL_VALUE, AGRI_NOX_EMISSIONS_PERCENT_TOTAL_ID );

            returnHashMap.put( AGRI_VALUE_ADD_PER_WORKER_CONSTANT_2005_USD_VALUE, AGRI_VALUE_ADD_PER_WORKER_CONSTANT_2005_USD_ID );

            returnHashMap.put( AGRI_VALUE_ADD_PERCENT_GDP_VALUE, AGRI_VALUE_ADD_PERCENT_GDP_ID );

            returnHashMap.put( ARABLE_LAND_PERCENT_LAND_AREA_VALUE, ARABLE_LAND_PERCENT_LAND_AREA_ID );

            returnHashMap.put( ARABLE_LAND_HA_PER_PERSON_VALUE, ARABLE_LAND_HA_PER_PERSON_ID );

            returnHashMap.put( CEREAL_YIELD_KG_PER_HA_VALUE, CEREAL_YIELD_KG_PER_HA_ID );

            // Consumer price index (2010 = 100)

            // Depth of the food deficit (kilocalories per person per day)

            // Droughts, floods, extreme temperatures (% of population, average 1990-2009)

            returnHashMap.put( EMPL_AGRI_PERCENT_TOTAL_EMPL_VALUE, EMPL_AGRI_PERCENT_TOTAL_EMPL_ID );

            returnHashMap.put( EMPL_AGRI_FE_PERCENT_TOTAL_EMPL_VALUE, EMPL_AGRI_FE_PERCENT_TOTAL_EMPL_ID );

            returnHashMap.put( EMPL_AGRI_MA_PERCENT_TOTAL_EMPL_VALUE, EMPL_AGRI_MA_PERCENT_TOTAL_EMPL_ID );

            // Food exports (% of merchandise exports)

            // Food imports (% of merchandise exports)

            returnHashMap.put( FOOD_PROD_INDEX_VALUE, FOOD_PROD_INDEX_ID );

            returnHashMap.put( INFL_CONS_PRICES_ANNUAL_PERCENT_VALUE, INFL_CONS_PRICES_ANNUAL_PERCENT_ID );

            returnHashMap.put( LAND_CEREAL_PROD_HA_VALUE, LAND_CEREAL_PROD_HA_ID );

            returnHashMap.put( PERM_CROPLAND_PERCENT_LAND_AREA_VALUE, PERM_CROPLAND_PERCENT_LAND_AREA_ID );

            returnHashMap.put( PREV_STUNT_HEIGHT_FOR_AGE_PERCENT_KIDS_UNDER_FIVE_VALUE, PREV_STUNT_HEIGHT_FOR_AGE_PERCENT_KIDS_UNDER_FIVE_ID );

            // PREV_STUNT_HEIGHT_FOR_AGE_FE_PERCENT_KIDS_UNDER_FIVE_VALUE = "Prevalence of stunting, height for age, female (% of children under 5)",

            // PREV_STUNT_HEIGHT_FOR_AGE_FE_PERCENT_KIDS_UNDER_FIVE_id = "SH.STA.STNT.ZS",

            // Prevalence of stunting, height for age, female (% of children under 5)

            // Prevalence of stunting, height for age, male (% of children under 5)

            // Prevalence of wasting, weight for height (% of children under 5)

            // Prevalence of wasting, weight for height, female (% of children under 5)

            // Prevalence of wasting, weight for height, male (% of children under 5)

            returnHashMap.put( RES_DEV_EXPE_PERCENT_GDP_VALUE, RES_DEV_EXPE_PERCENT_GDP_ID );

            returnHashMap.put( RESEARCHERS_IN_RND_PER_MILLION_VALUE, RESEARCHERS_IN_RND_PER_MILLION_ID );

            returnHashMap.put( SHARE_WOMEN_WAGE_EMPL_NON_AGRI_PERCENT_NON_AGRI_EMPL_VALUE, SHARE_WOMEN_WAGE_EMPL_NON_AGRI_PERCENT_NON_AGRI_EMPL_ID );

            // 2. return the hashmap

            return returnHashMap;

        } // end method getHashMap

        // begin method getRequestQueryURL
        // returns the query URL for the dataset passed in
        // during the time period specified
        public static String getRequestQueryURL( String inputDataset, int startYear, int endYear ) {

            // to get the dataset on "Agricultural irrigated land (% of total agricultural land)"
            // with 100 entries per page
            // containing entries from 1960 to 2016
            // in JSON form

            // the query looks like: http://api.worldbank.org/countries/KEN/indicators/AG.LND.IRIG.AG.ZS?per_page=100&date=1960:2016&format=json

            // 0. initialize the query to return
            // 1. get the hashmap of all the registered queries
            // 2. get the ID of the input dataset from the hashmap
            // 3. build the query
            // 3a. if the start year and the end year are similar use just one (the end year)
            // 3b. else use both
            // 4. return the query

            // 0. initialize the query to return

            String queryString = "";

            // 1. get the hashmap of all the registered queries

            // 2. get the ID of the input dataset from the hashmap

            String inputDatasetID = getHashMap().get( inputDataset );

            // 3. build the query

            // the query looks like: http://api.worldbank.org/countries/KEN/indicators/AG.LND.IRIG.AG.ZS?per_page=100&date=1960:2016&format=json

            String yearString = "date=";

            // 3a. if the start year and the end year are similar use just one (the end year)

            if( startYear == endYear ) { yearString += String.valueOf( endYear ); }

            // 3b. else use both

            else { yearString += String.format( Locale.ENGLISH, "%d%s%d", startYear, COLON, endYear ); }

            queryString = BASE_URL + inputDatasetID + QUESTION_MARK + PER_PAGE + AMPERSAND + yearString + AMPERSAND + FORMAT;

            // 4. return the query

            return queryString;

        } // end method getRequestQueryURL

        // method getRequestQueryURL
        // a getRequestQueryURL that takes only one year parameter
        public static String getRequestQueryURL( String inputDataset, int year ) { return getRequestQueryURL( inputDataset, year, year ); }

        // begin method getDatasetValues
        // returns an array of all the values of the datasets that the query builder has
        public static String [] getDatasetValues() {

            // dataset values are the keys in the hashmap

            // 0. get the hashmap
            // 1. get all the keys of the hashmap as a Set
            // 2. use the length of the Set to initialize the return array
            // 3. populate the return array with the Set
            // 4. ensure alphabetical ordering in the return array
            // 5. return the return array

            // 0. get the hashmap

            // 1. get all the keys of the hashmap as a Set

            // 2. use the length of the Set to initialize the return array

            // 3. populate the return array with the Set

            String returnArray[] = new String[ getHashMap().keySet().size() ];

            returnArray = getHashMap().keySet().toArray( returnArray );

            // 4. ensure alphabetical ordering in the return array

            Arrays.sort( returnArray );

            // 5. return the return array

            return returnArray;

        } // end method getDatasetValues

    } // end class RequestQueryBuilder

} // end class WorldBankJSONUtils