/* 영화 티켓 예매 사이트를 구축하기 위한 ERD를 설계하세요.
- cgv, 롯데시네마, 메가박스 등 참고
- 예매는 회원만 가능
- 예매는 한 번에 여러 좌석 가능
- 영화
	- 영화번호(int, pk), 제목(varchar), 이용등급, 러닝타임, 개봉일, 시놉시스(longtext)
- 영화장르
	- 영화장르번호(pk), 영화번호(fk), 장르명(fk)
- 장르
	- 장르명(pk)
- 인물 
    - 인물번호, 이름, 출생연도, 국적, 직업, 학력, 가족, 취미, 키, 사이트
    - 가족을 테이블로 관리할 수 있지만 영화와 관련해 배우 가족은 중요한 게 아니기 때문에 하나의 속성으로 관리
    - 학력은 최종학력만 기술
    - 취미도 테이블로 만들 수 있지만 속성으로 관리
    - 직업도 테이블로 만들 수 있지만 속성으로 관리
- 참여
	- 참여번호(pk), 영화번호(fk), 인물번호(fk), 역할
- 극장
	- 극장번호(pk), 지역, 지점명, 주소, 교통안내, 주차안내, 관 갯수, 총 좌석
- 좌석
	- 좌석번호(pk), 좌석명, 극장번호(fk), 관 번호, 좌석예매상태
- 상영시간
	- 상영번호(pk), 영화번호(fk), 극장번호(fk), 상영시간, 옵션(2D, 4D 등..), 총 좌석 수, 예약 가능 좌석 수
- 회원
	- 아이디(pk), 비밀번호, 예매번호(fk), 선호 극장(fk, 3개)
- 예매
	- 예매번호(pk), 아이디(fk), 상영번호(fk), [영화명]
- 예매 리스트
	- 예매리스트 번호(pk), 예매번호(fk), 좌석번호(fk)
    
*/
DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(15)	NOT NULL,
	`me_pw`	varchar(255)	NULL,
	`me_prf_num1`	int	NOT NULL,
	`me_prf_num2`	int	NOT NULL,
	`me_prf_num3`	int	NOT NULL
);

DROP TABLE IF EXISTS `film`;

CREATE TABLE `film` (
	`fi_num`	int	NOT NULL,
	`fi_title`	varchar(50)	NULL,
	`fi_runningtime`	int	NULL,
	`fi_director`	varchar(50)	NULL,
	`fi_mainantor`	varchar( 50)	NULL,
	`fi_rate`	varchar(10)	NULL,
	`fi_date`	date	NULL,
	`fi_synopsis`	longtext	NULL
);

DROP TABLE IF EXISTS `seat`;

