#!/usr/bin/env bash

cd core-service/
mvn spring-boot:run
cd ..

cd auth-service/
mvn spring-boot:run
cd ..

cd user-service/
mvn spring-boot:run
cd ..

cd blog-service/
mvn spring-boot:run
cd ..

cd auth-service/
mvn spring-boot:run
cd ..

cd notification-service/
mvn spring-boot:run
cd ..