package com.tds171a.soboru.models.receita;

import java.util.List;

import com.tds171a.soboru.models.ModelBase;
import com.tds171a.soboru.vos.Receita;
import com.tds171a.soboru.vos.Tag;

public class ReceitaModel extends ModelBase<Receita> {
	
	/**
	 * Construtor da classe MedidaModel
	 */
	public ReceitaModel() {
		dao = new ReceitaDAO();
	}

	public boolean incluirTag(Receita receita, Tag tag) {
		return ((ReceitaDAO) dao).incluirTag(receita, tag);
	}

	public List<Tag> listarTags(Receita receita) {
		return ((ReceitaDAO) dao).listarTags(receita);
	}
}
