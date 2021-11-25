-- 단가가 3000원 이상 6000원 미만인 제품들을 확인하세요
-- select (보고싶은 속성명) from (테이블) where 조건
SELECT * FROM 제품관리_odia.제품
	where 단가 >= 3000 and 단가 <= 6000 
    order by 제조업체, 제품명
    ;
    
-- between : A이상 B이하일 때 사용
select 제조업체, 제품명, 재고량, 단가 from 제품관리_odia.제품
	where 단가 between 3000 and 6000
    order by 제조업체, 제품명;

-- 제조업체가 대한식품 또는 민국푸드인 제품들을 확인    
-- in : 여러 값 중 하나를 만족하는 경우 사용
select * from 제품관리_odia.제품 where 제조업체 ='대한식품' or 제조업체 = '민국푸드' order by 제조업체 ;
select * from 제품관리_odia.제품 where 제조업체 IN('대한식품','민국푸드') order by 제조업체 ;

-- 등급이 silver 또는 gold인 회원의 아이디를 확인
select 고객아이디 from 제품관리_odia.고객 where 등급 IN ('gold','shilver');
select 고객아이디 from 제품관리_odia.고객 where 등급 = 'gold'or 등급='shilver';

-- 등급이 silver 또는 gold인 회원이 주문한 제품명을 확인
select distinct 제품명 from 제품관리_odia.제품
	join 주문 on 주문제품 = 제품번호
    join 고객 on 주문고객 = 고객아이디
    where 등급 in ('gold','shilver');
    
-- 가격이 2600원 이상인 제품의 제품명과 단가를 확인
select 제품명, 단가 from 제품 where 단가 >= 2600;
-- 서브쿼리 : 쿼리문 안에 들어가 있는 쿼리
-- select () from () [where ()];
-- 쿵떡파이의 가격보다 크거나 같은 제품의 제품명과 단가를 확인
-- select 제품명, 단가 from 제품 where (여기에... 쿵떡파이의 가격보다 크거나 같은 제품을 셀렉트와 조인으로 채워넣기)  ;
select 제품명, 단가 from 제품 where 단가 >=( select 단가 from 제품 where 제품명 = '쿵떡파이' );

-- 그냥만두의 가격보다 크거나 같고 얼큰라면의 가격보다 크거나 같은 제품의 제품명과 단가를 확인
select 제품명, 단가 from 제품 where 단가 >=(select 단가 from 제품 where 제품명 ='그냥만두') and 단가>=(select 단가 from 제품 where 제품명 ='얼큰라면') order by 제조업체;
select 제품명, 단가 from 제품 where 단가 >=(select max(단가) 단가 from 제품 where 제품명 in('그냥만두','얼큰라면')); /*이런 방법도 있다~*/

-- ALL() : 전부를 만족하는 경우들만 확인. AND
select 제품명, 단가 from 제품 where 단가 >= ALL(select 단가 from 제품 where 제품명 in('그냥만두','얼큰라면')); 

-- ANY() : 하나 이상 만족하는 경우들만 확인. OR
-- 그냥만두의 가격보다 크거나 같거나 얼큰라면의 가격보다 크거나 같은 제품의 제품명과 단가를 확인
select 제품명, 단가 from 제품 where 단가 >=(select 단가 from 제품 where 제품명 ='그냥만두') or 단가>=(select 단가 from 제품 where 제품명 ='얼큰라면');
select 제품명, 단가 from 제품 where 단가 >= ANY(select 단가 from 제품 where 제품명 in('그냥만두','얼큰라면')); 
select 제품명, 단가 from 제품 where 단가 >=(select min(단가) 단가 from 제품 where 제품명 in('그냥만두','얼큰라면')); /*이런 방법도 있다~*/

-- GROUP BY : WHERE 절 다음에 나와야 함, ORDER BY 앞, 같은 그룹끼리 묶어줌
select*from 제품 GROUP BY 제조업체; /*하나의 속성으로 묶어서 확인할 때 사용*/ 
select distinct 제조업체, 제품번호 from 제품; /*하나의 속성으로 묶이지 않음*/

-- 대한식품에서 만든 제품 개수 확인
select count(*) from 제품 where 제조업체 = '대한식품';

-- 각 회사별 만든 제품 개수 확인
select 제조업체, count(*) as'제조업체 별 제품 수' from 제품 group by 제조업체;

-- 1번 이상 주문한 고객별 주문한 제품 개수 *1번 이상은...걍 모두니까 조건 필요x
select 주문고객, sum(수량) as '재구매 고객 주문 제품 갯수' from 주문 group by 주문고객;
-- 1번 이상 주문한 고객별 주문한 주문 횟수
select 주문고객, count(*) as '재구매 고객 주문 횟수' from 주문 group by 주문고객;

