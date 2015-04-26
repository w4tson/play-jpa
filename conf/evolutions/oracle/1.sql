# Users schema
 
# --- !Ups
 

CREATE TABLE users (
  id NUMBER(5) PRIMARY KEY, 
  name VARCHAR2(120),
  login VARCHAR2(75) NOT NULL,
  password VARCHAR2(75) NOT NULL
 );

CREATE SEQUENCE user_seq
      INCREMENT BY 1
      START WITH 1
      NOMAXVALUE
      NOCYCLE
      CACHE 10;

insert into users values (user_seq.nextval, 'John Lennon', 'jlennon', 'yoko');
insert into users values (user_seq.nextval, 'Paul McCartney', 'macca', 'doooo');
insert into users values (user_seq.nextval, 'George Harrison', 'gharrison', 'patty');
insert into users values (user_seq.nextval, 'Ringo Starr', 'ringo', 'octopus');
 
# --- !Downs
 
DROP TABLE users;
drop SEQUENCE user_seq;