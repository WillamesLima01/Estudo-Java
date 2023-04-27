package Seguranca;

public class Autenticacao {
		
	private String login;
	private String senha;
	
	
	public boolean Autenticar() {
		
		return login.equals("willames") && senha.equals("123");
		
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
	
	
	
}
