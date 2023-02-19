package com.example.foodorderingapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.Models.OrdersModel;
import com.example.foodorderingapp.R;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewholder>{

    ArrayList<OrdersModel> list;
    Context context;


    public OrdersAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }



    @NonNull
    @Override
    public OrdersAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersAdapter.viewholder holder, int position) {

        final OrdersModel model=list.get(position);
        holder.orderimage.setImageResource(model.getOrderImage());
        holder.soldItemName.setText(model.getSoldItemName());
        holder.orderNumber.setText(model.getSoldItemName());
        holder.price.setText(model.getPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder{

        ImageView orderimage;
        TextView soldItemName,price,orderNumber;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            if(orderimage!=null){
                orderimage=orderimage.findViewById(R.id.orderimage);
            }
            if (soldItemName != null) {
                soldItemName=soldItemName.findViewById(R.id.orderitemName);
            }
            if (orderNumber != null) {
                orderNumber=orderNumber.findViewById(R.id.orderNumber);
            }
            if (price != null) {
                price= price.findViewById(R.id.orderPrice);
            }
        }
    }
}
