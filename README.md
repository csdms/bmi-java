[![Maven CI](https://github.com/csdms/bmi-java/actions/workflows/maven.yml/badge.svg)](https://github.com/csdms/bmi-java/actions/workflows/maven.yml)

# bmi-java

Java bindings for the CSDMS [Basic Model Interface](https://bmi.readthedocs.io).

## Build/Install

The Java BMI bindings can be built on Linux, macOS, and Windows. Instructions are given below.

**Prerequisites:**
* A Java compiler
* [Maven](http://maven.apache.org)

To compile and package the BMI Java bindings, run

    $ mvn clean package

This will generate files in the directory `target`. The result will look like
```bash
target
|-- bmi.jar
|-- classes
|   `-- edu
|       `-- colorado
|           `-- csdms
|               `-- bmi
|                   |-- BMI.class
|                   |-- BmiControl.class
|                   |-- BmiGetter.class
|                   |-- BmiGrid.class
|                   |-- BmiGridRectilinear.class
|                   |-- BmiGridStructuredQuad.class
|                   |-- BmiGridUniformRectilinear.class
|                   |-- BmiGridUnstructured.class
|                   |-- BmiInfo.class
|                   |-- BmiSetter.class
|                   |-- BmiTime.class
|                   `-- BmiVars.class
|-- generated-sources
|   `-- annotations
|-- maven-archiver
|   `-- pom.properties
`-- maven-status
    `-- maven-compiler-plugin
        `-- compile
            `-- default-compile
                |-- createdFiles.lst
                `-- inputFiles.lst
```

To install the jar file to your local Maven repository for use with other packages, run

    $ mvn install

## Use

To write a BMI for a model,
install the `bmi.jar` file and implement all the BMI functions
that are listed in the BMI Java [source package](https://github.com/csdms/bmi-java/tree/master/src/main/java/edu/colorado/csdms/bmi)
and described in the [documentation](https://bmi.readthedocs.io).
BMI functions that aren't used
(e.g., `getGridX` for a uniform rectilinear grid)
can simply return a `null` value.
A sample implementation is given in the
https://github.com/csdms/bmi-example-java
repository.
