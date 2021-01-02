/*
H2 Console: http://localhost:8080/h2-console
I set application port as 8897 so, URL: http://localhost:8897/h2-console
user: sa
pwd: no pwd

JDBC URL: jdbc:h2:mem:testdb

it will run below statement when you run applicaiton in console log
Hibernate: create sequence hibernate_sequence start with 1 increment by 1
Hibernate: create table aarav (id1 bigint not null, first_name1 varchar(30) not null, last_name1 varchar(30) not null, user_name1 varchar(30) not null, primary key (id1))
Hibernate: create table employee (empid bigint not null, department varchar(30) not null, email varchar(30) not null, emp_name varchar(30) not null, joined_on timestamp not null, promoted_on timestamp not null, manager_id bigint, salary bigint not null, shift_endtime varchar(30) not null, shift_starttime varchar(30) not null, primary key (empid))
Hibernate: create table orders (orderid bigint not null, orderdescription varchar(255), user_userid bigint, primary key (orderid))
Hibernate: create table user (userid bigint not null, email_address varchar(30) not null, first_name varchar(30), last_name varchar(30), role varchar(30) not null, ssn varchar(40) not null, user_name varchar(30) not null, primary key (userid))
Hibernate: alter table aarav add constraint UK_gna3p5nixjexm8pdujx319jq9 unique (user_name1)
Hibernate: alter table employee add constraint UK_fopic1oh5oln2khj8eat6ino0 unique (email)
Hibernate: alter table user add constraint UK_o14ahnprxuevixmhn8cg59s4d unique (ssn)
Hibernate: alter table user add constraint UK_lqjrcobrh9jc8wpcar64q1bfh unique (user_name)
Hibernate: alter table orders add constraint FK4ccl69s4ridbw2x4ufpoanndh foreign key (user_userid) references user

Create data.sql in src/main/resources
- Note: Columns will be created in Alphabetical order in DB except primary Key Id
- Note: So insert statement values should be in alphabetical order as 
displayed in H2 DB or write insert statements with column names for User table too.
*/

insert into user values(101, 'apatel@Devisolutions.com', 'Avirat', 'Patel', 'admin', 'ssn00001', 'apatel');
insert into user values(122, 'spatel@Devisolutions.com', 'Smruti', 'Patel', 'business', 'ssn00002', 'spatel');
insert into user values(123, 'aapatel@Devisolutions.com', 'Aarav', 'Patel', 'business', 'ssn00003', 'aapatel');


insert into orders(orderid, orderdescription, user_userid) 
 values(2001, 'order 11', 101);
insert into orders(orderid, orderdescription, user_userid) 
 values(2002, 'order 12', 101);
insert into orders(orderid, orderdescription, user_userid) 
 values(2003, 'order 13', 101);

insert into orders(orderid, orderdescription, user_userid) 
 values(2004, 'order 21', 122);
insert into orders(orderid, orderdescription, user_userid) 
 values(2005, 'order 22', 122);
 
insert into orders(orderid, orderdescription, user_userid) 
 values(123, 'order 31', 123);
 
 
 insert into employee(empid, department, email, emp_name, joined_on, promoted_on, manager_id , salary, shift_starttime, shift_endtime)
 values(1001, 'IT', 'avirat.patel@gmail.com', 'Avirat Patel', TO_TIMESTAMP('26-JUN-2013 00:00:00'), TO_TIMESTAMP('26-JUN-2021 00:00:00'), 1000, 4000000, '08:30', '16:30');

insert into employee(empid, department, email, emp_name, joined_on, promoted_on, manager_id , salary, shift_starttime, shift_endtime)
 values(1002, 'IT', 'Pranav.Pandya@gmail.com', 'Pranav Pandya', TO_TIMESTAMP('26-AUG-2013 00:00:00'), TO_TIMESTAMP('26-AUG-2021 00:00:00'), 1001, 4000000, '08:30', '16:30');

insert into employee(empid, department, email, emp_name, joined_on, promoted_on, manager_id , salary, shift_starttime, shift_endtime)
 values(1003, 'IT', 'samik.shah@gmail.com', 'Samik Shah', TO_TIMESTAMP('20-JUN-2014 00:00:00'), TO_TIMESTAMP('22-JUN-2021 00:00:00'), 1001, 4000000, '08:30', '16:30');

 