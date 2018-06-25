package com.example.android.abndproject4_musicapp;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private ArrayList<Track> mTrackList;
    private Activity mActivityContext;
    private int mPosition;

    // MyAdapter constructor
    public MyAdapter(ArrayList<Track> trackList, Activity activityContext) {
        mTrackList = trackList;
        mActivityContext = activityContext;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        // References to the views for each data item
        // each data item is just a string
        public TextView txtTitle;
        public TextView txtArtist;
        public View homeView;

        // ViewHolder constructor
        public ViewHolder(View v) {
            super(v);
            txtTitle = v.findViewById(R.id.title_text_view);
            txtArtist = v.findViewById(R.id.artist_text_view);
            homeView = v;
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        Track track = mTrackList.get(position);
        // - replace the contents of the view with that element
        holder.txtTitle.setText(track.getTitle());
        holder.txtArtist.setText(track.getArtist());
        // set onclickListener for Viewholder item - responds to click anywhere in the item
        holder.homeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPosition =holder.getAdapterPosition();
                playTrack();
            }
        });
    }

    // Return the size of the dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mTrackList.size();
    }

    private void playTrack() {
        // bundle information for new activity
        Bundle bundle = new Bundle();
        bundle.putString("title", mTrackList.get(mPosition).getTitle());
        bundle.putString("artist", mTrackList.get(mPosition).getArtist());
        bundle.putString("genre", mTrackList.get(mPosition).getGenre());
        // Create the intent, add the bundle and start the activity
        Intent intent = new Intent(mActivityContext, NowPlayingActivity.class);
        intent.putExtras(bundle);
        mActivityContext.startActivity(intent);
    }
}
