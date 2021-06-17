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




    @GET() //This is the relative URL portion of the get request (i.e What comes after the base URL: search?q=" + aStockName + "&token=" + APIkey)
    Call<TickerSearch> GetTickerSearch(@Url String url); //this might have to change to a different method name other than getTickerSearch

}

/*TODO Implement the following APIS at some point:

Trades - Last Price Updates
Stock Symbol
Company Profile 2
Basic Financials
Stock Candles
Quote

Crypto Exchanges
Crypto Symbol
Crypto Candles
*/