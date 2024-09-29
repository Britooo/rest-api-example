INSERT INTO
    director(name, birth_date, is_alive, is_oscar_winner)
VALUES
    ('Steven Spielberg', '1946-12-18', true, true),
    ('Christopher Nolan', '1970-07-30', true, true),
    ('Quentin Tarantino', '1963-03-27', true, true),
    ('Alfred Hitchcock', '1899-08-13', false, false),
    ('Martin Scorsese', '1942-11-17', true, true),
    ('Ridley Scott', '1937-11-30', true, false),
    ('James Cameron', '1954-08-16', true, true),
    ('Peter Jackson', '1961-10-31', true, true),
    ('Francis Ford Coppola', '1939-04-07', true, true),
    ('Guillermo del Toro', '1964-10-09', true, true);

INSERT INTO
    movie(name, genre, release_date, rating, director_id)
VALUES
    ('Jaws', 'Thriller', '1975-06-20', 8.0, 1),
    ('Jurassic Park', 'Adventure', '1993-06-11', 8.2, 1),
    ('Schindler''s List', 'Drama', '1993-12-15', 8.9, 1),
    ('Inception', 'Sci-Fi', '2010-07-16', 8.8, 2),
    ('The Dark Knight', 'Action', '2008-07-18', 9.0, 2),
    ('Dunkirk', 'War', '2017-07-21', 7.9, 2),
    ('Pulp Fiction', 'Crime', '1994-10-14', 8.9, 3),
    ('Once Upon a Time in Hollywood', 'Comedy', '2019-07-26', 7.6, 3),
    ('Psycho', 'Horror', '1960-09-08', 8.5, 4),
    ('Vertigo', 'Mystery', '1958-05-09', 8.3, 4),
    ('The Irishman', 'Drama', '2019-11-27', 7.8, 5),
    ('Goodfellas', 'Crime', '1990-09-19', 8.7, 5),
    ('Gladiator', 'Action', '2000-05-05', 8.5, 6),
    ('Blade Runner', 'Sci-Fi', '1982-06-25', 8.1, 6),
    ('Avatar', 'Sci-Fi', '2009-12-18', 7.8, 7),
    ('Titanic', 'Romance', '1997-12-19', 7.8, 7),
    ('The Lord of the Rings: The Fellowship of the Ring', 'Fantasy', '2001-12-19', 8.8, 8),
    ('The Lord of the Rings: The Return of the King', 'Fantasy', '2003-12-17', 9.0, 8),
    ('The Godfather', 'Crime', '1972-03-24', 9.2, 9),
    ('Pan''s Labyrinth', 'Fantasy', '2006-10-11', 8.2, 10);
