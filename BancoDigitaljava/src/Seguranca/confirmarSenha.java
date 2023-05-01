package Seguranca;

public class confirmarSenha {
		
	private String senhaPermissao;
	
	Autenticacao autenticacao = new Autenticacao();
	
	public boolean permissao() {
		
		return senhaPermissao.equals(autenticacao.getSenha());
		
	}


	public String getSenhaPermissao() {
		return senhaPermissao;
	}


	public void setSenhaPermissao(String senhaPermissao) {
		this.senhaPermissao = senhaPermissao;
		
	}	
	
}
