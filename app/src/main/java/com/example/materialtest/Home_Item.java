package com.example.materialtest;

public class Home_Item {

    private String name;

    private int imageId;

    public Home_Item(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

}