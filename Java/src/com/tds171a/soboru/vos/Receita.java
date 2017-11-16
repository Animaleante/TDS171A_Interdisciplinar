package com.tds171a.soboru.vos;

import java.util.List;

public class Receita {

	/**
	 * Parametro id da Receita
	 */
	private int id;

	/**
	 * Parametro nome da receita
	 */
	private String nome;

	/**
	 * Parametro nome da receita
	 */
	private int categoriaId;

	/**
	 * Parametro nome da receita
	 */
	private int usuarioId;

	/**
	 * Parametro nome da receita
	 */
	private Integer porcao;

	/**
	 * Parametro nome da receita
	 */
	private Double tempoPreparo;

	/**
	 * Parametro nome da receita
	 */
	private String modoPreparo;

	/**
	 * Parametro nome da receita
	 */
	private String imgPath;

	/**
	 * Parametro nome da receita
	 */
	private double pontuacaoMedia;

	/**
	 * Parametro nome da receita
	 */
	private int views;

	/**
	 * Parametro nome da receita
	 */
	private int favs;

	/**
	 * Parametro nome da receita
	 */
	private String slug;

	/**
	 * Parametro nome da receita
	 */
	private boolean aprovado;
	
	/**
	 * 
	 */
	private Categoria categoria;
	
	/**
	 * 
	 */
	private Usuario usuario;
	
	/**
	 * 
	 */
	private List<Utensilio> utensilios;
	
	/**
	 * 
	 */
	private List<Tag> tags;
	
	/**
	 * 
	 */
	private List<ReceitaIngrediente> receitaIngredientes;
	
	/**
	 * 
	 */
	private List<Comentario> comentarios;
	
	/**
	 * 
	 */
	private List<Report> reports;
	
	/**
	 * 
	 */
	private List<Pontuacao> pontuacoes;
	
	/**
	 * 
	 */
	private List<Usuario> usuariosFavoritaram;
	
	public Receita() {
		this.id = -1;
		this.nome = "";
		this.categoriaId = -1;
		this.usuarioId = -1;
		this.porcao = null;
		this.tempoPreparo = null;
		this.modoPreparo = "";
		this.imgPath = "";
		this.pontuacaoMedia = 0;
		this.views = 0;
		this.favs = 0;
		this.slug = "";
		this.aprovado = false;
		
		this.categoria = null;
		this.usuario = null;
		
		this.utensilios = null;
		this.tags = null;
		this.receitaIngredientes = null;
		this.comentarios = null;
		this.reports = null;
		this.pontuacoes = null;
		this.usuariosFavoritaram = null;
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the id_categoria
	 */
	public int getCategoriaId() {
		return categoriaId;
	}

	/**
	 * @param categoriaId the id_categoria to set
	 */
	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}

	/**
	 * @return the id_usuario
	 */
	public int getUsuarioId() {
		return usuarioId;
	}

	/**
	 * @param usuarioId the id_usuario to set
	 */
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	/**
	 * @return the porcao
	 */
	public Integer getPorcao() {
		return porcao;
	}

	/**
	 * @param porcao the porcao to set
	 */
	public void setPorcao(Integer porcao) {
		this.porcao = porcao;
	}

	/**
	 * @return the tempo_preparo
	 */
	public Double getTempoPreparo() {
		return tempoPreparo;
	}

	/**
	 * @param tempoPreparo the tempo_preparo to set
	 */
	public void setTempoPreparo(Double tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	/**
	 * @return the modo_preparo
	 */
	public String getModoPreparo() {
		return modoPreparo;
	}

	/**
	 * @param modoPreparo the modo_preparo to set
	 */
	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

	/**
	 * @return the img_path
	 */
	public String getImgPath() {
		return imgPath;
	}

	/**
	 * @param imgPath the img_path to set
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	/**
	 * @return the pontuacao_media
	 */
	public double getPontuacaoMedia() {
		return pontuacaoMedia;
	}

	/**
	 * @param pontuacaoMedia the pontuacao_media to set
	 */
	public void setPontuacaoMedia(double pontuacaoMedia) {
		this.pontuacaoMedia = pontuacaoMedia;
	}

	/**
	 * @return the views
	 */
	public int getViews() {
		return views;
	}

	/**
	 * @param views the views to set
	 */
	public void setViews(int views) {
		this.views = views;
	}

	/**
	 * @return the favs
	 */
	public int getFavs() {
		return favs;
	}

	/**
	 * @param favs the favs to set
	 */
	public void setFavs(int favs) {
		this.favs = favs;
	}

	/**
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}

	/**
	 * @return the aprovado
	 */
	public boolean getAprovado() {
		return aprovado;
	}

	/**
	 * @param aprovado the aprovado to set
	 */
	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

	/**
	 * @return the utensilios
	 */
	public List<Utensilio> getUtensilios() {
		return utensilios;
	}

	/**
	 * @param utensilios the utensilios to set
	 */
	public void setUtensilios(List<Utensilio> utensilios) {
		this.utensilios = utensilios;
	}

	/**
	 * @return the tags
	 */
	public List<Tag> getTags() {
		return tags;
	}

	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	/**
	 * @return the receitaIngredientes
	 */
	public List<ReceitaIngrediente> getReceitaIngredientes() {
		return receitaIngredientes;
	}

	/**
	 * @param receitaIngredientes the receitaIngredientes to set
	 */
	public void setReceitaIngredientes(List<ReceitaIngrediente> receitaIngredientes) {
		this.receitaIngredientes = receitaIngredientes;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	/**
	 * @return the comentarios
	 */
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	/**
	 * @return the reports
	 */
	public List<Report> getReports() {
		return reports;
	}

	/**
	 * @param reports the reports to set
	 */
	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	/**
	 * @return the pontuacoes
	 */
	public List<Pontuacao> getPontuacoes() {
		return pontuacoes;
	}

	/**
	 * @param pontuacoes the pontuacoes to set
	 */
	public void setPontuacoes(List<Pontuacao> pontuacoes) {
		this.pontuacoes = pontuacoes;
	}

	/**
	 * @return the usuariosFavoritaram
	 */
	public List<Usuario> getUsuariosFavoritaram() {
		return usuariosFavoritaram;
	}

	/**
	 * @param usuariosFavoritaram the usuariosFavoritaram to set
	 */
	public void setUsuariosFavoritaram(List<Usuario> usuariosFavoritaram) {
		this.usuariosFavoritaram = usuariosFavoritaram;
	}
}
