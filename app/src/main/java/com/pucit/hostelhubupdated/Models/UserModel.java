package com.pucit.hostelhubupdated.Models;

import android.content.Context;
import java.io.Serializable;

public class UserModel implements Serializable {

    public Context context;  //Additional attribute to work with async task and to display something!
    public String role;
    public String username;
    public String login;
    public String password;
    public String cnic;
    public String phone;
    public String email;
    public int houseNo;
    public int streetNo;
    public int postalCode;
    public String locality;
    public String city;

}
