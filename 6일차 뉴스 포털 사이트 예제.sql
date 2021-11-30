/* 스포츠, 연예, 일반 뉴스를 관리하는 사이트를 구축하기 위한 ERD를 설계하세요.
- 네이버 뉴스 참고
- 신문사
	- 신문사번호(pk), 신문사명, 발행 기사 목록, 신문사 소개
- 기자
	- 기자아이디(pk), 비밀번호, 기자이름, 구독자수, 응원수 등, 소속신문사(fk), 작성 기사 목록, 최종학력
- 분야
	- 신문사별로 스포츠, 연예, 일반 카테고리를 가짐
- 뉴스 등록, 수정, 삭제 기능
	- 뉴스 등록과 수정, 삭제는 기자인 회원만이 할 수 있음
    - 뉴스 등록시에는 스포츠, 연예, 일반으로 카테고리를 설정 (일반/스포츠/연예), 중분류(경제,정치,야구,축구 등)
    - 뉴스고유번호(pk), 제목, 내용, 기자명(fk), 발행일, 최종수정일, [발행신문사(fk)], 조회수, 대분류(일반/스포츠/연예), 중분류(경제,정치,야구,축구 등)
- 댓글 기능
	- 한 명의 회원은 기사 하나당 여러번 댓글을 달 수 있음
    - 하나의 기사에는 여러 회원이 댓글 가능
    - 댓글번호(pk), 뉴스번호(fk), 회원아이디(fk), 댓글내용, 공감, 비공감, 답글번호(fk), 작성일
- 답글 기능
	-
- 반응(좋아요, 싫어요 등) 기능
	- 한 명의 회원은 기사 하나당 좋아요 또는 싫어요 하나만 선택 가능
    - 하나의 기사에는 여러 회원이 좋아요 또는 싫어요 가능
	- 댓글과 답글에도 좋아요/싫어요 
    - 반응번호(pk), 뉴스번호(fk), 아이디(fk), 상태(좋아요, 훈훈해요, 슬퍼요, 화나요)
- 회원(일반)
    아이디(pk), 비밀번호, 이름, 주소, 연락처
*/
create database news;
use news;

DROP TABLE IF EXISTS `reporter`;

CREATE TABLE `reporter` (
	`rp_id`	varchar(16)	NOT NULL,
	`rp_pw`	varchar(255)	NULL,
	`rp_name`	varchar(255)	NULL,
	`rp_reg_num`	char(14)	NULL,
	`rp_company`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
	`nw_num`	int	NOT NULL,
	`nw_title`	varchar(50)	NULL,
	`nw_contents`	longtext	NULL,
	`nw_reg_date`	datetime	NULL,
	`nw_update`	datetime	NULL,
	`nw_company`	varchar(50)	NULL,
	`nw_main_category`	varchar(50)	NULL,
	`nw_sub_category`	varchar(50)	NULL,
	`nw_rp_id`	varchar(16)	NOT NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(16)	NOT NULL,
	`me_pw`	varchar(255)	NULL
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
	`co_num`	int	NOT NULL,
	`me_id`	varchar(16)	NOT NULL,
	`nw_num`	int	NOT NULL,
	`co_contents`	longtext	NULL,
	`co_up`	int	NULL,
	`co_down`	int	NULL,
	`co_date`	date	NULL,
	`co_del`	cahr(1)	NULL,
	`co_num2`	int	NOT NULL
);

DROP TABLE IF EXISTS `reaction`;

CREATE TABLE `reaction` (
	`re_num`	int	NOT NULL,
	`re_state`	varchar(10)	NULL,
	`me_id`	varchar(16)	NOT NULL,
	`nw_num`	int	NOT NULL
);

ALTER TABLE `reporter` ADD CONSTRAINT `PK_REPORTER` PRIMARY KEY (
	`rp_id`
);

ALTER TABLE `news` ADD CONSTRAINT `PK_NEWS` PRIMARY KEY (
	`nw_num`
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
	`co_num`
);

ALTER TABLE `reaction` ADD CONSTRAINT `PK_REACTION` PRIMARY KEY (
	`re_num`
);

ALTER TABLE `news` ADD CONSTRAINT `FK_reporter_TO_news_1` FOREIGN KEY (
	`nw_rp_id`
)
REFERENCES `reporter` (
	`rp_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_member_TO_comment_1` FOREIGN KEY (
	`me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_news_TO_comment_1` FOREIGN KEY (
	`nw_num`
)
REFERENCES `news` (
	`nw_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_comment_TO_comment_1` FOREIGN KEY (
	`co_num2`
)
REFERENCES `comment` (
	`co_num`
);

ALTER TABLE `reaction` ADD CONSTRAINT `FK_member_TO_reaction_1` FOREIGN KEY (
	`me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `reaction` ADD CONSTRAINT `FK_news_TO_reaction_1` FOREIGN KEY (
	`nw_num`
)
REFERENCES `news` (
	`nw_num`
);

