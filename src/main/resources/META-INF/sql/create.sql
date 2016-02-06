
-- -----------------------------------------------------
-- Schema estore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `estore` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `estore` ;

-- -----------------------------------------------------
-- Table `estore`.`CATEGORY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estore`.`CATEGORY` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(50) NOT NULL COMMENT '',
  `description` VARCHAR(100) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');


-- -----------------------------------------------------
-- Table `estore`.`USER_GROUPS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estore`.`USER_GROUPS` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(50) NOT NULL COMMENT '',
  `description` VARCHAR(300) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estore`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estore`.`USER` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `first_name` VARCHAR(50) NOT NULL COMMENT '',
  `last_name` VARCHAR(50) NOT NULL COMMENT '',
  `email` VARCHAR(100) NOT NULL COMMENT '',
  `password_hash` VARCHAR(128) NOT NULL COMMENT '',
  `create_date` DATETIME NOT NULL COMMENT '',
  `group_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_group_id_idx` (`group_id` ASC)  COMMENT '',
  CONSTRAINT `fk_user_usergroup`
    FOREIGN KEY (`group_id`)
    REFERENCES `estore`.`USER_GROUPS` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `estore`.`ORDERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estore`.`ORDERS` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `amount` FLOAT(50) NOT NULL COMMENT '',
  `order_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '',
  `customer_id` INT NOT NULL COMMENT '',
  `status` VARCHAR(50) NOT NULL COMMENT '',
  `payment_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `ORDER_CUSTOMER_ID_INDEX` (`customer_id` ASC)  COMMENT '',
  CONSTRAINT `fk_order_user`
    FOREIGN KEY (`customer_id`)
    REFERENCES `estore`.`USER` (`id`));


-- -----------------------------------------------------
-- Table `estore`.`PRODUCT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estore`.`PRODUCT` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(50) NOT NULL COMMENT '',
  `price` DECIMAL(5,2) NOT NULL COMMENT '',
  `description` VARCHAR(100) NOT NULL COMMENT '',
  `category_id` INT NOT NULL COMMENT '',
  `image` VARCHAR(100) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `FK_PRODUCT_CATEGORY_INDEX` (`category_id` ASC)  COMMENT '',
  CONSTRAINT `fk_product_category`
    FOREIGN KEY (`category_id`)
    REFERENCES `estore`.`CATEGORY` (`id`));


-- -----------------------------------------------------
-- Table `estore`.`ORDER_DETAIL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estore`.`ORDER_DETAIL` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `order_id` INT NOT NULL COMMENT '',
  `product_id` INT NOT NULL COMMENT '',
  `quantity` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `ORDER_PRODUCT_ID_INDEX` (`product_id` ASC)  COMMENT '',
  CONSTRAINT `fk_orderdetail_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `estore`.`PRODUCT` (`id`),
  CONSTRAINT `fk_orderdetail_order`
    FOREIGN KEY (`order_id`)
    REFERENCES `estore`.`ORDERS` (`id`));


-- -----------------------------------------------------
-- Table `estore`.`ADDRESS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estore`.`ADDRESS` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `street_address` VARCHAR(100) NOT NULL COMMENT '',
  `city` VARCHAR(50) NOT NULL COMMENT '',
  `state` VARCHAR(50) NOT NULL COMMENT '',
  `zip_code` VARCHAR(10) NOT NULL COMMENT '',
  `phone` VARCHAR(20) NULL COMMENT '',
  `last_updates_sent` TIMESTAMP NOT NULL COMMENT '',
  `user_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_user_id_idx` (`user_id` ASC)  COMMENT '',
  CONSTRAINT `fk_address_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `estore`.`USER` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estore`.`PAYMENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estore`.`PAYMENT` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `billing_address_id` INT NOT NULL COMMENT '',
  `order_id` INT NOT NULL COMMENT '',
  `date` DATETIME NOT NULL COMMENT '',
  `payment_gateway` VARCHAR(100) NULL COMMENT '',
  `status` INT NOT NULL COMMENT '',
  `transaction_number` VARCHAR(100) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_address_id_idx` (`billing_address_id` ASC)  COMMENT '',
  INDEX `fk_order_id_idx` (`order_id` ASC)  COMMENT '',
  CONSTRAINT `fk_payment_address`
    FOREIGN KEY (`billing_address_id`)
    REFERENCES `estore`.`ADDRESS` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_payment_order`
    FOREIGN KEY (`order_id`)
    REFERENCES `estore`.`ORDERS` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estore`.`DELIVERY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estore`.`DELIVERY` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `actual_date` DATE NULL COMMENT '',
  `address_id` INT NOT NULL COMMENT '',
  `cost` FLOAT NOT NULL COMMENT '',
  `status` INT NOT NULL COMMENT '',
  `promised_date` DATE NULL COMMENT '',
  `order_id` INT NOT NULL COMMENT '',
  `tracking_url` VARCHAR(200) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_address_id_idx` (`address_id` ASC)  COMMENT '',
  INDEX `fk_order_id_idx` (`order_id` ASC)  COMMENT '',
  CONSTRAINT `fk_delivery_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `estore`.`ADDRESS` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_delivery_order`
    FOREIGN KEY (`order_id`)
    REFERENCES `estore`.`ORDERS` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


