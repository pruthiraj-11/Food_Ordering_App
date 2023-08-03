package com.example.foodorderingapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.DetailsActivity;
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

        holder.itemView.setOnClickListener(v -> {
            Intent intent=new Intent(context,DetailsActivity.class);
            intent.putExtra("image",model.getImage());
            intent.putExtra("price",model.getMainPrice());
            intent.putExtra("desc",model.getDescription());
            intent.putExtra("name",model.getName());
            intent.putExtra("type",2);
            context.startActivity(intent);
        });
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
            foodimage= itemView.findViewById(R.id.burgerfood);
            mainName= itemView.findViewById(R.id.foodname);
            price= itemView.findViewById(R.id.foodprice);
            description= itemView.findViewById(R.id.fooddescription);
        }
    }
}