-- 1번 이상 주문한 고객별 고객의 총 주문 금액을 확인 *주문 횟수 조건 필요x
select 주문고객, 단가*sum(수량) as '고객별 총 주문액' from 주문 /* 여러 제품 주문할 경우 값이 제대로 출력되지 않음 */
	join 제품 on 주문제품=제품번호 where 단가
	group by 주문고객;

select 주문고객, sum(단가*수량) as '고객별 총 주문액' from 주문 /*단가*수량을 sum() 안에 넣어줘야 함*/
	join 제품 on 주문제품=제품번호 where 단가
	group by 주문고객 order by `고객별 총 주문액`; /*``는 데이터베이스 이름, 테이블 이름, 속성 이름 등에 사용쓰*/

-- 1번 이상 주문한 고객중 총 주문 금액이 100000원 이상인 고객 확인
-- where 절에는 GROUP BY로 작업한 집약함수를 이용한 조건을 걸 수 없다
select 주문고객 as '총 주문 금액' from 주문 
	join 제품 on 주문제품=제품번호 
	where (select sum(단가*수량)) >= 100000 group by 주문고객 order by `총 주문 금액` ; 
    -- HAVING 절은 GROUP BY로 작업한 내용에 조건을 걸어줄 때 사용
select 주문고객, sum(수량*단가) as `총 주문 금액` from 주문 
	join 제품 on 주문.주문제품=제품.제품번호 
	group by 주문고객 having `총 주문 금액`>=100000 order by `총 주문 금액` desc;
    
-- 제품별 주문한 제품 번호와 수량, 제조업체를 확인
select 제품명, 제품번호, sum(수량) as '누적주문량' , 제조업체 from 주문 
	join 제품 on 주문.주문제품=제품.제품번호
    group by 주문제품;
-- 제조업체별 가장 많이 팔린 제품을 제조업체, 제품번호, 주문수량을 확인
select 제조업체, 주문제품 AS 제품번호 , MAX(누적주문량) AS '주문수량' from 
	(select 제조업체, 제품번호, sum(수량) as '누적주문량' from 주문
		join 제품 on 주문제품=제품번호
		GROUP BY 주문제품
		ORDER BY 제조업체) as `제품별판매량`  
	GROUP BY 제조업체;
    
-- with group : 부분 총합을 구해줌
-- 제품별 주문 수량을 나타내려고 한다
select 주문고객, 주문제품, sum(수량) from 주문
	group by 주문제품
    with rollup; /*수량에 대한 총합이 마지막에 출력됨*/
    
-- LIMIT : 검색 결과의 갯수를 제한할 때 사용
-- LIMIT 정수1 : 정수1개만큼 결과를 보여줌
-- LIMIT 번지, 정수1 : 번지부터 정수1개의 결과를 보여줌
SELECT*FROM 주문 LIMIT 5; -- 처음5개
-- 한 번에 주문 내역을 확인할 수 있는 갯수가 5개인 경우로, 1페이지에 해당
SELECT*FROM 주문 LIMIT 0,5; -- 0번지부터 5개
-- 한 번에 주문 내역을 확인할 수 있는 갯수가 5개인 경우로, 2페이지에 해당
SELECT*FROM 주문 LIMIT 5,5; -- 5번지부터 5개
-- 한 번에 주문 내역을 확인할 수 있는 갯수가 5개인 경우로, 3페이지에 해당
-- 10번지부터 5개(5(3-1) : 갯수 *(페이지번호 -1)
SELECT*FROM 주문 LIMIT 10, 5; 

-- 가장 많은 금액을 사용한 고객 아이디를 확인
select 주문고객, sum(단가*수량) as '주문총액' from 주문 /*단가*수량을 sum() 안에 넣어줘야 함*/
	join 제품 on 주문제품=제품번호 where 단가
	group by 주문고객 order by `주문총액` desc limit 1; /*``는 데이터베이스 이름, 테이블 이름, 속성 이름 등에 사용쓰*/
    
-- 가장 많은 제품 갯수를 구매한 고객 아이디를 확인
select 주문고객, sum(수량) as '주문총량' from 주문 /*단가*수량을 sum() 안에 넣어줘야 함*/
	join 제품 on 주문제품=제품번호 where 단가
	group by 주문고객 order by `주문총량` desc limit 1; /*``는 데이터베이스 이름, 테이블 이름, 속성 이름 등에 사용쓰*/

-- 20대가 구매한 제품목록을 확인
select 제품명 as '20대 구매 제품' from 제품
	join 주문 on 주문제품=제품번호
    join 고객 on 주문고객=고객아이디
    where 나이 between 20 and 29
    group by 제품명;

-- 20대가 구매를 가장 많이 한 제품을 확인
select 제품명 as '최다주문제품'from 제품
	join 주문 on 주문제품=제품번호
    join 고객 on 주문고객=고객아이디
    where 나이 between 20 and 29
    group by 제품명
    order by sum(수량) desc limit 1
   ;