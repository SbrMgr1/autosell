insert into user (id,admin_verification, email, first_name, last_name, password, user_name, user_status) values (1,true, 'admin@gmail.com','Admin','','$2a$10$pz4xJn5hEFaxKCpJYdCIFeJgwtaqiJ24Th8bk0Lm2w2y.Db5Cslom','admin',1);
insert into authority (id,authority, user_name) values (1,'ROLE_ADMIN','admin');

insert into user (id,admin_verification, email, first_name, last_name, password, user_name, user_status) values (2,true, 'seller@gmail.com','Seller','','$2a$10$SCWgUYqcvf5s4w4cNZmFI.5RQ/Iby2ItE2pEXk9lsaD2KBO/ZWeFO','seller',1);
insert into authority (id,authority, user_name) values (2,'ROLE_SELLER','seller');

insert into user (id,admin_verification, email, first_name, last_name, password, user_name, user_status) values (3,true, 'buyer@gmail.com','Buyer','','$2a$10$cwBCBwwMCzhOYqJp5Eioo./KN0jJYkQVOL/2ndZwNKzSqE6jgbDzO','buyer',1);
insert into authority (id,authority, user_name) values (3,'ROLE_BUYER','buyer');


insert into category(id,name,description) values (1,'Electronics','Laptops,Hard drives,Tvs,mobile phones..');
insert into category(id,name,description) values (2,'Jewellery','Necklace,bracelets,ear-rings...');
insert into category(id,name,description) values (3,'Mobile Phones','iPhone,Samsung,Nokia,redMI...');
insert into category(id,name,description) values (4,'Home Decoration','Crockery sets,jars,containers,cookware....');
insert into category(id,name,description) values (5,'Baby care','Soaps,oil,body lotion,diapers....');

insert into product (id,name,price, tax, cat_id, description, product_image, added_by,sold_status) values (1,'Laptop',1122.12,10,1,'this is boot','macbook-pro.jpg',2,false);
insert into product (id,name,price, tax, cat_id, description, product_image, added_by,sold_status) values (2,'Glasses',1122.12,10,4,'this is glasses','glasses.png',2,false);
insert into product (id,name,price, tax, cat_id, description, product_image, added_by,sold_status) values (3,'Iphoe11',1122.12,10,3,'this is iphone','iphone11.jpg',2,false);
insert into product (id,name,price, tax, cat_id, description, product_image, added_by,sold_status) values (4,'Laptop',1122.12,10,1,'this is boot','macbook-pro.jpg',2,false);

-- CMS
insert into content(slug,cont,name) values('privacy-policy','Our Privacy Policy is here Our Privacy Policy is here Our Privacy Policy is here Our Privacy Policy is here','Privacy Policy');
insert into content(slug,cont,name) values('terms-and-conditions','You should read our privacy policy.You should read our privacy policy.You should read our privacy policy.','Terms and Condition');
insert into content(slug,cont,name) values('about-us','This page about US.This page about US.This page about US.This page about US.','About Us');
insert into content(slug,cont,name) values('faq','FAQ are listed here.FAQ are listed here.FAQ are listed here.FAQ are listed here.','FAQ');