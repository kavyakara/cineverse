package com.example.cineverse;

public class Movie {

    private String name;
    private String rating;
    private int image;

    public Movie(String name, String rating, int image) {
        this.name = name;
        this.rating = rating;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public int getImage() {
        return image;
    }
}