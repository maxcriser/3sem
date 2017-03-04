package com.maxcriser.emergencycalls.model;

public class Em {

    private final String title;
    private final String description;
    private final String phoneNumber;
    private final String smsNumber;
    private String imageUrl;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSmsNumber() {
        return smsNumber;
    }

    public Em(final String pTitle, final String pDescription, final String pPhoneNumber, final String pSmsNumber) {
        title = pTitle;
        description = pDescription;
        phoneNumber = pPhoneNumber;
        smsNumber = pSmsNumber;
//        imageUrl = pImageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
