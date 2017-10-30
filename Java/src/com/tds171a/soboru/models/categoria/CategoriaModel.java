package com.tds171a.soboru.models.categoria;

import java.util.List;

import com.tds171a.soboru.models.IDAO;
import com.tds171a.soboru.vos.Categoria;

/**
 * Classe de Model do Categoria
 * @author Diogo
 *
 */
public class CategoriaModel implements IDAO<Categoria> {

    /**
     * Par�metro do DAO do INgrediente
     */
    private CategoriaDAO dao;

    /**
     * Construtor da classe CategoriaModel
     */
    public CategoriaModel() {
        dao = new CategoriaDAO();
    }

    /**
     * M�todo para incluir um novo Categoria
     * @param categoria
     * @return
     */
    @Override
    public boolean incluir(Categoria categoria) {
        return dao.incluir(categoria);
    }

    /**
     * M�todo para trazer uma lista de todos os Categorias
     * @return
     */
    @Override
    public List<Categoria> listar() {
        return dao.listar();
    }

    /**
     * M�todo para atualizar um Categoria j� registrado
     * @param categoria
     * @return
     */
    @Override
    public boolean atualizar(Categoria categoria) {
        return dao.atualizar(categoria);
    }

    /**
     * M�todo para remover um Categoria
     * @param categoriaId
     * @return
     */
    @Override
    public boolean remover(int categoriaId) {
        return dao.remover(categoriaId);
    }
}
