CREATE TABLE IF NOT EXISTS user_main_role
(
    user_id
    varchar
    NOT
    NULL,
    role_id
    SERIAL
    NOT
    NULL,
    PRIMARY
    KEY
(
    user_id,
    role_id
),
    FOREIGN KEY
(
    user_id
) REFERENCES user_main
(
    id
) ON DELETE CASCADE
  ON UPDATE CASCADE,
    FOREIGN KEY
(
    role_id
) REFERENCES role
(
    role_id
)
  ON DELETE CASCADE
  ON UPDATE CASCADE );