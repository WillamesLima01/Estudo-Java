package classes;

import java.util.ArrayList;

import interfaces.PermitirAcesso;

public class Clientes implements PermitirAcesso {
	
	private String nomeCompleto;
	private String nome;
	private String datanasc;
	private String cpf;
	private String conta;
	private String email;
	private int varCc;
	private int varCp;
	private String senha;

	private static ArrayList<Clientes> listaClientes = new ArrayList<>();

	public Clientes(){

	}
	public Clientes(String nomeCompleto, String nome, String datanasc, String cpf, String conta, String email,
					int varCc, int varCp, String senha) {
		this.nomeCompleto = nomeCompleto;
		this.nome = nome;
		this.datanasc = datanasc;
		this.cpf = cpf;
		this.conta = conta;
		this.email = email;
		this.varCc = varCc;
		this.varCp = varCp;
		this.senha = senha;
		listaClientes.add(this);
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getVarCc() {
		return varCc;
	}

	public void setVarCc(int varCc) {
		this.varCc = varCc;
	}

	public int getVarCp() {
		return varCp;
	}

	public void setVarCp(int varCp) {
		this.varCp = varCp;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static ArrayList<Clientes> getListaClientes() {
		return listaClientes;
	}
	public static void adicionarCliente(Clientes cliente) {
		listaClientes.add(cliente);
	}


	@Override
	public Boolean validar(String usuario, String senha) {// validar login e senha

		boolean permissao = false;

		for (Clientes cliente : listaClientes) {
			if (cliente.getDatanasc().equals(usuario) && cliente.getSenha().equals(senha)) {
				permissao=true;
				break;
			} else if (cliente.getCpf().equals(usuario) && cliente.getSenha().equals(senha)) {
				permissao=true;
				break;
			} else if (cliente.getConta().equals(usuario) && cliente.getSenha().equals(senha)) {
				permissao=true;
				break;
			}
			// outros atributos e métodos que você deseja acessar
		}

		return permissao;

	}
}
