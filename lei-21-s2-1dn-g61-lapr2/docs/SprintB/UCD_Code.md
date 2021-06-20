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
  usecase "UC4,UC6,UC13,UC17: Check the results" as UC
  usecase "UC3 : Register a client" as UC3
  usecase "UC2 : Register a test" as UC2
  usecase "UC1 : Record the sample" as UC1
  usecase "UC5 : Record the results of the chemical analysis" as UC5
  usecase "UC7 : Register a new employee" as UC7
  usecase "UC8 : Register a new Clinical analysis laboratory" as UC8
  usecase "UC9 : Specify a new type of test and its collecting methods" as UC9
  usecase "UC10 :Specify a new test parameter and categorize it" as UC10
  usecase "UC11 : Specify a new parameter category" as UC11
  usecase "UC12 : Validate the diagnosis" as UC12
  usecase "UC14 : Consult the results" as UC14
  usecase "UC15 : Summarize and report Covid-19 data" as UC15
  usecase "UC16 : Generate daily automatic reports about covid-19" as UC16
  usecase "UC18 : Write a report and diagnosis" as UC18

}

mlt --> UC1
rc --> UC2
rc --> UC3
mlt --> UC
cct --> UC5
cct --> UC
ad --> UC7
ad --> UC8
ad --> UC9
ad --> UC10
ad --> UC11
lc --> UC12
lc --> UC
cl --> UC14
ad --> UC15
ti --> UC16
sd --> UC
sd --> UC18
@enduml
