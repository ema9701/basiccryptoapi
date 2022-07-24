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


    public static void main(String[] args) {

        ConsoleService console = new ConsoleService();
        RestCoinService restCoinService = new RestCoinService();
        RestCoinListService restCoinListService = new RestCoinListService();
        RestTemplate restTemplate = new RestTemplate();
        Scanner scanner = new Scanner(System.in);
        Coin response = new Coin();
        Portfolio port = new Portfolio();

        System.out.println("Select a service: ");
        console.mainMenuList();
        String selection = scanner.nextLine();
        Integer userInput = Integer.parseInt(selection);

        if (userInput == 1) {
           console.printCoinList(restCoinListService.getCoinList());
        } else if (userInput == 2) {
            System.out.println("Please enter a coin id: ");
            String idInput = scanner.nextLine();
            response = restCoinService.get(idInput);
            console.printCoinData(response, response.getId());

        }




    }
}
