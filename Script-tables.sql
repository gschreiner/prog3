CREATE SEQUENCE seq_pk_clientes START 1;

CREATE TABLE Clientes (
	id int PRIMARY KEY DEFAULT nextval('seq_pk_clientes'),
	nome varchar(100),
	sobre_nome varchar(100)
);