-- SAMPLE DATA


-- TABLE CATEGORY
INSERT INTO CATEGORY (NAME,TAGS) VALUES 
	('Misc','Bottle, Bag, Book'),
	('Coffee','Medium roast, Dark roast');

-- TABLE PRODUCT
INSERT INTO PRODUCT (NAME,PRICE,DESCRIPTION,CATEGORY_ID) VALUES 
	('Book',40.00,'Introduction to Java EE 7',1),
	('Bag',10.00,'Super large bag',1),
	('Bottle',5.00,'Large water bottle',1),
	('Venti Coffee',5.00,'Medium roast veti coffee',2),
	('Grande Coffee',4.00,'Medium roast grande coffee',2),
	('Tall Coffee',3.00,'Medium roast tall coffee',2);

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
INSERT INTO ORDERS (AMOUNT,ORDER_DATE,CUSTOMER_ID,STATUS,PAYMENT_ID) VALUES (20.0,'2015-01-05',1,'Processing',1);

-- TABLE ORDER_DETAIL
INSERT INTO ORDER_DETAIL (ORDER_ID,PRODUCT_ID,QUANTITY) VALUES (1,1,1);

-- TABLE DELIVERY
INSERT INTO DELIVERY (ADDRESS_ID,COST,STATUS,PROMISED_DATE,ORDER_ID,TRACKING_URL) VALUES (1,5.25,0,'2015-01-09',1,'https://tools.usps.com/go/TrackConfirmAction.action?tRef=fullpage&tLc=1&text28777=&tLabels=123');

-- TABLE PAYMENT
INSERT INTO PAYMENT (BILLING_ADDRESS_ID,ORDER_ID,DATE,PAYMENT_GATEWAY,STATUS,TRANSACTION_NUMBER) VALUES (1,1,'2015-01-05','PAYPAL',1,'1a2b3c');
