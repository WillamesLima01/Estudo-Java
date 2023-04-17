package GerenciamentoSistema;

public class Serie extends Video {
    private int temporada;
    private int episodios;

    public Serie(String titulo, String diretor, String elenco, String genero, String sinopse,
                 int anoLancamento, int classificacao, int temporada, int episodios) {

        super(titulo, diretor, elenco, genero, sinopse, anoLancamento, classificacao);

        this.temporada = temporada;
        this.episodios = episodios;

    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }
}
