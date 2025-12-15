--<ds_script>
-- DESCRICAO...: Script de Carga de dados
--               Referente ao sistema REVENDA.
-- RESPONSAVEL.: Mauro Degaspari
-- DATA........: 09/12/2025
-- APLICACAO...: REVENDA
--</DS_SCRIPT>
--<USUARIO=revenda>


/* ==========================================================================================
   FORNECEDORES
   ========================================================================================== */
INSERT INTO revenda.tb_fornecedores (
  cd_fornecedor, nm_fornecedor, cnpj_fornecedor, email_fornecedor,
  telefone_fornecedor, celular_fornecedor, cep_fornecedor,
  endereco_fornecedor, numero_fornecedor, complemento_fornecedor,
  bairro_fornecedor, cidade_fornecedor, estado_fornecedor
) VALUES (
  revenda.SEQ_FORNECEDORES.NEXTVAL, 'Tech Supplies LTDA', '12.345.678/0001-90',
  'contato@techsuppl.com', '1133445566', '11987654321',
  '01000-000', 'Rua das Industrias', 100, NULL,
  'Industrial', 'São Paulo', 'SP'
);

INSERT INTO revenda.tb_fornecedores VALUES (
  revenda.SEQ_FORNECEDORES.NEXTVAL, 'Mundo Distribuidora', '98.765.432/0001-10',
  'vendas@mundodist.com', '1144556677', '11999998888',
  '02000-000', 'Av. Central', 250, 'Bloco B',
  'Centro', 'São Paulo', 'SP'
);


/* ==========================================================================================
   CLIENTES
   ========================================================================================== */
INSERT INTO revenda.tb_clientes VALUES (
  revenda.SEQ_CLIENTE.NEXTVAL, 'Pedro Almeida', '11.223.344-5', '111.222.333-99',
  'pedro@gmail.com', '1133001122', '11992001122', '07000-000',
  'Rua E', 12, NULL, 'Centro', 'Guarulhos', 'SP'
);

INSERT INTO revenda.tb_clientes VALUES (
  revenda.SEQ_CLIENTE.NEXTVAL, 'Luciana Barros', '22.334.455-6', '222.333.444-88',
  'luciana@hotmail.com', '1144556677', '11993002233', '07100-000',
  'Rua F', 88, 'Ap 101', 'Vila Nova', 'Guarulhos', 'SP'
);

INSERT INTO revenda.tb_clientes VALUES (
  revenda.SEQ_CLIENTE.NEXTVAL, 'Fernanda Dias', '33.445.566-7', '333.444.555-77',
  'fernanda@live.com', '1133992244', '11994003344', '07200-000',
  'Rua G', 34, NULL, 'Jardim Florido', 'São Paulo', 'SP'
);

INSERT INTO revenda.tb_clientes VALUES (
  revenda.SEQ_CLIENTE.NEXTVAL, 'Rafael Souza', '44.556.677-8', '444.555.666-66',
  'rafael@gmail.com', '1133557799', '11995004455', '07300-000',
  'Av. Paulista', 1000, 'Torre A', 'Paulista', 'São Paulo', 'SP'
);

INSERT INTO revenda.tb_clientes VALUES (
  revenda.SEQ_CLIENTE.NEXTVAL, 'Carolina Martins', '55.667.788-9', '555.666.777-55',
  'carol@yahoo.com', '1144665588', '11996005566', '07400-000',
  'Rua H', 23, NULL, 'Centro', 'Osasco', 'SP'
);

INSERT INTO revenda.tb_clientes VALUES (
  revenda.SEQ_CLIENTE.NEXTVAL, 'Gustavo Lima', '66.778.899-0', '666.777.888-44',
  'gustavo@hotmail.com', '1122003344', '11997006677', '07500-000',
  'Rua I', 45, 'Fundos', 'Vila Yara', 'Osasco', 'SP'
);

INSERT INTO revenda.tb_clientes VALUES (
  revenda.SEQ_CLIENTE.NEXTVAL, 'Aline Ferreira', '77.889.900-1', '777.888.999-33',
  'aline@gmail.com', '1133112244', '11998007788', '07600-000',
  'Av. Brasil', 900, NULL, 'Centro', 'Barueri', 'SP'
);

INSERT INTO revenda.tb_clientes VALUES (
  revenda.SEQ_CLIENTE.NEXTVAL, 'Marcelo Andrade', '88.990.011-2', '888.999.000-22',
  'marcelo@outlook.com', '1133445566', '11999008899', '07700-000',
  'Rua J', 67, 'Casa 1', 'Aldeia', 'Barueri', 'SP'
);

