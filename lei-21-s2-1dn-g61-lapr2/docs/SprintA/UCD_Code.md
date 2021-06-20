@startuml
left to right direction
actor "Administrator" as ad
actor "Client" as cl
actor "Receptionist" as rc
actor "Laboratory Coordinator" as lc
actor "Specialist Doctor" as sd
actor "Clinical Chemistry Technologist" as cct
actor "Medical Lab Technician" as mlt
actor "NHS" as nhs
actor "Application" as app

rectangle system {
  usecase "Check the results" as UC
  usecase "Register a client" as UC1
  usecase "Register a test" as UC2
  usecase "Record the sample" as UC3
  usecase "Record the results of the chemical analysis" as UC5
  usecase "Write a report and diagnosis" as UC8
  usecase "Validate the diagnosis" as UC9
  usecase "Consult the results" as UC11
  usecase "Specify a new type of test and its collecting methods" as UC12
  usecase "Specify a new test parameter and categorize it" as UC13
  usecase "Specify a new parameter category" as UC14
  usecase "Summarize and report Covid-19 data" as UC15
  usecase "Generate daily automatic reports about covid-19" as UC16
  usecase "Receive daily reports about covid-19" as UC17
}

rc --> UC1
rc --> UC2
mlt --> UC3
mlt --> UC
cct --> UC5
cct --> UC
sd --> UC
sd --> UC8
lc --> UC9
lc --> UC
cl --> UC11
ad --> UC12
ad --> UC13
ad --> UC14
app --> UC15
app --> UC16
nhs --> UC17
@enduml