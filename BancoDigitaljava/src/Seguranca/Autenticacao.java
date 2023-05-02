package Seguranca;

public class Autenticacao {
		
	private String cliente = "willames";
	private String senhaAcesso = "123";
	private String login;
	private String senha;
	
	public boolean Autenticar() {
		
		return login.equals(cliente) && senha.equals(senhaAcesso);
		
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		cliente = cliente;
	}


	public String getSenhaAcesso() {
		return senhaAcesso;
	}


	public void setSenhaAcesso(String senhaAcesso) {
		this.senhaAcesso = senhaAcesso;
	}


	
	
}
