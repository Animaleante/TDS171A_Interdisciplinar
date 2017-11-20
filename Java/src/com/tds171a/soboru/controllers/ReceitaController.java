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
	
    /**
     * Retorna o id do �ltimo inserido.
     * modelo por cast.
     * @return
     */
	public int selecionarUltimoIdInserido() {
		return ((ReceitaModel) model).selecionarUltimoIdInserido();
	}
	
	/**
     * Retorna uma lista para o admin do site
     * onde apresenta todas as receitas mesmo
     * n�o estando liberadas.
     * modelo por cast.
     * @return
     */
	public List<Receita> listarAdmin() {
		return ((ReceitaModel) model).listarAdmin();
	}
    
	/**
     * Retorna uma lista de tags da receita.
     * modelo por cast.
     * @return
     */
    public boolean incluirTag(Receita receita, Tag tag) {
    	return ((ReceitaModel) model).incluirTag(receita, tag);
    }

    /**
     * Retorna uma lista de utensilios
     * modelo por cast.
     * @return
     */
	public List<Utensilio> listarUtensilios(Receita receita) {
		return ((ReceitaModel) model).listarUtensilios(receita);
	}

	/**
     * Efetua a pesquisa pelo nome da receita
     * passado pelo cliente
     * @param termoBusca
     * @return
     */
	public List<Receita> selecionarPorNome(String termoBusca) {
		return ((ReceitaModel) model).selecionarPorNome(termoBusca);
	}
	
	/**
	 * Retorna uma lista de receitas pesquisado
	 * por uma lista de ingredientes.
	 * @param ingredientes
	 * @return
	 */
	public List<Receita> selecionarPorIngredientes(List<Ingrediente> ingredientes) {
		return ((ReceitaModel) model).selecionarPorIngredientes(ingredientes);
	}

	/**
	 * Retorna uma lista de receitas quando
	 * pesquisa por nome e ingrediente.
	 * @param termoBusca
	 * @param ingredientes
	 * @return
	 */
	public List<Receita> selecionarPorNomeEIngredientes(String termoBusca, List<Ingrediente> ingredientes) {
		return ((ReceitaModel) model).selecionarPorNomeEIngredientes(termoBusca, ingredientes);
	}

	/**
	 * M�todo que recebe uma lista de utensilios e o
	 * id da receita e liga a lista no id da receita.
	 * @param receitaId
	 * @param lista
	 */
	public void registrarUtensilios(int receitaId, List<Utensilio> lista) {
		((ReceitaModel) model).registrarUtensilios(receitaId, lista);
	}

	/**
	 * Recebe uma lista de ingredientes cadastrados na receita
	 * atual.
	 * @param receita
	 * @return
	 */
	public List<ReceitaIngrediente> listarIngredientes(Receita receita) {
		return ((ReceitaModel) model).listarIngredientes(receita);
	}

	/**
	 * Retorna uma lista de receitas do usu�rio
	 * @param usuarioId
	 * @return
	 */
	public List<Receita> selecionarPorUsuario(int usuarioId) {
		return ((ReceitaModel) model).selecionarPorUsuario(usuarioId);
	}

	/**
	 * Retorna uma lista de receitas favoritadas
	 * pelo usu�rio
	 * @param usuarioId
	 * @return
	 */
	public List<Receita> selecionarPorFavoritosDeUsuario(int usuarioId) {
		return ((ReceitaModel) model).selecionarPorFavoritosDeUsuario(usuarioId);
	}
	
	/**
	 * M�todo que inclui a receita nos favoritos.
	 * @param receitaId
	 * @param usuarioId
	 * @return
	 */
	public boolean incluirFavorito(int receitaId, int usuarioId) {
		boolean sucesso = ((ReceitaModel) model).incluirFavorito(receitaId, usuarioId);
		atualizarFavs(receitaId);
		return sucesso;
	}

	/**
	 * M�todo que remove a receita dos favoritos
	 * do usu�rio
	 * @param receitaId
	 * @param usuarioId
	 * @return
	 */
	public boolean removerFavorito(int receitaId, int usuarioId) {
		boolean sucesso = ((ReceitaModel) model).removerFavorito(receitaId, usuarioId);
		atualizarFavs(receitaId);
		return sucesso;
	}

	/**
	 * Verifica se a receita aberta � um favorito
	 * e retorna um boolean para alterar o icone
	 * da p�gina.
	 * @param receitaId
	 * @param usuarioId
	 * @return
	 */
	public boolean isReceitaFavoritada(int receitaId, int usuarioId) {
		return ((ReceitaModel) model).isReceitaFavoritada(receitaId, usuarioId);
	}

	/**
	 * M�todo que efetua o report da receita se houver algum
	 * erro.
	 * @param receitaId
	 * @param usuarioId
	 * @return
	 */
	public boolean incluirReport(int receitaId, int usuarioId) {
		return ((ReceitaModel) model).incluirReport(receitaId, usuarioId);
		
	}

	/**
	 * M�todo que efetua a pontua��o da receita, 
	 * recebendo o id da receita, id do usu�rio e a 
	 * pontua��o.
	 * @param receitaId
	 * @param usuarioId
	 * @param pontos
	 * @return
	 */
	public boolean incluirPontuacao(int receitaId, int usuarioId, int pontos) {
		boolean sucesso = ((ReceitaModel) model).incluirPontuacao(receitaId, usuarioId, pontos);
		atualizarPontuacaoMedia(receitaId);
		return sucesso;
	}
	
	/**
	 * M�todo que atualiza os favoritos do
	 * usu�rio, setando quantas receitas ele
	 * favoritou
	 * @param receitaId
	 */
	public void atualizarFavs(int receitaId) {
		((ReceitaModel) model).atualizarFavs(receitaId);
	}
	
	/**
	 * M�todo que efetua a atualiza��o da m�dia 
	 * da receita, soamndo todos os valores e dividindo 
	 * pela quantidade de votos. 
	 * @param receitaId
	 */
	public void atualizarPontuacaoMedia(int receitaId) {
		((ReceitaModel) model).atualizarPontuacaoMedia(receitaId);
	}
}
