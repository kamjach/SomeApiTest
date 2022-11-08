CREATE TABLE IF NOT EXISTS role
(
    role_id serial PRIMARY KEY,
    name    varchar(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_main
(
    id         varchar PRIMARY KEY,
    first_name varchar NOT NULL,
    last_name  varchar NOT NULL,
    email      varchar NOT NULL,
    password   varchar,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

INSERT INTO role (role_id, name)
VALUES (11, 'ADMIN');

INSERT INTO role (role_id, name)
VALUES (22, 'USER');