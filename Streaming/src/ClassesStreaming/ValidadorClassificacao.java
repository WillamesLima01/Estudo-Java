package ClassesStreaming;

public class ValidadorClassificacao {
	
	public boolean validarAcesso(Usuario usuario, Video video) {
        int classificacaoIndicativa = video.getClassificacaoIndicativa();
        int idadeUsuario = usuario.getIdade();

        if (idadeUsuario >= classificacaoIndicativa) {
            return true;
        } else {
            return false;
        }
    }

}
