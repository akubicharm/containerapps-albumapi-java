CREATE TABLE album (
    id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    artist VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    book_url VARCHAR(512),
    image_url VARCHAR(512)
);