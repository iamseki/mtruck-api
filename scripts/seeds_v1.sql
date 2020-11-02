insert into contratos(tipo,data_final ) values('Eterno', null);

insert into empresas(contrato_id , cnpj , sede )
values((select id from contratos where tipo like 'Eterno'), '12345678910', 'São Paulo')

insert into perfil_usuario (descricao ) values('Administrador')

insert into usuarios(nome,cpf,email,senha,empresa_id,perfil_id)
values ('admin','123456789101','admin','admin@admin.com',
(select id from empresas where cnpj like '12345678910'), (select id from perfil_usuario where descricao like 'Administrador'))
