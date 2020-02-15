create table tb_directories (
    id int auto_increment primary key,
    path varchar(20000)
);

create index directories_index on tb_directories (path);