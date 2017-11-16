package com.tds171a.soboru.models.receita;

import java.util.List;

import com.tds171a.soboru.models.ModelBase;
import com.tds171a.soboru.vos.Receita;

public class ReceitaModel extends ModelBase<Receita> {
	
	/**
	 * Construtor da classe MedidaModel
	 */
	public ReceitaModel() {
		dao = new ReceitaDAO();
	}

	public List<Receita> selecionarPorNome(String termoBusca) {
		return ((ReceitaDAO) dao).selecionarPorNome(termoBusca);
	}
}
