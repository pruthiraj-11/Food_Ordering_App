package com.example.foodorderingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodorderingapp.Adapters.MainAdapter;
import com.example.foodorderingapp.Models.MainModel;
import com.example.foodorderingapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list=new ArrayList<>();

        list.add(new MainModel(R.drawable.mushroom,"Burger","5","Chicken Burger with extra cheese"));
        list.add(new MainModel(R.drawable.por,"Pizza","6","THe offer to download the coupons ends Thursday May 28"));
        list.add(new MainModel(R.drawable.por,"Noodles","7","Tasty chinese noodles"));
        list.add(new MainModel(R.drawable.por,"Pastries","8","Yummy pastries"));
        list.add(new MainModel(R.drawable.mushroom,"Portobello Mushroom","9","Special mushroom"));

        MainAdapter adapter=new MainAdapter(list,this);
        binding.recyclerViewMain.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        binding.recyclerViewMain.setLayoutManager(linearLayoutManager);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menus,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                Intent intent=new Intent(MainActivity.this,OrderActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}