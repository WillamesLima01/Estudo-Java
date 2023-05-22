package classes;

import interfaces.ConfirmarConta;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.ArrayList;

public class ContaPoupanca extends Conta implements ConfirmarConta {

    private Double saldoCp;
    private Double poupanca;
    private boolean bloquearCp = true;

    ArrayList<String> extratoCp = new ArrayList<>();

    NumberFormat vlr = NumberFormat.getCurrencyInstance();//formatar moeda (vlr.format(valor))

    public ContaPoupanca() {

    }
    public Double getSaldoCp() {

        return saldoCp;
    }

    public void setSaldoCp(Double saldoCp) {

        this.saldoCp = saldoCp;
    }

    public Double getPoupanca() {

        return poupanca;
    }

    public void setPoupanca(Double poupanca) {

        this.poupanca = poupanca;
    }

    public void setabrirContaPoupanca(String VarCp){

        Clientes clientes = new Clientes();

        String[]opcao = {"Sim", "Não"};
        int resposta1 = JOptionPane.showOptionDialog(null, "Pesquisando no banco de dados verificamos que você não tem a conta poupança.\n"+"Deseja abrir a conta agora?","Criar Conta Poupança", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);

        if(resposta1 == 0) {
            int posCliente = getPosCliente();
            clientes.Cliente[posCliente][5]="51";
            setVariacao("51");
            JOptionPane.showMessageDialog(null, "Abertura de conta poupança realizada com sucesso!", "Conta Poupança", JOptionPane.INFORMATION_MESSAGE);
            setBloquearCp(true);
        } else{
            setBloquearCp(false);
        }

    }

    public boolean isBloquearCp() {
        return bloquearCp;
    }

    public void setBloquearCp(boolean bloquearCp) {
        this.bloquearCp = bloquearCp;
    }

    @Override
    public Boolean confirmar(String tipoConta) {
        return getVariacao().equals("51");
    }

}
