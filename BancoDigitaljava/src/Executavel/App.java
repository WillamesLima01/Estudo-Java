package Executavel;

import classes.CartaoCredito;
import classes.ContaCorrente;
import classes.Movimentacao;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Seguranca.Autenticacao;
import Seguranca.confirmarSenha;
import java.util.Date;

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
    					
    					Boolean sair = false;//variável de controle do sistema após a autenticação do login e senha
    					
    					ArrayList<String> extratoCc = new ArrayList<>();
    					
    					while (sair == false) {
    				
	    					String opcao = JOptionPane.showInputDialog("Escolha a opcção :\n"+"1- Conta corrente\n"+"2- Cartão de crédito\n"+
	    															"3- Investimento\n"+"4- Depósito\n"+"5- Pagamento\n"+"6- Transferência");
				
	    					if(opcao.equals("1")) {//resolve as transações da conta corrente
	    						
	    						    						
	    						String opcaoCc = JOptionPane.showInputDialog("Escolha a opcção :\n"+"1- Saldo\n"+"2- Extrato\n"+
										"3- Saque ");
	    								
	    								Date dataAtual = new Date();
	    								movimentacao.setDataAtual(dataAtual);
	    								
	    								switch (opcaoCc) {
												case "1":
													
													Double valorSaldo = movimentacao.getSaldo();												
													if (valorSaldo == 0.0) {
														JOptionPane.showMessageDialog(null, "Sua conta conrrente está sem saldo, R$" + valorSaldo);
														movimentacao.setOpcao(opcaoCc);
														extratoCc.add(movimentacao.getDescricaoExtrato());
														break;													
													} else {
														JOptionPane.showMessageDialog(null, "Seu saldo atual é de: R$" + valorSaldo);
													}												
													
												case "2":
													
																																							
													
													
													break;
													
												case "3":												
													
													String saque = JOptionPane.showInputDialog("Informe o valor desejado para o saque :");
													
													movimentacao.setSaque(Double.parseDouble(saque));
													break;
										
										}
	    						
					
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
											
	    									String entrada = "";
	    									int cancelar = 0;
	    									boolean continuar = false; 
						
	    									ArrayList<String> Historico = new ArrayList<String>();
						
	    									while(entrada.equals("")) {											
								
	    											if (continuar == true) {
								
	    													cancelar = JOptionPane.showConfirmDialog(null, "Deseja continuar na opção de compra?");							}						
						
	    											if(cancelar == 1) {						
												
	    													entrada = "sair";
							
	    											} else {
	    												
	    													continuar = true;
	    													String valorCompra = JOptionPane.showInputDialog("Informe o valor da compra : ");										
	    													String localCompra = JOptionPane.showInputDialog("Informe o nome da loja ou estabelecimento : ");
	    													String dataCompra = JOptionPane.showInputDialog("Digite a data da compra : (ex: 01/01/1001) ");
											
	    													int alterardados = JOptionPane.showConfirmDialog(null, "confirmar dados da compra? \n" + "valor R$ " + valorCompra +
																									"; Local da compra : " + localCompra + "; data da compra : " + dataCompra);
							
	    															if(alterardados == 1) {
								
	    																	String opcaodados = JOptionPane.showInputDialog("Informe a opção que deseja alterar dados :\n 1 - Valor da compra; 2 - Local da compra; 3 - Data da compra");
								
	    																	switch (opcaodados) {
	    																				case "1":
									
	    																					valorCompra = JOptionPane.showInputDialog("Informe o valor da compra : ");
	    																					break;
									
	    																				case "2":
									
	    																					localCompra = JOptionPane.showInputDialog("Informe o nome da loja ou estabelecimento : ");
	    																					break;
									
	    																				case "3":
									
	    																					dataCompra = JOptionPane.showInputDialog("Digite a data da compra : (ex: 01/01/1001) ");
	    																					break;
								
	    																	}
	    																	
	    															} else {
							
	    																	CartaoCredito cartaoCredito = new CartaoCredito();
							
	    																	String senhaPermissao = JOptionPane.showInputDialog("Informe senha para liberar comprar : ");
																			
	    																			if (autenticacao.getSenha().equals(senhaPermissao)) {
								
	    																				cartaoCredito.setValorCompra(valorCompra);
	    																				cartaoCredito.setLocalCompra(localCompra);
	    																				cartaoCredito.setDataCompra(dataCompra);
	    																				Historico.add(cartaoCredito.getCompras());
								
	    																			} else {
								
	    																				JOptionPane.showMessageDialog(null, "ATENÇÃO!!! Senha inválida");
	    																				break;
								
	    																			}
							
							
	    															}
	    											}
						
	    									}
						
	    							} else if(opCartao.equals("6")) {//Opção sair
						
	    							}					
									
	    							} else if (opcao.equals("3")) {//opção investimento
					
	    								System.out.println(opcao);
					
	    							} else if (opcao.equals("4")) {//opção depósito
					
	    								String Deposito = JOptionPane.showInputDialog("Informe o valor de depósito : ");
	    								
	    								movimentacao.setDeposito(Double.parseDouble(Deposito));
	    								
	    							} else if (opcao.equals("5")) {//opção pagamento
					
	    								System.out.println(opcao);
					
	    							} else if (opcao.equals("6")) { //opção tranferencia
					
	    								System.out.println(opcao);
					
	    							}   
	    					
    					}
    					
    			} else {
    		
    				JOptionPane.showMessageDialog(null, "Acesso negado!" + " senhor " + login + " nome do usuário e/ou senha não confere com a cadastrada.");
    		
    			}
		
    	} else if(resposta == 1) {//Se não for cliente vem para está parte do código
    		
    			int resposta2 = JOptionPane.showConfirmDialog(null, "Deseja abrir sua conta no banco digital? ");
    		
    			if (resposta2 == 0) {//criar conta no aplicativo banco digital
    			
    			
    					//cadastrar senha e login
    			
    			} else {
    			
    			JOptionPane.showMessageDialog(null, "Compreendemos sua decissão. Até logo!");
    			
    			}    		
    		
    	} else {
    		
    		System.exit(0);			
    		    		
    	}
	}
	
}

