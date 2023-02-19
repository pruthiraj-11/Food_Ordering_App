package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.RecoverySystem;

import com.example.foodorderingapp.Adapters.MainAdapter;
import com.example.foodorderingapp.Models.MainModel;
import com.example.foodorderingapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        ArrayList<MainModel> list=new ArrayList<>();
        list.add(new MainModel(R.drawable.burger,"Burger","5","Chicken Burger with extra cheese"));
        list.add(new MainModel(R.drawable.pizza,"Pizza","6","THe offer to download the coupons ends Thursday May 28"));
        list.add(new MainModel(R.drawable.por,"Noodles","7","Tasty chinese noodles"));
        list.add(new MainModel(R.drawable.boc,"Pastries","8","Yummy pastries"));
        list.add(new MainModel(R.drawable.mushroom,"Portobello Mushroom","9","Special mushroom"));

        MainAdapter mainAdapter=new MainAdapter(list,this);
        binding.recyclerViewMain.setAdapter(mainAdapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        binding.recyclerViewMain.setLayoutManager(linearLayoutManager);

    }
}