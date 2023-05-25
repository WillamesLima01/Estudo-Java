package classes;

import interfaces.ConfirmarConta;

import javax.swing.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ContaPoupanca extends Conta implements ConfirmarConta {

    private Double saldoCp;
    private Double poupanca=0.0;
    private Double saqueCp;
    private String opcao;
    private Date dataAtual;
    private String dataTexto;
    private static boolean bloquearCp;

    ArrayList<String> extratoCp = new ArrayList<>();

    NumberFormat vlr = NumberFormat.getCurrencyInstance();//formatar moeda (vlr.format(valor))

    public ContaPoupanca() {

    }
    public Double getSaldoCp() {

        return saldoCp;
    }

    public void setSaldoCp(Double saldoCp) {
        this.saldoCp = saldoCp;
        this.poupanca += this.saldoCp;
        JOptionPane.showMessageDialog(null, "Seu novo saldo em conta poupança é "+ (vlr.format(this.poupanca)),"Saldo", JOptionPane.INFORMATION_MESSAGE);
    }

    public Double getSaqueCp() {
        return saqueCp;
    }

    public void setSaqueCp(Double saqueCp) {
        this.saqueCp = saqueCp;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {

        Date dataAtual = new Date();
        setDataAtual(dataAtual);

        switch (opcao) {
            case "1" ->
                    setDescricaoExtrato("Operação Saldo ; " + "Cc Var:51 ; " + "Data/Hora : " + this.dataTexto + ";  Valor  " + (vlr.format(this.poupanca)));
            case "2" ->
                    setDescricaoExtrato("Operação Extrato ; " + this.dataTexto + ";  Valor  " + (vlr.format(this.saldoCp)));
            case "3" ->
                    setDescricaoExtrato("Operação Saque ; " + "Cc Var:51 ; " + "Data/Hora : " + this.dataTexto + ";  Valor  " + (vlr.format(getSaque())));
            case "4" ->
                    setDescricaoExtrato("Operação Depósito ; " + "Cc Var:51 ; " + "Data/Hora : " + this.dataTexto + ";  Valor  " + (vlr.format(this.getDeposito())));
            case "5" ->
                    setDescricaoExtrato("Operação Transferência ; " + this.dataTexto + "; Conta beneficiada : " + getTransferencia() + "; Valor " + (vlr.format(this.getTransferencia())));
        }
    }

    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.dataTexto = dateFormat.format(dataAtual);
    }

    public String getDataTexto() {
        return dataTexto;
    }

    public void setDataTexto(String dataTexto) {
        this.dataTexto = dataTexto;
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
            //clientes.Cliente[posCliente][5]="51";
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
