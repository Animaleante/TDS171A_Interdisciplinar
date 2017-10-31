package com.tds171a.soboru.models.utensilio;

import java.util.List;

import com.tds171a.soboru.models.IDAO;
import com.tds171a.soboru.vos.Utensilio;

/**
 * Classe de MOdel do Utensilio
 * @author Diogo
 *
 */
public class UtensilioModel implements IDAO<Utensilio> {

	/**
	 * Parametro de model do Utensilio
	 */
	private UtensilioDAO dao;

	/**
	 * Construtor da classe de controller do Utensilio
	 */
	public UtensilioModel() {
		dao = new UtensilioDAO();
	}

	/**
	 * M�todo para incluir um novo Utensilio
	 * @param ingrediente
	 * @return
	 */
	@Override
	public boolean incluir(Utensilio utensilio) {
		return dao.incluir(utensilio);
	}

	/**
	 * M�todo para trazer uma lista de todos os Utensilios
	 * @return
	 */
	@Override
	public List<Utensilio> listar() {
		return dao.listar();
	}

	/**
	 * M�todo para atualizar um Utensilio j� registrado
	 * @param ingrediente
	 * @return
	 */
	@Override
	public boolean atualizar(Utensilio utensilio) {
		return dao.atualizar(utensilio);
	}

	/**
	 * M�todo para remover um Utensilio
	 * @param ingredienteId
	 * @return
	 */
	@Override
	public boolean remover(int utensilioId) {
		return dao.remover(utensilioId);
	}
}
