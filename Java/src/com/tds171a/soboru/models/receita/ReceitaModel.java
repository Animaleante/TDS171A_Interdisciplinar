package com.tds171a.soboru.models.receita;

import com.tds171a.soboru.models.ModelBase;
import com.tds171a.soboru.vos.Receita;

public class ReceitaModel extends ModelBase<Receita> {
	
	/**
	 * Construtor da classe MedidaModel
	 */
	public ReceitaModel() {
		dao = new ReceitaDAO();
	}
}
