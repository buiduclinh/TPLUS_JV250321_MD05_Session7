CREATE DATABASE movie_m;
USE movie_m;

CREATE TABLE movie
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    title        VARCHAR(100),
    director     VARCHAR(100),
    release_date DATE,
    genre        VARCHAR(30),
    poster       VARCHAR(100)
);

-- lấy movie theo id
DELIMITER $$
CREATE PROCEDURE get_movie_by_id(
    IN in_movie_id INT
)
BEGIN
    SELECT *
    FROM movie
    WHERE id = in_movie_id;
END $$
DELIMITER ;

-- lấy tất cả movie
DELIMITER $$
CREATE PROCEDURE get_all_movie()
BEGIN
    SELECT * FROM movie;
END $$
DELIMITER ;

-- thêm mới movie
DELIMITER $$
CREATE PROCEDURE add_movie(
    IN in_movie_title VARCHAR(100),
    IN in_movie_director VARCHAR(100),
    IN in_movie_release_date DATE,
    IN in_movie_genre VARCHAR(100),
    IN in_movie_poster VARCHAR(100)
)
BEGIN
    INSERT INTO movie(title, director, release_date, genre, poster)
    VALUES (in_movie_title, in_movie_director, in_movie_release_date, in_movie_genre, in_movie_poster);
END
$$
DELIMITER ;

-- cập nhật phim
DELIMITER $$
CREATE PROCEDURE update_movie(
    IN in_movie_id INT,
    IN in_movie_title VARCHAR(100),
    IN in_movie_director VARCHAR(100),
    IN in_movie_release_date DATE,
    IN in_movie_genre VARCHAR(100),
    IN in_movie_poster VARCHAR(100)
)
BEGIN
    UPDATE movie
    SET title=in_movie_title,
        director=in_movie_director,
        release_date=in_movie_release_date,
        genre=in_movie_genre,
        poster=in_movie_poster
    WHERE id = in_movie_id;
END $$
DELIMITER ;

-- xóa phim
DELIMITER $$
CREATE PROCEDURE delete_movie(
    IN in_movie_id INT
)
BEGIN
    DELETE
    FROM movie
    WHERE id = in_movie_id;
END $$
DELIMITER ;


