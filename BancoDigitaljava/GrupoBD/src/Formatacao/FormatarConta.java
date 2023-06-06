package Formatacao;

public class FormatarConta {

    private String numeroConta;

    public String getNumeroConta() {

        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {

        numeroConta = organizarNumero(numeroConta);

        String mil = numeroConta.substring(0, 1);
        String parte1 = numeroConta.substring(1, 4);
        String parte2 = numeroConta.substring(4, 5);

        this.numeroConta = mil + "." + parte1 + "-" + parte2;
    }

    public String organizarNumero(String numero) {

        int qtdN = numero.length();

        if (qtdN < 4) {
            numero = "00" + numero;
            return numero;
        } else if (qtdN == 4) {
            numero = "0" + numero;
            return numero;
        } else {
            return numero;
        }
    }
}

