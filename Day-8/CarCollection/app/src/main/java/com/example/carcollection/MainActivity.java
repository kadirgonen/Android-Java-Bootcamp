package com.example.carcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.carcollection.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    ArrayList<Car> carList;
    CarAdapter carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        carList = new ArrayList<Car>();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        carAdapter = new CarAdapter(carList);
        binding.recyclerView.setAdapter(carAdapter);
        getData();

    }

    private void getData() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflater
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_car,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_car_item){
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("info", "new");
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}