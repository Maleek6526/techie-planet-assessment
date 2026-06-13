SELECT
    games.yr,
    games.city,
    city.country
FROM games
LEFT JOIN city ON games.city = city.name;


SELECT
    games.yr,
    city.name,
    city.country
FROM games
RIGHT JOIN city ON games.city = city.name;