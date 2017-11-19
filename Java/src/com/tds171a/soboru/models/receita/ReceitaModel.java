package com.tds171a.soboru.models.receita;

import java.util.List;

import com.tds171a.soboru.models.ModelBase;
import com.tds171a.soboru.vos.Receita;
import com.tds171a.soboru.vos.ReceitaIngrediente;
import com.tds171a.soboru.vos.Tag;
import com.tds171a.soboru.vos.Utensilio;

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

	public List<Utensilio> listarUtensilios(Receita receita) {
		return ((ReceitaDAO) dao).listarUtensilios(receita);
	}
	
	public List<Receita> selecionarPorNome(String termoBusca) {
		return ((ReceitaDAO) dao).selecionarPorNome(termoBusca);
	}
	
	public List<Receita> selecionarPorIngredientes(List<Integer> ingredientes) {
		return ((ReceitaDAO) dao).selecionarPorIngredientes(ingredientes);
	}

	public List<Receita> selecionarPorNomeEIngredientes(String termoBusca, List<Integer> ingredientes) {
		return ((ReceitaDAO) dao).selecionarPorNomeEIngredientes(termoBusca, ingredientes);
	}

	public void registrarUtensilios(int receitaId, List<Utensilio> lista) {
		((ReceitaDAO) dao).registrarUtensilios(receitaId, lista);
	}

	public List<ReceitaIngrediente> listarIngredientes(Receita receita) {
		return ((ReceitaDAO) dao).listarIngredientes(receita);
	}
}
