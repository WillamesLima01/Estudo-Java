package entidades;

import javax.swing.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ContaPoupanca extends Conta {

    private Double saldoCp;
    private Double poupanca = 0.0;
    private String dataTexto;
    private static boolean bloquearCp;
    private String contaDestino;

    NumberFormat vlr = NumberFormat.getCurrencyInstance();//formatar moeda (vlr.format(valor))

    public ContaPoupanca() {

    }

    public void setSaldoCp(Double saldoCp) {
        this.saldoCp = saldoCp;
        this.poupanca += this.saldoCp;
        JOptionPane.showMessageDialog(null, "Seu novo saldo em conta poupança é " + (vlr.format(this.poupanca)), "Saldo", JOptionPane.INFORMATION_MESSAGE);

    }

    public Double getRendimentoPoupanca() {
        if (this.poupanca != 0.0) {
            return this.poupanca + (this.poupanca * 0.02);
        } else {
            return 0.0;
        }
    }

    public void setSaqueCp(Double saqueCp) {
        if (saqueCp <= this.poupanca) {
            this.poupanca -= saqueCp;
            setSaldo(this.poupanca);
            JOptionPane.showMessageDialog(null, "Saque no valor de " + (vlr.format(saqueCp) + " realizado com sucesso"), "Saque Conta Poupança", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Seu novo saldo é " + (vlr.format(getSaldo())), "Saldo Conta Poupança", JOptionPane.INFORMATION_MESSAGE);

        } else {

            JOptionPane.showMessageDialog(null, "Saldo insuficiente!", "Saldo", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public String getContaDestino() {

        return contaDestino;
    }

    public void setContaDestino(String contaDestino) {

        this.contaDestino = contaDestino;
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
                    setDescricaoExtrato("Operação Consulta rendimento ; " + "Cc Var:51 ; " + "Data/Hora : " + this.dataTexto + ";  Valor " + (vlr.format(getRendimentoPoupanca()) + ";  Rendimento " + (vlr.format(getRendimentoPoupanca() - this.poupanca))));
            case "5" ->
                    setDescricaoExtrato("Operação Depósito ; " + "Cc Var:51 ; " + "Data/Hora : " + this.dataTexto + ";  Valor  " + (vlr.format(this.getDeposito())));
            case "6" ->
                    setDescricaoExtrato("Operação Transferência ; " + this.dataTexto + "; Conta beneficiada : " + getContaDestino() + "; Valor " + (vlr.format(this.getTransferencia())));
        }
    }

    public void setDataAtual(Date dataAtual) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.dataTexto = dateFormat.format(dataAtual);
    }

    public Double getPoupanca() {

        return poupanca;
    }

    public boolean isBloquearCp() {

        return bloquearCp;
    }

    public void setBloquearCp(boolean bloquearCp) {

        ContaPoupanca.bloquearCp = bloquearCp;
    }

    public void settransferenciaCp(Double transferencia) {
        if (poupanca >= transferencia) {
            poupanca -= transferencia;
            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso senhor(a) " + getLogado(), "Transferência Conta Poupança", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Sado em conta poupança insuficiente!", "Transferência Conta Poupança", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static Clientes abrirContaPoupanca(Map<String, List<Clientes>> clienteMap, String varConta) {
        for (List<Clientes> listaClientes : clienteMap.values()) {
            for (Clientes cliente : listaClientes) {
                if (cliente.getVarCp() == 0) {
                    cliente.setVarCp(Integer.parseInt(varConta));
                    Conta.setVariacao(Integer.parseInt(varConta));
                    JOptionPane.showMessageDialog(null, "Abertura de conta poupança realizada com sucesso senhor(a) " + cliente.getNome() + "! ", "Conta Poupança", JOptionPane.INFORMATION_MESSAGE);
                    return cliente;
                }
            }
        }
        return null; // Cliente não encontrado
    }

}
