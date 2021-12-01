-- cgv 홈페이지에서 영화 듄 정보를 이용하여 영화정보, 인물 등 필요한 정보를 DB에 추가
-- 배우는 대표 2명만
/*
insert into genre values('가복'),('공포/호러'),('드라마'),('SF'),('멜로/로맨스'),('코미디'),('애니메이션'),('느와르'),('단편'),('로드무비'),('무협'),('뮤지컬'),('뮤직'),('미스터리')
						,('범죄'),('옴니버스'),('서부'),('스릴러'),('스포츠'),('시대극/사극'),('아동'),('액션'),('어드벤처'),('역사'),('전기'),('전쟁'),('종교'),('재난')
                        ,('청춘영화'),('퀴어'),('환타지'),('학원물'),('에로'); 
*/
/*
-- 영화 기본 정보 추가
delete from movie where mo_num=1;
insert into movie values(1,'듄','12세 이상 이용가',155,'2021.10.20',"“듄을 지배하는 자가 우주를 지배한다!”

10191년, 아트레이데스 가문의 후계자인 폴(티모시 샬라메)은 시공을 초월한 존재이자 
전 우주를 구원할 예지된 자의 운명을 타고났다. 
그리고 어떤 계시처럼 매일 꿈에서 아라키스 행성에 있는 한 여인을 만난다. 
모래언덕을 뜻하는 '듄'이라 불리는 아라키스는 물 한 방울 없는 사막이지만 
우주에서 가장 비싼 물질인 신성한 환각제 스파이스의 유일한 생산지로 이를 차지하기 위한 전쟁이 치열하다. 
황제의 명령으로 폴과 아트레이데스 가문은 죽음이 기다리는 아라키스로 향하는데…

위대한 자는 부름에 응답한다, 두려움에 맞서라, 이것은 위대한 시작이다!");
*/
/*
-- 듄 영화 장르 추가
insert into movie_genre values(1,'SF',1);
*/
/*
-- 듄 인물정보 추가
insert into `character` values(1,'드니 빌뇌브','1967.10.3','캐나다','영화감독'),(2,'티모시 샬라메','1995.2021-12-027','미국','배우'),(3,'레베카 퍼거슨','1983.10.19','스웨덴','배우');
select * from `character`;
*/
/*
-- 참여인물정보 추가 
insert participation values(1,1,1,'감독'),(2,1,2,'주연'),(3,1,3,'주연');
select*from participation;
*/

/*
-- cgv 홈페이지에서 강감점 정보를 이용하여 db에 추가, 상영시간표x, 좌석은 'A1'~'A5', 'B1'~B5만 추가, 관은 총 3개 추가
insert into theater values(1,'서울','강남점','서울특별시 강남구 강남대로 438 (역삼동',"# 지하철
2호선 | 강남역 11번 출구
9호선 | 신논현역 5번출구

# 버스
- 분당지역
   좌석버스: 1005-1, 1005-2, 6800, 5500-2
   간선버스: 408, 462
   광역버스: 9404, 9408
- 강북지역
   간선버스: 140, 144, 145, 471
- 강서지역
   좌석버스: 1500
   간선버스: 360
- 강동지역
   간선버스: 402, 420, 470, 407
- 인근경기지역
   좌석버스: 3030, 2002, 2002-1
   광역버스: 9409, 9500, 9501, 9503, 9700, 9711","# 주차정보
- 위치: 건물 지하2F ~ 지하4F

# 주차요금
- CGV 영화 관람 시 주차 3시간 6,000원
- 주차시간 (3시간) 초과 시 10분 당 1,000원
※ 발렛서비스 운영시간 : 오전 8시 이후 ~ 오후 20시

※ 발렛 무료 서비스는 영화 관람 고객 한 함.  (영화 미관람 시 건물 주차장에서 별도 정산)
※ 20시 이후 입차 차량은 발렛서비스 이용이 제한될 수 있으며, 별도 운영되는 주차팀의 사정에 따라 변경될 수 있습니다.

# 이용안내
- 주차공간이 협소하여 평일 오후/주말은 주차가 어렵습니다.
- 편리한 대중교통 이용을 이용하여 주시기 바랍니다.",3,30);
*/
/*
update theater set th_name='CGV강남' where th_name='강남점';
*/
/*
ALTER TABLE `cgv`.`ticketing_list` 
DROP FOREIGN KEY `FK_seat_TO_ticketing_list_1`;
ALTER TABLE `cgv`.`ticketing_list` 
DROP INDEX `FK_seat_TO_ticketing_list_1` ;
;
ALTER TABLE `cgv`.`seat` 
CHANGE COLUMN `st_state` `st_state` VARCHAR(50) NOT NULL DEFAULT '사용가능' ,
CHANGE COLUMN `st_type` `st_type` VARCHAR(50) NOT NULL DEFAULT '일반' ;
ALTER TABLE `cgv`.`seat` 
CHANGE COLUMN `st_num` `st_num` INT NOT NULL AUTO_INCREMENT ;
insert into seat(st_name,st_th_num,st_room_num) values('A1',1,1 ),('A2',1,1 ),('A3',1,1 ),('A4',1,1 ),('A5',1,1 ),
		('B1',1,1 ),('B2',1,1 ),('B3',1,1 ),('B4',1,1 ),('B5',1,1 ),
        ('A1',1,2 ),('A2',1,2 ),('A3',1,2 ),('A4',1,2 ),('A5',1,2 ),
		('B1',1,2 ),('B2',1,2 ),('B3',1,2 ),('B4',1,2 ),('B5',1,2 ),
        ('A1',1,3 ),('A2',1,3 ),('A3',1,3 ),('A4',1,3 ),('A5',1,3 ),
		('B1',1,3 ),('B2',1,3 ),('B3',1,3 ),('B4',1,3 ),('B5',1,3 );
*/
/*
-- cgv 영화 듄, 강남점 12월 1~3일 상영 시간표를 보고 DB에 추가
insert into `schedule` values(1,1,1,' 2021-12-01','15:45',1,'백신패스관',10,10),(2,1,1,' 2021-12-01','21:20',1,'백신패스관',10,10),
							(3,1,1,'2021-12-02','10:20',1,'백신패스관',10,10),(4,1,1,'2021-12-02','16:20',1,'백신패스관',10,10),(5,1,1,'2021-12-02','19:30',1,'백신패스관',10,10),
                            (6,1,1,'2021-12-03','10:30',1,'백신패스관',10,10),(7,1,1,'2021-12-03','16:30',1,'백신패스관',10,10),(8,1,1,'2021-12-03','19:45',1,'백신패스관',10,10);
*/

