package entidades;

import interfaces.ConfirmarConta;

import java.text.NumberFormat;
import java.util.ArrayList;

public class ContaInvestimento extends Conta implements ConfirmarConta {

    private Double saldo;
    private static Boolean bloquearCi;

    ArrayList<String> extratoCi = new ArrayList<>();

    NumberFormat vlr = NumberFormat.getCurrencyInstance();//formatar moeda (vlr.format(valor))

    public ContaInvestimento() {

    }

    public static Boolean getBloquearCi() {
        return bloquearCi;
    }

    public static void setBloquearCi(Boolean bloquearCi) {
        ContaInvestimento.bloquearCi = bloquearCi;
    }

    public void rendimentoInvestimento() {
        double rendimento = saldo * 0.10; // Calcula o rendimento (10% do saldo atual)
        saldo += rendimento; // Adiciona o rendimento ao saldo atual
    }

    public Double getSaldo() {
        return saldo;
    }

    @Override
    public Boolean confirmar(String tipoConta) {

        return (getVariacao()==Integer.parseInt(tipoConta));

    }
}
