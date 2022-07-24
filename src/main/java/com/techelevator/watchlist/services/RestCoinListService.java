package com.techelevator.watchlist.services;

import com.techelevator.watchlist.model.CoinList;
import com.techelevator.watchlist.util.BasicLogger;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class RestCoinListService implements  CoinListService{

    private static final String API_BASE_URL = "https://api.coingecko.com/api/v3/coins/list";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public CoinList[] getCoinList() {
        CoinList[] coinLists = null;
        try {
            coinLists = restTemplate.getForObject(API_BASE_URL, CoinList[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return coinLists;
    }



}
