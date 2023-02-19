package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

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
        binding= ActivityOrderBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        ArrayList<OrdersModel> list=new ArrayList<>();
        list.add(new OrdersModel(R.drawable.mushroom,"Mushroom","4","7467"));
        list.add(new OrdersModel(R.drawable.mushroom,"Mushroom","4","7467"));
        list.add(new OrdersModel(R.drawable.mushroom,"Mushroom","4","7467"));
        list.add(new OrdersModel(R.drawable.mushroom,"Mushroom","4","7467"));
        list.add(new OrdersModel(R.drawable.mushroom,"Mushroom","4","7467"));
        list.add(new OrdersModel(R.drawable.mushroom,"Mushroom","4","7467"));
        list.add(new OrdersModel(R.drawable.mushroom,"Mushroom","4","7467"));

        OrdersAdapter ordersAdapter =new OrdersAdapter(list,this);
        binding.orderRecyclerView.setAdapter(ordersAdapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(linearLayoutManager);
    }
}