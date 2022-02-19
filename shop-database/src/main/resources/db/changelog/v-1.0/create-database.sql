SET search_path TO "geekbrains";

-- DROP TABLE IF EXISTS databasechangelog cascade;
-- DROP TABLE IF EXISTS databasechangeloglock cascade;
DROP TABLE IF EXISTS category cascade;
DROP TABLE IF EXISTS manufacturer cascade;
DROP TABLE IF EXISTS product cascade;
DROP TABLE IF EXISTS price cascade;
DROP TABLE IF EXISTS stores cascade;
DROP TABLE IF EXISTS deliverie cascade;
DROP TABLE IF EXISTS customer cascade;
DROP TABLE IF EXISTS purchase cascade;
DROP TABLE IF EXISTS purchase_item cascade;
DROP VIEW IF EXISTS product_current_price;
DROP TABLE IF EXISTS users cascade;
DROP TABLE IF EXISTS roles cascade;
DROP TABLE IF EXISTS users_roles cascade;


CREATE TABLE IF NOT EXISTS category
(
    id            bigserial primary key,
    category_name text NOT NULL
);

CREATE TABLE IF NOT EXISTS manufacturer
(
    id                bigserial primary key,
    manufacturer_name character varying(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS product
(
    id              bigserial primary key,
    product_name    character varying(255) UNIQUE NOT NULL,
    description     character varying(4096),
    category_id     bigint REFERENCES category (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    manufacturer_id bigint REFERENCES manufacturer (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS price
(
    id          bigserial primary key,
    product_id  bigint                      NOT NULL REFERENCES product (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    date_price  timestamp without time zone NOT NULL,
    price_value Decimal(18, 2)              NOT NULL
);

CREATE OR REPLACE VIEW product_current_price AS
SELECT p.*, pv.price_value
FROM product p
         INNER JOIN
     (
         SELECT product_id,
                MAX(date_price) max_date
         FROM price
         GROUP BY product_id
     ) max_dates ON p.id = max_dates.product_id
         INNER JOIN
     price pv ON max_dates.product_id = pv.product_id
         AND max_dates.max_date = pv.date_price;

CREATE TABLE IF NOT EXISTS store
(
    id         bigserial primary key,
    store_name text NOT NULL
);

CREATE TABLE IF NOT EXISTS delivery
(
    id            bigserial primary key,
    product_id    bigint                      NOT NULL references product (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    store_id      bigint                      NOT NULL references store (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    delivery_date timestamp without time zone NOT NULL,
    product_count INTEGER                     NOT NULL
);

CREATE TABLE IF NOT EXISTS customer
(
    id            bigserial primary key,
    customer_name text NOT NULL
);

CREATE TABLE IF NOT EXISTS purchase
(
    id            bigserial primary key,
    customer_id   bigint                      NOT NULL REFERENCES customer (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    store_id      bigint                      NOT NULL REFERENCES store (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    purchase_date timestamp without time zone NOT NULL
);

CREATE TABLE IF NOT EXISTS purchase_item
(
    id            bigserial primary key,
    purchase_id   bigint     NOT NULL REFERENCES purchase (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    product_id    bigint     NOT NULL REFERENCES product (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    product_count INTEGER    NOT NULL,
    price         dec(18, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id       bigserial primary key,
    username varchar(128) not null,
    password varchar(128),
    email    varchar(128)
);

CREATE TABLE IF NOT EXISTS roles
(
    id       bigserial primary key,
    name varchar(128) not null
);

CREATE TABLE IF NOT EXISTS users_roles
(
    user_id bigint REFERENCES users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    role_id bigint REFERENCES roles (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);
