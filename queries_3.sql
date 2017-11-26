create user soboru identified by opet;
grant connect, resource to soboru;
connect soboru/opet

----------------------------------

CREATE TABLE roles (
    id NUMBER(11) NOT NULL,
    nome VARCHAR2(80) NOT NULL,
    is_admin NUMBER(1) NOT NULL,
    -- created_at DATE NOT NULL,
    -- updated_at DATE NOT NULL,
    -- deleted_at DATE NULL,
    CONSTRAINT role_pk PRIMARY KEY (id),
    CONSTRAINT role_nome_unique UNIQUE (nome)
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
    -- tipo NUMBER(1) NOT NULL,
    nasc DATE NOT NULL,
    sexo NUMBER(1) NOT NULL,
    id_role NUMBER(11) NOT NULL,
    notificacao_email NUMBER(1) NOT NULL,
    avatar_path VARCHAR2(80) NULL,
    -- created_at DATE NOT NULL,
    -- updated_at DATE NOT NULL,
    -- deleted_at DATE NULL,
    CONSTRAINT usuario_pk PRIMARY KEY (id),
    CONSTRAINT usuario_email_unique UNIQUE (email)
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
    CONSTRAINT medida_pk PRIMARY KEY (id),
    CONSTRAINT medida_nome_unique UNIQUE (nome)
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
    CONSTRAINT ingrediente_pk PRIMARY KEY (id),
    CONSTRAINT ingrediente_nome_unique UNIQUE (nome)
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
    CONSTRAINT categoria_pk PRIMARY KEY (id),
    CONSTRAINT categoria_nome_unique UNIQUE (nome)
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
    CONSTRAINT utensilio_pk PRIMARY KEY (id),
    CONSTRAINT utensilio_nome_unique UNIQUE (nome)
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
    modo_preparo CLOB NOT NULL,
    img_path VARCHAR2(80) NOT NULL,
    pontuacao_media DECIMAL(5,2) NOT NULL,
    views NUMBER(11) NOT NULL,
    favs NUMBER(11) NOT NULL,
    slug VARCHAR2(80) NOT NULL,
    aprovado NUMBER(1) NOT NULL,
    -- created_at DATE NOT NULL,
    -- updated_at DATE NOT NULL,
    -- deleted_at DATE NULL,
    CONSTRAINT receita_pk PRIMARY KEY (id),
    -- CONSTRAINT receita_nome_unique UNIQUE (nome),
    CONSTRAINT receita_cat_fk FOREIGN KEY (id_categoria) REFERENCES categorias(id),
    CONSTRAINT receita_usr_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE SEQUENCE receita_seq
    INCREMENT BY 1
    START WITH 1
    NOCACHE;

CREATE TABLE receitas_ingredientes (
    id NUMBER(11) NOT NULL,
    id_receita NUMBER(11) NOT NULL,
    id_ingrediente NUMBER(11) NOT NULL,
    id_medida NUMBER(11) NOT NULL,
    sub_sessao VARCHAR2(80) NULL,
    qty DECIMAL(5,2) NOT NULL,
    -- created_at DATE NOT NULL,
    -- updated_ate DATE NOT NULL,
    -- deleted_at DATE NULL,
    -- CONSTRAINT rec_ing_pk PRIMARY KEY(id_receita, id_ingrediente, id_medida),
    CONSTRAINT rec_ing_pk PRIMARY KEY(id),
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

--CREATE SEQUENCE receita_utensilio_seq
--  INCREMENT BY 1
--  START WITH 1
--  NOCACHE;

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

--CREATE SEQUENCE report_seq
--  INCREMENT BY 1
--  START WITH 1
--  NOCACHE;

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

--CREATE SEQUENCE ingredientes_fav_seq
--  INCREMENT BY 1
--  START WITH 1
--  NOCACHE;

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

--CREATE SEQUENCE ingredientes_exc_seq
--  INCREMENT BY 1
--  START WITH 1
--  NOCACHE;

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

--CREATE SEQUENCE receita_fav_seq
--  INCREMENT BY 1
--  START WITH 1
--  NOCACHE;

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

--CREATE SEQUENCE receita_exc_seq
--  INCREMENT BY 1
--  START WITH 1
--  NOCACHE;

CREATE TABLE comentarios (
    id NUMBER(11) NOT NULL,
    id_receita NUMBER(11) NOT NULL,
    id_usuario NUMBER(11) NOT NULL,
    body CLOB NOT NULL,
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
    qty NUMBER(1) NOT NULL,
    -- created_at DATE NOT NULL,
    -- updated_at DATE NOT NULL,
    -- deleted_at DATE NULL,
    CONSTRAINT pont_rec_pk PRIMARY KEY (id_receita, id_usuario),
    CONSTRAINT pont_rec_rec_fk FOREIGN KEY (id_receita) REFERENCES receitas(id),
    CONSTRAINT pont_rec_usr_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

--CREATE SEQUENCE pontuacao_seq
--  INCREMENT BY 1
--  START WITH 1
--  NOCACHE;

-- CREATE TABLE tags (
--     id NUMBER(11) NOT NULL,
--     nome VARCHAR2(80) NOT NULL,
--     -- created_at DATE NOT NULL,
--     -- updated_at DATE NOT NULL,
--     -- deleted_at DATE NULL,
--     CONSTRAINT tag_pk PRIMARY KEY (id),
--     CONSTRAINT tag_nome_unique UNIQUE (nome)
-- );

-- CREATE SEQUENCE tag_seq
--     INCREMENT BY 1
--     START WITH 1
--     NOCACHE;

-- CREATE TABLE receitas_tags (
--     id_receita NUMBER(11) NOT NULL,
--     id_tag NUMBER(11) NOT NULL,
--     -- created_at DATE NOT NULL,
--     -- updated_at DATE NOT NULL,
--     -- deleted_at DATE NULL,
--     CONSTRAINT rec_tag_pk PRIMARY KEY (id_receita, id_tag),
--     CONSTRAINT rec_tags_rec_fk FOREIGN KEY (id_receita) REFERENCES receitas(id),
--     CONSTRAINT rec_tags_tag_fk FOREIGN KEY (id_tag) REFERENCES tags(id)
-- );

--CREATE SEQUENCE receita_tag_seq
--  INCREMENT BY 1
--  START WITH 1
--  NOCACHE;

----------------------------------

insert into roles values(role_seq.NEXTVAL, 'Admin', 1);
insert into roles values(role_seq.NEXTVAL, 'Usuario', 0);

insert into usuarios values(usuario_seq.NEXTVAL, 'Admin Teste', 'admin@teste.com', '123456', TO_DATE('28-02-1990', 'DD_MM_YYYY'), 3, 1, 1, null);
insert into usuarios values(usuario_seq.NEXTVAL, 'Usuario Teste', 'teste@teste.com', '123456', TO_DATE('07-11-1988', 'DD_MM_YYYY'), 3, 2, 1, null);

insert into ingredientes values (ingrediente_seq.NEXTVAL,'ingrediente1');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'ingrediente2');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'ingrediente3');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'ingrediente4');

