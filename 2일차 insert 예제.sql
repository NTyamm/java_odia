-- insert into student values('2021160123' , 'hong', 'hong', '홍길동', '020101-3456789');
-- id : hong123, pw : pw123으로 하려고 했으나 순서를 착각해서 잘못 입력했더니 원하지 않은 결과가 발생
-- insert into student values('2021160123' , 'hong123', 'pw123', '황길동', '020102-3567891');
-- insert into student(st_num, st_id, st_pw, st_name, st_reg_num)
-- 	values('2021160001', 'kang' , 'kang', '강감찬', '021225-3045432');

-- 기동이 데이터 사라짐!!정신차려!!! 
-- id: kimid, pw : pwkim으로 하기 위해 속성 순서를 st_pw, st_id 순으로 바꿔서 원하는 결과가 나옴
-- insert into student(st_num, st_pw, st_id, st_name, st_reg_num)
-- values(2021160015, 'pwkim' , 'kimid', '김영희', '021225-4345432');
-- insert into student 
-- values(2021123005, 'park', 'parkpw', '박철수', '021221-4433221'),
-- (2021466005 , 'park3', 'parkpw', '박수철', '021231-4433821');
-- select*from university_odia.student;

-- 교수번호가 2000160001인 이순신 교수님의 정보를 추가하는 쿼리문을 작성하세요.
-- id : lee, pw : leelee, 주민번호 : 550505-1234567
-- insert into professor values(2000160001, 'lee', 'leelee', '이순신', '550505-1234567');

-- 과목명이 컴퓨터 개론이고 과목 코드는 MSC001, 일정과 분반은 미정인 과목을 추가하는 쿼리문을 박성하세요.
-- insert into subject(su_title, su_code) values('컴퓨터 개론','MSC001');

 -- 2000160001 교수님이 1번 과목을 강의한다. 이 내용을 lecture 테이블에 추가하는 코드를 작성하세요.
-- insert into lecture(le_pr_nu, le_su_nu) values (2000160001, 1); 

-- 2021160123 홍길동 학생이 1번 과목을 수강신청 했다. 이 내용을 추가하는 코드를 작성하세요.
-- insert into course(co_st_num, co_su_num) values(2021160123, 1);


-- 2000160001 교수님이 1번 과목을 강의할 강의 시간표의 일정 새로 나왔다. 월1,2로 결정되었고, 분반은 3분반이다.
-- 다음을 실행하는 쿼리문을 작성하세요.
-- update subject set su_schedule='월 1, 2교시', su_class_num = 3 where su_num=1;

select*from university_odia.lecture
