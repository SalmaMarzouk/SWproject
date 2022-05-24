drop schema if exists clinic;
Create Schema clinic;
Use clinic;

create table User (
ID varchar(30) primary key not null,
Name varchar(30) not null,
Password varchar (30) not null,
isDoctor boolean not null
); 
create table Patient (
ID varchar(30) unique,
Name varchar (30) ,
Gender varchar(10) ,
Age int CHECK (Age > 0),
Address varchar(30),
constraint gender_constraint check(Gender in ('F','M','Female','Male'))
); 
create table Appointment (
Patient_id varchar(30),
Patient_name varchar (30) ,
Doctor_id varchar(30) not null,
Doctor_name varchar(30) not null,
Date date,
Time time,
Available boolean,
constraint App_pk primary key(Doctor_id , Date,Time),
constraint App_pk2 unique(Patient_id , Date,Time),
constraint Did_fk foreign key (Doctor_id) references User(ID)
On delete cascade
On update cascade
); 

insert into User values('1','salma','11',true);
insert into User values('2','zeko','11',false);
SELECT * FROM clinic.User WHERE ID = "1" and Password = "11";
delete  from Patient where Id='3';
select * from  Appointment where  Available='0';
update  Appointment set Available='1' where Available='0';