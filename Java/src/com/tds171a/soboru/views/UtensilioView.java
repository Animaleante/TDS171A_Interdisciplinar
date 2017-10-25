package com.tds171a.soboru.views;

import java.util.List;

import com.tds171a.soboru.controllers.UtensilioController;
import com.tds171a.soboru.utils.Leitor;
import com.tds171a.soboru.vos.Utensilio;

/**
 * Classe de view do Utensilio
 * @author Diogo
 *
 */
public class UtensilioView {
	
	/**
	 * Parâmetro de controller do Utensilio
	 */
	private UtensilioController controller;
	
	/**
	 * Construtor da view de Utensilio
	 */
	public UtensilioView() {
		controller = new UtensilioController();
		
		while (menu() != 9) {
		}
	}

	/**
	 * Método de escrita do menu para Utensilio
	 * @return
	 */
	private int menu() {
		System.out.println(" --- Menu ---");

		System.out.println("1 - Incluir Utensilio");
		System.out.println("2 - Listar Utensilios");
		System.out.println("3 - Atualizar Utensilio");
		System.out.println("4 - Deletar Utensilio");
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
	 * Método para incluir um novo Utensilio
	 */
	private void incluir() {
		String nome = "";
		
		nome = Leitor.readString("Digite o nome do utensilio: ");
		
		Utensilio utensilio = new Utensilio(nome);
		
		System.out.println("Incluindo...");
		if(controller.incluir(utensilio))
			System.out.println("Utensilio incluido com sucesso!");
		else 
			System.out.println("Não foi possivel inserir esse utensilio.");
	}

	/**
	 * Método para listar os Utensilios
	 */
	private void listar() {
		List<Utensilio> list = controller.listar();
		
		if(list == null) {
			System.out.println("Houve um erro ao tentar listar os utensilios.");
		} else if(list.isEmpty()) {
			System.out.println("A lista de utensilios esta vazia.");
		} else {
			System.out.println("Lista de utensilios:");
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println("Utensilio #"+list.get(i).getId()+": " + list.get(i).getNome());
			}
			
			System.out.println("");
		}
	}

	/**
	 * Método para atualizar um Utensilio já cadastrada
	 */
	private void atualizar() {
		int id = -1;
		String nome = "";
		
		id = Leitor.readInt("Digite o id do utensilio a ser modificado: ");
		nome = Leitor.readString("Digite o novo nome do utensilio: ");
		
		Utensilio utensilio = new Utensilio(id, nome);
		
		System.out.println("Atualizando...");
		if(controller.atualizar(utensilio))
			System.out.println("Utensilio atualizado com sucesso!");
		else 
			System.out.println("Não foi possivel atualizar esse utensilio.");
	}

	/**
	 * Método para remover um Utensilio
	 */
	private void remover() {
		int id = -1;

		id = Leitor.readInt("Digite o id do utensilio a ser removido: ");

		System.out.println("Removendo...");
		if(controller.remover(id))
			System.out.println("Utensilio removido com sucesso!");
		else 
			System.out.println("Não foi possivel remover esse utensilio.");
	}
}
