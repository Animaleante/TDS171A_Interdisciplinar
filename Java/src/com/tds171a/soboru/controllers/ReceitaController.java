/**
 * 
 */
package com.tds171a.soboru.controllers;

import java.util.List;

import com.tds171a.soboru.models.receita.ReceitaModel;
import com.tds171a.soboru.vos.Receita;

/**
 * @author Sony
 *
 */
public class ReceitaController {

    /**
     * Parametro de model da Receita
     */
    private ReceitaModel model;

    /**
     * Construtor da classe de controller da Receita
     */
    public ReceitaController() {
        model = new ReceitaModel();
    }

    /**
     * Metodo para incluir uma nova Receita
     * @param categoria
     * @return
     */
    public boolean incluir(Receita vo) {
        return model.incluir(vo);
    }

    /**
     * Metodo para trazer uma lista de todas as Receitas
     * @return
     */
    public List<Receita> listar() {
        return model.listar();
    }

    /**
     * Metodo para atualizar uma Receita ja registrado
     * @param categoria
     * @return
     */
    public boolean atualizar(Receita vo) {
        return model.atualizar(vo);
    }

    /**
     * Metodo para remover uma Receita
     * @param categoriaId
     * @return
     */
    public boolean remover(int voId) {
        return model.remover(voId);
    }
}
