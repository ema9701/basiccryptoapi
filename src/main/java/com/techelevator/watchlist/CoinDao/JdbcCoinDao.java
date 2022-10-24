package com.techelevator.watchlist.CoinDao;


import com.techelevator.watchlist.model.Coin;
import com.techelevator.watchlist.model.CoinDTO;
import com.techelevator.watchlist.model.Watchlist;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCoinDao implements CoinDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcCoinDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Coin> list() {
        List<Coin> coins = new ArrayList<>();
        final String sql = " SELECT * FROM coin; ";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        while (rs.next()) {
            coins.add(mapRowToCoin(rs));
        }
        return coins;
    }

    @Override
    public Coin getByApiId(String apiId) {
        Coin coin = null;
        final String sql = " SELECT * FROM coin WHERE coin_id = ?; ";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, apiId);
        if (rs.next()) {
            coin = mapRowToCoin(rs);
        }
        return coin;
    }

    @Override
    public Coin getByEntryId(Integer id) {
        Coin coin = null;
        final String sql = " SELECT * FROM coin WHERE entry_id = ?; ";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, id);
        if (rs.next()) {
            coin = mapRowToCoin(rs);
        }
        return coin;
    }

    @Override
    public Integer insertCoin(CoinDTO newCoin) {
        final String sql = " INSERT INTO coin (coin_id, symbol, coin_name, current_price) " +
                " VALUES (?, ?, ?, ?) RETURNING entry_id; ";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, newCoin.getCoinId(),
                newCoin.getSymbol(), newCoin.getName(), newCoin.getCurrentPrice());
        return newId;
    }

    @Override
    public boolean updatePriceData(Double newPrice, Integer id) {
        final String sql = " UPDATE coin SET current_price = ? WHERE entry_id = ?; ";
        return jdbcTemplate.update(sql, newPrice, id) == 1;
    }

    @Override
    public boolean deleteCoin(Integer id) {
        final String sql = " DELETE FROM coin WHERE entry_id = ?; ";

        return jdbcTemplate.update(sql, id) == 1;
    }

    @Override
    public void addCoinToList(int coinId, int listId) {
        final String sql = " INSERT INTO coin_watchlist(coin_id, watchlist_id) " +
                " VALUES (?, ?); ";
        jdbcTemplate.update(sql, coinId, listId);
    }

    @Override
    public void removeFromList(int coinId, int listId) {
        final String sql = " DELETE FROM coin_watchlist WHERE coin_id = ? AND watchlist_id = ?; ";
        jdbcTemplate.update(sql, coinId, listId);
    }
    
    private Coin mapRowToCoin(SqlRowSet rs) {
        Coin coin = new Coin();
        coin.setEntryId(rs.getInt("entry_id"));
        coin.setId(rs.getString("coin_id"));
        coin.setSymbol(rs.getString("symbol"));
        coin.setName(rs.getString("coin_name"));
        coin.setCurrentPrice(rs.getDouble("current_price"));
        return coin;
    }


}
