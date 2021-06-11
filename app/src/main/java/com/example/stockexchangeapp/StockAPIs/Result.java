package com.example.stockexchangeapp.StockAPIs;

/*
###########################################################################
   SEARCH RESULT
   description: an object to hold the results from the POST get request
###########################################################################
 */
public class Result {

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
