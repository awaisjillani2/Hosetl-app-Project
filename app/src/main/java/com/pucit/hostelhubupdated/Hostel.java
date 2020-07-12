package com.pucit.hostelhubupdated;

import java.io.Serializable;
import java.util.ArrayList;

public class Hostel implements Serializable {

    private int hID;
    private int fID;
    private int rID;
    private String bIDs;        //A string containing comma separated bed ids to fetch data about particular hostel
    private int type;           //A variable to hold type of hostel (0->Female and 1->Male)
    private String name;
    private String location;
    private int totalRooms;
    private int availableRooms;
    private boolean wifi;
    private boolean ac;
    private boolean electricity;
    private boolean gas;
    private boolean mess;
    private boolean attachedBaths;
    private String images;          //A string containing comma separated image paths for particular hostel
    private ArrayList<String> beds;
    private ArrayList<Double> bedRent;
    private double ratings;
    private ArrayList<String> feedbacks;

    public Hostel(){}

    public Hostel(int hID,int fId,int rID,String bIds,int type,String name,String loc,int tRooms,
                  int aRooms,boolean wifi,boolean ac,boolean electricity,boolean gas,
                  boolean mess,boolean aBaths,String imgs)
    {
           this.hID = hID;
           this.fID = fId;
           this.rID = rID;
           this.bIDs = bIds;
           this.type = type;
           this.name = name;
           this.location = loc;
           this.totalRooms = tRooms;
           this.availableRooms = aRooms;
           this.wifi = wifi;
           this.ac = ac;
           this.electricity = electricity;
           this.gas = gas;
           this.mess = mess;
           this.attachedBaths = aBaths;
           this.images = imgs;

           this.beds = new ArrayList<>();
           this.beds.add(0,"Single bed");
           this.beds.add(1,"Double bed");

           this.bedRent = new ArrayList<>();
           this.bedRent.add(0,3000.0);
           this.bedRent.add(1,5000.0);

           this.ratings = 4.5;

           this.feedbacks = new ArrayList<>();
           this.feedbacks.add(0,"Good in every aspect");
           this.feedbacks.add(1,"Good but mess quality is not satisfying");

           //Feedbacks are not handeled yet

    }

    public int getHId(){
        return this.hID;
    }

    public String getName(){
        return this.name;
    }

    public String getLocation(){
        return this.location;
    }

    public String getType(){
        if (this.type == 0)
            return "Female";
        return "Male";
    }

    public String getImages(){
        return images;
    }

    public int getTotalRooms() {
        return this.totalRooms;
    }

    public int getAvailableRooms() {
        return this.availableRooms;
    }

    public boolean getWifi() {
        return this.wifi;
    }

    public boolean getAC() {
        return this.ac;
    }

    public boolean getGas() {
        return this.gas;
    }

    public boolean getElectricity() {
        return this.electricity;
    }

    public boolean getMess() {
        return this.mess;
    }

    public boolean getAttachedBaths() {
        return this.attachedBaths;
    }

    public ArrayList<String> getBeds(){
        return this.beds;
    }

    public ArrayList<Double> getBedRent(){
        return this.bedRent;
    }

    public Double getRatings(){
        return this.ratings;
    }

}
