create database if not exists phimrap;

use phimrap;

drop table if exists phim;
CREATE TABLE phim(
                     maphim int,
                     tenphim varchar(50),
                     thoigianchieu varchar(50),
                     Daodienphim varchar(50),
                     timechieu int,
                     primary key (maphim));

insert into phim value (1, 'phim A','9-10-1980','Bo em', 120);
insert into phim value (2, 'phim B','20-10-1983','Me em', 121);
insert into phim value (3, 'phim C','12-10-2003','Chinh em', 122);
insert into phim value (4, 'phim D','13-10-2005','Em gai em', 123);
insert into phim value (5, 'phim E','5-4-2012','Em trai em', 124);
select * from phim;