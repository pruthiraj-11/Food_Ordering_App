package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.foodorderingapp.Adapters.MainAdapter;
import com.example.foodorderingapp.Adapters.OrdersAdapter;
import com.example.foodorderingapp.Models.MainModel;
import com.example.foodorderingapp.Models.OrdersModel;
import com.example.foodorderingapp.databinding.ActivityMainBinding;
import com.example.foodorderingapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<OrdersModel> list=new ArrayList<>();
        DBHelper dbHelper=new DBHelper(this);
        list=dbHelper.getOrders();

//        list.add(new OrdersModel(R.drawable.mushroom,"Mushroom","4","7467"));
//        list.add(new OrdersModel(R.drawable.mushroom,"Mushroom","4","7467"));
//        list.add(new OrdersModel(R.drawable.mushroom,"Mushroom","4","7467"));
//        list.add(new OrdersModel(R.drawable.mushroom,"Mushroom","4","7467"));
//        list.add(new OrdersModel(R.drawable.mushroom,"Mushroom","4","7467"));
//        list.add(new OrdersModel(R.drawable.mushroom,"Mushroom","4","7467"));
//        list.add(new OrdersModel(R.drawable.mushroom,"Mushroom","4","7467"));

        OrdersAdapter ordersAdapter =new OrdersAdapter(list,this);
        binding.orderRecyclerView.setAdapter(ordersAdapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(linearLayoutManager);
    }
}