/*
H2 Console: http://localhost:8080/h2-console
I set application port as 8897 so, URL: http://localhost:8897/h2-console
JDBC URL: jdbc:h2:mem:testdb

Create data.sql in src/main/resources
- Note: Columns will be created in Alphabetical order in DB except primary Key Id
- Note: So insert statement values should be in alphabetical order as 
displayed in H2 DB or write insert statements with column names for User table too.
*/
insert into user values(101, 'apatel@Devisolutions.com', 'Avirat', 'Patel', 'admin', 'ssn00001', 'apatel');
insert into user values(122, 'spatel@Devisolutions.com', 'Smruti', 'Patel', 'business', 'ssn00002', 'spatel');
insert into user values(123, 'aapatel@Devisolutions.com', 'Aarav', 'Patel', 'business', 'ssn00003', 'aapatel');