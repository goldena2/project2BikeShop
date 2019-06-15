/*******************************************************************************
   Drop Tables
********************************************************************************/
drop table users CASCADE CONSTRAINTS;
drop table title CASCADE CONSTRAINTS;
drop table product CASCADE CONSTRAINTS;
drop table image CASCADE CONSTRAINTS;
drop table invoice CASCADE CONSTRAINTS;
drop table invoice_line CASCADE CONSTRAINTS;
drop table availability CASCADE CONSTRAINTS;
drop table day_of_week CASCADE CONSTRAINTS;
drop table shift CASCADE CONSTRAINTS;
drop table schedule CASCADE CONSTRAINTS;
drop table services CASCADE CONSTRAINTS;
drop table product_type CASCADE CONSTRAINTS;

drop sequence users_seq;
drop sequence product_seq;
drop sequence invoice_seq;
drop sequence availability_seq;
drop sequence shift_seq;
drop sequence schedule_seq;
drop sequence services_seq;
/*******************************************************************************
   Create Tables
********************************************************************************/
create table users(
	id number not null,
	username VARCHAR(20) not NULL,
	password VARCHAR(20) not NULL,
	fname VARCHAR(20) not NULL,
	lname VARCHAR(20) not NULL,
	title number not null,
	phone_number VARCHAR(16),
	email VARCHAR(32),
	CONSTRAINT user_pk PRIMARY KEY (id)
);

create table title(
	id number not null,
	title varchar(16) not null,
	CONSTRAINT title_pk PRIMARY KEY (id)
);

create table product(
	id number not null,
	name varchar(16) not null,
	upc varchar(24) not null,
	price number not null,
	description varchar(64) not null,
	stock number,
    type_id number,
	CONSTRAINT product_pk PRIMARY KEY (id)
);

create table image(
	product_id number not null,
	image varchar(32)
);

create table invoice(
	id number not null,
	user_id number not null,
	total_cost number not null,
	CONSTRAINT invoice_pk PRIMARY KEY (id)
);

create table invoice_line(
	invoice_id number not null,
	product_id number not null,
	quantity number not null
);

-- start and end time are caculated in 24 hour format the numbers are the minutes past midnight so 01:00 = 60, 02:30 = 150
create table availability(
	id number not null,
	user_id number not null,
	date_id number not null,
	start_time number default 0,
	end_time number default 0,
	CONSTRAINT availability_pk PRIMARY KEY (id)
);

create table services(
	id number not null,
	description varchar(1024),
	user_id number not null,
	day varchar(12),
	appointment_time number,
	CONSTRAINT services_pk PRIMARY KEY (id)
);

create table day_of_week(
	id number not null,
	day_of_the_week varchar(16) not null,
	CONSTRAINT date_pk PRIMARY KEY (id)
);

create table shift(
	id number not null,
	user_id number not null,
	start_time number default 0,
	end_time number default 0,
	date_id number not null,
	schedule_id number not null,
	CONSTRAINT shift_pk PRIMARY KEY (id)
);

create table schedule(
	id number not null,
	start_date date not null,
	end_date date not null,
	CONSTRAINT schedule_pk PRIMARY KEY (id)
);

create table product_type(
    id number not null,
    type varchar2(50) not null,
    CONSTRAINT product_type_pk PRIMARY KEY (id)
);

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
ALTER TABLE users ADD CONSTRAINT FK_titleid
    FOREIGN KEY (title) REFERENCES title (id);

ALTER TABLE image ADD CONSTRAINT FK_productid
    FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE invoice ADD CONSTRAINT FK_userid
    FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE invoice_line ADD CONSTRAINT FK_invoiceid
    FOREIGN KEY (invoice_id) REFERENCES invoice (id);

ALTER TABLE invoice_line ADD CONSTRAINT FK_invoiceProductid
    FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE availability ADD CONSTRAINT FK_enployeeid
    FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE availability ADD CONSTRAINT FK_avilibilitDateid
    FOREIGN KEY (date_id) REFERENCES day_of_week (id);

ALTER TABLE shift ADD CONSTRAINT FK_userShiftid
    FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE shift ADD CONSTRAINT FK_shiftDateid
    FOREIGN KEY (schedule_id) REFERENCES schedule (id);

ALTER TABLE shift ADD CONSTRAINT FK_dayid
    FOREIGN KEY (date_id) REFERENCES day_of_week (id);

/*******************************************************************************
Creating the Sequences
********************************************************************************/
create sequence users_seq;
create sequence product_seq;
create sequence invoice_seq;
create sequence availability_seq;
create sequence shift_seq;
create sequence schedule_seq;
create sequence services_seq;

/*******************************************************************************
   Manually inserted table entries
********************************************************************************/
insert into TITLE(id, title)
values(1, 'non-employee');
insert into TITLE(id, title)
values(2, 'employee');
insert into TITLE(id, title)
values(3, 'manager');

insert into USERS(id, username, password, fname, lname, title, phone_number, email)
values(1, 'user', 'pass', 'firstname', 'lastname', 1, '111-1111', 'email@email.com');
insert into USERS(id, username, password, fname, lname, title, phone_number, email)
values(2, 'emp', 'pass', 'empFN', 'empLN', 2, '222-2222', 'email@email.com');
insert into USERS(id, username, password, fname, lname, title, phone_number, email)
values(3, 'man', 'pass', 'manFN', 'manLN', 3, '333-3333', 'email@email.com');

insert into day_of_week(id, day_of_the_week)
values(1, 'monday');
insert into day_of_week(id, day_of_the_week)
values(2, 'tuesday');
insert into day_of_week(id, day_of_the_week)
values(3, 'wednesday');
insert into day_of_week(id, day_of_the_week)
values(4, 'thursday');
insert into day_of_week(id, day_of_the_week)
values(5, 'friday');
insert into day_of_week(id, day_of_the_week)
values(6, 'saturday');
insert into day_of_week(id, day_of_the_week)
values(7, 'sunday');

insert into product_type(id, type)
values(1, 'bike');
insert into product_type(id, type)
values(2, 'part');
insert into product_type(id, type)
values(3, 'other');

insert into product(id, name, upc, price, description, stock, type_id)
values(1,'Mountain Bike', '1 22222 33333 4', 500, 'A generic mountain bike', 5, 1);
insert into product(id, name, upc, price, description, stock, type_id)
values(2,'Road Bike', '5 66666 77777 8', 300, 'A generic road bike', 3, 1);
insert into product(id, name, upc, price, description, stock, type_id)
values(3,'Tire Pump', '1 11111 11111 1', 25, 'Inflates tires.', 10, 3);

commit;
exit;
