package ClassesStreaming;

import java.util.List;

public class Serie extends Video {
	
	   private int temporadaAtual;
	    private int episodioAtual;

	    public Serie(String titulo, String diretor, List<String> elenco, String genero, String sinopse, int anoLancamento, 
	    		int classificacaoIndicativa, int temporadaAtual, int episodioAtual) {
	    	
	        super(titulo, diretor, elenco, genero, sinopse, anoLancamento, classificacaoIndicativa);
	        this.temporadaAtual = temporadaAtual;
	        this.episodioAtual = episodioAtual;
	    }

	    public int getTemporadaAtual() {
	        return temporadaAtual;
	    }

	    public void setTemporadaAtual(int temporadaAtual) {
	        this.temporadaAtual = temporadaAtual;
	    }

	    public int getEpisodioAtual() {
	        return episodioAtual;
	    }

	    public void setEpisodioAtual(int episodioAtual) {
	        this.episodioAtual = episodioAtual;
	    }

}
