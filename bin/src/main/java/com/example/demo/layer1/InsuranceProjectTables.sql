
CREATE TABLE customer (
	Cust_Id NUMBER(10, 0) NOT NULL,
	Cust_FirstName VARCHAR2(25) NOT NULL,
	Cust_LastName VARCHAR2(25) NOT NULL,
	Cust_Email VARCHAR2(25) UNIQUE NOT NULL,
	Cust_ContactNumber VARCHAR2(10) NOT NULL,
	Cust_Password VARCHAR2(25) NOT NULL,
	constraint CUSTOMER_PK PRIMARY KEY (Cust_Id));

insert into Customer values(101, 'Kunal','Chugriya','kunalchugriaa@gmail.com','9987387287','Kunal@12');

insert into Customer values(102, 'Chirag','Nagpal','chirag@gmail.com','9987374569','Chirag@12');

insert into Customer values(103, 'Gulshan','Kataria','gulshan@gmail.com','8758387287','Gulshan@12');

insert into Customer values(104, 'Jayesh','Samtani','jayesh@gmail.com','9123387287','Jayesh@12');

insert into Customer values(105, 'Preeti','Singh','preeti@gmail.com','9123687287','Preeti@12');   

---------------------------------------------------------------------------------------------------------------------

CREATE TABLE Insurance (
	Cust_Id NUMBER(10, 0) NOT NULL,
	Insurance_Amount DECIMAL(15) NOT NULL,
	Insurance_id NUMBER(10, 0) NOT NULL,
	Insurance_IssueDate DATE NOT NULL,
	Insurance_PolicyType NUMBER(5, 0) NOT NULL,
	Insurance_IsActive NUMBER(1, 0) NOT NULL,
	constraint INSURANCE_PK PRIMARY KEY (Insurance_id));

ALTER TABLE Insurance ADD CONSTRAINT Insurance_fk0 FOREIGN KEY (Cust_Id) REFERENCES customer(Cust_Id);
 
INSERT INTO INSURANCE VALUES (101,2000,301,'16-SEP-2009',1,0);  
INSERT INTO INSURANCE VALUES (102,3000,302,'22-DEC-2019',1,1);
INSERT INTO INSURANCE VALUES (101,3500,303,'25-JAN-2005',1,0);
INSERT INTO INSURANCE VALUES (103,4000,304,'22-MAY-2014',1,0);
INSERT INTO INSURANCE VALUES (104,5000,305,'15-OCT-2017',1,0);
INSERT INTO INSURANCE VALUES (105,6000,306,'13-FEB-2007',1,0);

INSERT INTO INSURANCE VALUES (101,3000,307,'15-FEB-2021',2,0);
INSERT INTO INSURANCE VALUES (102,3500,308,'24-MAR-2021',2,0);
INSERT INTO INSURANCE VALUES (103,4000,309,'22-APR-2021',2,0);
INSERT INTO INSURANCE VALUES (104,5000,310,'21-JUN-2021',2,0);
INSERT INTO INSURANCE VALUES (105,6000,311,'20-AUG-2021',2,0);

--------------------------------------------------------------------------------------------------------------------------------
    
CREATE TABLE Vehicle (
	Vehicle_id NUMBER(10, 0) NOT NULL,
	Vehicle_Model VARCHAR2(30) NOT NULL,
	Vechicle_Type NUMBER(5, 0) NOT NULL,
	Vehicle_RegistrationNo VARCHAR2(15) UNIQUE NOT NULL,
	Vehicle_Manufacture VARCHAR2(20) NOT NULL,
	Vehicle_PurchaseDate DATE NOT NULL,
	Vehicle_EngineNumber VARCHAR2(12) UNIQUE NOT NULL,
	Vehicle_ChasisNumber VARCHAR2(17) UNIQUE NOT NULL,
	Cust_id NUMBER(10, 0) NOT NULL,
	Vehicle_PlanType NUMBER(5, 0) NOT NULL,
	Vehicle_DurationOfPolicy NUMBER(3, 0) NOT NULL,
	Insurance_Id NUMBER(10, 0) NOT NULL,
	constraint VECHICLE_PK PRIMARY KEY (Vehicle_id));

ALTER TABLE Vehicle ADD CONSTRAINT Vehicle_fk0 FOREIGN KEY (Cust_id) REFERENCES customer(Cust_Id);
ALTER TABLE Vehicle ADD CONSTRAINT Vehicle_fk1 FOREIGN KEY (Insurance_Id) REFERENCES Insurance(Insurance_id);



insert into Vehicle values(501,'i10',1,'MH 19 AZ 8901','Hyundai','15-SEP-2009','52WVC10338','1HGBH41JXMN109186',101,1,1,301);

