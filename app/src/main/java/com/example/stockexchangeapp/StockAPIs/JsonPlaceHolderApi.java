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




    @GET()
    Call<TickerSearch> GetTickerSearch(@Url String url); //this might have to change to a different method name other than getTickerSearch

    @GET()
    Call<CompanyProfile2> GetCompanyProfile2(@Url String url);
}

/*TODO Implement the following APIS at some point:

Trades - Last Price Updates - websocket (might be difficult or require extra files)
Stock Symbol - DONE
Company Profile 2 - DONE
Basic Financials
Stock Candles
Quote

Crypto Exchanges
Crypto Symbol
Crypto Candles
*/