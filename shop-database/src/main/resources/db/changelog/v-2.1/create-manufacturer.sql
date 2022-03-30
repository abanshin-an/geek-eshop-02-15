
CREATE TABLE IF NOT EXISTS manufacturer
(
    id              bigserial primary key,
    name            character varying(255) NOT NULL
);

INSERT INTO manufacturer (id,name)
VALUES (1,'Apple')
     ,(2,'Aquarius')
     ,(3,'Canon')
     ,(4,'Dell')
     ,(5,'HP')
     ,(6,'Lenovo')
     ,(7,'LG')
     ,(8,'Samsung')
     ,(9,'TrustPhone')
     ,(10,'Xerox')
     ,(11,'Xiaomi')
;

alter table product
    add column manufacturer_id bigint;
alter table product
    add constraint manufacturer_id_fkey foreign key (manufacturer_id)
        references manufacturer (id) match simple
        on update cascade on delete cascade;

update product set manufacturer_id=1  where id =  1 ;
update product set manufacturer_id=8  where id =  2 ;
update product set manufacturer_id=11 where id =  3 ;
update product set manufacturer_id=9  where id =  4 ;
update product set manufacturer_id=1  where id =  5 ;
update product set manufacturer_id=6  where id =  6 ;
update product set manufacturer_id=2  where id =  7 ;
update product set manufacturer_id=8  where id =  8 ;
update product set manufacturer_id=1  where id =  9 ;
update product set manufacturer_id=5  where id = 10 ;
update product set manufacturer_id=4  where id = 11 ;
update product set manufacturer_id=6  where id = 12 ;
update product set manufacturer_id=5  where id = 13 ;
update product set manufacturer_id=3  where id = 14 ;
update product set manufacturer_id=5  where id = 15 ;
update product set manufacturer_id=10 where id = 16 ;
update product set manufacturer_id=4  where id = 17 ;
update product set manufacturer_id=8  where id = 18 ;
update product set manufacturer_id=7  where id = 19 ;
update product set manufacturer_id=5  where id = 20 ;

