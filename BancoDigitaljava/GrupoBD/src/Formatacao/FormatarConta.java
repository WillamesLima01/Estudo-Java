package Formatacao;

public class FormatarConta {

    private String numeroTx;
    private String numeroConta;

    public String getNumeroConta() {

        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {

        int numero = Integer.parseInt(numeroConta);

        numeroTx = String.format("%d.%d-%d", numero / 10000, (numero % 10000) / 10, numero % 10);

        this.numeroConta = numeroTx;
    }

}
