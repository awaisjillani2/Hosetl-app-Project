package com.pucit.hostelhubupdated;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pucit.hostelhubupdated.Models.ModelForViewHostel;

import java.util.List;

public class AdapterForViewHostels extends RecyclerView.Adapter<AdapterForViewHostels.Viewholder> {


    private List<ModelForViewHostel> modelClassList;

    public AdapterForViewHostels(List<ModelForViewHostel> modelClassList) {
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items_view_hostels_layout,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        int resource=modelClassList.get(position).getImageResource();
        String title=modelClassList.get(position).getTitle();
        String subtitle=modelClassList.get(position).getSubTitle();
        holder.setData(resource,title,subtitle);
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{


        private ImageView imageOfHostel;
        private TextView titleOfHostel;
        private TextView subtitleOfHostel;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imageOfHostel=itemView.findViewById(R.id.iv_in_recycler_view);
            titleOfHostel=itemView.findViewById(R.id.tv_title_view_hostel);
            subtitleOfHostel=itemView.findViewById(R.id.tv_subtitle_view_hostel);

        }

        private void setData(int resource,String titleText,String subtitleText){
            imageOfHostel.setImageResource(resource);
            titleOfHostel.setText(titleText);
            subtitleOfHostel.setText(subtitleText);


        }

    }

}
