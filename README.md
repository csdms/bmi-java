[![Build CI](https://github.com/csdms/bmi-java/actions/workflows/build.yml/badge.svg)](https://github.com/csdms/bmi-java/actions/workflows/build.yml)

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

To install the jar file to your local Maven repository
(typically `~/.m2/repository`)
for use with other packages, run

    $ mvn install

The result in the local repository will look like
```bash
edu
`-- colorado
    `-- csdms
        `-- bmi
            |-- 2.0
            |   |-- _remote.repositories
            |   |-- bmi-2.0.jar
            |   |-- bmi-2.0.jar.md5
            |   |-- bmi-2.0.jar.sha1
            |   |-- bmi-2.0.pom
            |   |-- bmi-2.0.pom.md5
            |   `-- bmi-2.0.pom.sha1
            |-- maven-metadata-local.xml
            |-- maven-metadata-local.xml.md5
            `-- maven-metadata-local.xml.sha1

4 directories, 10 files
```

### Developer note: Deploy

The `bmi` package is hosted on the [CSDMS Apache Maven Repository](https://csdms.colorado.edu/repository).
To deploy the `bmi` package to this site, run
```
$ mvn deploy
```
on a machine where you have provided [server settings and encrypted login credentials](http://maven.apache.org/guides/mini/guide-encryption.html#how-to-encrypt-server-passwords)
for the site in your local `settings.xml` file.


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
