# JUnit 학습 - 배포를 위해서!!

### 1. 테이블 생성

```sql
USE greendb;
show variables like 'autocommit%';
SET AUTOCOMMIT = TRUE;
create table product(
    product_id int primary KEY auto_increment,
    product_name varchar(20) NOT null,
    product_price INT NOT null,
    product_qty INT NOT NULL,
    created_at TIMESTAMP NOT null
);
create table customer(
    customer_id int primary KEY auto_increment,
    username varchar(20) NOT null,
    password VARCHAR(20) NOT null,
    created_at TIMESTAMP
);
create table orders(
    order_id int primary KEY auto_increment,
    customer_id INT NOT null,
    product_id INT NOT null,
    created_at TIMESTAMP
);

ALTER TABLE product CONVERT TO CHARACTER SET UTF8;
ALTER TABLE customer CONVERT TO CHARACTER SET UTF8;
ALTER TABLE orders CONVERT TO CHARACTER SET utf8;

```

### 2. 더미 데이터

```sql
INSERT INTO product(product_name, product_price, product_qty, created_at) VALUES('바나나', 3000, 98, NOW());
INSERT INTO product(product_name, product_price, product_qty, created_at) VALUES('딸기', 2000, 100, NOW());
INSERT INTO customer(username, PASSWORD, created_at) VALUES('ssar', '1234', NOW());
INSERT INTO customer(username, PASSWORD, created_at) VALUES('cos', '1234', NOW());
INSERT INTO orders(customer_id, product_id, created_at) VALUES(1, 1, NOW());
INSERT INTO orders(customer_id, product_id, created_at) VALUES(2, 1, NOW());
```