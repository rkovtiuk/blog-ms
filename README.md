== Description

There is a sample application
https://github.com/rkovtiuk/BlogMS/[here]. It
is a Spring Boot application so you can run it using the usual
mechanisms (for instance "mvn spring-boot:run"). When it runs it will
look for the config server on "http://localhost:8888" by default, so
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


=== Quick Start

Start the server:

----
$ cd 'spring-service'
$ mvn spring-boot:run
----

The server is a Spring Boot application so you can run it from your
IDE instead if you prefer (the main class is
`ConfigServerApplication`). 



