#1
delimiter $$
create procedure usp_get_employees_salary_above_35000()
begin
	select e.first_name, e.last_name from employees as e
	where e.salary > 35000
	order by e.first_name, e.last_name;
end $$


#2
delimiter $$
create procedure usp_get_employees_salary_above(number decimal(19,4))
begin
	select e.first_name, e.last_name from employees as e
	where e.salary >= number
	order by e.first_name, e.last_name;
end $$


#3
delimiter $$
create procedure usp_get_towns_starting_with(begins_with varchar(12))
begin
	select t.name from towns as t
	where strcmp(lower(substring(t.name,1,char_length(begins_with))), lower(begins_with))=0
	order by t.name;
end $$

#4
delimiter $$
create procedure usp_get_employees_from_town(town varchar(30))
begin
	select e.first_name, e.last_name from employees as e
	JOIN addresses as a
	ON a.address_id = e.address_id
	JOIN towns as t
	ON t.town_id = a.town_id
	where strcmp(lower(t.name),lower(town)) = 0
	order by e.first_name, e.last_name;
end $$

#5
delimiter $$
create function ufn_get_salary_level(salary decimal(19,4))
returns varchar(10)
begin
declare salary_level varchar(10);
	if (salary < 30000) then set salary_level := 'Low';
	elseif (salary <= 50000) then set salary_level := 'Average';
	else set salary_level := 'High';
	end if;
return salary_level;
end $$


#6
delimiter $$
create function ufn_get_salary_level(salary decimal(19,4))
returns varchar(10)
begin
declare salary_level varchar(10);
	if (salary < 30000) then set salary_level := 'Low';
	elseif (salary <= 50000) then set salary_level := 'Average';
	else set salary_level := 'High';
	end if;
return salary_level;
end $$


delimiter $$
create procedure usp_get_employees_by_salary_level (level_of_salary varchar(10))
begin
	select e.first_name, e.last_name from employees as e
	where strcmp(ufn_get_salary_level(e.salary),level_of_salary) = 0
	order by e.first_name desc, e.last_name desc;
end $$

#7
delimiter $$
create function ufn_is_word_comprised(set_of_chars varchar(30), word varchar(200))
returns bool
begin
	declare len_word int default char_length(word);
	declare idx int default 1;
	while(idx <= len_word)
	do
		if(locate(substring(word, idx,1), set_of_chars)) < 1
		then
		return false;
		end if;
		set idx = idx +1;
	end while;
	return true;
end $$

#8
alter table employees drop foreign key fk_employees_employees;
alter table employees drop foreign key fk_employees_departments;
alter table employees drop foreign key fk_employees_addresses;
alter table employees_projects drop foreign key fk_employees_projects_employees;
alter table departments drop foreign key fk_departments_employees;
alter table employees_projects 
add constraint fk_employees_projects_employees foreign key (employee_id)
references employees(employee_id) on delete cascade;
alter table employees 
add constraint fk_employees_addresses foreign key (address_id)
references addresses(address_id) on delete cascade;
update employees
set manager_id = 2 
where manager_id in (select m_id from(select e.manager_id as m_id from departments as d join employees as e on d.department_id = e.department_id
							where d.name in ('Production', 'Production Control')) as managers_departments); 
delete from employees
where department_id in (select d.department_id from departments as d 
									where d.name in ('Production', 'Production Control'));
delete from departments where name in ('Production', 'Production Control');
alter table employees 
add constraint fk_employees_employees foreign key (manager_id)
references employees(employee_id);
alter table employees 
add constraint fk_employees_departments foreign key (department_id)
references departments(department_id);
alter table departments 
add constraint fk_departments_employees foreign key (manager_id)
references employees(employee_id);

#9
delimiter $$
create procedure usp_get_holders_full_name()
begin
	select concat(ah.first_name, ' ', ah.last_name) as full_name from account_holders as ah
	order by full_name;
end $$

#10
delimiter $$
create procedure usp_get_holders_with_balance_higher_than(number decimal(19,4))
begin
	select ah.first_name, ah.last_name from account_holders as ah
	join(	select a.account_holder_id, sum(a.balance) as balance from accounts as a
			group by a.account_holder_id) as balances
	on balances.account_holder_id = ah.id
	where balances.balance > number
	order by ah.first_name, ah.last_name;
end$$

#11
delimiter $$
create function 
ufn_calculate_future_value(ini_sum decimal(19,4), 
yearly_interest_rate decimal(19,4),
number_of_years int)
returns decimal(19,2)
begin
declare result decimal(19,4);
set result := ini_sum *(pow((yearly_interest_rate +1), number_of_years));
return result;
end $$