insert into Vehicle values(502,'Nano' , 1,'MH 29 ZE 7798' , 'TATA', '21-DEC-2019','21CZC50338','9GZWE43JXMN189886',102,1,2,302);

insert into Vehicle values(503,'Climber' , 1,'RZ 24 QW 4589' , 'Renault', '24-JAN-2005','45DFD45339','7JSIA89KIAL175941',101,1,2,303);

insert into Vehicle values(504,'Splendor' , 2,'GJ 23 CS 2342' , 'Hero', '12-FEB-2007','32SDE43228','5DAFW32DAMN233232',105,0,3,306);

insert into Vehicle values(505,'Swift Dzire' , 1,'DL 02 SD 2327' , 'Maruti', '21-MAY-2014','54KSL21324','7DSDA53FSAD435356',103,1,2,304);

insert into Vehicle values(506,'FZ-X' , 2,'DL 12 AS 4533' , 'Yamaha', '14-OCT-2017','43FAS34545','2WERT21FASE124365',104,0,2,305);


======================================================================================================================================

CREATE TABLE Travel (
	TravelId INT NOT NULL,
	INSURANCE_ID NUMBER(10, 0) NOT NULL,
	Travel_Destination VARCHAR2(50) NOT NULL,
	Travel_ModeOfTravel VARCHAR2(15) NOT NULL,
	Travel_StartDate DATE NOT NULL,
	Travel_EndDate DATE NOT NULL,
	Travel_PolicyPlan NUMBER(5, 0) NOT NULL,
	Travel_NoOfMembers NUMBER(2, 0) NOT NULL,
	Travel_Email VARCHAR2(255) NOT NULL,
	Travel_Contact NUMBER(10, 0) NOT NULL,
	Nominee_Name VARCHAR2(255) NOT NULL,
	Nominee_Relationship VARCHAR2(255) NOT NULL,
	Cust_Id NUMBER(10, 0) NOT NULL,
	constraint TRAVEL_PK PRIMARY KEY (TravelId));

ALTER TABLE Travel ADD CONSTRAINT Travel_fk0 FOREIGN KEY (Cust_Id) REFERENCES customer(Cust_Id);
ALTER TABLE Travel ADD CONSTRAINT Travel_fk1 FOREIGN KEY (INSURANCE_ID) REFERENCES Insurance(Insurance_id);


insert into Travel values (451 ,307 ,'Newyork', 'Airplane', '27-FEB-2021' , '6-MAR-2021' , 0 , 3,'KunalChughriya5@gmail.com' ,'9156967277' ,'Kunal Chughriya' ,'Brother',101);
insert into Travel values (452 ,308 ,'London', 'Airplane', '27-MAR-2021' , '6-APR-2021' , 1 , 2,'Chirag@gmail.com' ,'9156989277' , 'Chirag Nagpal' ,'Brother',102);
insert into Travel values (453 ,309 ,'Sanfransico', 'Airplane', '27-APR-2021' , '6-JUN-2021' , 0 , 3,'Gulshan@gmail.com' ,'9178967822' ,'Gulshan Kataria' ,'Brother',103);
insert into Travel values (454 ,310 ,'Italy', 'Airplane', '27-JUN-2021' , '6-JUL-2021' , 1 , 2,'Jayesh45@gmail.com' ,'9156967277' ,'Jayesh Samtani' ,'Sister',104);
insert into Travel values (455 ,311 ,'Singapore', 'Airplane', '27-AUG-2021' , '6-SEP-2021' , 1 , 2,'preeti@gmail.com' ,'9186567677' ,'Preeti Singh' ,'Brother',105);

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE Members (
	Member_Id NUMBER(10, 0) NOT NULL,
	Member_Name VARCHAR2(30) NOT NULL,
    Member_DOB DATE NOT NULL,
	Member_Relationship VARCHAR2(15) NOT NULL,
	Member_PassportNo VARCHAR2(8) NOT NULL,
	TravelId INT NOT NULL,
	constraint MEMBERS_PK PRIMARY KEY (Member_Id));

ALTER TABLE Members ADD CONSTRAINT Members_fk0 FOREIGN KEY (TravelId) REFERENCES Travel(TravelId);

insert into Members values (901,'Rohit Sharma','30-APR-1987','Brother','A2096457',451);
insert into Members values (902,'Virat Kohli','05-NOV-1988','Brother','A2096455',451);
insert into Members values (903,'KL Rahul','30-APR-1987','Brother','A2096456',451);

