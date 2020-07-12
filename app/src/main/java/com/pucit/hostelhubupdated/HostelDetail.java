package com.pucit.hostelhubupdated;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HostelDetail extends AppCompatActivity {

    private Hostel hostel;
    private Button btnLogin;

    private ImageView imgV;
    private TextView tv_name;
    private TextView tv_location;
    private TextView tv_type;
    private TextView tv_tRooms;
    private TextView tv_aRooms;
    private TextView tv_mess;
    private TextView tv_gas;
    private TextView tv_electricity;
    private TextView tv_wifi;
    private TextView tv_ac;
    private TextView tv_aBaths;
    private TextView tv_rating;
    private TableLayout tbl_beds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostel_detail);

        Bundle b = getIntent().getExtras();
        hostel = (Hostel)b.getSerializable("hostel");

        findViewsOfHostelDetailActivity();
        assignText();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HostelSeekerLogin.class);
                startActivity(i);
            }
        });
    }

    public void assignText(){

        imgV.setImageResource(R.drawable.hostel_room);
        tv_name.setText("Name: " + hostel.getName());
        tv_location.setText("Location: " + hostel.getLocation());
        tv_type.setText("Type: " + hostel.getType());
        tv_tRooms.setText("Total Rooms: " + hostel.getTotalRooms());
        tv_aRooms.setText("Available Rooms: " + hostel.getAvailableRooms());
        tv_rating.setText(hostel.getRatings().toString());


        if (hostel.getMess() == true)
            tv_mess.setText("Yes");
        else
            tv_mess.setText("No");

        if (hostel.getGas() == true)
            tv_gas.setText("Yes");
        else
            tv_gas.setText("No");

        if (hostel.getElectricity() == true)
            tv_electricity.setText("Yes");
        else
            tv_electricity.setText("No");

        if (hostel.getWifi() == true)
            tv_wifi.setText("Yes");
        else
            tv_wifi.setText("No");

        if (hostel.getAC() == true)
            tv_ac.setText("Yes");
        else
            tv_ac.setText("No");

        if (hostel.getAttachedBaths() == true)
            tv_aBaths.setText("Yes");
        else
            tv_aBaths.setText("No");



        ArrayList<String> beds = hostel.getBeds();
        ArrayList<Double> bedRent = hostel.getBedRent();
        int count = beds.size();


        int k = 0;
        for (int i = 0; i<count;i++){
            TableRow row = new TableRow(getApplicationContext());
            TableRow row1 = new TableRow(getApplicationContext());

            TextView bed = new TextView(this);
            TextView rent = new TextView(this);

            bed.setText("Bed Type: " + beds.get(i));
            bed.setPadding(8,0,6,0);

            rent.setText("Rent: " + bedRent.get(i).toString());
            rent.setPadding(8,0,6,0);

            row.addView(bed);
            tbl_beds.addView(row,k);
            row1.addView(rent);
            tbl_beds.addView(row1,k+1);

            k = k + 2;
        }


    }

    public void findViewsOfHostelDetailActivity(){

        imgV = (ImageView) findViewById(R.id.imgV_activity_hostel_detail);
        tv_name = (TextView) findViewById(R.id.tv_name_activity_hostel_detail) ;
        tv_location = (TextView) findViewById(R.id.tv_location_activity_hostel_detail) ;
        tv_type = (TextView) findViewById(R.id.tv_type_activity_hostel_detail) ;
        tv_tRooms = (TextView) findViewById(R.id.tv_tRooms_activity_hostel_detail) ;
        tv_aRooms = (TextView) findViewById(R.id.tv_aRooms_activity_hostel_detail) ;
        tv_mess = (TextView) findViewById(R.id.tv_mess_activity_hostel_detail) ;
        tv_gas = (TextView) findViewById(R.id.tv_gas_activity_hostel_detail) ;
        tv_electricity = (TextView) findViewById(R.id.tv_electricity_activity_hostel_detail) ;
        tv_wifi = (TextView) findViewById(R.id.tv_wifi_activity_hostel_detail) ;
        tv_ac = (TextView) findViewById(R.id.tv_ac_activity_hostel_detail) ;
        tv_aBaths = (TextView) findViewById(R.id.tv_aBaths_activity_hostel_detail) ;
        tv_rating = (TextView) findViewById(R.id.tv_ratings_activity_hostel_detail) ;
        tbl_beds = (TableLayout) findViewById(R.id.tbl_bed_activity_hostel_detail);

        btnLogin = (Button) findViewById(R.id.btn_request_reg_activity_hostel_detail);
    }


}

