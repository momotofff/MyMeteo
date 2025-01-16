CREATE TABLE Users (
    id          BIGINT      PRIMARY KEY,
    username    TEXT        NOT NULL UNIQUE,
    email       TEXT        NOT NULL UNIQUE
);

CREATE TABLE sensors (
    id          BIGINT      PRIMARY KEY,
    name        TEXT        NOT NULL UNIQUE,
    created_at  TIMESTAMP   DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE measurements (
    id          BIGINT      PRIMARY KEY,
    sensor_id   BIGINT      REFERENCES sensors(id),
    value       FLOAT       NOT NULL,
    raining     BOOLEAN     NOT NULL
);

