SELECT
    games.yr,
    city.country
FROM games
JOIN city ON games.city = city.name
ORDER BY games.yr ASC;