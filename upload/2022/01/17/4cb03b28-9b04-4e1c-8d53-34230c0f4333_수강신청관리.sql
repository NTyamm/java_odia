-- university 데이터베이스를 생성하여
-- ERD를 이용하여 student 테이블, professor 테이블, subject 테이블을 생성하세요
-- university DB 생성
-- create database university;
-- 생성한 university DB 확인
-- show databases; 
 use univesity;
 DROP TABLE IF EXISTS student;
 create table student(
	st_id varchar(12) not null unique,
    st_pw varchar(20) not null,
    st_name varchar(50) not null,
    st_regnum char(14) not null,
    st_num char(10) not null,
    constraint primary key(st_num)
    );
explain student;
drop table if exists subject;
 create table subject(
	su_num varchar(12) not null,
    su_name varchar(20) not null,
    su_code char(6) not null,
    su_class int,
    su_schedule varchar(30),
    constraint primary key(su_num)
	);
explain subject;
 drop table if exists professor;
 create table professor(
	pr_id varchar(12) not null unique,
    pr_pw varchar(20) not null,
    pr_name varchar(50) not null,
    pr_regnum char(14) not null,
    pr_num char(10) not null,
    constraint primary key(pr_num)
    );
explain professor;    