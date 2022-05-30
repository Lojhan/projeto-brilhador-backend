DROP TABLE IF EXISTS vendasproduto;
DROP TABLE IF EXISTS vendas;
DROP TABLE IF EXISTS produto;
DROP TABLE IF EXISTS contaspagar;

CREATE TABLE vendas(
	
id INT NOT NULL AUTO_INCREMENT,
descricao VARCHAR(100) CHARACTER SET 'latin1' NOT NULL,
valorDaVenda FLOAT NOT NULL,
nomeCliente VARCHAR(200),
numeroFiscal INT NOT NULL,
horaDaVenda DATETIME NOT NULL DEFAULT NOW(),

PRIMARY KEY (id)
)ENGINE=InnoDB, DEFAULT CHARACTER SET = latin1;

CREATE TABLE produto(
	
id INT NOT NULL AUTO_INCREMENT,
descricao VARCHAR(100) CHARACTER SET 'latin1' NOT NULL,
valor FLOAT NOT NULL,
quantidade FLOAT,

PRIMARY KEY (id)
)ENGINE=InnoDB, DEFAULT CHARACTER SET = latin1;

CREATE TABLE vendasproduto(
	
id INT NOT NULL AUTO_INCREMENT,
idProduto INT NOT NULL,
idVenda INT NOT NULL,
quantidade INT NOT NULL, 	

PRIMARY KEY (id),
FOREIGN KEY (idProduto) REFERENCES produto(id),
FOREIGN KEY (idVenda) REFERENCES vendas(id)
)ENGINE=InnoDB, DEFAULT CHARACTER SET = latin1;

CREATE TABLE contaspagar(
	
id INT NOT NULL AUTO_INCREMENT,
valor FLOAT NOT NULL,
isBaixado BOOLEAN NOT NULL,
dataBaixa DATETIME,
classificacao VARCHAR(100) NOT NULL,

PRIMARY KEY (id)
)ENGINE=InnoDB, DEFAULT CHARACTER SET = latin1;


INSERT INTO `graziyuri`.`produto` (`descricao`, `valor`, `quantidade`) VALUES ('Coca', '9', '100');
INSERT INTO `graziyuri`.`produto` (`descricao`, `valor`, `quantidade`) VALUES ('Guarana', '6', '250');
INSERT INTO `graziyuri`.`produto` (`descricao`, `valor`, `quantidade`) VALUES ('Pepsi', '6', '300');
INSERT INTO `graziyuri`.`produto` (`descricao`, `valor`, `quantidade`) VALUES ('Fanta', '8', '120');
INSERT INTO `graziyuri`.`produto` (`descricao`, `valor`, `quantidade`) VALUES ('Sprite', '6', '230');
INSERT INTO `graziyuri`.`produto` (`descricao`, `valor`, `quantidade`) VALUES ('Dolli', '2', '100');
INSERT INTO `graziyuri`.`produto` (`descricao`, `valor`, `quantidade`) VALUES ('Sukita', '4', '140');
INSERT INTO `graziyuri`.`produto` (`descricao`, `valor`, `quantidade`) VALUES ('H2O', '6', '123');
INSERT INTO `graziyuri`.`produto` (`descricao`, `valor`, `quantidade`) VALUES ('Skol', '2', '560');
INSERT INTO `graziyuri`.`produto` (`descricao`, `valor`, `quantidade`) VALUES ('Bhama', '3', '320');
INSERT INTO `graziyuri`.`produto` (`descricao`, `valor`, `quantidade`) VALUES ('Sol', '2.4', '120');
INSERT INTO `graziyuri`.`produto` (`descricao`, `valor`, `quantidade`) VALUES ('Caracu', '3', '140');
INSERT INTO `graziyuri`.`vendas` (`descricao`, `valorDaVenda`, `nomeCliente`, `numeroFiscal`) VALUES ('Venda varejo 1', '30', 'Fulano', '53434534');
INSERT INTO `graziyuri`.`vendas` (`descricao`, `valorDaVenda`, `nomeCliente`, `numeroFiscal`) VALUES ('Venda varejo 1', '15', 'Ciclano', '56156456');
INSERT INTO `graziyuri`.`vendas` (`descricao`, `valorDaVenda`, `nomeCliente`, `numeroFiscal`) VALUES ('Venda varejo 2', '30', 'Yuri', '21321321');
INSERT INTO `graziyuri`.`vendas` (`descricao`, `valorDaVenda`, `nomeCliente`, `numeroFiscal`) VALUES ('Venda varejo 1', '40', 'Grazi', '45465465');
INSERT INTO `graziyuri`.`vendas` (`descricao`, `valorDaVenda`, `nomeCliente`, `numeroFiscal`) VALUES ('Venda varejo 1', '35', 'Bel', '56454655');
INSERT INTO `graziyuri`.`vendas` (`descricao`, `valorDaVenda`, `nomeCliente`, `numeroFiscal`) VALUES ('Venda varejo 2', '10', 'Celso', '84848949');
INSERT INTO `graziyuri`.`vendas` (`descricao`, `valorDaVenda`, `nomeCliente`, `numeroFiscal`) VALUES ('Venda varejo 2', '3', 'Vinicius', '54654652');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('1', '1', '4');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('2', '1', '6');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('4', '2', '5');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('6', '2', '3');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('2', '2', '5');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('3', '3', '2');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('5', '3', '6');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('1', '3', '2');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('6', '3', '7');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('2', '4', '1');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('3', '4', '2');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('4', '4', '5');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('5', '4', '6');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('5', '5', '8');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('1', '5', '5');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('2', '6', '6');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('3', '7', '7');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('5', '7', '3');
INSERT INTO `graziyuri`.`vendasproduto` (`idProduto`, `idVenda`, `quantidade`) VALUES ('6', '7', '2');
INSERT INTO `graziyuri`.`contaspagar` (`valor`, `isBaixado`, `classificacao`) VALUES ('140', '0', 'PAGAMENTO DE FORNECEDOR');
INSERT INTO `graziyuri`.`contaspagar` (`valor`, `isBaixado`, `dataBaixa`, `classificacao`) VALUES ('3500', '1', NOW(), 'PAMENTO FOLHA');
INSERT INTO `graziyuri`.`contaspagar` (`valor`, `isBaixado`, `dataBaixa`, `classificacao`) VALUES ('260', '1', NOW(), 'CONCECIONARIA - LUZ');
INSERT INTO `graziyuri`.`contaspagar` (`valor`, `isBaixado`, `dataBaixa`, `classificacao`) VALUES ('359', '1', NOW(), 'CONCECIONARIA - AGUA');
INSERT INTO `graziyuri`.`contaspagar` (`valor`, `isBaixado`, `classificacao`) VALUES ('10000', '0', 'ALUGUEL');


