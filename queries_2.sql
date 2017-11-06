create user soboru identified by opet;
grant connect, resource to soboru;
connect soboru/opet

----------------------------------

CREATE TABLE roles (
	id NUMBER(11) NOT NULL,
	nome VARCHAR2(80) NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_at DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT role_pk PRIMARY KEY (id)
);

CREATE SEQUENCE role_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE usuarios (
	id NUMBER(11) NOT NULL,
	nome VARCHAR2(80) NOT NULL,
	email VARCHAR2(80) NOT NULL,
	senha VARCHAR2(80) NOT NULL,
	tipo NUMBER(1) NOT NULL,
	nasc DATE NOT NULL,
	sexo NUMBER(1) NOT NULL,
	id_role NUMBER(11) NOT NULL,
	notificacao_email NUMBER(1) NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_at DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT usuario_pk PRIMARY KEY (id)
);

CREATE SEQUENCE usuario_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE medidas (
	id NUMBER(11) NOT NULL,
	nome VARCHAR2(80) NOT NULL,
	abreviacao VARCHAR2(80) NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_at DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT medida_pk PRIMARY KEY (id)
);

CREATE SEQUENCE medida_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;	

CREATE TABLE ingredientes (
	id NUMBER(11) NOT NULL,
	nome VARCHAR2(80) NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_at DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT ingrediente_pk PRIMARY KEY (id)
);

CREATE SEQUENCE ingrediente_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE categorias (
	id NUMBER(11) NOT NULL,
	nome VARCHAR2(80) NOT NULL,
	id_super_categoria NUMBER(11) NULL,
	selecionavel NUMBER(1) NOT NULL,
	slug VARCHAR2(80) NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_at DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT categoria_pk PRIMARY KEY (id)
);

CREATE SEQUENCE categoria_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE utensilios (
	id NUMBER(11) NOT NULL,
	nome VARCHAR2(80) NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_at DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT utensilio_pk PRIMARY KEY (id)
);

