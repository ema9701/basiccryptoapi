package com.techelevator.watchlist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinDTO {

    private String coinId;
    private String symbol;
    private String name;
    private Double currentPrice;

    public CoinDTO(String coinId, String symbol, String name, Double currentPrice) {
        this.coinId = coinId;
        this.symbol = symbol;
        this.name = name;
        this.currentPrice = currentPrice;
    }

    public CoinDTO() {}

    public String getCoinId() {
        return coinId;
    }

    public void setCoinId(String coinId) {
        this.coinId = coinId;
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

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
