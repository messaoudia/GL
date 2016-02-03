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
  adresse_client_id         bigint,
  constraint uq_Client_adresse_client_id unique (adresse_client_id),
  constraint pk_Client primary key (id))
;

create table Contact (
  id                        bigint not null,
  nom                       varchar(255),
  prenom                    varchar(255),
  email                     varchar(255),
  telephone                 varchar(255),
  client_id                 bigint,
  constraint pk_Contact primary key (id))
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
  client_id                 bigint,
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
  projet_id                 bigint,
  predecesseur_id           bigint,
  parent_id                 bigint,
  constraint pk_Tache primary key (id))
;

create table User (
  id                        bigint not null,
  nom                       varchar(255),
  prenom                    varchar(255),
  email                     varchar(255),
  telephone                 varchar(255),
  password                  varchar(255),
  constraint pk_User primary key (id))
;


create table Contact_Tache (
  Contact_id                     bigint not null,
  Tache_id                       bigint not null,
  constraint pk_Contact_Tache primary key (Contact_id, Tache_id))
;
create sequence Adresse_seq;

create sequence Client_seq;

create sequence Contact_seq;

create sequence Notification_seq;

create sequence Projet_seq;

create sequence Tache_seq;

create sequence User_seq;

alter table Client add constraint fk_Client_adresseClient_1 foreign key (adresse_client_id) references Adresse (id) on delete restrict on update restrict;
create index ix_Client_adresseClient_1 on Client (adresse_client_id);
alter table Contact add constraint fk_Contact_client_2 foreign key (client_id) references Client (id) on delete restrict on update restrict;
create index ix_Contact_client_2 on Contact (client_id);
alter table Projet add constraint fk_Projet_client_3 foreign key (client_id) references Client (id) on delete restrict on update restrict;
create index ix_Projet_client_3 on Projet (client_id);
alter table Tache add constraint fk_Tache_projet_4 foreign key (projet_id) references Projet (id) on delete restrict on update restrict;
create index ix_Tache_projet_4 on Tache (projet_id);
alter table Tache add constraint fk_Tache_predecesseur_5 foreign key (predecesseur_id) references Tache (id) on delete restrict on update restrict;
create index ix_Tache_predecesseur_5 on Tache (predecesseur_id);
alter table Tache add constraint fk_Tache_parent_6 foreign key (parent_id) references Tache (id) on delete restrict on update restrict;
create index ix_Tache_parent_6 on Tache (parent_id);



alter table Contact_Tache add constraint fk_Contact_Tache_Contact_01 foreign key (Contact_id) references Contact (id) on delete restrict on update restrict;

alter table Contact_Tache add constraint fk_Contact_Tache_Tache_02 foreign key (Tache_id) references Tache (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists Adresse;

drop table if exists Client;

drop table if exists Contact;

drop table if exists Contact_Tache;

drop table if exists Notification;

drop table if exists Projet;

drop table if exists Tache;

drop table if exists User;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists Adresse_seq;

drop sequence if exists Client_seq;

drop sequence if exists Contact_seq;

drop sequence if exists Notification_seq;

drop sequence if exists Projet_seq;

drop sequence if exists Tache_seq;

drop sequence if exists User_seq;

