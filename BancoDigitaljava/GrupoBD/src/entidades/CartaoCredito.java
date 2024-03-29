package entidades;

import javax.swing.*;
import java.text.NumberFormat;

public class CartaoCredito {

    private double LimiteCredito = 3000;
    private String DataVencimento;
    private double aumentolimite;
    private String compras;
    private double TotalCompras;

    NumberFormat vlr = NumberFormat.getCurrencyInstance();//formatar moeda (vlr.format(valor))

    public CartaoCredito() {//método construtor

    }

    public void setValorCompra(String valorCompra) {
        Double valor = Double.parseDouble(valorCompra);
        String valorTx = vlr.format(valor);
        this.compras = "valor da compra : "+ valorTx;

    }

    public void setLocalCompra(String localCompra) {

        this.compras = this.compras + " ; Local da compra efetuada : " + localCompra;

    }

    public void setDataCompra(String dataCompra) {

        this.compras = this.compras + " ; Data da compra : " + dataCompra;
        this.setCompras(compras);
    }

    public String getCompras() {

        return compras;
    }

    public void setCompras(String compras) {

        JOptionPane.showMessageDialog(null, "Parabéns!!! compra realizada com sucesso! ");

    }

    public double getTotalCompras() {

        return TotalCompras;
    }

    public void setTotalCompras(double valorCompra) {

        this.TotalCompras += valorCompra;
    }

    public double getAumentolimite() {

        return aumentolimite;
    }

    public void setAumentolimite(double aumentolimite) {

        if (aumentolimite > 10000) {

            JOptionPane.showMessageDialog(null,"O valor desejado precisa ser avaliado pela gerência financeira!\n"+
                    "                Favor entrar em contato com sua gerência!", "Banco Digital", JOptionPane.INFORMATION_MESSAGE);

        }

        this.aumentolimite = aumentolimite;
    }

    public double getLimiteCredito() {

        return LimiteCredito;

    }

    public void setLimiteCredito(double limiteCredito) {

        this.LimiteCredito += getAumentolimite();
        JOptionPane.showMessageDialog(null,"Operação realizada com sucesso!\n"+"Seu novo limite de crédito é de "+(vlr.format(LimiteCredito)), "Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);

    }


    public double getSaldoDiponivel() {

        return getLimiteCredito() - getTotalCompras();
    }

    public String getDataVencimento() {

        return DataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        DataVencimento = dataVencimento;
        JOptionPane.showMessageDialog(null,"Seu cartão se vence em "+(dataVencimento), "Banco Digital", JOptionPane.INFORMATION_MESSAGE);

    }

}
