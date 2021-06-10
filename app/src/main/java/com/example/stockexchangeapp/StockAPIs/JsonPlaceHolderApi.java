package com.example.stockexchangeapp.StockAPIs;

import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    @GET("{searchGetURL}") //This is the relative URL portion of the get request (i.e What comes after the base URL: search?q=" + aStockName + "&token=" + APIkey)
    Call<TickerSearch> GetTickerSearch( @Query("getResultCount") int count, @Query("getResults") List<Result> resultslist ); //this might have to change to a different method name other than getTickerSearch

    //TODO Add other API calls here (Summary, ticker prices, etc)
}
