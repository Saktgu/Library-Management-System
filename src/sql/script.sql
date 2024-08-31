use user;
set sql_safe_updates=0;

desc booklog;
truncate booklog;
insert into booklog values('his0001','Ramayana','Valmigi','1950',3,3);
select * from booklog;

desc bookstatus;
truncate bookstatus;
update bookstatus set edate='01/12/2022' where uid='CL004';
update bookstatus set gs=0 where uid='CL002';
select * from bookstatus;

desc userlog;
truncate userlog;
update userlog set edate='18/10/2024' where snum=1;
select * from userlog;









