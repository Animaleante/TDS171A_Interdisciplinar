package com.tds171a.soboru.views;

import java.util.List;

import com.tds171a.soboru.controllers.MedidaController;
import com.tds171a.soboru.utils.Leitor;
import com.tds171a.soboru.vos.Medida;

/**
 * Classe de view das Medidas 
 * @author Diogo
 *
 */
public class MedidaView {
	
	/**
	 * Parâmetro de controller do Medida
	 */
	private MedidaController controller;
	
	/**
	 * Construtor da view de Medidas
	 */
	public MedidaView() {
		controller = new MedidaController();

		while (menu() != 9) {
		}
	}
	
	/**
	 * Método de escrita do menu para Medida
	 * @return
	 */
	private int menu() {
		System.out.println(" --- Menu ---");

		System.out.println("1 - Incluir Medida");
		System.out.println("2 - Listar Medidas");
		System.out.println("3 - Atualizar Medida");
		System.out.println("4 - Deletar Medida");
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
	 * Método para incluir uma nova Medida
	 */
	private void incluir() {
		String nome = "";
		String abreveacao = "";

		nome = Leitor.readString("Digite o nome da Medida: ");
		abreveacao = Leitor.readString("Digite a abreveação: ");

		Medida medida = new Medida(nome,abreveacao);

		System.out.println("Incluindo...");
		if (controller.incluir(medida))
			System.out.println("Medida incluida com sucesso!");
		else
			System.out.println("Não foi possivel inserir essa medida.");
	}

	/**
	 * Método para listar as Medidas
	 */
	private void listar() {
		List<Medida> list = controller.listar();

		if (list == null) {
			System.out.println("Houve um erro ao tentar listar as medidas.");
		} else if (list.isEmpty()) {
			System.out.println("A lista de medidas esta vazia.");
		} else {
			System.out.println("Lista de medidas:");

			for (int i = 0; i < list.size(); i++) {
				System.out.println("Medida #" + list.get(i).getId() + ": " + list.get(i).getNome()+", abreveação: " + list.get(i).getAbreviacao());
			}

			System.out.println("");
		}
	}

	/**
	 * Método para atualizar uma Medida já cadastrada
	 */
	private void atualizar() {
		int id = -1;
		String nome = "";
		String abreveacao = "";

		id = Leitor.readInt("Digite o id da medida a ser modificada: ");
		nome = Leitor.readString("Digite o novo nome da medida: ");
		abreveacao = Leitor.readString("Digite uma nova abreveação: ");

		Medida medida = new Medida(id, nome,abreveacao);

		System.out.println("Atualizando...");
		if (controller.atualizar(medida))
			System.out.println("Medida atualizada com sucesso!");
		else
			System.out.println("Não foi possivel atualizar essa medida.");
	}

	/**
	 * Método para remover uma Medida
	 */
	private void remover() {
		int id = -1;

		id = Leitor.readInt("Digite o id da medida a ser removida: ");

		System.out.println("Removendo...");
		if (controller.remover(id))
			System.out.println("Medida removida com sucesso!");
		else
			System.out.println("Não foi possivel remover essa medida.");
	}
}
