use polyoe_new
go

CREATE PROC spFavoriteByYear(@Year INT)
AS
BEGIN
SELECT
v.Title AS 'Group',
count(f.Id) AS 'Like',
max(f.LikeDate) AS 'Newest',
min(f.LikeDate) AS 'Oldest'
FROM Favorites f JOIN Videos v ON v.Id = f.VideoId
WHERE year(f.LikeDate) = @Year
GROUP BY v.Title
END
exec spFavoriteByYear 2024

