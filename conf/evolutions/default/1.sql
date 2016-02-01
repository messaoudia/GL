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

create table Client (
  id                        bigint not null,
  nom                       varchar(255),
  priorite                  integer,
  archiver                  boolean,
  constraint pk_Client primary key (id))
;

create table Notification (
  id                        bigint not null,
  title                     varchar(255),
  content_notification      varchar(255),
  date_envoi                date,
  link                      varchar(255),
  etat_lecture              boolean,
  archiver                  boolean,
  constraint pk_Notification primary key (id))
;

create table Personne (
  id                        bigint not null,
  nom                       varchar(255),
  prenom                    varchar(255),
  mail                      varchar(255),
  telephone                 varchar(255),
  constraint pk_Personne primary key (id))
;

create table Projet (
  id                        bigint not null,
  nom                       varchar(255),
  description               varchar(255),
  date_debut_theorique      date,
  date_fin_theorique        date,
  date_debut_reel           date,
  date_fin_reel             date,
  charge_initiale           integer,
  avancement_global         tinyint,
  en_cours                  boolean,
  archive                   boolean,
  priorite                  integer,
  unite                     integer,
  constraint ck_Projet_unite check (unite in (0,1)),
  constraint pk_Projet primary key (id))
;

create table Tache (
  id                        bigint not null,
  nom                       varchar(255),
  description               varchar(255),
  niveau                    integer,
  critique                  boolean,
  date_debut                date,
  date_fin_tot              date,
  date_fin_tard             date,
  charge_initiale           integer,
  charge_consommee          integer,
  charge_totale             integer,
  disponible                boolean,
  constraint pk_Tache primary key (id))
;

create sequence Adresse_seq;

create sequence Client_seq;

create sequence Notification_seq;

create sequence Personne_seq;

create sequence Projet_seq;

create sequence Tache_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists Adresse;

drop table if exists Client;

drop table if exists Notification;

drop table if exists Personne;

drop table if exists Projet;

drop table if exists Tache;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists Adresse_seq;

drop sequence if exists Client_seq;

drop sequence if exists Notification_seq;

drop sequence if exists Personne_seq;

drop sequence if exists Projet_seq;

drop sequence if exists Tache_seq;

