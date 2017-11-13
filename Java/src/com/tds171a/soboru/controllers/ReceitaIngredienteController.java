/**
 * 
 */
package com.tds171a.soboru.controllers;

import java.util.List;

import com.tds171a.soboru.models.receitaIngrediente.ReceitaIngredienteModel;
import com.tds171a.soboru.vos.ReceitaIngrediente;

/**
 * @author Diogo
 *
 */
public class ReceitaIngredienteController extends ControllerBase<ReceitaIngrediente> {
	public ReceitaIngredienteController() {
		model = new ReceitaIngredienteModel();
	}

	public List<ReceitaIngrediente> selecionarPorReceita(int receitaId) {
		return ((ReceitaIngredienteModel) model).selecionarPorReceita(receitaId);
	}
}
