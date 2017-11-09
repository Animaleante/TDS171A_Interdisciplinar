package com.tds171a.soboru.beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.tds171a.soboru.controllers.ReportController;
import com.tds171a.soboru.vos.Report;

@Named("reportBean")
@SessionScoped
public class ReportBean extends BeanBase<Report> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4730432362349049623L;
	
	public ReportBean() {
		route_base = "/cadastro/report/";
		controller = new ReportController();
		setVo(new Report());
	}

	@Override
	public String deletar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void limparVo() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean validarDados() {
		// TODO Auto-generated method stub
		return super.validarDados();
	}

}
