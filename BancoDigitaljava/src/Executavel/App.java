package Executavel;

import classes.CartaoCredito;
import classes.Clientes;
import classes.ContaCorrente;
import classes.Movimentacao;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import Formatacao.FormatarConta;
import Formatacao.FormatarCpf;
import Formatacao.FormatarData;
import Seguranca.PermitirAcesso;
import Seguranca.confirmarSenha;
import java.util.Date;
import java.util.Random;

public class App {    
	
	public static void main(String[] args) {
		
		String usuario = " ";
		Boolean sairDoDistema = false;
		Random random = new Random();		
	
	
		
		while (sairDoDistema == false) {
			
			try{	
						
			int resposta = JOptionPane.showConfirmDialog(null, "Bem vindo! o senhor já é Cliente? ","Banco Digital", JOptionPane.INFORMATION_MESSAGE);
						
	    	if (resposta == 0) {
	    		
	    		int opcaoAcesso = random.nextInt(3) + 1; // gera um número aleatório entre 1 e 3	 
	    			
	    			Clientes clientes = new Clientes();
	    			FormatarCpf formatarCpf = new FormatarCpf();
	    			FormatarData formatarData = new FormatarData();
	    			FormatarConta formatarConta = new FormatarConta();
	    			
	    			int pos = opcaoAcesso;
	    			
	    			clientes.setPosLogin(pos);//Preciso saber a posicao da escolha para buscar na matriz o dado correto
	    			
	    		switch (opcaoAcesso) {
						case 1:
							
							usuario = JOptionPane.showInputDialog(null,"Informe a data de nascimento do titular :\n"+"Ex.: 01010001","Banco Digital", JOptionPane.INFORMATION_MESSAGE);
							
							if(usuario == null || usuario.equals("")){
								continue;
							}
							formatarData.setDataTx(usuario);
							usuario = formatarData.getDataTx();
							clientes.setPosSenha(pos + 3);
							break;
						
						case 2:
							usuario = JOptionPane.showInputDialog(null,"Informe o CPF do titular da conta :\n"+"Ex.: 00100100101","Banco Digital", JOptionPane.INFORMATION_MESSAGE);
							
							if(usuario == null || usuario.equals("")){
								continue;
							}
							formatarCpf.setCpfnumero(usuario);
							usuario = formatarCpf.getCpfformatado();
							clientes.setPosSenha(pos + 2);
							break;
							
						case 3:
							usuario = JOptionPane.showInputDialog(null,"Informe a conta : ","Banco Digital", JOptionPane.INFORMATION_MESSAGE);							
							
							if(usuario == null || usuario.equals("")){
								continue;
							}
							formatarConta.setNumeroConta(usuario);
							usuario = formatarConta.getNumeroConta();
							clientes.setPosSenha(pos + 1);
							break;
				
				}
	    		
	    			String senha = JOptionPane.showInputDialog(null,"Informe senha : ","Banco Digital", JOptionPane.INFORMATION_MESSAGE);	
			    	
	    			ContaCorrente Cc = new ContaCorrente();
	    			Movimentacao movimentacao = new Movimentacao();	    			       
	    			PermitirAcesso pAcesso = new Clientes();
	    			
	    			NumberFormat vlr = NumberFormat.getCurrencyInstance();	 
	    				    			
	    			clientes.setConfirmarAcesso(usuario, senha);
	    			
	    			if(clientes.getUsuarioCliente() == null) {// caso o usuário não seja cadastrado, volta para o início do programa
	    				
	    				continue;
	    			}
	    			
	    			if(pAcesso.validar(usuario, senha)) {
	    					
	    					Boolean sair = false;//variável de controle do sistema após a autenticação do login e senha
	    					
	    					CartaoCredito cartaoCredito = new CartaoCredito();
	    					
	    					ArrayList<String> extratoCc = new ArrayList<>();
	    					ArrayList<String> Historico = new ArrayList<>();
	    					
	    					while (sair == false) {
	    				
		    					String opcao = JOptionPane.showInputDialog(null,"Escolha a opcção :\n"+"1- Conta corrente\n"+"2- Cartão de crédito\n"+
		    															"3- Depósito\n"+"4 - Transferência\n"+"5- Sair","Banco Digital", JOptionPane.INFORMATION_MESSAGE);
		    					
		    					if(opcao== null) {
																		
									break;
									
								}
					
		    					Date dataAtual = new Date();
								movimentacao.setDataAtual(dataAtual);	
																		    					
		    					if(opcao.equals("1")) {//resolve as transações da conta corrente
		    						
		    						    						
		    						String opcaoCc = JOptionPane.showInputDialog(null,"Escolha a opcção :\n"+"1- Saldo\n"+"2- Extrato\n"+"3- Saque ","Conta Corrente", JOptionPane.INFORMATION_MESSAGE);
		    						
		    								if(opcaoCc== null) {
		    									
		    									continue;		    									
		    									
		    								}
		    								
		    								switch (opcaoCc) {		    										
		    										
													case "1":
														
														Double valorSaldo = movimentacao.getSaldo();												
														if (valorSaldo == 0.0) {
															JOptionPane.showMessageDialog(null, "Sua conta conrrente está sem saldo " + vlr.format(valorSaldo),"Saldo", JOptionPane.INFORMATION_MESSAGE);
															movimentacao.setOpcao(opcaoCc);															
															extratoCc.add(movimentacao.getDescricaoExtrato());
															break;													
														} else {
															JOptionPane.showMessageDialog(null, "Seu saldo atual é de " + vlr.format(valorSaldo),"Saldo", JOptionPane.INFORMATION_MESSAGE);
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
														
														JOptionPane.showMessageDialog(null, "<html>" + sb.toString()+ "<html>", "Extrato", JOptionPane.INFORMATION_MESSAGE);//imprimir o extrato organizado									
																												
														break;
														
													case "3":												
														
														String saque = JOptionPane.showInputDialog(null,"Informe o valor desejado para o saque :","Saque conta corrente", JOptionPane.INFORMATION_MESSAGE);
														
														movimentacao.setSaque(Double.parseDouble(saque));
														movimentacao.setOpcao(opcaoCc);
														extratoCc.add(movimentacao.getDescricaoExtrato());
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
								
		    											cartaoCredito.setAumentolimite(Double.parseDouble(aumentolimitecar));
														cartaoCredito.setLimiteCredito(cartaoCredito.getAumentolimite());
														
		    									} else if(opCartao1.equals("2")) {								
		    													    											
		    											JOptionPane.showMessageDialog(null, "O valor de limite de crédito do cartão é " + vlr.format(cartaoCredito.getLimiteCredito()),"Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);
											
		    											continue;//System.exit(resposta);//terminar codigo (parar o código)
		    											
		    									}
							
		    							} else if(opCartao.equals("2")) {//Opção saldo disponível			    									
							
		    								JOptionPane.showMessageDialog(null, "Saldo disponível para compra no cartão de crédito : " + vlr.format(cartaoCredito.getSaldoDiponivel()));
														
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
			    									
			    										JOptionPane.showMessageDialog(null, "Sem registro de histórico de cartão de crédito","Saldo", JOptionPane.INFORMATION_MESSAGE);
			    										continue;
			    								}
			    								
																		
		    							} else if(opCartao.equals("5")) {//Opção comprar com cartão
												
		    									String entrada = "";
		    									int cancelar = 0;
		    									boolean continuar = false; 		    									
							
		    									while(entrada.equals("")) {											
									
		    											if (continuar == true) {
									
		    													cancelar = JOptionPane.showConfirmDialog(null, "Deseja continuar na opção de compra?","Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);		
		    											}						
							
		    											if(cancelar == 1) {						
													
		    													entrada = "sair";
								
		    											} else {
		    												
		    													continuar = true;
		    													String valorCompra = JOptionPane.showInputDialog(null,"Informe o valor da compra : \n" + "Limite para compra R$ " + cartaoCredito.getSaldoDiponivel(),"Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);										
		    													String localCompra = JOptionPane.showInputDialog(null,"Informe o nome da loja ou estabelecimento : ","Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);
		    													String dataCompra = JOptionPane.showInputDialog(null,"Digite a data da compra : (ex: 01011001) ","Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);
		    													
		    													formatarData.setDataTx(dataCompra);
																dataCompra = formatarData.getDataTx();
																
		    													int alterardados = JOptionPane.showConfirmDialog(null, "confirmar dados da compra? \n" + "valor R$ " + valorCompra +
																										"; Local da compra : " + localCompra + "; data da compra : " + dataCompra,"Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);
								
		    															if(alterardados == 1) {
									
		    																	String opcaodados = JOptionPane.showInputDialog(null,"Informe a opção que deseja alterar dados :\n 1 - Valor da compra; 2 - Local da compra; 3 - Data da compra","Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);
									
		    																	switch (opcaodados) {
		    																				case "1":
										
		    																					valorCompra = JOptionPane.showInputDialog(null,"Informe o valor da compra : ","Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);
		    																					break;
										
		    																				case "2":
										
		    																					localCompra = JOptionPane.showInputDialog(null,"Informe o nome da loja ou estabelecimento : ","Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);
		    																					break;
										
		    																				case "3":
										
		    																					dataCompra = JOptionPane.showInputDialog(null,"Digite a data da compra : (ex: 01011001) ","Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);
		    																					break;
									
		    																	}
		    																	
		    															} else {		    																	
								
		    																	String senhaPermissao = JOptionPane.showInputDialog(null,"Informe senha para liberar comprar : ","Segurança", JOptionPane.INFORMATION_MESSAGE);
																				
		    																			if (clientes.getSenhaAcesso().equals(senhaPermissao)) {
		    																						    																						    																				
		    																				cartaoCredito.setValorCompra(valorCompra);
		    																				cartaoCredito.setLocalCompra(localCompra);
		    																				cartaoCredito.setDataCompra(dataCompra);
		    																				cartaoCredito.setTotalCompras(Double.parseDouble(valorCompra));
		    																				Historico.add(cartaoCredito.getCompras());
									
		    																			} else {
									
		    																				JOptionPane.showMessageDialog(null, "ATENÇÃO!!! Senha inválida!","Segurança - autenticação", JOptionPane.INFORMATION_MESSAGE);
		    																				break;
		    																				
		    																			}
									
		    															}								
								
		    											}
		    									}
							
		    									} else if(opCartao.equals("6")) {
		    										
		    										break;
		    																					
		    									}    										
		    					
		    							} else if (opcao.equals("3")) {//opção depósito
		    						
			    						String opcaoCc = "4";
		    							String Deposito = JOptionPane.showInputDialog(null,"Informe o valor de depósito : ","Depósito conta corrente", JOptionPane.INFORMATION_MESSAGE);		    								
		    							movimentacao.setDeposito(Double.parseDouble(Deposito));
		    							movimentacao.setOpcao(opcaoCc);
										extratoCc.add(movimentacao.getDescricaoExtrato());			
    							
		    					} else if (opcao.equals("4")) { //opção tranferencia
						
			    						String opcaoCc = "5"; 
			    						String contaTransferencia = JOptionPane.showInputDialog(null,"Informe a conta de destino : ","Tranferência", JOptionPane.INFORMATION_MESSAGE);		    								
		    							String transferencia = JOptionPane.showInputDialog(null,"Informe o valor de transferência : ","Transferência", JOptionPane.INFORMATION_MESSAGE);		    								
		    							movimentacao.setTransferencia(Double.parseDouble(transferencia), contaTransferencia);
		    							movimentacao.setOpcao(opcaoCc);
										extratoCc.add(movimentacao.getDescricaoExtrato());	
						
		    					} else if (opcao.equals("5")) { //opção sair
		    						
	    							break;
					
		    					} 
		    					
		    				}
	    					
	    			} else {
	    		
	    				JOptionPane.showMessageDialog(null, "Acesso negado!" + " senhor " + usuario + " nome do usuário e/ou senha não confere(m) com o(s) cadastrado(s).","Segurança - Validação", JOptionPane.INFORMATION_MESSAGE);
	    		
	    			}
			
	    	} else if(resposta == 1) {//Se não for cliente vem para está parte do código
	    		
	    			int resposta2 = JOptionPane.showConfirmDialog(null, "Deseja abrir sua conta no banco digital? ","Informação com segurança", JOptionPane.INFORMATION_MESSAGE);
	    		
	    			if (resposta2 == 0) {//criar conta no aplicativo banco digital
	    					    				
	    				String nomeCompleto = JOptionPane.showInputDialog(null,"Informe o nome completo do usuário : ","Banco Digital", JOptionPane.INFORMATION_MESSAGE);
	    				String dataNascimento = JOptionPane.showInputDialog(null,"Informe a data de nascimeto : \n"+"Ex.: 01011001","Banco Digital", JOptionPane.INFORMATION_MESSAGE);
	    				String cpf = JOptionPane.showInputDialog(null,"Informe o CPF : \n"+"Ex.: 12345678910","Banco Digital", JOptionPane.INFORMATION_MESSAGE);
	    				
	    		        int numerogerado = random.nextInt(90000) + 10000; // gera um número aleatório entre 1000 e 9999
	    		       	   
	    		        
	    				Clientes clientes = new Clientes();	   
	    				
	    				FormatarCpf formatarCpf = new FormatarCpf();
	    				FormatarData formatarData = new FormatarData();	 
	    				FormatarConta formatarConta = new FormatarConta();
	    				
	    				formatarCpf.setCpfnumero(cpf);
	    				cpf = formatarCpf.getCpfformatado();
	    				formatarData.setDataTx(dataNascimento);
	    				dataNascimento = formatarData.getDataTx();
	    				formatarConta.setNumeroConta(String.valueOf(numerogerado));
	    				String numeroCc = formatarConta.getNumeroConta();
	    				
	    				
	    				String senhaCadastro = "";
	    				Boolean sair = true;
	    				
	    				while(sair) {
			    				senhaCadastro = JOptionPane.showInputDialog(null,"Informe a senha : \n"+"Obs.: Senha númerica. Use a sequência de 0 a 9 e digite sua senha ","Banco Digital", JOptionPane.INFORMATION_MESSAGE);
			    				String senhaCadastroConfirme = JOptionPane.showInputDialog(null,"Confirme a senha : ","Banco Digital", JOptionPane.INFORMATION_MESSAGE);
			    				
			    				if(senhaCadastro.equals(senhaCadastroConfirme)) {
			    					
			    					sair = false;
			    					
			    				} else {
			    					
			    					JOptionPane.showMessageDialog(null, "Senha não conferem!", "ATENÇÃO!!!", JOptionPane.INFORMATION_MESSAGE);
			    				}
	    				
	    				}				
	    				
	    				clientes.setNomeCompleto(nomeCompleto);
	    				clientes.setDatanasc(dataNascimento);
	    				clientes.setCpf(cpf);
	    				clientes.setNumeroCc(numeroCc);	   	    				
	    				clientes.setSenhaCadastro(senhaCadastro); 
	    				
	    				
	    				    				    				
	    				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso, senhor(a), "+ clientes.getNome() +".\n"+
	    											"Sua Conta Corrente é "+ clientes.getNumeroCc(),"Cadastro de Clientes", JOptionPane.INFORMATION_MESSAGE);    				
						
	    			} else {
	    			
	    			JOptionPane.showMessageDialog(null, "Compreendemos sua decissão. Até logo!","Banco Digital agradece!", JOptionPane.INFORMATION_MESSAGE);
	    			
	    			}    		
	    		
	    	} else {
	    		
	    		System.exit(0);			
	    		    		
	    	}
	    
		
		
	} catch (NumberFormatException e) {
		
		StringBuilder saida = new StringBuilder();		
		
		/*Imprime erro no console java*/
		e.printStackTrace();	
		
		/*Mensagem do erro ou causa*/		
		System.out.println("Mensagem: " + e.getMessage());	
		
		for (int pos = 0; pos < e.getStackTrace().length; pos++) {				
			saida.append("\n Classe de erro : " + e.getStackTrace()[pos].getClassName());
			saida.append("\n Método de erro : " + e.getStackTrace()[pos].getMethodName());				
			saida.append("\n Linha de erro : " + e.getStackTrace()[pos].getLineNumber());
			saida.append("\n Classe : " + e.getClass().getName());
		}	
		
		JOptionPane.showMessageDialog(null, "Erro de conversão de número " + saida.toString());	
		
	} catch (NullPointerException e) {
		
		JOptionPane.showMessageDialog(null, "Erro de Null pointer exeption " + e.getClass());
		
	} catch (Exception e) {/*Captura todas as excessão que não prevemos*/
		
		e.printStackTrace();
		
		JOptionPane.showMessageDialog(null, "Erro inesperado : " + e.getClass().getName());
		
	} 
	
	} //fim do while sairdosistema
		
	}
	
}

