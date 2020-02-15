create table tb_customers (
    id int auto_increment primary key,
    username varchar(20),
    password varchar(20)
);

create table tb_employees (
    id int auto_increment primary key,
    username varchar(20),
    password varchar(20)
);
insert into tb_customers (username, password) values ('customer1', 'customer1');
insert into tb_customers (username, password) values ('customer2', 'customer2');
insert into tb_customers (username, password) values ('customer3', 'customer3');
insert into tb_customers (username, password) values ('customer4', 'customer4');
insert into tb_customers (username, password) values ('customer5', 'customer5');
insert into tb_customers (username, password) values ('customer6', 'customer6');
insert into tb_customers (username, password) values ('customer7', 'customer7');
insert into tb_customers (username, password) values ('customer8', 'customer8');
insert into tb_customers (username, password) values ('customer9', 'customer9');

insert into tb_employees (username, password) values ('employee1', 'employee1');
insert into tb_employees (username, password) values ('employee2', 'employee2');
insert into tb_employees (username, password) values ('employee3', 'employee3');
insert into tb_employees (username, password) values ('employee4', 'employee4');
insert into tb_employees (username, password) values ('employee5', 'employee5');
insert into tb_employees (username, password) values ('employee6', 'employee6');
insert into tb_employees (username, password) values ('employee7', 'employee7');
insert into tb_employees (username, password) values ('employee8', 'employee8');
insert into tb_employees (username, password) values ('employee9', 'employee9');
