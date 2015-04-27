#Play JPA Example

The goal of this Play! sample is to demonstrate a REST API your grandad would be proud of. Features include JPA backed by
Oracle DB & Swagger integration.

##Prerequisites

* A running Oracle database. 
  + Oh boy! [Docker](https://www.docker.com) to the rescue, run `docker pull wnameless/oracle-xe-11g`
  + `docker run -d -p 49160:22 -p 49161:1521 wnameless/oracle-xe-11g`
  + `ssh -p 49160 root@$(boot2docker ip)` (password is admin)
  + `sqlplus system/oracle`
  + Create the play_evolutions table described in the [oracle_evolutions.sql](conf/evolutions/oracle_evolutions.sql) script
