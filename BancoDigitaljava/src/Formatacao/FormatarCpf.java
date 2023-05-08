package Formatacao;

import java.text.DecimalFormat;

public class FormatarCpf {
	
	private String cpfnumero;
	private String cpfformatado;
	
	
	public void setCpfnumero(String cpfnumero) {
		this.cpfnumero = cpfnumero;
	}	
	
	public String getCpfformatado() {
		
		DecimalFormat format = new DecimalFormat("00000000000");
        this.cpfformatado = format.format(Long.parseLong(cpfnumero));
        return this.cpfformatado.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
				
	}	
	
}
