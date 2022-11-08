CREATE TABLE IF NOT EXISTS confirmation_token
(
    id    VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    user_id    VARCHAR(255),
    expired_at TIMESTAMP WITHOUT TIME ZONE,
    token      VARCHAR(255),
    CONSTRAINT pk_confirmation_token PRIMARY KEY (token),
    CONSTRAINT fk_user_id_on_user_main FOREIGN KEY (user_id) REFERENCES user_main (id)
);