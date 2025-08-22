show databases;

USE universitymanagementsystem;

CREATE TABLE feestructure (
    degree VARCHAR(100),
    fullfee VARCHAR(100),
    semesterfee VARCHAR(100)
);

INSERT INTO feestructure (degree, fullfee, semesterfee) VALUES 
('B.Tech', '400000', '50000'),
('M.Tech', '480000', '60000'),
('B.Sc', '560000', '70000'),
('M.Sc', '640000', '80000'),
('Ph.D', '720000', '90000');


SELECT * FROM universitymanagementsystem.feestructure;
