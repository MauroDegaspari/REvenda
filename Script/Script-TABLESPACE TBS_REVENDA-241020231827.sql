-- Cria tablespace p/ dados
-- projeto	REVENDA
-- drop tablespace tbs_revenda;

create tablespace tbs_revenda
datafile 'E:\Programas\oraclexe\app\oracle\oradata\tbd_revenda.dbf' size 100M reuse
autoextend on next 10M maxsize 200M
online;


-- Cria usuario (dono das tabelas)
create user revenda --usuario
identified by "123"  --senha
default tablespace tbs_revenda
temporary tablespace temp;

-- Cria e define a "role" de privilegios (perfil)
create role perfil_desenv_chamae;

grant
create cluster,
create database link,
create procedure,
create session,
create sequence,
create synonym,
create table,
create any type,
create trigger,
create view
to perfil_desenv_chamae;


grant alter session to perfil_desenv_chamae;


grant create trigger to revenda;


grant perfil_desenv_chamae to revenda ;

grant unlimited tablespace to revenda;

