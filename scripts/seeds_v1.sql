insert into contratos(tipo,data_final ) values('Eterno', null);

insert into empresas(contrato_id , nome, cnpj , sede);
values((select id from contratos where tipo like 'Eterno'),'Admin SA','12345678910', 'São Paulo');

insert into perfil_usuario (descricao ) values('Administrador'),('Gerente'),('Operador');
insert into funcionalidades (descricao) values('GPS'),('Sensores'),('Tudo');

insert into funcionalidade_contrato (contrato_id, funcionalidade_id)
values((select id from contratos where tipo like 'Eterno'),(select id from funcionalidades where descricao like 'Tudo'));

insert into usuarios(nome,cpf,email,senha,empresa_id,perfil_id)
values ('admin','123456789101','admin','admin@admin.com',
(select id from empresas where cnpj like '12345678910'), 
(select id from perfil_usuario where descricao like 'Administrador'));
