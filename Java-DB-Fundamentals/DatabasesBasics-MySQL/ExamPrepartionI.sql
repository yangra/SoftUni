#1
create database AMS;
use AMS;

create table tickets (
	ticket_id INT(11) primary key,
	price decimal(8,2) not null,
	class enum('First', 'Second', 'Third'),
	seat varchar(5) not null,
	customer_id int(11),
	flight_id int(11)
	);
	
create table flights(
	flight_id int(11) primary key,
	departure_time datetime not null,
	arrival_time datetime not null,
	status enum('Departing', 'Delayed', 'Arrived', 'Cancelled'),
	origin_airport_id int(11),
	destination_airport_id int(11),
	airline_id int(11)
	);
	
create table airlines(
	airline_id int(11) primary key,
	airline_name varchar(30) not null,
	nationality varchar(30) not null,
	rating int(11) default 0
);

create table airports(
	airport_id int(11) primary key,
	airport_name varchar(50) not null,
	town_id int(11) unique
);

create table towns(
	town_id int(11) primary key,
	town_name varchar(30) not null
);

create table customers(
	customer_id int(11) primary key,
	first_name varchar(20) not null,
	last_name varchar(20) not null,
	date_of_birth date not null,
	gender enum('M', 'F'),
	home_town_id int(11) unique
);

alter table tickets add constraint fk_tickets_customers foreign key (customer_id)
references customers(customer_id);
alter table tickets add constraint fk_tickets_flights foreign key (flight_id)
references flights(flight_id);
alter table flights add constraint fk_flights_airports_origin foreign key (origin_airport_id)
references airports(airport_id);
alter table flights add constraint fk_flights_airports_destination foreign key (destination_airport_id)
references airports(airport_id);
alter table flights add constraint fk_flights_airlines foreign key (airline_id)
references airlines(airline_id);
alter table airports add constraint fk_airports_towns foreign key (town_id)
references towns(town_id);
alter table customers add constraint fk_customers_towns foreign key (home_town_id)
references towns(town_id);


#2
insert into flights(flight_id, departure_time, arrival_time, status, origin_airport_id, destination_airport_id, airline_id)
values (1, '2016-10-13 06:00:00', '2016-10-13 10:00:00', 'Delayed', 1, 4, 1),
(2, '2016-10-12 12:00:00', '2016-10-12 12:01:00', 'Departing', 1, 3, 2),
(3, '2016-10-14 15:00:00', '2016-10-20 04:00:00', 'Delayed', 4, 2, 4),
(4, '2016-10-12 13:24:00', '2016-10-12 16:31:00', 'Departing', 3, 1, 3),
(5, '2016-10-12 08:11:00', '2016-10-12 23:22:00', 'Departing', 4, 1, 1),
(6, '1995-06-21 12:30:00', '1995-06-22 20:30:00', 'Arrived', 2, 3, 5),
(7, '2016-10-12 23:34:00', '2016-10-13 03:00:00', 'Departing', 2, 4, 2),
(8, '2016-11-11 13:00:00', '2016-11-12 22:00:00', 'Delayed', 4, 3, 1),
(9, '2015-10-01 12:00:00', '2015-12-01 01:00:00', 'Arrived', 1, 2, 1),
(10, '2016-10-12 19:30:00', '2016-10-13 12:30:00', 'Departing', 2, 1, 7);

insert into tickets(ticket_id, price, class, seat, customer_id, flight_id)
values (1, 3000.00, 'First', '233-A', 3, 8),
(2, 1799.90, 'Second', '123-D', 1, 1),
(3, 1200.50, 'Second', '12-Z', 2, 5),
(4, 410.68, 'Third', '45-Q', 2, 8),
(5, 560.00, 'Third', '201-R', 4, 6),
(6, 2100.00, 'Second', '13-T', 1, 9),
(7, 5500.00, 'First', '98-O', 2, 7);

#3
UPDATE flights
SET airline_id = 1
WHERE status = 'Arrived';

#4
update tickets
set price = price*1.5
where flight_id in
(select f.flight_id from flights as f
join airlines as a on a.airline_id = f.airline_id
where a.rating in (select max(a.rating) from airlines as a));

#5
create table customer_reviews (
	review_id int(11) primary key,
	review_content varchar(255) not null,
	review_grade int(2),
	airline_id int(11),
	customer_id int(11),
	constraint fk_customer_reviews_airlines foreign key (airline_id)
	references airlines(airline_id),
	constraint fk_customer_reviews_customers foreign key (customer_id)
	references customers(customer_id)
);

create table customer_bank_accounts(
	account_id int(11) primary key,
	account_number varchar(10) unique not null,
	balance decimal(10,2) not null,
	customer_id int(11),
	constraint fk_customer_bank_accounts_customers foreign key (customer_id)
	references customers(customer_id)
);

#6
insert into customer_reviews(review_id, review_content, review_grade, airline_id, customer_id)
values (1, 'Me is very happy. Me likey this airline. Me good.', 10, 1, 1),
(2, 'Ja, Ja, Ja... Ja, Gut, Gut, Ja Gut! Sehr Gut!', 10, 1, 4),
(3, 'Meh...', 5, 4, 3),
(4, 'Well Ive seen better, but Ive certainly seen a lot worse...', 7, 3, 5);

insert into customer_bank_accounts(account_id, account_number, balance, customer_id)
values (1, '123456790', 2569.23, 1),
(2, '18ABC23672', 14004568.23, 2),
(3, 'F0RG0100N3', 19345.20, 5);

#7
select t.ticket_id, t.price, t.class, t.seat from tickets as t
order by t.ticket_id;

#8
select 	c.customer_id, 
			concat(c.first_name,' ', c.last_name) as 'full_name',
			c.gender from customers as c
