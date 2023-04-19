package ClassesStreaming;

import java.sql.Date;

public class Acesso {
	
	private Usuario usuario;
    private Video video;
    private Date data;
    
    public Acesso(Usuario usuario, Video video) {
        this.usuario = usuario;
        this.video = video;
        this.data = new Date();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Video getVideo() {
        return video;
    }

    public Date getData() {
        return data;
    }

}
