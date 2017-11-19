--ingredientes
-- arroz com lentilha
--insert into ingredientes values (ingrediente_seq.NEXTVAL,'NOME INGREDIENTE');

--Ingredientes - Arroz de Lentilha
insert into ingredientes values (ingrediente_seq.NEXTVAL,'agua fervente');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'lentilha');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'picados');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'azeite');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'arroz branco');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'sal');

--Ingredientes - Cebola Frita
insert into ingredientes values (ingrediente_seq.NEXTVAL,'cebola');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'farinha de trigo');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'oleo');

--Ingredientes - Torta
insert into ingredientes values (ingrediente_seq.NEXTVAL,'pimentao verde');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'pimenta dedo-de-moca');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'ovo');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'mucarela ralada');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'iogurte natural');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'salsinha');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'fermento em po');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'tomate');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'calabresa');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'azeitona');


--Ingredientes - Petit gâteau de queijo

insert into ingredientes values (ingrediente_seq.NEXTVAL,'queijo cremoso');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'cream cheese');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'parmesao ralado');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'manteiga');
insert into ingredientes values (ingrediente_seq.NEXTVAL,'gemas');

--medidas
--insert into medidas values (medida_seq.NEXTVAL,'NOME MEDIDA','ABREVEACAO');


insert into medidas values (medida_seq.NEXTVAL,'litro','L');
insert into medidas values (medida_seq.NEXTVAL,'gramas','g');
insert into medidas values (medida_seq.NEXTVAL,'dentes','dentes');
insert into medidas values (medida_seq.NEXTVAL,'fio','fio');
insert into medidas values (medida_seq.NEXTVAL,'a gosto','a gosto');
insert into medidas values (medida_seq.NEXTVAL,'unidade','uni');
insert into medidas values (medida_seq.NEXTVAL,'xicara (cha)','xic');
insert into medidas values (medida_seq.NEXTVAL,'colher (sopa)','csp');
insert into medidas values (medida_seq.NEXTVAL,'copo','cp');
insert into medidas values (medida_seq.NEXTVAL,'fatias','fatias');
insert into medidas values (medida_seq.NEXTVAL,'colheres (sobremesa)','csb');
insert into medidas values (medida_seq.NEXTVAL,'mililitro','ml');

--utensilios
--insert into utensilios values (utensilio_seq.NEXTVAL, 'NOME');

insert into utensilios values (utensilio_seq.NEXTVAL, 'Abridor de garrafa');
insert into utensilios values (utensilio_seq.NEXTVAL, 'Saca-rolhas');
insert into utensilios values (utensilio_seq.NEXTVAL, 'Assadeiras aluminio');
insert into utensilios values (utensilio_seq.NEXTVAL, 'Socador de alho');
insert into utensilios values (utensilio_seq.NEXTVAL, 'Funil');
insert into utensilios values (utensilio_seq.NEXTVAL, 'Escorredor de macarrao');
insert into utensilios values (utensilio_seq.NEXTVAL, 'Pa para bolo');
insert into utensilios values (utensilio_seq.NEXTVAL, 'Espatula de silicone');
insert into utensilios values (utensilio_seq.NEXTVAL, 'Espremedor de alho');
insert into utensilios values (utensilio_seq.NEXTVAL, 'Espremedor de batata');


--categorias
-- ID,NOME,ID_SUPER_CATEGORIA SELECIONAVEL,SLUG
--insert into categorias values(categoria_seq.NEXTVAL, 'categoria1', null, 0, 'NOME CATEGORIA');

--1
insert into categorias values(categoria_seq.NEXTVAL, 'Salgados', null, 0, 'Salgados');
--2
insert into categorias values(categoria_seq.NEXTVAL, 'Tortas', 1, 1, 'Tortas');
--3
insert into categorias values(categoria_seq.NEXTVAL, 'Petiscos', 1, 1, 'Petiscos');
--4
insert into categorias values(categoria_seq.NEXTVAL, 'Cotidiano', 1, 1, 'Cotidiano');
--5
insert into categorias values(categoria_seq.NEXTVAL, 'Gourmet', null, 0, 'Gourmet');
--6
insert into categorias values(categoria_seq.NEXTVAL, 'Petit gateau', 2, 1, 'Petit gateau');

--receitas
--insert into receitas values (receita_seq.NEXTVAL, 'NOME RECEITA', 2, 1, 2, 2, 'Modo de Preparo', 'teste.jpg', 0, 0, 0, 'receita1', 1);


