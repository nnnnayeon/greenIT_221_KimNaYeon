create database book;

use book;
create table user(
	id varchar(20) unique not null,
    pw varchar(20) not null,
    `name` varchar(20) not null,
    usercode smallint(8) primary key,
    `point` int default 1000,
    address varchar(500)
);

create table dibsBook(
	title varchar(500) not null,
    thumbnail varchar(500) not null,
    isbn varchar(20) primary key,
    usercode int,
    authors varchar(20),
    createAt datetime
);

select * from user;