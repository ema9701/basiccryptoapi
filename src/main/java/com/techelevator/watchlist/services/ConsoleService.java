package com.techelevator.watchlist.services;

import com.techelevator.watchlist.model.Coin;
import com.techelevator.watchlist.model.CoinList;
import com.techelevator.watchlist.model.Watchlist;

import java.util.List;
import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.println(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void mainMenuList() {
        System.out.println("============================");
        System.out.println("     Watchlist API Client   ");
        System.out.println("============================");
        System.out.println("1. List supported currencies.");
        System.out.println("2. Search for currency by ID.");
        System.out.println("3. Get database entries.");
        System.out.println("4. View/Edit watchlists.");
        System.out.println("0. Exit");

    }

    public void printCoinList(CoinList[] coinLists) {
        if (coinLists != null) {
            System.out.println("============================");
            for (CoinList list : coinLists) {
                System.out.println(list.toString());
            }
            System.out.println("============================");
        }
    }

    public void printCoinData(Coin coin, String id) {
        if (coin != null) {
            String msg = "Recent Coin Data for: " + id;
            System.out.println("===============================");
            System.out.println(msg);
            System.out.println("===============================");
            System.out.println(coin.toString());
        }
    }

    public void printDBEntries(List<Coin> coins) {
        if (coins != null) {
            for (Coin coin : coins) {
                System.out.println("=============================");
                System.out.println(coin.getEntryId() +
                        " \n" + coin.getName() +
                        " \n" + coin.getSymbol() +
                        " \n" + coin.getCurrentPrice());
                System.out.println("=============================");
            }
        }
    }



    public void printWatchlist(List<Watchlist> lists) {
        if (lists != null) {
            System.out.println("=============================");
            for (Watchlist list : lists) {
                System.out.println(list.toString());
            }
            System.out.println("=============================");

        }
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public String promptForString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public void printError() {
        System.out.println("An error occurred. Please try again.");
    }

}
