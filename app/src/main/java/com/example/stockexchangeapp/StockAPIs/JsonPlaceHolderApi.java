package com.example.stockexchangeapp.StockAPIs;

import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    // API CONSTANTS FOR FETCHING DATA FROM STOCK SERVER //
    final String BASE_URL = "https://finnhub.io/api/v1/";
    final String AUTH_TOKEN = "&token=c313r62ad3idae6u7d6g"; //If key ever changes, change this
    final String SEARCH_TICKER_URL = "search?q=";

    //q={ticker}&token=c313r62ad3idae6u7d6g
    //@GET(SEARCH_TICKER_URL+"{ticker}"+AUTH_TOKEN) //This is the relative URL portion of the get request (i.e What comes after the base URL: search?q=" + aStockName + "&token=" + APIkey)
    //Call<TickerSearch> GetTickerSearch(@Path("{ticker}") String ticker); //this might have to change to a different method name other than getTickerSearch

    //TODO fix this file path to not be static
    @GET(SEARCH_TICKER_URL+"gamestop"+AUTH_TOKEN) //This is the relative URL portion of the get request (i.e What comes after the base URL: search?q=" + aStockName + "&token=" + APIkey)
    Call<TickerSearch> GetTickerSearch(); //this might have to change to a different method name other than getTickerSearch

}
