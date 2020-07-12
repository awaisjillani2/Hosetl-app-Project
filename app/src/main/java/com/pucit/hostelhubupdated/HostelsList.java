package com.pucit.hostelhubupdated;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HostelsList extends AppCompatActivity {

    private List<Hostel> hostelList = new ArrayList<>();
    private RecyclerView hostelListRV;
    private HostelListAdapter hLAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostels_list);

        hostelListRV = (RecyclerView) findViewById(R.id.rv_hostel_list_activity_main);

        getData();

        hLAdapter = new HostelListAdapter(hostelList);
        hostelListRV.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        hostelListRV.setLayoutManager(mLayoutManager);

        // adding inbuilt divider line
        hostelListRV.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        hostelListRV.setItemAnimator(new DefaultItemAnimator());

        hostelListRV.setAdapter(hLAdapter);

        // row click listener
        hostelListRV.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), hostelListRV, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Hostel hostel = hostelList.get(position);
                Intent i = new Intent(getApplication(), HostelDetail.class);
                i.putExtra("hostel", hostel);
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }


    public  void getData() { ;

        Hostel i = new Hostel(1,1,1,"1,2",0,"YMCA","Johar Town",
                20,5,true,false,true,true,true,
                false,"hostelRoom.jpg");
        hostelList.add(i);

        i = new Hostel(2,2,2,"1",1,"Lodges","Wapda Town",
                20,15,true,true,true,true,true,
                true,"hostel_room.jpg");
        hostelList.add(i);

        i = new Hostel(3,3,3,"2",1,"Bukhari Hostel","Johar Town",
                20,5,true,false,true,true,true,
                false,"hostel_room.jpg");
        hostelList.add(i);

        i = new Hostel(4,4,4,"1,2",1,"Al-Hameed Hostel","Johar Town",
                20,5,true,false,true,true,true,
                false,"hostel_room.jpg");
        hostelList.add(i);

        i = new Hostel(5,5,5,"1,2",0,"Al-Huda","Anarkali Bazar",
                20,5,false,true,true,true,false,
                false,"hostel_room.jpg");
        hostelList.add(i);

        i = new Hostel(6,6,6,"1,2",1,"Khalid Hostel","Lower Mall",
                20,5,false,false,true,false,false,
                true,"hostel_room.jpg");
        hostelList.add(i);

    }

}

