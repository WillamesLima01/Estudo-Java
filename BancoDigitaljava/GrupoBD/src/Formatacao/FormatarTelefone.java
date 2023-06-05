package Formatacao;

public class FormatarTelefone {

    String numeroTelefone;
    //String numeroTx;

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {

        String ddd = numeroTelefone.substring(0, 2);
        String parte1 = numeroTelefone.substring(2, 7);
        String parte2 = numeroTelefone.substring(7, 11);

        this.numeroTelefone = "(" + ddd + ") " + parte1 + "-" + parte2;

    }
}
