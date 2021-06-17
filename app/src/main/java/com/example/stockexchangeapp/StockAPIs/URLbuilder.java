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
           case GetTickerSearch:    theURL = theURL + SEARCH_TICKER_URL;
           break;
           case StockSymbol:        return "Feature Not added";
           case CompanyProfile2:    return "Feature Not added";
           case BasicFinancials:    return "Feature Not added";
           case StockCandles:       return "Feature Not added";
           case Quote:              return "Feature Not added";
           case CryptoExchanges:    return "Feature Not added";
           case CryptoSymbol:       return "Feature Not added";
           case CryptoCandles:      return "Feature Not added";
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
