package entidade;

public class Avaliacao extends Propriedade {

    private String propriedadeAvaliada;
    private String hospedeAvaliacao;
    private int notaAvaliacao;
    private String comentario;
    private Double mediaNotas;

    public Avaliacao(String endereco, int nQuartos, Double preco, Double mediaAvaliacao, String propriedadeAvaliada, String hospedeAvaliacao, int notaAvaliacao, String comentario, Double mediaNotas) {
        super(endereco, nQuartos, preco, mediaAvaliacao);
        this.propriedadeAvaliada = propriedadeAvaliada;
        this.hospedeAvaliacao = hospedeAvaliacao;
        this.notaAvaliacao = notaAvaliacao;
        this.comentario = comentario;
        this.mediaNotas = mediaNotas;
    }

    public Double getMediaNotas() {

        return mediaNotas;
    }

    public void setMediaNotas(Double mediaNotas) {
        this.mediaNotas = mediaNotas;
    }

    public String getPropriedadeAvaliada() {
        return propriedadeAvaliada;
    }

    public void setPropriedadeAvaliada(String propriedadeAvaliada) {
        this.propriedadeAvaliada = propriedadeAvaliada;
    }

    public String getHospedeAvaliacao() {
        return hospedeAvaliacao;
    }

    public void setHospedeAvaliacao(String hospedeAvaliacao) {
        this.hospedeAvaliacao = hospedeAvaliacao;
    }

    public int getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(int notaAvaliacao) {

        this.notaAvaliacao = notaAvaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
