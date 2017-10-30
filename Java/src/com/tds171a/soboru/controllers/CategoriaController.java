package com.tds171a.soboru.controllers;

import java.util.List;

import com.tds171a.soboru.models.categoria.CategoriaModel;
import com.tds171a.soboru.vos.Categoria;

/**
 * Classe de controller do Categoria
 * @author Diogo
 *
 */
public class CategoriaController {

    /**
     * Par�metro de model do Categoria
     */
    private CategoriaModel model;

    /**
     * Construtor da classe de controller do Categoria
     */
    public CategoriaController() {
        model = new CategoriaModel();
    }

    /**
     * M�todo para incluir um novo Categoria
     * @param categoria
     * @return
     */
    public boolean incluir(Categoria categoria) {
        return model.incluir(categoria);
    }

    /**
     * M�todo para trazer uma lista de todos os Categorias
     * @return
     */
    public List<Categoria> listar() {
        return model.listar();
    }

    /**
     * M�todo para atualizar um Categoria j� registrado
     * @param categoria
     * @return
     */
    public boolean atualizar(Categoria categoria) {
        return model.atualizar(categoria);
    }

    /**
     * M�todo para remover um Categoria
     * @param categoriaId
     * @return
     */
    public boolean remover(int categoriaId) {
        return model.remover(categoriaId);
    }
}
