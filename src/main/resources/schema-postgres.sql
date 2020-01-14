
DROP TABLE IF EXISTS users;
CREATE TABLE users (
id SERIAL PRIMARY KEY,
userid VARCHAR(100),
name VARCHAR(100),
address VARCHAR(250),
contact VARCHAR(20),
deleted boolean default false
);