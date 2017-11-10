package com.tds171a.soboru.vos;

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
	
	private String categoriaNome;

	/**
	 * Parametro nome da receita
	 */
	private int usuarioId;
	
	private String usuarioNome;

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
	
	public Receita() {
		this.id = -1;
		this.nome = "";
		//this.categoriaId = -1;
		this.categoriaNome="";
		//this.usuarioId = -1;
		this.usuarioNome = "";
		this.porcao = null;
		this.tempoPreparo = null;
		this.modoPreparo = "";
		this.imgPath = "";
		this.pontuacaoMedia = 0;
		this.views = 0;
		this.favs = 0;
		this.slug = "";
		this.aprovado = false;
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
	 * @return the categoriaNome
	 */
	public String getCategoriaNome() {
		return categoriaNome;
	}

	/**
	 * @param categoriaNome the categoriaNome to set
	 */
	public void setCategoriaNome(String categoriaNome) {
		this.categoriaNome = categoriaNome;
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
