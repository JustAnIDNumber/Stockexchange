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

/*
###########################################################################
   SEARCH RESULT
   description: an object to hold the results from the POST get request
###########################################################################
 */
class Result {

    // {"description":"APPLE INC","displaySymbol":"AAPL","symbol":"AAPL","type":"Common Stock"}
    private String description;
    private String displaySymbol;
    private String symbol;
    private String type;


    public Result(String description, String displaySymbol, String symbol, String type) {
        this.description = description;
        this.displaySymbol = displaySymbol;
        this.symbol = symbol;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public String getDisplaySymbol() {
        return displaySymbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getType() {
        return type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDisplaySymbol(String displaySymbol) {
        this.displaySymbol = displaySymbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setType(String type) {
        this.type = type;
    }
}

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
