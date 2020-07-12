package com.pucit.hostelhubupdated;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    Context application;
    List<Feedback> data;

    public MyAdapter(Context application, List<Feedback> data) {
        this.application = application;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_feedbacklist_view,parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Feedback i = data.get(position);
        holder.name.setText(i.getName());
        holder.ratin.setText(i.getRating());
        holder.feed.setText(i.getFeedback());
        holder.feedbk=i;
    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView ratin;
        TextView feed;
        public Feedback feedbk;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.rl_tv_name_flist);
            ratin = itemView.findViewById(R.id.rl_tv_ratings_flist);
            feed = itemView.findViewById(R.id.rl_tv_feedback_flist);

        }
    }
}
