CREATE SEQUENCE seq_pk_clientes START 1;

CREATE TABLE Clientes (
	id int PRIMARY KEY DEFAULT nextval('seq_pk_clientes'),
	nome varchar(100),
	sobre_nome varchar(100)
);

CREATE SEQUENCE seq_pk_produto START 1;
CREATE TABLE Produtos (
	id int PRIMARY KEY DEFAULT nextval('seq_pk_produto'),
	nome varchar(100),
	detalhes varchar(400),
	marca varchar(100),
	valor float
);

CREATE SEQUENCE seq_pk_pedidos START 1;
CREATE TABLE Pedidos (
	id int PRIMARY KEY DEFAULT nextval('seq_pk_pedidos'),
	id_cliente integer,
	data date,
	faturado SMALLINT,
	entregue SMALLINT,
	FOREIGN KEY (id_cliente) REFERENCES Clientes(id)
);



CREATE TABLE Produtos_Pedidos (
	id_pedido integer,
	id_produto integer,
	qt integer,
	valor float,
	FOREIGN KEY (id_produto) REFERENCES Produtos(id),
	FOREIGN KEY (id_pedido) REFERENCES Pedidos(id),
	PRIMARY key(id_pedido , id_produto )
);

ALTER TABLE clientes ADD COLUMN data_nasc date;
