package com.example.javafragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.
                inflate(R.layout.fragment_first, container, false);

        TextView textView = viewGroup.findViewById(R.id.textView);
        textView.setText("1st Fragment Example");

        return viewGroup;
    }
}