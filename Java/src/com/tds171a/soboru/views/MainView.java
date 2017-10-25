package com.tds171a.soboru.views;

import com.tds171a.soboru.utils.Leitor;

/**
 * Classe de view do Menu Principal
 * @author Diogo
 *
 */
public class MainView {
	
	/**
	 * Construtor da view de Ingrediente
	 */
	public MainView() {
		while (menu() != 9) {
		}
	}
	
	/**
	 * Método de escrita do menu para Ingrediente
	 * @return
	 */
	private int menu() {
		System.out.println(" --- Menu ---");

		System.out.println("1 - Ingredientes");
		System.out.println("2 - Utensilios");
		System.out.println("3 - Medidas");
		System.out.println("9 - Sair");

		int op = -1;
		op = Leitor.readInt();

		switch (op) {
			case 1:
				new IngredienteView();
				break;
			case 2:
				new UtensilioView();
				break;
			case 3:
				new MedidaView();
				break;
			case 9:
				System.out.println("Até mais!");
				break;
			default:
				System.out.println("Opcao escolhida invalida!\n");
				break;
		}

		return op;
	}
}
