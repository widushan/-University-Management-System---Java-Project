create database universitymanagementsystem;

show databases;

USE universitymanagementsystem;

CREATE TABLE login (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

INSERT INTO login (username, password) VALUES ('admin', '12345');


select * from login;

show tables;


