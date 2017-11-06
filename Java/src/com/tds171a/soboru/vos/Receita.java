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

	/**
	 * Parametro nome da receita
	 */
	private int usuarioId;

	/**
	 * Parametro nome da receita
	 */
	private int porcao;

	/**
	 * Parametro nome da receita
	 */
	private double tempoPreparo;

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
	
	public Receita() {}
	
	public Receita(int id, String nome, int categoriaId, int usuarioId, int porcao, double tempoPreparo, String modoPreparo, String imgPath, double pontuacaoMedia, int views, int favs, String slug, boolean aprovado) {
		this.id = id;
		this.nome = nome;
		this.categoriaId = categoriaId;
		this.usuarioId = usuarioId;
		this.porcao = porcao;
		this.tempoPreparo = tempoPreparo;
		this.modoPreparo = modoPreparo;
		this.imgPath = imgPath;
		this.pontuacaoMedia = pontuacaoMedia;
		this.views = views;
		this.favs = favs;
		this.slug = slug;
		this.setAprovado(aprovado);
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
	public int getPorcao() {
		return porcao;
	}

	/**
	 * @param porcao the porcao to set
	 */
	public void setPorcao(int porcao) {
		this.porcao = porcao;
	}

	/**
	 * @return the tempo_preparo
	 */
	public double getTempoPreparo() {
		return tempoPreparo;
	}

	/**
	 * @param tempoPreparo the tempo_preparo to set
	 */
	public void setTempoPreparo(double tempoPreparo) {
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
}
