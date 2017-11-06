package com.tds171a.soboru.controllers;

import com.tds171a.soboru.models.categoria.CategoriaModel;
import com.tds171a.soboru.vos.Categoria;

/**
 * Classe de controller do Categoria
 * @author Diogo
 *
 */
public class CategoriaController extends ControllerBase<Categoria> {

    /**
     * Construtor da classe de controller do Categoria
     */
    public CategoriaController() {
        model = new CategoriaModel();
    }
}
