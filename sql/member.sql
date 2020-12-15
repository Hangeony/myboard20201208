DROP TABLE member;
DROP TABLE article;
CREATE TABLE member(
memberid VARCHAR2(50) PRIMARY KEY,
name VARCHAR2(50) NOT NULL,
password VARCHAR2(10) NOT NULL,
regdate DATE NOT NULL
);

SELECT * FROM member;
SELECT * FROM article;
SELECT * FROM article_content;
SELECT * FROM reply;
SELECT replyid, memberid, article_no, body, regdate FROM reply
WHERE article_no=103 ORDER BY replyid DESC;
DELETE FROM member
WHERE memberid = '123';

CREATE TABLE article (
    article_no NUMBER GENERATED AS IDENTITY,
    writer_id VARCHAR2(50) NOT NULL,
    writer_name VARCHAR2(50) NOT NULL,
    title VARCHAR2(255) NOT NULL,
    regdate DATE NOT NULL,
    moddate DATE NOT NULL,
    read_cnt NUMBER,
    PRIMARY KEY (article_no)
);
CREATE TABLE article_content(
article_no NUMBER PRIMARY KEY,
content VARCHAR2(4000)
);
SELECT COUNT(*) FROM article;
SELECT *FROM desc article;
DESC article;

DELETE FROM article WHERE article_no = 24;
DELETE FROM article_content WHERE article_no = 24;
commit;

--댓글
CREATE TABLE reply (
    replyid NUMBER GENERATED AS IDENTITY,
    memberid VARCHAR2(50) NOT NULL,
    article_no NUMBER NOT NULL,
    body VARCHAR2(1000) NOT NULL,
    regdate DATE NOT NULL,
    PRIMARY KEY (replyid)
);

INSERT INTO reply (memberid, article_no, body, regdate)
VALUES (' ', 0, ' ', SYSDATE);
