package com.example.android.abndproject4_musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private String genre;   // currently displayed genre
    private ArrayList<Track> trackList;  // ArrayList of tracks

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        // get the bundle and extract the tracklist and genre
        Bundle bundle = getIntent().getExtras();
        if (null != bundle) {
            genre = bundle.getString("genre");
            trackList = (ArrayList<Track>) bundle.getSerializable("tracklist");
        }
        // set the app bar title
        setTitle("Popular " + genre + " Songs");

        // get the recycler view
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);

        // this setting improves performance if changes in content
        // do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // add styling
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        // define an adapter
        RecyclerView.Adapter mAdapter = new MyAdapter(trackList, this);
        recyclerView.setAdapter(mAdapter);
    }
}
