/**
 * 
 */
package com.tds171a.soboru.controllers;

import java.util.List;

import com.tds171a.soboru.models.receita.ReceitaModel;
import com.tds171a.soboru.vos.Receita;

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

	public List<Receita> selecionarPorNome(String termoBusca) {
		return ((ReceitaModel) model).selecionarPorNome(termoBusca);
	}
	
	public List<Receita> selecionarPorIngredientes(List<Integer> ingredientes) {
		return ((ReceitaModel) model).selecionarPorIngredientes(ingredientes);
	}

	public List<Receita> selecionarPorNomeEIngredientes(String termoBusca, List<Integer> ingredientes) {
		return ((ReceitaModel) model).selecionarPorNomeEIngredientes(termoBusca, ingredientes);
	}
}
