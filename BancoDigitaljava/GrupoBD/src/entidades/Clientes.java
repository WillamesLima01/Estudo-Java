package entidades;

import interfaces.PermitirAcesso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Clientes implements PermitirAcesso {

    private String nomeCompleto;
    private String nome;
    private String datanasc;
    private String cpf;
    private String conta;
    private String email;
    private String contato;
    private int varCc;
    private int varCp;
    private int varCi;
    private String senha;

    private static final ArrayList<Clientes> listaClientes = new ArrayList<>();

    public Clientes(){

    }

    public Clientes(String nomeCompleto, String nome, String datanasc, String cpf, String conta, String email, String contato, int varCc, int varCp, int varCi, String senha) {
        this.nomeCompleto = nomeCompleto;
        this.nome = nome;
        this.datanasc = datanasc;
        this.cpf = cpf;
        this.conta = conta;
        this.email = email;
        this.contato = contato;
        this.varCc = varCc;
        this.varCp = varCp;
        this.varCi = varCi;
        this.senha = senha;
        listaClientes.add(this);
    }

    public String getNome() {

        return nome;
    }

    public String getDatanasc() {

        return datanasc;
    }

    public String getCpf() {

        return cpf;
    }

    public String getConta() {

        return conta;
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

    public int getVarCi() {
        return varCi;
    }

    public void setVarCi(int varCi) {
        this.varCi = varCi;
    }

    public String getSenha() {

        return senha;
    }

    public static Clientes buscarClientePorChave(Map<String, List<Clientes>> clienteMap, String chave) {
        for (List<Clientes> listaClientes : clienteMap.values()) {
            for (Clientes cliente : listaClientes) {
                if (cliente.getCpf() != null && cliente.getCpf().equals(chave)) {
                    return cliente;
                } else if (cliente.getDatanasc() != null && cliente.getDatanasc().equals(chave)) {
                    return cliente;
                } else if (cliente.getConta() != null && cliente.getConta().equals(chave)) {
                    return cliente;
                }
            }
        }
        return null; // Cliente não encontrado
    }

    @Override
    public Boolean validar(String senha, String usuarioSenha) {// validar login e senha

        return (usuarioSenha.equals(senha));

    }
}
