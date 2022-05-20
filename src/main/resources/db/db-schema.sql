DROP TABLE IF EXISTS daily_questions;

CREATE TABLE daily_questions (
                         id SERIAL PRIMARY KEY NOT NULL,
                         question VARCHAR(500) NOT NULL
);

DROP TABLE IF EXISTS public_questions;

CREATE TABLE public_questions (
                        id SERIAL PRIMARY KEY NOT NULL,
                        date DATE NOT NULL,
                        question VARCHAR(500) NOT NULL
);

DROP TABLE IF EXISTS users;

CREATE TABLE users (
                        id SERIAL PRIMARY KEY NOT NULL,
                        username VARCHAR(50) NOT NULL,
                        name VARCHAR(15) NOT NULL,
                        email VARCHAR(60) NOT NULL,
                        city VARCHAR(15),
                        password VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS answer_card;

CREATE TABLE answer_card (
                        id SERIAL PRIMARY KEY NOT NULL,
                        user_id BIGINT REFERENCES users(id),
                        day_number INT NOT NULL,
                        difficulty INT NOT NULL,
                        fulfillment INT NOT NULL,
                        motivation INT NOT NULL,
                        question SERIAL REFERENCES daily_questions(id),
                        answer VARCHAR(600)
);