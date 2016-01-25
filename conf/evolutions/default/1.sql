# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table Adresse (
  id                        bigint not null,
  adresse                   varchar(255),
  zip_code                  varchar(255),
  ville                     varchar(255),
  pays                      varchar(255),
  constraint pk_Adresse primary key (id))
;

create table Clients (
  id                        bigint not null,
  nom                       varchar(255),
  importance                integer,
  archiver                  boolean,
  constraint pk_Clients primary key (id))
;

create table Notification (
  id                        bigint not null,
  title                     varchar(255),
  content_notification      varchar(255),
  date_envoi                timestamp,
  link                      varchar(255),
  etat_lecture              boolean,
  archiver                  boolean,
  constraint pk_Notification primary key (id))
;

create table Projet (
  id                        bigint not null,
  nom                       varchar(255),
  description               varchar(255),
  date_debut                timestamp,
  date_fin                  timestamp,
  charge_initiale           integer,
  avancement_global         tinyint,
  en_cours                  boolean,
  archive                   boolean,
  priorite                  integer,
  constraint pk_Projet primary key (id))
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

create sequence Adresse_seq;

create sequence Clients_seq;

create sequence Notification_seq;

create sequence Projet_seq;

create sequence Taches_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists Adresse;

drop table if exists Clients;

drop table if exists Notification;

drop table if exists Projet;

drop table if exists Taches;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists Adresse_seq;

drop sequence if exists Clients_seq;

drop sequence if exists Notification_seq;

drop sequence if exists Projet_seq;

drop sequence if exists Taches_seq;