insert into Members values (904,'Joe Root','30-APR-1987','Brother','A2096557',452);
insert into Members values (905,'James Anderson','05-NOV-1988','Brother','A2096555',452);
 

insert into Members values (907,'Steven Smith','30-APR-1987','Brother','A3096457',453);
insert into Members values (908,'Pat cummins','05-NOV-1988','Brother','A3096455',453);
insert into Members values (909,'David Warner','30-APR-1987','Brother','A3096456',453);

insert into Members values (910,'Kane Williamson','30-APR-1987','Brother','A4096457',454);
insert into Members values (911,'Trent Boult','05-NOV-1988','Brother','A4096455',454);
 

insert into Members values (913,'Dinesh Karthik','30-APR-1987','Brother','A5096457',455);
insert into Members values (914,'Murali Vijay','05-NOV-1988','Brother','A5096455',455);
 
-----------------------------------------------------------------------------------------------------------------------------------------

 CREATE TABLE Claim (
	Claim_Id INT NOT NULL,
	Claim_Reason VARCHAR2(255) NOT NULL,
	Claim_ApprovalStatus NUMBER(1, 0) NOT NULL,
	Claim_AmountInsured DECIMAL NOT NULL,
	Claim_DateOfSubmission DATE NOT NULL,
	InsuranceID INT NOT NULL,
	constraint CLAIM_PK PRIMARY KEY (Claim_Id));

ALTER TABLE Claim ADD CONSTRAINT Claim_fk0 FOREIGN KEY (InsuranceID) REFERENCES Insurance(Insurance_id);




INSERT INTO CLAIM VALUES (801,'ACCIDENT',1,800,'29-SEP-2009',301);
INSERT INTO CLAIM VALUES (802,'DISASTER',1,900,'19-SEP-2020',302);
INSERT INTO CLAIM VALUES (803,'ACCIDENT',0,700,'23-APR-2005',303);
INSERT INTO CLAIM VALUES (804,'ACCIDENT',1,600,'12-SEP-2014',304);
INSERT INTO CLAIM VALUES (805,'ACCIDENT',0,800,'29-NOV-2017',305);


-------------------------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE Payment (
	Payment_Id INT NOT NULL,
	InsuranceID NUMBER(10, 0) NOT NULL,
	Payment_Amount DECIMAL(10) NOT NULL,
	constraint PAYMENT_PK PRIMARY KEY (Payment_Id));


ALTER TABLE Payment ADD CONSTRAINT Payment_fk0 FOREIGN KEY (InsuranceID) REFERENCES Insurance(Insurance_id);



INSERT INTO Payment VALUES(700,301,2000);
INSERT INTO Payment VALUES(701,302,3000);
INSERT INTO Payment VALUES(702,303,3500);
INSERT INTO Payment VALUES(703,304,4000);
INSERT INTO Payment VALUES(704,305,5000);
INSERT INTO Payment VALUES(705,306,6000);
INSERT INTO Payment VALUES(706,307,3000);
INSERT INTO Payment VALUES(707,308,3500);
INSERT INTO Payment VALUES(708,309,4000);
INSERT INTO Payment VALUES(709,310,5000);
INSERT INTO Payment VALUES(710,311,6000);

------------------------------------------------------------------------------------------------------------------------------------


alter table vehicle rename column VECHICLE_TYPE to VEHICLE_TYPE;

--Vehicle_Type
ALTER TABLE Vehicle ADD CONSTRAINT CHK_VehicleType CHECK (VEHICLE_TYPE in (1,2));
----------Car : 1, Bike - 2

--Vehicle_PlanType
ALTER TABLE Vehicle ADD CONSTRAINT CHK_VehiclePlanType CHECK (Vehicle_PlanType in (0,1));
----------Third Party : 0, Comprehension : 1


--Claim_ApprovalStatus
ALTER TABLE Claim ADD CONSTRAINT CHK_ClaimApprovalStatus CHECK (Claim_ApprovalStatus in (0,1,-1));
----------Not Approved : 0, Approved : 1

--Insurance_PolicyType
ALTER TABLE Insurance ADD CONSTRAINT CHK_InsurancePolicyType CHECK (Insurance_PolicyType in (1,2));
-----------Vehicle : 1, Travel : 2

--Insurance_IsActive
ALTER TABLE Insurance ADD CONSTRAINT CHK_InsuranceIsActive CHECK (Insurance_IsActive in (0,1));
----------InActive : 0, Active : 1

--Travel_PolicyPlan
ALTER TABLE travel ADD CONSTRAINT CHK_TravelPolicyPlan CHECK (Travel_PolicyPlan in (0,1));
----------Standard : 0, Gold : 1