insert into medidas values (medida_seq.NEXTVAL,'medida1','abreviacao1');
insert into medidas values (medida_seq.NEXTVAL,'medida2','abreviacao2');
insert into medidas values (medida_seq.NEXTVAL,'medida3','abreviacao3');

insert into utensilios values (utensilio_seq.NEXTVAL, 'utensilio1');
insert into utensilios values (utensilio_seq.NEXTVAL, 'utensilio2');
insert into utensilios values (utensilio_seq.NEXTVAL, 'utensilio3');

insert into categorias values(categoria_seq.NEXTVAL, 'categoria1', null, 0, 'categoria1');
insert into categorias values(categoria_seq.NEXTVAL, 'categoria2', 1, 1, 'categoria2');
insert into categorias values(categoria_seq.NEXTVAL, 'categoria3', 1, 1, 'categoria3');
insert into categorias values(categoria_seq.NEXTVAL, 'categoria4', null, 0, 'categoria4');

-- insert into tags values(tag_seq.NEXTVAL, 'tag1');
-- insert into tags values(tag_seq.NEXTVAL, 'tag2');
-- insert into tags values(tag_seq.NEXTVAL, 'tag3');

insert into receitas values(receita_seq.NEXTVAL, 'receita1', 2, 1, 2, 2, 'Modo de Preparo da Receita 1', 'teste.jpg', 0, 0, 0, 'receita1', 1);
insert into receitas values(receita_seq.NEXTVAL, 'receita2', 3, 1, 4, 1.5, 'Modo de Preparo da Receita 2', 'teste.jpg', 0, 0, 0, 'receita2', 1);
insert into receitas values(receita_seq.NEXTVAL, 'receita3', 3, 2, 5, 6.4, 'Modo de Preparo da Receita 3', 'teste.jpg', 0, 0, 0, 'receita3', 0);

insert into receitas_ingredientes values(receita_seq.NEXTVAL, 1, 1, 2, null, 50);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 1, 2, 1, null, 200);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 1, 2, 1, 'Cobertura', 150);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 1, 3, 3, 'Cobertura', 10);

insert into receitas_ingredientes values(receita_seq.NEXTVAL, 2, 1, 1, null, 10);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 2, 2, 2, null, 300);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 2, 3, 2, null, 800);
    
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 3, 1, 1, null, 10);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 3, 3, 1, null, 15);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 3, 4, 2, null, 100);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 3, 4, 3, 'Recheio', 4);

insert into receitas_utensilios values(1, 1);
insert into receitas_utensilios values(1, 3);
insert into receitas_utensilios values(2, 1);
insert into receitas_utensilios values(3, 2);
insert into receitas_utensilios values(3, 1);

insert into reports values(1, 2);

insert into ingredientes_fav values(1, 2);

insert into ingredientes_exc values(2, 2);

insert into receitas_fav values(1, 1);
insert into receitas_fav values(1, 2);
update receitas set favs = (select count(id_receita) from receitas_fav where id_receita = 1) where id = 1;

insert into receitas_exc values(2, 2);

insert into comentarios values(comentario_seq.NEXTVAL, 1, 2, 'Melhor receita 1.');
insert into comentarios values(comentario_seq.NEXTVAL, 2, 2, 'Melhor receita 2.');
insert into comentarios values(comentario_seq.NEXTVAL, 3, 1, 'Melhor receita 3.');

insert into pontuacoes values(1, 1, 3);
insert into pontuacoes values(1, 2, 4);
update receitas set pontuacao_media = (select avg(qty) from pontuacoes where id_receita = 1) where id = 1;
insert into pontuacoes values(2, 2, 2);
update receitas set pontuacao_media = (select avg(qty) from pontuacoes where id_receita = 2) where id = 2;
insert into pontuacoes values(3, 2, 5);
update receitas set pontuacao_media = (select avg(qty) from pontuacoes where id_receita = 3) where id = 3;

-- insert into receitas_tags values(1, 1);
-- insert into receitas_tags values(1, 2);
-- insert into receitas_tags values(2, 3);
-- insert into receitas_tags values(3, 1);
-- insert into receitas_tags values(3, 3);

update receitas set views = views + 1 where id = 1;

commit;
