#!/usr/bin/env bash

# something wrong
#mvn -f user-service/pom.xml spring-boot:run
#mvn -f user-notification/pom.xml spring-boot:run
#mvn -f user-dashboard/pom.xml spring-boot:run


cd user-service
mvn spring-boot:run
cd ..
cd user-notification
mvn spring-boot:run
cd ..
cd user-dashboard
mvn spring-boot:run
cd ..
