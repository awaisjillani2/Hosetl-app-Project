package com.pucit.hostelhubupdated;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FeedbackList extends AppCompatActivity {
    List<Feedback> data;
    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_list);


        data = Feedback.getData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_flist);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        adapter = new MyAdapter(getApplicationContext(), data);

        recyclerView.setAdapter(adapter);

        /*
        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Hostel hostel = data.get(position);

                //Toast here is just for understanding of flow
                //We'll send intent here to hostel details activity according to the data tapped
                Toast.makeText(getApplicationContext(), hostel.getName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

         */
    }
}