INSERT INTO revenda.tb_clientes VALUES (
  revenda.SEQ_CLIENTE.NEXTVAL, 'João da Silva', '12.345.678-9', '123.456.789-00',
  'joao@gmail.com', '1122334455', '11988887777', '03000-000',
  'Rua A', 10, NULL, 'Bela Vista', 'São Paulo', 'SP'
);

INSERT INTO revenda.tb_clientes VALUES (
  revenda.SEQ_CLIENTE.NEXTVAL, 'Maria Oliveira', '98.765.432-1', '987.654.321-00',
  'maria@hotmail.com', '1133557799', '11977776666', '04000-000',
  'Rua B', 22, 'Casa 2', 'Centro', 'Campinas', 'SP'
);


/* ==========================================================================================
   FUNCIONÁRIOS
   ========================================================================================== */
INSERT INTO revenda.tb_funcionarios VALUES (
  revenda.SEQ_FUNCIONARIOS.NEXTVAL, 'Carlos Pereira', '22.333.444-5', '222.333.444-55',
  'carlos@empresa.com', 'abc123', 'Vendedor', 'N',
  '1144556677', '11955554444', '05000-000',
  'Rua C', 45, NULL, 'Jardins', 'São Paulo', 'SP'
);

INSERT INTO revenda.tb_funcionarios VALUES (
  revenda.SEQ_FUNCIONARIOS.NEXTVAL, 'Ana Souza', '11.222.333-4', '111.222.333-44',
  'ana@empresa.com', 'xyz789', 'Gerente', 'S',
  '1133221100', '11944443333', '06000-000',
  'Rua D', 88, 'Sala 12', 'Centro', 'Santos', 'SP'
);

INSERT INTO revenda.tb_funcionarios VALUES (
  revenda.SEQ_FUNCIONARIOS.NEXTVAL, 'Thiago Rocha', '12.121.212-1', '111.111.111-11',
  'thiago@empresa.com', 'th123', 'Atendente', 'N',
  '1144122233', '11991112222', '08000-000',
  'Rua K', 45, NULL, 'Centro', 'São Paulo', 'SP'
);

INSERT INTO revenda.tb_funcionarios VALUES (
  revenda.SEQ_FUNCIONARIOS.NEXTVAL, 'Beatriz Mendes', '23.232.323-2', '222.222.222-22',
  'beatriz@empresa.com', 'bz321', 'Supervisora', 'S',
  '1133554466', '11992223333', '08100-000',
  'Rua L', 12, 'Bloco C', 'Jardins', 'São Paulo', 'SP'
);

INSERT INTO revenda.tb_funcionarios VALUES (
  revenda.SEQ_FUNCIONARIOS.NEXTVAL, 'Rodrigo Santos', '34.343.434-3', '333.333.333-33',
  'rodrigo@empresa.com', 'rg456', 'Vendedor', 'N',
  '1144778899', '11993334444', '08200-000',
  'Rua M', 99, NULL, 'Centro', 'Santos', 'SP'
);


/* ==========================================================================================
   PRODUTOS
   ========================================================================================== */
INSERT INTO revenda.tb_produtos VALUES (
  revenda.SEQ_PRODUTOS.NEXTVAL, 'Mouse Gamer X100', 120.50, 50,
  (SELECT MIN(cd_fornecedor) FROM revenda.tb_fornecedores)
);

INSERT INTO revenda.tb_produtos VALUES (
  revenda.SEQ_PRODUTOS.NEXTVAL, 'Teclado Mecânico RGB', 250.00, 30,
  (SELECT MIN(cd_fornecedor)+1 FROM revenda.tb_fornecedores)
);

INSERT INTO revenda.tb_produtos VALUES (
  revenda.SEQ_PRODUTOS.NEXTVAL, 'Monitor 24’’ FullHD', 899.90, 20,
  (SELECT MIN(cd_fornecedor)+1 FROM revenda.tb_fornecedores)
);


/* ==========================================================================================
   VENDAS
   ========================================================================================== */
INSERT INTO revenda.tb_vendas (
  cd_venda, cd_cliente, total_venda, obs_venda
) VALUES (
  revenda.SEQ_VENDAS.NEXTVAL,
  (SELECT MIN(cd_cliente) FROM revenda.tb_clientes),    -- João
  370.50, 'Compra à vista'
);

INSERT INTO revenda.tb_vendas (
  cd_venda, cd_cliente, total_venda, obs_venda
) VALUES (
  revenda.SEQ_VENDAS.NEXTVAL,
  (SELECT MIN(cd_cliente) + 1 FROM revenda.tb_clientes), -- Maria
  899.90, 'Entrega expressa'
);

