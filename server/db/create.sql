DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id                                  INT                 PRIMARY KEY AUTO_INCREMENT,
    full_name                           VARCHAR(100),
    phone_number                        VARCHAR(20),
    email                               VARCHAR(100),
    username                            VARCHAR(100),
    password                            VARCHAR(100),
    status                              INT,
    role                                VARCHAR(50),
    updated_at                          DATETIME,
    updated_by                          INT,
    created_at                          DATETIME,
    created_by                          INT,
);

DROP TABLE IF EXISTS user_settings;
CREATE TABLE user_settings (
    user_id                             INT                 PRIMARY KEY,
    dashboard_position                  TEXT,
    month_start_at                      DATE,
);