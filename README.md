[![Build Status](https://travis-ci.org/rkovtiuk/BlogMS.svg?branch=master)](https://travis-ci.org/rkovtiuk/BlogMS)

# BlobMS 

### Description

There is a sample application
[here](https://github.com/rkovtiuk/blog-ms/). It
is a Spring Boot application so you can run it using the usual
mechanisms (for instance "mvn spring-boot:run"). When it runs it will
look for the config server on http://localhost:8888 by default, so
you could run the server as well to see it all working together.

The sample has a test case where the config server is also started in
the same JVM (with a different port), and the test asserts that an
environment property from the git configuration repo is present. To
change the location of the config server just set
"spring.cloud.config.uri" in "bootstrap.yml" (or via System
properties etc.).

The test case has a `main()` method that runs the server in the same
way (watch the logs for its port), so you can run the whole system in
one process and play with it (e.g. right click on the main in your IDE
and run it). The `main()` method uses `target/config` for the working
directory of the git repository, so you can make local changes there
and see them reflected in the running app.


### On local machine

Simple method to start the service:

```
$ cd 'spring-service'
$ mvn spring-boot:run
```
For start all the service you can execute `start_all.sh`.

The server is a Spring Boot application so you can run it from your
IDE instead if you prefer (the main class is
`ConfigServerApplication`). 

### On docker
Running using Docker is even simpler, assuming that docker-compose 
and docker are installed on your box, just run the following:

Build the docker images for the microservices
```
mvn clean package docker:build
```
Start up Docker containers
```
docker-compose up
```

#### [author](https://github.com/rkovtiuk)

