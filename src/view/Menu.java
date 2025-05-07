package view;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Escultura;
import model.Moldura;
import util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int opcao;

//		Testes

		Escultura e1 = new Escultura(2, "Escultura Abstrata", 1, 350.0f, "Moderno", "Entalhe em Madeira");
		e1.visualizar();

		Moldura m1 = new Moldura(1, "Moldura Clássica", 2, 120.0f, "Verniz Fosco", "Barroca");
		m1.visualizar();

		while (true) {
			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA
					+ "───────────────────────༺𓆩༒︎𓆪༻───────────────────────");
			System.out.println("                                                     ");
			System.out.println("                   ✧ ARTES AURORA ✧                  ");
			System.out.println("                                                     ");
			System.out.println("───────────────────────༺𓆩༒︎𓆪༻───────────────────────");

			// Menuzinho
			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA
					+ "                                                     ");
			System.out.println("            1 - Cadastrar Produto                    ");
			System.out.println("            2 - Listar Produtos                     ");
			System.out.println("            3 - Buscar Produto por ID               ");
			System.out.println("            4 - Atualizar Produto                   ");
			System.out.println("            5 - Deletar Produto                     ");
			System.out.println("            6 - Sair                                ");
			System.out.println("                                                     ");
			System.out.println("───────────────────────༺𓆩༒︎𓆪༻───────────────────────");

			System.out.print("\nEscolha a opção desejada: " + Cores.TEXT_RESET);

			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nOpção Inválida! Digite um número.");
				sc.nextLine(); // Limpa o buffer de entrada
				continue;
			}

			if (opcao == 6) {
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA
						+ "\nArtes Aurora - Obrigado por usar nosso sistema!");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Cadastrar Produto\n\n");

				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os Produtos\n\n");

				keyPress();
				break;
			case 3:
				System.out.println("Buscar Produto por ID\n\n");

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar Produto\n\n");

				keyPress();
				break;
			case 5:
				System.out.println("Deletar Produto\n\n");

				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");

				keyPress();
				break;
			}
		}
	}

	// Sobre
	public static void sobre() {
		System.out.println("\n───────────────────────༺𓆩༒︎𓆪༻────────────────────────");
		System.out.println("Projeto Desenvolvido por: Maria Helena Squarcini      ");
		System.out.println("Maria Helena - maria.helen@live.com                   ");
		System.out.println("github.com/squarcinihelena                            ");
		System.out.println("───────────────────────༺𓆩༒︎𓆪༻────────────────────────");
	}

	// Keypress
	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");

			// Lê apenas a tecla Enter e ignora outras teclas
			int input;
			while ((input = System.in.read()) != '\n') {
				// Ignora qualquer outra tecla diferente do Enter
				if (input == -1) {
					throw new IOException("Entrada encerrada inesperadamente");
				}
			}

		} catch (IOException e) {
			System.err.println("Erro de entrada/saída: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao processar a entrada: " + e.getMessage());
		}
	}
}