package com.pucit.hostelhubupdated;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HostelManagerHomeActivity extends AppCompatActivity {
    public Button viewHostels;
    public Button addHostel;
    public Button editProfile;
    public Button logout;
    public Button viewratingsfeedback;
    public Button viewnotification;
    public Button communicate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostel_manager_home);
        viewHostels=findViewById(R.id.btn_view_hostel_ll_hostel_manager);
        addHostel=findViewById(R.id.btn_add_Hostel_ll_hostel_manager_home_activity);
        editProfile=findViewById(R.id.btn_Edit_hostel_ll_hostel_manager);
        logout=findViewById(R.id.btn_logout);
        viewratingsfeedback=findViewById(R.id.btn_view_ratings_feedbacks_ll_hostel_manager);
        viewnotification=findViewById(R.id.btn_view_notification_ll_hostel_manager);
        communicate=findViewById(R.id.btn_communicate_ll_hostel_manager);



        viewHostels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(), ViewHostel.class);
                startActivity(i);
            }
        });
        addHostel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HostelManagerHomeActivity.this, AddHostel.class);
                startActivity(i);
            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HostelManagerHomeActivity.this, EditManagerProfileActivity.class);
                startActivity(i);
            }
        });

        viewnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HostelManagerHomeActivity.this, NotificationList.class);
                startActivity(i);
            }
        });

        viewratingsfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HostelManagerHomeActivity.this,FeedbackList.class);
                startActivity(i);
            }
        });

        communicate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HostelManagerHomeActivity.this, NotificationList.class);
                startActivity(i);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HostelManagerHomeActivity.this, HostelSeekerLogin.class);
                startActivity(i);
            }
        });



    }
}
