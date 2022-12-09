create table product
(
    id    bigserial primary key,
    title varchar(255),
    price int
);
insert into product(title, price)
values ('meat', 450),
       ('box', 120),
       ('vodka', 380),
       ('water', 90),
       ('snow', 50),
       ('bear', 110),
       ('xer', 200),
       ('pussy', 1500),
       ('boobs', 500),
       ('sex', 2000);
