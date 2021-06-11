package com.example.stockexchangeapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.stockexchangeapp.StockAPIs.JsonPlaceHolderApi;
import com.example.stockexchangeapp.StockAPIs.TickerSearch;
import com.example.stockexchangeapp.databinding.FragmentFirstBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.Retrofit;

public class FirstFragment extends Fragment {



    private JsonPlaceHolderApi jsonPlaceHolderApi;

    private FragmentFirstBinding binding;

    String searchbartext = "gamestop";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

                                                                  //This will be the value in the search bar from fragment 1

        Retrofit retrofit = new Retrofit.Builder()                                                  //this is the current instance of retrofit2, unknown if we need a new instance for each api call
                .baseUrl(JsonPlaceHolderApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);



        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    private void GetTickerSearch(String thesearch){

        Context context = this.getContext();


        Call<TickerSearch> call = jsonPlaceHolderApi.GetTickerSearch(/*thesearch*/);                //This calls the class built from the searchticker code in PlaceholderAPi interface

        call.enqueue(new Callback<TickerSearch>() {                                                 //call.enqueue is a retrofit function to handle the asynchronous http call for us (MAGIC)
            @Override
            public void onResponse(Call<TickerSearch> call, Response<TickerSearch> response) {      //Anonymous function to ensure we have the enqueue response methods
                if (!response.isSuccessful()) {                                                     //Response can be unsuccessful from the server ex: 404 error codes
                    Toast.makeText(context, "Code: " + response.code(), Toast.LENGTH_LONG);
                    return;
                }

                //TODO Add code if response is good here
                Toast.makeText(
                                context,
                            "Number of results:\n"+
                                response.body().getResultCount() +
                                "\nResults:\n"+
                                response.body().getResults().toString(), Toast.LENGTH_LONG);
                return;
            }
                @Override
                public void onFailure(Call<TickerSearch> call, Throwable t) {
                    Toast.makeText(context, "Code: " + t.getMessage(), Toast.LENGTH_LONG);
                }
        });
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GetTickerSearch(searchbartext);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }




}