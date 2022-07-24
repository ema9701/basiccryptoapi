package com.techelevator.watchlist.services;

import com.techelevator.watchlist.model.Coin;
import com.techelevator.watchlist.model.CoinList;

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
        System.out.println("==========================");
        System.out.println("   Watchlist API Client   ");
        System.out.println("==========================");
        System.out.println("1. List supported currencies.");
        System.out.println("2. Search for currency by ID.");
        System.out.println("3. Select a watchlist.");
        System.out.println("4. Create new watchlist.");
    }


    public void printCoinList(CoinList[] coinLists) {
        System.out.println("==========================");
        System.out.println("    CoinList Main         ");
        System.out.println("==========================");
        System.out.println("0. Exit");
        if (coinLists != null) {
            for (CoinList list : coinLists) {
                System.out.println(list.toString());
            }
            System.out.println();
        }
    }

    public void printCoinData(Coin coin, String id) {
        System.out.println("Please enter a coin id: ");
        if (coin != null) {
            String msg = "Recent Coin Data for: " + id;
            System.out.println("=============================");
            System.out.println(msg);
            System.out.println("=============================");
            System.out.println(coin.toString());
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
}
