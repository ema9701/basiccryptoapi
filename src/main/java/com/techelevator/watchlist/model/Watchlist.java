package com.techelevator.watchlist.model;

import java.util.ArrayList;
import java.util.List;

public class Watchlist {

    Long id;
    List<Coin> coinList = new ArrayList<>();


    public Watchlist(Long id, List<Coin> coinList) {
        this.id = id;
        this.coinList = coinList;
    }

    public Watchlist() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

}
