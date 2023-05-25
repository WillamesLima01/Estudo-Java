package classes;

import interfaces.ConfirmarConta;

import javax.swing.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ContaCorrente extends Conta implements ConfirmarConta {

    private Double saldoCc = 0.0;
    private Double contaCorrente = 0.0;
    private double limiteChequeEspecial;
    private Double saqueCc;
    private String opcao;
    private Date dataAtual;
    private String dataTexto;
    private static boolean bloquearCc;

    ArrayList<String> extratoCc = new ArrayList<>();

    NumberFormat vlr = NumberFormat.getCurrencyInstance();//formatar moeda (vlr.format(valor))
    public ContaCorrente() {

    }
    public Double getSaldoCc() {
        return saldoCc;
    }
    public void setSaldoCc(Double saldoCc) {
        this.saldoCc = saldoCc;
        this.contaCorrente += this.saldoCc;
        JOptionPane.showMessageDialog(null, "Seu novo saldo em conta corrente é "+ (vlr.format(this.contaCorrente)),"Saldo", JOptionPane.INFORMATION_MESSAGE);
    }

    public Double getSaqueCc() {
        return saqueCc;
    }

    public void setSaqueCc(Double saqueCc) {
        if (saqueCc <= this.contaCorrente) {
            this.contaCorrente -= this.saqueCc;
            setSaldo(this.contaCorrente);

            JOptionPane.showMessageDialog(null, "Seu novo saldo é "+ (vlr.format(getSaldo())),"Saque", JOptionPane.INFORMATION_MESSAGE);

        } else {

            JOptionPane.showMessageDialog(null, "Saldo insuficiente!","Saldo", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public Double getContaCorrente() {

        return contaCorrente;
    }
    public void setContaCorrente(Double contaCorrente) {

        this.contaCorrente = contaCorrente;
    }


    public double getLimiteChequeEspecial() {

        return limiteChequeEspecial;
    }
    public void setLimiteChequeEspecial(double limiteChequeEspecial) {

        this.limiteChequeEspecial = limiteChequeEspecial;
    }
    public void setabrirContaCorrente(String varCc){
        Clientes clientes = new Clientes();

        String[]opcao = {"Sim", "Não"};
        int resposta1 = JOptionPane.showOptionDialog(null, "Pesquisando no banco de dados verificamos que você não tem a conta corrente.\n"+"Deseja abrir a conta agora?","Criar Conta Corrente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);

        if(resposta1 == 0) {
            int posCliente = getPosCliente();
           // clientes.Cliente[getPosCliente()][4]="10";
            setVariacao("10");
            JOptionPane.showMessageDialog(null, "Abertura de conta corrente realizada com sucesso!", "Conta Corrente", JOptionPane.INFORMATION_MESSAGE);
            bloquearCc=true;
        } else {
            bloquearCc=false;
        }
    }
    public Date getDataAtual() {

        return dataAtual;
    }
    public void setDataAtual(Date dataAtual) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.dataTexto = dateFormat.format(dataAtual);
    }
    public boolean isBloquearCc() {
        return bloquearCc;
    }
    public void setBloquearCc(boolean bloquearCc) {
        this.bloquearCc = bloquearCc;
    }
    public void setOpcao(String opcao) {

        Date dataAtual = new Date();
        setDataAtual(dataAtual);

        switch (opcao) {
            case "1" ->
                    setDescricaoExtrato("Operação Saldo ; " + "Cc Var:10 ; " + "Data/Hora : " + this.dataTexto + ";  Valor  " + (vlr.format(this.contaCorrente)));
            case "2" ->
                    setDescricaoExtrato("Operação Extrato ; " + this.dataTexto + ";  Valor  " + (vlr.format(this.saldoCc)));
            case "3" ->
                    setDescricaoExtrato("Operação Saque ; " + "Cc Var:10 ; " + "Data/Hora : " + this.dataTexto + ";  Valor  " + (vlr.format(getSaque())));
            case "4" ->
                    setDescricaoExtrato("Operação Depósito ; " + "Cc Var:10 ; " + "Data/Hora : " + this.dataTexto + ";  Valor  " + (vlr.format(this.getDeposito())));
            case "5" ->
                    setDescricaoExtrato("Operação Transferência ; " + this.dataTexto + "; Conta beneficiada : " + getTransferencia() + "; Valor " + (vlr.format(this.getTransferencia())));
        }
    }

    @Override
    public Boolean confirmar(String tipoConta) {
        return getVariacao().equals("10");
    }

}
