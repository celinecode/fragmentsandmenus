package com.example.miscontactos;

public class Pet {
    private String name;
    private int rating;
    private int photo;


    public Pet(String name, int rating, int photo) {
        this.name = name;
        this.rating = rating;
        this.photo = photo;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating() {
        this.rating++;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}

