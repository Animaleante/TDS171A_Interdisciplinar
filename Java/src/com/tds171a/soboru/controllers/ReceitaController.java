/**
 * 
 */
package com.tds171a.soboru.controllers;

import java.util.List;

import com.tds171a.soboru.models.receita.ReceitaModel;
import com.tds171a.soboru.vos.Receita;
import com.tds171a.soboru.vos.Tag;

/**
 * Classe de controller da receita
 * @author Diogo
 *
 */
public class ReceitaController extends ControllerBase<Receita>{

	/**
     * Construtor da classe de controller da receita
     */
    public ReceitaController() {
        model = new ReceitaModel();
    }
    
    public boolean incluirTag(Receita receita, Tag tag) {
    	return ((ReceitaModel) model).incluirTag(receita, tag);
    }

	public List<Tag> listarTags(Receita receita) {
		return ((ReceitaModel) model).listarTags(receita);
	}
}
