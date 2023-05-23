package Executavel;

import Formatacao.FormatarConta;
import Formatacao.FormatarCpf;
import Formatacao.FormatarData;
import classes.*;
import interfaces.ConfirmarConta;
import interfaces.PermitirAcesso;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {    
	
	public static void main(String[] args) {

		String usuario = " ";
		boolean sairSistema = true;
		Random random = new Random();


		ContaCorrente contaCorrente = new ContaCorrente();
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		Procedimentos procedimentos = new Procedimentos();
		Clientes clientes = new Clientes();
		String[] opcoes = {"Conta Corrente","Conta Poupança"};

		while (sairSistema) {
			
			try{
				Scanner scanner = new Scanner(System.in);
                int resposta = JOptionPane.showConfirmDialog(null, "Bem vindo! o senhor já é Cliente? ","Banco Digital", JOptionPane.YES_NO_CANCEL_OPTION);

				if (resposta == 0) {

					int opcaoAcesso = random.nextInt(3) + 1; // gera um número aleatório entre 1 e 3

					FormatarCpf formatarCpf = new FormatarCpf();
					FormatarData formatarData = new FormatarData();
					FormatarConta formatarConta = new FormatarConta();

					clientes.setPosLogin(opcaoAcesso);//Preciso saber a posicao da escolha para buscar na matriz o dado correto

					switch (opcaoAcesso) {
						case 1 -> {
							usuario = JOptionPane.showInputDialog(null, "Informe a data de nascimento do titular :\n" + "Ex.: 01010001", "Banco Digital", JOptionPane.INFORMATION_MESSAGE);
							if (usuario == null || usuario.equals("")) {
								continue;
							}
							formatarData.setDataTx(usuario);
							usuario = formatarData.getDataTx();
							clientes.setPosSenha(opcaoAcesso + 5);
						}
						case 2 -> {
							usuario = JOptionPane.showInputDialog(null, "Informe o CPF do titular da conta :\n" + "Ex.: 00100100101", "Banco Digital", JOptionPane.INFORMATION_MESSAGE);
							if (usuario == null || usuario.equals("")) {
								continue;
							}
							formatarCpf.setCpfnumero(usuario);
							usuario = formatarCpf.getCpfformatado();
							clientes.setPosSenha(opcaoAcesso + 4);
						}
						case 3 -> {
							usuario = JOptionPane.showInputDialog(null, "Informe a conta : ", "Banco Digital", JOptionPane.INFORMATION_MESSAGE);
							if (usuario == null || usuario.equals("")) {
								continue;
							}
							formatarConta.setNumeroConta(usuario);
							usuario = formatarConta.getNumeroConta();
							clientes.setPosSenha(opcaoAcesso + 3);
						}
					}

					String senha = JOptionPane.showInputDialog(null,"Informe senha : ","Banco Digital", JOptionPane.INFORMATION_MESSAGE);

					Movimentacao movimentacao = new Movimentacao();
					PermitirAcesso pAcesso = new Clientes();

					NumberFormat vlr = NumberFormat.getCurrencyInstance();

					clientes.setConfirmarAcesso(usuario, senha);

					if(clientes.getUsuarioCliente() == null) {

						continue;
					}

					if(pAcesso.validar(usuario, senha)) {

						boolean sair = true;//variável de controlo do sistema após a autenticação do "login" e senha

						CartaoCredito cartaoCredito = new CartaoCredito();

						ArrayList<String> extratoCc = new ArrayList<>();
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
									6- Sair""", "Banco Digital", JOptionPane.INFORMATION_MESSAGE);

							if (opcao == null) {
								break;
							}

							if(opcao.equals("3")){
								int opcaoDeposito = JOptionPane.showOptionDialog(null, "Escolha o tipo de conta:", "Tipo de conta", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
								procedimentos.setcontaDeposito(opcaoDeposito);
							} else {
								procedimentos.setconfirmarConta(opcao);
							}

							switch (opcao) {
								case "1" -> {//resolve as transações da conta corrente

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
												contaCorrente.setSaqueCc(Double.parseDouble(saque));
												contaCorrente.setSaque(Double.parseDouble(saque));
												contaCorrente.setOpcao(opcaoCc);
												extratoCc.add(contaCorrente.getDescricaoExtrato());
											}
										}
									}
								}
								case "2" -> { //resolve as transações de cartão de crédito

									String opCartao = JOptionPane.showInputDialog("""
											O que deseja realizar :
											1- Limite de crédito
											2- Saldo disponível
											3- Data de vencimento
											4- Histórico de compra
											5- Comprar com cartão
											6- sair""");

									switch (opCartao) {
										case "1": //Opção limite de crédito

											String opCartao1 = JOptionPane.showInputDialog("""
													- Limite de crédito
													-------------------------------
													O que deseja realizar :
													1- Aumentar Limite de crédito
													2- Consultar limite de crédito
													-------------------------------""");

											if (opCartao1.equals("1")) {

												String aumentolimitecar = JOptionPane.showInputDialog("""
														- Limite de crédito
														---------------------------------------------------------
														Informe o valor desejado de acréscimo
														---------------------------------------------------------""");

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
											boolean continuar = true;

											while (entrada.equals("")) {

												if (continuar) {

													cancelar = JOptionPane.showConfirmDialog(null, "Deseja continuar na opção de compra?", "Cartão de Crédito", JOptionPane.YES_NO_CANCEL_OPTION);
												}

												if (cancelar == 1) {

													entrada = "sair";

												} else {

													continuar = false;
													String valorCompra = JOptionPane.showInputDialog(null, "Informe o valor da compra : \n" + "Limite para compra R$ " + cartaoCredito.getSaldoDiponivel(), "Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);
													String localCompra = JOptionPane.showInputDialog(null, "Informe o nome da loja ou estabelecimento : ", "Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);
													String dataCompra = JOptionPane.showInputDialog(null, "Digite a data da compra : (ex: 01011001) ", "Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);

													formatarData.setDataTx(dataCompra);
													dataCompra = formatarData.getDataTx();

													int alterardados = JOptionPane.showConfirmDialog(null, "confirmar dados da compra? \n" + "valor R$ " + valorCompra +
															"; Local da compra : " + localCompra + "; data da compra : " + dataCompra, "Cartão de Crédito", JOptionPane.YES_NO_CANCEL_OPTION);

													if (alterardados == 1) {

														String opcaodados = JOptionPane.showInputDialog(null, "Informe a opção que deseja alterar dados :\n 1 - Valor da compra; 2 - Local da compra; 3 - Data da compra", "Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);

														switch (opcaodados) {
															case "1" ->
																	valorCompra = JOptionPane.showInputDialog(null, "Informe o valor da compra : ", "Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);
															case "2" ->
																	localCompra = JOptionPane.showInputDialog(null, "Informe o nome da loja ou estabelecimento : ", "Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);
															case "3" ->
																	dataCompra = JOptionPane.showInputDialog(null, "Digite a data da compra : (ex: 01011001) ", "Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);
															default ->
																	JOptionPane.showMessageDialog(null, "Opção escolhida não confere com a mensagem!", "Cartão de Crédito", JOptionPane.INFORMATION_MESSAGE);
														}

													} else {

														String senhaPermissao = JOptionPane.showInputDialog(null, "Informe senha para liberar comprar : ", "Segurança", JOptionPane.INFORMATION_MESSAGE);

														if (clientes.getSenhaAcesso().equals(senhaPermissao)) {

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
											}

											break;
										case "6":

											break label;

									}
								}
								case "3" -> {//depósito

									String opcaoCc = "4";
									String deposito = JOptionPane.showInputDialog(null, "Informe o valor de depósito : ", "Depósito", JOptionPane.INFORMATION_MESSAGE);

										if(Conta.getVariacao().equals("10")) {

											contaCorrente.setSaldoCc(Double.parseDouble(deposito));
											//movimentacao.setVariacao(1);
											movimentacao.setOpcao(opcaoCc);
											extratoCc.add(movimentacao.getDescricaoExtrato());

										} else {
											contaPoupanca.setSaldo(Double.parseDouble(deposito));
											contaPoupanca.setSaldoCp(contaPoupanca.getSaldo());
											//movimentacao.setVariacao(51);
											movimentacao.setOpcao(opcaoCc);
											//extratoCp.add(movimentacao.getDescricaoExtrato());

										}


								}

								case "4" -> { //opção tranferencia

									String opcaoCc = "5";
									String contaTransferencia = JOptionPane.showInputDialog(null, "Informe a conta de destino : ", "Tranferência", JOptionPane.INFORMATION_MESSAGE);
									String transferencia = JOptionPane.showInputDialog(null, "Informe o valor de transferência : ", "Transferência", JOptionPane.INFORMATION_MESSAGE);
									movimentacao.setTransferencia(Double.parseDouble(transferencia), contaTransferencia);
									movimentacao.setOpcao(opcaoCc);
									extratoCc.add(movimentacao.getDescricaoExtrato());

								}
								case "5" -> { //opção conta poupança

									if(contaPoupanca.isBloquearCp()) {
										String opcaoCp = JOptionPane.showInputDialog(null, """
												Escolha a opcção :
												1- Saldo
												2- Extrato
												3- Saques""", "Conta Poupança", JOptionPane.INFORMATION_MESSAGE);

										if (opcaoCp == null) continue;


										switch (opcaoCp) {
											case "1" -> {
												Double valorSaldo = contaCorrente.getSaldoCc();
												if (valorSaldo == 0.0) {
													JOptionPane.showMessageDialog(null, "Sua conta conrrente está sem saldo " + vlr.format(valorSaldo), "Saldo", JOptionPane.INFORMATION_MESSAGE);
													movimentacao.setOpcao(opcaoCp);
													extratoCc.add(movimentacao.getDescricaoExtrato());
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
												contaCorrente.setSaque(Double.parseDouble(saque));
												movimentacao.setOpcao(opcaoCp);
												extratoCc.add(movimentacao.getDescricaoExtrato());
											}
										}
									}
								}
								case "6" ->  //opção sair

										sair = false;

								//break;

							}
						}

					} else {

						JOptionPane.showMessageDialog(null, "Acesso negado!" + " senhor " + usuario + " nome do usuário e/ou senha não confere(m) com o(s) cadastrado(s).","Segurança - Validação", JOptionPane.INFORMATION_MESSAGE);

					}
//========================================== Se não for cliente vem para está parte do código ===================================================================================

				} else if(resposta == 1) {

					int resposta2 = JOptionPane.showConfirmDialog(null, "Deseja abrir sua conta no banco digital? ","Informação com segurança", JOptionPane.YES_NO_CANCEL_OPTION);

					if (resposta2 == 0) {//criar conta no aplicativo banco digital

						int opcaoC = JOptionPane.showOptionDialog(null, "Escolha o tipo de conta:", "Tipo de conta", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

						switch (opcaoC) {
							case 0 -> clientes.setOpcaoC("10");
							case 1 -> clientes.setOpcaoC("51");
						}

						String nomeCompleto = JOptionPane.showInputDialog(null,"Informe o nome completo do usuário : ","Banco Digital", JOptionPane.INFORMATION_MESSAGE);
						String dataNascimento = JOptionPane.showInputDialog(null,"Informe a data de nascimeto : \n"+"Ex.: 01011001","Banco Digital", JOptionPane.INFORMATION_MESSAGE);
						String cpf = JOptionPane.showInputDialog(null,"Informe o CPF : \n"+"Ex.: 12345678910","Banco Digital", JOptionPane.INFORMATION_MESSAGE);

						int numerogerado = random.nextInt(90000) + 10000; // gera um número aleatório entre 1000 e 9999

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

						clientes.Reiniciarlista();
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

					sairSistema = false;
					//System.exit(0);

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

