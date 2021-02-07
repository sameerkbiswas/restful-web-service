-- This fine name should be data.sql to load the data automatically to H2 Database
-- create table user (id integer not null, date_of_birth timestamp, name varchar(255), primary key (id))
-- Started the Id from 101 to work with POST method to save data using without conflicting with hibernate_sequence
INSERT INTO USER VALUES (101, SYSDATE(), 'ABC');
INSERT INTO USER VALUES (102, SYSDATE(), 'PQR');
INSERT INTO USER VALUES (103, SYSDATE(), 'XYZ');
INSERT INTO USER VALUES (104, SYSDATE(), 'Sameer Biswas');
INSERT INTO USER VALUES (105, SYSDATE(), 'Kumar Biswas');
INSERT INTO USER VALUES (106, SYSDATE(), 'Sameer Kumar Biswas');