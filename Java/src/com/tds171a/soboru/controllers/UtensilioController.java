package com.tds171a.soboru.controllers;

import java.util.List;

import com.tds171a.soboru.models.utensilio.UtensilioModel;
import com.tds171a.soboru.vos.Utensilio;

/**
 * Classe de controller do Utensilio
 * @author Diogo
 *
 */
public class UtensilioController {

	/**
	 * Par�metro de model do Utensilio
	 */
	private UtensilioModel model;

	/**
	 * Construtor da classe de controller do Utensilio
	 */
	public UtensilioController() {
		model = new UtensilioModel();
	}

	/**
	 * M�todo para incluir um novo Utensilio
	 * @param utensilio
	 * @return
	 */
	public boolean incluir(Utensilio utensilio) {
		return model.incluir(utensilio);
	}

	/**
	 * M�todo para trazer uma lista de todos os Utensilios
	 * @return
	 */
	public List<Utensilio> listar() {
		return model.listar();
	}

	/**
	 * M�todo para atualizar um Utensilio j� registrado
	 * @param utensilio
	 * @return
	 */
	public boolean atualizar(Utensilio utensilio) {
		return model.atualizar(utensilio);
	}

	/**
	 * M�todo para remover um Utensilio
	 * @param utensilioId
	 * @return
	 */
	public boolean remover(int utensilioId) {
		return model.remover(utensilioId);
	}
}
