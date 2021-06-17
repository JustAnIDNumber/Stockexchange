package com.example.stockexchangeapp.StockAPIs;

public class URLbuilder {

    // API CONSTANTS FOR FETCHING DATA FROM STOCK SERVER //
    final static String BASE_URL = "https://finnhub.io/api/v1/";
    final static String AUTH_TOKEN = "&token=c313r62ad3idae6u7d6g";                                 //If key ever changes, change this

    final static String SEARCH_TICKER_URL = "search?q=";

    public enum REQUEST_TYPE{
        GetTickerSearch,                                                                            //Search for best-matching symbols based on your query.
        StockSymbol,
        CompanyProfile2,
        BasicFinancials,
        StockCandles,
        Quote,

        CryptoExchanges,
        CryptoSymbol,
        CryptoCandles,

    }

    //TODO the other API calls
    public static String GetURL(REQUEST_TYPE type, String theSearch){

        String theURL = "";

        switch (type){
           case GetTickerSearch: theURL = theURL + SEARCH_TICKER_URL;
               break;
           case StockSymbol:
               break;
           case CompanyProfile2:
               break;
           case BasicFinancials:
               break;
           case StockCandles:
               break;
           case Quote:
               break;
           case CryptoExchanges:
               break;
           case CryptoSymbol:
               break;
           case CryptoCandles:
               break;
        }

        theURL = theURL + theSearch;
        theURL = theURL + AUTH_TOKEN;
        return theURL;

    }

    public static String getBASE_URL() {
        return BASE_URL;
    }

    public static String getAUTH_TOKEN() {
        return AUTH_TOKEN;
    }
}