-- cgv강남점의 12월 1일 상영시간표를 확인
select mo_title, mo_runtime, mo_date, sc_option, sc_total_seat, sc_seat, sc_time from `schedule`
	join theater on sc_th_num=th_num
    join movie on sc_mo_num=mo_num
    where sc_date='2021-12-01' and th_name = 'CGV강남';

-- 아이디가 abc123, 비번이 abc123인 회원이 가입
-- insert into `member` values('abc123','abc123');
/*
ALTER TABLE `cgv`.`ticketing_list` 
ADD INDEX `FK_seat_TO_ticketing_list_1_idx` (`tl_st_num` ASC) VISIBLE;
;
ALTER TABLE `cgv`.`ticketing_list` 
ADD CONSTRAINT `FK_seat_TO_ticketing_list_1`
  FOREIGN KEY (`tl_st_num`)
  REFERENCES `cgv`.`seat` (`st_num`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
*/  

-- abc123 회원이 12월 1일 21:20 1관에서 하는 영화 듄을 A1,A2 두 자리를 예매했다.
-- 1. 예매에 데이터 추가
insert into ticketing select 1, 'abc123' sc_num from schedule where sc_date='2021-12-01' and sc_time='21:20' and sc_room_num=1;
-- 2. 예매리스트에 데이터 추가
insert into ticketing_list select 1,1, st_num=seat where st_room_num=1 and st_name = 'A1'; -- select로 하기 족같아 강사님거 보고 수정해 
insert into ticketing_list select 1,1, st_num=seat where st_room_num=1 and st_name = 'A2';
-- 3. 상영시간 정보를 수정
update `schedule` set sc_seat=sc_seat -2 where sc_date='2021-12-01' and sc_time = '21:20' and sc_room_num=1;
select * from schedule 
	where sc_date='2021-12-01' and sc_time='21:20' and sc_room_num=1;
    
-- cgv강남,  12월 1일 21:20 1관에서 하는 영화에서 예매 가능한 좌석을 확인
select th_name, st_room_num, st_name from seat
	 join theater on th_num=st_th_num
     where th_name='CGV강남' and st_room_num=1;
select st_room_num, st_name from seat where st_th_num=1;
select* from ticketing_list join ticketing on tl_tk_num=tk_num
	join `schedule` on tk_sc_num=sc_num
    where sc_th_num=1 and sc_room_num=1 and sc_date='2021-12-01' and sc_time='21:20';
    
select * from ticketing_list
	join ticketing on tl_tk_num=tk_num
    where tk_sc_num=2;
    
-- 예약 가능한 좌석 확인
select * from seat 
	join (select * from ticketing_list
		join ticketing on tl_tk_num=tk_num
		where tk_sc_num=2) 
    as tl 
    on st_num = tl_st_num
    where st_th_rum=1 and st_room_num=1 and tl_num is null;
     