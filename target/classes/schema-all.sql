DROP table user_entity;

create table user_entity(
id int NOT NULL auto_increment PRIMARY KEY,
user_name varchar(100),
email varchar(100),
address varchar(100) ,
phone_number int
);