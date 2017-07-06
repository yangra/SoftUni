#1
create database the_nerd_herd;
use the_nerd_herd;

create table credentials (
id int primary key,
email varchar(30) not null,
password varchar(20) not null
);

create table locations (
id int primary key,
latitude float not null,
longitude float not null
);

create table users(
id int primary key,
nickname varchar(25),
gender char(1),
age int,
location_id int not null,
credential_id int unique not null,
constraint fk_users_locations foreign key (location_id) references locations(id),
constraint fk_users_credentials foreign key (credential_id) references credentials(id)
);

create table chats (
id int primary key,
title varchar(32) not null,
start_date date not null,
is_active bit(1)
);

create table messages(
id int primary key,
content varchar(200) not null,
sent_on date not null,
chat_id int not null,
user_id int not null,
constraint fk_messages_chats foreign key (chat_id) references chats(id),
constraint fk_messages_users foreign key (user_id) references users(id)
);

create table users_chats(
user_id int,
chat_id int,
constraint pk_users_chats primary key (user_id, chat_id),
constraint fk_users_chats_chats foreign key (chat_id) references chats(id),
constraint fk_users_chats_users foreign key (user_id) references users(id)
);

#4
delete l.* 
from locations as l left join users as u 
on u.location_id = l.id 
where u.id is null;

#5
select u.nickname, u.gender, u.age 
from users as u 
where u.age between 22 and 37;

#6
select m.content, m.sent_on 
from messages as m 
where m.sent_on > '2014-05-12' and locate('just', m.content) != 0
order by m.id desc;

#7
select c.title, c.is_active
from chats as c
where c.is_active = 0 and char_length(c.title)<5 or substring(c.title,3,2) = 'tl'
order by c.title desc;

#8
select c.id, c.title, m.id from chats as c 
		join messages as m on m.chat_id = c.id
where m.sent_on < '2012-03-26' and substring(c.title, -1) = 'x'
order by c.id, m.id;

#9
select c.id, count(m.id) as 'total_messages' from messages as m 
								left join chats as c on m.chat_id = c.id
								where m.id < 90
group by c.id
order by total_messages desc, c.id
limit 5;

#10
select u.nickname, c.email, c.password from users as u 
							join credentials as c on c.id = u.credential_id
							where c.email like '%co.uk'
order by c.email;

#11
select u.id, u.nickname, u.age from users as u where u.location_id is null;

#12???????
select m.id, m.chat_id, m.user_id from messages as m
where m.user_id in (select u.id from users as u left join users_chats as uc on u.id = uc.chat_id where uc.chat_id is null )
and m.chat_id = 17
order by m.id desc;

#13???
select u.nickname, c.title, l.latitude, l.longitude from users as u 
							join locations as l on l.id = u.location_id 
							join users_chats as uc on u.id = uc.user_id
							join chats as c on c.id = uc.chat_id
where l.latitude between 41.14 and 44.13 and l.longitude between 22.21 and 28.36
order by c.title;

#14
select c.title, if(count(m.id) > 0, m.content, null) as 'content' from chats as c
			join messages as m on c.id = m.chat_id
where m.chat_id = (select c.id from chats as c 
order by c.start_date desc
limit 1)
order by m.sent_on
limit 1;

#15
delimiter $$
create function udf_get_radians(degree float)
returns float
begin
declare radian float;
set radian = (degree*pi())/180;
return radian;
end $$

#16
delimiter $$
create procedure udp_change_password(email_ver varchar(30), new_password varchar(20))
begin
start transaction;
update credentials
set password = new_password
where email = email_ver;
if ((select count(c.email) from credentials as c where c.email = email_ver)<>1) then
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The email doesn\'t exist';
	rollback;
else 
	commit;
end if;
end $$

#17
delimiter $$
create procedure udp_send_message(uid int, cid int, mess_content varchar(200))
begin
start transaction;
insert into messages(id, content, sent_on, user_id, chat_id)
values ((select m.id from messages as m order by m.id desc limit 1)+1,
mess_content, '2017-06-20', uid, cid);
if ((select count(uc.user_id) from users_chats as uc where uc.chat_id = cid and uc.user_id = uid )<>1) then
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'There is no chat with that user!';
	ROLLBACK;
else 
	COMMIT;
end if;
end $$

#18

