drop database FurnitureShop;
CREATE DATABASE FurnitureShop;
USE FurnitureShop;

CREATE TABLE Employee(
                         EID VARCHAR(10),
                         firstName VARCHAR(30) NOT NULL,
                         lastName VARCHAR(30) NOT NULL,
                         street VARCHAR(40),
                         city VARCHAR(30) NOT NULL,
                         lane VARCHAR(30),
                         NIC VARCHAR(15),
                         MobileNumber VARCHAR(30) UNIQUE NOT NULL,
                         CONSTRAINT PRIMARY KEY (EID)
);

CREATE TABLE Salary(
                       SID VARCHAR(10),
                       EID VARCHAR(10),
                       basic DECIMAL(10,2) NOT NULL,
                       bonus DECIMAL(10,2) ,
                       CONSTRAINT PRIMARY KEY (SID),
                       CONSTRAINT FOREIGN KEY(EID) REFERENCES Employee(EID)
                           ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE User(
                     Password VARCHAR(10),
                     UserName VARCHAR(10),
                     CONSTRAINT PRIMARY KEY (Password)

);

CREATE TABLE EmployeeAttendance(
                                   AID VARCHAR(10),
                                   EID VARCHAR(10),
                                   attendance VARCHAR(30) NOT NULL,
                                   workingHourse INT(30) NOT NULL,
                                   date VARCHAR(30) NOT NULL,
                                   CONSTRAINT PRIMARY KEY (AID),
                                   CONSTRAINT FOREIGN KEY(EID) REFERENCES Employee(EID)
                                       ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Customer(
                         CID VARCHAR(10),
                         firstName VARCHAR(30) NOT NULL,
                         lastName VARCHAR(30) NOT NULL,
                         street VARCHAR(40),
                         city VARCHAR(30) NOT NULL,
                         lane VARCHAR(30),
                         NIC VARCHAR(15),
                         MobileNumber VARCHAR(30) UNIQUE NOT NULL,
                         CONSTRAINT PRIMARY KEY (CID)
);

CREATE TABLE Delivary(
                         DID VARCHAR(10),
                         driverName VARCHAR(30),
                         CONSTRAINT PRIMARY KEY (DID)

);

CREATE TABLE DelivaryDetails(
                       DID VARCHAR(10),
                       EID VARCHAR(10),
                       time VARCHAR(30),
                       date  DATE,
                       CONSTRAINT FOREIGN KEY(DID) REFERENCES Delivary(DID)ON                        UPDATE CASCADE ON DELETE CASCADE,
                       CONSTRAINT FOREIGN KEY(EID) REFERENCES Employee(EID)
                       ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Payment(
                       PID VARCHAR(10),
                       cash VARCHAR(30),
                       balance VARCHAR(30),
                       time VARCHAR(30),
                       orderDate DATE,
                       CONSTRAINT PRIMARY KEY (PID)

);


CREATE TABLE `Order`(
                       OID VARCHAR(10),
                       CID VARCHAR(10),
                       DID VARCHAR(10),
                       PID VARCHAR(10),
                       orderDate  DATE,
                       CONSTRAINT PRIMARY KEY (OID),
                       CONSTRAINT FOREIGN KEY(CID) REFERENCES Customer(CID)
                       ON UPDATE CASCADE ON DELETE CASCADE,
                       CONSTRAINT FOREIGN KEY(DID) REFERENCES Delivary(DID)
                       ON UPDATE CASCADE ON DELETE CASCADE,
                      CONSTRAINT FOREIGN KEY(PID) REFERENCES Payment(PID)
                       ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE Item(
	IID VARCHAR(6) NOT NULL,
                  ItemName VARCHAR(30) NOT NULL,
                  MatirialType VARCHAR(30),
                  Size VARCHAR(10),
	Colour VARCHAR(30) NOT NULL,
	UnitPrize VARCHAR(30),
	QtyOnHand VARCHAR(30),
                 CONSTRAINT PRIMARY KEY (IID)

);

CREATE TABLE OrderDetails(
                       OID VARCHAR(10),
                       IID VARCHAR(6) NOT NULL,
                       qtyOnHand INT(30),
                       unitPrice VARCHAR(15),
                       CONSTRAINT FOREIGN KEY(OID) REFERENCES `Order`(OID) ON                         UPDATE CASCADE ON DELETE CASCADE,
                       CONSTRAINT FOREIGN KEY(IID) REFERENCES Item(IID)
                       ON UPDATE CASCADE ON DELETE CASCADE
);
