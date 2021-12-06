-- create database fruit_odia;
use fruit_odia;
CREATE TABLE `fruit` (
	`fr_name`	varchar(30)	NOT NULL,
	`fr_price`	int	not null default 0,
	`fr_amount`	int	not null default 0,
	`fr_unit`	varchar(10)	NULL
);

CREATE TABLE `buy` (
	`bu_num`	int	not NULL auto_increment,
	`bu_fr_name`	varchar(30)	not NULL,
	`bu_amount`	int	not null default 0,
	`bu_date`	datetime not NULL default current_timestamp,
	`bu_unit`	varchar(10)	NULL,
	`bu_st_name`	varchar(20)	NOT NULL,
    primary key (`bu_num`)
);

CREATE TABLE `store` (
	`st_name`	varchar(20)	NOT NULL,
	`st_address`	varchar(50)	NULL
);

CREATE TABLE `sell` (
	`se_num`	int	NOT NULL,
	`se_fr_name`	varchar(30)	NOT NULL,
	`se_amount`	int	not NULL default 0,
	`se_unit`	varchar(10)	NULL,
	`se_price`	int	not NULL default 0,
	`se_date`	datetime not NULL default now(),
	`type`	varchar(4) not NULL,
    primary key (`se_num`)
);

ALTER TABLE `fruit` ADD CONSTRAINT `PK_FRUIT` PRIMARY KEY (
	`fr_name`
);

ALTER TABLE `store` ADD CONSTRAINT `PK_store` PRIMARY KEY (
	`st_name`
);


ALTER TABLE `buy` ADD CONSTRAINT `FK_BUY_FRUIT` FOREIGN KEY (
	`bu_fr_name`
 ) references `fruit`(`fr_name`);
 
 ALTER TABLE `buy` ADD CONSTRAINT `FK_BUY_STORE` FOREIGN KEY (
	`bu_st_name`
 ) references `store`(`st_name`);
 
 ALTER TABLE `sell` ADD CONSTRAINT `FK_SELL_FRUIT`FOREIGN KEY (
	`se_fr_name`
 ) references `fruit`(`fr_name`);