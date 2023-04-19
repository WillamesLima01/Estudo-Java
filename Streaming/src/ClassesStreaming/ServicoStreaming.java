package ClassesStreaming;

import java.util.ArrayList;

public class ServicoStreaming {
	
	private ArrayList<Video> videosDisponiveis;
    private ArrayList<Usuario> usuariosCadastrados;
    private ArrayList<Acesso> acessosRegistrados;

    public ServicoStreaming() {
        this.videosDisponiveis = new ArrayList<Video>();
        this.usuariosCadastrados = new ArrayList<Usuario>();
        this.acessosRegistrados = new ArrayList<Acesso>();
    }

    public void cadastrarVideo(Video video) {
        this.videosDisponiveis.add(video);
    }

    public void cadastrarUsuario(Usuario usuario) {
        this.usuariosCadastrados.add(usuario);
    }

    public boolean verificarDisponibilidade(String titulo) {
        for (Video video : this.videosDisponiveis) {
            if (video.getTitulo().equals(titulo)) {
                return true;
            }
        }
        return false;
    }

    public Video buscarVideo(String titulo) {
        for (Video video : this.videosDisponiveis) {
            if (video.getTitulo().equals(titulo)) {
                return video;
            }
        }
        return null;
    }

    public Usuario buscarUsuario(String email) {
        for (Usuario usuario : this.usuariosCadastrados) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    public void registrarAcesso(Usuario usuario, Video video) {
        Acesso acesso = new Acesso(usuario, video);
        this.acessosRegistrados.add(acesso);
    }

    public ArrayList<Video> getVideosDisponiveis() {
        return this.videosDisponiveis;
    }

    public ArrayList<Usuario> getUsuariosCadastrados() {
        return this.usuariosCadastrados;
    }

    public ArrayList<Acesso> getAcessosRegistrados() {
        return this.acessosRegistrados;
    }

}
