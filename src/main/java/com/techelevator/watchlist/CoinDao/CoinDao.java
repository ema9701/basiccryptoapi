package com.techelevator.watchlist.CoinDao;

import com.techelevator.watchlist.model.Coin;
import com.techelevator.watchlist.model.CoinDTO;
import com.techelevator.watchlist.model.MarketData;
import com.techelevator.watchlist.model.Watchlist;

import java.util.List;

public interface CoinDao {

    List<Coin> list();

    List<Coin> getCoinsByWatchlistId(int listId);

    Coin getByApiId(String apiId);

    Coin getByEntryId(Integer id);

    Integer insertCoin(CoinDTO newCoin);

    boolean updatePriceData(Double newPrice, Integer id);

    boolean deleteCoin(Integer id);

    void addCoinToList(int coinId, int listId);

    void removeFromList(int coinId, int listId);
}
