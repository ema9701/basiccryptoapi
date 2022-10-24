package com.techelevator.watchlist.CoinDao;

import com.techelevator.watchlist.model.Coin;
import com.techelevator.watchlist.model.CoinDTO;
import com.techelevator.watchlist.model.MarketData;
import com.techelevator.watchlist.model.Watchlist;

import java.util.List;

public interface CoinDao {

    List<Coin> list();

    Coin getByApiId(String apiId);

    Coin getByEntryId(Integer id);

    Integer insertCoin(CoinDTO newCoin);

    boolean deleteCoin(Integer id);
}
