package com.example.stockexchangeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.stockexchangeapp.StockAPIs.JsonPlaceHolderApi;
import com.example.stockexchangeapp.StockAPIs.TickerSearch;
import com.example.stockexchangeapp.databinding.FragmentFirstBinding;

import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.Retrofit;
import retrofit2.http.Query;

public class FirstFragment extends Fragment {

    final String BASEURL = "https://finnhub.io/api/v1/";

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        GetTickerSearch();

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
//TODO fix this BS
    private void GetTickerSearch(){
/*
        Call<TickerSearch> call jsonPlaceHolderApi.GetTickerSearch( count,  resultslist );
        //Call<List<Post>> call = jsonPlaceHolderApi.getPosts(parameters);
        call.enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
 */
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