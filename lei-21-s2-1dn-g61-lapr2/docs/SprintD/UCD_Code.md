@startuml
left to right direction
actor "Administrator" as ad
actor "Client" as cl
actor "Receptionist" as rc
actor "Laboratory Coordinator" as lc
actor "Specialist Doctor" as sd
actor "Clinical Chemistry Technologist" as cct
actor "Medical Lab Technician" as mlt
actor "Timer" as ti

rectangle system {
  usecase "UC2,UC6,UC13,UC17: Check the results" as UC
  usecase "UC3 : Register a client" as UC3
  usecase "UC4 : Register a test" as UC4
  usecase "UC5 : Record the sample" as UC5
  usecase "UC1 : Record the results of the chemical analysis" as UC1
  usecase "UC7 : Register a new employee" as UC7
  usecase "UC8 : Register a new Clinical analysis laboratory" as UC8
  usecase "UC9 : Specify a new type of test and its collecting methods" as UC9
  usecase "UC10 : Specify a new test parameter and categorize it" as UC10
  usecase "UC11 : Specify a new parameter category" as UC11
  usecase "UC15 : Validate the work" as UC15
  usecase "UC18 : Consult the results" as UC18
  usecase "UC12 : Summarize and report Covid-19 data" as UC12
  usecase "UC16 : Generate daily automatic reports about covid-19" as UC16
  usecase "UC14 : Write a report and diagnosis" as UC14

}

mlt --> UC5
rc --> UC4
rc --> UC3
mlt --> UC
cct --> UC1
cct --> UC
ad --> UC7
ad --> UC8
ad --> UC9
ad --> UC10
ad --> UC11
lc --> UC15
lc --> UC
cl --> UC18
ad --> UC12
ti --> UC16
sd --> UC
sd --> UC14
@enduml
