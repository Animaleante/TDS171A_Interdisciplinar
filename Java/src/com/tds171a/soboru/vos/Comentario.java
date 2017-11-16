/**
 * 
 */
package com.tds171a.soboru.vos;

/**
 * @author Diogo
 *
 */
public class Comentario {
	private int id;
	private int receitaId;
	private int usuarioId;
	private String body;
	
	private Receita receita;
	private Usuario usuario;
	
	public Comentario() {
		id = -1;
		receitaId = -1;
		usuarioId = -1;
		receita = null;
		usuario = null;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the receitaId
	 */
	public int getReceitaId() {
		return receitaId;
	}
	/**
	 * @param receitaId the receitaId to set
	 */
	public void setReceitaId(int receitaId) {
		this.receitaId = receitaId;
	}
	/**
	 * @return the usuarioId
	 */
	public int getUsuarioId() {
		return usuarioId;
	}
	/**
	 * @param usuarioId the usuarioId to set
	 */
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the receita
	 */
	public Receita getReceita() {
		return receita;
	}

	/**
	 * @param receita the receita to set
	 */
	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
