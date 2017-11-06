package com.tds171a.soboru.beans;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.tds171a.soboru.vos.Usuario;

public class SessionContext {
	private static SessionContext instance;
	
	public static SessionContext getInstance() {
		if(instance == null) {
			instance = new SessionContext();
		}
		
		return instance;
	}
	
	private SessionContext() {}
	
	private ExternalContext currentExternalContext() {
		if(FacesContext.getCurrentInstance() == null) {
			throw new RuntimeException("O FacesContext nao pode ser chamado fora de uma requisicao HTTP");
		} else {
			return FacesContext.getCurrentInstance().getExternalContext();
		}
	}
	
	public void encerrarSessao() {
		currentExternalContext().invalidateSession();
	}
	
	public Usuario getUsuarioLogado() {
		return (Usuario) getAttribute("usuarioLogado");
	}
	
	public void setUsuarioLogado(Usuario usuario) {
		setAttribute("usuarioLogado", usuario);
	}
	
	public Object getAttribute(String nome) {
		return currentExternalContext().getSessionMap().get(nome);
	}
	
	public void setAttribute(String nome, Object valor) {
		currentExternalContext().getSessionMap().put(nome, valor);
	}
}
