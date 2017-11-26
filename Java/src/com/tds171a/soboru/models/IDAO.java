package com.tds171a.soboru.models;

import java.util.List;

public interface IDAO<T> {
	//Lista de vari�veis abstratas.
	public boolean incluir(T vo);
	public List<T> listar();
	public boolean atualizar(T vo);
	public boolean remover(int voId);
	public T selecionar(int voId);
}
