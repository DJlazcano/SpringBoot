CREATE SCHEMA IF NOT EXISTSshoppingcartñ

CREATE TABLE IF NOT EXISTS shoppingcart.USERS (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    area_of_interest VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS shoppingcart.PRODUCTS(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE,
    price DECIMAL(10,2) NOT NULL,
    image TEXT,
    description VARCHAR(255),
    total_products_inventory INT DEFAULT 0,
    status BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
);

CREATE TABLE shoppingcart.WISHLIST(
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES shoppingcart.USERS(id),
    FOREIGN KEY (product_id) REFERENCES shoppingcart.PRODUCTS(id)
);

CREATE TABLE shoppingcart.ORDER_HISTORY(
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES shoppingcart.USERS(id),
    FOREIGN KEY (product_id) REFERENCES shoppingcart.PRODUCTS(id)
);