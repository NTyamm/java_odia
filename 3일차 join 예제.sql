-- 컴퓨터 개론을 강의하는 교수님 교수번호 확인하는 쿼리문을 작성하세요.
-- lecture와 subject를 join해야 함
select le_pr_num from university_odia.subject
	inner join lecture
    on le_su_num = su_num
    where su_title = '컴퓨터 개론';
select le_pr_num from university_odia.subject
	join lecture
    on le_su_num = su_num
    where su_title = '컴퓨터 개론';
    
-- 컴퓨터개론 3분반을 듣는 학생들의 명단을 검색하는 쿼리를 작성해 보세요.
select st_name from  univerity_odia.course
	join subject
    on co_su_num = su_num
	join student
    on co_st_num = st_num
    where su_title = '컴퓨터 개론' and su_class_num = 3;
    
-- 2021160123 학번인 홍길동 학생이 수강한 모든 과목명을 확인하는 쿼리를 작성하세요.
select su_title from course
	join subject
		on co_su_num = su=num
	where st_num = 2021160123;
    
-- 이순신 교수님의 강의를 듣는 학생들 명단을 확인하는 쿼리를 작성하세요.
select st_name from lecture
	join professor
		on le_pr_num = pr_num
	join course
		on co_su_num = le_su_num
	join student
		on co_st_num = st=num
	where pr_name = '이순신';
    
-- 2021160001 학번 학생이 컴퓨터 개론 3분반 강의를 신청했다. 이 때 알맞은 쿼리를 작성하세요.
-- insert
-- insert into university_odia.course(co_st_num, co_su_num) values(2021160001,1);
-- 또는 검색결과를 이용해서 삽입
-- insert into course(co_st_num, co_su_num) select 2021160015, su_num from subject where su_class_num = 3 and su_title = '컴퓨터개론';

-- 2021160123 학번 홍길동 학생이 수강중인 컴퓨터 개론 3분반 성적이 A+가 나왔다. 이 때 알맞은 쿼리를 작성하세요
-- update university_odia.course set co_score='A+' where co_st_num = 2021160123 and co_su_num = 1;