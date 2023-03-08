public class ContaLogin {
    private String nome;
    private int anoNascimeto;
    private String email;
    private String senha;

    public ContaLogin(String email) {
        this.email = email;
    }

    public ContaLogin(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome, int x) {
        if (x == 10) {
            this.nome = nome;
        } else {
            System.out.println("Código de alteração errado!");
        }
    }

    public int getAnoNascimeto() {
        return anoNascimeto;
    }

    public void setAnoNascimeto(int anoNascimeto) {
        this.anoNascimeto = anoNascimeto;
    }
    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}


