# Pata Data
A way to access World Bank APIs for open datasets. 

## Introduction :point_up:

Pata Data is an Android application designed to get World Bank data and display it. It is 
built on top of the [Android Volley Framework] (https://developer.android.com/training/volley/index.html).

## Version History :package:

**latest**&nbsp;&nbsp;&nbsp;[Pata Data v1.0.0](https://github.com/joshua-kairu/pata-data/releases/download/v1.0.0/pata-data-v1.0.0.apk)&nbsp;&nbsp;&nbsp;Wednesday, June 15, 2016 <br/>

This repo tries its best to follow the [Semantic Versioning](http://semver.org/) guidelines.

## How To Use :wrench:

Please follow these steps to use the app:

:one: Install the app.<br/>
:two: Run the app.<br/>
:three: You will find a screen that allows you to select a dataset as well as the start and end years for the dataset.<br/>
:four: Select the search button on the bottom right to as to fetch the dataset information from World Bank.<br/>
:five: After the data is gotten from the World Bank, it will be displayed in chart form.<br/>
:six: Press the back button to go back to the dataset selection screen.<br/>

The video below shows the previously mentioned steps.

![Pata Data - Basic Use](screen-records/pata-data-2016-06-13-221127.gif) 

You can also choose to view the data in tabular form. Here is how to do it:

:one: In the screen showing the graphical form of the data, tap the table icon to see the data in tabular form.<br/>
:two: If you want to go back to the chart, tap the chart icon the table screen<br/>

The video below shows this.

![Pata Data -Switching Between Chart and Table Views](screen-records/pata-data-chart-and-table-2016-06-13-221127.gif) 

## Abilities :muscle:

This app has the superpowers to:
* fetch (some relevant) World Bank datasets about Kenya in JSON form.
* display the datasets in a scrollable list.
* display the datasets in graph form.

## Limitations :worried:

This app is currently unable to:
* fetch datasets about another country.
* edit app settings.

Also, there are some hurdles inherent in the World Bank datasets themselves. These include:
* datasets missing data on particular years, 
* datasets having ```0.0``` as the value for all data in all the years between the start and the end year. This scenario can be seen in the video below:

![Pata Data - Zero Data](screen-records/pata-data-zero-data-2016-06-13-221127.gif) 

## Possible Future Work :fast_forward:

As of today Tuesday, May 24, 2016, some of the things that should be implemented are:
- [ ] A settings section for user customization. We attempt to do this in the create-settings branch.

## Other things :books:

This is my first uploaded app that I apploaded myself. :bowtie:

And the videos here demostrate the app working in portrait phone orientation. The app also works in landscape orientation. :smile:

## License :lock_with_ink_pen:

This repository is licensed under the [GNU General Public License Version 3](http://www.gnu.org/licenses/gpl-3.0.en.html).
