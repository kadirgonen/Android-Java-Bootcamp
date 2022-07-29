package com.example.carcollection;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carcollection.databinding.RecyclerRowBinding;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarHolder> {

    @NonNull
    @Override
    public CarAdapter.CarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.CarHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CarHolder extends RecyclerView.ViewHolder {

        private RecyclerRowBinding binding;

        public CarHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
