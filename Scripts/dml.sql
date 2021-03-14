select user(), database ();



insert into attendings values
	 ('h1a','재학')
	,('h1b','휴학')
	,('h1c','졸업')
	,('h1d','제적');


insert into militarys values
	 ('y2a','미필')
	,('y2b','군필')
	,('y2c','면제');

insert into days values
	 (1,'주간')
	,(2,'야간');

insert into department values
	 (1,'자동차공학')
	,(2,'컴퓨터정보')
	,(3,'산업설비');

insert into subjects values
	 (1,'1과목')
	,(2,'3과목')
	,(3,'3과목');

/*
insert into students values
	 (18020017,'박제선',980806,1000000)
	,(18010016,'한동성',980920,1000000)
	,(17010012,'박태준',971011,1000000)
	,(18020028,'정정일',981226,1000000)
	,(18020015,'정연희',981112,2000000)
	,(17030001,'유기수',978324,1000000)
	,(18010018,'임정만',970228,1000000)
	,(18010030,'박선호',940806,1000000)
	,(18020001,'임성준',980301,1000000)
	,(18020029,'이준민',980605,1000000)
	,(18010019,'이강길',981127,1000000)
	,(18020037,'하에준',951225,2000000)
	,(18020027,'박다영',981117,2000000)
	,(18020026,'여효주',881019,2000000)
	,(18020010,'전인우',980430,1000000);
	*/

insert into students values
 	 (18020017,'박제선',19980806,1000000,1,1,1,'h1a','y2a','')
	,(18010016,'한동성',19980920,1000000,1,2,1,'h1a','y2a','')
	,(17010012,'박태준',19971011,1000000,2,2,2,'h1b','y2a','')
	,(18020028,'정정일',19981226,1000000,1,1,1,'h1b','y2a','')
	,(18020015,'정연희',19981112,2000000,1,1,1,'h1a','y2a','')
	,(17030001,'유기수',19970324,1000000,2,3,2,'h1b','y2c','')
	,(18010018,'임정만',19970228,1000000,1,2,2,'h1a','y2a','')
	,(18010030,'박선호',19940806,1000000,2,2,1,'h1a','y2b','')
	,(18020001,'임성준',19980301,1000000,1,1,1,'h1a','y2a','')
	,(18020029,'이준민',19980605,1000000,1,1,1,'h1a','y2a','')
	,(18010019,'이강길',19981127,1000000,1,2,1,'h1b','y2a','')
	,(18020037,'하에준',19951225,2000000,2,1,1,'h1a','y2b','')
	,(18020027,'박다영',19981117,2000000,1,3,1,'h1a','y2a','')
	,(18020026,'여효주',19881019,2000000,1,2,1,'h1a','y2b','')
	,(18020010,'전인우',19980430,1000000,1,2,1,'h1a','y2a','');

insert into scores values
 	 (18020017,1,100)
	,(18010016,1,80)
	,(17010012,1,50)
	,(18020028,1,56)
	,(18020015,1,6)
	,(17030001,1,100)
	,(18010018,1,81)
	,(18010030,1,92)
	,(18020001,1,94)
	,(18020029,1,15)
	,(18010019,1,42)
	,(18020037,1,66)
	,(18020027,1,85)
	,(18020026,1,77)
	,(18020010,1,42)
	,(18020017,2,80)
	,(18010016,2,60)
	,(17010012,2,60)
	,(18020028,2,100)
	,(18020015,2,65)
	,(17030001,2,64)
	,(18010018,2,94)
	,(18010030,2,83)
	,(18020001,2,85)
	,(18020029,2,27)
	,(18010019,2,85)
	,(18020037,2,42)
	,(18020027,2,15)
	,(18020026,2,51)
	,(18020010,2,29)
	,(18020017,3,90)
	,(18010016,3,90)
	,(17010012,3,80)
	,(18020028,3,88)
	,(18020015,3,88)
	,(17030001,3,51)
	,(18010018,3,51)
	,(18010030,3,92)
	,(18020001,3,61)
	,(18020029,3,34)
	,(18010019,3,61)
	,(18020037,3,49)
	,(18020027,3,90)
	,(18020026,3,67)
	,(18020010,3,88);

insert into ranking values
	 ('A',4.5,91,100)
	,('B',3.5,81,90)
	,('C',2.5,71,80)
	,('D',1.5,61,70)
	,('F',0,0,60);


	 
select * from students s2 ;
select * from ranking;
select * from scores;

desc ranking ;
