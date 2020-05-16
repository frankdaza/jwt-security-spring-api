CREATE TABLE account_role (
    id BIGSERIAL PRIMARY KEY,
    account_id BIGSERIAL NOT NULL REFERENCES account,
    role_id BIGSERIAL NOT NULL REFERENCES role
);

CREATE UNIQUE INDEX account_role_index ON account_role (account_id, role_id);