#12
delimiter $$
create function 
ufn_calculate_future_value(ini_sum decimal(19,4), 
yearly_interest_rate decimal(19,4),
number_of_years int)
returns decimal(19,4)
begin
declare result decimal(19,4);
set result := ini_sum *(pow((yearly_interest_rate +1), number_of_years));
return result;
end $$

delimiter $$
create procedure usp_calculate_future_value_for_account(account_id int, interest_rate decimal (19,4))
begin
	select a.id as account_id, ah.first_name, ah.last_name, a.balance as current_balance, 
	ufn_calculate_future_value(a.balance, interest_rate,5) as balance_in_5_years from accounts as a
	join account_holders as ah on ah.id = a.account_holder_id
	where a.id = account_id;
end $$


#13
DELIMITER $$
create procedure usp_deposit_money(IN account_id int, IN money_amount decimal(19,4))
begin
	start transaction;
	update accounts set accounts.balance = accounts.balance + money_amount
	where accounts.id = account_id;
	if (money_amount <= 0)
	then 
		rollback;
	else
		commit;
	end if;
end $$

#14
delimiter $$
create procedure usp_withdraw_money(account_id int, money_amount decimal(19,4))
begin
declare amount decimal(19,4);
set amount := (select a.balance from accounts as a
					where a.id = account_id);
start transaction;
update accounts
set balance = balance - money_amount
where id = account_id;
if money_amount < 0 then rollback;
elseif amount < money_amount then rollback;
elseif account_id not in(select a.id from accounts as a) then rollback;
else commit;
end if;
end $$

#15
drop procedure if exists usp_transfer_money;
delimiter $$
create procedure usp_transfer_money(from_account_id int, to_account_id int, amount decimal(19,4))
begin
declare from_acc_balance decimal(19,4);
declare to_acc_balance decimal(19,4);
set from_acc_balance = (select a.balance from accounts as a where a.id = from_account_id);
set to_acc_balance = (select a.balance from accounts as a where a.id = to_account_id);
start transaction;
update accounts
set balance = from_acc_balance - amount
where id=from_account_id;
update accounts
set balance = to_acc_balance + amount
where id=to_account_id;
if amount < 0 then rollback;
elseif from_account_id not in (select a.id from accounts as a) then rollback;
elseif to_account_id not in (select a.id from accounts as a) then rollback;
elseif from_acc_balance < amount then rollback;
elseif from_account_id = to_account_id then rollback;
end if;
commit;
end $$

#16
create table logs (
log_id int auto_increment primary key,
account_id int,
old_sum decimal(19,4),
new_sum decimal(19,4)
);

delimiter $$
create trigger tr_update_accounts_logs
after update on accounts
for each row
begin
	insert into logs(account_id, old_sum, new_sum)
	values (new.id, old.balance, new.balance);
end $$

#17
create table logs (
log_id int auto_increment primary key,
account_id int,
old_sum decimal(19,4),
new_sum decimal(19,4)
);

delimiter $$
create trigger tr_update_accounts_logs
after update on accounts
for each row
begin
	insert into logs(account_id, old_sum, new_sum)
	values (new.id, old.balance, new.balance);
end $$

delimiter ;

drop table if exists notification_emails;
create table notification_emails(
id int auto_increment primary key,
recipient int,
subject varchar(100),
body varchar(200)
);

drop trigger if exists tr_insert_logs_emails;
delimiter $$
create trigger tr_insert_logs_emails
after insert on logs
for each row
begin
	insert into notification_emails( recipient, subject, body)
	values (	new.account_id, 
				CONCAT('balance change for account: ',new.account_id), 
				CONCAT_WS(' ','On', DATE_FORMAT(Now(),%b %d %Y at %r), 'your balance was changed from', new.old_sum, 'to', new.new_sum, '.'));
end $$

#18
delimiter $$
create procedure usp_buy_items(player_game_id int, item_name varchar(50))
begin
declare item_price decimal(19,4);
declare itemid int;
set item_price = (select i.price from items as i where i.name = item_name);
set itemid = (select i.id from items as i where i.name = item_name);	
	update users_games
	set cash = cash - item_price
	where id = player_game_id;
	insert into user_game_items(item_id,user_game_id)
	values (itemid, player_game_id);
end $$


