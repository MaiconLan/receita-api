CREATE TABLE public.usuario
(
    id_usuario SERIAL  NOT NULL,
    nome       VARCHAR NOT NULL,
    email      VARCHAR NOT NULL,
    login      VARCHAR NOT NULL,
    senha      VARCHAR NOT NULL,
    CONSTRAINT id_usuario_pk PRIMARY KEY (id_usuario)

);

CREATE TABLE public.receita
(
    id_receita SERIAL  NOT NULL,
    nome       VARCHAR NOT NULL,
    descricao  VARCHAR,
    publica    BOOLEAN DEFAULT FALSE,
    CONSTRAINT id_receita_pk PRIMARY KEY (id_receita)

);


CREATE TABLE public.lista_compra
(
    id_lista_compra SERIAL NOT NULL,
    descricao       VARCHAR,
    CONSTRAINT id_lista_compra_pk PRIMARY KEY (id_lista_compra)

);

CREATE TABLE public.produto
(
    id_produto SERIAL  NOT NULL,
    descricao  VARCHAR,
    CONSTRAINT id_produto_pk PRIMARY KEY (id_produto)
);

CREATE TABLE public.produto_lista_compra
(
    id_lista_compra INTEGER NOT NULL,
    id_produto      INTEGER NOT NULL,
    CONSTRAINT produto_lista_compra_pk PRIMARY KEY (id_produto, id_lista_compra),
    CONSTRAINT produto_fk FOREIGN KEY (id_produto)
        REFERENCES public.produto (id_produto) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT lista_compra_fk FOREIGN KEY (id_lista_compra)
        REFERENCES public.lista_compra (id_lista_compra) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION

);

INSERT INTO public.usuario (nome, email, login, senha) VALUES ('Maicon Lanzendorf', 'maiconteste@teste.com', 'admin', '$2a$10$5PAR/F4nejwxTlwFPWh4sOscqEB2dBCSCAKGaC3e652jLMsXl.yb.');