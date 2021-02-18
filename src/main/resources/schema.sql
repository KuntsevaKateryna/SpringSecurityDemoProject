CREATE TABLE IF NOT EXISTS client (
id INT AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
age INT,
    PRIMARY KEY (id )
);

Create Table IF NOT EXISTS address (
address_index INT,
city VARCHAR(255) NOT NULL,
street VARCHAR(255) NOT NULL,
streetNo INT,
flatNo INT,
client int PRIMARY KEY references client(id ));

Create Table IF NOT EXISTS hobby (
id INT AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
descr VARCHAR(255) NOT NULL,
client int references client(id ),
 PRIMARY KEY (id ));

 Create Table IF NOT EXISTS master (
 id INT AUTO_INCREMENT,
 name VARCHAR(255) NOT NULL,
 specialization VARCHAR(255) NOT NULL,
 PRIMARY KEY (id ));

 Create Table IF NOT EXISTS client_master (
 client INT,
 master INT,
  PRIMARY KEY (client, master));


   Create Table IF NOT EXISTS salon1 (
   id INT AUTO_INCREMENT,
   name VARCHAR(255) NOT NULL,
   PRIMARY KEY (id ));

   Create Table IF NOT EXISTS client_salon (
   client INT,
   salon INT,
    PRIMARY KEY (client, salon));


