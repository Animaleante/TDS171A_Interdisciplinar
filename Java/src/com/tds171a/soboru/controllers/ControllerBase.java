package com.tds171a.soboru.controllers;

import java.util.List;

import com.tds171a.soboru.models.IDAO;

public abstract class ControllerBase<T> {
	/**
	 * Parametro de model do Utensilio
	 */
	protected IDAO<T> model;

	/**
	 * Construtor da classe abstrata de controller
	 */
	public ControllerBase() {
//		model = new IDAO<T>();
	}

	/**
	 * Metodo para incluir um novo Item
	 * @param utensilio
	 * @return
	 */
	public boolean incluir(T vo) {
		return model.incluir(vo);
	}

	/**
	 * Metodo para trazer uma lista de todos os Item
	 * @return
	 */
	public List<T> listar() {
		return model.listar();
	}

	/**
	 * Metodo para atualizar um Item ja registrado
	 * @param utensilio
	 * @return
	 */
	public boolean atualizar(T vo) {
		return model.atualizar(vo);
	}

	/**
	 * Metodo para remover um Item
	 * @param utensilioId
	 * @return
	 */
	public boolean remover(int voId) {
		return model.remover(voId);
	}
	
	/**
	 * Metodo para selecionar um Item
	 * @param voId
	 * @return
	 */
	public T selecionar(int voId) {
		return model.selecionar(voId);
	}
}
