CREATE TABLE role (
    id BIGSERIAL PRIMARY KEY,
    name CHARACTER VARYING UNIQUE NOT NULL,
    created_at DATE NOT NULL,
    created_by CHARACTER VARYING NOT NULL,
    updated_at DATE,
    updated_by CHARACTER VARYING
);

CREATE TABLE account (
    id BIGSERIAL PRIMARY KEY,
    username CHARACTER VARYING UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL,
    enabled BOOLEAN NOT NULL,
    name CHARACTER VARYING NOT NULL,
    created_at DATE NOT NULL,
    created_by CHARACTER VARYING NOT NULL,
    updated_at DATE,
    updated_by CHARACTER VARYING
);

CREATE UNIQUE INDEX account_index ON account (username, password, enabled);

CREATE TABLE account_role (
    id BIGSERIAL PRIMARY KEY,
    account_id BIGSERIAL NOT NULL REFERENCES account,
    role_id BIGSERIAL NOT NULL REFERENCES role,
    created_at DATE NOT NULL,
    created_by CHARACTER VARYING NOT NULL,
    updated_at DATE,
    updated_by CHARACTER VARYING
);

CREATE UNIQUE INDEX account_role_index ON account_role (account_id, role_id);
