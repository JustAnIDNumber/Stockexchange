package com.example.stockexchangeapp.StockAPIs;

/*  "country": "US",
  "currency": "USD",
  "exchange": "NASDAQ/NMS (GLOBAL MARKET)",
  "ipo": "1980-12-12",
  "marketCapitalization": 1415993,
  "name": "Apple Inc",
  "phone": "14089961010",
  "shareOutstanding": 4375.47998046875,
  "ticker": "AAPL",
  "weburl": "https://www.apple.com/",
  "logo": "https://static.finnhub.io/logo/87cb30d8-80df-11ea-8951-00000000092a.png",
  "finnhubIndustry":"Technology" */

import android.content.Context;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Constructor;
import java.util.Date;

public class CompanyProfile2 {

    @SerializedName("finnhubIndustry")
    String sector;
    String name;
    String country;
    String currency;
    String exchange;
    String ticker;
    String weburl;
    String logo;
    Date   ipo;
    int    marketCapitalization;
    int    phone;
    double shareOutstanding;

    public CompanyProfile2(
            String sector,
            String name,
            String country,
            String currency,
            String exchange,
            String ticker,
            String logo,
            Date ipo,
            int marketCapitalization,
            int phone,
            double shareOutstanding) {


            this.sector               = sector;
            this.name                 = name ;
            this.country              = country;
            this.currency             = currency;
            this.exchange             = exchange;
            this.ticker               = ticker;
            this.logo                 = logo;
            this.ipo                  = ipo;
            this.marketCapitalization = marketCapitalization;
            this.phone                = phone;
            this.shareOutstanding     = shareOutstanding;



    }


    public String getSector() {
        return sector;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCurrency() {
        return currency;
    }

    public String getExchange() {
        return exchange;
    }

    public String getTicker() {
        return ticker;
    }

    public String getWeburl() {
        return weburl;
    }

    public String getLogo() {
        return logo;
    }

    public Date getIpo() {
        return ipo;
    }

    public int getMarketCapitalization() {
        return marketCapitalization;
    }

    public int getPhone() {
        return phone;
    }

    public double getShareOutstanding() {
        return shareOutstanding;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setIpo(Date ipo) {
        this.ipo = ipo;
    }

    public void setMarketCapitalization(int marketCapitalization) {
        this.marketCapitalization = marketCapitalization;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setShareOutstanding(double shareOutstanding) {
        this.shareOutstanding = shareOutstanding;
    }
}



