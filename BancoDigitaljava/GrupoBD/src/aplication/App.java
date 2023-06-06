package aplication;

import Formatacao.*;
import entidades.*;
import interfaces.PermitirAcesso;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.*;

import static entidades.Clientes.buscarClientePorChave;
import static entidades.ContaCorrente.abrirContaCorrente;
import static entidades.ContaInvestimento.abrirContaInvestimento;
import static entidades.ContaPoupanca.abrirContaPoupanca;

public class App {

    public static void main(String[] args) {

        String usuario = " ";
        boolean sairSistema = true;
        Random random = new Random();

        ContaCorrente contaCorrente = new ContaCorrente();
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        ContaInvestimento contaInvestimento = new ContaInvestimento();

        Map<String, List<Clientes>> cliente = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        String[] opcoes = {"Conta Corrente","Conta Poupança", "Conta Investimento"};

        while (sairSistema) {

            try{

                int resposta = JOptionPane.showConfirmDialog(null, "Bem vindo! o senhor já é Cliente? ","Banco Digital", JOptionPane.YES_NO_CANCEL_OPTION);

                if (resposta == 1) {

                    int resposta2 = JOptionPane.showConfirmDialog(null, "Deseja abrir sua conta no banco digital? ","Informação com segurança", JOptionPane.YES_NO_CANCEL_OPTION);

                    if (resposta2 == 0) {//criar conta no aplicativo banco digital

                        int opcaoC = JOptionPane.showOptionDialog(null, "Escolha o tipo de conta:", "Tipo de conta", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

                        int varCc = 0;
                        int varCp = 0;
                        int varCi = 0;

                        switch (opcaoC){
                            case 0 -> varCc = 10;
                            case 1 -> varCp = 51;
                            case 2 -> varCi = 61;
                        }

                        String nomeCompleto = JOptionPane.showInputDialog(null,"Informe o nome completo do usuário : ","Banco Digital", JOptionPane.INFORMATION_MESSAGE);
                        String dataNascimento = JOptionPane.showInputDialog(null,"Informe a data de nascimeto : \n"+"Ex.: 01011001","Banco Digital", JOptionPane.INFORMATION_MESSAGE);
                        String cpf = JOptionPane.showInputDialog(null,"Informe o CPF : \n"+"Ex.: 12345678910","Banco Digital", JOptionPane.INFORMATION_MESSAGE);
                        String email = JOptionPane.showInputDialog(null,"Informe e-mail : \n","Banco Digital", JOptionPane.INFORMATION_MESSAGE);
                        String contato = JOptionPane.showInputDialog(null,"Informe um número para contato : \n"+"Ex.: DD911111111","Banco Digital", JOptionPane.INFORMATION_MESSAGE);

                        int numerogerado = random.nextInt(90000) + 10000; // gera um número aleatório entre 1000 e 9999

                        FormatarCpf formatarCpf = new FormatarCpf();
                        FormatarData formatarData = new FormatarData();
                        FormatarConta formatarConta = new FormatarConta();
                        FormatarNome formatarNome = new FormatarNome();
                        FormatarTelefone telefone = new FormatarTelefone();

                        formatarNome.setNome(nomeCompleto);
                        String nome = formatarNome.getNome();
                        formatarCpf.setCpfnumero(cpf);
                        cpf = formatarCpf.getCpfformatado();
                        formatarData.setDataTx(dataNascimento);
                        dataNascimento = formatarData.getDataTx();
                        telefone.setNumeroTelefone(contato);
                        contato= telefone.getNumeroTelefone();
                        formatarConta.setNumeroConta(String.valueOf(numerogerado));
                        String numeroCc = formatarConta.getNumeroConta();

                        String senhaCadastro = "";
                        boolean sair = true;

                        while(sair) {

                            senhaCadastro = JOptionPane.showInputDialog(null,"Informe a senha : \n"+"Obs.: Senha númerica. Use a sequência de 0 a 9 e digite sua senha ","Banco Digital", JOptionPane.INFORMATION_MESSAGE);
                            String senhaCadastroConfirme = JOptionPane.showInputDialog(null,"Confirme a senha : ","Banco Digital", JOptionPane.INFORMATION_MESSAGE);

                            if(senhaCadastro.equals(senhaCadastroConfirme)) {

                                sair = false;

                            } else {

                                JOptionPane.showMessageDialog(null, "Senha não conferem!", "ATENÇÃO!!!", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        Clientes clientes1 = new Clientes(nomeCompleto,nome,dataNascimento,cpf,numeroCc,email,contato,varCc,varCp,varCi,senhaCadastro);

                        List<String> chaves = new ArrayList<>();
                        chaves.add(clientes1.getCpf());
                        chaves.add(clientes1.getDatanasc());
                        chaves.add(clientes1.getConta());

                        for (String chave : chaves) {
                            if (!cliente.containsKey(chave)) {
                                cliente.put(chave, new ArrayList<>());
                            }
                            cliente.get(chave).add(clientes1);
                        }

                        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso senhor(a), "+ nome +".\n"+
                                "Sua Conta Corrente é "+ numeroCc,"Cadastro de Clientes", JOptionPane.INFORMATION_MESSAGE);

                        String emailRemetente = "GrupoWDAVBD@gmail.com";
                        String senhaRemetente = "2022bdti";

                        String emailDestino = "illaap@hotmail.com";

                        EnviarEmail enviarEmail = new EnviarEmail(emailRemetente, senhaRemetente);
                        enviarEmail.enviarEmail(emailDestino);


                    } else {

                        JOptionPane.showMessageDialog(null, "Compreendemos sua decissão. Até logo!","Banco Digital agradece!", JOptionPane.INFORMATION_MESSAGE);

                    }

//========================================== Se for cliente vem para está parte do código ===================================================================================

                } else if(resposta == 0) {

                    int opcaoAcesso = random.nextInt(3) + 1; // gera um número aleatório entre 1 e 3

                    FormatarCpf formatarCpf = new FormatarCpf();
                    FormatarData formatarData = new FormatarData();
                    FormatarConta formatarConta = new FormatarConta();

                    switch (opcaoAcesso) {
                        case 1 -> {
                            usuario = JOptionPane.showInputDialog(null, "Informe a data de nascimento do titular :\n" + "Ex.: 01010001", "Banco Digital", JOptionPane.INFORMATION_MESSAGE);
                            if (usuario == null || usuario.equals("")) {
                                continue;
                            }
                            formatarData.setDataTx(usuario);
                            usuario = formatarData.getDataTx();
                        }
                        case 2 -> {
                            usuario = JOptionPane.showInputDialog(null, "Informe o CPF do titular da conta :\n" + "Ex.: 00100100101", "Banco Digital", JOptionPane.INFORMATION_MESSAGE);
                            if (usuario == null || usuario.equals("")) {
                                continue;
                            }
                            formatarCpf.setCpfnumero(usuario);
                            usuario = formatarCpf.getCpfformatado();
                        }
                        case 3 -> {
                            usuario = JOptionPane.showInputDialog(null, "Informe a conta : ", "Banco Digital", JOptionPane.INFORMATION_MESSAGE);
                            if (usuario == null || usuario.equals("")) {
                                continue;
                            }
                            formatarConta.setNumeroConta(usuario);
                            usuario = formatarConta.getNumeroConta();
                        }
                    }

                    String senha = JOptionPane.showInputDialog(null, "Informe senha : ", "Banco Digital", JOptionPane.INFORMATION_MESSAGE);

                    PermitirAcesso pAcesso = new Clientes();

                    NumberFormat vlr = NumberFormat.getCurrencyInstance();

                    Clientes clienteLogado = buscarClientePorChave(cliente, usuario);

                    if (clienteLogado != null && pAcesso.validar(senha, clienteLogado.getSenha())) {//Validar senha pois o login já é feito no cliente encontrado

                        Conta.setLogado(clienteLogado.getNome());

                        if (clienteLogado.getVarCc() == 10) {
                            Conta.setVariacao(clienteLogado.getVarCc());
                        } else if (clienteLogado.getVarCp() == 51) {
                            Conta.setVariacao(clienteLogado.getVarCp());
                        } else if (clienteLogado.getVarCi() == 61) {
                            Conta.setVariacao(clienteLogado.getVarCi());
                        }

                        boolean sair = true;//variável de controlo do sistema após a autenticação do "login" e senha

                        CartaoCredito cartaoCredito = new CartaoCredito();

                        ArrayList<String> extratoCc = new ArrayList<>();
                        ArrayList<String> extratoCP = new ArrayList<>();
                        ArrayList<String> extratoCi = new ArrayList<>();
                        ArrayList<String> Historico = new ArrayList<>();

                        label:
                        while (sair) {

                            String opcao = JOptionPane.showInputDialog(null, """
                                    Escolha a opcção:
                                    1- Conta corrente
                                    2- Cartão de crédito
                                    3- Depósito
                                    4- Transferência
                                    5- Conta Poupança
                                    6- Conta Investimento
                                    7- Sair""", "Banco Digital", JOptionPane.INFORMATION_MESSAGE);

                            if (opcao == null) {
                                break;
                            }

                            String varConta = "";

                            switch (opcao) {
                                case "1" -> {
                                    varConta = "10";
                                    contaCorrente.setBloquearCc(true);
                                }
                                case "3" -> {
                                    int opcaoDeposito = JOptionPane.showOptionDialog(null, "Escolha o tipo de conta:", "Tipo de conta", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

                                    switch (opcaoDeposito) {
                                        case 0 -> {
                                            assert clienteLogado != null;
                                            contaCorrente.setBloquearCc(clienteLogado.getVarCc() == 10);
                                            varConta = "10";
                                        }
                                        case 1 -> {
                                            assert clienteLogado != null;
                                            contaPoupanca.setBloquearCp(clienteLogado.getVarCp() == 51);
                                            varConta = "51";
                                        }
                                        case 2 -> {
                                            assert clienteLogado != null;
                                            ContaInvestimento.setBloquearCi(clienteLogado.getVarCi() == 61);
                                            varConta = "61";
                                        }
                                    }
                                }
                                case "4" -> varConta = String.valueOf(Conta.getVariacao());
                                case "5" -> {
                                    varConta = "51";
                                    contaPoupanca.setBloquearCp(true);
                                }
                                case "6" -> {
                                    varConta = "61";
                                    ContaInvestimento.setBloquearCi(true);
                                }

                            }

                            String[] opcaoC = {"Sim", "Não"};//verificar se o cliente tem as contas

                            assert clienteLogado != null;
                            if (clienteLogado.getVarCc() == 0 && varConta.equals("10")) {

                                int resposta1 = JOptionPane.showOptionDialog(null, "Pesquisando no banco de dados verificamos que você não tem a conta corrente.\n" + "Deseja abrir a conta agora?", "Criar Conta Corrente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcaoC, opcaoC[0]);
                                if (resposta1 == 0) {
                                    clienteLogado = abrirContaCorrente(cliente, varConta);
                                    contaCorrente.setBloquearCc(true);
                                } else {
                                    contaCorrente.setBloquearCc(false);
                                }

                            } else if (clienteLogado.getVarCp() == 0 && varConta.equals("51")) {

                                int resposta1 = JOptionPane.showOptionDialog(null, "Pesquisando no banco de dados verificamos que você não tem a conta poupança.\n" + "Deseja abrir a conta agora?", "Criar Conta Poupança", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcaoC, opcaoC[0]);
                                if (resposta1 == 0) {
                                    clienteLogado = abrirContaPoupanca(cliente, varConta);
                                    contaPoupanca.setBloquearCp(true);
                                } else {
                                    contaPoupanca.setBloquearCp(false);
                                }
                            } else if (clienteLogado.getVarCi() == 0 && varConta.equals("61")) {

                                int resposta1 = JOptionPane.showOptionDialog(null, "Pesquisando no banco de dados verificamos que você não tem a conta investimento.\n" + "Deseja abrir a conta agora?", "Criar Conta Investimento", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcaoC, opcaoC[0]);
                                if (resposta1 == 0) {
                                    clienteLogado = abrirContaInvestimento(cliente, varConta);
                                    ContaInvestimento.setBloquearCi(true);
                                } else {
                                    ContaInvestimento.setBloquearCi(false);
                                }
                            }
                            switch (opcao) {
                                case "1" -> {//resolve as transações da conta-corrente

                                    if (contaCorrente.isBloquearCc()) {

                                        String opcaoCc = JOptionPane.showInputDialog(null, """
                                                Escolha a opcção :
                                                1- Saldo
                                                2- Extrato
                                                3- Saque\s""", "Conta Corrente", JOptionPane.INFORMATION_MESSAGE);

                                        if (opcaoCc == null) continue;

                                        switch (opcaoCc) {
                                            case "1" -> {
                                                Double valorSaldo = contaCorrente.getContaCorrente();
                                                if (valorSaldo == 0.0) {
                                                    JOptionPane.showMessageDialog(null, "Sua conta conrrente está sem saldo " + vlr.format(valorSaldo), "Saldo", JOptionPane.INFORMATION_MESSAGE);
                                                    contaCorrente.setOpcao(opcaoCc);
                                                    extratoCc.add(contaCorrente.getDescricaoExtrato());
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Seu saldo atual é de " + vlr.format(valorSaldo), "Saldo", JOptionPane.INFORMATION_MESSAGE);
                                                }
                                            }
                                            case "2" -> {
                                                int n = extratoCc.size();
                                                String[][] imprimir = new String[n][1];
                                                StringBuilder sb = new StringBuilder();
                                                for (int i = 0; i < n; i++) {//adiciona os elementos de extrato Conta-corrente na matriz de uma coluna com várias linhas

                                                    imprimir[i][0] = extratoCc.get(i);

                                                }
                                                sb.append("<center><b>Extrato Conta Corrente</br></center>");
                                                sb.append("<hr>");//adiciona linha horizontal no extrato
                                                for (int i = 0; i < n; i++) {//organiza a impressão com quebras de linha um em baixo de outro

                                                    sb.append(imprimir[i][0]).append("<br><hr>");

                                                }

                                                JOptionPane.showMessageDialog(null, "<html>" + sb + "<html>", "Extrato", JOptionPane.INFORMATION_MESSAGE);//imprimir o extrato organizado .toString()

                                            }
                                            case "3" -> {

                                                String saque = JOptionPane.showInputDialog(null, "Informe o valor desejado para o saque :", "Saque conta corrente", JOptionPane.INFORMATION_MESSAGE);

                                                String senhaPermissao = JOptionPane.showInputDialog(null, "Informe senha para liberar saque : ", "Segurança", JOptionPane.INFORMATION_MESSAGE);

                                                assert clienteLogado != null;
                                                if (pAcesso.validar(senhaPermissao, clienteLogado.getSenha())) {

                                                    contaCorrente.setSaque(Double.parseDouble(saque));
                                                    contaCorrente.setSaqueCc(contaCorrente.getSaque());
                                                    contaCorrente.setOpcao(opcaoCc);
                                                    extratoCc.add(contaCorrente.getDescricaoExtrato());

                                                } else {

                                                    JOptionPane.showMessageDialog(null, "ATENÇÃO!!! Senha inválida!", "Segurança - autenticação", JOptionPane.INFORMATION_MESSAGE);

                                                }
                                            }
                                        }
                                    }
                                }
                                case "2" -> { //resolve as transações de cartão de crédito

                                    String opCartao = JOptionPane.showInputDialog(null, """
                                            O que deseja realizar :
                                            1- Limite de crédito
                                            2- Saldo disponível
                                            3- Data de vencimento
                                            4- Histórico de compra
                                            5- Comprar com cartão
                                            6- sair""", "Banco Digital", JOptionPane.INFORMATION_MESSAGE);

                                    switch (opCartao) {
                                        case "1": //Opção limite de crédito

                                            String opCartao1 = JOptionPane.showInputDialog(null, """
                                                    - Limite de crédito -\s
                                                    O que deseja realizar :
                                                    1- Aumentar Limite de crédito
                                                    2- Consultar limite de crédito
                                                    """, "Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);

                                            if (opCartao1.equals("1")) {

                                                String aumentolimitecar = JOptionPane.showInputDialog(null, """
                                                        - Limite de crédito -
                                                        Informe o valor desejado de acréscimo""", "Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);

                                                cartaoCredito.setAumentolimite(Double.parseDouble(aumentolimitecar));
                                                cartaoCredito.setLimiteCredito(cartaoCredito.getAumentolimite());

                                            } else if (opCartao1.equals("2")) {

                                                JOptionPane.showMessageDialog(null, "O valor de limite de crédito do cartão é " + vlr.format(cartaoCredito.getLimiteCredito()), "Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);

                                                continue;

                                            }

                                            break;
                                        case "2": //Opção saldo disponível

                                            JOptionPane.showMessageDialog(null, "Saldo disponível para compra no cartão de crédito : " + vlr.format(cartaoCredito.getSaldoDiponivel()));

                                            break;
                                        case "3": //Opção data de vencimento

                                            cartaoCredito.setDataVencimento("25/05/2028");

                                            break;
                                        case "4": //histórico de compra

                                            int n = Historico.size();

                                            if (n > 0) {
                                                String[][] imprimirHistorico = new String[n][1];

                                                StringBuilder HC = new StringBuilder();

                                                for (int i = 0; i < n; i++) {//adiciona os elementos de extrato Conta-corrente na matriz de uma coluna com várias linhas

                                                    imprimirHistorico[i][0] = Historico.get(i);

                                                }

                                                HC.append("<center><b>Histórico Catão de Crédito</br></center>");
                                                HC.append("<hr>");//adiciona linha horizontal no extrato


                                                for (int i = 0; i < n; i++) {//organiza a impressão com quebras de linha um em baixo de outro

                                                    HC.append(imprimirHistorico[i][0]).append("<br><hr>");

                                                }

                                                JOptionPane.showMessageDialog(null, "<html>" + HC + "<html>", "Histórico Catão de Crédito", JOptionPane.INFORMATION_MESSAGE);//imprimir o extrato organizado .toString()


                                            } else {

                                                JOptionPane.showMessageDialog(null, "Sem registro de histórico de cartão de crédito", "Saldo", JOptionPane.INFORMATION_MESSAGE);
                                            }
                                            continue;

                                        case "5": //Opção comprar com cartão

                                            String entrada = "";
                                            int cancelar = 0;
                                            boolean continuar = false;

                                            while (entrada.equals("")) {

                                                if (continuar) {

                                                    cancelar = JOptionPane.showConfirmDialog(null, "Deseja continuar na opção de compra?", "Cartão de Crédito", JOptionPane.YES_NO_CANCEL_OPTION);
                                                }

                                                if (cancelar == 1) {

                                                    entrada = "sair";

                                                } else {

                                                    continuar = true;
                                                    String valorCompra = "";
                                                    String localCompra = "";
                                                    String dataCompra = "";

                                                    while (continuar) {
                                                        valorCompra = JOptionPane.showInputDialog(null, "Informe o valor da compra : \n" + "Limite para compra " + vlr.format(cartaoCredito.getSaldoDiponivel()), "Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);
                                                        localCompra = JOptionPane.showInputDialog(null, "Informe o nome da loja ou estabelecimento : ", "Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);
                                                        dataCompra = JOptionPane.showInputDialog(null, "Digite a data da compra : (ex: 01011001) ", "Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);

                                                        formatarData.setDataTx(dataCompra);
                                                        dataCompra = formatarData.getDataTx();

                                                        int alterardados = JOptionPane.showConfirmDialog(null, "confirmar dados da compra? \n" + "valor R$ " + valorCompra +
                                                                "; Local da compra : " + localCompra + "; data da compra : " + dataCompra, "Cartão de Crédito", JOptionPane.YES_NO_CANCEL_OPTION);

                                                        switch (alterardados){
                                                            case 0 -> continuar=false;
                                                            case 1 -> continuar=true;
                                                        }

                                                    }

                                                    continuar = true;

                                                    String senhaPermissao = JOptionPane.showInputDialog(null, "Informe senha para liberar comprar : ", "Segurança", JOptionPane.INFORMATION_MESSAGE);

                                                    assert clienteLogado != null;
                                                    if (pAcesso.validar(senhaPermissao, clienteLogado.getSenha())) {

                                                        cartaoCredito.setValorCompra(valorCompra);
                                                        cartaoCredito.setLocalCompra(localCompra);
                                                        cartaoCredito.setDataCompra(dataCompra);
                                                        cartaoCredito.setTotalCompras(Double.parseDouble(valorCompra));
                                                        Historico.add(cartaoCredito.getCompras());

                                                    } else {

                                                        JOptionPane.showMessageDialog(null, "ATENÇÃO!!! Senha inválida!", "Segurança - autenticação", JOptionPane.INFORMATION_MESSAGE);
                                                        break;

                                                    }



                                                }
                                            }

                                            break;
                                        case "6":

                                            break label;

                                    }
                                }
                                case "3" -> {//depósito

                                    if (contaCorrente.isBloquearCc() && Conta.getVariacao() == 10) {
                                        String deposito = JOptionPane.showInputDialog(null, "Informe o valor de depósito : ", "Depósito Conta Corrente", JOptionPane.INFORMATION_MESSAGE);

                                        if (deposito == null) {
                                            continue;
                                        }

                                        contaCorrente.setDeposito(Double.parseDouble(deposito));
                                        contaCorrente.setSaldoCc(contaCorrente.getDeposito());
                                        contaCorrente.setOpcao("4");
                                        extratoCc.add(contaCorrente.getDescricaoExtrato());
                                        contaCorrente.setBloquearCc(false);

                                    } else if (contaPoupanca.isBloquearCp() && Conta.getVariacao() == 51) {
                                        String deposito = JOptionPane.showInputDialog(null, "Informe o valor de depósito : ", "Depósito Conta Poupança", JOptionPane.INFORMATION_MESSAGE);

                                        if (deposito == null) {
                                            continue;
                                        }

                                        contaPoupanca.setDeposito(Double.parseDouble(deposito));
                                        contaPoupanca.setSaldoCp(contaPoupanca.getDeposito());
                                        contaPoupanca.setOpcao("5");
                                        extratoCP.add(contaPoupanca.getDescricaoExtrato());
                                        contaPoupanca.setBloquearCp(false);

                                    }  else if (contaInvestimento.isBloquearCi() && Conta.getVariacao() == 61) {

                                        JOptionPane.showMessageDialog(null, """
                                                Seja bem vindo ao nosso investimento CDB! Veja alguns benefícios do Certificado de Depósito Bancário:
                                                O CDB é uma opção de investimento em renda fixa oferecida pelo Banco Digital.
                                                 Segurança: O CDB é garantido pelo Fundo Garantidor de Créditos (FGC) até o valor de R$ 250.000 por CPF
                                                 e por instituição financeira. Isso significa que, em caso de falência da instituição emissora, o investidor
                                                 terá seu investimento protegido até esse limite.""", "Conta Investimento", JOptionPane.INFORMATION_MESSAGE);

                                        String deposito = JOptionPane.showInputDialog(null, "Informe o valor de depósito : ", "Depósito Conta Investimento", JOptionPane.INFORMATION_MESSAGE);

                                        if (deposito == null) {
                                            continue;
                                        }

                                        contaInvestimento.setSaldo(Double.parseDouble(deposito));
                                        contaInvestimento.setRendimento(contaInvestimento.getSaldo());
                                        contaInvestimento.setOpcao("5");
                                        extratoCi.add(contaInvestimento.getDescricaoExtrato());
                                        ContaInvestimento.setBloquearCi(false);
                                    }
                                }
                                case "4" -> { //opção tranferencia

                                    //String opcaoCc = "5";
                                    int tipoDeConta = JOptionPane.showOptionDialog(null, "Deseja transferir da conta:", "Tipo de conta", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                                    String contaTransferencia = JOptionPane.showInputDialog(null, "Informe a conta de destino : ", "Tranferência", JOptionPane.INFORMATION_MESSAGE);
                                    String transferencia = JOptionPane.showInputDialog(null, "Informe o valor de transferência : ", "Transferência", JOptionPane.INFORMATION_MESSAGE);

                                    String senhaPermissao = JOptionPane.showInputDialog(null, "Informe senha para liberar transferência : ", "Segurança", JOptionPane.INFORMATION_MESSAGE);

                                    assert clienteLogado != null;
                                    if (pAcesso.validar(senhaPermissao, clienteLogado.getSenha())) {

                                        if (tipoDeConta == 0) {
                                            contaCorrente.setTransferencia(Double.parseDouble(transferencia));
                                            contaCorrente.settransferenciaCc(contaCorrente.getTransferencia());
                                            contaCorrente.setContaDestino(contaTransferencia);
                                            contaCorrente.setOpcao(opcao);
                                            extratoCc.add(contaCorrente.getDescricaoExtrato());
                                        } else {
                                            contaPoupanca.setTransferencia(Double.parseDouble(transferencia));
                                            contaPoupanca.settransferenciaCp(contaPoupanca.getTransferencia());
                                            contaPoupanca.setContaDestino(contaTransferencia);
                                            contaPoupanca.setOpcao(opcao);
                                            extratoCP.add(contaPoupanca.getDescricaoExtrato());
                                        }

                                    } else {

                                        JOptionPane.showMessageDialog(null, "ATENÇÃO!!! Senha inválida!", "Segurança - autenticação", JOptionPane.INFORMATION_MESSAGE);

                                    }
                                }
                                case "5" -> { //opção conta poupança

                                    if (contaPoupanca.isBloquearCp()) {
                                        String opcaoCp = JOptionPane.showInputDialog(null, """
                                                Escolha a opcção :
                                                1- Saldo
                                                2- Extrato
                                                3- Saque
                                                4- Consultar rendimento""", "Conta Poupança", JOptionPane.INFORMATION_MESSAGE);

                                        if (opcaoCp == null) continue;

                                        switch (opcaoCp) {
                                            case "1" -> {
                                                Double valorSaldo = contaPoupanca.getPoupanca();
                                                if (valorSaldo == 0.0) {
                                                    JOptionPane.showMessageDialog(null, "Sua conta poupança está sem saldo " + vlr.format(valorSaldo), "Saldo", JOptionPane.INFORMATION_MESSAGE);
                                                    contaPoupanca.setOpcao(opcaoCp);
                                                    extratoCP.add(contaPoupanca.getDescricaoExtrato());
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Seu saldo atual é de " + vlr.format(valorSaldo), "Saldo", JOptionPane.INFORMATION_MESSAGE);
                                                }
                                            }
                                            case "2" -> {
                                                int n = extratoCP.size();
                                                String[][] imprimir = new String[n][1];
                                                StringBuilder sb = new StringBuilder();
                                                for (int i = 0; i < n; i++) {//adiciona os elementos de extrato Conta-corrente na matriz de uma coluna com várias linhas

                                                    imprimir[i][0] = extratoCP.get(i);

                                                }
                                                sb.append("<center><b>Extrato Conta Poupança</br></center>");
                                                sb.append("<hr>");//adiciona linha horizontal no extrato
                                                for (int i = 0; i < n; i++) {//organiza a impressão com quebras de linha um em baixo de outro

                                                    sb.append(imprimir[i][0]).append("<br><hr>");

                                                }
                                                JOptionPane.showMessageDialog(null, "<html>" + sb + "<html>", "Extrato", JOptionPane.INFORMATION_MESSAGE);//imprimir o extrato organizado
                                            }
                                            case "3" -> {

                                                String saque = JOptionPane.showInputDialog(null, "Informe o valor desejado para o saque :", "Saque conta poupança", JOptionPane.INFORMATION_MESSAGE);

                                                String senhaPermissao = JOptionPane.showInputDialog(null, "Informe senha para liberar saque : ", "Segurança", JOptionPane.INFORMATION_MESSAGE);

                                                assert clienteLogado != null;
                                                if (pAcesso.validar(senhaPermissao, clienteLogado.getSenha())) {

                                                    contaPoupanca.setSaque(Double.parseDouble(saque));
                                                    contaPoupanca.setSaqueCp(contaPoupanca.getSaque());
                                                    contaPoupanca.setOpcao(opcaoCp);
                                                    extratoCP.add(contaPoupanca.getDescricaoExtrato());

                                                } else {

                                                    JOptionPane.showMessageDialog(null, "ATENÇÃO!!! Senha inválida!", "Segurança - autenticação", JOptionPane.INFORMATION_MESSAGE);

                                                }

                                            }
                                            case "4" -> {
                                                Double redimento = contaPoupanca.getRendimentoPoupanca();
                                                JOptionPane.showMessageDialog(null, "Seu saldo em conta poupança com rendimento é de " + (vlr.format(redimento)), "Redimento Conta Poupança", JOptionPane.INFORMATION_MESSAGE);
                                                if(redimento==0.0){continue;}
                                                contaPoupanca.setOpcao(opcaoCp);
                                                extratoCP.add(contaPoupanca.getDescricaoExtrato());
                                            }
                                        }
                                    }
                                }
                                case "6" -> { //opção conta investimento

                                    if (contaInvestimento.isBloquearCi()) {
                                        String opcaoCi = JOptionPane.showInputDialog(null, """
                                                Escolha a opcção :
                                                1- Saldo
                                                2- Extrato
                                                3- Saque
                                                4- Consultar rendimento""", "Conta Investimento", JOptionPane.INFORMATION_MESSAGE);

                                        if (opcaoCi == null) continue;


                                        switch (opcaoCi) {
                                            case "1" -> {
                                                Double valorSaldo = contaInvestimento.getRendimento();
                                                contaInvestimento.setOpcao(opcaoCi);
                                                if (valorSaldo == 0.0) {
                                                    JOptionPane.showMessageDialog(null, "Sua conta investimento está sem saldo " + vlr.format(valorSaldo), "Saldo", JOptionPane.INFORMATION_MESSAGE);

                                                    extratoCi.add(contaInvestimento.getDescricaoExtrato());
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Seu saldo atual é de " + vlr.format(valorSaldo), "Saldo", JOptionPane.INFORMATION_MESSAGE);
                                                    extratoCi.add(contaInvestimento.getDescricaoExtrato());
                                                }
                                            }
                                            case "2" -> {
                                                int n = extratoCi.size();
                                                String[][] imprimir = new String[n][1];
                                                StringBuilder sb = new StringBuilder();
                                                for (int i = 0; i < n; i++) {//adiciona os elementos de extrato Conta-investimento na matriz de uma coluna com várias linhas

                                                    imprimir[i][0] = extratoCi.get(i);

                                                }
                                                sb.append("<center><b>Extrato Conta Investimento</br></center>");
                                                sb.append("<hr>");//adiciona linha horizontal no extrato
                                                for (int i = 0; i < n; i++) {//organiza a impressão com quebras de linha um em baixo de outro

                                                    sb.append(imprimir[i][0]).append("<br><hr>");

                                                }
                                                JOptionPane.showMessageDialog(null, "<html>" + sb + "<html>", "Extrato", JOptionPane.INFORMATION_MESSAGE);//imprimir o extrato organizado
                                            }
                                            case "3" -> {

                                                String saque = JOptionPane.showInputDialog(null, "Informe o valor desejado para o saque :", "Saque conta investimento", JOptionPane.INFORMATION_MESSAGE);

                                                String senhaPermissao = JOptionPane.showInputDialog(null, "Informe senha para liberar saque : ", "Segurança", JOptionPane.INFORMATION_MESSAGE);

                                                assert clienteLogado != null;
                                                if (pAcesso.validar(senhaPermissao, clienteLogado.getSenha())) {

                                                    contaInvestimento.setSaque(Double.parseDouble(saque));
                                                    contaInvestimento.setSaqueCi(contaInvestimento.getSaque());
                                                    contaInvestimento.setOpcao(opcaoCi);
                                                    extratoCi.add(contaInvestimento.getDescricaoExtrato());

                                                } else {

                                                    JOptionPane.showMessageDialog(null, "ATENÇÃO!!! Senha inválida!", "Segurança - autenticação", JOptionPane.INFORMATION_MESSAGE);

                                                }

                                            }
                                            case "4" -> {
                                                Double redimento = contaInvestimento.RendimentoInvestimento();
                                                JOptionPane.showMessageDialog(null, "Seu saldo em conta investimento com rendimento é de " + (vlr.format(redimento)), "Redimento Conta Investimento", JOptionPane.INFORMATION_MESSAGE);
                                                if(redimento==0.0){continue;}
                                                contaInvestimento.setOpcao(opcaoCi);
                                                extratoCi.add(contaInvestimento.getDescricaoExtrato());
                                            }
                                        }
                                    }
                                }
                                case "7" ->  //opção sair

                                    sair = false;

                            }

                        }

                    } else if (clienteLogado == null) {

                        JOptionPane.showMessageDialog(null, "Acesso negado!" + " A informação fornecida, " + usuario + ", não confere com a cadastrada.", "Segurança - Validação", JOptionPane.INFORMATION_MESSAGE);

                    } else {

                        JOptionPane.showMessageDialog(null, "Acesso negado!" + " A senha, " + senha + ", não confere com a cadastrada.", "Segurança - Validação", JOptionPane.INFORMATION_MESSAGE);
                    }

                } else {

                    sairSistema = false;

                }

                scanner.close();
            } catch (NumberFormatException e) {

                StringBuilder saida = new StringBuilder();

                /*Imprime erro no console java*/
                e.printStackTrace();

                /*Mensagem do erro ou causa*/
                System.out.println("Mensagem: " + e.getMessage());

                for (int pos = 0; pos < e.getStackTrace().length; pos++) {
                    saida.append("\n Classe de erro : ").append(e.getStackTrace()[pos].getClassName());
                    saida.append("\n Método de erro : ").append(e.getStackTrace()[pos].getMethodName());
                    saida.append("\n Linha de erro : ").append(e.getStackTrace()[pos].getLineNumber());
                    saida.append("\n Classe : ").append(e.getClass().getName());
                }

                JOptionPane.showMessageDialog(null, "Erro de conversão de número " + saida);

            } catch (NullPointerException e) {

                JOptionPane.showMessageDialog(null, "Erro de Null pointer exeption " + e.getClass());

            } catch (Exception e) {/*Captura todas as excessão que não prevemos*/

                e.printStackTrace();

                JOptionPane.showMessageDialog(null, "Erro inesperado : " + e.getClass().getName());

            }
        } //fim do while sairdosistema
    }
}
