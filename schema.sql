CREATE DATABASE desafioDois;

create table administradores(
  id serial not null primary key,
  nome varchar(50) not null,
  email varchar(50) not null unique,
  senha text not null
);

drop table administradores;


insert into administradores (nome, email, senha) values ('Frankilns','Frankilns@email.com','senhaqualquer');
insert into administradores (nome, email, senha) values ('Bianca','Bianca@email.com','senhaqualquer');
insert into administradores (nome, email, senha) values ('Gabrielli','Gabrielli@email.com', 'senhaqualquer');
insert into administradores (nome,email,  senha) values ('Mayanna','Mayanna@email.com', 'senhaqualquer');
insert into administradores (nome,email,  senha) values ('Lukas','Lukas@email.com','senhaqualquer');
insert into administradores (nome,email,  senha) values ('teste','teste@email.com','senhaqualquer');

drop table usuarios;

create table usuarios(
  id serial not null primary key,
  nome varchar(50) not null,
  cpf varchar(14) not null unique,
  telefone varchar(20) not null unique,
  data_nascimento timestamp default current_timestamp
);
