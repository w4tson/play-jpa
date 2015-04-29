#Play JPA Example

The goal of this Play! sample is to demonstrate a REST API your grandad would be proud of. Features include JPA backed by
Oracle DB & Swagger integration.

##Switching database to Oracle

* Uncomment the relevant bits on the [application.conf](conf/application.conf)
* Put your Oracle connection details or use [Docker](https://www.docker.com) to spin up a local instance
  + `docker pull wnameless/oracle-xe-11g`
  + `docker run -d -p 49160:22 -p 49161:1521 wnameless/oracle-xe-11g`
  + `ssh -p 49160 root@$(boot2docker ip)` (password is admin)
  + `sqlplus system/oracle`
  + Create the play_evolutions table described in the [oracle_evolutions.sql](conf/evolutions/oracle_evolutions.sql) script
