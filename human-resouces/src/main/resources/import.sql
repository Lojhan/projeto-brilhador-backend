INSERT INTO tb_plano_Saude(nome_Plano, valor_Plano) VALUES ('Nenhum', 0);
INSERT INTO tb_plano_Saude(nome_Plano, valor_Plano) VALUES ('Basico', 100);
INSERT INTO tb_plano_Saude(nome_Plano, valor_Plano) VALUES ('Intermediario', 150);
INSERT INTO tb_plano_Saude(nome_Plano, valor_Plano) VALUES ('Completo', 200);

INSERT INTO tb_treinamento(nome_Treinamento, area) VALUES ('Treinamento de vendas', 'vendas');
INSERT INTO tb_treinamento(nome_Treinamento, area) VALUES ('Treinamento de logistica', 'logistica');
INSERT INTO tb_treinamento(nome_Treinamento, area) VALUES ('Treinamento de RH', 'rh');

INSERT INTO tb_funcionario(id_plano_Saude, nome, email, data_Nasc, cpf , data_Contr, salario,  status, descricao, trans) VALUES  (1, 'Maicon', 'maicon@gmail.com', '01/01/2000' , '123.456.789-10', '01/01/2020', 1000, 'Ativo' , 'Logistica', true);
INSERT INTO tb_funcionario(id_plano_Saude, nome, email, data_Nasc, cpf , data_Contr, salario,  status, descricao, trans) VALUES (2, 'Eliane', 'eliane@gmail.com', '01/01/2000' , '123.456.789-11', '01/01/2020', 1500, 'Ativo' , 'Vendas', false);
INSERT INTO tb_funcionario(id_plano_Saude, nome, email, data_Nasc, cpf , data_Contr, salario,  status, descricao, trans) VALUES (3, 'Pedro', 'pedro@gmail.com', '01/01/2000' , '123.456.789-12', '01/01/2020', 2000, 'Ferias' , 'Rh', true);

INSERT INTO PESSOAS_TREINAMENTO(id_treinamento, id_funcionario) VALUES (1,1);
INSERT INTO PESSOAS_TREINAMENTO(id_treinamento, id_funcionario) VALUES (1,2);
INSERT INTO PESSOAS_TREINAMENTO(id_treinamento, id_funcionario) VALUES (2,2);
INSERT INTO PESSOAS_TREINAMENTO(id_treinamento, id_funcionario) VALUES (2,1);

