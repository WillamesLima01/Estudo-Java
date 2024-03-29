package classes;

import java.sql.Date;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CartaoCredito {
	
	private double LimiteCredito = 3000;
	private double SaldoDiponivel;
	private Date DataVencimento;	
	private double aumentolimite;
	private String compras;
	private double TotalCompras;
	private String valorCompra;
	private String localCompra;
	private String dataCompra;
	private String cancelaropcao;	
	
	NumberFormat vlr = NumberFormat.getCurrencyInstance();//formatar moeda (vlr.format(valor))
		
	public CartaoCredito() {//método construtor
				
	}		
				
	public String getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(String valorCompra) {

		this.compras = "valor da compra : R$ "+ valorCompra;
		
	}

	public String getLocalCompra() {
		return localCompra;
	}

	public void setLocalCompra(String localCompra) {

		
		this.compras = this.compras + " ; Local da compra efetuada : " + localCompra;
		
	}

	public String getDataCompra() {
		return dataCompra;
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


	public void setTotalCompras(double totalCompras) {
				
		TotalCompras = totalCompras;
	}


	
	public double getAumentolimite() {
		return aumentolimite;
	}

	public void setAumentolimite(double aumentolimite) {
		
		if (aumentolimite > 10000) {
			
			JOptionPane.showMessageDialog(null,"O valor desejado precisa ser avaliado pela gerencia financiara!\n"+
					"                Favor entrar em contato com sua gerencia!");
			
		} else {
			
			LimiteCredito += aumentolimite;		
		
			JOptionPane.showMessageDialog(null,"Operação realizada com sucesso!\n"+"Seu novo limite de crédito é de "+(vlr.format(LimiteCredito)));
		}
	}		
	
	public double getLimiteCredito() {
		
		return LimiteCredito;
		
	}
	
	public void setLimiteCredito(double limiteCredito) {
		
		this.LimiteCredito = limiteCredito;
		
	}
	
	
	public double getSaldoDiponivel() {
		
		return SaldoDiponivel;
	}


	public void setSaldoDiponivel(double saldoDiponivel) {
		
		SaldoDiponivel = this.LimiteCredito - this.TotalCompras;
		JOptionPane.showMessageDialog(null,"Saldo "+(vlr.format(this.SaldoDiponivel)));
		
	}
	
	public Date getDataVencimento() {
		
		return DataVencimento;
		
	}
	
	public void setDataVencimento(Date dataVencimento) {
		
		DataVencimento = dataVencimento;
	}	
	
}
