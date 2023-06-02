package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Procedimentos {

    private String usuario;
    private String senha;
    private boolean permissao=false;
    private int varCc;
    private int varCp;

    Clientes clientes = new Clientes();
    ContaCorrente contaCorrente = new ContaCorrente();
    ContaPoupanca contaPoupanca = new ContaPoupanca();

    public Procedimentos(){

    }
    public Procedimentos(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String confirmarConta(Map<String, List<Clientes>> clienteMap, String chave) {
        for (List<Clientes> listaClientes : clienteMap.values()) {
            for (Clientes cliente : listaClientes) {
                if (cliente.getVarCc()==Integer.parseInt(chave)) {
                    return chave;
                } else if (cliente.getVarCp()==Integer.parseInt(chave)) {
                    return chave;
                }
            }
        }
        return null; // Cliente não encontrado
    }

    public void validaConta(ArrayList<Clientes> listaClientes){


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

        }

    }

    public String getUsuario() {

        return usuario;
    }

    public void setUsuario(String usuario) {

        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {

        this.senha = senha;
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
}
