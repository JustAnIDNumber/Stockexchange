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


/****************************************************************************************************
 TICKERSEARCH
 Java 8's version of a record. When android catches up to java 14 this should be changed to record
 ****************************************************************************************************/
public class TickerSearch {


    @SerializedName("count")
    private int resultCount; //The number of results we get back
    @SerializedName("result")
    private List<SearchResult> results;

    public TickerSearch() {

    }
    public TickerSearch(int resultCount, List<SearchResult> results) {

        this.resultCount = resultCount;
        this.results     = results;
    }



    public int getResultCount() {
        return resultCount;
    }

    public List<SearchResult> getResults() {
        return results;
    }


    /****************************************************************************************************
        INNER CLASS SearchResult
        Java 8's version of a record. When android catches up to java 14 this should be changed to record
    ****************************************************************************************************/

    public class SearchResult {
        private String description;
        private String displaySymbol;
        private String symbol;
        private String type;


        public SearchResult(String description, String displaySymbol, String symbol, String type) {
            this.description = description;
            this.displaySymbol = displaySymbol;
            this.symbol = symbol;
            this.type = type;
        }

        public List<SearchResult> getResultsList(){
            return results;
        }

        public int getResultCount(){
            return resultCount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDisplaySymbol() {
            return displaySymbol;
        }

        public void setDisplaySymbol(String displaySymbol) {
            this.displaySymbol = displaySymbol;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }



}

