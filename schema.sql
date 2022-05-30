

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
  data_nascimento timestamp default current_timestamp,
  email varchar(50) not null unique
);

create table pedido(
  id serial not null primary key,
  usuario_id integer not null,
  valor_total integer not null,
  descricao varchar(250) not null,
  data_criacao timestamp default current_timestamp,
  status varchar(12) not null default 'em_aberto',
  constraint fk_cliente foreign key (usuario_id) references usuarios(id)
);


