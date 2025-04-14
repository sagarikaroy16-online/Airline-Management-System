
create database airlinemanagementsystem;



use airlinemanagementsystem;


create table login(username varchar(20), password varchar(20));
show tables;

insert into login values('admin', 'admin');
drop table login;
select * from login;

create table passenger (name varchar(20), nationality varchar(20), phone varchar(15), address varchar(50), aadhar varchar(20), mail varchar(20), gender varchar(20));
select * from passenger;

create table flight(f_code varchar(20), f_name varchar(20), source varchar(40), destination varchar(40));
describe flight;

insert into flight values("1001", "AI-1212", "Delhi", "Mumbai");
insert into flight values("1002", "AI-1453", "Delhi", "Goa");
insert into flight values("1003", "AI-1112", "Mumbai", "Chennai");
insert into flight values("1004", "AI-3222", "Delhi", "Amritsar");
insert into flight values("1005", "AI-1212", "Delhi", "Kolkata");

select * from flight;
drop table flight;

create table reservation(PNR varchar(15), TICKET varchar(20), aadhar varchar(20), name varchar(20), nationality varchar(30), address varchar(50), gender varchar(20), 
						contact int, mail varchar(20),  flight_name varchar(15), flight_code varchar(20), source varchar(30), destination varchar(30), Date varchar(30));

drop table reservation;
select * from reservation;

create table cancel(pnr varchar(20), name varchar(40), cancelno varchar(20), fcode varchar(20), ddate varchar(30));

