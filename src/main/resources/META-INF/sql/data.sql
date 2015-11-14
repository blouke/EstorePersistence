-- SAMPLE DATA


-- TABLE CATEGORY
INSERT INTO `CATEGORY` (`id`,`name`,`tags`) VALUES (1,'Misc','Bottle, Mug, Ice Tray');
INSERT INTO `CATEGORY` (`id`,`name`,`tags`) VALUES (2,'Coffee','Medium roast, Dark roast, Light roast');
INSERT INTO `CATEGORY` (`id`,`name`,`tags`) VALUES (3,'Bags','Purse, Backpack, Tote');
INSERT INTO `CATEGORY` (`id`,`name`,`tags`) VALUES (4,'Books','Science Fiction');

-- TABLE PRODUCT
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (1,'Dune',20.00,'\"Set on the desert planet Arakis, Dune is the story of the boy Paul Atreides, who would become the m',4,'dune.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (2,'Hydrogen Sonata',25.00,'The Scavenger species are circling. It is, truly, the End Days for the Gzilt civilization.\n\nAn ancie',4,'hydrogen-sonata-book.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (3,'Hyperion',15.00,'On the world called Hyperion, beyond the law of the Hegemony of Man, there waits the creature called',4,'hyperion-book.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (4,'Rebel Dawn (Star Wars: The Han Solo Trilogy #3)',18.00,'Here is the explosive conclusion of the blockbuster trilogy that chronicles the never-before-told st',4,'rebel-dawn-book.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (5,'Peet\'s Coffee & Tea Major Dickason\'s Blend',9.00,'Our most famous blend. Combines the best coffees from the world\'s premier coffee-growing regions. Ve',2,'dark-coffee.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (6,'Starbucks Veranda Blen Whole Bean Coffee',8.00,'Forty years of coffee-roasting expertise inspired us to perfect Starbucks® Blonde Roast - a lighter,',2,'light-coffee.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (7,'Caribou Coffee Blend Whole Bean',7.00,'Caribou coffee\'s signature blend meets that challenge, balancing a big bodied, syrupy taste with a c',2,'medium-coffee.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (8,'R2-D2 Dome Purse',50.00,'When you\'re carrying something super-important, say, your car keys or your eReader or the plans to t',3,'r2d2bag.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (9,'Star Trek Messenger Bag',45.00,'Space: the final frontier. With this messenger bag at your side, you can explore strange new worlds,',3,'star-trek-bag.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (10,'Doctor Who Purse',60.00,'Dimensions - 375w x 275h x 135d mm. The coolest bag in time and space. Unfortunately not like the re',3,'tardis-bag.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (11,'Star Wars Han Solo in Carbonite Ice Cube Tray',20.00,'That doesn\'t really have the same sort of dramatic impact, does it? Still, that\'s basically what Dar',1,'han-solo-ice-tray.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (12,'Green Arrow Coffee Mug',11.00,'Don\'t fail the morning by using a boring coffee mug.',1,'green-arrow-mug.jpg');
INSERT INTO `PRODUCT` (`id`,`name`,`price`,`description`,`category_id`,`image`) VALUES (13,'Red Dwarf Coffee Mug',14.00,'I am Holly, the ship\'s computer, with an IQ of 6000; the same IQ as 6000 PE teachers.',1,'red-dwarf-mug.jpg');

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
