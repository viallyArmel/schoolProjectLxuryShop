CREATE
DATABASE IF NOT EXISTS luxurydb;
USE
luxurydb;

set
@@global.time_zone = '+00:00' ;
set
@@session.time_zone = '+00:00' ;

DROP TABLE IF EXISTS translation CASCADE;
DROP TABLE IF EXISTS order_line CASCADE;
DROP TABLE IF EXISTS coupon CASCADE;
DROP TABLE IF EXISTS `order` CASCADE;
DROP TABLE IF EXISTS `language` CASCADE;
DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS category CASCADE;
DROP TABLE IF EXISTS customer CASCADE;

-- birthdate check constraint must be edited every year
CREATE TABLE customer
(
    `id`                      INT          NOT NULL AUTO_INCREMENT,
    `username`                VARCHAR(255) NOT NULL,
    `password`                VARCHAR(255) NOT NULL,
    `firstname`               VARCHAR(255) NOT NULL,
    `lastname`                VARCHAR(255) NOT NULL,
    `email`                   VARCHAR(255) NOT NULL,
    `phone_number`            VARCHAR(45),
    `birthdate`               DATE,
    `gender`                  VARCHAR(255) NOT NULL,
    `street`                  VARCHAR(255),
    `postal_code`             INT,
    `locality`                VARCHAR(255),
    `country`                 VARCHAR(255) NOT NULL,
    `authorities`             VARCHAR(255) NOT NULL,
    `account_non_expired`     BIT          NOT NULL,
    `account_non_locked`      BIT          NOT NULL,
    `credentials_non_expired` BIT          NOT NULL,
    `enabled`                 BIT          NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `user_firstname_chk` CHECK (`firstname` REGEXP '(?i)(^[a-z])((?![ .,''-]$)[a-z .,''-]){1,29}$'
) ,
      CONSTRAINT `user_lastname_chk` CHECK (`lastname` REGEXP '(?i)(^[a-z])((?![ .,''-]$)[a-z .,''-]){1,29}$'),
      CONSTRAINT `user_username_chk` CHECK (`username` REGEXP '^(?=[a-zA-Z0-9._]{4,20}$)(?!.*[_.]{2})[^_.].*[^_.]$'),
      CONSTRAINT `user_password_chk` CHECK (`password` REGEXP '^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{6,}$'),
      CONSTRAINT `user_phone_number_chk` CHECK (`phone_number` REGEXP '^[0-9]{0,10}$'),
      CONSTRAINT `user_email_chk` CHECK (`email` LIKE '%@%.%'),
      CONSTRAINT `user_postal_code_chk` CHECK (`postal_code` >= 0),
      CONSTRAINT `username_uk` UNIQUE (`username`),
      CONSTRAINT `email_uk` UNIQUE (`email`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE category
(
    `id`    INT NOT NULL AUTO_INCREMENT,
    `image` VARCHAR(100),
    PRIMARY KEY (`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE product
(
    `id`           INT PRIMARY KEY AUTO_INCREMENT,
    `name`         VARCHAR(255) UNIQUE NOT NULL,
    `price`        DECIMAL(9, 2)       NOT NULL,
    `picture`      VARCHAR(255)        NOT NULL,
    `out_of_stock` BIT                 NOT NULL,
    `category`     INT                 NOT NULL,
    CONSTRAINT `product_price_chk` CHECK (`price` >= 0),
    CONSTRAINT `product_categ_fk` FOREIGN KEY (`category`) REFERENCES `category` (`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE `language`
(
    `code`  VARCHAR(3)  NOT NULL,
    `label` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`code`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE `order`
(
    `id`       INT  NOT NULL AUTO_INCREMENT,
    `date`     DATE NOT NULL,
    `customer` INT  NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `order_customer_fk` FOREIGN KEY (`customer`) REFERENCES `customer` (`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE order_line
(
    `id`       INT PRIMARY KEY AUTO_INCREMENT,
    `quantity` INT           NOT NULL,
    `price`    DECIMAL(9, 2) NOT NULL,
    `order`    INT           NOT NULL,
    `product`  INT           NOT NULL,
    CONSTRAINT `order_line_quantity_chk` CHECK (`quantity` > 0),
    CONSTRAINT `order_line_price_chk` CHECK (`price` >= 0),
    CONSTRAINT `orderLine_order_fk` FOREIGN KEY (`order`) REFERENCES `order` (`id`),
    CONSTRAINT `orderLine_product_fk` FOREIGN KEY (`product`) REFERENCES `product` (`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE translation
(
    `id`       INT PRIMARY KEY AUTO_INCREMENT,
    `label`    VARCHAR(255) NOT NULL,
    `category` INT          NOT NULL,
    `language` VARCHAR(3)   NOT NULL,
    CONSTRAINT `translation_category_fk` FOREIGN KEY (`category`) REFERENCES `category` (`id`),
    CONSTRAINT `translation_language_fk` FOREIGN KEY (`language`) REFERENCES `language` (`code`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

delimiter
//
CREATE TRIGGER valid_customer_birthdate
    BEFORE INSERT
    ON customer
    FOR EACH ROW IF YEAR(NEW.`birthdate`) > YEAR(SYSDATE())-18 THEN
	SIGNAL SQLSTATE '45001' set message_text = "User must be at least 18 years old.";
END IF;
//
delimiter ;

INSERT INTO customer (username, `password`, firstname, lastname, email, phone_number, birthdate, gender, street,
                      postal_code, locality, country, authorities, account_non_expired, account_non_locked,
                      credentials_non_expired, enabled)
VALUES ('vially418', '$2a$10$UbEElbK3yjGwTz2afspINeDLxfMxpPfGOS1hwARxvdV.HSwJI5tzW', 'Armel vially', 'Dongmo',
        'armelvially418@icloud.com', '0492447329', str_to_date('2002-10-10', '%Y-%m-%d'), 'Homme',
        'rue lucien namêche 39', 5000, 'namur', 'belgique', 'ADMIN', 1, 1, 1, 1),
       ('idrl', '$2a$10$g2kEx49tIx7H4l49C9D88.brN0DipQMZE3hVcmr79EhC4DE75XqZa', 'idricelle', 'tegomo',
        'tegomo@gmail.com', '0493993030', str_to_date('2002-10-10', '%Y-%m-%d'), 'Femme', 'rue lucien namêche 39', 5000,
        'namur', 'belgique', 'USER', 1, 1, 1, 1),
       ('po_manil', '$2a$10$l.S5S.0Eq8Bk5Tc8LawJr.Hgkd/5dZKuU5mXKsmLZnmk687wI57a6', 'Pierre-Olivier', 'manil',
        'pomanil@icloud.com', '0499247329', str_to_date('1994-10-10', '%Y-%m-%d'), 'Homme', 'rue lucien namêche 39',
        5000, 'namur', 'belgique', 'ADMIN', 1, 1, 1, 1),
        ('draekthar', '$2a$10$wziKaMgyJ.8hSRd4yOTwR.xSBNjECB/O5g.8UR4x8Yyn415gBn5W6', 'po', 'ma', 'a@b.c', '0499112233', '2002-02-02', 'Homme', 'Abc', '5000', 'na', 'Be', 'ADMIN', 1,1,1, 1);


INSERT INTO `language` (`code`, label)
VALUES ('fr', 'français'),
       ('en', 'anglais');

INSERT INTO category (image)
VALUES ('manSetOutfit'),
       ('menShoes'),
       ('womanSetBagShoes'),
       ('womanSetOutfit'),
       ('womanBag'),
       ('womanShoes');

INSERT INTO translation (`label`, `category`, `language`)
VALUES ('Ensemble vêtements homme', 1, 'fr'),
       ('Man set outfit', 1, 'en'),
       ('Chaussures homme', 2, 'fr'),
       ('Men shoes', 2, 'en'),
       ('Sacs femme', 3, 'fr'),
       ('Woman bags', 3, 'en'),
       ('Ensemble sacs et chaussures femme', 4, 'fr'),
       ('Woman set bags and shoes', 4, 'en'),
       ('Ensemble vêtements femme', 5, 'fr'),
       ('Woman set outfit', 5, 'en'),
       ('Chaussures femme', 6, 'fr'),
       ('Woman shoes', 6, 'en');

INSERT INTO product (`name`, `price`, `picture`, `out_of_stock`, `category`)
VALUES ('man set outfit 1', '45', '/images/manSetOutfit/manSetOutfit1', true, 1),
       ('man set outfit 2', '60', '/images/manSetOutfit/manSetOutfit2', false, 1),
       ('man set outfit 3', '100', '/images/manSetOutfit/manSetOutfit3', false, 1),
       ('man set outfit 4', '24', '/images/manSetOutfit/manSetOutfit4', false, 1),
       ('man set outfit 5', '120', '/images/manSetOutfit/manSetOutfit5', false, 1),
       ('man set outfit 6', '75', '/images/manSetOutfit/manSetOutfit6', false, 1),
       ('man set outfit 7', '30', '/images/manSetOutfit/manSetOutfit7', true, 1),
       ('men shoes 1', '40', '/images/menShoes/menShoes1', false, 2),
       ('men shoes 2', '60.99', '/images/menShoes/menShoes2', false, 2),
       ('men shoes 3', '100', '/images/menShoes/menShoes3', false, 2),
       ('men shoes 4', '130', '/images/menShoes/menShoes4', false, 2),
       ('men shoes 5', '200', '/images/menShoes/menShoes5', true, 2),
       ('men shoes 6', '35', '/images/menShoes/menShoes6', true, 2),
       ('men shoes 7', '38', '/images/menShoes/menShoes7', false, 2),
       ('men shoes 8', '40', '/images/menShoes/menShoes8', false, 2),
       ('men shoes 9', '80', '/images/menShoes/menShoes9', false, 2),
       ('men shoes 10', '64', '/images/menShoes/menShoes10', false, 2),
       ('men shoes 11', '45.30', '/images/menShoes/menShoes11', false, 2),
       ('woman set bag shoes 1', '20.99', '/images/womanSetBagShoes/womanSetBagShoes1', false, 3),
       ('woman set bag shoes 2', '230', '/images/womanSetBagShoes/womanSetBagShoes2', false, 3),
       ('woman set bag shoes 3', '123', '/images/womanSetBagShoes/womanSetBagShoes3', false, 3),
       ('woman set bag shoes 4', '34.99', '/images/womanSetBagShoes/womanSetBagShoes4', true, 3),
       ('woman set bag shoes 5', '99.99', '/images/womanSetBagShoes/womanSetBagShoes5', false, 3),
       ('woman set bag shoes 6', '34.99', '/images/womanSetBagShoes/womanSetBagShoes6', false, 3),
       ('woman set bag shoes 7', '45', '/images/womanSetBagShoes/womanSetBagShoes7', false, 3),
       ('woman set bag shoes 8', '76', '/images/womanSetBagShoes/womanSetBagShoes8', false, 3),
       ('woman set bag shoes 9', '122', '/images/womanSetBagShoes/womanSetBagShoes9', false, 3),
       ('woman set bag shoes 10', '234', '/images/womanSetBagShoes/womanSetBagShoes10', false, 3),
       ('woman set bag shoes 11', '300.99', '/images/womanSetBagShoes/womanSetBagShoes11', false, 3),
       ('woman set bag shoes 12', '111.99', '/images/womanSetBagShoes/womanSetBagShoes12', false, 3),
       ('woman set bag shoes 13', '234', '/images/womanSetBagShoes/womanSetBagShoes13', false, 3),
       ('woman set bag shoes 14', '45', '/images/womanSetBagShoes/womanSetBagShoes14', false, 3),
       ('woman set bag shoes 15', '59', '/images/womanSetBagShoes/womanSetBagShoes15', false, 3),
       ('woman set bag shoes 16', '211.99', '/images/womanSetBagShoes/womanSetBagShoes16', false, 3),
       ('woman set bag shoes 17', '87', '/images/womanSetBagShoes/womanSetBagShoes17', false, 3),
       ('woman set bag shoes 18', '98.99', '/images/womanSetBagShoes/womanSetBagShoes18', false, 3),
       ('woman set bag shoes 19', '95.99', '/images/womanSetBagShoes/womanSetBagShoes19', false, 3),
       ('woman set bag shoes 20', '58.99', '/images/womanSetBagShoes/womanSetBagShoes20', false, 3),
       ('woman set bag shoes 21', '33.99', '/images/womanSetBagShoes/womanSetBagShoes21', false, 3),
       ('woman set bag shoes 22', '49.99', '/images/womanSetBagShoes/womanSetBagShoes22', false, 3),
       ('woman set bag shoes 23', '99.99', '/images/womanSetBagShoes/womanSetBagShoes23', false, 3),
       ('woman set bag shoes 24', '129', '/images/womanSetBagShoes/womanSetBagShoes24', false, 3),
       ('woman set bag shoes 25', '240', '/images/womanSetBagShoes/womanSetBagShoes25', false, 3),
       ('woman set bag shoes 26', '76', '/images/womanSetBagShoes/womanSetBagShoes26', false, 3),
       ('woman set bag shoes 27', '77.99', '/images/womanSetBagShoes/womanSetBagShoes27', false, 3),
       ('woman set outfit 1', '23.99', '/images/womanSetOutfit/womanSetOutfit1', false, 4),
       ('woman set outfit 2', '30', '/images/womanSetOutfit/womanSetOutfit2', false, 4),
       ('woman set outfit 3', '45.99', '/images/womanSetOutfit/womanSetOutfit3', false, 4),
       ('woman set outfit 4', '67.99', '/images/womanSetOutfit/womanSetOutfit4', false, 4),
       ('woman set outfit 5', '77.99', '/images/womanSetOutfit/womanSetOutfit5', false, 4),
       ('woman set outfit 6', '30', '/images/womanSetOutfit/womanSetOutfit6', false, 4),
       ('woman set outfit 7', '45', '/images/womanSetOutfit/womanSetOutfit7', false, 4),
       ('woman set outfit 8', '50', '/images/womanSetOutfit/womanSetOutfit8', false, 4),
       ('woman bag 1', '99', '/images/womanBag/womanBag1', false, 5),
       ('woman bag 2', '100', '/images/womanBag/womanBag2', false, 5),
       ('woman bag 3', '75', '/images/womanBag/womanBag3', false, 5),
       ('woman bag 4', '45', '/images/womanBag/womanBag4', false, 5),
       ('woman bag 5', '78', '/images/womanBag/womanBag5', false, 5),
       ('woman bag 6', '120', '/images/womanBag/womanBag6', false, 5),
       ('woman bag 7', '76', '/images/womanBag/womanBag7', false, 5),
       ('women shoes 1', '76', '/images/womenShoes/womanShoes1', false, 6),
       ('women shoes 2', '76', '/images/womenShoes/womanShoes2', false, 6),
       ('women shoes 3', '76', '/images/womenShoes/womanShoes3', false, 6),
       ('women shoes 4', '76', '/images/womenShoes/womanShoes4', false, 6),
       ('women shoes 5', '76', '/images/womenShoes/womanShoes5', false, 6),
       ('women shoes 6', '76', '/images/womenShoes/womanShoes6', false, 6),
       ('women shoes 7', '76', '/images/womenShoes/womanShoes7', false, 6),
       ('women shoes 8', '76', '/images/womenShoes/womanShoes8', false, 6),
       ('women shoes 9', '76', '/images/womenShoes/womanShoes9', true, 6),
       ('women shoes 10', '76', '/images/womenShoes/womanShoes10', false, 6),
       ('women shoes 11', '76', '/images/womenShoes/womanShoes11', false, 6),
       ('women shoes 12', '76', '/images/womenShoes/womanShoes12', false, 6),
       ('women shoes 13', '76', '/images/womenShoes/womanShoes13', false, 6),
       ('women shoes 14', '76', '/images/womenShoes/womanShoes14', false, 6),
       ('women shoes 15', '76', '/images/womenShoes/womanShoes15', false, 6),
       ('women shoes 16', '76', '/images/womenShoes/womanShoes16', false, 6),
       ('women shoes 17', '76', '/images/womenShoes/womanShoes17', false, 6),
       ('women shoes 18', '76', '/images/womenShoes/womanShoes18', false, 6),
       ('women shoes 19', '76', '/images/womenShoes/womanShoes19', false, 6),
       ('women shoes 20', '76', '/images/womenShoes/womanShoes20', false, 6),
       ('women shoes 21', '76', '/images/womenShoes/womanShoes21', true, 6);

INSERT INTO order (`date`, customer) VALUES
(str_to_date('2012-10-10', '%Y-%m-%d'), 1),
(str_to_date('2012-11-12', '%Y-%m-%d'), 1),
(str_to_date('2012-12-25', '%Y-%m-%d'), 1),
(str_to_date('2013-01-08', '%Y-%m-%d'), 1),
(str_to_date('2013-01-18', '%Y-%m-%d'), 1),
(str_to_date('2013-09-14', '%Y-%m-%d'), 1),
(str_to_date('2013-09-30', '%Y-%m-%d'), 2),
(str_to_date('2011-11-18', '%Y-%m-%d'), 2),
(str_to_date('2015-04-07', '%Y-%m-%d'), 3);

INSERT INTO order_line (quantity, price, `order`, product) VALUES
(1,45, 1, 1),
(1,100, 1, 3),
(1,120, 1, 5),
(2,90, 2, 1),
(1,100, 2, 3),
(1,120, 3, 5),
(2,80, 3, 8),
(1,40, 4, 8),
(1,40, 5, 8),
(1,40, 6, 8),

(2,90, 7, 25),
(1,99, 7, 54),
(1,76, 7, 62),
(1,45.99, 8, 48),

(1,45.30, 9, 18),
(1,24, 9, 4);