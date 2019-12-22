insert into KINTAI_USER(id, name) values(10001, 'taro');
insert into KINTAI_USER(id, name) values(10002, '次郎');

insert into KINTAI_TIME(CATEGORY, IN_TIME, OUT_TIME, USER_ID) values ('出退勤', now(), null, 10001);
insert into KINTAI_TIME(CATEGORY, IN_TIME, OUT_TIME, USER_ID) values ('出退勤', now(), now(), 10002);
insert into KINTAI_TIME(CATEGORY, IN_TIME, OUT_TIME, USER_ID) values ('起床睡眠', now(), null, 10001);
