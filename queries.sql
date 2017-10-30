CREATE TABLE usuarios (
	id_usuario NUMBER(11) NOT NULL,
	nome_usuario VARCHAR2(80) NOT NULL,
	email VARCHAR2(80) NOT NULL,
	senha VARCHAR2(80) NOT NULL,
	tipo_usuario NUMBER(1) NOT NULL,
	nasc DATE NOT NULL,
	sexo NUMBER(1) NOT NULL,
	notificacao_email NUMBER(1) NOT NULL,
	created_at DATE NOT NULL,
	updated_at DATE NOT NULL,
	deleted_at DATE NULL,
	CONSTRAINT usuario_pk PRIMARY KEY (id_usuario)
);

CREATE SEQUENCE seq_usuarios
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE ingredientes_medidas (
	id_ingredientes_medida NUMBER(11) NOT NULL,
	nome VARCHAR2(80) NOT NULL,
	created_at DATE NOT NULL,
	updated_at DATE NOT NULL,
	deleted_at DATE NULL,
	CONSTRAINT ing_medidas_pk PRIMARY KEY (id_ingredientes_medida)
);

CREATE SEQUENCE seq_ingredientes_medidas
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE ingredientes (
	id_ingrediente NUMBER(11) NOT NULL,
	nome_ingrediente VARCHAR2(80) NOT NULL,
	created_at DATE NOT NULL,
	updated_at DATE NOT NULL,
	deleted_at DATE NULL,
	CONSTRAINT ingrediente_pk PRIMARY KEY (id_ingrediente)
);

CREATE SEQUENCE seq_ingredientes
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE categoria_receitas (
	id_categoria_receita NUMBER(11) NOT NULL,
	nome_categoria VARCHAR2(80) NOT NULL,
	id_super_categoria NUMBER(11) NULL,
	selecionavel NUMBER(1) NOT NULL,
	slug VARCHAR2(80) NOT NULL,
	created_at DATE NOT NULL,
	updated_at DATE NOT NULL,
	deleted_at DATE NULL,
	CONSTRAINT cat_receitas_pk PRIMARY KEY (id_categoria_receita)
);

CREATE SEQUENCE seq_receitas
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE utensilios (
	id_utensilio NUMBER(11) NOT NULL,
	nome_utensilios VARCHAR2(80) NOT NULL,
	created_at DATE NOT NULL,
	updated_at DATE NOT NULL,
	deleted_at DATE NULL,
	CONSTRAINT utensilios_pk PRIMARY KEY (id_utensilio)
);

