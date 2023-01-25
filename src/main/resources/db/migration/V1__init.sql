create table product
(
    id         bigserial primary key,
    title      varchar(255),
    price      int,
    created_at timestamp default current_timestamp,
    update_at  timestamp default current_timestamp
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

create table order_Items
(
    id             bigserial primary key,
    title          varchar(255),
    quantity       int,
    price_per_item int,
    price          int
);