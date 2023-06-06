package entidades;

import javax.swing.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ContaInvestimento extends Conta {

    private String dataTexto;
    private static Boolean bloquearCi;
    private Double rendimento = 0.0;

    NumberFormat vlr = NumberFormat.getCurrencyInstance();//formatar moeda (vlr.format(valor))

    public ContaInvestimento() {

    }

    public boolean isBloquearCi() {

        return bloquearCi;
    }

    public static void setBloquearCi(boolean bloquearCi) {

        ContaInvestimento.bloquearCi = bloquearCi;
    }

    public Double getRendimento() {
        return rendimento;
    }

    public void setRendimento(Double rendimento) {
        this.rendimento += rendimento;

        JOptionPane.showMessageDialog(null, "Seu novo saldo em conta investimento é de " + (vlr.format(this.rendimento)), "Saldo Conta Investimento", JOptionPane.INFORMATION_MESSAGE);

    }

    public void setSaqueCi(Double saqueCi) {
        if (saqueCi <= this.rendimento) {
            this.rendimento -= saqueCi;
            setSaldo(this.rendimento);
            JOptionPane.showMessageDialog(null, "Saque no valor de " + (vlr.format(saqueCi) + " realizado com sucesso"), "Saque Conta Investimento", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Seu novo saldo é " + (vlr.format(getSaldo())), "Saldo Conta Poupança", JOptionPane.INFORMATION_MESSAGE);

        } else {

            JOptionPane.showMessageDialog(null, "Saldo insuficiente!", "Saldo", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public static Clientes abrirContaInvestimento(Map<String, List<Clientes>> clienteMap, String varConta) {
        for (List<Clientes> listaClientes : clienteMap.values()) {
            for (Clientes cliente : listaClientes) {
                if (cliente.getVarCi() == 0) {
                    cliente.setVarCi(Integer.parseInt(varConta));
                    Conta.setVariacao(Integer.parseInt(varConta));
                    JOptionPane.showMessageDialog(null, "Abertura de conta investimento realizada com sucesso senhor(a) " + cliente.getNome() + "! ", "Conta Investimento", JOptionPane.INFORMATION_MESSAGE);
                    return cliente;
                }
            }
        }
        return null; // Cliente não encontrado
    }

    public void setDataAtual(Date dataAtual) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.dataTexto = dateFormat.format(dataAtual);
    }

    public void setOpcao(String opcao) {

        Date dataAtual = new Date();
        setDataAtual(dataAtual);

        switch (opcao) {
            case "1" ->
                    setDescricaoExtrato("Operação Saldo ; " + "Ci Var:61 ; " + "Data/Hora : " + this.dataTexto + ";  Valor  " + (vlr.format(this.rendimento)));
            case "2" ->
                    setDescricaoExtrato("Operação Extrato ; " + this.dataTexto + ";  Valor  " + (vlr.format(this.rendimento)));
            case "3" ->
                    setDescricaoExtrato("Operação Saque ; " + "Ci Var:61 ; " + "Data/Hora : " + this.dataTexto + ";  Valor  " + (vlr.format(getSaque())));
            case "4" ->
                    setDescricaoExtrato("Operação Consulta rendimento ; " + "Ci Var:61 ; " + "Data/Hora : " + this.dataTexto + ";  Valor  " + (vlr.format(rendimento)) + " ;  rendimento " + (vlr.format(rendimento - getSaldo())) );
            case "5" ->
                    setDescricaoExtrato("Operação Depósito ; " + "Ci Var:61 ; " + "Data/Hora : " + this.dataTexto + ";  Valor  " + (vlr.format(getSaldo())));

        }
    }

    public Double RendimentoInvestimento () {
        if(this.rendimento != 0.0) {
            this.setSaldo(rendimento);
            rendimento += getSaldo() * 0.10; // Calcula o rendimento (10% do saldo atual)
            return rendimento; // retorna o rendimento atual
        }else {
            return 0.0;
        }
    }

}

