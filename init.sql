create database if not exists demo;
drop table if exists demo.users;
CREATE TABLE if not exists demo.users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL
);