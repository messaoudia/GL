# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table Clients (
  id                        bigint not null,
  nom                       varchar(255),
  importance                integer,
  archiver                  boolean,
  constraint pk_Clients primary key (id))
;

create table Taches (
  id                        bigint not null,
  nom                       varchar(255),
  description               varchar(255),
  niveau                    integer,
  date_debut                timestamp,
  date_fin_tot              timestamp,
  date_fin_tard             timestamp,
  charge                    integer,
  constraint pk_Taches primary key (id))
;

create sequence Clients_seq;

create sequence Taches_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists Clients;

drop table if exists Taches;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists Clients_seq;

drop sequence if exists Taches_seq;

