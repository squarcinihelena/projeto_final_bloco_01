package view;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcao;

		while (true) {
			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA
					+ "───────────────────────༺𓆩༒︎𓆪༻───────────────────────");
			System.out.println("                                                     ");
			System.out.println("                  ✧ MOLDURAS AURORA ✧                ");
			System.out.println("                                                     ");
			System.out.println("───────────────────────༺𓆩༒︎𓆪༻───────────────────────");

			// Menuzinho
			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA
					+ "                                                     ");
			System.out.println("            1 - Cadastrar Moldura                    ");
			System.out.println("            2 - Listar Molduras                      ");
			System.out.println("            3 - Buscar Moldura por ID                ");
			System.out.println("            4 - Atualizar Moldura                    ");
			System.out.println("            5 - Deletar Moldura                      ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("───────────────────────༺𓆩༒︎𓆪༻───────────────────────");

			System.out.print("\nEscolha a opção desejada: " + Cores.TEXT_RESET);

			opcao = sc.nextInt();

			if (opcao == 6) {
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA + "\nAurora Molduras - Obrigado por usar nosso sistema!");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Cadastrar Moldura\n\n");
				keyPress();
				break;
			case 2:
				System.out.println("Listar todas as Molduras\n\n");
				keyPress();
				break;
			case 3:
				System.out.println("Buscar Moldura por ID\n\n");
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar Dados da Moldura\n\n");
				keyPress();
				break;
			case 5:
				System.out.println("Apagar Moldura\n\n");
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
			System.out.println("\n\n Pressione ENTER para continuar...");
			System.in.read();
			System.in.read(); // limpa o buffer do ENTER
		} catch (IOException e) {
			System.err.println(" Erro ao pressionar tecla.");
		}
	}
}