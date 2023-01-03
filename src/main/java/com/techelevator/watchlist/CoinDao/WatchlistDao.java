package com.techelevator.watchlist.CoinDao;

import com.techelevator.watchlist.model.Coin;
import com.techelevator.watchlist.model.Watchlist;

import java.util.List;

public interface WatchlistDao {

    List<Watchlist> viewAllLists();

    Watchlist getById(Integer id);

    boolean updateList(Watchlist list, Integer id);

    boolean deleteList(Integer id);

    Watchlist createNewList(String name);


}
