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
	 * Parâmetro de model do Utensilio
	 */
	private UtensilioModel model;
	
	/**
	 * Construtor da classe de controller do Utensilio
	 */
	public UtensilioController() {
		model = new UtensilioModel();
	}

	/**
	 * Método para incluir um novo Utensilio
	 * @param ingrediente
	 * @return
	 */
	public boolean incluir(Utensilio utensilio) {
		return model.incluir(utensilio);
	}

	/**
	 * Método para trazer uma lista de todos os Utensilios
	 * @return
	 */
	public List<Utensilio> listar() {
		return model.listar();
	}
	
	/**
	 * Método para atualizar um Utensilio já registrado
	 * @param ingrediente
	 * @return
	 */
	public boolean atualizar(Utensilio utensilio) {
		return model.atualizar(utensilio);
	}

	/**
	 * Método para remover um Utensilio
	 * @param ingredienteId
	 * @return
	 */
	public boolean remover(int utensilioId) {
		return model.remover(utensilioId);
	}
}
