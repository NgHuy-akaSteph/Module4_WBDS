package com.dev.demoapp.entities;

import org.springframework.web.multipart.MultipartFile;

public class Song {
    private String title;
    private String artist;
    private String album;
    private MultipartFile file;

    public Song() {
    }

    public Song(String title, String artist, String album, MultipartFile file) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.file = file;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
