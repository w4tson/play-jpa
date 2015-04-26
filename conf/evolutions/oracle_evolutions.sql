#this needs creating in an empty oracle db
#because the sql that play auto runs doesn't play with oracle

create table play_evolutions (
id int not null primary key, hash varchar2(255) not null, 
applied_at timestamp not null, 
apply_script CLOB, 
revert_script CLOB, 
state VARCHAR2(255), 
last_problem CLOB
);
#docker run -d -p 49160:22 -p 49161:1521 wnameless/oracle-xe-11g

#ssh -p 49160 root@$(boot2docker ip)
#password = admin
#sqlplus system/oracle
