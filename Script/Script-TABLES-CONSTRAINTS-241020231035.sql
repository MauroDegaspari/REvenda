--<ds_script>
-- DESCRICAO...: Scrip de execução de tabelas e CONSTRAINT
--               Referente ao sistema REVENDA.
-- RESPONSAVEL.: Mauro Degaspari
-- DATA........: 24/10/2023
-- APLICACAO...: REVENDA
--</DS_SCRIPT>
--<USUARIO=REVENDA>                         drop table tb_clientes               drop table tb_fornecedores  drop table tb_funcionarios    drop constraint cnt_cd_cliente_pk

  CREATE TABLE revenda.tb_clientes (
    cd_cliente          NUMBER        NOT NULL,
    nm_cliente          VARCHAR2(100)  ,
    rg_cliente          VARCHAR2(20)   ,
    cpf_cliente         VARCHAR2(20)   ,
    email_cliente       VARCHAR2(200)  ,
    telefone_cliente    VARCHAR2(30)   ,
    celular_cliente     VARCHAR2(30)   ,
    cep_cliente         VARCHAR2(100)  ,
    rua_cliente         VARCHAR2(255)  ,
    numero_cliente      NUMBER         ,
    complemento_cliente VARCHAR2(200)  ,
    bairro_cliente      VARCHAR2(100)  ,
    cidade_cliente      varchar2(100)  ,
    estado_cliente      varchar2(2)
  )
  /
  ALTER TABLE revenda.tb_clientes
  ADD CONSTRAINT cnt_cd_cliente_pk PRIMARY KEY(
  cd_cliente )

  /
  COMMENT ON TABLE revenda.tb_clientes IS ' Tabela onde serão cadastrado todos os usuario com ou sem privilegios '
  /
  COMMENT ON COLUMN revenda.tb_clientes.cd_cliente IS 'cd = Código,  sequence de usuarios'
  /
  COMMENT ON COLUMN revenda.tb_clientes.nm_cliente IS ' nm = Nome, nome do cliente cadastrado'
  /


                               ------- FORNECEDORES ------------

  CREATE TABLE revenda.tb_fornecedores (
    cd_fornecedor          NUMBER          NOT   NULL,
    nm_fornecedor          VARCHAR2(100),
    cnpj_fornecedor        VARCHAR2(100),
    email_fornecedor       VARCHAR2(200),
    telefone_fornecedor    VARCHAR2(30),
    celular_fornecedor     VARCHAR2(30),
    cep_fornecedor         VARCHAR2(100),
    endereco_fornecedor    VARCHAR2(255),
    numero_fornecedor      NUMBER       ,
    complemento_fornecedor VARCHAR2(200),
    bairro_fornecedor      VARCHAR2(100),
    cidade_fornecedor      VARCHAR2(100),
    estado_fornecedor      VARCHAR2(2)
  )
  /
  ALTER TABLE revenda.tb_fornecedores
  ADD CONSTRAINT cnt_cd_fornecedor_pk PRIMARY KEY(
  cd_fornecedor)

  /


                           ------- FUNCIONARIOS ------------

  CREATE TABLE revenda.tb_funcionarios (
    cd_funcionario          NUMBER                    NOT NULL,
    nm_funcionario          VARCHAR2(100),
    rg_funcionario          VARCHAR2(30),
    cpf_funcionario         VARCHAR2(20),
    email_funcionario       VARCHAR2(200),
    sh_funcionario          VARCHAR2(10),
    cargo_funcionario       VARCHAR2(100),
    nvl_funcionario         VARCHAR2(1)  DEFAULT 'N'  NOT NULL ,
    telefone_funcionario    VARCHAR2(30),
    celular_funcionario     VARCHAR2(30),
    cep_funcionario         VARCHAR2(100),
    endereco_funcionario    VARCHAR2(255),
    numero_funcionario      NUMBER,
    complemento_funcionario VARCHAR2(200),
    bairro_funcionario      VARCHAR2(100),
    cidade_funcionario      VARCHAR2(100),
    estado_funcionario      VARCHAR2(2)
  )
  /
  ALTER TABLE revenda.tb_funcionarios
  ADD CONSTRAINT cnt_cd_funcionario_pk PRIMARY KEY(
  cd_funcionario)

  /

  ALTER TABLE revenda.tb_funcionarios
  ADD CONSTRAINT cnt_sn_nvl_acesso_ck CHECK (
  nvl_funcionario IN ('S','N')
  )
  /
                               ------- PRODUTOS ------------

  CREATE TABLE revenda.tb_produtos (
    cd_produto          NUMBER       NOT NULL,
    ds_produto          VARCHAR2(100)        ,
    preco_produto       NUMBER(10,2)         ,
    qtd_estoque_produto NUMBER               ,
    cd_fornecedor       NUMBER       NOT NULL
  )
  /

  ALTER TABLE revenda.tb_produtos
  ADD CONSTRAINT cnt_cd_produto_pk PRIMARY KEY(
  cd_produto)

  /

  ALTER TABLE revenda.tb_produtos
  ADD CONSTRAINT cnt_cd_produto_fk FOREIGN KEY(
  cd_fornecedor) REFERENCES revenda.tb_fornecedores(
  cd_fornecedor)

  /
                                            ------- VENDAS ------------

  CREATE TABLE revenda.tb_vendas (
    cd_venda          NUMBER         NOT NULL,
    cd_cliente        NUMBER         NOT NULL,
    dt_venda          DATE   DEFAULT SYSDATE,
    total_venda       NUMBER(10,2) ,
    obs_venda         VARCHAR2(255)
  )
  /

    ALTER TABLE revenda.tb_vendas
    ADD CONSTRAINT cnt_cd_venda_pk PRIMARY KEY(
    cd_venda)
  /
    ALTER TABLE revenda.tb_vendas
    ADD CONSTRAINT cnt_cd_cliente_fk FOREIGN KEY(
    cd_cliente) REFERENCES revenda.tb_clientes(
    cd_cliente)
  /

                                          ------- ITENS_VENDAS ------------

  CREATE TABLE revenda.tb_itens_vendas (
    cd_itens_vendas    NUMBER  NOT NULL,
    cd_venda           NUMBER  NOT NULL,
    cd_produto         NUMBER  NOT NULL,
    qtd_itens_vendas   NUMBER  NOT NULL,
    subtotal           NUMBER(10,2)
  )
  /

  ALTER TABLE revenda.tb_itens_vendas
  ADD CONSTRAINT cnt_tb_itens_vendas_fk PRIMARY KEY(
  cd_itens_vendas)
  /
  ALTER TABLE revenda.tb_itens_vendas
  ADD CONSTRAINT cnt_cd_venda_fk FOREIGN KEY(
  cd_venda) REFERENCES revenda.tb_vendas(
  cd_venda)
  /
  ALTER TABLE revenda.tb_itens_vendas
  ADD CONSTRAINT cnt_cd_produto2_fk FOREIGN KEY(
  cd_produto) REFERENCES revenda.tb_produtos(
  cd_produto)


