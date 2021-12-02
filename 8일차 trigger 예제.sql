/* 트리거: 테이블에 대한 이벤트에 반응해 자동으로 실행되는 작업
- 데이터 무결성을 지킬 수 있다. -> 연관된 테이블간의 데이터 일관성을 유지
- 트리거 사용 방법
	1. 트리거 생성
	2. 이벤트를 발생
delimiter // <-delimiter를 이용해 문장 끝을 다르게 지정할 수 있다. ;으로 끝내지 않고 트리거를 위한 문장으로 인식시키기 위해서 임시로 //로 설정한 것일뿐, 다른 걸 활용해도 괜찮음
create trigger 트리거명 타이밍(after|before) 이벤트명(insert|update|delete) on 테이블명 
for each now
begin
-- 실행코드
end //
delimiter;

-old : update이벤트 발생시 사용 가능한 것으로 값이 바뀌기 전의 행
-new : insert, update 이벤트 발생할 때 사용한 것으로, 값이 바뀐 후의 행 또는 새로 추가된 행
-변수방법
	declare 변수명 자료형 default 기본값;
-변수값 변경 방법
	set 변수명 = 값;
	set 변수명 = (select를 이용한 검색 결과);
*/

use fruit_odia;
drop trigger if exists insert_buy;
delimiter //
create trigger insert_buy after insert on buy
for each row
begin
	-- 구매한 과일의 수량
    -- 구매한 과일의 이름
    update fruit
		set
			fr_amount = fr_amount + new.bu_amount
		where
			fr_name = new.bu_fr_name;
end//
delimiter ;
-- 트리거 확인을 위해 buy 테이블에 행을 추가
-- insert into buy values(4,'바나나',50,now(),'송이','과일상회');
-- 트리거에 의해 fruit 테이블이 변경됐는지 확인 (근데 나는 이유 모르겠지만 과일 데이터 하나도 없음ㅋㅋ)
select * from fruit_odia.fruit;
-- 만들어진 트리거를 확인
show triggers;
-- 과일을 판매했을 때 과일 수량을 맞춰주는 트리거를 만들어 보세요. (과일데이터 왜인지 몰라도 다 날아가서 0개던데?ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ)
delimiter //
create trigger insert_sell after insert on sell
for each row
begin
	declare _amount int default 0; -- 할 필요 없는데 그냥 한 번 변수선언 해보기
    set _amount = new.se_amount;
	update fruit
		set fr_amount = fr_amount - new._amount
        where
			fr_name = new.se_fr_name;
end//
delimiter ;

-- 트리거 확인을 위해 sell 테이블에 행 추가
insert into sell values(2,'바나나',3,'송이',12000);
select*from fruit;