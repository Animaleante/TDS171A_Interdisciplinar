package com.tds171a.soboru.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import com.tds171a.soboru.controllers.ReceitaController;
import com.tds171a.soboru.controllers.ReportController;
import com.tds171a.soboru.vos.Receita;
import com.tds171a.soboru.vos.Report;

@Named("reportBean")
@SessionScoped
public class ReportBean extends BeanBase<Report> {

	/**
	 *
	 */
	private static final long serialVersionUID = 4730432362349049623L;

	private List<Receita> receitas;

	public ReportBean() {
		route_base = "/cadastro/report/";
		controller = new ReportController();
		setVo(new Report());
	}

	@Override
	public String criar()
	{
	    ReceitaController receitaController = new ReceitaController();
	    setReceitas(receitaController.listar());
	    return super.criar();
	}

	@Override
	public String incluir()
	{
	    getVo().setUsuarioId(SessionContext.getInstance().getUsuarioLogado().getId());

	    return super.incluir();
	}

	@Override
	public String deletar() {
        FacesContext context = FacesContext.getCurrentInstance();

        if(((ReportController)controller).remover(getVo().getReceitaId(), getVo().getUsuarioId())) {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado com sucesso!", null));
        } else {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nao foi possivel deletar.", null));
            return route_base + DELETAR_PAGE;
        }

        limparVo();

        return listar();
	}

	@Override
	public void limparVo() {
		setVo(new Report());
	}

	@Override
	public boolean validarDados() {
		// TODO Auto-generated method stub
		return super.validarDados();
	}

    /**
     * @return the receitas
     */
    public List<SelectItem> getReceitas()
    {
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Receita r : this.receitas) {
            items.add(new SelectItem(r.getId(), r.getNome()));
        }
        return items;
    }

    /**
     * @param pReceitas the receitas to set
     */
    public void setReceitas(List<Receita> pReceitas)
    {
        receitas = pReceitas;
    }

}
