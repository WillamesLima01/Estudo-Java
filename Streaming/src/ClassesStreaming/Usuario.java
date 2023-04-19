package ClassesStreaming;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	  private String nome;
	    private String email;
	    private String senha;
	    private int idade;
	    private Favoritos favoritos;

	    public Usuario(String nome, String email, String senha, int idade) {
	        this.nome = nome;
	        this.email = email;
	        this.senha = senha;
	        this.idade = idade;
	        this.favoritos = new Favoritos();
	    }

	    public String getNome() {
	        return this.nome;
	    }

	    public int getIdade() {
			return idade;
		}

		public void setIdade(int idade) {
			this.idade = idade;
		}

		public void setFavoritos(Favoritos favoritos) {
			this.favoritos = favoritos;
		}

		public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public String getEmail() {
	        return this.email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getSenha() {
	        return this.senha;
	    }

	    public void setSenha(String senha) {
	        this.senha = senha;
	    }

	    public Favoritos getFavoritos() {
	        return this.favoritos;
	    }

	    public void adicionarFavorito(ItemPlayList item) {
	        this.favoritos.adicionarItem(item);
	    }

	    public void removerFavorito(ItemPlayList item) {
	        this.favoritos.removerItem(item);
	    }
    

}
