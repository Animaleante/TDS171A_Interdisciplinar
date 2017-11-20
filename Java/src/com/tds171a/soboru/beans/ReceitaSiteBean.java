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
import com.tds171a.soboru.vos.Comentario;
import com.tds171a.soboru.vos.Ingrediente;
import com.tds171a.soboru.vos.Medida;
import com.tds171a.soboru.vos.Receita;
import com.tds171a.soboru.vos.ReceitaIngrediente;
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
	private IngredienteController ingredienteController;
	private MedidaController medidaController;
	private ReceitaIngredienteController receitaIngredienteController;
	private UtensilioController utensilioController;
	private ComentarioController comentarioController;
	
	private List<ReceitaIngrediente> listaIngredientes;
	private List<Utensilio> listaUtensilios;

	private List<Categoria> categorias;
	private List<Ingrediente> ingredientes;
	private List<Medida> medidas;
	private List<Utensilio> utensilios;
	

	private Part imgFile;

	/**
	 * Construtor setando a rota e qual ser� passado para o navegador.
	 */
	public ReceitaSiteBean() {
		route_base = "/receita/";
		controller = new ReceitaController();

		categoriaController = new CategoriaController();
		usuarioController = new UsuarioController();
		ingredienteController = new IngredienteController();
		medidaController = new MedidaController();
		receitaIngredienteController = new ReceitaIngredienteController();
		utensilioController = new UtensilioController();
		comentarioController = new ComentarioController();

		setVo(new Receita());
		setListaIngredientes(new ArrayList<ReceitaIngrediente>());
		setIngredientes(new ArrayList<Ingrediente>());
		setMedidas(new ArrayList<Medida>());
	}

	/**
	 * recebe listas de controllers especificas para passar ao cliente e ele
	 * selecionar quais anexar na receita.
	 */
	@Override
	public String criar() {
		if(SessionContext.getInstance().isLogado()) {
			setCategorias(categoriaController.listarSelecionaveis());
			setIngredientes(ingredienteController.listar());
			setMedidas(medidaController.listar());
			setUtensilios(utensilioController.listar());
			return super.criar();
		}
		return "/login/"+BeanBase.INDEX_PAGE+BeanBase.FACES_REDIRECT;
	}

	public void adicionarReceitaIngrediente() {
		listaIngredientes.add(new ReceitaIngrediente());
		
	}

	public void removerReceitaIngrediente(ReceitaIngrediente receitaIngrediente) {
		listaIngredientes.remove(receitaIngrediente);
	}

	public void adicionarUtensilio() {
		listaUtensilios.add(new Utensilio());
		
	}

	public void removerUtensilio(Utensilio utensilio) {
		listaUtensilios.remove(utensilio);
	}

	/**
	 * POST do criar, onde � verificado a sess�o e se v�lida gera a inclus�o da
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

//		return super.incluir();
		
	    if(!validarDados())
	    	return route_base + CRIAR_PAGE;

	    if(controller.incluir(getVo())) {
	    	try {
		    	int receitaId = ((ReceitaController) controller).selecionarUltimoIdInserido();
		    	System.out.println("ReceitaId: " + receitaId);
				receitaIngredienteController.incluirLista(receitaId, getListaIngredientes());
				((ReceitaController) controller).registrarUtensilios(receitaId, getListaUtensilios());
	    	} catch (Exception e) {
				e.printStackTrace();
			}
			
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso!", null));
	    } else {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nao foi possivel fazer o cadastro!", null));
            return route_base + CRIAR_PAGE;
	    }

	    limparVo();

	    return listar();
	}

	/**
	 * Override do exibir, onde recebe o id de todas as controllers e exibe a
	 * receita ao cliente.
	 */
	@Override
	public String exibir(Receita vo) {
		System.out.println("Exibir");
		vo = controller.selecionar(vo.getId());

		if (vo.getCategoria() == null)
			vo.setCategoria(categoriaController.selecionar(vo.getCategoriaId()));

		if (vo.getUsuario() == null)
			vo.setUsuario(usuarioController.selecionar(vo.getUsuarioId()));
			
		if (vo.getUtensilios() == null)
 			vo.setUtensilios(utensilioController.selecionarPorReceita(vo.getId()));
 
 		if (vo.getReceitaIngredientes() == null)
 			vo.setReceitaIngredientes(receitaIngredienteController.selecionarPorReceita(vo.getId()));
 
 		if (vo.getComentarios() == null)
 			vo.setComentarios(comentarioController.selecionarPorReceita(vo.getId()));

		if (vo.getUsuariosFavoritaram() == null)
			vo.setUsuariosFavoritaram(usuarioController.selecionarUsuariosQueFavoritaram(vo.getId()));

		if (SessionContext.getInstance().isLogado()) {
			Usuario usuario = SessionContext.getInstance().getUsuarioLogado();
			vo.setReportou(usuarioController.reportou(usuario.getId(), vo.getId()));
			vo.setPontuou(usuarioController.pontuou(usuario.getId(), vo.getId()));	
		}
		
		return super.exibir(vo);
	}

	/**
	 * Override do deletar, onde verifica a sessao, se existe um �tem v�lido e se
	 * n�o houver, retorna a pagina de cria��o.
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
	 * Verifica os dados da pagina de intera��o e se faltar algum dado informa ao
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
		setListaIngredientes(new ArrayList<ReceitaIngrediente>());
		adicionarReceitaIngrediente();
		setListaUtensilios(new ArrayList<Utensilio>());
		adicionarUtensilio();
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

	/**
	 * @return the listaIngredientes
	 */
	public List<ReceitaIngrediente> getListaIngredientes() {
		return listaIngredientes;
	}

	/**
	 * @param listaIngredientes the listaIngredientes to set
	 */
	public void setListaIngredientes(List<ReceitaIngrediente> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

	/**
	 * @return the listaUtensilios
	 */
	public List<Utensilio> getListaUtensilios() {
		return listaUtensilios;
	}

	/**
	 * @param listaUtensilios the listaUtensilios to set
	 */
	public void setListaUtensilios(List<Utensilio> listaUtensilios) {
		this.listaUtensilios = listaUtensilios;
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
	 * @return the ingredientes
	 */
	public List<SelectItem> getIngredientes() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		for (Ingrediente i : this.ingredientes) {
			items.add(new SelectItem(i.getId(), i.getNome()));
		}
		return items;
	}

	/**
	 * @param ingredientes the ingredientes to set
	 */
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	/**
	 * @return the medidas
	 */
	public List<SelectItem> getMedidas() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		for (Medida m : this.medidas) {
			items.add(new SelectItem(m.getId(), m.getNome()));
		}
		return items;
	}

	/**
	 * @param medidas the medidas to set
	 */
	public void setMedidas(List<Medida> medidas) {
		this.medidas = medidas;
	}

	/**
	 * @return the utensilios
	 */
	public List<SelectItem> getUtensilios() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		for (Utensilio u : this.utensilios) {
			items.add(new SelectItem(u.getId(), u.getNome()));
		}
		return items;
	}

	/**
	 * @param utensilios the utensilios to set
	 */
	public void setUtensilios(List<Utensilio> utensilios) {
		this.utensilios = utensilios;
	}
}
