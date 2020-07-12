package com.pucit.hostelhubupdated;

import java.util.ArrayList;
import java.util.List;

public class Feedback{
    private String name;
    private String rating;
    private String feedback;

    public Feedback() {
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void setRating(String r) {
        this.rating = r;
    }

    public String getRating() {
        return rating;
    }

    public void setFeedback(String f) {
        this.feedback = f;
    }

    public String getFeedback() {
        return feedback;
    }

    Feedback(String n, String r, String f) {
        name = n;
        rating = r;
        feedback = f;
    }


    public static List<Feedback> getData() {
        List<Feedback> data = new ArrayList<>();
        Feedback i = new Feedback("name1","rating1","feedback1");
        data.add(i);

        i = new Feedback("name2","rating2","feedback2");
        data.add(i);

        i = new Feedback("name3","rating3","feedback3");
        data.add(i);

        i = new Feedback("name4","rating4","feedback4");
        data.add(i);

        i = new Feedback("name5","rating5","feedback5");
        data.add(i);

        i = new Feedback("name6","rating6","feedback6");
        data.add(i);

        i = new Feedback("name7","rating7","feedback7");
        data.add(i);

        i = new Feedback("name8","rating8","feedback8");
        data.add(i);

        i = new Feedback("name9","rating9","feedback9");
        data.add(i);

        i = new Feedback("name10","rating10","feedback10");
        data.add(i);

        i = new Feedback("name11","rating11","feedback11");
        data.add(i);

        i = new Feedback("name12","rating12","feedback12");
        data.add(i);

        i = new Feedback("name13","rating13","feedback13");
        data.add(i);

        i = new Feedback("name14","rating14","feedback14");
        data.add(i);

        i = new Feedback("name15","rating15","feedback15");
        data.add(i);

        i = new Feedback("name16","rating16","feedback16");
        data.add(i);


        return data;
    }
}
