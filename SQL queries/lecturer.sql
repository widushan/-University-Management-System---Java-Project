show databases;

USE universitymanagementsystem;

CREATE TABLE lecturer (
    name VARCHAR(100),
    address VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(50),
    nic VARCHAR(20),
    lecno VARCHAR(20),
    doservice VARCHAR(40),
    department VARCHAR(100),
    module1 VARCHAR(100),
    module2 VARCHAR(100),
    module3 VARCHAR(100),
    module4 VARCHAR(100)
);

select * from lecturer;