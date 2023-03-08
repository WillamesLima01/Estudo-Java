public class ContaCorrente {
    private String nome;
    private String senha;
    private double saldo;

    public ContaCorrente(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
    public void depositar(double valorDeposito) {
        this.saldo += valorDeposito;
        System.out.println(("Seu novo saldo é R$ " + this.saldo));
    }
    public void sacar(double valorSaque) {
        if (valorSaque <= this.saldo) {
            this.saldo -= valorSaque;
            System.out.println("Seu saldo após o saque é R$ " + this.saldo);
        } else {
            System.out.println("Seu saldo é insuficiente para essa operação!");
        }
    }

    public double verificarSaldo() {
        return this.saldo;
    }
    public String getNome() {
        return this.nome;
    }
    public String getSenha() {
        return this.senha;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
