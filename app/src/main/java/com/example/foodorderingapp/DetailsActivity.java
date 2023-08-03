package com.example.foodorderingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderingapp.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DBHelper helper = new DBHelper(this);

        if(getIntent().getIntExtra("type",0)==2) {
            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("desc");

            binding.detailImage.setImageResource(image);
            binding.pricecount.setText(String.format("%d", price));
            binding.orderfoodname.setText(name);
            binding.detaileDescriptions.setText(description);

            binding.orderbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = helper.insertOrder(
                            binding.usernames.getText().toString(),
                            binding.userphone.getText().toString(),
                            price,
                            image,
                            description,
                            name
                    );
                    if (isInserted) {
                        Toast.makeText(DetailsActivity.this, "Data success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailsActivity.this, "Data error", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            int id=getIntent().getIntExtra("id",0);
            Cursor cursor=helper.getOrderById(id);
            int image=cursor.getInt(4);
            binding.detailImage.setImageResource(image);
            binding.pricecount.setText(String.format("%d",cursor.getInt(3)));
            binding.orderfoodname.setText(cursor.getString(6));
            binding.detaileDescriptions.setText(cursor.getString(5));
            binding.usernames.setText(cursor.getString(1));
            binding.userphone.setText(cursor.getString(2));
            binding.orderbtn.setText("Update Now");
            binding.orderbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  boolean status= helper.updateOrder(binding.usernames.getText().toString(),binding.userphone.getText().toString(),
                           Integer.parseInt(binding.pricecount.getText().toString()),image,binding.detaileDescriptions.getText().toString(),binding.orderfoodname.getText().toString(),id);
                    if (status) {
                        Toast.makeText(DetailsActivity.this, "Updated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailsActivity.this, "Update error", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menus,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                Intent intent=new Intent(DetailsActivity.this,OrderActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}