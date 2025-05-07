package model;

public class Escultura extends Produto {
	
    private String estilo;
    private String tecnica;

    
    public Escultura(int id, String nome, int tipo, float preco, String estilo, String tecnica) {
		super(id, nome, tipo, preco);
		this.estilo = estilo;
		this.tecnica = tecnica;
	}


    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    @Override
    public void visualizar() {
        System.out.println("Escultura:");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: R$ " + getPreco());
        System.out.println("Estilo: " + estilo);
        System.out.println("Técnica: " + tecnica);
    }
}