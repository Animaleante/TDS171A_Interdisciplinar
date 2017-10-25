package com.tds171a.soboru.models.ingrediente;

import java.util.List;

import com.tds171a.soboru.models.IDAO;
import com.tds171a.soboru.vos.Ingrediente;

/**
 * Classe de Model do Ingrediente
 * @author Diogo
 *
 */
public class IngredienteModel implements IDAO<Ingrediente> {
	
	/**
	 * Parâmetro do DAO do INgrediente
	 */
	private IngredienteDAO dao;
	
	/**
	 * Construtor da classe IngredienteModel
	 */
	public IngredienteModel() {
		dao = new IngredienteDAO();
	}

	/**
	 * Método para incluir um novo Ingrediente
	 * @param ingrediente
	 * @return
	 */
	@Override
	public boolean incluir(Ingrediente ingrediente) {
		return dao.incluir(ingrediente);
	}

	/**
	 * Método para trazer uma lista de todos os Ingredientes
	 * @return
	 */
	@Override
	public List<Ingrediente> listar() {
		return dao.listar();
	}
	
	/**
	 * Método para atualizar um Ingrediente já registrado
	 * @param ingrediente
	 * @return
	 */
	@Override
	public boolean atualizar(Ingrediente ingrediente) {
		return dao.atualizar(ingrediente);
	}

	/**
	 * Método para remover um Ingrediente
	 * @param ingredienteId
	 * @return
	 */
	@Override
	public boolean remover(int ingredienteId) {
		return dao.remover(ingredienteId);
	}
}
