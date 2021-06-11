package com.example.stockexchangeapp.StockAPIs;

/*
    https://finnhub.io/ LOGIN CREDENTIALS

    API key:        c313r62ad3idae6u7d6g

    Username/Email: Anthony/mujybgrvfdws@gmail.com
    Password:       Toothpaste

    example of POST possibly: https://finnhub.io/api/v1/search?q=apple&token=c313r62ad3idae6u7d6g

    so broken down would be something like: "https://finnhub.io/api/v1/search?q=" + aStockName + "&token=" + APIkey
 */

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class TickerSearch {

    @SerializedName("count")
    private int resultCount; //The number of results we get back
    @SerializedName("result")
    private List<Result> results;

    public TickerSearch(int resultCount, List<Result> results) {
        this.resultCount = resultCount;
        this.results = results;
    }

    /*
    public TickerSearch GetTickerSearch(){
        return this;
    }
    */

    public int getResultCount() {
        return resultCount;
    }

    public List<Result> getResults() {
        return results;
    }


}
