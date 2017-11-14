package com.tds171a.soboru.models.categoria;

import java.util.List;

import com.tds171a.soboru.models.ModelBase;
import com.tds171a.soboru.vos.Categoria;

/**
 * Classe de Model do Categoria
 * @author Diogo
 *
 */
public class CategoriaModel extends ModelBase<Categoria> {

    /**
     * Construtor da classe CategoriaModel
     */
    public CategoriaModel() {
        dao = new CategoriaDAO();
    }
    
	public List<Categoria> listarGrupos() {
		return ((CategoriaDAO)dao).listarGrupos();
	}
}
