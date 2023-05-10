package entidade;

public class Hospede extends Usuario {

        private String listaImoveisFavoritos;

    public Hospede(String nome, String email, String contato, String listaImoveisFavoritos) {
        super(nome, email, contato);
        this.listaImoveisFavoritos = listaImoveisFavoritos;
    }

    public String getListaImoveisFavoritos() {
        return listaImoveisFavoritos;
    }

    public void setListaImoveisFavoritos(String listaImoveisFavoritos) {
        this.listaImoveisFavoritos = listaImoveisFavoritos;
    }
}
