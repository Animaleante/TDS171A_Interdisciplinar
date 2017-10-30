package com.tds171a.soboru.controllers;

import java.util.List;

import com.tds171a.soboru.models.medida.MedidaModel;
import com.tds171a.soboru.vos.Medida;

/**
 * Classe de controller da Medida
 * @author Diogo
 *
 */
public class MedidaController {

	/**
	 * Par�metro de model da Medida
	 */
	private MedidaModel model;

	/**
	 * Construtor da classe de controller da Medida
	 */
	public MedidaController() {
		model = new MedidaModel();
	}

	/**
	 * M�todo para incluir uma nova Medida
	 * @param medida
	 * @return
	 */
	public boolean incluir(Medida medida) {
		return model.incluir(medida);
	}

	/**
	 * M�todo para trazer uma lista de todas as Medidas
	 * @return
	 */
	public List<Medida> listar() {
		return model.listar();
	}

	/**
	 * M�todo para atualizar uma Medida j� registrada
	 * @param medida
	 * @return
	 */
	public boolean atualizar(Medida medida) {
		return model.atualizar(medida);
	}

	/**
	 * M�todo para remover uma Medida
	 * @param medidaId
	 * @return
	 */
	public boolean remover(int medidaId) {
		return model.remover(medidaId);
	}
}
