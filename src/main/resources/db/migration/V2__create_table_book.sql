create table book
(
    id   int auto_increment primary key,
    name  varchar(255) null,
    price decimal(10,2),
    status varchar(255),
    customer_id int not null,
    foreign key (customer_id) references customer(id)
);
