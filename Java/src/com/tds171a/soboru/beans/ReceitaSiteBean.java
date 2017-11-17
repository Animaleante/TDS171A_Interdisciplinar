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
import com.tds171a.soboru.controllers.PontuacaoController;
import com.tds171a.soboru.controllers.ReceitaController;
import com.tds171a.soboru.controllers.ReceitaIngredienteController;
import com.tds171a.soboru.controllers.ReportController;
import com.tds171a.soboru.controllers.TagController;
import com.tds171a.soboru.controllers.UsuarioController;
import com.tds171a.soboru.controllers.UtensilioController;
import com.tds171a.soboru.utils.Utils;
import com.tds171a.soboru.vos.Categoria;
import com.tds171a.soboru.vos.Ingrediente;
import com.tds171a.soboru.vos.Medida;
import com.tds171a.soboru.vos.Receita;
import com.tds171a.soboru.vos.Tag;
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
	private UtensilioController utensilioController;
	private TagController tagController;
	private ComentarioController comentarioController;
	private ReceitaIngredienteController receitaIngredienteController;
	private IngredienteController ingredienteController;
	private MedidaController medidaController;
	private ReportController reportController;
	private PontuacaoController pontuacaoController;

	private List<Categoria> categorias;
	private List<Ingrediente> ingredientes;
	private List<Medida> medidas;
	private List<Utensilio> utensilios;
	private List<Tag> tags;
	
	private Part imgFile;

	/**
     *Construtor setando a rota e qual
     *será passado para o navegador.
     */
	public ReceitaSiteBean() {
		route_base = "/receita/";
		controller = new ReceitaController();
		
		categoriaController = new CategoriaController();
		usuarioController = new UsuarioController();
		utensilioController = new UtensilioController();
		tagController = new TagController();
		comentarioController = new ComentarioController();
		receitaIngredienteController = new ReceitaIngredienteController();
		ingredienteController = new IngredienteController();
		medidaController = new MedidaController();
		reportController = new ReportController();
		pontuacaoController = new PontuacaoController();
		
		setVo(new Receita());
	}

	/**
	 * recebe listas de controllers especificas
	 * para passar ao cliente e ele selecionar 
	 * quais anexar na receita.
	 */
	@Override
	public String criar() {
		setCategorias(categoriaController.listar());
		setIngredientes(ingredienteController.listar());
		setMedidas(medidaController.listar());
		setUtensilios(utensilioController.listar());
		setTags(tagController.listar());

		return super.criar();
	}
	
	/**
	 * POST do criar, onde é verificado a sessão
	 * e se válida gera a inclusão da receita.
	 */
	@Override
	public String incluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		getVo().setUsuarioId(SessionContext.getInstance().getUsuarioLogado().getId());
		getVo().setSlug(Utils.toSlug(getVo().getNome()));
		getVo().setAprovado(false);
		
		try (InputStream input = imgFile.getInputStream()) {
			File file = File.createTempFile("receita_",  ".jpg", new File(System.getProperty("jboss.server.data.dir"), "images"));
			// TODO - Se pasta não existe, criar ela
			Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			getVo().setImgPath(file.getName());
		} catch (IOException e) {
			e.printStackTrace();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao tentar fazer upload da imagem: " + e.getMessage(), null));
            return route_base + CRIAR_PAGE;
		}
		
		return super.incluir();
	}
	
	/**
	 * Override do exibir, onde recebe o id de todas as controllers
	 * e exibe a receita ao cliente.
	 */
	@Override
	public String exibir(Receita vo) {
		vo = controller.selecionar(vo.getId());
		
		if(vo.getCategoria() == null)
			vo.setCategoria(categoriaController.selecionar(vo.getCategoriaId()));
		
		if(vo.getUsuario() == null)
			vo.setUsuario(usuarioController.selecionar(vo.getUsuarioId()));
		
		if(vo.getUtensilios() == null)
			vo.setUtensilios(utensilioController.selecionarPorReceita(vo.getId()));
		
		if(vo.getTags() == null)
			vo.setTags(tagController.selecionarPorReceita(vo.getId()));
		
		if(vo.getReceitaIngredientes() == null)
			vo.setReceitaIngredientes(receitaIngredienteController.selecionarPorReceita(vo.getId()));
		
		if(vo.getComentarios() == null)
			vo.setComentarios(comentarioController.selecionarPorReceita(vo.getId()));
		
		if(vo.getUsuariosFavoritaram() == null)
			vo.setUsuariosFavoritaram(usuarioController.selecionarUsuariosQueFavoritaram(vo.getId()));
		
		return super.exibir(vo);
	}

	/**
     * Override do deletar, onde verifica a sessao, 
     * se existe um ítem válido e se não houver, retorna a 
     * pagina de criação.
     */
	@Override
	public String deletar() {
	    FacesContext context = FacesContext.getCurrentInstance();

	    if(getVo().getId() == -1) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Item nao pode ser vazio!", null));
	        return route_base + DELETAR_PAGE;
	    }

		if(controller.remover(getVo().getId())) {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado com sucesso!", null));
	    } else {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nao foi possivel deletar.", null));
            return route_base + DELETAR_PAGE;
		}

		limparVo();

	    return listar();
	}

	/**
	 * Verifica os dados da pagina de interação e se faltar algum dado 
	 * informa ao cliente.
	 */
	@Override
	public boolean validarDados() {
		FacesContext context = FacesContext.getCurrentInstance();

		if(getVo().getNome().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
	        return false;
	    }

		return true;
	}

	/**
	 * Cria uma nova vo para limpar os campos para um novo registro
	 * sem interferencia de dados cadastrados anteriormente.
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
		if(SessionContext.getInstance().isLogado()) {
			// TODO - adicionar as receitas favoritas desse usuario
			getVo().getUsuariosFavoritaram().add(SessionContext.getInstance().getUsuarioLogado());
			// TODO - pegar receita novamente com novos dados
			return exibir(getVo());
		}
		
		return "/login/"+INDEX_PAGE+FACES_REDIRECT;
	}
	
	/**
	 * 
	 * @return
	 */
	public String reportar() {
		if(SessionContext.getInstance().isLogado()) {
			// TODO - criar report desse usuario para essa receita
			return exibir(getVo());
		}
		
		return "/login/"+INDEX_PAGE+FACES_REDIRECT;
	}
	
	/**
	 * 
	 * @param pontos
	 * @return
	 */
	public String pontuar(double pontos) {
		if(SessionContext.getInstance().isLogado()) {
			// TODO - adicionar pontuacao a essa receita atrelada a esse usuario, e recalcular pontuacao_media da receita
			// TODO - pegar receita novamente com novos dados
			return exibir(getVo());
		}
		
		return "/login/"+INDEX_PAGE+FACES_REDIRECT;
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
	 * @param categorias the categorias to set
	 */
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	/**
	 * @return the ingredientes
	 */
	public List<SelectItem> getIngredientes() {
		List<SelectItem> items = new ArrayList<SelectItem>();
	    for (Ingrediente c : this.ingredientes) {
	        items.add(new SelectItem(c.getId(), c.getNome()));
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
	    for (Medida c : this.medidas) {
	        items.add(new SelectItem(c.getId(), c.getNome()));
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
	    for (Utensilio c : this.utensilios) {
	        items.add(new SelectItem(c.getId(), c.getNome()));
	    }
	    return items;
	}

	/**
	 * @param utensilios the utensilios to set
	 */
	public void setUtensilios(List<Utensilio> utensilios) {
		this.utensilios = utensilios;
	}

	/**
	 * @return the tags
	 */
	public List<Tag> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	/**
	 * @return the imgFile
	 */
	public Part getImgFile() {
		return imgFile;
	}

	/**
	 * @param imgFile the imgFile to set
	 */
	public void setImgFile(Part imgFile) {
		this.imgFile = imgFile;
	}
}
