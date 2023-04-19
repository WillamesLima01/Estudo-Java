package ClassesStreaming;

import java.util.List;

public class PlayList {
	
	private String nome;
    private List<ItemPlayList> itens;

    public PlayList(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public void adicionar(ItemPlayList item) {
        itens.add(item);
    }

    public void remover(ItemPlayList item) {
        itens.remove(item);
    }

    public void reproduzir() {
        System.out.println("Reproduzindo " + nome + ":");
        for (ItemPlayList item : itens) {
            System.out.println("- " + item.getTitulo());
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ItemPlayList> getItens() {
        return itens;
    }

    public void setItens(List<ItemPlayList> itens) {
        this.itens = itens;
    }


}
