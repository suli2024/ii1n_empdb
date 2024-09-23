create database surubt
collate utf8_hungarian_ci
character set utf8;

grant all privileges
on surubt.*
to surubt@localhost
identified by 'titok';

use surubt;

create table employees(
    id int not null primary key auto_increment,
    name varchar(50),
    city varchar(50),
    salary double
);

