@startuml
title Relationships - Class Diagram

class Employee {
    String employeeID;
    String name;
    String adress;
    String phoneNumber;
    String codeSOC;
}

class Barcode

class Client {
    String citizenCardNumber;
    String numberNHS;
    String numberTIN;
    String birthDate;
    string sex;
    String phoneNumber;
    string name;
}

class Company {
    String designation;
}

class TestType {
    String designation;
    String code;
    String collectingMethods;
}

class Parameter {
	String designation;
  String code;
}

class TestParameter {
    Parameter testedParameter;
    TestParameterResult testResult;
}

class ReferenceValue

class TestParameterResult{
     String value;
     String metric;
     Date createdAt;
     ReferenceValue refValue;
}

interface ExternalModule

class ExternalModuleAdapter1

class ExternalModuleAdapter2

class ExternalModuleAdapter3

class Test {
    String code;
    String NHSCode;
    String testResult
    String dateSample;
    String timeSmaple;
    String dateChemAnalysis;
    String timeChemAnalysis;
    String dateDiagnosis;
    String timeDiagnosis;
    String dateValidTest;
    String timeValidTest;
}

class Sample

class ChemicalLaboratory

class ClinicalChemistryTechnologist

class ChemicalAnalysis

Parameter "*" -- "1" Administrator: specifies a new <
ChemicalAnalysis "1" -- "*" Sample: uses >
ChemicalLaboratory "1" -- "*" ChemicalAnalysis: performs >
Client "1" -- "*" Test: does a >
Client "1" -- "*" TestParameter: consults the >
ClinicalChemistryTechnologist "1" -- "*" TestParameter: records >
ClinicalChemistryTechnologist "1" -- "*" ChemicalAnalysis: records the results of the >
Company "1" -- "*" Test: performs >
Company "1" -- "*" Client: have >
Company "1" -- "*" Parameter: capable of analysing >
Company "1" -- "*" TestType: conducts >
Company "1" -- "*" Employee: has >
Employee "1" <|-- "*" ClinicalChemistryTechnologist
ExternalModule "1" <|.. "1" ExternalModuleAdapter1
ExternalModule "1" <|.. "1" ExternalModuleAdapter2
ExternalModule "1" <|.. "1" ExternalModuleAdapter3
ExternalModule "1" -- "*" TestType: makes use of <
Sample "*" -- "1" Test: is from >
Sample "1" -- "1" Barcode: contains >
Test "*" -- "1" Client: requested by >
Test "1" -- "1" TestType: is of >
Test "1" -- "1..*" TestParameter: has >
TestType "*" -- "1" Administrator: specifies a new <
TestType "*" -- "*"  ParameterCategory: measure by >
TestParameterResult "1" -- "1" TestParameter: has <
TestParameterResult "1" -- "1" ReferenceValue: records >
TestParameter "*" -- "1" Parameter: refers to <
@enduml