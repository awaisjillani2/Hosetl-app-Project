package com.pucit.hostelhubupdated;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HostelListAdapter extends RecyclerView.Adapter<HostelListAdapter.MyViewHolder> {

    private List<Hostel> hostelList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView images;
        public TextView name;
        public TextView location;
        public TextView type;

        public MyViewHolder(View view) {
            super(view);
            images = (ImageView) view.findViewById(R.id.imgV_imgs_hostel_list_item);
            name = (TextView) view.findViewById(R.id.tv_name_hostel_list_item);
            location = (TextView) view.findViewById(R.id.tv_location_hostel_list_item);
            type = (TextView) view.findViewById(R.id.tv_type_hostel_list_item);
        }
    }

    public HostelListAdapter(List<Hostel> hostelList) {
        this.hostelList = hostelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hostel_list_item
                        , parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Hostel hostel = hostelList.get(position);

        holder.images.setImageResource(R.drawable.hostel_room);
        holder.name.setText(hostel.getName());
        holder.location.setText(hostel.getLocation());
        holder.type.setText(hostel.getType());
    }

    @Override
    public int getItemCount() {
        return hostelList.size();
    }
}

