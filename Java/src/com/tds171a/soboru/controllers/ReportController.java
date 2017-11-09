/**
 * 
 */
package com.tds171a.soboru.controllers;

import com.tds171a.soboru.models.report.ReportModel;
import com.tds171a.soboru.vos.Report;

/**
 * @author Diogo
 *
 */
public class ReportController extends ControllerBase<Report> {
	
	/**
	 * 
	 */
	public ReportController() {
		model = new ReportModel();
	}
}
