DROP TABLE orders IF EXISTS;
DROP TABLE clients IF EXISTS;

DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), price INTEGER, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Milk', 56), ('Apples', 129), ('Bread', 59), ('Tea', 109), ('Sugar', 60);


CREATE TABLE IF NOT EXISTS clients (id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO clients (name) VALUES ('Bob'), ('Alex'), ('John'), ('Vasya'), ('Rajesh');


CREATE TABLE IF NOT EXISTS orders (id bigserial, client_id INTEGER, product_id INTEGER, PRIMARY KEY (id), FOREIGN KEY (client_id) REFERENCES clients (id), FOREIGN KEY (product_id) REFERENCES products (id));
--INSERT INTO orders (client_id, product_id) VALUES (1, 1), (1, 2), (2, 5), (2, 1), (2, 6);