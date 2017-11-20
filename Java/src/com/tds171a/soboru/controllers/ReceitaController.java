/**
 * 
 */
package com.tds171a.soboru.controllers;

import java.util.List;

import com.tds171a.soboru.models.receita.ReceitaModel;
import com.tds171a.soboru.vos.Ingrediente;
import com.tds171a.soboru.vos.Receita;
import com.tds171a.soboru.vos.ReceitaIngrediente;
import com.tds171a.soboru.vos.Tag;
import com.tds171a.soboru.vos.Utensilio;

/**
 * Classe de controller da receita
 * @author Diogo
 *
 */
public class ReceitaController extends ControllerBase<Receita>{

	/**
     * Construtor da classe de controller da receita
     */
    public ReceitaController() {
        model = new ReceitaModel();
    }
	
	public int selecionarUltimoIdInserido() {
		return ((ReceitaModel) model).selecionarUltimoIdInserido();
	}
	
	public List<Receita> listarAdmin() {
		return ((ReceitaModel) model).listarAdmin();
	}
    
    public boolean incluirTag(Receita receita, Tag tag) {
    	return ((ReceitaModel) model).incluirTag(receita, tag);
    }

	public List<Utensilio> listarUtensilios(Receita receita) {
		return ((ReceitaModel) model).listarUtensilios(receita);
	}

	public List<Receita> selecionarPorNome(String termoBusca) {
		return ((ReceitaModel) model).selecionarPorNome(termoBusca);
	}
	
	public List<Receita> selecionarPorIngredientes(List<Ingrediente> ingredientes) {
		return ((ReceitaModel) model).selecionarPorIngredientes(ingredientes);
	}

	public List<Receita> selecionarPorNomeEIngredientes(String termoBusca, List<Ingrediente> ingredientes) {
		return ((ReceitaModel) model).selecionarPorNomeEIngredientes(termoBusca, ingredientes);
	}

	public void registrarUtensilios(int receitaId, List<Utensilio> lista) {
		((ReceitaModel) model).registrarUtensilios(receitaId, lista);
	}

	public List<ReceitaIngrediente> listarIngredientes(Receita receita) {
		return ((ReceitaModel) model).listarIngredientes(receita);
	}

	public List<Receita> selecionarPorUsuario(int usuarioId) {
		return ((ReceitaModel) model).selecionarPorUsuario(usuarioId);
	}

	public List<Receita> selecionarPorFavoritosDeUsuario(int usuarioId) {
		return ((ReceitaModel) model).selecionarPorFavoritosDeUsuario(usuarioId);
	}
	
	public boolean incluirFavorito(int receitaId, int usuarioId) {
		boolean sucesso = ((ReceitaModel) model).incluirFavorito(receitaId, usuarioId);
		atualizarFavs(receitaId);
		return sucesso;
	}

	public boolean removerFavorito(int receitaId, int usuarioId) {
		boolean sucesso = ((ReceitaModel) model).removerFavorito(receitaId, usuarioId);
		atualizarFavs(receitaId);
		return sucesso;
	}

	public boolean isReceitaFavoritada(int receitaId, int usuarioId) {
		return ((ReceitaModel) model).isReceitaFavoritada(receitaId, usuarioId);
	}

	public boolean incluirReport(int receitaId, int usuarioId) {
		return ((ReceitaModel) model).incluirReport(receitaId, usuarioId);
		
	}

	public boolean incluirPontuacao(int receitaId, int usuarioId, int pontos) {
		boolean sucesso = ((ReceitaModel) model).incluirPontuacao(receitaId, usuarioId, pontos);
		atualizarPontuacaoMedia(receitaId);
		return sucesso;
	}
	
	public void atualizarFavs(int receitaId) {
		((ReceitaModel) model).atualizarFavs(receitaId);
	}
	
	public void atualizarPontuacaoMedia(int receitaId) {
		((ReceitaModel) model).atualizarPontuacaoMedia(receitaId);
	}
}