CREATE TABLE `seat` (
	`se_num`	char(10)	NOT NULL,
	`se_type`	varchar(10)	NULL,
	`se_seat`	char(3)	NULL,
	`se_state`	varchar(50)	NULL,
	`ci_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `prf_cine`;

CREATE TABLE `prf_cine` (
	`prf_num`	int	NOT NULL,
	`prf_ci_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `genre`;

CREATE TABLE `genre` (
	`ge_genre`	varchar(50)	NOT NULL,
	`Field`	VARCHAR(255)	NULL
);

DROP TABLE IF EXISTS `fi_genre`;

CREATE TABLE `fi_genre` (
	`fg_num`	int	NOT NULL,
	`fg_ge_genre`	varchar(50)	NOT NULL,
	`fg_fi_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `people`;

CREATE TABLE `people` (
	`pp_num`	int	NOT NULL,
	`pp_name`	varchar(50)	NULL,
	`pp_year`	int	NULL,
	`pp_nationality`	varchar(50)	NULL,
	`pp_job`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `participation`;

CREATE TABLE `participation` (
	`pt_num`	int	NOT NULL,
	`pt_pp_num`	int	NOT NULL,
	`pt_role`	varchar(50)	NULL,
	`fi_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `CopyOftimetable`;

CREATE TABLE `CopyOftimetable` (
	`ti_num`	int	NOT NULL,
	`ti_fi_num`	int	NOT NULL,
	`ti_date`	date	NULL,
	`ti_time`	varchar(5)	NULL,
	`ti_option`	varchar(10)	NULL,
	`ti_seatable`	int	NULL,
	`ti_roomnum`	int	NULL,
	`ti_total_seat`	int	NULL,
	`se_num`	char(10)	NOT NULL
);

DROP TABLE IF EXISTS `ticketing`;

CREATE TABLE `ticketing` (
	`tk_num`	varchar(10)	NOT NULL,
	`me_id`	varchar(15)	NOT NULL,
	`ti_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `bkList`;

CREATE TABLE `bkList` (
	`bkl_num`	int	NOT NULL,
	`tk_num`	varchar(10)	NOT NULL
);

DROP TABLE IF EXISTS `cinema_main`;

CREATE TABLE `cinema_main` (
	`ci_num`	int	NOT NULL,
	`ci_location`	varchar(10)	NULL,
	`ci_name`	varchar(10)	NULL,
	`ci_address`	varchar(50)	NULL,
	`ci_traffic`	longtext	NULL,
	`ci_carpark`	longtext	NULL,
	`ci_mf_count`	int	NULL,
	`Field`	int	NULL
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `film` ADD CONSTRAINT `PK_FILM` PRIMARY KEY (
	`fi_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `PK_SEAT` PRIMARY KEY (
	`se_num`
);

ALTER TABLE `prf_cine` ADD CONSTRAINT `PK_PRF_CINE` PRIMARY KEY (
	`prf_num`
);

ALTER TABLE `genre` ADD CONSTRAINT `PK_GENRE` PRIMARY KEY (
	`ge_genre`
);

ALTER TABLE `fi_genre` ADD CONSTRAINT `PK_FI_GENRE` PRIMARY KEY (
	`fg_num`
);

ALTER TABLE `people` ADD CONSTRAINT `PK_PEOPLE` PRIMARY KEY (
	`pp_num`
);

ALTER TABLE `participation` ADD CONSTRAINT `PK_PARTICIPATION` PRIMARY KEY (
	`pt_num`
);

ALTER TABLE `CopyOftimetable` ADD CONSTRAINT `PK_COPYOFTIMETABLE` PRIMARY KEY (
	`ti_num`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `PK_TICKETING` PRIMARY KEY (
	`tk_num`
);

ALTER TABLE `bkList` ADD CONSTRAINT `PK_BKLIST` PRIMARY KEY (
	`bkl_num`
);

ALTER TABLE `cinema_main` ADD CONSTRAINT `PK_CINEMA_MAIN` PRIMARY KEY (
	`ci_num`
);

ALTER TABLE `member` ADD CONSTRAINT `FK_prf_cine_TO_member_1` FOREIGN KEY (
	`me_prf_num1`
)
REFERENCES `prf_cine` (
	`prf_num`
);

ALTER TABLE `member` ADD CONSTRAINT `FK_prf_cine_TO_member_2` FOREIGN KEY (
	`me_prf_num2`
)
REFERENCES `prf_cine` (
	`prf_num`
);

ALTER TABLE `member` ADD CONSTRAINT `FK_prf_cine_TO_member_3` FOREIGN KEY (
	`me_prf_num3`
)
REFERENCES `prf_cine` (
	`prf_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `FK_cinema_main_TO_seat_1` FOREIGN KEY (
	`ci_num`
)
REFERENCES `cinema_main` (
	`ci_num`
);

ALTER TABLE `prf_cine` ADD CONSTRAINT `FK_cinema_main_TO_prf_cine_1` FOREIGN KEY (
	`prf_ci_num`
)
REFERENCES `cinema_main` (
	`ci_num`
);

ALTER TABLE `fi_genre` ADD CONSTRAINT `FK_genre_TO_fi_genre_1` FOREIGN KEY (
	`fg_ge_genre`
)
REFERENCES `genre` (
	`ge_genre`
);

ALTER TABLE `fi_genre` ADD CONSTRAINT `FK_film_TO_fi_genre_1` FOREIGN KEY (
	`fg_fi_num`
)
REFERENCES `film` (
	`fi_num`
);

ALTER TABLE `participation` ADD CONSTRAINT `FK_people_TO_participation_1` FOREIGN KEY (
	`pt_pp_num`
)
REFERENCES `people` (
	`pp_num`
);

ALTER TABLE `participation` ADD CONSTRAINT `FK_film_TO_participation_1` FOREIGN KEY (
	`fi_num`
)
REFERENCES `film` (
	`fi_num`
);

ALTER TABLE `CopyOftimetable` ADD CONSTRAINT `FK_film_TO_CopyOftimetable_1` FOREIGN KEY (
	`ti_fi_num`
)
REFERENCES `film` (
	`fi_num`
);

ALTER TABLE `CopyOftimetable` ADD CONSTRAINT `FK_seat_TO_CopyOftimetable_1` FOREIGN KEY (
	`se_num`
)
REFERENCES `seat` (
	`se_num`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_member_TO_ticketing_1` FOREIGN KEY (
	`me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_CopyOftimetable_TO_ticketing_1` FOREIGN KEY (
	`ti_num`
)
REFERENCES `CopyOftimetable` (
	`ti_num`
);

ALTER TABLE `bkList` ADD CONSTRAINT `FK_ticketing_TO_bkList_1` FOREIGN KEY (
	`tk_num`
)
REFERENCES `ticketing` (
	`tk_num`
);

