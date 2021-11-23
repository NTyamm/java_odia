-- 2021160123 학번 학생이 수강 신청한 과목 제목 들을 확인하는 쿼리문

SELECT co_st_num, su_title FROM university_odia.course
	left join subject
    on course.co_st_num = subject.su_num
    where co_st_num = 2021160123;
    
SELECT co_st_num, su_tilte FROM university_odia.course
	left join subject
    on co_su_num = su_num
	where co_st_num = 2021160123;
-- 테이블1과 테이블2의 순서를 바꾼 경우 결과가 달라짐
select*from subject
	left join course
    on co_su_num = su_num;
    
-- 2000160001 교수번호를 가진 교수님이 강의하는 강의 제목과 일정을 확인하는 쿼리문을 작성하세요
select su_title, su_schedule from university_odia.lecture
	left join subject 
    on lecture.le_su_num = subject.su_num
    where le_pr_num = 2000160001;
    
-- 컴퓨터 개론을 강의하는 교수님 교수번호 확인하는 쿼리문을 작성하세요.
-- lecture와 subject를 join해야 함
select le_pr_num from university_odia.lecture
	left join subject
    on le_su_num = su_num
    where su_title = '컴퓨터 개론';