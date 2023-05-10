package entidade;

public class Proprietario extends Usuario {

    private int qtdImoveis;

    public Proprietario(String nome, String email, String contato, int qtdImoveis) {
        super(nome, email, contato);
        this.qtdImoveis = qtdImoveis;
    }

    public int getQtdImoveis() {
        return qtdImoveis;
    }

    public void setQtdImoveis(int qtdImoveis) {
        this.qtdImoveis = qtdImoveis;
    }
}
