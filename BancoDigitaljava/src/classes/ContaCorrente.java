package classes;

import java.util.ArrayList;

public class ContaCorrente {

    private String nomeTitular;
    private int numeroConta;
    private double limiteChequeEspecial;
    //private ArrayList<String> historicoTransacoes;

    Movimentacao movimentacao = new Movimentacao();

    public ContaCorrente() {

    }

    public int getNumeroConta() {

        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {

        this.numeroConta = numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {

        this.nomeTitular = nomeTitular;
    }

    public double getLimiteChequeEspecial() {

        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    /*public ArrayList<String> getHistoricoTransacoes() {

        return historicoTransacoes;
    }

    public void setHistoricoTransacoes(ArrayList<String> historicoTransacoes) {
        this.historicoTransacoes = historicoTransacoes;
    }*/

}
