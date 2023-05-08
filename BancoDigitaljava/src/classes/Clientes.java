package classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Seguranca.PermitirAcesso;

public class Clientes implements PermitirAcesso {
	
	private String nomeCompleto;
	private String nome;
	private String stilonome;
	private String datanasc;
	private String cpf;
	private String numeroCc;
	private String usuarioCadastro;
	private String senhaCadastro;
	private String senha;
	private String usuario;	
	private static String usuarioCliente;
	private static String senhaAcesso;
	private int n;	
	private static int x;	
	private int posLogin;
	private int posSenha;
	
		
	private static String[][]Cliente = new String[10][5];
	
	ArrayList<String>ClienteDados = new ArrayList<>();
			
	
	
	public void setClientesCadastrados(String ClientesCadastrados) {
		
		n = ClienteDados.size();		
						
		for(int y = 0; y < n; y++) {
			
			Cliente[x][y] = ClienteDados.get(y);
			
		}		
		
		x++;
				
	}	
	
	public void setConfirmarAcesso(String usuario, String senha) {
		
		this.usuario = usuario;
		this.senha = senha;
		Boolean sair = false;
		
		for(int i = 0; i < 5; i++) {
			
			for(int j = 0; j < Cliente[i].length; j++){
				
				if(Cliente[j][0] == null) {
					
					JOptionPane.showMessageDialog(null, "Dados não encontrados no banco de dados!","ATENÇÃO!", JOptionPane.INFORMATION_MESSAGE);
					sair = true;
					break;
				}
				if(Cliente[j][posLogin].equals(usuario) && Cliente[j][posSenha].equals(senha)) {
					
					usuarioCliente = Cliente[j][posLogin];
					senhaAcesso = Cliente[j][posSenha];	
					sair = true;
					break;
				}
			}			
			
			if(sair) {
				
				break;
				
			}
		}	
		
		
	}
				
		
	public String getNumeroCc() {
		return numeroCc;
	}

	public void setNumeroCc(String numeroCc) {
		this.numeroCc = numeroCc;
		ClienteDados.add(numeroCc);
	}

	public String getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(String usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
		ClienteDados.add(usuarioCadastro);
	}

	public String getSenhaCadastro() {
		return senhaCadastro;
	}

	public void setSenhaCadastro(String senhaCadastro) {
		this.senhaCadastro = senhaCadastro;
		ClienteDados.add(senhaCadastro);		
		setClientesCadastrados(senhaCadastro);
		
	}	
	
	public ArrayList<String> getClienteDados() {
		return ClienteDados;
	}

	public void setClienteDados(ArrayList<String> clienteDados) {
		ClienteDados = clienteDados;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
		ClienteDados.add(nomeCompleto);
		setNome(nomeCompleto);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		
		String[] primeironome;			
		
		primeironome = nome.split(" ");
		
		int qc = primeironome[0].length();
		
		if(qc < 4) {
			//usei uma array dentro da formula para converter as primeiras letras do nome composto
			stilonome = primeironome[0].substring(0, 1).toUpperCase() + primeironome[0].substring(1) +
					" " + primeironome[1].substring(0, 1).toUpperCase() + primeironome[1].substring(1);
						
		} else {
			
			stilonome = primeironome[0];
			stilonome = stilonome.substring(0, 1).toUpperCase() + stilonome.substring(1);
		}		
				
		this.nome = stilonome;
		
	}

	public String getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
		ClienteDados.add(datanasc);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
		ClienteDados.add(cpf);
	}
	
	public String getUsuarioCliente() {
		return usuarioCliente;
	}

	public void setUsuarioCliente(String usuarioCliente) {
		this.usuarioCliente = usuarioCliente;
	}

	public String getSenhaAcesso() {
		return senhaAcesso;
	}

	public void setSenhaAcesso(String senhaAcesso) {
		this.senhaAcesso = senhaAcesso;
	}	

	public int getPosLogin() {
		return posLogin;
	}

	public void setPosLogin(int posLogin) {
		this.posLogin = posLogin;
	}

	public int getPosSenha() {
		return posSenha;
	}

	public void setPosSenha(int posSenha) {
		this.posSenha = posSenha;
	}


	@Override
	public Boolean validar(String usuario, String senha) {// validar login e senha
		
		return this.usuarioCliente.equals(usuario) && this.senhaAcesso.equals(senha);
		
	}
}
