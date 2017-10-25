package com.tds171a.soboru.views;

import java.util.List;

import com.tds171a.soboru.controllers.IngredienteController;
import com.tds171a.soboru.utils.Leitor;
import com.tds171a.soboru.vos.Ingrediente;

/**
 * Classe de view do Ingrediente 
 * @author Diogo
 *
 */
public class IngredienteView {
	
	/**
	 * Parâmetro de controller do Ingrediente
	 */
	private IngredienteController controller;
	
	/**
	 * Construtor da view de Ingrediente
	 */
	public IngredienteView() {
		controller = new IngredienteController();
		
		while (menu() != 9) {
		}
	}
	
	/**
	 * Método de escrita do menu para Ingrediente
	 * @return
	 */
	private int menu() {
		System.out.println(" --- Menu ---");

		System.out.println("1 - Incluir Ingrediente");
		System.out.println("2 - Listar Ingredientes");
		System.out.println("3 - Atualizar Ingrediente");
		System.out.println("4 - Deletar Ingrediente");
		System.out.println("9 - Sair");

		int op = -1;
		op = Leitor.readInt();

		switch (op) {
			case 1:
				incluir();
				break;
			case 2:
				listar();
				break;
			case 3:
				atualizar();
				break;
			case 4:
				remover();
				break;
			case 9:
				break;
			default:
				System.out.println("Opcao escolhida invalida!\n");
				break;
		}

		return op;
	}
	
	/**
	 * Método para incluir um novo Ingrediente
	 */
	private void incluir() {
		String nome = "";
		
		nome = Leitor.readString("Digite o nome do ingrediente: ");
		
		Ingrediente ingrediente = new Ingrediente(nome);
		
		System.out.println("Incluindo...");
		if(controller.incluir(ingrediente))
			System.out.println("Ingrediente incluido com sucesso!");
		else 
			System.out.println("Não foi possivel inserir esse ingrediente.");
	}
	
	/**
	 * Método para listar os Ingredientes
	 */
	private void listar() {
		List<Ingrediente> list = controller.listar();
		
		if(list == null) {
			System.out.println("Houve um erro ao tentar listar os ingredientes.");
		} else if(list.isEmpty()) {
			System.out.println("A lista de ingredientes esta vazia.");
		} else {
			System.out.println("Lista de ingredientes:");
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println("Ingrediente #"+list.get(i).getId()+": " + list.get(i).getNome());
			}
			
			System.out.println("");
		}
	}
	
	/**
	 * Método para atualizar um Ingrediente já cadastrado
	 */
	private void atualizar() {
		int id = -1;
		String nome = "";
		
		id = Leitor.readInt("Digite o id do ingrediente a ser modificado: ");
		nome = Leitor.readString("Digite o novo nome do ingrediente: ");
		
		Ingrediente ingrediente = new Ingrediente(id, nome);
		
		System.out.println("Atualizando...");
		if(controller.atualizar(ingrediente))
			System.out.println("Ingrediente atualizado com sucesso!");
		else 
			System.out.println("Não foi possivel atualizar esse ingrediente.");
	}
	
	/**
	 * Método para remover um Ingrediente
	 */
	private void remover() {
		int id = -1;

		id = Leitor.readInt("Digite o id do ingrediente a ser removido: ");

		System.out.println("Removendo...");
		if(controller.remover(id))
			System.out.println("Ingrediente removido com sucesso!");
		else 
			System.out.println("Não foi possivel remover esse ingrediente.");
	}
}
