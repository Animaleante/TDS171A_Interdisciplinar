/**
 *
 */
package com.tds171a.soboru.models.report;

import com.tds171a.soboru.models.ModelBase;
import com.tds171a.soboru.vos.Report;

/**
 * @author Diogo
 *
 */
public class ReportModel extends ModelBase<Report> {

	/**
	 *
	 */
	public ReportModel() {
		dao = new ReportDAO();
	}

	public boolean remover(int receitaId, int usuarioId) {
        return ((ReportDAO)dao).remover(receitaId, usuarioId);
    }
}
