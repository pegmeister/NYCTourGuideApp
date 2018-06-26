package com.example.pegmeister.nyctourguideapp;

public class Item {
    // initiate private variables
    private String itemTitle;
    private String itemLocation;
    private int itemImageResourceId;
    private String itemInformation;

    //create a new Item constructor to take 4 params
    public Item(String title, String location, int imageResourceID, String infomation) {
        itemTitle = title;
        itemLocation = location;
        itemImageResourceId = imageResourceID;
        itemInformation = infomation;

    }

    // get item name
    public String getItemTitle() {
        return itemTitle;
    }

    // get item location
    public String getItemLocation() {
        return itemLocation;
    }

    // get item imageResource
    public int getItemImageResourceId() {
        return itemImageResourceId;
    }

    // get item information
    public String getInformation() {
        return itemInformation;
    }

}
