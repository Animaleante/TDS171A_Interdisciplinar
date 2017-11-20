package com.tds171a.soboru.controllers;

import java.util.List;

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

	/**
	 * Trás os utensilios existentes na receita.
	 * @param receitaId
	 * @return
	 */
	public List<Utensilio> selecionarPorReceita(int receitaId) {
		return ((UtensilioModel) model).selecionarPorReceita(receitaId);
	}
}
