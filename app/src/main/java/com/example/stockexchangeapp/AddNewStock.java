package com.example.stockexchangeapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddNewStock#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddNewStock extends Fragment {



    public AddNewStock() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_new_stock, container, false);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}