create table product_category(
    id int8 not null,
    name varchar(50) not null,
    description varchar(255) not null,
    active_flg boolean not null,
    primary key (id)
);

create table product (
    id int8 not null,
    pid varchar(50) not null,
    name varchar(50) null,
    description varchar(255) not null,
    active_flg boolean not null ,
    product_category_id int8 not null references product_category(id),
    primary key (id)
);

