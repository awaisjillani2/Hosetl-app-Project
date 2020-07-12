package com.pucit.hostelhubupdated;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class AddHostel extends AppCompatActivity {
    public static final int PICK_IMAGE = 3;

    private Button btn_addHostel;

    Button uploadImages,moreOptions;
    EditText hostelName,location,bedRent,totalNoOfRooms,availableRooms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hostel);


        hostelName=findViewById(R.id.et_hostel_name);
        location=findViewById(R.id.et_location);
        bedRent=findViewById(R.id.et_beds_rent);
        totalNoOfRooms=findViewById(R.id.et_total_no_of_rooms);
        availableRooms=findViewById(R.id.et_available_rooms);
        btn_addHostel= findViewById(R.id.btn_add_Hostel_rl_addHOstel_activity);

        btn_addHostel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddHostel.this,HostelManagerHomeActivity.class);
                startActivity(i);
            }
        });

        moreOptions=findViewById(R.id.more_options_rl_addHostel);
        moreOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AddHostel.this, MoreOptions.class);
                startActivity(i);
            }
        });
        uploadImages=findViewById(R.id.btn_upload_images);

        uploadImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }
        });

    //input validations
        hostelName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hostelName.getText().toString().equals("")){
                    hostelName.setError("Invalid Hostel Name");
                }
                else
                {
                    hostelName.setError(null);
                }
            }
        });



        location.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(location.getText().toString().equals("")){
                    location.setError("Invalid Location");
                }
                else
                {
                    hostelName.setError(null);
                }
            }
        });

        bedRent.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(bedRent.getText().toString().equals("") ){
                    bedRent.setError("Invalid Bed Rent");
                }
                else
                {
                    hostelName.setError(null);
                }
            }
        });

        totalNoOfRooms.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(totalNoOfRooms.getText().toString().equals("")){
                    totalNoOfRooms.setError("Invalid No of Rooms");
                }
                else
                {
                    totalNoOfRooms.setError(null);
                }
            }
        });



        availableRooms.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(availableRooms.equals("")){
                    availableRooms.setError("Invalid Input");
                }
                else{
                    availableRooms.setError(null);
                }
            }
        });





    }


}
