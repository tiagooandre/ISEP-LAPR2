# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_
_are common across several US/UC;_
_are not related to US/UC, namely: Audit, Reporting and Security._

- Users must be authenticated with a password holding seven alphanumeric characters, 
 including three capital letters and two digits

- Only the specialist doctor is allowed to access all client data

- Many Labs has the exclusivity to perform Covid-19 tests


## Usability

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

- At least two sorting algorithms should be evaluated and 
 documented in the application user manual
 
 - The user interface must be simple, intuitive and consistent.


## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._
- The system should not fail more than 5 days in one year. Whenever the system fails, there should be no data loss.

## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._
- Any interface between a user and the system shall have a maximum response time of 3 seconds. The system should start up in less than 10 seconds.

## Supportability 
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._

- The application must support the English language only

- Despite being out of scope, the system should be developed having in mind the need to easily support other kinds of tests

- The ordering algorithm to be used by the application must be defined through a configuration file.

- The development team must implement unit tests for all methods except methods that implement Input/Output operations.

- The application should run on all platforms for which there exists a Java Virtual Machine.

## +
### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._

- The application must be developed in Java language (programming language)

- The application graphical interface is to be developed in JavaFX 11 (development tools)

- Adopt the best practices for identifying requirements

- Adopt the best practices for Object Oriented software analysis and design (mandatory standards/patterns)


### Implementation Constraints

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

- Adopt recognized coding standards

- The IDE should be IntelliJ or Netbeans

- Should be used Javadoc to generate useful documentation for Java code

- The unit tests should be implemented using the JUnit 4 Framework

- To generate the coverage report should be used the JaCoCo plugin

- All the images/figures produced during the software development process should be recorded in SVG format

- During system development, the team must adopt recognized coding standards (e.g., CamelCase)


### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._

- Samples are given a barcode that is automatically generated using an external API

- The company generates daily  reports with all the information demanded by the NHS and should send them to the NHS using their API

### Physical Constraints
_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

- The application will be deployed to a machine with 8GB of RAM.