order by full_name, c.customer_id;

#9
select f.flight_id, f.departure_time, f.arrival_time from flights as f
where f.`status` = 'Delayed'
order by f.flight_id;

#10
select a.airline_id, a.airline_name, a.nationality, a.rating from airlines as a
where a.airline_id in(select a.airline_id from airlines as a
														join flights as f on a.airline_id = f.airline_id)
order by a.rating desc, a.airline_id
limit 5;

#11
select 	t.ticket_id, 
			a.airport_name as 'destination', 
			concat(c.first_name,' ', c.last_name) as 'customer_name'  from tickets as t
				join flights as f on f.flight_id = t.flight_id
				join airports as a on f.destination_airport_id = a.airport_id
				join customers as c on c.customer_id = t.customer_id
where t.class = 'First' and t.price < 5000
order by t.ticket_id;

#12
select c.customer_id,
concat(c.first_name, ' ', c.last_name),
t.town_name
 from  customers as c 
		join towns as t on t.town_id = c.home_town_id
		where c.customer_id in (select c.customer_id from customers as c
										join tickets as ti on ti.customer_id = c.customer_id
										join flights as f on f.flight_id = ti.flight_id
										join airports as a on a.airport_id = f.origin_airport_id
										where a.town_id = c.home_town_id and f.`status` = 'Departing')				
order by c.customer_id;

#13!!!!!!!!!!
select c.customer_id, 
			concat(c.first_name,' ', c.last_name) as 'full_name',
			 datediff((current_date - Interval 1 YEAR),c.date_of_birth)/365.25 as 'age' 
			 from customers as c
			 where c.customer_id in(select c.customer_id from customers as c
												join  tickets as t	on t.customer_id = c.customer_id
					 							join flights as f on f.flight_id = t.flight_id
												where f.`status` = 'Departing')
			order by age, c.customer_id;

#14
select
c.customer_id,
concat(c.first_name, ' ', c.last_name) as 'full_name',
t.price as 'ticket_price',
a.airport_name as 'destination' from customers as c
				join tickets as t on t.customer_id = c.customer_id
				join flights as f on t.flight_id = f.flight_id
				join airports as a on a.airport_id = f.destination_airport_id
	where f.`status` = 'Delayed'
	order by ticket_price desc, c.customer_id
	limit 3;

#15
select * from(select
					f.flight_id,
					f.departure_time,
					f.arrival_time,
					orig.airport_name as 'origin',
					des.airport_name as 'destionation' from flights as f
							join airports as orig on orig.airport_id = f.origin_airport_id
							join airports as des on des.airport_id = f.destination_airport_id
					where f.`status` = 'Departing'
					order by f.departure_time desc
					limit 5) as d
order by departure_time, flight_id;

#16 ?????
select
c.customer_id,
concat(c.first_name, ' ', c.last_name) as 'full_name',
round(datediff((now() - Interval 1 YEAR),c.date_of_birth)/365.25,0) as 'age' from customers as c 
				join tickets as t on t.customer_id = c.customer_id
where t.flight_id in (select f.flight_id from flights as f
								where f.`status` = 'Arrived')
and round(datediff((now() - Interval 1 YEAR),c.date_of_birth)/365.25,0) < 21
order by age desc, c.customer_id;


#17
select a.airport_id, a.airport_name, count(t.ticket_id) as 'passengers' from airports as a
join flights as f on f.origin_airport_id = a.airport_id and f.`status` = 'Departing'
join tickets as t on t.flight_id = f.flight_id
group by a.airport_id, a.airport_name
order by a.airport_id;	

#18
delimiter $$
create procedure usp_submit_review(customerid int, reviewcontent varchar(255), reviewgrade int(2), airlinename varchar(30))
begin
declare airlineid int;
set airlineid := (select a.airline_id from airlines as a where a.airline_name = airlinename);
start transaction;
if airlinename not in (select a.airline_name from airlines as a) then
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid account';
rollback;
else 
insert into customer_reviews(customer_id, review_content, review_grade, airline_id)
values (customerid, reviewcontent, reviewgrade, airlineid);
commit;
end if;
end $$

#19!!!!!!!!!
delimiter $$
create procedure usp_purchase_ticket(cust_id int, fl_id int, tick_price decimal(8,2), cl enum('First', 'Second', 'Third'), st varchar(5))
begin
start transaction;
if (select cba.balance 
		from customer_bank_accounts as cba 
		where cba.customer_id = cust_id) < tick_price then
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid account';
rollback;
else
update customer_bank_account
set balance = balance - tick_price
where customer_id = cust_id;
insert into tickets(ticket_id, customer_id, flight_id, price, class, seat)
values(8,cust_id, fl_id, tick_price, cl, st);
commit;
end if;
end $$

#20
create table arrived_flights(
flight_id int primary key,
arrival_time datetime not null,
origin varchar(50) not null,
destination varchar(50) not null,
passengers int not null
);

delimiter $$
create trigger tr_arrived_flights
before update
on flights
for each row
begin
if new.`status` = 'Arrived' then
insert into arrived_flights (flight_id, arrival_time, origin, destination, passengers)
values (new.flight_id,now(), 
(select a.airport_name from flights as f1 join airports as a on a.airport_id = f1.origin_airport_id where f1.flight_id = new.flight_id),
(select a.airport_name from flights as f2 join airports as a on a.airport_id = f2.destination_airport_id where f2.flight_id = new.flight_id),
(select count(t.ticket_id) from flights as f3 join tickets as t on f3.flight_id = t.flight_id where f3.flight_id = new.flight_id));
end if;
end $$

update flights
set status = 'Arrived'
where flight_id = 9;