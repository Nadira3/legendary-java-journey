# Directory Structure
- main
- test

## Main
The main folder contains the source code for the working application

## Test
The test folder contains test classes for the classes in the main folder. Tests can be run by compiling the dependencies in the `pom.xml` file using maven

```
mvn compile
```
This will install all the necessary dependencies required to build your project and test.
```
mvn test
```
this will run all the tests.
