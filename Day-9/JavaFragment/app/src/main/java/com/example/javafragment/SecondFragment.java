package com.example.javafragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.
                inflate(R.layout.fragment_second, container, false);

        TextView textView = viewGroup.findViewById(R.id.textView2);
        textView.setText("2nd Fragment Example");

        return viewGroup;
    }
}