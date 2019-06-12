/**
/*******************************************************************************
   Drop database if it exists
********************************************************************************/

DROP USER projectTwo CASCADE;

/*******************************************************************************
   Create database
********************************************************************************/


CREATE USER projectTwo
IDENTIFIED BY password
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to projectTwo;
GRANT resource to projectTwo;
GRANT create session TO projectTwo;
GRANT create table TO projectTwo;
GRANT create view TO projectTwo;

conn project2/password
create sequence users_seq;

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
create table availibility(
	id number not null,
	user_id number not null,
	date_id number not null,
	start_time number default 0,
	end_time number default 0,
	CONSTRAINT availibility_pk PRIMARY KEY (id)
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

ALTER TABLE availibility ADD CONSTRAINT FK_enployeeid
    FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE availibility ADD CONSTRAINT FK_avilibilitDateid
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
create sequence product_seq;


/*******************************************************************************
   Manually inserted table entries
********************************************************************************/


insert into USERS(id, username, password, fname, lname, title, phone_number, email)
values(1, 'user', 'pass', 'firstname', 'lastname', 0, '111-1111', 'email@email.com');

commit;
exit;
