CREATE DATABASE ACP14USER ;

CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(20),
  birth DATE NOT NULL,
  phone VARCHAR (20),
  amount DOUBLE,
  PRIMARY KEY (id)
);

INSERT INTO users(name,birth,phone,amount) VALUES ('Serhii','1997-01-02' ,'+380222222',3000.00);
INSERT INTO users(name,birth,phone,amount) VALUES ('Oleg','1998-02-03' ,'+380333333',4000.00);
INSERT INTO users(name,birth,phone,amount) VALUES ('Ivan','1996-03-04' ,'+380444444',5000.00);
INSERT INTO users(name,birth,phone,amount) VALUES ('Kolia','1995-04-05' ,'+380555555',2000.00);