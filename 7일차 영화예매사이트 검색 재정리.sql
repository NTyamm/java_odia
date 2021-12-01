-- cgv강남,  12월 1일 21:20 1관에서 하는 영화에서 예매 가능한 좌석을 확인
select th_name, st_room_num, st_name from seat
	 join theater on th_num=st_th_num
     where th_name='CGV강남' and st_room_num=1;
-- 1관의 총 좌석 리스트 확인
select st_room_num, st_name from seat where st_th_num=1;
select* from ticketing_list join ticketing on tl_tk_num=tk_num
	join `schedule` on tk_sc_num=sc_num
    where sc_th_num=1 and sc_room_num=1 and sc_date='2021-12-01' and sc_time='21:20';
-- 티케팅으로 나간 좌석 확인    
-- 먼저 잘못 추가된 데이터 삭제
DELETE FROM TICKETING_LIST WHERE TL_NUM=2;
select * from ticketing_list
	join ticketing on tl_tk_num=tk_num
    where tk_sc_num=2;

-- 예약가능한 좌석 확인
select * from seat 
	LEFT join (select * from ticketing_list
		join ticketing on tl_tk_num=tk_num
		where tk_sc_num=2) 
    as tl 
    on st_num = tl_st_num
    where st_th_Num=1 and st_room_num=1 and tl_num is null;
     