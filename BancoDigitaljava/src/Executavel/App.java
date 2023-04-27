package Executavel;

import classes.CartaoCredito;
import classes.ContaCorrente;
import classes.Movimentacao;

import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Seguranca.Autenticacao;

public class App {    
	
	public static void main(String[] args) {
		
		int resposta = JOptionPane.showConfirmDialog(null, "Bem vindo! o senhor já é Cliente? ");
    	
    	if (resposta == 0) {
    	
		String login = JOptionPane.showInputDialog("Informe o nome do usuário : ");
		String senha = JOptionPane.showInputDialog("Informe senha : ");	
		    	
    	ContaCorrente Cc = new ContaCorrente();
        Movimentacao movimentacao = new Movimentacao();
        Autenticacao autenticacao = new Autenticacao();
        
        autenticacao.setLogin(login);
        autenticacao.setSenha(senha);
        
        NumberFormat vlr = NumberFormat.getCurrencyInstance();
               
		
		if(autenticacao.Autenticar()) {
			
			String opcao = JOptionPane.showInputDialog("Escolha a opcção :\n"+"1- Conta corrente\n"+"2- Cartão de crédito\n"+
			"3- Investimento\n"+"4- Empréstimo\n"+"5- Pagamento\n"+"6- Transferência");
			
			if(opcao.equals("1")) {//resolve as transações da conta corrente
				
				System.out.println(opcao);
				
			} else if(opcao.equals("2")) {//resolve as transações de cartão de crédito
				
				String opCartao = JOptionPane.showInputDialog("O que deseja realizar :\n"+"1- Limite de crédito\n"+"2- Saldo disponível\n"+
						"3- Data de vencimento\n"+"4- Histórico de compra\n"+"5- Comprar com cartão\n"+"6- sair");
				
				if(opCartao.equals("1")) {//Opção limite de crédito
					
					String opCartao1 = JOptionPane.showInputDialog("- Limite de crédito\n"+"-------------------------------\n"+"O que deseja realizar :\n"+
							"1- Aumentar Limite de crédito\n"+"2- Consultar limite de crédito\n"+"-------------------------------");
					
					if(opCartao1.equals("1")) {
						
						String aumentolimitecar = JOptionPane.showInputDialog("- Limite de crédito\n"+"---------------------------------------------------------\n"+
								"Informe o valor desejado de acréscimo\n"+"---------------------------------------------------------");
						
						CartaoCredito cartaoCredito = new CartaoCredito();
						
						cartaoCredito.setAumentolimite(Double.parseDouble(aumentolimitecar));
																								
					} else if(opCartao1.equals("2")) {
						
						CartaoCredito cartaoCredito = new CartaoCredito();
						
						JOptionPane.showMessageDialog(null, "O valor de limite de crédito do cartão é R$ "+vlr.format(cartaoCredito.getLimiteCredito()));
									
						System.exit(resposta);//terminar codigo (parar o código)
					}
					
				} else if(opCartao.equals("2")) {//Opção saldo disponível
					
					CartaoCredito cartaoCredito = new CartaoCredito();
					
					cartaoCredito.setSaldoDiponivel(0);//pesquisar como chamar set pelo get
					
					
				} else if(opCartao.equals("3")) {//Opção data de vencimento
					
					CartaoCredito cartaoCredito = new CartaoCredito();
					
					
					
				} else if(opCartao.equals("4")) {//Opção histórico de compra
					
				} else if(opCartao.equals("5")) {//Opção comprar com cartão
					
				} else if(opCartao.equals("6")) {//Opção sair
					
				}					
								
			} else if (opcao.equals("3")) {//opção investimento
				
				System.out.println(opcao);
				
			} else if (opcao.equals("4")) {//opção emprestimos
				
				System.out.println(opcao);
				
			} else if (opcao.equals("5")) {//opção pagamento
				
				System.out.println(opcao);
				
			} else if (opcao.equals("6")) { //opção tranferencia
				
				System.out.println(opcao);
				
			}
		               
        double saldo = 2000;
        double saque = 1000;
        double deposito = 1000;
        double pagamento = 0;
        int numeroConta = 1229;
        String nomeTitular = "willames";
        double limiteChequeEspecial = 3000;
        
        
        movimentacao.setSaldo(saldo);
        //movimentacao.setPagamento(pagamento);
        movimentacao.setDeposito(deposito);
        movimentacao.setSaque(saque);
        Cc.setNumeroConta(numeroConta);
        Cc.setNomeTitular(nomeTitular);
        //Cc.setLimiteChequeEspecial(limiteChequeEspecial);

        //System.out.println(movimentacao.getPagamento());
        System.out.println(Cc.getNomeTitular());
        System.out.println(Cc.getNumeroConta());
        System.out.println(movimentacao.getSaque());
        
        

    	} else {
    		
    		JOptionPane.showMessageDialog(null, "Acesso negado!" + " senhor " + login + " nome do usuário e/ou senha não confere com a cadastrada.");
    		
    	}
		
    	} else {
    		
    		int resposta2 = JOptionPane.showConfirmDialog(null, "Deseja abrir sua conta no banco digital? ");
    		
    		if (resposta2 == 0) {
    			
    			System.out.println("Abrir conta");
    			
    		} else {
    			
    			JOptionPane.showMessageDialog(null, "Compreendemos sua decissão. Até logo!");
    			
    		}
    			
    			
    		
    		
    	}
	}
    }

