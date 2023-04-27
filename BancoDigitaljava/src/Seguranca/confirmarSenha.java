package Seguranca;

public class confirmarSenha {
		
	private String senhaPermissao;
	
	
	public boolean permissao() {
		
		return senhaPermissao.equals("123456");
		
	}


	public String getSenhaPermissao() {
		return senhaPermissao;
	}


	public void setSenhaPermissao(String senhaPermissao) {
		this.senhaPermissao = senhaPermissao;
		
	}	
	
}
