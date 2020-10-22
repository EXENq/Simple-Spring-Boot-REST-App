create table if not exists customers
(
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   first_name VARCHAR (50) not NULL,
   last_name varchar (100) not null,
   address varchar (1000) not null,
   budget decimal not null
);