package classes;

import interfaces.ConfirmarConta;

public class Procedimentos {
        private String opcao;
        private int opcaoDeposito;
        private String contaDep;

    Clientes clientes = new Clientes();
    ContaCorrente contaCorrente = new ContaCorrente();
    ContaPoupanca contaPoupanca = new ContaPoupanca();

    public Procedimentos() {

    }
    public void setcontaDeposito(int opcaoDeposito){

        switch (opcaoDeposito){
            case 0 -> contaDep = "1";
            case 1 -> contaDep = "5";
        }
        setconfirmarConta(contaDep);
    }
    public void setconfirmarConta(String opcao){

        switch (opcao) {
            case "1" -> clientes.setPosConta("4");
            case "5" -> clientes.setPosConta("5");
        }

        if(clientes.getPosConta()!= null) {

            clientes.buscarTipoDeConta(clientes.getPosConta());

            if (Conta.getVariacao().equals("0") && clientes.getPosConta().equals("4")) {
                ConfirmarConta conta = new ContaCorrente();
                if (!conta.confirmar(Conta.getVariacao())) { //A interrogação no início da sentença inverte o resultado
                    contaCorrente.setabrirContaCorrente(Conta.getVariacao());
                }
            } else if (Conta.getVariacao().equals("0") && clientes.getPosConta().equals("5")) {
                ConfirmarConta conta = new ContaPoupanca();
                if (!conta.confirmar(Conta.getVariacao())) {
                    contaPoupanca.setabrirContaPoupanca(Conta.getVariacao());
                }
            }
        }
    }
}
