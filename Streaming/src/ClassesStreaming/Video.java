package ClassesStreaming;

import java.util.List;

public abstract class Video {

	   protected String titulo;
	   protected String diretor;
	   protected List<String> elenco;
	   protected String genero;
	   protected String sinopse;
	   protected int anoLancamento;
	   protected int classificacaoIndicativa;

	    public Video(String titulo, String diretor, List<String> elenco, String genero, String sinopse, 
	    		int anoLancamento, int classificacaoIndicativa) {
	    	
	        this.titulo = titulo;
	        this.diretor = diretor;
	        this.elenco = elenco;
	        this.genero = genero;
	        this.sinopse = sinopse;
	        this.anoLancamento = anoLancamento;
	        this.classificacaoIndicativa = classificacaoIndicativa;
	    }

	    public String getTitulo() {
	        return titulo;
	    }

	    public String getDiretor() {
	        return diretor;
	    }

	    public List<String> getElenco() {
	        return elenco;
	    }

	    public String getGenero() {
	        return genero;
	    }

	    public String getSinopse() {
	        return sinopse;
	    }

	    public int getAnoLancamento() {
	        return anoLancamento;
	    }

	    public int getClassificacaoIndicativa() {
	        return classificacaoIndicativa;
	    }
}
