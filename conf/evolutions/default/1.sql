# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table adresse (
  id                        bigint not null,
  adresse                   varchar(255),
  zip_code                  varchar(255),
  ville                     varchar(255),
  pays                      varchar(255),
  constraint pk_adresse primary key (id))
;

create table client (
  id                        bigint not null,
  nom                       varchar(255),
  priorite                  integer,
  archiver                  boolean,
  adresse_client_id         bigint,
  constraint uq_client_adresse_client_id unique (adresse_client_id),
  constraint pk_client primary key (id))
;

create table contact (
  id                        bigint not null,
  nom                       varchar(255),
  prenom                    varchar(255),
  email                     varchar(255),
  telephone                 varchar(255),
  client_id                 bigint,
  constraint pk_contact primary key (id))
;

create table notification (
  id                        bigint not null,
  title                     varchar(255),
  content_notification      varchar(255),
  date_envoi                date,
  link                      varchar(255),
  etat_lecture              boolean,
  archiver                  boolean,
  utilisateur_id            bigint,
  constraint pk_notification primary key (id))
;

create table projet (
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
  constraint ck_projet_unite check (unite in (0,1)),
  constraint pk_projet primary key (id))
;

create table tache (
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
  responsable_id            bigint,
  constraint pk_tache primary key (id))
;

create table utilisateur (
  id                        bigint not null,
  nom                       varchar(255),
  prenom                    varchar(255),
  email                     varchar(255),
  telephone                 varchar(255),
  password                  varchar(255),
  constraint pk_utilisateur primary key (id))
;


create table contact_tache (
  contact_id                     bigint not null,
  tache_id                       bigint not null,
  constraint pk_contact_tache primary key (contact_id, tache_id))
;
create sequence adresse_seq;

create sequence client_seq;

create sequence contact_seq;

create sequence notification_seq;

create sequence projet_seq;

create sequence tache_seq;

create sequence utilisateur_seq;

alter table client add constraint fk_client_adresseClient_1 foreign key (adresse_client_id) references adresse (id) on delete restrict on update restrict;
create index ix_client_adresseClient_1 on client (adresse_client_id);
alter table contact add constraint fk_contact_client_2 foreign key (client_id) references client (id) on delete restrict on update restrict;
create index ix_contact_client_2 on contact (client_id);
alter table notification add constraint fk_notification_utilisateur_3 foreign key (utilisateur_id) references utilisateur (id) on delete restrict on update restrict;
create index ix_notification_utilisateur_3 on notification (utilisateur_id);
alter table projet add constraint fk_projet_client_4 foreign key (client_id) references client (id) on delete restrict on update restrict;
create index ix_projet_client_4 on projet (client_id);
alter table tache add constraint fk_tache_projet_5 foreign key (projet_id) references projet (id) on delete restrict on update restrict;
create index ix_tache_projet_5 on tache (projet_id);
alter table tache add constraint fk_tache_predecesseur_6 foreign key (predecesseur_id) references tache (id) on delete restrict on update restrict;
create index ix_tache_predecesseur_6 on tache (predecesseur_id);
alter table tache add constraint fk_tache_parent_7 foreign key (parent_id) references tache (id) on delete restrict on update restrict;
create index ix_tache_parent_7 on tache (parent_id);
alter table tache add constraint fk_tache_responsable_8 foreign key (responsable_id) references utilisateur (id) on delete restrict on update restrict;
create index ix_tache_responsable_8 on tache (responsable_id);



alter table contact_tache add constraint fk_contact_tache_contact_01 foreign key (contact_id) references contact (id) on delete restrict on update restrict;

alter table contact_tache add constraint fk_contact_tache_tache_02 foreign key (tache_id) references tache (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists adresse;

drop table if exists client;

drop table if exists contact;

drop table if exists contact_tache;

drop table if exists notification;

drop table if exists projet;

drop table if exists tache;

drop table if exists utilisateur;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists adresse_seq;

drop sequence if exists client_seq;

drop sequence if exists contact_seq;

drop sequence if exists notification_seq;

drop sequence if exists projet_seq;

drop sequence if exists tache_seq;

drop sequence if exists utilisateur_seq;

