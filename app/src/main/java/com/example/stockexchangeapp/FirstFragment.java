package com.example.stockexchangeapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.stockexchangeapp.StockAPIs.CompanyProfile2;
import com.example.stockexchangeapp.StockAPIs.JsonPlaceHolderApi;
import com.example.stockexchangeapp.StockAPIs.TickerSearch;
import com.example.stockexchangeapp.StockAPIs.URLbuilder;
import com.example.stockexchangeapp.databinding.FragmentFirstBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.Retrofit;

public class FirstFragment extends Fragment {




    private FragmentFirstBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {




        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }




}