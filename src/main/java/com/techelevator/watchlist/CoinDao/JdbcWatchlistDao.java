package com.techelevator.watchlist.CoinDao;

import com.techelevator.watchlist.model.Coin;
import com.techelevator.watchlist.model.Watchlist;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcWatchlistDao implements WatchlistDao {

    JdbcTemplate jdbcTemplate;

    public JdbcWatchlistDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Watchlist> viewAllLists() {
        List<Watchlist> lists = new ArrayList<>();
        final String sql = " SELECT * FROM watchlist; ";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        while (rs.next()) {
            lists.add(mapRowToWatchlist(rs));
        }
        return lists;
    }

    @Override
    public Watchlist getById(Integer id) {
        Watchlist w = null;
        final String sql = " SELECT list_name FROM watchlist WHERE list_id = ?; ";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, id);
        if (rs.next()) {
            w = mapRowToWatchlist(rs);
        }
        return w;
    }

    @Override
    public boolean updateList(Watchlist list, Integer id) {
        final String sql = " UPDATE watchlist SET name = ? WHERE list_id = ?; ";
        return jdbcTemplate.update(sql, list.getListName(), list.getListId()) == 1;
    }

    @Override
    public boolean deleteList(Integer id) {
        final String sql = " DELETE FROM watchlist WHERE list_id = ?; ";
        return jdbcTemplate.update(sql, id) == 1;
    }

    private Watchlist mapRowToWatchlist(SqlRowSet rs) {
        Watchlist w = new Watchlist();
        w.setListId(rs.getInt("list_id"));
        w.setListName(rs.getString("list_name"));
        return w;
    }

}
