CREATE TABLE orders (
    id          UUID PRIMARY KEY,
    status      VARCHAR(20)  NOT NULL,
    supplier    VARCHAR(255) NOT NULL,
    destination VARCHAR(255) NOT NULL,
    product     VARCHAR(255) NOT NULL,
    quantity    INTEGER      NOT NULL,
    notes       TEXT,
    created_at  TIMESTAMP    NOT NULL,
    updated_at  TIMESTAMP    NOT NULL
);
