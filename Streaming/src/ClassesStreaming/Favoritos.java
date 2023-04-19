package ClassesStreaming;

import java.util.ArrayList;

public class Favoritos {
	
	 private ArrayList<ItemPlayList> lista;

	    public Favoritos() {
	        lista = new ArrayList<ItemPlayList>();
	    }

	    public void adicionar(ItemPlayList item) {
	        lista.add(item);
	        System.out.println("Item adicionado aos favoritos.");
	    }

	    public void remover(ItemPlayList item) {
	        lista.remove(item);
	        System.out.println("Item removido dos favoritos.");
	    }

	    public void imprimir() {
	        System.out.println("Lista de favoritos:");
	        for (ItemPlayList item : lista) {
	            System.out.println(item.getTitulo());
	        }
	    }	

}
