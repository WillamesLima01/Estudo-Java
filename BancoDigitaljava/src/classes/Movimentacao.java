package classes;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Movimentacao {
    private double saldo;
    private double extrato;
    private double pagamento;
    private double transferencia;
    private double deposito;
    private double saque;
    private String descricaoExtrato;
    private String opcao;
    private Date dataAtual;
    private String dataTexto;
    private String contaTransferencia;
    
    NumberFormat vlr = NumberFormat.getCurrencyInstance();//formatar moeda (vlr.format(valor))
           
    
    public Movimentacao() {
		
	}

	    
   
	public String getOpcao() {
		return opcao;
	}



	public void setOpcao(String opcao) {
		
		switch (opcao) {
			case "1":
				this.descricaoExtrato = "Operação Saldo ; "+ this.dataTexto + ";  Valor  " + (vlr.format(this.saldo));
				break;
			case "2":
				this.descricaoExtrato = "Operação Extrato ; "+ this.dataTexto + ";  Valor  " + (vlr.format(this.saldo));
				break;
			case "3":
				this.descricaoExtrato = "Operação Saque ; "+ this.dataTexto + ";  Valor  " + (vlr.format(this.saque));
				break;
			case "4":
				this.descricaoExtrato = "Operação Depósito ; "+ this.dataTexto + ";  Valor  " + (vlr.format(this.saldo));
				break;
			case "5":
				this.descricaoExtrato = "Operação Transferência ; "+ this.dataTexto + "; Conta beneficiada : " + getcontaTransferencia() + "; Valor " + (vlr.format(this.getTransferencia()));
				break;
					
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

	public void setDataTexto(String datatexto) {
		this.dataTexto = datatexto;
	}

	public String getDescricaoExtrato() {
		return descricaoExtrato;
	}

	public void setDescricaoExtrato(String descricaoExtrato) {
		this.descricaoExtrato = descricaoExtrato;
	}	

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {    	
    	
        this.saldo =saldo;
        
    }

    public double getExtrato() {
        return extrato;
    }

    public void setExtrato(double extrato) {
        this.extrato = extrato;
    }

    public double getPagamento() {
        return pagamento;
    }

    public void setPagamento(double pagamento) {
        this.saldo -= pagamento;
        JOptionPane.showMessageDialog(null,"Pagamento efetuado com sucesso! Seu novo saldo é de " + (vlr.format(this.saldo)),"Saldo", JOptionPane.INFORMATION_MESSAGE);        
    }

    public double getTransferencia() {
        return transferencia;
    }
    
    public String getcontaTransferencia() {
    	return contaTransferencia;
    }

    public void setTransferencia(double transferencia, String contaTransferencia) {    	
    	
    	if (transferencia <= this.saldo) {
            this.saldo -= transferencia; 
            this.transferencia= transferencia;
            JOptionPane.showMessageDialog(null, "Transação realizada com sucesso","Transferência", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Seu novo saldo é "+ (vlr.format(this.saldo)),"Saldo conta corrente", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
        	            
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar essa transação!","Saldo", JOptionPane.INFORMATION_MESSAGE);
            
        }
        this.transferencia = transferencia;
        this.contaTransferencia = contaTransferencia;
        
    }

    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.saldo += deposito;        
        JOptionPane.showMessageDialog(null,"Seu novo saldo em conta corrente é de " + (vlr.format(this.saldo)),"Depósito", JOptionPane.INFORMATION_MESSAGE);
    }

    public double getSaque() {
        return saque;
    }

    public void setSaque(double saque) {
        if (saque <= this.saldo) {
            this.saldo -= saque; 
            this.saque= saque;
            JOptionPane.showMessageDialog(null, "Seu novo saldo é "+ (vlr.format(this.saldo)),"Saque", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
        	            
            JOptionPane.showMessageDialog(null, "Saldo insuficiente!","Saldo", JOptionPane.INFORMATION_MESSAGE);
            
        }

    }

    public double verificarSaldo(){
        return this.saldo;
    }

}
