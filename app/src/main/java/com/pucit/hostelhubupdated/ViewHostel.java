package com.pucit.hostelhubupdated;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pucit.hostelhubupdated.Models.ModelForViewHostel;

import java.util.ArrayList;
import java.util.List;

public class ViewHostel extends AppCompatActivity {
    public TextView edit,delete;

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_hostel);


        recyclerView=findViewById(R.id.recycler_view_view_hostels);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<ModelForViewHostel> modelClassList=new ArrayList<>();
        modelClassList.add(new ModelForViewHostel(R.drawable.ic_hostel_24px,"Hostel Name1","Hostel Description1"));
        modelClassList.add(new ModelForViewHostel(R.drawable.ic_hostel_24px,"Hostel Name2","Hostel Description2"));
        modelClassList.add(new ModelForViewHostel(R.drawable.ic_hostel_24px,"Hostel Name3","Hostel Description3"));
        modelClassList.add(new ModelForViewHostel(R.drawable.ic_hostel_24px,"Hostel Name4","Hostel Description4"));
        modelClassList.add(new ModelForViewHostel(R.drawable.ic_hostel_24px,"Hostel Name5","Hostel Description5"));
        modelClassList.add(new ModelForViewHostel(R.drawable.ic_hostel_24px,"Hostel Name6","Hostel Description6"));
        modelClassList.add(new ModelForViewHostel(R.drawable.ic_hostel_24px,"Hostel Name7","Hostel Description7"));
        modelClassList.add(new ModelForViewHostel(R.drawable.ic_hostel_24px,"Hostel Name8","Hostel Description8"));
        modelClassList.add(new ModelForViewHostel(R.drawable.ic_hostel_24px,"Hostel Name9","Hostel Description9"));


        AdapterForViewHostels adapter=new AdapterForViewHostels(modelClassList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();






    }
}
