package com.example.android.abndproject4_musicapp;

import java.io.Serializable;

/**
 * This class defines the music Track object which contains three strings
 * Ultimately it would also hold the path to the music file
 */
public class Track implements Serializable {
    private String title;
    private String artist;
    private String genre;

    // main constructor
    public Track(String genre, String title, String artist) {
        this.artist = artist;
        this.title = title;
        this.genre = genre;
    }

    //getters
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

}

