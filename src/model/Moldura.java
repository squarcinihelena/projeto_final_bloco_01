package model;

public class Moldura extends Produto {
	
    private String acabamento;
    private String tipoMoldura;
   
    
	public Moldura(int id, String nome, int tipo, float preco, String acabamento, String tipoMoldura) {
		super(id, nome, tipo, preco);
		this.acabamento = acabamento;
		this.tipoMoldura = tipoMoldura;
	}



    public String getAcabamento() {
        return acabamento;
    }

    public void setAcabamento(String acabamento) {
        this.acabamento = acabamento;
    }

    public String getTipoMoldura() {
        return tipoMoldura;
    }

    public void setTipoMoldura(String tipoMoldura) {
        this.tipoMoldura = tipoMoldura;
    }

    @Override
    public void visualizar() {
        System.out.println("Moldura:");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: R$ " + getPreco());
        System.out.println("Acabamento: " + acabamento);
        System.out.println("Tipo de Moldura: " + tipoMoldura);
    }
}