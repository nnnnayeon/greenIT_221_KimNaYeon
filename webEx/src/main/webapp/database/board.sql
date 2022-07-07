create database firstJsp;

create table board(
	`no` int not null,
    `code` int primary key,
    title varchar(100) not null,
    contents varchar(4000) not null,
    viewCnt int default 0,
    likeCnt int default 0,
	createdAt datetime,
    modifiedAt datetime
);

select * from firstjsp.board;