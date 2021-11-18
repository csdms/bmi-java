[![Maven CI](https://github.com/csdms/bmi-java/actions/workflows/maven.yml/badge.svg)](https://github.com/csdms/bmi-java/actions/workflows/maven.yml)

# bmi-java

Java bindings for the Basic Model Interface. You'll need to install [Maven](http://maven.apache.org) to build and run tests.

## Build

To compile the BMI Java bindings and run the JUnit tests in `src/test/java`, run

    $ mvn test

## Create the bmi-java jar

    $ mvn package

This will generate a jar file at `target/bmi-java.jar`.

## Build javadocs

    $ mvn javadoc:javadoc
    
This will generate javadocs at `target/site/apidocs`. See the [Maven Javadoc Plugin](https://maven.apache.org/plugins/maven-javadoc-plugin/usage.html) for more details.
