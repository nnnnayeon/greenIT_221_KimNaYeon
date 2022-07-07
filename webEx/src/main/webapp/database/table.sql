use firstjsp;

create table users(
	id varchar(20) primary key,
    password varchar(20) not null,
    `name` varchar(40) not null,
    birthdate datetime not null,
    gender varchar(5) not null,
    email varchar(40) not null,
    country varchar(10) not null,
    mobile varchar(13) not null
);

select * from firstjsp.users;