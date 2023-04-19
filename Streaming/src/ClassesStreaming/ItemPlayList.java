package ClassesStreaming;

import java.util.List;

public class ItemPlayList {
	
	protected String titulo;
	   protected String diretor;
	   protected List<String> elenco;
	   protected String genero;
	   protected String sinopse;
	   
	   public ItemPlayList(String titulo, String diretor, List<String> elenco, String genero, String sinopse) {
	      this.titulo = titulo;
	      this.diretor = diretor;
	      this.elenco = elenco;
	      this.genero = genero;
	      this.sinopse = sinopse;
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
	   
	   public abstract void reproduzir();
	   
	   public abstract int getDuracao();
	}


