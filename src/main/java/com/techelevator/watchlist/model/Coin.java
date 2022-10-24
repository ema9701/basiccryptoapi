package com.techelevator.watchlist.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coin {
    @JsonProperty("id")
    private String id;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("name")
    private String name;
    @JsonProperty("market_data")
    private MarketData marketData;
    //Database instance variables
    private Integer entryId;
    private Double currentPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MarketData getMarketData() {
        return marketData;
    }

    public void setMarketData(MarketData marketData) {
        this.marketData = marketData;
    }

    //Database getters & setters

    public Integer getEntryId() {
        return  entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Coin() {}

    public Coin(Integer entryId, String id, String symbol, String name, Double currentPrice) {
        this.entryId = entryId;
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return " Coin ID: " + id +
                "\n Coin Name: " + name +
                "\n Coin Ticker: " + symbol +
                "\n Current Price: " + marketData.getCurrentPrice().get("usd") +
                "\n 24-hour Price change: " + marketData.getPriceChange24() +
                "\n 24-hour Low Price: " + marketData.getLow24h().get("usd") +
                "\n 24-hour High Price: " + marketData.getHigh24h().get("usd");
    }


}
