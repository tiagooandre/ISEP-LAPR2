@startuml
title Relationships - Class Diagram

class Employee {
    String employeeID;
    String name;
    String adress;
    String phoneNumber;
    String codeSOC;
}
class ParameterCategory {
    String code;
    string description;
    String NHSID;
}
class Company {
    String designation;
}
class Parameter {
	String designation;
  String code;
}
class Administrator


Parameter "*" -- "1" Administrator: specifies a new <
ParameterCategory "*" -- "1" Administrator: created by >
Company "1" -- "*" ParameterCategory: adopts >
Company "1" -- "*" Parameter: capable of analysing >
Company "1" -- "*" Employee: has >
Employee "1" <|-- "*" Administrator
Parameter "*" -- "1" ParameterCategory: presented under >
@enduml