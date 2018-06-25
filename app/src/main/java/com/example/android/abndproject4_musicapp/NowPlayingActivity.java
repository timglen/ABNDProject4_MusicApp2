package com.example.android.abndproject4_musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * This activity displays the informatiton for selected track
 * The functionality to play the track would be placed here but
 * is not yet included
 */

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        // get the bundle and extract the track info
        Bundle bundle = getIntent().getExtras();
        String genre = "Genre: " + bundle.getString("genre");
        String title = "Title: " + bundle.getString("title");
        String artist ="Artist: " + bundle.getString("artist");

        // update the textviews with the track info
        ((TextView) findViewById(R.id.genre_text_view)).setText(genre);
        ((TextView) findViewById(R.id.title_text_view)).setText(title);
        ((TextView) findViewById(R.id.artist_text_view)).setText(artist);

    }

}
