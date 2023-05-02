package Executavel;

import classes.CartaoCredito;
import classes.ContaCorrente;
import classes.Movimentacao;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import Seguranca.Autenticacao;
import Seguranca.confirmarSenha;
import java.util.Date;

public class App {    
	
	public static void main(String[] args) {
		
		Boolean sairDoDistema = false;
		
		while (sairDoDistema == false) {
		
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
	    					
	    					CartaoCredito cartaoCredito = new CartaoCredito();
	    					
	    					ArrayList<String> extratoCc = new ArrayList<>();
	    					ArrayList<String> Historico = new ArrayList<>();
	    					
	    					while (sair == false) {
	    				
		    					String opcao = JOptionPane.showInputDialog("Escolha a opcção :\n"+"1- Conta corrente\n"+"2- Cartão de crédito\n"+
		    															"3- Pagamento\n"+"4- Depósito\n"+"5- Transferência\n"+"6- Sair");
		    					
		    					if(opcao== null) {
									
									//continue;
									break;
									
								}
					
		    					Date dataAtual = new Date();
								movimentacao.setDataAtual(dataAtual);	
																		    					
		    					if(opcao.equals("1")) {//resolve as transações da conta corrente
		    						
		    						    						
		    						String opcaoCc = JOptionPane.showInputDialog("Escolha a opcção :\n"+"1- Saldo\n"+"2- Extrato\n"+
											"3- Saque ");
		    						
		    								if(opcaoCc== null) {
		    									
		    									continue;
		    									//break;
		    									
		    								}
		    								
		    								switch (opcaoCc) {		    										
		    										
													case "1":
														
														Double valorSaldo = movimentacao.getSaldo();												
														if (valorSaldo == 0.0) {
															JOptionPane.showMessageDialog(null, "Sua conta conrrente está sem saldo " + vlr.format(valorSaldo));
															movimentacao.setOpcao(opcaoCc);															
															extratoCc.add(movimentacao.getDescricaoExtrato());
															break;													
														} else {
															JOptionPane.showMessageDialog(null, "Seu saldo atual é de " + vlr.format(valorSaldo));
														}												
														break;
													case "2":																												
														
														int n = extratoCc.size();
														
														String[][]imprimir = new String[n][1];
														
														StringBuilder sb = new StringBuilder();
														
														for(int i = 0; i < n; i++) {//adiciona os elementos de extratoCc na matriz de uma coluna com n linhas
																														
														    imprimir[i][0] = extratoCc.get(i);
															
														}	
																											
														sb.append("<center><b>Extrato Conta Corrente</br></center>");
														sb.append("<hr>");//adiciona linha horizontal no extrato
														
														for(int i = 0; i < n; i++) {//organiza a impressão com quebras de linha um em baixo de outro
															
														    sb.append(imprimir[i][0]).append("<br><hr>");
															
														}														
														
														JOptionPane.showMessageDialog(null, "<html>" + sb.toString()+ "<html>", "Extrato Conta Corrente", JOptionPane.INFORMATION_MESSAGE);//imprimir o extrato organizado									
																												
														break;
														
													case "3":												
														
														String saque = JOptionPane.showInputDialog("Informe o valor desejado para o saque :");
														
														movimentacao.setSaque(Double.parseDouble(saque));
														movimentacao.setOpcao(opcaoCc);
														extratoCc.add(movimentacao.getDescricaoExtrato());
														break;
											
											}
		    						
						
		    					} else if(opcao.equals("2")) {//resolve as transações de cartão de crédito
		    						
		    						String opCartao = JOptionPane.showInputDialog("O que deseja realizar :\n"+"1- Limite de crédito\n"+"2- Saldo disponível\n"+
		    															"3- Data de vencimento\n"+"4- Histórico de compra\n"+"5- Comprar com cartão\n"+"6- sair");
						
		    							if(opCartao.equals("1")) {//Opção limite de crédito
		    								
		    									//CartaoCredito cartaoCredito = new CartaoCredito();
		    									
		    									String opCartao1 = JOptionPane.showInputDialog("- Limite de crédito\n"+"-------------------------------\n"+"O que deseja realizar :\n"+
		    																					"1- Aumentar Limite de crédito\n"+"2- Consultar limite de crédito\n"+"-------------------------------");
							
		    									if(opCartao1.equals("1")) {
								
		    											String aumentolimitecar = JOptionPane.showInputDialog("- Limite de crédito\n"+"---------------------------------------------------------\n"+
		    														"Informe o valor desejado de acréscimo\n"+"---------------------------------------------------------");
								
		    											cartaoCredito.setAumentolimite(Double.parseDouble(aumentolimitecar));
														cartaoCredito.setLimiteCredito(cartaoCredito.getAumentolimite());
														
		    									} else if(opCartao1.equals("2")) {								
		    													    											
		    											JOptionPane.showMessageDialog(null, "O valor de limite de crédito do cartão é R$ "+vlr.format(cartaoCredito.getLimiteCredito()));
											
		    											continue;//System.exit(resposta);//terminar codigo (parar o código)
		    											
		    									}
							
		    							} else if(opCartao.equals("2")) {//Opção saldo disponível
							
		    									//CartaoCredito cartaoCredito = new CartaoCredito();
							
		    									cartaoCredito.setSaldoDiponivel(0);//pesquisar como chamar set pelo get
							
							
		    							} else if(opCartao.equals("3")) {//Opção data de vencimento
							
		    								cartaoCredito.setDataVencimento("25/05/2028");
							
		    							} else if(opCartao.equals("4")) {//Opção histórico de compra
		    								
			    								int n = Historico.size();
												
			    								if (n > 0) {
														String[][]imprimirHistorico = new String[n][1];
														
														StringBuilder HC = new StringBuilder();
														
														for(int i = 0; i < n; i++) {//adiciona os elementos de extratoCc na matriz de uma coluna com n linhas
																														
															imprimirHistorico[i][0] = Historico.get(i);
															
														}	
																											
														HC.append("<center><b>Histórico Catão de Crédito</br></center>");
														HC.append("<hr>");//adiciona linha horizontal no extrato
														
														for(int i = 0; i < n; i++) {//organiza a impressão com quebras de linha um em baixo de outro
															
															HC.append(imprimirHistorico[i][0]).append("<br><hr>");
															
														}														
														
														JOptionPane.showMessageDialog(null, "<html>" + HC.toString()+ "<html>", "Histórico Catão de Crédito", JOptionPane.INFORMATION_MESSAGE);//imprimir o extrato organizado									
																												
														continue;
												
			    								} else {
			    									
			    										JOptionPane.showMessageDialog(null, "Sem registro de histórico de cartão de crédito");
			    										continue;
			    								}
			    								
																		
		    							} else if(opCartao.equals("5")) {//Opção comprar com cartão
												
		    									String entrada = "";
		    									int cancelar = 0;
		    									boolean continuar = false; 		    									
							
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
								
		    																	//CartaoCredito cartaoCredito = new CartaoCredito();
								
		    																	String senhaPermissao = JOptionPane.showInputDialog("Informe senha para liberar comprar : ");
																				
		    																			if (autenticacao.getSenhaAcesso().equals(senhaPermissao)) {
									
		    																				cartaoCredito.setValorCompra(valorCompra);
		    																				cartaoCredito.setLocalCompra(localCompra);
		    																				cartaoCredito.setDataCompra(dataCompra);
		    																				cartaoCredito.setTotalCompras(Double.parseDouble(valorCompra));
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
		    										
		    					} else if (opcao.equals("3")) {//opção pagamento
		    							System.out.println(opcao);
		    								
		    					} else if (opcao.equals("4")) {//opção depósito
		    						
			    						String opcaoCc = opcao;
		    							String Deposito = JOptionPane.showInputDialog("Informe o valor de depósito : ");		    								
		    							movimentacao.setDeposito(Double.parseDouble(Deposito));
		    							movimentacao.setOpcao(opcaoCc);
										extratoCc.add(movimentacao.getDescricaoExtrato());						
		    							
						
		    					} else if (opcao.equals("5")) { //opção tranferencia
						
		    							System.out.println(opcao);
						
		    					} else if (opcao.equals("6")) { //opção sair
		    						
	    							break;
					
		    					} 
		    					
	    					}
	    					
	    			} else {
	    		
	    				JOptionPane.showMessageDialog(null, "Acesso negado!" + " senhor " + login + " nome do usuário e/ou senha não confere(m) com o(s) cadastrado(s).");
	    		
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
	    
		} //fim do while sairdosistema
	}
	
}

