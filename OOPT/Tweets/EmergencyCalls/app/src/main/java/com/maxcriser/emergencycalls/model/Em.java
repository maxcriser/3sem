package com.maxcriser.emergencycalls.model;

public class Em {

    private String title;
    private String description;
    private String number;
    private String imageUrl;

    public Em(String pTitle, String pDescription, String pNumber) {
        title = pTitle;
        description = pDescription;
        number = pNumber;
//        imageUrl = pImageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getNumber() {
        return number;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
