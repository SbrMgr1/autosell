insert into user (id,admin_verification, email, first_name, last_name, password, user_name, user_status) values (1,true, 'admin@gmail.com','Admin','','$2a$10$pz4xJn5hEFaxKCpJYdCIFeJgwtaqiJ24Th8bk0Lm2w2y.Db5Cslom','admin',1);
insert into authority (id,authority, user_name) values (1,'ROLE_ADMIN','admin');

insert into user (id,admin_verification, email, first_name, last_name, password, user_name, user_status) values (2,true, 'seller@gmail.com','Seller','','$2a$10$SCWgUYqcvf5s4w4cNZmFI.5RQ/Iby2ItE2pEXk9lsaD2KBO/ZWeFO','seller',1);
insert into authority (id,authority, user_name) values (2,'ROLE_SELLER','seller');

insert into user (id,admin_verification, email, first_name, last_name, password, user_name, user_status) values (3,true, 'buyer@gmail.com','Buyer','','$2a$10$cwBCBwwMCzhOYqJp5Eioo./KN0jJYkQVOL/2ndZwNKzSqE6jgbDzO','buyer',1);
insert into authority (id,authority, user_name) values (3,'ROLE_BUYER','buyer');