INSERT INTO revenda.tb_vendas(
  cd_venda, cd_cliente, total_venda, obs_venda
 )VALUES (
  revenda.SEQ_VENDAS.NEXTVAL,
  (SELECT cd_cliente FROM revenda.tb_clientes WHERE nm_cliente='Carolina Martins'),
  370.50,
  'Pagamento em cartão'
);

INSERT INTO revenda.tb_vendas(
  cd_venda, cd_cliente, total_venda, obs_venda
 ) VALUES (
  revenda.SEQ_VENDAS.NEXTVAL,
  (SELECT cd_cliente FROM revenda.tb_clientes WHERE nm_cliente='Gustavo Lima'),
  899.90,
  'Compra online'
);

INSERT INTO revenda.tb_vendas(
  cd_venda, cd_cliente, total_venda, obs_venda
 ) VALUES (
  revenda.SEQ_VENDAS.NEXTVAL,
  (SELECT cd_cliente FROM revenda.tb_clientes WHERE nm_cliente='Aline Ferreira'),
  250.00,
  'Retirada na loja'
);

INSERT INTO revenda.tb_vendas(
  cd_venda, cd_cliente, total_venda, obs_venda
 ) VALUES (
  revenda.SEQ_VENDAS.NEXTVAL,
  (SELECT cd_cliente FROM revenda.tb_clientes WHERE nm_cliente='Marcelo Andrade'),
  120.50,
  'Pagamento em dinheiro'
);


/* ==========================================================================================
   ITENS DAS VENDAS
   ========================================================================================== */

-- Itens da venda: Carolina Martins
INSERT INTO revenda.tb_itens_vendas VALUES (
  revenda.SEQ_ITENS_VENDAS.NEXTVAL,
  (SELECT MAX(cd_venda) FROM revenda.tb_vendas),
  (SELECT MIN(cd_produto) FROM revenda.tb_produtos),
  1, 120.50
);

INSERT INTO revenda.tb_itens_vendas VALUES (
  revenda.SEQ_ITENS_VENDAS.NEXTVAL,
  (SELECT MAX(cd_venda) FROM revenda.tb_vendas),
  (SELECT MIN(cd_produto)+1 FROM revenda.tb_produtos),
  1, 250.00
);


-- Itens da venda: Gustavo Lima
INSERT INTO revenda.tb_itens_vendas VALUES (
  revenda.SEQ_ITENS_VENDAS.NEXTVAL,
  (SELECT MAX(cd_venda) FROM revenda.tb_vendas),
  (SELECT MIN(cd_produto)+2 FROM revenda.tb_produtos),
  1, 899.90
);

-- Itens da venda: Aline Ferreira
INSERT INTO revenda.tb_itens_vendas VALUES (
  revenda.SEQ_ITENS_VENDAS.NEXTVAL,
  (SELECT MAX(cd_venda) FROM revenda.tb_vendas),
  (SELECT MIN(cd_produto)+1 FROM revenda.tb_produtos),
  1, 250.00
);

-- Itens da venda: Marcelo Andrade
INSERT INTO revenda.tb_itens_vendas VALUES (
  revenda.SEQ_ITENS_VENDAS.NEXTVAL,
  (SELECT MAX(cd_venda) FROM revenda.tb_vendas),
  (SELECT MIN(cd_produto) FROM revenda.tb_produtos),
  1, 120.50
);



-- 15 produtos com colunas explicitadas (cd_produto, ds_produto, preco_produto, qtd_estoque_produto, cd_fornecedor)
INSERT INTO revenda.tb_produtos (cd_produto, ds_produto, preco_produto, qtd_estoque_produto, cd_fornecedor)
VALUES (revenda.SEQ_PRODUTOS.NEXTVAL, 'Notebook Lenovo IdeaPad 3', 2599.90, 12, (SELECT MIN(cd_fornecedor) FROM revenda.tb_fornecedores));

INSERT INTO revenda.tb_produtos (cd_produto, ds_produto, preco_produto, qtd_estoque_produto, cd_fornecedor)
VALUES (revenda.SEQ_PRODUTOS.NEXTVAL, 'Smartphone Samsung Galaxy A25', 1699.00, 18, (SELECT MIN(cd_fornecedor) FROM revenda.tb_fornecedores));

INSERT INTO revenda.tb_produtos (cd_produto, ds_produto, preco_produto, qtd_estoque_produto, cd_fornecedor)
VALUES (revenda.SEQ_PRODUTOS.NEXTVAL, 'Smartwatch Xiaomi Redmi Watch 4', 489.90, 25, (SELECT MIN(cd_fornecedor) FROM revenda.tb_fornecedores));

