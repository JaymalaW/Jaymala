/* Movie Table Details */

INSERT INTO `moviecruiser`.`movie` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('1', 'Avatar', '2787965087', '1', '2020-03-15', 'Science Fiction', '1');
INSERT INTO `moviecruiser`.`movie` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('2', 'The Avengers', '1518812988', '1', '2020-12-23', 'Superhero', '0');
INSERT INTO `moviecruiser`.`movie` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('3', 'Titanic', '2187463944', '1', '2017-08-21', 'Romance', '0');
INSERT INTO `moviecruiser`.`movie` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('4', 'Jurassic World', '1671713208', '0', '2017-07-02', 'Science Fiction', '1');
INSERT INTO `moviecruiser`.`movie` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('5', 'Avengers:End Game', '2750760348', '1', '2022-11-02', 'Superhero', '1');

/* User Table Details */

INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('1', 'Jaymala');
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('2', 'Ashwini');


/* Cart Table Details */

INSERT INTO `moviecruiser`.`favorite` (`fv_id`, `fv_us_id`, `fv_mo_id`) VALUES ('1', '1', '1');
INSERT INTO `moviecruiser`.`favorite` (`fv_id`, `fv_us_id`, `fv_mo_id`) VALUES ('2', '1', '4');
INSERT INTO `moviecruiser`.`favorite` (`fv_id`, `fv_us_id`, `fv_mo_id`) VALUES ('3', '1', '5');

/* 1.	View Movie List Admin (TYUC001) */

SELECT mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser FROM moviecruiser.movie;

/* 2.	View Movie List Customer (TYUC002) */

select mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from moviecruiser.movie
where mo_active = 1
and mo_date_of_launch > (SELECT CURRENT_DATE());

/* 3.	Edit Movie (TYUC003) */

select mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from moviecruiser.movie
where mo_id = 1;

update moviecruiser.movie
set
mo_title = 'Avatar One',
mo_box_office = '2787965807',
mo_active = '1',
mo_date_of_launch = '2020-03-25',
mo_genre = 'Science Fiction',
mo_has_teaser = '1'
where mo_id = 1;

/* 4.	Add to Favorite (TYUC004) */

/* 5.	View Favorite (TYUC005)  */

select mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from moviecruiser.movie
inner join moviecruiser.favorite as Result
on fv_mo_id = mo_id
where fv_us_id = 1;

select count(fv_id) as No_of_Favorite from moviecruiser.favorite
where fv_us_id = 1;

/* 6.	Remove movie from Favorite (TYUC006)  */

delete from moviecruiser.favorite
where fv_us_id = 1
and fv_mo_id = 4 limit 1;

SELECT mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser FROM moviecruiser.favorite;