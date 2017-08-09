#!/usr/bin/env bash

cd db-setup/
mvn spring-boot:run
cd ..

cd user-service/
mvn spring-boot:run
cd ..