package controller;

import java.util.ArrayList;
import java.util.Optional;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.stream.Collectors;

import model.Produto;
import repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    int id = 0;

    @Override
    public void procurarPorId(int id) {
        try {
            Optional<Produto> produto = buscarNaCollection(id);
            if (produto.isPresent()) {
                produto.get().visualizar();
            } else {
                throw new NoSuchElementException("Produto não encontrado.");
            }
        } catch (NoSuchElementException e) {
            System.out.printf("\nErro: %s\n", e.getMessage());
        } catch (Exception e) {
            System.out.println("\nErro inesperado ao buscar produto: " + e.getMessage());
        }
    }

    @Override
    public void listarTodos() {
        try {
            if (listaProdutos.isEmpty()) {
                System.out.println("Não há produtos cadastrados.");
            } else {
                for (var produto : listaProdutos) {
                    produto.visualizar();
                }
            }
        } catch (Exception e) {
            System.out.println("\nErro ao listar produtos: " + e.getMessage());
        }
    }

    @Override
    public void cadastrar(Produto produto) {
        try {
            if (produto == null) {
                throw new IllegalArgumentException("Produto não pode ser nulo.");
            }
            listaProdutos.add(produto);
            System.out.println("O Produto foi criado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nErro inesperado ao cadastrar produto: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Produto produto) {
        try {
            if (produto == null) {
                throw new IllegalArgumentException("Produto não pode ser nulo.");
            }

            Optional<Produto> buscaProduto = buscarNaCollection(produto.getId());

            if (buscaProduto.isPresent()) {
                listaProdutos.set(listaProdutos.indexOf(buscaProduto.get()), produto);
                System.out.printf("\nO Produto ID %d foi atualizado com sucesso!\n", produto.getId());
            } else {
                throw new NoSuchElementException("Produto não encontrado para atualização.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.printf("\nErro: %s\n", e.getMessage());
        } catch (Exception e) {
            System.out.println("\nErro inesperado ao atualizar produto: " + e.getMessage());
        }
    }

    @Override
    public void deletar(int id) {
        try {
            Optional<Produto> produto = buscarNaCollection(id);

            if (produto.isPresent()) {
                if (listaProdutos.remove(produto.get())) {
                    System.out.printf("\nO Produto ID %d foi excluído com sucesso!\n", id);
                } else {
                    throw new Exception("Falha ao remover o produto.");
                }
            } else {
                throw new NoSuchElementException("Produto não encontrado para exclusão.");
            }
        } catch (NoSuchElementException e) {
            System.out.printf("\nErro: %s\n", e.getMessage());
        } catch (Exception e) {
            System.out.println("\nErro inesperado ao excluir produto: " + e.getMessage());
        }
    }

    public int gerarId() {
        return ++id;
    }

    public Optional<Produto> buscarNaCollection(int id) {
        try {
            for (var produto : listaProdutos) {
                if (produto.getId() == id) {
                    return Optional.of(produto);
                }
            }
            return Optional.empty();
        } catch (Exception e) {
            System.out.println("\nErro ao buscar na coleção: " + e.getMessage());
            return Optional.empty();
        }
    }

    // Meu Extra!! : Filtrar produtos por preço utilizando streams c/ lambda
    public void listarProdutosPorPreco(float precoMinimo, float precoMaximo) {
        try {
            List<Produto> produtosFiltrados = listaProdutos.stream()
                    .filter(produto -> produto.getPreco() >= precoMinimo && produto.getPreco() <= precoMaximo)
                    .collect(Collectors.toList());

            if (produtosFiltrados.isEmpty()) {
                System.out.println("Nenhum produto encontrado dentro do intervalo de preço.");
            } else {
                for (Produto produto : produtosFiltrados) {
                    produto.visualizar();
                }
            }
        } catch (Exception e) {
            System.out.println("\nErro ao listar produtos por preço: " + e.getMessage());
        }
    }
}