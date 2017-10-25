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
	 * Parâmetro de model da Medida
	 */
	private MedidaModel model;
	
	/**
	 * Construtor da classe de controller da Medida
	 */
	public MedidaController() {
		model = new MedidaModel();
	}

	/**
	 * Método para incluir uma nova Medida
	 * @param ingrediente
	 * @return
	 */
	public boolean incluir(Medida medida) {
		return model.incluir(medida);
	}

	/**
	 * Método para trazer uma lista de todas as Medidas
	 * @return
	 */
	public List<Medida> listar() {
		return model.listar();
	}
	
	/**
	 * Método para atualizar uma Medida já registrada
	 * @param ingrediente
	 * @return
	 */
	public boolean atualizar(Medida medida) {
		return model.atualizar(medida);
	}

	/**
	 * Método para remover uma Medida
	 * @param ingredienteId
	 * @return
	 */
	public boolean remover(int medidaId) {
		return model.remover(medidaId);
	}
}
