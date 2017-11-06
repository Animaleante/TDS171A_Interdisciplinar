package com.tds171a.soboru.controllers;

import com.tds171a.soboru.models.utensilio.UtensilioModel;
import com.tds171a.soboru.vos.Utensilio;

/**
 * Classe de controller do Utensilio
 * @author Diogo
 *
 */
public class UtensilioController extends ControllerBase<Utensilio> {

	/**
	 * Construtor da classe de controller do Utensilio
	 */
	public UtensilioController() {
		model = new UtensilioModel();
	}
}
