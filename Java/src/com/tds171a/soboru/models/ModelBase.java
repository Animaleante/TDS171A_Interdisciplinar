/**
 * 
 */
package com.tds171a.soboru.models;

import java.util.List;

/**
 * @author Diogo
 *
 */
public abstract class ModelBase<T> implements IDAO<T> {

    /**
     * Parametro do DAO
     */
    protected IDAO<T> dao;

    /**
     * Construtor da classe ModelBase
     */
    public ModelBase() {}

    /**
     * Metodo para incluir um novo Item
     * @param vo
     * @return
     */
    @Override
    public boolean incluir(T vo) {
        return dao.incluir(vo);
    }

    /**
     * Metodo para trazer uma lista de todos os Items
     * @return
     */
    @Override
    public List<T> listar() {
        return dao.listar();
    }

    /**
     * Metodo para atualizar um Item ja registrado
     * @param vo
     * @return
     */
    @Override
    public boolean atualizar(T vo) {
        return dao.atualizar(vo);
    }

    /**
     * Metodo para remover um Item
     * @param voId
     * @return
     */
    @Override
    public boolean remover(int voId) {
        return dao.remover(voId);
    }
}
