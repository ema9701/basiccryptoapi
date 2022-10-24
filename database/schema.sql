BEGIN TRANSACTION;
DROP TABLE IF EXISTS coin_watchlist, watchlist, coin;
	
CREATE TABLE coin (
    entry_id SERIAL PRIMARY KEY,
	coin_id VARCHAR(50),
	symbol VARCHAR(15),
	coin_name VARCHAR(50),
	current_price NUMERIC (13, 2)
);

 CREATE TABLE watchlist (
 	list_id SERIAL PRIMARY KEY,
 	list_name VARCHAR(50)
 );
--
-- CREATE TABLE coin_watchlist (
--    coin_id INT,
--    watchlist_id INT,
--    CONSTRAINT PK_coin_watchlist_id PRIMARY KEY (coin_id, watchlist_id),
--    CONSTRAINT FK_coin_watchlist_coin_id FOREIGN KEY (coin_id) REFERENCES coin(table_id),
--    CONSTRAINT FK_coin_watchlist_watchlist_id FOREIGN KEY (watchlist_id) REFERENCES watchlist(watchlist_id)
-- );



INSERT INTO coin (coin_id, symbol, coin_name, current_price)
VALUES ('test', 'tst', 'TestingCoin', 30.00),
		('stuff', 'stf', 'StuffCoin', 20.00);

-- ROLLBACK;
COMMIT TRANSACTION; 