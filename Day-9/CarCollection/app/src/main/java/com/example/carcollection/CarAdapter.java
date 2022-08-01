package com.example.carcollection;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carcollection.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarHolder> {

    ArrayList<Car> carArrayList;

    public CarAdapter(ArrayList<Car> carArrayList) {
        this.carArrayList = carArrayList;
    }

    @NonNull
    @Override
    public CarAdapter.CarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding binding =
                RecyclerRowBinding.inflate
                        (LayoutInflater.from(parent.getContext()),parent,false);
        return new CarHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.CarHolder holder, int position) {
        Car car =  carArrayList.get(position);
        holder.binding.recylertextView.setText(car.name);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
                    intent.putExtra("carId", car.id);
                    intent.putExtra("info", "old");
                    holder.itemView.getContext().startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return carArrayList.size();
    }

    public class CarHolder extends RecyclerView.ViewHolder {

        private RecyclerRowBinding binding;

        public CarHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
