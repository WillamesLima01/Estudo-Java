package Executavel;

import classes.ContaCorrente;
import classes.Movimentacao;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        double saldo = 2000;
        double saque = 1000;
        double deposito = 0;
        double pagamento = 0;
        int numeroConta = 1229;
        String nomeTitular = "willames";
        double limiteChequeEspecial = 3000;

        ContaCorrente Cc = new ContaCorrente();
        Movimentacao movimentacao = new Movimentacao();


        movimentacao.setSaldo(saldo);
        //movimentacao.setPagamento(pagamento);
        //movimentacao.setDeposito(deposito);
        movimentacao.setSaque(saque);
        Cc.setNumeroConta(numeroConta);
        Cc.setNomeTitular(nomeTitular);
        //Cc.setLimiteChequeEspecial(limiteChequeEspecial);

        //System.out.println(movimentacao.getPagamento());
        System.out.println(Cc.getNomeTitular());
        System.out.println(Cc.getNumeroConta());
        System.out.println(movimentacao.getSaque());

    }
}
