/* MenuItem Table Details  */

INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'Sandwich', '99.00', '1', '2020-03-15', 'Main Course', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'Burger', '129.00', '1', '2017-12-23', 'Mani Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'Pizza', '149', '1', '2020-08-21', 'Main Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'French Fries', '57.00', '0', '2017-07-02', 'Starters', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'Chocolate Brownie', '32.00', '1', '2022-11-02', 'Dessert', '1');

/* User Table Details  */

insert into `truyum`.user (us_id, us_name) values (1, 'Shiva');
insert into `truyum`.user (us_id, us_name) values (2, 'Ajay');

/* Cart Table Details  */

insert into `truyum`.cart (ct_us_id, ct_me_id) values (1,1);
insert into `truyum`.cart (ct_us_id, ct_me_id) values (1,3);
insert into `truyum`.cart (ct_us_id, ct_me_id) values (1,5);

/* 1.	View Menu Item List Admin (TYUC001) */

SELECT me_id, me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery FROM truyum.menu_item;

/* 2.	View Menu Item List Customer (TYUC002) */

select me_id, me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from truyum.menu_item 
where me_active = '1' 
and me_date_of_launch > (SELECT CURRENT_DATE());

/* 3.	Edit Menu Item (TYUC003) */

select me_id, me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from truyum.menu_item 
where me_id = 1;

update truYum.menu_item 
set 
me_name = 'Sandwich Toast',
me_price = 33.33,
me_active = '1',
me_date_of_launch = '2020-01-15',
me_category = 'Dessert',
me_free_delivery = '1'
where me_id = 1;

/* 4.	Add to Cart (TYUC004) */

/* 5.	View Cart (TYUC005)  */

select me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from
truyum.menu_item
inner join truyum.cart as Result 
on ct_me_id = me_id
where ct_us_id = 1;

select SUM(me_price) as Total_Price from
truyum.menu_item
inner join truyum.cart as Total
on ct_me_id = me_id
where ct_us_id = 1;

/* 6.	Remove Item from Cart (TYUC006)  */

delete from truyum.cart
where ct_us_id = 1 
and ct_me_id = 1 limit 1;

SELECT me_id, me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery FROM truyum.menu_item;
select * from truyum.cart;
