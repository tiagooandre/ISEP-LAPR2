@startuml
title Relationships - Class Diagram

class Company {
    String designation;
}
class NHSAPI
class Test {
    String code;
    String NHSCode;
    String description;
}
class NHSReport {
	String text;
}
class NHS
class AutoReportNHS


Company "1" -- "*" Test: performs >
Company "1" -- "1" AutoReportNHS: activates >
AutoReportNHS "1" -- "1" NHSAPI: calls >
Company "1" -- "1" NHSAPI: uses >
NHS "1" -- "1" NHSAPI: distributes >
NHS "1" -- "*" NHSReport: wants >
NHSAPI "1" -- "*" NHSReport: generates >
@enduml