CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE contratos (
	id uuid primary key default uuid_generate_v4(),
	tipo varchar(40) unique not null,
	data_inicial timestamp default now(),
	data_final timestamp
);

create table funcionalidades(
	id uuid primary key default uuid_generate_v4(),
	descricao varchar(40) not null
);

create table funcionalidade_contrato(
	contrato_id uuid references contratos(id),
	funcionalidade_id uuid references funcionalidades(id),
	primary key(contrato_id, funcionalidade_id)
);

CREATE TABLE empresas(
	id uuid primary key  default uuid_generate_v4(),
	contrato_id uuid references contratos(id),
	nome varchar(40) unique not null,
	cnpj varchar(40) unique not null,
	sede varchar(40),
	data_cadastro timestamp DEFAULT now()
);

create table caminhoes(
	id uuid primary key  default uuid_generate_v4(),
	empresa_id uuid references empresas(id) ON DELETE CASCADE,
	placa varchar unique not null,
	modelo varchar not null,
	chassi varchar not null,
	data_cadastro timestamp default now()
);

create table viagens(
	id uuid primary key  default uuid_generate_v4(),
	caminhao_id uuid references caminhoes(id) ON DELETE CASCADE,
	status varchar(20) not null default 'em andamento',
	carga varchar(40) not null,
	endereco_origem varchar(40) not null,
	endereco_destino varchar(40) not null,
	peso_inicial int not null,
	peso_final int,
	data_inicial timestamp default now(),
	data_final timestamp
);

create table datalog(
	id uuid primary key default uuid_generate_v4(),
    viagem_id uuid references viagens(id) ON DELETE CASCADE,
	peso_atual float not null,
	latitude varchar(20),
	longitude varchar(20),
	data timestamp default now()
);

CREATE TABLE perfil_usuario (
	id uuid primary key DEFAULT uuid_generate_v4(),
	descricao varchar(20) not null
);

CREATE TABLE usuarios(
	id uuid primary key default uuid_generate_v4(),
	perfil_id uuid references perfil_usuario(id),
	empresa_id uuid references empresas(id) ON DELETE CASCADE,
	nome varchar(100) not null,
	cpf varchar(100) unique not null,
	email varchar(100) unique not null,
	senha varchar(100) not null
);

CREATE TABLE auditoria(
	id uuid primary key default uuid_generate_v4(),
	descricao varchar not null,
	data_criacao timestamp default now()
);


