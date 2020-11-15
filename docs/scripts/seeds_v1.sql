insert into contratos(tipo,data_final ) values('Eterno', null);

insert into empresas(contrato_id , nome, cnpj , sede)
values
((select id from contratos where tipo like 'Eterno'),'Admin SA','12345678910', 'São Paulo'),
((select id from contratos where tipo like 'Eterno'),'Testin SA','12345678911', 'Acre'),
((select id from contratos where tipo like 'Eterno'),'Test SA','12345678912', 'Rio do Sul');

insert into perfil_usuario (descricao ) values('Administrador'),('Gerente'),('Operador');
insert into funcionalidades (descricao) values('GPS'),('Sensores'),('Tudo');

insert into funcionalidade_contrato (contrato_id, funcionalidade_id)
values((select id from contratos where tipo like 'Eterno'),(select id from funcionalidades where descricao like 'Tudo'));

insert into usuarios(nome,cpf,email,senha,empresa_id,perfil_id)
values ('gerente','712.491.940-16','gerente','gerente@gerente.com',
(select id from empresas where cnpj like '12345678910'), 
(select id from perfil_usuario where descricao like 'Gerente')),

('operador','321.645.800-87','operador','operador@operador.com',
(select id from empresas where cnpj like '12345678910'), 
(select id from perfil_usuario where descricao like 'Operador')),

('admin','928.580.070-04','admin','admin@admin.com',
(select id from empresas where cnpj like '12345678910'), 
(select id from perfil_usuario where descricao like 'Administrador'));

insert into caminhoes(empresa_id,placa,chassi,modelo)
values 
((select id from empresas where cnpj like '12345678910'),
'MYD-6258','2fVmvxegAKjYC0155','IVEKO'),
((select id from empresas where cnpj like '12345678911'),
'NEU-7883','5pAEAK3zxbC7A0791','IVEKO'),
((select id from empresas where cnpj like '12345678912'),
'FTK-1821','78NzT8upDKCld6836','IVEKO')