drop procedure if exists usp_massive_shopping;
delimiter $$
create procedure usp_massive_shopping()
begin
declare player_game_id int;
declare player_cash decimal(19,4);
DECLARE done INT;
DECLARE item_name VARCHAR(50);
	DECLARE cursor1 CURSOR FOR  select i.name from items as i where i.min_level in(11,12);
	declare cursor2 cursor for select i.name from items as i where i.min_level in(19,20,21);
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
  	set player_game_id = (select ug.id from users as u 
									join users_games as ug on u.id = ug.user_id
									join games as g on ug.game_id = g.id 
									where u.user_name = 'Stamat' and g.name = 'Safflower'); 
	
	start transaction;
	  	OPEN cursor1;
	  	set done = 0;
	  	items_part1: loop
	   	FETCH cursor1 INTO item_name;
	   	if done then leave items_part1;
	  		end if;
	      call usp_buy_items(player_game_id,item_name);
	  	end loop;
	  	set player_cash = (select ug.cash from users_games as ug where id = player_game_id);
		if (player_cash < 0) then rollback;
		else commit;
  		end if;
  		close cursor1;
		   		
  	start transaction;
	  	open cursor2;
	  	set done = 0;
	  	items_part2: loop
	  		fetch cursor2 into item_name;
	  		if done then leave items_part2;
	  		end if;
	  		call usp_buy_items(player_game_id,item_name);	 
		end loop;
		set player_cash = (select ug.cash from users_games as ug where id = player_game_id);
		if (player_cash < 0) then rollback;
		else commit;
  		end if;
	  	close cursor2;
	   
  	
  	select i.name as 'Item Name' from items as i 
					  							join user_game_items as ugi on ugi.item_id = i.id
											   join users_games as ug on ug.id = ugi.user_game_id
												join games as g on g.id = ug.game_id
												where g.name = 'Safflower'
												order by i.name;
								
	select ug.cash from users_games as ug
								join users as u on ug.user_id = u.id
								join games as g on g.id = ug.game_id
								where g.name = 'Safflower' and u.user_name = 'Stamat';
end $$

call usp_massive_shopping();

#19
delimiter $$
create procedure usp_buy_items(player_game_id int, item_name varchar(50))
begin
declare itemid int;
declare item_price decimal(19,4); 
declare player_cash decimal(19,4);
declare player_level int;
declare item_min_level int;
set itemid := (select i.id from items as i where i.name = item_name);
set item_price := (select i.price from items as i where i.name = item_name);
set player_level := (select ug.level from users_games as ug where ug.id = player_game_id);
set item_min_level := (select i.min_level from items as i where i.name = item_name);
start transaction;
	update users_games
	set cash = cash - item_price
	where id = player_game_id;
	insert into user_game_items(item_id, user_game_id)
	values (itemid, player_game_id);
	set player_cash := (select ug.cash from users_games as ug where ug.id = player_game_id);
	if (player_cash < 0) then rollback;
	elseif ( player_level < item_min_level) then rollback;
	end if;
	commit;
	
end $$



delimiter $$
create procedure usp_buy_items_for_alex ()
begin
declare player_game_id int;
set player_game_id := (select ug.id from users as u 
									join users_games as ug on u.id = ug.user_id
									join games as g on ug.game_id = g.id 
									where u.user_name = 'Alex' and g.name = 'Edinburgh');

call usp_buy_items(player_game_id, 'Blackguard');
call usp_buy_items(player_game_id, 'Bottomless Potion of Amplification');
call usp_buy_items(player_game_id, 'Eye of Etlich (Diablo III)');
call usp_buy_items(player_game_id, 'Gem of Efficacious Toxin');
call usp_buy_items(player_game_id, 'Golden Gorget of Leoric');
call usp_buy_items(player_game_id, 'Ziggurat Tooth');
call usp_buy_items(player_game_id, 'The Three Hundredth Spear');
call usp_buy_items(player_game_id, 'The Short Mans Finger');
call usp_buy_items(player_game_id, 'Tzo Krins Gaze');
call usp_buy_items(player_game_id, 'Valtheks Rebuke');
call usp_buy_items(player_game_id, 'Utars Roar');
call usp_buy_items(player_game_id, 'Urn of Quickening');
call usp_buy_items(player_game_id, 'Boots');
call usp_buy_items(player_game_id, 'Bombardiers Rucksack');
call usp_buy_items(player_game_id, 'Cloak of Deception');
call usp_buy_items(player_game_id, 'Hellfire Amulet');

select u.user_name as 'Username', 
		g.name as 'Name', 
		ug.cash as 'Cash', 
		i.name as 'Item Name' from users_games as ug
					join games as g on g.id = ug.game_id
					join users as u on u.id = ug.user_id
					join user_game_items as ugi on ug.id = ugi.user_game_id
					join items as i on i.id = ugi.item_id
					where g.name = 'Edinburgh'
					order by i.name;
end $$

call usp_buy_items_for_alex();