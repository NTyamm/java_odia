/* 의류 쇼핑몰을 구축하려 한다. 이때 필요한 테이블 구조를 잡아보세요.
 - 장바구니기능x, 한 제품의 옵션을 하나만 선택해서 여러 개 구매할 수 있다.
 -  A제품 빨강 L, A제품 파랑L은 A제품 빨강L 구매후 A제품 파랑L을 구매해야 한다.
 - 의류구매 가능, 
 - 배송정보는 회원 주소로 사용, 
 - 결제 정보 관리x, 
 - 구매는 회원만 가능, 
 - 동일한 제품은 x, 
 - 쿠폰x, 할인x,
 - murchandise, order, customer, stock
 - mrchandise에는 제품명, 품번, 가격, 제조사
	- 대분류, 중분류로 상의-가디건/니트, 티셔츠, 블라우스, 하의-트라우저/스커트, 원피스 등으로 나누는 걸 생각해야 함...
    - 옵션 : 색상, 사이즈 선택 가능
    - 동일제품은 없음
 - order에는 품번, 주문량, 구매자 아이디, 배송정보
 - customer에는 회원아이디, 이름, 주소, 연락처, 내국인만 가능
 - stock에는 품번, 단가, 제조사, 재고량
*/
create database shoppingmall;
use shoppingmall;

CREATE TABLE `goods` (
	`mu_num`	varchar(10)	NOT NULL,
	`mu_name`	varchar(50)	NULL,
	`mu_main_category`	varchar(10)	NULL,
	`mu_sub_category`	varchar(10)	NULL,
	`mu_price`	int	NULL,
	`mu_detail`	longtext	NULL,
	`ca_num`	int	NOT NULL
);


CREATE TABLE `order` (
	`or_num`	varchar(15)	NOT NULL,
	`me_id2`	varchar(16)	NOT NULL,
	`op_num`	int	NOT NULL,
	`or_date`	datetime	NULL,
	`or_amount`	int	NULL,
	`or_price`	int	NULL,
	`Field`	VARCHAR(255)	NULL
);



CREATE TABLE `option` (
	`op_num`	int	NOT NULL auto_increment,
	`op_colour`	varchar(10)	NULL,
	`op_size`	varchar(10)	NULL,
	`op_stock`	int	NULL,
	`op_mu_num`	varchar(10)	NOT NULL,
    primary key(op_num)
);

CREATE TABLE `category` (
	`ca_num`	int	NOT NULL auto_increment,
	`ca_main`	varchar(10)	NULL,
	`ca_sub`	varchar(10)	NULL,
    primary key(ca_num)
);

CREATE TABLE `member` (
	`me_id`	varchar(16)	NOT NULL,
	`me_pw`	varchar(255)	NULL,
	`me_name`	varchar(50)	NULL,
	`me_phone`	char(13)	NULL,
	`me_gender`	varchar(10)	NULL,
	`ad_num`	int	NOT NULL
);

CREATE TABLE `address` (
	`ad_num`	int	NOT NULL auto_increment,
	`ad_nickname`	varchar(10)	NULL,
	`ad_address`	varchar(50)	NULL,
	`ad_zipcode`	varchar(10)	NULL,
	`ad_detail`	varchar(50)	NULL,
    primary key(ad_num)
);

CREATE TABLE `review` (
	`re_num`	int	NOT NULL auto_increment,
	`re_or_num`	varchar(15)	NOT NULL,
	`re_contents`	longtext	NULL,
	`re_score`	varchar(10)	NULL,
	`re_op_num`	int	NULL,
	`date`	datetime	NULL,
	`품번`	varchar(10)	NOT NULL,
	`me_id`	varchar(16)	NOT NULL,
    primary key(re_num)
);


ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `order` ADD CONSTRAINT `PK_ORDER` PRIMARY KEY (
	`or_num`
);

ALTER TABLE `goods` ADD CONSTRAINT `PK_GOODS` PRIMARY KEY (
	`mu_num`
);



ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);



ALTER TABLE `order` ADD CONSTRAINT `FK_member_TO_order_1` FOREIGN KEY (
	`me_id2`
)
REFERENCES `CopyOfmember` (
	`me_id`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_option_TO_order_1` FOREIGN KEY (
	`op_num`
)
REFERENCES `option` (
	`op_num`
);

ALTER TABLE `goods` ADD CONSTRAINT `FK_category_TO_goods_1` FOREIGN KEY (
	`ca_num`
)
REFERENCES `category` (
	`ca_num`
);

ALTER TABLE `option` ADD CONSTRAINT `FK_goods_TO_option_1` FOREIGN KEY (
	`op_mu_num`
)
REFERENCES `goods` (
	`mu_num`
);

ALTER TABLE `member` ADD CONSTRAINT `FK_address_TO_member_1` FOREIGN KEY (
	`ad_num`
)
REFERENCES `address` (
	`ad_num`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_goods_TO_review_1` FOREIGN KEY (
	`mu_num`
)
REFERENCES `goods` (
	`mu_num`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_member_TO_review_1` FOREIGN KEY (
	`me_id`
)
REFERENCES `member` (
	`me_id`
);

