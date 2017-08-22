# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table phone (
  id                            varchar(255) not null,
  imageurl                      varchar(255),
  name                          varchar(255),
  snippet                       varchar(255),
  age                           bigint not null,
  carrier                       varchar(255),
  details                       TEXT,
  constraint pk_phone primary key (id)
);


# --- !Downs

drop table if exists phone;

