package com.example.android.abndproject4_musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 *  Udacity - Grow with Google - Android Basics NanoDegree Progrem
 *  Project 4 - Music player app
 *  Warren Mick - June 15, 2018
 *
 *  This project is the framework for a music player app.    The app provides lists
 *  tracks in several genres.   The app has three main activities:
 *  the opening activity gives the user a selection of genres to choose from.
 *  on clicking a genre, a second activitiy then shows a list of tracks for that genre.
 *  If track is clicked, a third activity opens to play the track.   There are no music
 *  files included with the app nor the functionality to play a track.
 */

public class MainActivity extends AppCompatActivity {

    // arraylists to hold all and a subset of the whole list of tracks
    private ArrayList<Track> trackListAll = new ArrayList<>();
    private ArrayList<Track> trackList = new ArrayList<>();
    private String genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  load the list of tracks from the csv file in the resourse folder
        loadTrackList();

        // Set onclick listener for TextView Folk which calls RecyclerActivity
        TextView folk = findViewById(R.id.genre_folk);
        if (folk != null) {
            folk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // sort only folk tracks in to the array tracklist
                    genre = "Folk";
                    sortTracks();
                    startRecyclerActivity();
                }
            });
        }

        // Set onclick listener for TextView Jazz which calls RecyclerActivity
        TextView jazz = findViewById(R.id.genre_jazz);
        if (jazz != null) {
            jazz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // sort only folk tracks in to the array tracklist
                    genre = "Jazz";
                    sortTracks();
                    startRecyclerActivity();
                }
            });
        }
        // Set onclick listener for TextView Country which calls RecyclerActivity
        TextView country = findViewById(R.id.genre_country);
        if (country != null) {
            country.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // sort only folk tracks in to the array tracklist
                    genre = "Country";
                    sortTracks();
                    startRecyclerActivity();
                }
            });
        }

        // Set onclick listener for TextView Jazz which calls RecyclerActivity
        TextView classical = findViewById(R.id.genre_classical);
        if (classical != null) {
            classical.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // sort only folk tracks in to the array tracklist
                    genre = "Classical";
                    sortTracks();
                    startRecyclerActivity();
                }
            });
        }

    }

    // Load the complete list of tracks from file tracklistall.csv in the raw resource folder
    private void loadTrackList() {
        InputStream is = getResources().openRawResource(R.raw.tracklistall);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String line = "";
        // read in each line and catch errors
        try {
            while ((line = reader.readLine()) != null) {
                // Split the line using the comma as a separator).
                String[] lineSplit = line.split(",");
                // Read the data and store it in a Track object.
                Track track = new Track(lineSplit[0], lineSplit[1], lineSplit[2]);
                // add the Track object to the Arraylist trackListAll
                trackListAll.add(track);

            }
        } catch (IOException e1) {
            Log.e("MainActivity", "Error" + line, e1);
            e1.printStackTrace();
        }

    }

    // fill arraylist trackList with just the tracks of the specified genre
    private void sortTracks() {
        trackList.clear();
        for (int index = 0; index < trackListAll.size(); index++) {
            if (trackListAll.get(index).getGenre().equals(genre)) {
                trackList.add(trackListAll.get(index));
            }
        }
    }

    //start the ListActivity and pass the TrackList and Genre
    private void startRecyclerActivity() {
        //add trackList into the bundle to pass to next activity
        //cast the arraylist into Serializable
        Bundle bundle = new Bundle();
        bundle.putSerializable("tracklist", (Serializable) trackList);
        bundle.putString("genre", genre);
        //create the intent, add the bundle and start the activity
        Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}

