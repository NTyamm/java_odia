/* 직급에 다음 데이터를 추가하는 쿼리를 작성하세요.
- 사원, 대리, 과장, 부장, 전무, 이사, 대표이사
사원 200 10
대리 230 15
과장 250 20
부장 280 30
전무 300 35
이사 350 40
대표이사 400 50
*/
/*
insert into salary values('사원', 200, 10);
insert into salary values('대리', 230, 15);
insert into salary values('과장', 250, 20);
insert into salary values('부장', 280,30);
insert into salary values('전무', 300, 30);
insert into salary values('이사', 350, 40);
insert into salary values('대표이사', 400, 50);
SELECT * FROM company.salary;
*/

/* 아래 부서 정보를 추가하는 쿼리를 작성하세요.
영업
회계
관리
마케팅
개발*/
/*  insert into department values
	('영업'),
	('회계'),
	('관리'),
	('마케팅'),
    ('개발');
SELECT * FROM COMPANY.DEPARTMENT;
*/

/* 사번이 2019001, 2년차, 부서는 회계부이고 주민번호는 123456-12345657인 홍길동 사원의 정보를 추가하세요 */
 INSERT INTO company.EMPLOYEE VALUES (2019001, '123456-1234567','홍길동','사원', 2 ,'회계', 2019);
 SELECT * FROM COMPANY.EMPLOYEE;