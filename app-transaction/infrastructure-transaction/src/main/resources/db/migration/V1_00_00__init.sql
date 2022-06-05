CREATE TABLE customer
(
    id         UUID PRIMARY KEY,
    first_name varchar not null,
    last_name  varchar not null
);

CREATE TABLE purchase
(
    id            UUID PRIMARY KEY,
    customer_id   UUID    NOT NULL,
    amount        numeric not null,
    purchase_date timestamp not null,
    CONSTRAINT fk_purchase_customer
        FOREIGN KEY (customer_id)
            REFERENCES customer (id)
);
