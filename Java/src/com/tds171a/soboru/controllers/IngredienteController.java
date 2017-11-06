package com.tds171a.soboru.controllers;

import com.tds171a.soboru.models.ingrediente.IngredienteModel;
import com.tds171a.soboru.vos.Ingrediente;

/**
 * Classe de controller do Ingrediente
 * @author Diogo
 *
 */
public class IngredienteController extends ControllerBase<Ingrediente> {
	
	/**
	 * Construtor da classe de controller do Ingrediente
	 */
	public IngredienteController() {
		model = new IngredienteModel();
	}
}
