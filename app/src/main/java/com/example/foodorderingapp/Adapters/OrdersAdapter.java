package com.example.foodorderingapp.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.DBHelper;
import com.example.foodorderingapp.DetailsActivity;
import com.example.foodorderingapp.MainActivity;
import com.example.foodorderingapp.Models.OrdersModel;
import com.example.foodorderingapp.OrderActivity;
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
        holder.orderNumber.setText(model.getOrderNumber());
        holder.price.setText(model.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,DetailsActivity.class);
                intent.putExtra("id",model.getOrderNumber());
                intent.putExtra("image",model.getOrderImage());
                intent.putExtra("price",model.getPrice());
                intent.putExtra("name",model.getSoldItemName());
                intent.putExtra("type",2);
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Item");
                builder.setMessage("Are you sure want to delete this item?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DBHelper helper = new DBHelper(context);
                        if (helper.deleteOrder(model.getOrderNumber()) > 0) {
                            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
                return false;
            }
        });
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
            orderimage=itemView.findViewById(R.id.orderimage);
            soldItemName=itemView.findViewById(R.id.orderitemName);
            orderNumber=itemView.findViewById(R.id.orderNumber);
            price= itemView.findViewById(R.id.orderPrice);
        }
    }
}
