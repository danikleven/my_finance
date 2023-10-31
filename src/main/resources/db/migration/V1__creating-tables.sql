create table finances (
    id bigint not null auto_increment,
    detailing text not null,
    amount bigint(20) not null,
    financeDate date,

    primary key(id)

);

create table expenses (
    id bigint not null auto_increment,
    detailing text not null,
    amount bigint(20) not null,
    expensesDate date,

    primary key(id)
);