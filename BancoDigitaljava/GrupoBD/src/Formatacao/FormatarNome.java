package Formatacao;

public class FormatarNome {
    private String nome;

    public FormatarNome(){

    }
    public FormatarNome(String nome) {

        this.nome = nome;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        String stiloNome;
        String[] primeiroNome;

        primeiroNome = nome.split(" ");

        int qc = primeiroNome[0].length();

        if(qc < 4) {
            //usei uma array dentro da fórmula para converter as primeiras letras do nome composto
            stiloNome = primeiroNome[0].substring(0, 1).toUpperCase() + primeiroNome[0].substring(1) +
                    " " + primeiroNome[1].substring(0, 1).toUpperCase() + primeiroNome[1].substring(1);

        } else {

            stiloNome = primeiroNome[0];
            stiloNome = stiloNome.substring(0, 1).toUpperCase() + stiloNome.substring(1);
        }

        this.nome = stiloNome;
    }

}
