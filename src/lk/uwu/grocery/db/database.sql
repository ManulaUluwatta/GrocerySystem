DROP DATABASE grocery;
CREATE DATABASE grocery;

USE grocery;

CREATE TABLE major_category(
	majorCatID VARCHAR (30)NOT NULL,
	majorCatName VARCHAR (30)NOT NULL,
	CONSTRAINT PRIMARY KEY(majorCatID)
);

CREATE TABLE sub_category(
	subCatID VARCHAR (30)NOT NULL,
	majorCatID VARCHAR (30)NOT NULL,
	majorCatName VARCHAR (30),
	subCatName VARCHAR (30),
	CONSTRAINT PRIMARY KEY(subCatID)	,
	CONSTRAINT FOREIGN KEY(majorCatID)REFERENCES major_category(majorCatID)ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE customer(
	custID VARCHAR (30)NOT NULL,
	custFirstName VARCHAR (30)NOT NULL,
	custLastName VARCHAR (30),
	custAddress VARCHAR (30),
	custContact VARCHAR(30),
	custEmail VARCHAR(30),
	custNIC VARCHAR (30),
	custType VARCHAR (30),
	cust_pic VARCHAR(300),
	CONSTRAINT PRIMARY KEY(custID)
);


CREATE TABLE supplier(
	supID VARCHAR (30)NOT NULL,
	supFirstName VARCHAR (30)NOT NULL,
	supLastName VARCHAR (30)NOT NULL,
	supAddress VARCHAR(300),
	supCompany VARCHAR(30),
	supContact VARCHAR (10),
	supEmial VARCHAR(30),
	supNIC VARCHAR (30),
	sup_pic VARCHAR(300),
	CONSTRAINT PRIMARY KEY(supID)
);

CREATE TABLE item(
	itemCode VARCHAR (30)NOT NULL,
	itemName VARCHAR (30)NOT NULL,
	majorCatID VARCHAR (30)NOT NULL,
	subCatID VARCHAR (30)NOT NULL,
	sub_description VARCHAR(300),
	itemSellingPrice DECIMAL(8,2),
	itemCost DECIMAL(8,2),
	qtyOnHand INT (10),
	photo_path VARCHAR(300),
	supID VARCHAR (30)NOT NULL,
	CONSTRAINT PRIMARY KEY(itemCode),
	CONSTRAINT FOREIGN KEY(majorCatID)REFERENCES major_category(majorCatID)ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FOREIGN KEY(subCatID)REFERENCES sub_category(subCatID)ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FOREIGN KEY(supID)REFERENCES supplier(supID)ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE orders(
	orderID VARCHAR (30)NOT NULL,
	custID VARCHAR (30)NOT NULL,
	orderDate VARCHAR (30)NOT NULL,
	CONSTRAINT PRIMARY KEY(orderID),
	CONSTRAINT FOREIGN KEY(custID)REFERENCES customer(custID)ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE order_detail(
	orderDetailID VARCHAR (30)NOT NULL,
	orderID VARCHAR (30)NOT NULL,
	itemCode VARCHAR (30)NOT NULL,
	itemName VARCHAR (30)NOT NULL,
	PricePerUnit DECIMAL(8,2),
	discount DECIMAL(8,2),
	totalAmount DECIMAL(8,2),
	orderQty INT (30),
	CONSTRAINT PRIMARY KEY(orderDetailID,orderID,itemCode),
	CONSTRAINT FOREIGN KEY(orderID)REFERENCES orders(orderID)ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FOREIGN KEY(itemCode)REFERENCES item(itemCode)ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE payment(
	payID VARCHAR (30)NOT NULL,
	orderID VARCHAR(30),
	paymentDate VARCHAR (30),
	paymentAmount DECIMAL (30)NOT NULL,
	payDiscount DECIMAL (30)NOT NULL,
	CONSTRAINT PRIMARY KEY(payID),
	CONSTRAINT FOREIGN KEY(orderID)REFERENCES orders(orderID)ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE user_profile(
	pass_id VARCHAR (30)NOT NULL,
	user_name VARCHAR (30)NOT NULL,
	password VARCHAR (30)NOT NULL,
	admin_name VARCHAR (30)NOT NULL,
	admin_email VARCHAR (30),
	photo_path VARCHAR (200)NOT NULL,
	CONSTRAINT PRIMARY KEY(pass_id)
);
INSERT INTO user_profile VALUES('P001','manager','admin','Dasun jayanga','dasun@gmail.com','/lk/uwu/grocery/ui/images/notAvalable.png');
INSERT INTO user_profile VALUES('P002','cashier','123','Ridmi Balasooriya','ridmi@gmail.com','/lk/uwu/grocery/ui/images/notAvalable.png');


CREATE TABLE login_details(
	lgn_id VARCHAR (30)NOT NULL,
	pass_id VARCHAR (30)NOT NULL,
	admin_name VARCHAR (30)NOT NULL,
	admin_email VARCHAR (30),
	login_date VARCHAR (30),
	login_time VARCHAR (30),
	exit_date VARCHAR (30),
	exit_time VARCHAR (30),
	CONSTRAINT PRIMARY KEY(lgn_id),
	CONSTRAINT FOREIGN KEY(pass_id)REFERENCES user_profile(pass_id)ON UPDATE CASCADE ON DELETE CASCADE
);


