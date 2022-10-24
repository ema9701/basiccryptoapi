package com.techelevator.watchlist.model;

import java.util.ArrayList;
import java.util.List;

public class Watchlist {

   Integer listId;
   String listName;
   List<Coin> savedCoins;

   public Watchlist(Integer listId, String listName) {
       this.listId = listId;
       this.listName = listName;
       this.savedCoins = new ArrayList<>();
   }

   public Watchlist() {}

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
}