insert into receitas (id, nome, id_categoria, id_usuario, porcao, tempo_preparo, modo_preparo, img_path, pontuacao_media, views, favs, slug, aprovado) 
values (receita_seq.NEXTVAL, 'Arroz de Lentilha', 4, 1, 5, 20, 'Numa panela com água fervente em fogo médio coloque a lentilha, tempere com sal, tampe a panela e cozinhe por 20 minutos.
Escorra a lentilha, reserve a água do cozimento e a lentilha.
Depois de refogar bem o alho no azeite e o arroz, tempere com sal, coloque a água do cozimento da lentilha, tampe a panela e cozinhe por +/- 15 minutos.
Depois misture o arroz cozido com a lentilha cozida e reserve.', 'teste.jpg', 0, 0, 0, 'receita1', 1);

insert into receitas values (receita_seq.NEXTVAL, 'Cebola Frita', 3, 1, 3, 19, 'Com uma faca afiada corte as cebolas em fatias bem finas e seque bem com um papel absorvente.
Numa tigela com a farinha de trigo tempere com sal a gosto, passe as fatias de cebola nessa mistura, retire o excesso de farinha de trigo e frite as fatias em óleo quente até dourar.
Retire do óleo com a ajuda de uma escumadeira e coloque em papel absorvente
Montagem: Sirva o arroz com lentilha, o kibe assado e a cebola frita', 'teste.jpg', 0, 0, 0, 'receita1', 1);

insert into receitas values (receita_seq.NEXTVAL, 'Torta salgada da vovo', 2, 1, 5, 160, 'Misture numa tigela ¼ xícara (chá) de azeite, ¼ xícara (chá) de pimentão verde bem picadinho, ¼ xícara (chá) de cebola picada, 1 colher (sopa) de pimenta dedo-de-moça sem semente picadinha, 2 ovos, 1 xícara (chá) de muçarela ralada no ralo grosso, ½ copo de iogurte natural e salsinha picadinha a gosto. Adicione 1 xícara (chá) de farinha de trigo, ½ colher (sopa) de sal, ½ colher (sopa) de fermento em pó e mexa bem.
Espalhe a massa numa forma para pizza redonda (30 cm de diâmetro) untada com manteiga e enfarinhada. Leve para assar em forno pré-aquecido a 200° C por 15 minutos.
Retire do forno e sobre a massa assada distribua muçarela ralada no ralo grosso, rodelas de tomate, fatias de ovo cozido, linguiça calabresa refogada e fatiada e azeitona verde fatiada a gosto. Regue o azeite e leve ao forno a 200° C por 15 minutos ou até derreter o queijo. Retire do forno e sirva em seguida.', 'teste.jpg', 0, 0, 0, 'receita1', 1);

insert into receitas values (receita_seq.NEXTVAL, 'Petit gateau de queijo', 6, 1, 1, 80, 'Misture o queijo com o cream cheese, o parmesão, a manteiga, os ovos e as gemas e leve ao banho-maria, mexendo sempre, até ficar homogêneo.
Fora do fogo, acrescente a farinha e sal a gosto e misture bem até obter um creme. Cubra com filme plástico e leve à geladeira por no mínimo 1 hora.
Distribua em forminhas de petit gâteau ou de empada untadas com manteiga, sem encher totalmente, e leve ao forno quente preaquecido (250°C) por 7 a 10 minutos ou até a borda ficar firme e o centro, molinho. 
Desenforme e sirva em seguida.', 'teste.jpg', 0, 0, 0, 'receita1', 1);

--receitasIngredientes
--cebola
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 20, 7, 6, null, 2);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 20, 8, 2, null, 500);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 20, 6, 5, null, 0);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 20, 9, 9, null, 5);

--torta
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 21, 4, 12, null, 60);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 21, 10, 2, null, 40);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 21, 7, 2, null, 40);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 21, 11, 8, null, 1);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 21, 12, 6, null, 2);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 21, 13, 7, null, 1);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 21, 14, 2, null, 85);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 21, 15, 5, null, 0);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 21, 8, 7, null, 1);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 21, 6, 8, null, 1/2);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 21, 16, 8, null, 1/2);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 21, 13, 5, null, 0);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 21, 17, 5, null, 0);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 21, 25, 5, null, 0);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 21, 18, 5, null, 0);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 21, 19, 5, null, 0);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 21, 4, 5, null, 0);

--petit
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 22, 20, 8, null, 5);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 22, 21, 11, null, 4);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 22, 22, 8, null, 4);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 22, 23, 8, null, 5);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 22, 12, 6, null, 2);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 22, 24, 8, null, 2);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 22, 9, 8, null, 2);

--arroz
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 19, 20, 8, null, 5);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 19, 21, 11, null, 4);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 19, 22, 8, null, 2);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 19, 23, 8, null, 5);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 19, 12, 6, null, 2);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 19, 24, 6, null, 2);
insert into receitas_ingredientes values(receita_seq.NEXTVAL, 19, 8, 8, null, 2);