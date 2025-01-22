INSERT INTO countries (id, code, name)
VALUES (uuid_generate_v4(), 'US', 'United States'),
       (uuid_generate_v4(), 'GB', 'United Kingdom'),
       (uuid_generate_v4(), 'BR', 'Brazil'),
       (uuid_generate_v4(), 'JP', 'Japan'),
       (uuid_generate_v4(), 'DE', 'Germany');

INSERT INTO publishers (id, name, email, revenue, founded_date, active, country_id)
VALUES (uuid_generate_v4(), 'Epic Games', 'contact@epicgames.com', 100000000.00, '1991-01-01', true,
        (SELECT id FROM countries WHERE code = 'US')),
       (uuid_generate_v4(), 'Valve Corporation', 'info@valve.com', 150000000.00, '1996-08-24', true,
        (SELECT id FROM countries WHERE code = 'US')),
       (uuid_generate_v4(), 'CD Projekt', 'contact@cdprojekt.com', 50000000.00, '1994-05-01', true,
        (SELECT id FROM countries WHERE code = 'PL')),
       (uuid_generate_v4(), 'Nintendo', 'support@nintendo.com', 200000000.00, '1889-09-23', true,
        (SELECT id FROM countries WHERE code = 'JP')),
       (uuid_generate_v4(), 'Square Enix', 'contact@square-enix.com', 70000000.00, '1986-04-01', true,
        (SELECT id FROM countries WHERE code = 'JP'));

INSERT INTO games (id, title, description, price, category, launch_date, publisher_id)
VALUES (uuid_generate_v4(), 'Fortnite', 'Battle Royale game by Epic Games', 0.00, 'BATTLE_ROYALE', '2017-09-26',
        (SELECT id FROM publishers WHERE name = 'Epic Games')),
       (uuid_generate_v4(), 'Half-Life 2', 'First-person shooter game by Valve Corporation', 19.99, 'FPS', '2004-11-16',
        (SELECT id FROM publishers WHERE name = 'Valve Corporation')),
       (uuid_generate_v4(), 'The Witcher 3', 'Action RPG by CD Projekt', 49.99, 'RPG', '2015-05-19',
        (SELECT id FROM publishers WHERE name = 'CD Projekt')),
       (uuid_generate_v4(), 'The Legend of Zelda: Breath of the Wild', 'Action-adventure game by Nintendo', 59.99,
        'ADVENTURE', '2017-03-03', (SELECT id FROM publishers WHERE name = 'Nintendo')),
       (uuid_generate_v4(), 'Final Fantasy XV', 'Action RPG by Square Enix', 39.99, 'RPG', '2016-11-29',
        (SELECT id FROM publishers WHERE name = 'Square Enix'));
