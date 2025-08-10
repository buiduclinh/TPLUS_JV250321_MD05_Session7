CREATE DATABASE md5_ss7_8_9;
USE md5_ss7_8_9;

CREATE TABLE category
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(50),
    description   VARCHAR(255) NOT NULL,
    status        BIT DEFAULT 1
);
-- lấy tất cả nhãn
DELIMITER $$
CREATE PROCEDURE get_all_category(
)
BEGIN
    SELECT * FROM category;
END $$
DELIMITER ;
-- lấy đối tượng theo id
DELIMITER $$
CREATE PROCEDURE get_category_by_id(
    IN in_category_id INT
)
BEGIN
    SELECT *
    FROM category
    WHERE id = in_category_id;
END $$
DELIMITER ;

-- add category
DELIMITER $$
CREATE PROCEDURE add_category(
    IN in_category_name VARCHAR(50),
    IN in_category_description VARCHAR(255)
)
BEGIN
    INSERT INTO category(category_name, description)
    VALUES (in_category_name, in_category_description);
END $$
DELIMITER ;

-- update category
DELIMITER $$
CREATE PROCEDURE update_category(
    IN in_category_id INT,
    IN in_category_name VARCHAR(50),
    IN in_category_description VARCHAR(255),
    IN in_category_status BIT
)
BEGIN
    UPDATE category
    SET category_name = in_category_name,
        description   = in_category_description,
        status        = in_category_status
    WHERE id = in_category_id;
END $$
DELIMITER ;

-- delete category
DELIMITER $$
CREATE PROCEDURE delete_category(
    IN in_category_id INT
)
BEGIN
    DELETE
    FROM category
    WHERE id = in_category_id;
END $$
DELIMITER ;