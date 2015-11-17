[![Build Status](https://travis-ci.org/csdms/bmi-java.svg?branch=master)](https://travis-ci.org/csdms/bmi-java)

# bmi-java

Java bindings for the Basic Model Interface.

## Build

To build the BMI Java bindings and tests:

    $ ant build

The resulting `*.class` files
are written, by default, to the **build** directory.
The location of this directory can be configured by editing
the Ant build file, **build.xml**.

To run the `Heat` example:

    $ java -cp ./build edu.colorado.csdms.heat.Heat

The complete set of JUnit tests can be built and run with:

    $ ant test
