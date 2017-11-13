/**
 *
 */
package com.tds171a.soboru.controllers;

import com.tds171a.soboru.models.report.ReportModel;
import com.tds171a.soboru.vos.Report;

/**
 * Classe de controller do report
 * @author Palte
 *
 */
public class ReportController extends ControllerBase<Report> {

	/**
	 *Construtor da classe
	 */
	public ReportController() {
		model = new ReportModel();
	}

	/**
	 * remove o report tirando o id da receita
	 * e o id do usuário.
	 */
	public boolean remover(int receitaId, int usuarioId) {
	    return ((ReportModel)model).remover(receitaId, usuarioId);
	}
}
