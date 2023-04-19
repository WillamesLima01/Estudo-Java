package Executavel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {
	
	public static void main(String[] args) {
        ServicoStreaming servico = new ServicoStreaming();
              
        
        // Criando alguns filmes e séries
        Filme filme1 = new Filme("Matrix", "Lana Wachowski", "Keanu Reeves, Laurence Fishburne", "Ação, Ficção científica", "Um programador de computador é levado para o mundo real da inteligência artificial", 1999, 16);
        Filme filme2 = new Filme("De Volta para o Futuro", "Robert Zemeckis", "Michael J. Fox, Christopher Lloyd", "Aventura, Comédia", "Um adolescente viaja no tempo para salvar seus pais", 1985, 12);
        Serie serie1 = new Serie("Breaking Bad", "Vince Gilligan", "Bryan Cranston, Aaron Paul", "Drama, Crime", "Um professor de química se envolve com o tráfico de drogas", 2008, 18, 5);
        Serie serie2 = new Serie("Stranger Things", "The Duffer Brothers", "Millie Bobby Brown, Finn Wolfhard", "Ficção científica, Terror", "Um grupo de amigos investiga o desaparecimento de um colega em uma cidade misteriosa", 2016, 16, 3);
        
        // Adicionando os filmes e séries ao serviço de streaming
        servico.adicionarVideo(filme1);
        servico.adicionarVideo(filme2);
        servico.adicionarVideo(serie1);
        servico.adicionarVideo(serie2);
        
        // Criando alguns usuários
        Usuario usuario1 = new Usuario("João", "joao@gmail.com", "123456");
        Usuario usuario2 = new Usuario("Maria", "maria@gmail.com", "abcdef");
        Usuario usuario3 = new Usuario("Pedro", "pedro@gmail.com", "qwerty");
        
        // Cadastrando os usuários no serviço de streaming
        servico.cadastrarUsuario(usuario1);
        servico.cadastrarUsuario(usuario2);
        servico.cadastrarUsuario(usuario3);
        
        // Adicionando títulos à lista de favoritos do usuário 1
        servico.adicionarTituloFavorito(usuario1, filme1);
        servico.adicionarTituloFavorito(usuario1, serie1);
        
        // Acessando um título
        servico.acessarTitulo(usuario1, filme1);
        
        // Verificando se o usuário tem permissão para assistir a um título com base na classificação indicativa
        ValidadorClassificacao validador = new ValidadorClassificacao();
        boolean temPermissao = validador.verificarPermissao(usuario1, filme1);
        System.out.println("O usuário " + usuario1.getNome() + " tem permissão para assistir a " + filme1.getTitulo() + "? " + temPermissao);
        
        // Verificando a lista de favoritos do usuário 1
        List<ItemPlaylist> favoritos = servico.listarFavoritos(usuario1);
        System.out.println("Lista de favoritos do usuário " + usuario1.getNome() + ":");
        for (ItemPlaylist item : favoritos) {
            System.out.println(item.getTitulo());
        }
    }

}
