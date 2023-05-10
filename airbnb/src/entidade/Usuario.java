package entidade;

public abstract class Usuario {

    protected String nome;
    protected String email;
    protected String contato;

    public Usuario(String nome, String email, String contato) {
        this.nome = nome;
        this.email = email;
        this.contato = contato;
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

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
