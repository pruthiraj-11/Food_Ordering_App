package com.example.foodorderingapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.Models.MainModel;
import com.example.foodorderingapp.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder> {

    ArrayList<MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_food,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        final MainModel model=list.get(position);
        holder.foodimage.setImageResource(model.getImage());
        holder.mainName.setText(model.getName());
        holder.price.setText(model.getMainPrice());
        holder.description.setText(model.getDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder{

        ImageView foodimage;
        TextView mainName,price,description;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            if (foodimage != null) {
                foodimage= foodimage.findViewById(R.id.burgerfood);
            }
            if (mainName != null) {
                mainName=mainName.findViewById(R.id.foodname);
            }
            if (price != null) {
                price= price.findViewById(R.id.foodprice);
            }
            if (description != null) {
                description=description.findViewById(R.id.fooddescription);
            }
        }
    }
}
