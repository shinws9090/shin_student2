-- 학생관리2
DROP SCHEMA IF EXISTS `student2`;

-- 학생관리2
CREATE SCHEMA `student2`;

-- 학생정보
CREATE TABLE `student2`.`students` (
	`stdno`   INT         NOT NULL COMMENT '학생번호', -- 학생번호
	`name`    VARCHAR(20) NOT NULL COMMENT '이름', -- 이름
	`dirth`   DATE        NOT NULL COMMENT '생년월일', -- 생년월일
	`social`  INT         NOT NULL COMMENT '주민번호 뒷자리', -- 주민번호 뒷자리
	`dayTime` INT         NULL     COMMENT '주야', -- 주야
	`dept`    INT         NULL     COMMENT '학과', -- 학과
	`grade`   INT         NULL     COMMENT '학년', -- 학년
	`atd`     CHAR(10)    NULL     COMMENT '학적', -- 학적
	`milt`    CHAR(10)    NULL     COMMENT '병역', -- 병역
	`pic`     CHAR(50)    NULL     COMMENT '증명사진' -- 증명사진
)
COMMENT '학생정보';

-- 학생정보
ALTER TABLE `student2`.`students`
	ADD CONSTRAINT `PK_students` -- 학생정보 기본키
		PRIMARY KEY (
			`stdno` -- 학생번호
		);

-- 학생성적
CREATE TABLE `student2`.`scores` (
	`stdno`     INT NOT NULL COMMENT '학생번호', -- 학생번호
	`subjectno` INT NOT NULL COMMENT '과목코드', -- 과목코드
	`score`     INT NULL     COMMENT '점수' -- 점수
)
COMMENT '학생성적';

-- 학생성적
ALTER TABLE `student2`.`scores`
	ADD CONSTRAINT `PK_scores` -- 학생성적 기본키
		PRIMARY KEY (
			`stdno`,     -- 학생번호
			`subjectno`  -- 과목코드
		);

-- 병역
CREATE TABLE `student2`.`militarys` (
	`miltno`   CHAR(10) NOT NULL COMMENT '병역코드', -- 병역코드
	`miltname` CHAR(10) NOT NULL COMMENT '병역구분' -- 병역구분
)
COMMENT '병역';

-- 병역
ALTER TABLE `student2`.`militarys`
	ADD CONSTRAINT `PK_militarys` -- 병역 기본키
		PRIMARY KEY (
			`miltno` -- 병역코드
		);

-- 학적
CREATE TABLE `student2`.`attendings` (
	`atdno`   CHAR(10) NOT NULL COMMENT '학적코드', -- 학적코드
	`atdname` CHAR(10) NOT NULL COMMENT '학적구분' -- 학적구분
)
COMMENT '학적';

-- 학적
ALTER TABLE `student2`.`attendings`
	ADD CONSTRAINT `PK_attendings` -- 학적 기본키
		PRIMARY KEY (
			`atdno` -- 학적코드
		);

-- 주야구분
CREATE TABLE `student2`.`days` (
	`dayTimeno`   INT      NOT NULL COMMENT '주야코드', -- 주야코드
	`dayTimename` CHAR(10) NOT NULL COMMENT '주야구분' -- 주야구분
)
COMMENT '주야구분';

-- 주야구분
ALTER TABLE `student2`.`days`
	ADD CONSTRAINT `PK_days` -- 주야구분 기본키
		PRIMARY KEY (
			`dayTimeno` -- 주야코드
		);

-- 학과
CREATE TABLE `student2`.`department` (
	`deptno`   INT         NOT NULL COMMENT '학과코드', -- 학과코드
	`deptname` VARCHAR(20) NOT NULL COMMENT '학과구분' -- 학과구분
)
COMMENT '학과';

-- 학과
ALTER TABLE `student2`.`department`
	ADD CONSTRAINT `PK_department` -- 학과 기본키
		PRIMARY KEY (
			`deptno` -- 학과코드
		);

-- 성적등급
CREATE TABLE `student2`.`ranking` (
	`rank`    CHAR(5) NOT NULL COMMENT '평어', -- 평어
	`ranksco` DOUBLE  NULL     COMMENT '평점', -- 평점
	`lowsco`  INT     NULL     COMMENT '최소실점수', -- 최소실점수
	`hisco`   INT     NULL     COMMENT '최대실점수' -- 최대실점수
)
COMMENT '성적등급';

-- 성적등급
ALTER TABLE `student2`.`ranking`
	ADD CONSTRAINT `PK_ranking` -- 성적등급 기본키
		PRIMARY KEY (
			`rank` -- 평어
		);

-- 과목
CREATE TABLE `student2`.`subjects` (
	`subjectno`   INT         NOT NULL COMMENT '과목코드', -- 과목코드
	`subjectname` VARCHAR(10) NULL     COMMENT '과목구분' -- 과목구분
)
COMMENT '과목';

-- 과목
ALTER TABLE `student2`.`subjects`
	ADD CONSTRAINT `PK_subjects` -- 과목 기본키
		PRIMARY KEY (
			`subjectno` -- 과목코드
		);

-- 학생정보
ALTER TABLE `student2`.`students`
	ADD CONSTRAINT `FK_attendings_TO_students` -- 학적 -> 학생정보
		FOREIGN KEY (
			`atd` -- 학적
		)
		REFERENCES `student2`.`attendings` ( -- 학적
			`atdno` -- 학적코드
		);

-- 학생정보
ALTER TABLE `student2`.`students`
	ADD CONSTRAINT `FK_militarys_TO_students` -- 병역 -> 학생정보
		FOREIGN KEY (
			`milt` -- 병역
		)
		REFERENCES `student2`.`militarys` ( -- 병역
			`miltno` -- 병역코드
		);

-- 학생정보
ALTER TABLE `student2`.`students`
	ADD CONSTRAINT `FK_department_TO_students` -- 학과 -> 학생정보
		FOREIGN KEY (
			`dept` -- 학과
		)
		REFERENCES `student2`.`department` ( -- 학과
			`deptno` -- 학과코드
		);

-- 학생정보
ALTER TABLE `student2`.`students`
	ADD CONSTRAINT `FK_days_TO_students` -- 주야구분 -> 학생정보
		FOREIGN KEY (
			`dayTime` -- 주야
		)
		REFERENCES `student2`.`days` ( -- 주야구분
			`dayTimeno` -- 주야코드
		);

-- 학생성적
ALTER TABLE `student2`.`scores`
	ADD CONSTRAINT `FK_students_TO_scores` -- 학생정보 -> 학생성적
		FOREIGN KEY (
			`stdno` -- 학생번호
		)
		REFERENCES `student2`.`students` ( -- 학생정보
			`stdno` -- 학생번호
		);

-- 학생성적
ALTER TABLE `student2`.`scores`
	ADD CONSTRAINT `FK_subjects_TO_scores` -- 과목 -> 학생성적
		FOREIGN KEY (
			`subjectno` -- 과목코드
		)
		REFERENCES `student2`.`subjects` ( -- 과목
			`subjectno` -- 과목코드
		);
	
grant all
	on student2.*
	to 'user_student2'@'localhost' identified by 'rootroot';