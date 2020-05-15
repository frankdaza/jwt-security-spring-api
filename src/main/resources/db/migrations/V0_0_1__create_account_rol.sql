CREATE TABLE role (
    id BIGSERIAL PRIMARY KEY,
    name CHARACTER VARYING UNIQUE NOT NULL
);

CREATE TABLE account (
    id BIGSERIAL PRIMARY KEY,
    username CHARACTER VARYING UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL,
    name CHARACTER VARYING NOT NULL
);

CREATE UNIQUE INDEX account_index ON account (username, password, enabled);
