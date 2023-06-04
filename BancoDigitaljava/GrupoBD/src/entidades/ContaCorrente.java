package entidades;

import interfaces.ConfirmarConta;

import javax.swing.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ContaCorrente extends Conta implements ConfirmarConta {

    private Double saldoCc = 0.0;
    private Double contaCorrente = 0.0;
    private double limiteChequeEspecial;
    private String dataTexto;
    private static boolean bloquearCc;
    private String contaDestino;

    ArrayList<String> extratoCc = new ArrayList<>();

    NumberFormat vlr = NumberFormat.getCurrencyInstance();//formatar moeda (vlr.format(valor))

    public ContaCorrente() {

    }

    public void setSaldoCc(Double saldoCc) {
        this.saldoCc = saldoCc;
        this.contaCorrente += this.saldoCc;
        JOptionPane.showMessageDialog(null, "Seu novo saldo em conta corrente é "+ (vlr.format(this.contaCorrente)),"Saldo", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setSaqueCc(Double saqueCc) {
        if (saqueCc <= this.contaCorrente) {
            this.contaCorrente -= saqueCc;
            setSaldo(this.contaCorrente);
            JOptionPane.showMessageDialog(null, "Saque no valor de "+ (vlr.format(saqueCc) +" realizado com sucesso"),"Saque Conta Corrente", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Seu novo saldo é "+ (vlr.format(getSaldo())),"Saldo Conta Corrente", JOptionPane.INFORMATION_MESSAGE);

        } else {

            JOptionPane.showMessageDialog(null, "Saldo insuficiente!","Saldo Conta Corrente", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public Double getContaCorrente() {

        return contaCorrente;
    }

    public String getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }

    public double getLimiteChequeEspecial() {

        return limiteChequeEspecial;
    }
    public void setLimiteChequeEspecial(double limiteChequeEspecial) {

        this.limiteChequeEspecial = limiteChequeEspecial;
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

    public static Clientes abrirContaCorrente(Map<String, List<Clientes>> clienteMap, String varConta) {
        for (List<Clientes> listaClientes : clienteMap.values()) {
            for (Clientes cliente : listaClientes) {
                if (cliente.getVarCc() == 0) {
                    cliente.setVarCc(Integer.parseInt(varConta));
                    Conta.setVariacao(Integer.parseInt(varConta));
                    JOptionPane.showMessageDialog(null, "Abertura de conta corrente realizada com sucesso senhor(a) "+cliente.getNome()+"! ", "Conta Corrente", JOptionPane.INFORMATION_MESSAGE);
                    return cliente;
                }
            }
        }
        return null; // Cliente não encontrado
    }

    public void settransferenciaCc(Double transferencia){
        if(contaCorrente >= transferencia) {
            contaCorrente -= transferencia;
            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso senhor(a) " + getLogado(), "Transferência Conta Corrente", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Saldo em conta corrente insuficiente!", "Transferência Conta Corrente", JOptionPane.INFORMATION_MESSAGE);
        }
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
                    setDescricaoExtrato("Operação Transferência ; " + this.dataTexto + "; Conta beneficiada : " + getContaDestino() + "; Valor " + (vlr.format(this.getTransferencia())));
        }
    }

    @Override
    public Boolean confirmar(String tipoConta) {

        return (getVariacao()==Integer.parseInt(tipoConta));

    }

}
