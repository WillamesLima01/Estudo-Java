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
				this.descricaoExtrato = "Operação Transferência ; "+ this.dataTexto + ";  Valor  " + (vlr.format(this.saldo));
				break;
			case "6":
				this.descricaoExtrato = "Operação Pagamento ; "+ this.dataTexto + ";  Valor  " + (vlr.format(this.saldo));
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
        JOptionPane.showMessageDialog(null,"Pagamento efetuado com sucesso! Seu novo saldo é de " + (vlr.format(this.saldo)));        
    }

    public double getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(double transferencia) {
        this.transferencia = transferencia;
    }

    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.saldo += deposito;        
        JOptionPane.showMessageDialog(null,"Seu novo saldo em conta corrente é de " + (vlr.format(this.saldo)));
    }

    public double getSaque() {
        return saque;
    }

    public void setSaque(double saque) {
        if (saque <= this.saldo) {
            this.saldo -= saque; 
            this.saque= saque;
            JOptionPane.showMessageDialog(null, "Seu novo saldo é "+ (vlr.format(this.saldo)));
            
        } else {
        	            
            JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
            
        }

    }

    public double verificarSaldo(){
        return this.saldo;
    }

}