CREATE SEQUENCE seq_utensilios
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE ingredientes_fav_exc (
	id_ing_fav_exc NUMBER(11) NOT NULL,
	id_ingrediente NUMBER(11) NOT NULL,
	id_usuario NUMBER(11) NOT NULL,
	is_fav NUMBER(1) NOT NULL,
	created_at DATE NOT NULL,
	updated_at DATE NOT NULL,
	deleted_at DATE NULL,
	CONSTRAINT ing_fav_exc_pk PRIMARY KEY (id_ing_fav_exc),
	CONSTRAINT ing_fav_exc_ing_fk FOREIGN KEY (id_ingrediente) REFERENCES ingredientes(id_ingrediente),
	CONSTRAINT ing_fav_exc_usr_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

CREATE SEQUENCE seq_ingredientes_fav_exc
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE receitas (
	id_receita NUMBER(11) NOT NULL,
	nome_receita VARCHAR2(80) NOT NULL,
	id_categoria NUMBER(11) NOT NULL,
	porcao NUMBER(11) NOT NULL,
	tempo_preparo DECIMAL(5,2) NOT NULL,
	modo_preparo TEXT NOT NULL,
	img_path VARCHAR2(80) NOT NULL,
	id_usuario NUMBER(11) NULL,
	pontuacao_media DECIMAL(5,2) NOT NULL,
	views NUMBER(11) NOT NULL,
	favs NUMBER(11) NOT NULL,
	slug VARCHAR2(80) NOT NULL,
	created_at DATE NOT NULL,
	updated_at DATE NOT NULL,
	deleted_at DATE NULL,
	CONSTRAINT receitas_pk PRIMARY KEY (id_receita),
	CONSTRAINT receitas_cat_fk FOREIGN KEY (id_categoria) REFERENCES categoria_receitas(id_categoria),
	CONSTRAINT receitas_usr_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

CREATE SEQUENCE seq_receitas
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE receitas_ingredientes (
	id_receitas_ingrediente NUMBER(11) NOT NULL,
	id_receita NUMBER(11) NOT NULL,
	id_ingrediente NUMBER(11) NOT NULL,
	id_medida NUMBER(11) NOT NULL,
	sub_sessao VARCHAR2(80) NULL,
	qty DECIMAL(5,2) NOT NULL,
	created_at DATE NOT NULL,
	updated_ate DATE NOT NULL,
	deleted_at DATE NULL,
	CONSTRAINT rec_ing_pk PRIMARY KEY(id_receitas_ingrediente),
	CONSTRAINT rec_ing_rec_fk FOREIGN KEY (id_receita) REFERENCES receitas(id_receita),
	CONSTRAINT rec_ing_ing_fk FOREIGN KEY (id_ingrediente) REFERENCES ingredientes(id_ingrediente),
	CONSTRAINT rec_ing_med_fk FOREIGN KEY (id_medida) REFERENCES ingredientes_medidas(id_ingredientes_medida)
);

CREATE SEQUENCE seq_receitas_ingredientes
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE receitas_utensilios (
	id_receitas_utensilios NUMBER(11) NOT NULL,
	id_receita NUMBER(11) NOT NULL,
	id_utensilio NUMBER(11) NOT NULL,
	CONSTRAINT rec_utens_pk PRIMARY KEY (id_receitas_utensilios),
	CONSTRAINT rec_utens_rec_fk FOREIGN KEY (id_receita) REFERENCES receitas(id_receita),
	CONSTRAINT rec_utens_uten_fk FOREIGN KEY (id_utensilio) REFERENCES utensilios(id_utensilio)
);

CREATE SEQUENCE seq_receitas_utensilios
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE reports (
	id_report NUMBER(11) NOT NULL,
	id_usuario NUMBER(11) NOT NULL,
	id_receita NUMBER(11) NOT NULL,
	created_at DATE NOT NULL,
	updated_at DATE NOT NULL,
	deleted_at DATE NULL,
	CONSTRAINT reports_pk PRIMARY KEY (id_report),
	CONSTRAINT reports_usr_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
	CONSTRAINT reports_rec_fk FOREIGN KEY (id_receita) REFERENCES receitas(id_receita)
);

CREATE SEQUENCE seq_reports
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE receitas_fav_exc (
	id_fav_exc NUMBER(11) NOT NULL,
	id_receita NUMBER(11) NOT NULL,
	id_usuario NUMBER(11) NOT NULL,
	is_fav NUMBER(1) NOT NULL,
	created_at DATE NOT NULL,
	updated_at DATE NOT NULL,
	deleted_at DATE NULL,
	CONSTRAINT rec_fav_exc_pk PRIMARY KEY (id_fav_exc),
	CONSTRAINT rec_fav_exc_usr_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
	CONSTRAINT rec_fav_exc_rec_fk FOREIGN KEY (id_receita) REFERENCES receitas(id_receita)
);

CREATE SEQUENCE seq_receitas_fav_exc
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE comentarios (
	id_comentario NUMBER(11) NOT NULL,
	id_receita NUMBER(11) NOT NULL,
	id_usuario NUMBER(11) NOT NULL,
	body TEXT NOT NULL,
	created_at DATE NOT NULL,
	updated_at DATE NOT NULL,
	deleted_at DATE NULL,
	CONSTRAINT comentarios_pk PRIMARY KEY (id_comentario),
	CONSTRAINT comentarios_usr_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
	CONSTRAINT comentarios_rec_fk FOREIGN KEY (id_receita) REFERENCES receitas(id_receita)
);

CREATE SEQUENCE seq_comentarios
	INCREMENT BY 1
	START WITH 1
	NOCACHE;

CREATE TABLE pontuacao_receitas (
	id_pontuacao_receita NUMBER(11) NOT NULL,
	id_receita NUMBER(11) NOT NULL,
	id_usuario NUMBER(11) NOT NULL,
	qty NUMBER(11) NOT NULL,
	created_at DATE NOT NULL,
	updated_at DATE NOT NULL,
	deleted_at DATE NULL,
	CONSTRAINT pont_rec_pk PRIMARY KEY (id_pontuacao_receita),
	CONSTRAINT pont_rec_rec_fk FOREIGN KEY (id_receita) REFERENCES receitas(id_receita),
	CONSTRAINT pont_rec_usr_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

CREATE SEQUENCE seq_pont_receitas
	INCREMENT BY 1
	START WITH 1
	NOCACHE;
	
----------------------

create user soboru identified by opet;
grant connect, resource to soboru;

CREATE TABLE ingredientes (
	id NUMBER(11) NOT NULL,
	nome VARCHAR2(80) NOT NULL,
	CONSTRAINT ingrediente_pk PRIMARY KEY (id)
);

CREATE SEQUENCE ingrediente_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;
	
CREATE TABLE medidas (
	id NUMBER(11) NOT NULL,
	nome VARCHAR2(80) NOT NULL,
	abreviacao VARCHAR2(80) NOT NULL,
	CONSTRAINT medida_pk PRIMARY KEY (id)
);

CREATE SEQUENCE medida_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;	
	
CREATE TABLE utensilios (
	id NUMBER(11) NOT NULL,
	nome VARCHAR2(80) NOT NULL,
	CONSTRAINT utensilio_pk PRIMARY KEY (id)
);

CREATE SEQUENCE utensilio_seq
	INCREMENT BY 1
	START WITH 1
	NOCACHE;		
	
insert into ingredientes values (1,'nome1');
insert into medidas values (2,'nome2','abreviacao');
