--AuthTest > script.sql

DROP TABLE tblUser;

CREATE TABLE tblUser (
	id varchar2(30) PRIMARY KEY,	--아이디(PK)
	pw varchar2(30) NOT NULL,		--암호
	name varchar2(30) NOT NULL,	--이름
	grade number(1) NOT NULL 		--등급, 일반(1), 관리자(2)
);

INSERT INTO tblUser VALUES ('hong', '1111', '홍길동', 1);
INSERT INTO tblUser VALUES ('dog', '1111', '강아지', 1);
INSERT INTO tblUser VALUES ('cat', '1111', '고양이', 2);

SELECT * FROM tblUser;

COMMIT;