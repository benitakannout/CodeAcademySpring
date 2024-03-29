INSERT INTO daily_questions (question)
VALUES ('Write a motivational mantra to repeat each day.'),
       ('Why is this habit a priority for me?'),
       ('What one word do I associate with my habit? Reflect on it.'),
       ('How will this new habit improve my daily life?'),
       ('What is my ultimate "why"?'),
       ('What time of the day is easiest for me to commit to my new habit?'),
       ('Write a motivational note from the perspective of your future self'),
       ('What was the main thing blocking me from adopting this habit in the past?'),
       ('What one thing can I do to make my habit more fun?'),
       ('What is the most rewarding thing about committing to my habit?'),
       ('How does my new habit make me a better person?');

INSERT INTO users (username, name, email, city, password)
VALUES ('user1', 'Vardenis', 'vardenis@test.lt', 'Vilnius', '$2y$10$YNNox.S1CJ/L.PEvz.kr4.cY95nFQqO5QRvyzPE4ZtSQcJ0rJKuHW');

INSERT INTO answer_card (user_id, difficulty, fulfillment, motivation, question, answer)
VALUES (1, 3, 5, 4, 1, 'My mind is peaceful');

INSERT INTO public_questions (question)
VALUES ('What is the most memorable compliment that you have ever gotten?'),
       ('How did you practice self-care this week?'),
       ('When was the last time you stepped out of your comfort zone?');

INSERT INTO public_comments (question, user_id, comment)
VALUES (1, 1, 'That I am inspiring'),
       (2, 1, 'I went to get a massage'),
       (2, 1, 'I wrote in my gratitude journal');