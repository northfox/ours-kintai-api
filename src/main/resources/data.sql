insert into KINTAI_USER(id, name) values(10001, 'taro')
on duplicate key update id = values(id);
insert into KINTAI_USER(id, name) values(10002, '次郎')
on duplicate key update id = values(id);

insert into KINTAI_TIME(id, CATEGORY, IN_TIME, OUT_TIME, USER_ID) values (10001, '出退勤', now(), null, 10001)
on duplicate key update id = values(id);
insert into KINTAI_TIME(id, CATEGORY, IN_TIME, OUT_TIME, USER_ID) values (10002, '出退勤', now(), now(), 10002)
on duplicate key update id = values(id);
insert into KINTAI_TIME(id, CATEGORY, IN_TIME, OUT_TIME, USER_ID) values (10003, '起床睡眠', now(), null, 10001)
on duplicate key update id = values(id);
