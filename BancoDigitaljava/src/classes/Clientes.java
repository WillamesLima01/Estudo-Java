package classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.PermitirAcesso;

public class Clientes implements PermitirAcesso {
	
	private String nomeCompleto;
	private String nome;
	private String datanasc;
	private String cpf;
	private String numeroCc;
	private String usuarioCadastro;
	private String senhaCadastro;
	private static String usuarioCliente;
	private static String senhaAcesso;
	private static int x;
	private int posLogin;
	private int posSenha;
	private String opcaoC;
	private String posConta;// posição para identificar qual variação de conta vai utilizar no momento
	private int poscliente;
		
	public static String[][]Cliente = new String[10][7];

	ArrayList<String>ClienteDados = new ArrayList<>();

	ContaCorrente contaCorrente = new ContaCorrente();
	ContaPoupanca contaPoupanca = new ContaPoupanca();

	public void setClientesCadastrados(String ClientesCadastrados) {

		int n = ClienteDados.size();
						
		for(int y = 0; y < n; y++) {
			Cliente[x][y] = ClienteDados.get(y);
		}
		x++;
	}	
	
	public void setConfirmarAcesso(String usuario, String senha) {

		boolean sair = false;
		
		for(int i = 0; i < 7; i++) {
			
			for(int j = 0; j < Cliente[i].length; j++){
				
				if(Cliente[j][0] == null) {
					
					JOptionPane.showMessageDialog(null, "Dados não encontrados no banco de dados!","ATENÇÃO!", JOptionPane.INFORMATION_MESSAGE);
					sair = true;
					break;
				}
				if(Cliente[j][posLogin].equals(usuario) && Cliente[j][posSenha].equals(senha)) {

					usuarioCliente = Cliente[j][posLogin];
					senhaAcesso = Cliente[j][posSenha];
					contaCorrente.setConta(Cliente[j][3]);
					contaCorrente.setPosCliente(j);
					sair = true;
					break;
				}
			}			
			
			if(sair) {
				
				break;
				
			}
		}	
		
		
	}

	public void buscarTipoDeConta(String varConta){
		int y = Integer.valueOf(varConta);
		int x = Integer.valueOf(contaCorrente.getPosCliente());
		contaCorrente.setVariacao(Cliente[x][y]);
	}
	public void Reiniciarlista(){
		ClienteDados = new ArrayList<>();
	}

	public String getPosConta() {
		return posConta;
	}

	public void setPosConta(String posConta) {
		this.posConta = posConta;
	}

	public String getNumeroCc() {
		return numeroCc;
	}

	public void setNumeroCc(String numeroCc) {
		this.numeroCc = numeroCc;
		ClienteDados.add(numeroCc);
	}

	public String getOpcaoC() {
		return opcaoC;
	}

	public void setOpcaoC(String opcaoC) {
		this.opcaoC = opcaoC;
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
		if(this.opcaoC.equals("10")){
			ClienteDados.add("10");
			ClienteDados.add("0");
		} else {
			ClienteDados.add("0");
			ClienteDados.add("51");
		}
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

		String stilonome;
		if(qc < 4) {
			//usei uma array dentro da fórmula para converter as primeiras letras do nome composto
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
