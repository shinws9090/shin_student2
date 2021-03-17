



create view studentAll
as
select s.stdno, s.name, s.dirth, s.social, dayTimeno, dayTimename, deptno, deptname, grade, atdno, atdname, miltno, miltname,pic, 
	max(if(s2.subjectno=1,score,null))'score1',
	max(if(s2.subjectno=1,s2.subjectno,null))'subjno1',
	max(if(j.subjectno=1,subjectname,null))'subfname1',
	max(if(s2.subjectno=2,score,null))'score2',
	max(if(s2.subjectno=2,s2.subjectno,null))'subjno2',
	max(if(j.subjectno=2,subjectname,null))'subfname2',
	max(if(s2.subjectno=3,score,null))'score3',
	max(if(s2.subjectno=3,s2.subjectno,null))'subjno3',
	max(if(j.subjectno=3,subjectname,null))'subfname3',
	sum(score)'total',round(avg(score),1)'avg'
	from students s
	join days d on s.dayTime =d.dayTimeno 
	join department d2 on s.dept = d2.deptno 
	join attendings a on s.atd = a.atdno 
	join militarys m on s.milt =m.miltno 
	join scores s2 on s.stdno =s2.stdno 
	join subjects j on s2.subjectno = j.subjectno 
	group by s.stdno;


select stdno ,
	max(if(s2.subjectno=1,score,null)),
	max(if(s2.subjectno=1,s2.subjectno,null)),
	max(if(j.subjectno=1,subjectname,null)),
	max(if(s2.subjectno=2,score,null)),
	max(if(s2.subjectno=2,s2.subjectno,null)),
	max(if(j.subjectno=2,subjectname,null)),
	max(if(s2.subjectno=3,score,null)),
	max(if(s2.subjectno=3,s2.subjectno,null)),
	max(if(j.subjectno=3,subjectname ,null))
	from scores s2 join subjects j on s2.subjectno = j.subjectno 
	group by stdno;

drop view studentAll;
drop view studentAllRank;
select * from subjects s2 ;
select * from studentAll;

-- 뷰
create view studentallRank
as
select s.*,rank,ranksco
from studentall s ,ranking r 
where s.avg between r.lowsco and r.hisco ;

-- 학생클래스만
select stdno, name, dirth, social, dayTimeno, dayTimename, 
	   deptno, deptname, grade, atdno, atdname, miltno, miltname
	from studentall
	where stdno = 17010012;

-- 랭킹까지 가지고 올것
select stdno, name, dirth, social, dayTimeno, dayTimename,
		deptno, deptname, grade, atdno, atdname, miltno, miltname, pic,
		score1, subjno1, subfname1, score2, subjno2, subfname2, score3, subjno3, subfname3,
		total, avg, `rank`, ranksco
	from studentallRank;
	where name = ;

select user();


delete from students where stdno = 123123;

select stdno, name, dirth, social, dayTimeno, dayTimename,
		deptno, deptname, grade, atdno, atdname, miltno, miltname,
		score1, subjno1, subfname1, score2, subjno2, subfname2, score3, subjno3, subfname3,
		total, avg, rank, ranksco
	from studentallRank 
where rank = 'B';

select * from students;
select * from scores;
-- stdno, name, dirth, social, dayTime, dept, grade, atd, milt
insert into students values (?,?,?,?,?,?,?,?,?);
insert into scores values(?,0);


-- 수정
update students 
	set name = ?, dirth = ?, social = ?, dayTime = ?, dept = ?, grade = ?, atd = ?, milt = ?
	where stdno = ?;

select * from scores s ;

update scores
	set score = 10
	where subjectno = 1 and stdno = 656756;

select  curdate();



-- 로그인 작업

select ID , pass , email 
from manageruser 
where id = 'shinws9090' and pass = password('1234');

select * from manageruser m ;

insert into manageruser 
values ('shinws9090',password('1234'),'shinws9090@naver.com');

delete from manageruser 
where id = 'shinws9090' and pass = password('1234');

select ID 
from manageruser 
where id = 'shinws9090' and pass = password('1234');




	