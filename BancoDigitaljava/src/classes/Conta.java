package classes;

import java.util.ArrayList;
public abstract class Conta {

    private String conta;
    private Double saldo;
    private Double transferencia;
    private Double saque;
    private Double deposito;
    private Double pagamento;
    private static String variacao;
    private int posCliente;
    private String descricaoExtrato;

    ArrayList<String> HistoricoConta = new ArrayList<>();
    public Conta() {

    }
    public static String getVariacao() {
        return variacao;
    }
    public static void setVariacao(String variacao) {
        Conta.variacao = variacao;
    }

    public int getPosCliente() {
        return posCliente;
    }

    public void setPosCliente(int posCliente) {
        this.posCliente = posCliente;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public Double getPagamento() {
        return pagamento;
    }
    public void setPagamento(Double pagamento) {
        this.pagamento = pagamento;
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
    public ArrayList<String> getHistoricoConta() {
        return HistoricoConta;
    }
    public void setHistoricoConta(ArrayList<String> historicoConta) {
        HistoricoConta = historicoConta;
    }

    public String getDescricaoExtrato() {
        return descricaoExtrato;
    }

    public void setDescricaoExtrato(String descricaoExtrato) {
        this.descricaoExtrato = descricaoExtrato;
    }
}
