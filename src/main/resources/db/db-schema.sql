DROP TABLE IF EXISTS daily_questions;

CREATE TABLE daily_questions (
                         id SERIAL PRIMARY KEY NOT NULL,
                         question VARCHAR(500) NOT NULL
);

DROP TABLE IF EXISTS public_questions;

CREATE TABLE public_questions (
                        id SERIAL PRIMARY KEY NOT NULL,
                        question VARCHAR(500) NOT NULL
);

DROP TABLE IF EXISTS users;

CREATE TABLE users (
                        id SERIAL PRIMARY KEY NOT NULL,
                        username VARCHAR(50) NOT NULL UNIQUE,
                        name VARCHAR(15) NOT NULL,
                        email VARCHAR(60) NOT NULL,
                        city VARCHAR(15),
                        password VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS answer_card;

CREATE TABLE answer_card (
                        id SERIAL PRIMARY KEY NOT NULL,
                        user_id INT REFERENCES users(id),
                        difficulty INT NOT NULL,
                        fulfillment INT NOT NULL,
                        motivation INT NOT NULL,
                        question SERIAL REFERENCES daily_questions(id),
                        answer VARCHAR(600)
);

DROP TABLE IF EXISTS public_comments;

CREATE TABLE public_comments (
                                  id SERIAL PRIMARY KEY NOT NULL,
                                  question INT REFERENCES public_questions(id),
                                  user_id INT REFERENCES users(id),
                                  comment VARCHAR(500) NOT NULL
);