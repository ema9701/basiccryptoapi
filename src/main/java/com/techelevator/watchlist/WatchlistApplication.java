package com.techelevator.watchlist;

import com.techelevator.watchlist.CoinDao.CoinDao;
import com.techelevator.watchlist.CoinDao.JdbcCoinDao;
import com.techelevator.watchlist.CoinDao.JdbcWatchlistDao;
import com.techelevator.watchlist.CoinDao.WatchlistDao;
import com.techelevator.watchlist.model.Coin;
import com.techelevator.watchlist.model.CoinDTO;
import com.techelevator.watchlist.model.CoinList;
import com.techelevator.watchlist.model.Watchlist;
import com.techelevator.watchlist.services.ConsoleService;
import com.techelevator.watchlist.services.RestCoinListService;
import com.techelevator.watchlist.services.RestCoinService;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class WatchlistApplication {

    ConsoleService console;
    RestCoinService coinService;
    RestCoinListService coinList;
    CoinDao coinDao;
    WatchlistDao watchDao;

    public WatchlistApplication() {
        this.console = new ConsoleService();
        this.coinService = new RestCoinService();
        this.coinList = new RestCoinListService();
        BasicDataSource dataSource = new BasicDataSource();
        String url = System.getenv("DB_URL");
        dataSource.setUrl(url);
        dataSource.setUsername(System.getenv("DB_USER"));
        dataSource.setPassword(System.getenv("DB_PASSWORD"));
        this.coinDao = new JdbcCoinDao(dataSource);
        this.watchDao = new JdbcWatchlistDao((dataSource));
    }


    public static void main(String[] args) {
        WatchlistApplication app = new WatchlistApplication();
        app.run();
    }


    private void run() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            console.mainMenuList();
            menuSelection = console.promptForMenuSelection("Please select a service: "
            );
            if (menuSelection == 1) {
                handleCoinList();
            } else if (menuSelection == 2) {
                handleCoinData();
            } else if (menuSelection == 3) {
                viewFromDatabase();
            } else if (menuSelection == 4) {
                selectList();
            }
            else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid selection.");
            }
            console.pause();
        }
    }

    private void handleCoinList() {
        CoinList[] coinList = this.coinList.getCoinList();
        if (coinList != null) {
            console.printCoinList(coinList);
        } else {
            console.printError();
        }
    }

    private void handleCoinData() {
        String idInput = console.promptForString("Coin id: ");
        try {
            Coin response = coinService.get(idInput);
            console.printCoinData(response, response.getId());
            String addCoin = console.promptForString("Add to database? (Y/N)");
            if (addCoin.equalsIgnoreCase("y")) {
                double price = response.getMarketData().getCurrentPrice().get("usd");
                CoinDTO newEntry = new CoinDTO(response.getId(), response.getSymbol(),
                        response.getName(), price);
                Integer newId = coinDao.insertCoin(newEntry);
                System.out.println("\n New entry created for " + coinDao.getByEntryId(newId).getName() +
                        " with a table id of " + newId);
            } else if (addCoin.equalsIgnoreCase("n")) {
                return;
            }
        } catch (Exception e) {
            console.printError();
        }
    }

    private void selectList() {
        List<Watchlist> lists = watchDao.viewAllLists();
        console.printWatchlist(lists);
        String listId = console.promptForString("Select a list: ");
//        Watchlist list = lists.get(Integer.parseInt(listId) -1);
//        list.setSavedCoins(coinDao.getCoinsByWatchlistId(list.getListId()));
//        console.printDBEntries(list.getSavedCoins());
        Watchlist list = watchDao.getById(Integer.parseInt(listId));

    }

    private void createNewList() {
        String newListName = console.promptForString("Enter a name for the new list: ");
        Watchlist newList = watchDao.createNewList(newListName);
    }



    private void viewFromDatabase() {
        List<Coin> coins = coinDao.list();
        console.printDBEntries(coins);
    }





}
