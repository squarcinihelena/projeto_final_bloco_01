package view;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.ProdutoController;
import model.Escultura;
import model.Moldura;
import model.Produto;
import util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ProdutoController produtos = new ProdutoController();

		int opcao, id, tipo;
		String nome, estilo, tecnica, acabamento, tipoMoldura;
		float preco;

		while (true) {
			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA
					+ "───────────────────────༺𓆩༒︎𓆪༻───────────────────────");
			System.out.println("                                                     ");
			System.out.println("                   ✧ ARTES AURORA ✧                  ");
			System.out.println("                                                     ");
			System.out.println("───────────────────────༺𓆩༒︎𓆪༻───────────────────────");

			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA
					+ "                                                     ");
			System.out.println("            1 - Cadastrar Produto                    ");
			System.out.println("            2 - Listar Produtos                      ");
			System.out.println("            3 - Buscar Produto por ID                ");
			System.out.println("            4 - Atualizar Produto                    ");
			System.out.println("            5 - Deletar Produto                      ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("───────────────────────༺𓆩༒︎𓆪༻───────────────────────");

			System.out.print("\nEscolha a opção desejada: " + Cores.TEXT_RESET);

			try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nOpção Inválida! Digite um número.");
                sc.nextLine();
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
                case 1 -> {
                    System.out.println("Cadastrar Produto\n\n");

                    System.out.print("Digite o Nome do Produto: ");
                    sc.nextLine(); // limpar buffer
                    nome = sc.nextLine();

                    while (true) {
                        try {
                            System.out.print("Digite o Preço do Produto: ");
                            preco = sc.nextFloat();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Preço inválido! Digite um número.");
                            sc.nextLine();
                        }
                    }

                    do {
                        try {
                            System.out.print("Digite o Tipo (1-Escultura | 2-Moldura): ");
                            tipo = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Tipo inválido! Digite 1 ou 2.");
                            sc.nextLine();
                            tipo = 0;
                        }
                    } while (tipo != 1 && tipo != 2);

                    id = produtos.gerarId();

                    if (tipo == 1) {
                        System.out.print("Digite o Estilo da Escultura (Clássico, Moderno, Abstrato...): ");
                        sc.nextLine();
                        estilo = sc.nextLine();
                        System.out.print("Digite a Técnica da Escultura (Entalhe, Modelagem, Fundição...): ");
                        tecnica = sc.nextLine();

                        produtos.cadastrar(new Escultura(id, nome, tipo, preco, estilo, tecnica));

                    } else if (tipo == 2) {
                        System.out.print("Digite o Acabamento da Moldura: ");
                        sc.nextLine();
                        acabamento = sc.nextLine();
                        System.out.print("Digite o Tipo da Moldura: ");
                        tipoMoldura = sc.nextLine();

                        produtos.cadastrar(new Moldura(id, nome, tipo, preco, acabamento, tipoMoldura));
                    }

                    keyPress();
                }
                case 2 -> {
                    System.out.println("Listar todos os Produtos\n\n");
                    produtos.listarTodos();
                    keyPress();
                }
                case 3 -> {
                    System.out.println("Buscar Produto por ID\n\n");

                    while (true) {
                        try {
                            System.out.print("Digite o ID do Produto: ");
                            id = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("ID inválido! Digite um número inteiro.");
                            sc.nextLine();
                        }
                    }

                    produtos.procurarPorId(id);
                    keyPress();
                }
                case 4 -> {
                    System.out.println("Atualizar Produto\n\n");

                    while (true) {
                        try {
                            System.out.print("Digite o ID do Produto: ");
                            id = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("ID inválido! Digite um número inteiro.");
                            sc.nextLine();
                        }
                    }

                    var buscaProduto = produtos.buscarNaCollection(id);

                    if (buscaProduto.isPresent()) {
                        Produto p = buscaProduto.get();

                        System.out.print("Digite o Novo Nome: ");
                        sc.nextLine();
                        nome = sc.nextLine();

                        while (true) {
                            try {
                                System.out.print("Digite o Novo Preço: ");
                                preco = sc.nextFloat();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Preço inválido! Digite um número.");
                                sc.nextLine();
                            }
                        }

                        if (p instanceof Escultura e) {
                            System.out.print("Digite o Novo Estilo: ");
                            sc.nextLine();
                            estilo = sc.nextLine();
                            System.out.print("Digite a Nova Técnica: ");
                            tecnica = sc.nextLine();

                            produtos.atualizar(new Escultura(id, nome, 1, preco, estilo, tecnica));

                        } else if (p instanceof Moldura m) {
                            System.out.print("Digite o Novo Acabamento: ");
                            sc.nextLine();
                            acabamento = sc.nextLine();
                            System.out.print("Digite o Novo Tipo de Moldura: ");
                            tipoMoldura = sc.nextLine();

                            produtos.atualizar(new Moldura(id, nome, 2, preco, acabamento, tipoMoldura));
                        }

                    } else {
                        System.out.println("\nProduto não encontrado!");
                    }

                    keyPress();
                }
                case 5 -> {
                    System.out.println("Deletar Produto\n\n");

                    while (true) {
                        try {
                            System.out.print("Digite o ID do Produto: ");
                            id = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("ID inválido! Digite um número inteiro.");
                            sc.nextLine();
                        }
                    }

                    produtos.deletar(id);
                    keyPress();
                }
                default -> {
                    System.out.println("\nOpção Inválida!\n");
                    keyPress();
                }
            }
        }
    }

    public static void sobre() {
        System.out.println("\n───────────────────────༺𓆩༒︎𓆪༻────────────────────────");
        System.out.println("Projeto Desenvolvido por: Maria Helena Squarcini      ");
        System.out.println("Maria Helena - maria.helen@live.com                   ");
        System.out.println("github.com/squarcinihelena                            ");
        System.out.println("───────────────────────༺𓆩༒︎𓆪༻────────────────────────");
    }

    public static void keyPress() {
        try {
            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");

            int input;
            while ((input = System.in.read()) != '\n') {
                if (input == -1) {
                    throw new IOException("Entrada encerrada inesperadamente");
                }
            }
        } catch (IOException e) {
            System.err.println("Erro de entrada/saída: " + e.getMessage());
        }
    }
}