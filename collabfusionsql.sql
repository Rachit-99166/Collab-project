use collabfusion;
select * from users;
CREATE TABLE clients (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    contributor_name VARCHAR(100) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    publisher_name VARCHAR(100) NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO clients(title, contributor_name, email, publisher_name) 
VALUES 
('E-Commerce Platform', 'John', 'john@gmail.com','Rachit Dua'),
('School management Platform', 'Raj', 'Raj@gmail.com','Rachit Dua');