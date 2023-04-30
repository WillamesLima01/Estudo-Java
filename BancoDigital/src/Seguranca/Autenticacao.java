package Seguranca;

public class Autenticacao {
		
	private String login = "willames";
	private String senha = "123";
	
	
	public boolean Autenticar() {
		
		return login.equals(login) && senha.equals(senha);
		
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