CREATE SEQUENCE utensilio_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE receitas (
	id NUMBER(11) NOT NULL,
	nome VARCHAR2(80) NOT NULL,
	id_categoria NUMBER(11) NOT NULL,
	id_usuario NUMBER(11) NOT NULL,
	porcao NUMBER(11) NOT NULL,
	tempo_preparo DECIMAL(5,2) NOT NULL,
	modo_preparo TEXT NOT NULL,
	img_path VARCHAR2(80) NOT NULL,
	pontuacao_media DECIMAL(5,2) NOT NULL,
	views NUMBER(11) NOT NULL,
	favs NUMBER(11) NOT NULL,
	slug VARCHAR2(80) NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_at DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT receitas_pk PRIMARY KEY (id),
	CONSTRAINT receitas_cat_fk FOREIGN KEY (id_categoria) REFERENCES categorias(id),
	CONSTRAINT receitas_usr_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE SEQUENCE receita_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE receitas_ingredientes (
	id_receita NUMBER(11) NOT NULL,
	id_ingrediente NUMBER(11) NOT NULL,
	id_medida NUMBER(11) NOT NULL,
	sub_sessao VARCHAR2(80) NULL,
	qty DECIMAL(5,2) NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_ate DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT rec_ing_pk PRIMARY KEY(id_receita, id_ingrediente, id_medida),
	CONSTRAINT rec_ing_rec_fk FOREIGN KEY (id_receita) REFERENCES receitas(id),
	CONSTRAINT rec_ing_ing_fk FOREIGN KEY (id_ingrediente) REFERENCES ingredientes(id),
	CONSTRAINT rec_ing_med_fk FOREIGN KEY (id_medida) REFERENCES medidas(id)
);

CREATE SEQUENCE receita_ingrediente_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE receitas_utensilios (
	id_receita NUMBER(11) NOT NULL,
	id_utensilio NUMBER(11) NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_at DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT rec_utens_pk PRIMARY KEY (id_receita, id_utensilio),
	CONSTRAINT rec_utens_rec_fk FOREIGN KEY (id_receita) REFERENCES receitas(id),
	CONSTRAINT rec_utens_uten_fk FOREIGN KEY (id_utensilio) REFERENCES utensilios(id)
);

CREATE SEQUENCE receita_utensilio_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE reports (
	id_usuario NUMBER(11) NOT NULL,
	id_receita NUMBER(11) NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_at DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT reports_pk PRIMARY KEY (id_usuario, id_receita),
	CONSTRAINT reports_usr_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
	CONSTRAINT reports_rec_fk FOREIGN KEY (id_receita) REFERENCES receitas(id)
);

CREATE SEQUENCE report_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE ingredientes_fav (
	id_ingrediente NUMBER(11) NOT NULL,
	id_usuario NUMBER(11) NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_at DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT ing_fav_pk PRIMARY KEY (id_ingrediente, id_usuario),
	CONSTRAINT ing_fav_ing_fk FOREIGN KEY (id_ingrediente) REFERENCES ingredientes(id),
	CONSTRAINT ing_fav_usr_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE SEQUENCE ingredientes_fav_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE ingredientes_exc (
	id_ingrediente NUMBER(11) NOT NULL,
	id_usuario NUMBER(11) NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_at DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT ing_exc_pk PRIMARY KEY (id_ingrediente, id_usuario),
	CONSTRAINT ing_exc_ing_fk FOREIGN KEY (id_ingrediente) REFERENCES ingredientes(id),
	CONSTRAINT ing_exc_usr_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE SEQUENCE ingredientes_exc_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE receitas_fav (
	id_receita NUMBER(11) NOT NULL,
	id_usuario NUMBER(11) NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_at DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT receita_fav_pk PRIMARY KEY (id_receita, id_usuario),
	CONSTRAINT rec_fav_usr_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
	CONSTRAINT rec_fav_rec_fk FOREIGN KEY (id_receita) REFERENCES receitas(id)
);

CREATE SEQUENCE receita_fav_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE receitas_exc (
	id_receita NUMBER(11) NOT NULL,
	id_usuario NUMBER(11) NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_at DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT receita_exc_pk PRIMARY KEY (id_receita, id_usuario),
	CONSTRAINT rec_exc_usr_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
	CONSTRAINT rec_exc_rec_fk FOREIGN KEY (id_receita) REFERENCES receitas(id)
);

CREATE SEQUENCE receita_exc_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE comentarios (
	id NUMBER(11) NOT NULL,
	id_receita NUMBER(11) NOT NULL,
	id_usuario NUMBER(11) NOT NULL,
	body TEXT NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_at DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT comentarios_pk PRIMARY KEY (id),
	CONSTRAINT comentarios_usr_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
	CONSTRAINT comentarios_rec_fk FOREIGN KEY (id_receita) REFERENCES receitas(id)
);

CREATE SEQUENCE comentario_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE pontuacoes (
	id_receita NUMBER(11) NOT NULL,
	id_usuario NUMBER(11) NOT NULL,
	qty NUMBER(11) NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_at DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT pont_rec_pk PRIMARY KEY (id_receita, id_usuario),
	CONSTRAINT pont_rec_rec_fk FOREIGN KEY (id_receita) REFERENCES receitas(id),
	CONSTRAINT pont_rec_usr_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE SEQUENCE pontuacao_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE tags (
	id NUMBER(11) NOT NULL,
	nome VARCHAR2(80) NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_at DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT tag_pk PRIMARY KEY (id)
);

CREATE SEQUENCE tag_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE receitas_tags (
	id_receita NUMBER(11) NOT NULL,
	id_tag NUMBER(11) NOT NULL,
	-- created_at DATE NOT NULL,
	-- updated_at DATE NOT NULL,
	-- deleted_at DATE NULL,
	CONSTRAINT rec_tag_pk PRIMARY KEY (id_receita, id_tag),
	CONSTRAINT rec_tags_rec_fk FOREIGN KEY (id_receita) REFERENCES receitas(id),
	CONSTRAINT rec_tags_tag_fk FOREIGN KEY (id_utensilio) REFERENCES tags(id)
);

CREATE SEQUENCE receita_tag_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

----------------------------------

insert into ingredientes values (ingrediente_seq.NEXTVAL,'nome1');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'nome2');
insert into medidas values (medida_seq.NEXTVAL,'nome1','abreviacao1');