INSERT INTO revenda.tb_produtos (cd_produto, ds_produto, preco_produto, qtd_estoque_produto, cd_fornecedor)
VALUES (revenda.SEQ_PRODUTOS.NEXTVAL, 'Fone Bluetooth JBL Tune 520BT', 329.00, 30, (SELECT MIN(cd_fornecedor) FROM revenda.tb_fornecedores));

INSERT INTO revenda.tb_produtos (cd_produto, ds_produto, preco_produto, qtd_estoque_produto, cd_fornecedor)
VALUES (revenda.SEQ_PRODUTOS.NEXTVAL, 'Monitor LG 24'' Full HD', 899.50, 9, (SELECT MIN(cd_fornecedor) FROM revenda.tb_fornecedores));

INSERT INTO revenda.tb_produtos (cd_produto, ds_produto, preco_produto, qtd_estoque_produto, cd_fornecedor)
VALUES (revenda.SEQ_PRODUTOS.NEXTVAL, 'Teclado Mecânico Redragon Kumara', 259.90, 14, (SELECT MIN(cd_fornecedor) FROM revenda.tb_fornecedores));

INSERT INTO revenda.tb_produtos (cd_produto, ds_produto, preco_produto, qtd_estoque_produto, cd_fornecedor)
VALUES (revenda.SEQ_PRODUTOS.NEXTVAL, 'Mouse Gamer Logitech G203', 149.90, 22, (SELECT MIN(cd_fornecedor) FROM revenda.tb_fornecedores));

INSERT INTO revenda.tb_produtos (cd_produto, ds_produto, preco_produto, qtd_estoque_produto, cd_fornecedor)
VALUES (revenda.SEQ_PRODUTOS.NEXTVAL, 'HD Externo 1TB Seagate', 349.00, 10, (SELECT MIN(cd_fornecedor) FROM revenda.tb_fornecedores));

INSERT INTO revenda.tb_produtos (cd_produto, ds_produto, preco_produto, qtd_estoque_produto, cd_fornecedor)
VALUES (revenda.SEQ_PRODUTOS.NEXTVAL, 'SSD Kingston NV2 500GB', 289.00, 16, (SELECT MIN(cd_fornecedor) FROM revenda.tb_fornecedores));

INSERT INTO revenda.tb_produtos (cd_produto, ds_produto, preco_produto, qtd_estoque_produto, cd_fornecedor)
VALUES (revenda.SEQ_PRODUTOS.NEXTVAL, 'Cadeira Gamer ThunderX3 TGC12', 1129.00, 5, (SELECT MIN(cd_fornecedor) FROM revenda.tb_fornecedores));

INSERT INTO revenda.tb_produtos (cd_produto, ds_produto, preco_produto, qtd_estoque_produto, cd_fornecedor)
VALUES (revenda.SEQ_PRODUTOS.NEXTVAL, 'Caixa de Som JBL Flip 6', 689.00, 12, (SELECT MIN(cd_fornecedor) FROM revenda.tb_fornecedores));

INSERT INTO revenda.tb_produtos (cd_produto, ds_produto, preco_produto, qtd_estoque_produto, cd_fornecedor)
VALUES (revenda.SEQ_PRODUTOS.NEXTVAL, 'Impressora HP DeskJet Ink Advantage 2776', 429.90, 8, (SELECT MIN(cd_fornecedor) FROM revenda.tb_fornecedores));

INSERT INTO revenda.tb_produtos (cd_produto, ds_produto, preco_produto, qtd_estoque_produto, cd_fornecedor)
VALUES (revenda.SEQ_PRODUTOS.NEXTVAL, 'Placa de Vídeo GTX 1650 4GB', 999.00, 6, (SELECT MIN(cd_fornecedor) FROM revenda.tb_fornecedores));

INSERT INTO revenda.tb_produtos (cd_produto, ds_produto, preco_produto, qtd_estoque_produto, cd_fornecedor)
VALUES (revenda.SEQ_PRODUTOS.NEXTVAL, 'Microfone Fifine K669B', 219.90, 20, (SELECT MIN(cd_fornecedor) FROM revenda.tb_fornecedores));

INSERT INTO revenda.tb_produtos (cd_produto, ds_produto, preco_produto, qtd_estoque_produto, cd_fornecedor)
VALUES (revenda.SEQ_PRODUTOS.NEXTVAL, 'Roteador TP-Link Archer C6', 239.00, 17, (SELECT MIN(cd_fornecedor) FROM revenda.tb_fornecedores));


