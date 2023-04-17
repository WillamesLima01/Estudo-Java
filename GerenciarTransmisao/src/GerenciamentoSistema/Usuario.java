package GerenciamentoSistema;

import java.util.List;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private Favoritos favoritos;


    public Usuario(String nome, String email, String senha) {

        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.favoritos = new Favoritos();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Favoritos getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Favoritos favoritos) {
        this.favoritos = favoritos;
    }

    public void adicionarFavorito(ItemPlaylist item) {
        favoritos.adicionar(item);
    }

    public void removerFavorito(ItemPlaylist item) {
        favoritos.remover(item);
    }
}
