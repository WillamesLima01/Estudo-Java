package entidade;

import java.util.ArrayList;

public abstract class Propriedade {

    private String endereco;
    private int nQuartos;
    private Double preco;
    private Double mediaAvaliacao;

    ArrayList<String> listaReservados = new ArrayList<String>();
    ArrayList<String> listaAvaliacoes = new ArrayList<String>();

    public Propriedade(String endereco, int nQuartos, Double preco, Double mediaAvaliacao) {
        this.endereco = endereco;
        this.nQuartos = nQuartos;
        this.preco = preco;
        this.mediaAvaliacao = mediaAvaliacao;
    }

    public Double getMediaAvaliacao() {


        return mediaAvaliacao;

    }

    public String getEndereco() {
        return endereco;

    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getnQuartos() {
        return nQuartos;
    }

    public void setnQuartos(int nQuartos) {
        this.nQuartos = nQuartos;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
