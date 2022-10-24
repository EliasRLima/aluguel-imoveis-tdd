
insert into aluguel(idaluguel, idLocacao, dataVencimento, valorPago, dataPagamento, obs) values (11, 11, CURRENT_TIMESTAMP(), 1200, CURRENT_TIMESTAMP(), 'test');
insert into aluguel(idaluguel, idLocacao, dataVencimento, valorPago, dataPagamento, obs) values (22, 11, CURRENT_TIMESTAMP(), 1100, CURRENT_TIMESTAMP(), 'test');
insert into aluguel(idaluguel, idLocacao, dataVencimento, valorPago, dataPagamento, obs) values (33, 11, CURRENT_TIMESTAMP(), 1000, CURRENT_TIMESTAMP(), 'test');

insert into cliente(idCliente, nomeCliente, cpf, telefone1, telefone2, email, dataNascimento) values (11, 'Aluisio Junior', '12312312312', '12341234', '12345678', 'junior@email', CURRENT_TIMESTAMP());
insert into cliente(idCliente, nomeCliente, cpf, telefone1, telefone2, email, dataNascimento) values (22, 'Breno Silva', '12345612345', '12341234', '12345678', 'breno@email', CURRENT_TIMESTAMP());
insert into cliente(idCliente, nomeCliente, cpf, telefone1, telefone2, email, dataNascimento) values (33, 'Jose Costa', '45671234122', '12341234', '12345678', 'jose@email', CURRENT_TIMESTAMP());

insert into imovel(idImovel, tipoImovel, endereco, bairro, cep, metragem, dormitorios, banheiros, suites, vagasGaragem, valorAluguelSugerido, obs) values (11, 'Apartamento', 'rua 01', 'bairro 2', '1000000', 1231, 2, 1, 1, 2, 1100, 'Mobiliada');
insert into imovel(idImovel, tipoImovel, endereco, bairro, cep, metragem, dormitorios, banheiros, suites, vagasGaragem, valorAluguelSugerido, obs) values (22, 'Apartamento', 'rua 01', 'bairro 2', '1000000', 1231, 3, 1, 2, 4, 2100, 'Mobiliada');
insert into imovel(idImovel, tipoImovel, endereco, bairro, cep, metragem, dormitorios, banheiros, suites, vagasGaragem, valorAluguelSugerido, obs) values (33, 'Cobertura', 'rua 01', 'bairro 2', '1000000', 1231, 4, 2, 3, 10, 14100, 'Mobiliada');

insert into locacao(idLocacao, idImovel, idCliente, valorAluguel, percentualMulta, diavencimento, dataInicio, dataFim, ativo, obs) values (11, 11, 11, 1200, 0.33, 30, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()+30, 1, 'test');