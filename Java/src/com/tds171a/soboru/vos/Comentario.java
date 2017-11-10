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
	
	private String receitaNome;
	private String usuarioNome;
	
	public Comentario() {
		// TODO Auto-generated constructor stub
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
	 * @return the receitaNome
	 */
	public String getReceitaNome() {
		return receitaNome;
	}

	/**
	 * @param receitaNome the receitaNome to set
	 */
	public void setReceitaNome(String receitaNome) {
		this.receitaNome = receitaNome;
	}

	/**
	 * @return the usuarioNome
	 */
	public String getUsuarioNome() {
		return usuarioNome;
	}

	/**
	 * @param usuarioNome the usuarioNome to set
	 */
	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}
}
