# flexible-calculator

Current version: 0.0.1
This repository implements a Flexible Calculator which can do basic operations like ADD, SUBTRACT, MULTIPLY, DIVIDE

## Design 

The pupose of the task is to implement the Calculation which can be extended for new operations.

Currently supported operations are addition, subtraction, multiplication and division.

* Implementation uses the **factory** design pattern to get an instance of the correct operation. 
* validations are handled by Validator class and can be extended for validation per operation
* Results are always derived as BigDecimal and converted to either one of below implemented using NumberParser.
** BigInteger - in cases where both input and result are Whole Numbers
** BigDecimal - other scenarios

### New Additions

* New Additions can be achieved by add the operation on the Enum and add a entry for the same in the factory.
* However it could be improved by config based by using Spring where factories could be configured and modified as needed.

## Build

Project uses maven to build and running the application

```
mvn clean install
```

Tests could be either run through maven or through IDE like IntelliJ or Eclipse

## Usage

To use as a maven dependency use for any of the projects use. Please note that the project is not deployed in a artifactory and may require to be built before using.

``
<dependency>
    <groupId>com.senthil.interview</groupId>
    <artifactId>flexible-calculator</artifactId>
    <version>0.0.1</version>
  </dependency>
``

## Scope for Improvements 

** Using IOC container (ex. Spring) can remove the need to modify the Factory class and can be controlled by adding the operation and modifying the Spring configuration.
