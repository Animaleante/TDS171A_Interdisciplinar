package com.tds171a.soboru.controllers;

import com.tds171a.soboru.models.medida.MedidaModel;
import com.tds171a.soboru.vos.Medida;

/**
 * Classe de controller da Medida
 * @author Diogo
 *
 */
public class MedidaController extends ControllerBase<Medida>{

	/**
	 * Construtor da classe de controller da Medida
	 */
	public MedidaController() {
		model = new MedidaModel();
	}
}
