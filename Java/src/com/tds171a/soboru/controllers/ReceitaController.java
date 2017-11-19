/**
 * 
 */
package com.tds171a.soboru.controllers;

import java.util.List;

import com.tds171a.soboru.models.receita.ReceitaModel;
import com.tds171a.soboru.vos.Receita;
import com.tds171a.soboru.vos.ReceitaIngrediente;
import com.tds171a.soboru.vos.Tag;
import com.tds171a.soboru.vos.Utensilio;

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

	public List<Utensilio> listarUtensilios(Receita receita) {
		return ((ReceitaModel) model).listarUtensilios(receita);
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

	public void registrarUtensilios(int receitaId, List<Utensilio> lista) {
		((ReceitaModel) model).registrarUtensilios(receitaId, lista);
	}

	public List<ReceitaIngrediente> listarIngredientes(Receita receita) {
		return ((ReceitaModel) model).listarIngredientes(receita);
	}
}
