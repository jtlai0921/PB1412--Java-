create table images (

	id int identity(1,1) primary key,
	name varchar(20),
	type varchar(10),
	content image
);