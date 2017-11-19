/**
 * 
 */
package com.tds171a.soboru.controllers;

import java.util.List;

import com.tds171a.soboru.models.receitaIngrediente.ReceitaIngredienteModel;
import com.tds171a.soboru.vos.ReceitaIngrediente;

/**
 * Classe de controller da Receita
 * @author luiz.palte
 *
 */
public class ReceitaIngredienteController extends ControllerBase<ReceitaIngrediente> {
	public ReceitaIngredienteController() {
		model = new ReceitaIngredienteModel();
	}

	/**
	 * returna uma lista de receita
	 */
	public List<ReceitaIngrediente> selecionarPorReceita(int receitaId) {
		return ((ReceitaIngredienteModel) model).selecionarPorReceita(receitaId);
	}

	public void incluirLista(int receitaId, List<ReceitaIngrediente> lista) {
		((ReceitaIngredienteModel) model).incluirLista(receitaId, lista);
	}
}
