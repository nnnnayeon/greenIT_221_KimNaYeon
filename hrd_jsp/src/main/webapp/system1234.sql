-- 실행 : alt + x

-- DB 연결
CONN system/1234;

-- 회원정보 테이블 생성
CREATE TABLE member_tbl_02(
	custno NUMBER(6),			-- 회원번호
	custname VARCHAR2(20),		-- 이름
	phone VARCHAR2(13),			-- 연락처
	address VARCHAR2(4),		-- 통신사
	joindate DATE,				-- 등록일
	grade CHAR(1),				-- 등급
	city CHAR(2),				-- 거주기
	PRIMARY KEY(custno)			-- 기본키
	-- primary key 제약 조건을 설정하면,
	-- 해당 필드는 NOT NULL과 UNIQUE 제약 조건의 특징을 모두 가진다.
	-- 따라서 이 제약 조건이 설정된 필드는 NULL 값을 가질 수 없으며,
	-- 중복된 값을 가질 수 없다.
	-- 이러한 PRIMARY KEY 제약 조건을 기본키라고 한다.
);

-- 테이블 확인
desc member_tbl_02;

-- 회원정보 테이블에 대한 시퀀스 추가
CREATE SEQUENCE member_seq
START WITH 100001
INCREMENT BY 1
MINVALUE 100001
NOCACHE;

-- 회원 정보 추가(6개)
INSERT INTO member_tbl_02 VALUES(member_seq.nextval, '김행복', '010-1111-2222', 'SK', '20151202', 'A', '01');
INSERT INTO member_tbl_02 VALUES(member_seq.nextval, '이축복', '010-1111-3333', 'SK', '20151206', 'B', '01');
INSERT INTO member_tbl_02 VALUES(member_seq.nextval, '장믿음', '010-1111-4444', 'LG', '20151001', 'B', '30');
INSERT INTO member_tbl_02 VALUES(member_seq.nextval, '최사랑', '010-1111-5555', 'KT', '20151113', 'A', '30');
INSERT INTO member_tbl_02 VALUES(member_seq.nextval, '진평화', '010-1111-6666', 'LG', '20151225', 'B', '60');
INSERT INTO member_tbl_02 VALUES(member_seq.nextval, '차공단', '010-1111-7777', 'LG', '20151211', 'C', '60');
SELECT * FROM member_tbl_02;

-- 회원매출정보 명세서 테이블 생성
CREATE TABLE money_tbl_02(
	custno NUMBER(6),			-- 고객rl변호
	saleno NUMBER(8),			-- 판매번호
	pcost NUMBER(8),			-- 단가
	amount NUMBER(4),			-- 수량
	price NUMBER(8),			-- 가격
	pcode VARCHAR2(4),			-- 상품코드
	sdate DATE,					-- 판매일자
	PRIMARY KEY(custno, saleno)-- 기본키
);

-- 매출 정보 추가(10개)
INSERT INTO money_tbl_02 VALUES(100001, 20160001, 500, 5, 2500, 'A001', '20160101');
INSERT INTO money_tbl_02 VALUES(100001, 20160002, 1000, 4, 4000, 'A002', '20160101');
INSERT INTO money_tbl_02 VALUES(100001, 20160003, 500, 3, 1500, 'A008', '20160101');
INSERT INTO money_tbl_02 VALUES(100002, 20160004, 2000, 1, 2000, 'A004', '20160102');
INSERT INTO money_tbl_02 VALUES(100002, 20160005, 500, 1, 500, 'A001', '20160103');
INSERT INTO money_tbl_02 VALUES(100003, 20160006, 1500, 2, 3000, 'A003', '20160103');
INSERT INTO money_tbl_02 VALUES(100004, 20160007, 500, 2, 1000, 'A001', '20160104');
INSERT INTO money_tbl_02 VALUES(100004, 20160008, 300, 1, 300, 'A005', '20160104');
INSERT INTO money_tbl_02 VALUES(100004, 20160009, 600, 1, 600, 'A006', '20160104');
INSERT INTO money_tbl_02 VALUES(100004, 20160010, 3000, 1, 3000, 'A007', '20160106');
SELECT * FROM money_tbl_02;



















