Projeto Farmácia (e-commerce) - Java
<br />

<div align="center"> <img src="https://i.imgur.com/IaD4lwg.png" title="source: imgur.com" width="35%"/> </div>
<br />

<div align="center"> <img src="https://img.shields.io/github/languages/top/rafaelq80/aulas_java_t82?style=flat-square" /> <img src="https://img.shields.io/github/repo-size/rafaelq80/aulas_java_t82?style=flat-square" /> <img src="https://img.shields.io/github/languages/count/rafaelq80/aulas_java_t82?style=flat-square" /> <img src="https://img.shields.io/github/last-commit/rafaelq80/aulas_java_t82?style=flat-square" /> <img src="https://img.shields.io/github/issues/rafaelq80/aulas_java_t82?style=flat-square" /> <img src="https://img.shields.io/github/issues-pr/rafaelq80/aulas_java_t82?style=flat-square" /> <img src="https://img.shields.io/badge/status-construção-yellow" alt="Status: Em Construção"> </div>
<br />

1. Descrição
<br />

O Projeto Farmácia (e-commerce) é um sistema de gestão desenvolvido para simular e administrar operações comuns em uma Farmácia virtual. Oferece funcionalidades como cadastro, consulta, atualização e remoção de produtos.

O sistema organiza as informações dos produtos — incluindo nome, preço e categoria — garantindo uma experiência de compra segura e eficiente. Seu principal objetivo é automatizar e simplificar o gerenciamento de uma loja online, promovendo agilidade, controle e eficiência no atendimento ao cliente.

Este projeto, desenvolvido em Java, foca no estudo e aplicação dos conceitos de Programação Orientada a Objetos (POO), incluindo:

Classes e Objetos;
Atributos e Métodos;
Modificadores de Acesso;
Herança e Polimorfismo;
Classes Abstratas;
Interfaces.
Além de servir como um simulador funcional, o projeto oferece uma base prática para compreender os princípios fundamentais da POO aplicados a um cenário realista.

<br />

2. Funcionalidades do Projeto
<br />

Cadastrar Produto: Adiciona um novo produto ao sistema especificando nome, preço, categoria e demais propriedades relevantes. O identificador do produto é gerado automaticamente.
Listar todos os Produtos: Exibe todos os produtos cadastrados no sistema, com informações detalhadas.
Consultar Produto por ID: Localiza um produto específico a partir do seu identificador único.
Editar Produto: Permite atualizar os dados de um produto existente com base no seu ID.
Excluir Produto: Remove um produto específico do sistema a partir do seu ID.
<br />

3. Diagrama de Classes
<br />

Um Diagrama de Classes é um modelo visual usado na programação orientada a objetos para representar a estrutura de um sistema. Ele exibe classes, atributos, métodos e os relacionamentos entre elas, como associações, heranças e dependências.

Esse diagrama ajuda a planejar e entender a arquitetura do sistema, mostrando como os componentes interagem e se conectam. É amplamente utilizado nas fases de design e documentação de projetos.

Abaixo, você confere o Diagrama de Classes do Projeto Farmácia (e-commerce):

classDiagram
class Produto {
  - id: int
  - nome: String
  - categoria: int
  - preco: float
  + getId() int
  + getNome() String
  + getCategoria() int
  + getPreco() float
  + setId(id: int) void
  + setNome(nome: String) void
  + setCategoria(categoria: int) void
  + setPreco(preco: float) void
  + visualizar() void
}
class Medicamento {
  - generico: String
  + getGenerico() String
  + setGenerico(generico: String) void
  + visualizar() void
}
class Cosmetico {
  - fragancia: String
  + getFragancia() String
  + setFragancia(fragancia: String) void
  + visualizar() void
}
Medicamento --> Produto
Cosmetico --> Produto
<br />

4. Tela Inicial do Sistema - Menu
<br />

<div align="center"> <img src="https://i.imgur.com/lx232A1.png" title="source: imgur.com" width="90%"/> </div>
<br />

5. Requisitos
<br />

Para executar os códigos localmente, você precisará de:

Java JDK 17+
Eclipse ou STS
<br />

6. Como Executar o projeto no Eclipse/STS
<br />

6.1. Importando o Projeto
Clone o repositório do Projeto Conta Bancária dentro da pasta do Workspace do Eclipse/STS
git clone https://github.com/rafaelq80/farmacia_java_t82.git
Abra o Eclipse/STS e selecione a pasta do Workspace onde você clonou o repositório do projeto
No menu superior do Eclipse/STS, clique na opção: File 🡲 Import...
Na janela Import, selecione a opção: General 🡲 Existing Projects into Workspace e clique no botão Next
Na janela Import Projects, no item Select root directory, clique no botão Browse... e selecione a pasta do Workspace onde você clonou o repositório do projeto
O Eclipse/STS reconhecerá automaticamente o projeto
Marque o Projeto Conta Bancária no item Projects e clique no botão Finish para concluir a importação
<br />

6.2. Executando o projeto
Na guia Package Explorer, localize o Projeto Conta Bancária
Abra a Classe Menu
Clique no botão Run source: imgur.com para executar a aplicação
Caso seja perguntado qual é o tipo do projeto, selecione a opção Java Application
O console exibirá o menu do Projeto.
<br />

7. Contribuição
<br />

Este repositório é parte de um projeto educacional, mas contribuições são sempre bem-vindas! Caso tenha sugestões, correções ou melhorias, fique à vontade para:

Criar uma issue
Enviar um pull request
Compartilhar com colegas que estejam aprendendo Java!
<br />

8. Contato
<br />

Desenvolvido por Rafael Para dúvidas, sugestões ou colaborações, entre em contato via GitHub ou abra uma issue!