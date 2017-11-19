/**
 * 
 */
package com.tds171a.soboru.beans;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.tds171a.soboru.controllers.ReceitaController;
import com.tds171a.soboru.controllers.UsuarioController;
import com.tds171a.soboru.vos.Receita;
import com.tds171a.soboru.vos.Usuario;

@Named("usuarioSiteBean")
@SessionScoped
/**
 * @author PC970
 *
 */
public class UsuarioSiteBean extends BeanBase<Usuario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9063625419454028906L;
	
	private ReceitaController receitaController;
	private List<Receita> listaReceitas;
	private List<Receita> listaFavoritos;

	/**
	 * 
	 */
	public UsuarioSiteBean() {
		route_base = "/usuario/";
		controller = new UsuarioController();
		
		receitaController = new ReceitaController();
		
		setVo(new Usuario());
	}
	
	public String exibir() {
		Usuario usuario = SessionContext.getInstance().getUsuarioLogado();
		if(usuario != null)
			return exibir(usuario);
		return "/login/"+BeanBase.INDEX_PAGE+BeanBase.FACES_REDIRECT;
	}
	
	@Override
	public String exibir(Usuario vo) {
		vo = controller.selecionar(vo.getId());
		
		setListaReceitas(receitaController.selecionarPorUsuario(vo.getId()));
		setListaFavoritos(receitaController.selecionarPorFavoritosDeUsuario(vo.getId()));
		
		return super.exibir(vo);
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

	/**
	 * @return the listaReceitas
	 */
	public List<Receita> getListaReceitas() {
		return listaReceitas;
	}

	/**
	 * @param listaReceitas the listaReceitas to set
	 */
	public void setListaReceitas(List<Receita> listaReceitas) {
		this.listaReceitas = listaReceitas;
	}

	/**
	 * @return the listaFavoritos
	 */
	public List<Receita> getListaFavoritos() {
		return listaFavoritos;
	}

	/**
	 * @param listaFavoritos the listaFavoritos to set
	 */
	public void setListaFavoritos(List<Receita> listaFavoritos) {
		this.listaFavoritos = listaFavoritos;
	}

}
