/**
 * 
 */
package com.tds171a.soboru.beans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.servlet.http.Part;

import com.tds171a.soboru.controllers.CategoriaController;
import com.tds171a.soboru.controllers.ComentarioController;
import com.tds171a.soboru.controllers.IngredienteController;
import com.tds171a.soboru.controllers.MedidaController;
import com.tds171a.soboru.controllers.ReceitaController;
import com.tds171a.soboru.controllers.ReceitaIngredienteController;
import com.tds171a.soboru.controllers.UsuarioController;
import com.tds171a.soboru.controllers.UtensilioController;
import com.tds171a.soboru.utils.Utils;
import com.tds171a.soboru.vos.Categoria;
import com.tds171a.soboru.vos.Ingrediente;
import com.tds171a.soboru.vos.Medida;
import com.tds171a.soboru.vos.Receita;
import com.tds171a.soboru.vos.Tag;
import com.tds171a.soboru.vos.Usuario;
import com.tds171a.soboru.vos.Utensilio;

@Named("receitaSiteBean")
@SessionScoped
/**
 * @author Diogo
 *
 */
public class ReceitaSiteBean extends BeanBase<Receita> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5362181648251196256L;
	
	private CategoriaController categoriaController;
	private UsuarioController usuarioController;

	private List<Categoria> categorias;

	private Part imgFile;

	/**
	 * Construtor setando a rota e qual será passado para o navegador.
	 */
	public ReceitaSiteBean() {
		route_base = "/receita/";
		controller = new ReceitaController();

		categoriaController = new CategoriaController();
		usuarioController = new UsuarioController();

		setVo(new Receita());
	}

	/**
	 * recebe listas de controllers especificas para passar ao cliente e ele
	 * selecionar quais anexar na receita.
	 */
	@Override
	public String criar() {
		setCategorias(categoriaController.listar());

		return super.criar();
	}

	/**
	 * POST do criar, onde é verificado a sessão e se válida gera a inclusão da
	 * receita.
	 */
	@Override
	public String incluir() {
		FacesContext context = FacesContext.getCurrentInstance();

		getVo().setUsuarioId(SessionContext.getInstance().getUsuarioLogado().getId());
		getVo().setSlug(Utils.toSlug(getVo().getNome()));
		getVo().setAprovado(false);

		try (InputStream input = imgFile.getInputStream()) {
			File file = File.createTempFile("receita_", ".jpg", Utils.getImagerDir());
			Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			getVo().setImgPath(file.getName());
		} catch (IOException e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro ao tentar fazer upload da imagem: " + e.getMessage(), null));
			return route_base + CRIAR_PAGE;
		}

		return super.incluir();
	}

	/**
	 * Override do exibir, onde recebe o id de todas as controllers e exibe a
	 * receita ao cliente.
	 */
	@Override
	public String exibir(Receita vo) {
		vo = controller.selecionar(vo.getId());

		if (vo.getCategoria() == null)
			vo.setCategoria(categoriaController.selecionar(vo.getCategoriaId()));

		if (vo.getUsuario() == null)
			vo.setUsuario(usuarioController.selecionar(vo.getUsuarioId()));

		if (vo.getUsuariosFavoritaram() == null)
			vo.setUsuariosFavoritaram(usuarioController.selecionarUsuariosQueFavoritaram(vo.getId()));

		if (SessionContext.getInstance().isLogado()) {
			Usuario usuario = SessionContext.getInstance().getUsuarioLogado();
			vo.setReportou(usuarioController.reportou(usuario.getId(), vo.getId()));
			vo.setPontuou(usuarioController.pontuou(usuario.getId(), vo.getId()));
		}

		try{
			System.out.println(vo.getComentarios().size());
		}catch (Exception e) {
			System.out.println("Erro coment size");
		}
		return super.exibir(vo);
	}

	/**
	 * Override do deletar, onde verifica a sessao, se existe um ítem válido e se
	 * não houver, retorna a pagina de criação.
	 */
	@Override
	public String deletar() {
		FacesContext context = FacesContext.getCurrentInstance();

		if (getVo().getId() == -1) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Item nao pode ser vazio!", null));
			return route_base + DELETAR_PAGE;
		}

		if (controller.remover(getVo().getId())) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado com sucesso!", null));
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nao foi possivel deletar.", null));
			return route_base + DELETAR_PAGE;
		}

		limparVo();

		return listar();
	}

	/**
	 * Verifica os dados da pagina de interação e se faltar algum dado informa ao
	 * cliente.
	 */
	@Override
	public boolean validarDados() {
		FacesContext context = FacesContext.getCurrentInstance();

		if (getVo().getNome().isEmpty()) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
			return false;
		}

		return true;
	}

	/**
	 * Cria uma nova vo para limpar os campos para um novo registro sem
	 * interferencia de dados cadastrados anteriormente.
	 */
	@Override
	public void limparVo() {
		setVo(new Receita());
	}

	/**
	 * 
	 * @return
	 */
	public String favoritar() {
		if (SessionContext.getInstance().isLogado()) {
			if(!isReceitaFavoritada()) {
				((ReceitaController) controller).incluirFavorito(getVo().getId(), SessionContext.getInstance().getUsuarioLogado().getId());
				getVo().getUsuariosFavoritaram().add(SessionContext.getInstance().getUsuarioLogado());
			} else {
				((ReceitaController) controller).removerFavorito(getVo().getId(), SessionContext.getInstance().getUsuarioLogado().getId());
				// TODO - check if this is working
				getVo().getUsuariosFavoritaram().remove(SessionContext.getInstance().getUsuarioLogado());
			}

			return exibir(getVo());
		}

		return "/login/" + INDEX_PAGE + FACES_REDIRECT;
	}

	/**
	 * 
	 * @return
	 */
	public String reportar() {
		if (SessionContext.getInstance().isLogado()) {
			((ReceitaController) controller).incluirReport(getVo().getId(), SessionContext.getInstance().getUsuarioLogado().getId());
			return exibir(getVo());
		}

		return "/login/" + INDEX_PAGE + FACES_REDIRECT;
	}

	/**
	 * 
	 * @param pontos
	 * @return
	 */
	public String pontuar(int pontos) {
		if (SessionContext.getInstance().isLogado()) {
			((ReceitaController) controller).incluirPontuacao(getVo().getId(), SessionContext.getInstance().getUsuarioLogado().getId(), pontos);
			return exibir(getVo());
		}

		return "/login/" + INDEX_PAGE + FACES_REDIRECT;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isReceitaFavoritada() {
		if(SessionContext.getInstance().isLogado()) {
//			return ((ReceitaController) controller).isReceitaFavoritada(getVo().getId(), SessionContext.getInstance().getUsuarioLogado().getId());
			boolean favoritada = false;
			int usuarioLogadoId = SessionContext.getInstance().getUsuarioLogado().getId();
			List<Usuario> usuariosFavoritaram = getVo().getUsuariosFavoritaram();
			for (int i = 0; i < getVo().getUsuariosFavoritaram().size(); i++) {
				if(usuariosFavoritaram.get(i).getId() == usuarioLogadoId) {
					favoritada = true;
					break;
				}
			}
			
			return favoritada;
		}
		return false;
	}
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public String formatDouble(Double num) {
		return Utils.formatDouble(num);
	}

	/**
	 * @return the categorias
	 */
	public List<SelectItem> getCategorias() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		for (Categoria c : this.categorias) {
			items.add(new SelectItem(c.getId(), c.getNome()));
		}
		return items;
	}

	/**
	 * @param categorias
	 *            the categorias to set
	 */
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	/**
	 * @return the imgFile
	 */
	public Part getImgFile() {
		return imgFile;
	}

	/**
	 * @param imgFile
	 *            the imgFile to set
	 */
	public void setImgFile(Part imgFile) {
		this.imgFile = imgFile;
	}
}
