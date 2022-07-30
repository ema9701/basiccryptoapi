package com.techelevator.watchlist;

import com.techelevator.watchlist.model.Coin;
import com.techelevator.watchlist.model.CoinList;
import com.techelevator.watchlist.model.Portfolio;
import com.techelevator.watchlist.services.ConsoleService;
import com.techelevator.watchlist.services.RestCoinListService;
import com.techelevator.watchlist.services.RestCoinService;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@SpringBootApplication
public class WatchlistApplication {

    ConsoleService console = new ConsoleService();
    RestCoinService restCoinService = new RestCoinService();
    RestCoinListService restCoinListService = new RestCoinListService();

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
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid selection.");
            }
            console.pause();
        }
    }

    private void handleCoinList() {
        CoinList[] coinList = restCoinListService.getCoinList();
        if (coinList != null) {
            console.printCoinList(coinList);
        } else {
            console.printError();
        }
    }

    private void handleCoinData() {
        String idInput = console.promptForString("Coin id: ");
        Coin response = restCoinService.get(idInput);
        console.printCoinData(response, response.getId());
    }


}
