CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS countries
(
    id   UUID         NOT NULL PRIMARY KEY,
    code VARCHAR(2)   NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS publishers
(
    id           UUID         NOT NULL PRIMARY KEY,
    name         VARCHAR(80)  NOT NULL UNIQUE,
    email        VARCHAR(255) NOT NULL UNIQUE,
    revenue      NUMERIC(20, 2),
    founded_date DATE         NOT NULL,
    active       BOOLEAN      NOT NULL,
    country_id   UUID,
    CONSTRAINT fk_country_id FOREIGN KEY (country_id) REFERENCES countries (id)
);

CREATE TABLE IF NOT EXISTS games
(
    id           UUID           NOT NULL PRIMARY KEY,
    title        VARCHAR(300)   NOT NULL,
    description  VARCHAR(700),
    price        NUMERIC(20, 2) NOT NULL,
    category     VARCHAR(30),
    CHECK (category IN ('RPG', 'ACTION', 'ADVENTURE', 'FPS', 'RACING', 'SPORTS', 'STRATEGY', 'HORROR', 'PLATFORMER',
                        'BATTLE_ROYALE')),
    launch_date  DATE           NOT NULL,
    publisher_id UUID           NOT NULL,
    CONSTRAINT fk_publisher_id FOREIGN KEY (publisher_id) REFERENCES publishers (id)
);

