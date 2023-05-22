package Seguranca;

import classes.Clientes;

public class confirmarSenha {
		
	private String senhaPermissao;
	
	Clientes clientes = new Clientes();
	
	public boolean permissao() {
		return senhaPermissao.equals(clientes.getSenhaAcesso());
	}
	public String getSenhaPermissao() {

		return senhaPermissao;
	}

	public void setSenhaPermissao(String senhaPermissao) {
		this.senhaPermissao = senhaPermissao;
		
	}	
	
}
