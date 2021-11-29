/* 사원들의 월급을 관리하는 시스템을 위한 DB를 설계하세요.
- 월급지급내역 관리 포함
직급
- 사원, 대리, 과장, 부장, 전무, 이사
월급
- 월급은 직급별 기본급에 직급별 호봉에 따른 추가금
예) 사원 기본급 200만, 호봉별 추가금 10만원
	2년차 사원 홍길동의 월급은? 220만원
*/

create database company;
use company;
create table employee(
	em_num int not null,
	em_name varchar(20) not null,
    em_de_department varchar(10) not null,
    em_sa_level varchar(2) not null,
	em_year int(4) not null,
    em_reg_num int(14) not null,
    em_join_year int(4) not null
);
create table salary(
	sa_level char(2) not null,
    sa_base_salary int not null,
	sa_add_salary int not null
);
create table department(
	de_department varchar(10) not null
);

ALTER TABLE `company`.`employee` 
ADD COLUMN `employeecol` VARCHAR(45) NOT NULL AFTER `em_de_department`,
CHANGE COLUMN `em_reg_num` `em_reg_num` CHAR(14) NOT NULL AFTER `em_num`,
CHANGE COLUMN `em_de_department` `em_de_department` VARCHAR(10) NOT NULL AFTER `em_year`,
CHANGE COLUMN `em_name` `em_name` VARCHAR(45) NOT NULL ,
CHANGE COLUMN `em_sa_level` `em_sa_level` VARCHAR(4) NOT NULL ,
ADD PRIMARY KEY (`em_num`),
ADD UNIQUE INDEX `em_reg_num_UNIQUE` (`em_reg_num` ASC) VISIBLE;
;
-- 외래키 설정이 빠짐
ALTER TABLE `company`.`employee` 
DROP FOREIGN KEY `em_de_department`;
ALTER TABLE `company`.`employee` 
CHANGE COLUMN `em_de_department` `em_de_department` VARCHAR(10) NULL ;
ALTER TABLE `company`.`employee` 
ADD CONSTRAINT `em_de_department`
  FOREIGN KEY (`em_de_department`)
  REFERENCES `company`.`department` (`de_department`)
  ON DELETE SET NULL
  ON UPDATE SET NULL;

ALTER TABLE `company`.`employee` 
DROP FOREIGN KEY `em_sa_level`;
ALTER TABLE `company`.`employee` 
CHANGE COLUMN `em_sa_level` `em_sa_level` VARCHAR(10) NULL ;
ALTER TABLE `company`.`employee` 
ADD CONSTRAINT `em_sa_level`
  FOREIGN KEY (`em_sa_level`)
  REFERENCES `company`.`salary` (`sa_level`);