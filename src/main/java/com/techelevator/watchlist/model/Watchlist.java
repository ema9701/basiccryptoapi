package com.techelevator.watchlist.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Watchlist {

    Integer listId;
    String listName;
    List<Coin> savedCoins;
    Map<String, Coin> coinsToWatch;

    public Watchlist(Integer listId, String listName) {
        this.listId = listId;
        this.listName = listName;
        this.savedCoins = new ArrayList<>();
        this.coinsToWatch = new HashMap<>();
    }

    public Watchlist() {
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<Coin> getSavedCoins() {
        return savedCoins;
    }

    public void setSavedCoins(List<Coin> savedCoins) {
        this.savedCoins = savedCoins;
    }

    public Map<String, Coin> getCoinsToWatch() {
        return coinsToWatch;
    }

    public void setCoinsToWatch(Map<String, Coin> coinsToWatch) {
        this.coinsToWatch = coinsToWatch;
    }

    public void addCoinsToList(Coin coin) {
        if (coinsToWatch.containsKey(getListName())) {
            if (!coinsToWatch.containsValue(coin)) {
                coinsToWatch.put(getListName(), coin);
            }
        }
    }

    @Override
    public String toString() {
        return listId + "." + listName;
    }

}
