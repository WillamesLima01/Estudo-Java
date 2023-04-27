package classes;

public class Movimentacao {
    private double saldo;
    private double extrato;
    private double pagamento;
    private double transferencia;
    private double deposito;
    private double saque;


    public Movimentacao() {

    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getExtrato() {
        return extrato;
    }

    public void setExtrato(double extrato) {
        this.extrato = extrato;
    }

    public double getPagamento() {
        return pagamento;
    }

    public void setPagamento(double pagamento) {
        this.saldo -= pagamento;
        System.out.println("Pagamento efetuado com sucesso! Seu novo saldo é de R$ " + this.saldo);
    }

    public double getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(double transferencia) {
        this.transferencia = transferencia;
    }

    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.saldo += deposito;
        System.out.println("Seu novo saldo em conta corrente é de R$ " + this.saldo);
    }

    public double getSaque() {
        return saque;
    }

    public void setSaque(double saque) {
        if (saque <= this.saldo) {
            this.saldo -= saque;
            System.out.println("Seu novo saldo é R$ " + this.saldo);
        } else {
            System.out.println("Saldo insuficinete!");
        }

    }

    public double verificarSaldo(){
        return this.saldo;
    }

}
