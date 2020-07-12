package com.pucit.hostelhubupdated.Database;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.pucit.hostelhubupdated.Models.UserModel;

import java.util.HashMap;
import java.util.Map;


public class Database {

    private static FirebaseDatabase database;
    private static DatabaseReference reference;


    public static DatabaseReference getDbReference(){
        if (database == null){
            database = FirebaseDatabase.getInstance();
            reference = database.getReference();
            return reference;
        }
        else
            return reference;
    }

    public static Query isAlreadyAUser(String cnic){

        return getDbReference().child("Users").orderByChild("CNIC").equalTo(cnic);
    }


    public static void insertUser(UserModel obj){

        String key = getDbReference().child("Users").push().getKey();
        Map<String,Object> map= new HashMap<>();

        map.put("Role",obj.role);
        map.put("Login",obj.login);
        map.put("Name",obj.username);
        map.put("Password",obj.password);
        map.put("CNIC",obj.cnic);
        map.put("Phone",obj.phone);
        map.put("Email",obj.email);
        map.put("HouseNo",obj.houseNo);
        map.put("StreetNo",obj.streetNo);
        map.put("PostalCode",obj.postalCode);
        map.put("Locality",obj.locality);
        map.put("City",obj.city);

        getDbReference().child("Users").child(key).setValue(map);

    }

    public static UserModel updateUserInfo(String cnic){

        Log.d("updateUser","bye ");
        Query q = getDbReference().child("Users").orderByChild("CNIC").equalTo(cnic);
        q.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("updateUser", "onDataChange");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("updateUser", "onCancelled");
            }
        });
        return null;

    }


}


