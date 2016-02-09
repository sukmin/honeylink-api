CREATE TABLE link (

	seq BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	link_url VARCHAR(1000) NOT NULL,
	link_title VARCHAR(200),
	link_thum_url VARCHAR(1000),
	read_count INT DEFAULT 0,
	reg_ymdt DATETIME,
	del_yn ENUM('y','n') NOT NULL DEFAULT 'n',
	reg_member_seq BIGINT

);

INSERT INTO link (link_url,link_title,link_thum_url,reg_ymdt)
VALUES("http://pgr21.com","Pgr21.com","http://pgr21.com/img/logo.png",NOW());
INSERT INTO link (link_url,link_title,link_thum_url,reg_ymdt)
VALUES("http://www.naver.com","네이버 메인","http://static.naver.net/www/mobile/edit/2015/0429/mobile_20514817711.png",NOW());

CREATE TABLE notice (
	
	seq BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	notice_type VARCHAR(10) NOT NULL,
	notice_content VARCHAR(1000) NOT NULL,
	notice_url VARCHAR(1000),
	last_version_name VARCHAR(100)

);

INSERT INTO notice (notice_type,notice_content,last_version_name)
VALUES ("force","테스트공지입니다.","1.0");


