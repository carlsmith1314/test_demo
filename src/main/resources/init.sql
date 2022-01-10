create table test_demo(
                          id int auto_increment not null ,
                          name varchar(20) not null unique ,
                          sex varchar(10) not null ,
                          age int not null ,
                          address varchar(128) not null ,
                          relation varchar(128) not null ,
                          primary key (id, name)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

insert into test_demo (name, sex, age, address, relation) values ('零落', '女', '23', '广东省', 'my honey');

insert into test_demo (name, sex, age, address, relation) values ('CarlSmith', '男', '23', '内蒙古自治区', 'me');