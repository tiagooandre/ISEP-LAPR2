@startuml
title Relationships - Class Diagram

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

class Email {
  String email;
}

Company "1" -- "*" Client: have >
User "1" -- "1" Email: has >
@enduml