package com.pucit.hostelhubupdated.Models;

public class ModelForViewHostel {

    private int imageResource;
    private String title;
    private String subTitle;

    public ModelForViewHostel(int imageResource, String title, String subTitle) {
        this.imageResource = imageResource;
        this.title = title;
        this.subTitle = subTitle;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }
}
