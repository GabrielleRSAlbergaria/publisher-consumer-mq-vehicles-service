create schema if not exists auto_maia;

create table auto_maia.vehicle
(
    id varchar(36) not null,
    marca varchar(36) not null,
    modelo varchar(36) not null,
    disponivel BOOLEAN not null,
    primary key (id)
);