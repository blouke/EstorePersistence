USE `estore`;

-- SAMPLE DATA


-- TABLE CATEGORY
INSERT INTO `CATEGORY` (`id`,`name`,`description`) VALUES (1,'Pizza Delivery Bags','Multiple Colors with multiple sizes available.');
INSERT INTO `CATEGORY` (`id`,`name`,`description`) VALUES (2,'Jumbo Delivery Bags','Holds multiple items.');
INSERT INTO `CATEGORY` (`id`,`name`,`description`) VALUES (3,'Catering Bags','Pasta/Sandwiches & Drink Carrier Bags.');



-- TABLE PRODUCT
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (1,'12" - 14" Pizza Delivery Bag (Red)',12.00,'\"The details goes here',1,'red-pizza-bag.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (2,'12" - 14" Pizza Delivery Bag (Blue)',12.00,'\"The details goes here',1,'blue-pizza-bag.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (3,'12" - 14" Pizza Delivery Bag (Black)',12.00,'\"The details goes here',1,'black-pizza-bag.jpg');

INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (4,'16" - 18" Pizza Delivery Bag (Red)',15.00,'\"The details goes here',1,'red-pizza-bag.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (5,'16" - 18" Pizza Delivery Bag (Blue)',15.00,'\"The details goes here',1,'blue-pizza-bag.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (6,'16" - 18" Pizza Delivery Bag (Black)',15.00,'\"The details goes here',1,'black-pizza-bag.jpg');

INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (7,'16" - 18" Pizza Delivery Bag (Red)',18.00,'\"The details goes here',1,'red-pizza-bag.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (8,'16" - 18" Pizza Delivery Bag (Blue)',18.00,'\"The details goes here',1,'blue-pizza-bag.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (9,'16" - 18" Pizza Delivery Bag (Black)',18.00,'\"The details goes here',1,'black-pizza-bag.jpg');

INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (10,'16" - 18" Jumbo Delivery Bags (Holds upto Eight)',25.00,'\"The details goes here',2,'blue-jumbo-bag.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (11,'Pasta/Sandwiches & Drink Carrier Bags',25.00,'\"The details goes here',3,'blue-pasta-bag.jpg');





-- TABLE USER_GROUPS
INSERT INTO USER_GROUPS (NAME,DESCRIPTION) VALUES 
	('Administrator','EStore web application administrators'),
	('Customer','EStore online customers');

-- TABLE USER
INSERT INTO USER (FIRST_NAME,LAST_NAME,EMAIL,PASSWORD_HASH,CREATE_DATE,GROUP_ID) VALUES 
	('Jack','Adams','jack@yahoo.com','1a2b','2015-01-05',2),
	('Dave','Smith','smith@google.com','2a3b','2014-05-11',2),
	('Sam','Smith','sam@google.com','3a4b','2014-01-01',1);

-- TABLE ADDRESS
INSERT INTO ADDRESS (STREET_ADDRESS,CITY,STATE,ZIP_CODE,PHONE,LAST_UPDATES_SENT,USER_ID) VALUES 
	('123 street','Chicago','IL','61111','3334446666','2015-01-05',1),
	('abc street','Chicago','IL','60124','4445558888','2015-01-05',2),
	('xyz street','Chicago','IL','60105','6662228888','2015-01-05',3);

-- TABLE ORDER
INSERT INTO ORDERS (AMOUNT,ORDER_DATE,CUSTOMER_ID,STATUS,PAYMENT_ID) VALUES 
	(20.0,'2015-01-05',1,'Processing',1),
	(100.0,'2014-01-05',1,'Processing',2),
	(25.0,'2015-04-06',1,'Processing',3),
	(40.0,'2015-06-08',2,'Processing',4),
	(80.0,'2015-08-02',2,'Processing',5);

-- TABLE ORDER_DETAIL
INSERT INTO ORDER_DETAIL (ORDER_ID,PRODUCT_ID,QUANTITY) VALUES (1,1,1);

-- TABLE DELIVERY
INSERT INTO DELIVERY (ADDRESS_ID,COST,STATUS,PROMISED_DATE,ORDER_ID,TRACKING_URL) VALUES (1,5.25,0,'2015-01-09',1,'https://tools.usps.com/go/TrackConfirmAction.action?tRef=fullpage&tLc=1&text28777=&tLabels=123');

-- TABLE PAYMENT
INSERT INTO PAYMENT (BILLING_ADDRESS_ID,ORDER_ID,DATE,PAYMENT_GATEWAY,STATUS,TRANSACTION_NUMBER) VALUES 
	(1,1,'2015-01-05','PAYPAL',1,'1a2b3c'),
	(1,1,'2015-01-05','PAYPAL',1,'1a2b3c'),
	(1,1,'2015-01-05','PAYPAL',1,'1a2b3c'),
	(1,1,'2015-01-05','PAYPAL',1,'1a2b3c'),
	(1,1,'2015-01-05','PAYPAL',1,'1a2b3c');
