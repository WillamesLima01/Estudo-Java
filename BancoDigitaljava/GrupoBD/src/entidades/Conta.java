package entidades;

public abstract class Conta {

    private static String logado;
    private Double saldo;
    private Double transferencia;
    private Double saque;
    private Double deposito;
    private static int variacao;
    private String descricaoExtrato;

    public Conta() {

    }

    public static String getLogado() {

        return logado;
    }

    public static void setLogado(String logado) {

        Conta.logado = logado;
    }

    public static int getVariacao() {

        return variacao;
    }

    public static void setVariacao(int variacao) {

        Conta.variacao = variacao;
    }

    public Double getSaldo() {

        return saldo;
    }
    public void setSaldo(Double saldo) {

        this.saldo = saldo;
    }

    public Double getTransferencia() {

        return transferencia;
    }
    public void setTransferencia(Double transferencia) {

        this.transferencia = transferencia;
    }
    public Double getSaque() {

        return saque;
    }
    public void setSaque(Double saque) {

        this.saque = saque;
    }
    public Double getDeposito() {

        return deposito;
    }
    public void setDeposito(Double deposito) {

        this.deposito = deposito;
    }

    public String getDescricaoExtrato() {

        return descricaoExtrato;
    }

    public void setDescricaoExtrato(String descricaoExtrato) {

        this.descricaoExtrato = descricaoExtrato;
    }
}