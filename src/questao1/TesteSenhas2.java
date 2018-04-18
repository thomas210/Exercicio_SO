package questao1;

public class TesteSenhas2 extends Thread {
	private int indice;
	private int modulo;
	private String senha = null;
	
	/*CADA THREAD VAI TESTAR UM NUMERO, CADA UM TESTA UMA SENHA NA ORDEM E DEPOIS VAI PARA O SEGUINTE DA SENHA TESTADA PELA ULTIMA THREAD
	 * EXEMPLO: 4 THREADS
	 * 0000000000 E TESTADA PELA THREAD 0, 0000000001 E TESTADA PELA THREAD 1, 0000000002 E TESTADA PELA THREAD 2, 0000000003 E TESTADA PELA THREAD 3 
	 * 0000000004 E TESTADA PELA THREAD 0, 0000000005 E TESTADA PELA THREAD 1, 0000000006 E TESTADA PELA THREAD 2, 0000000007 E TESTADA PELA THREAD 3 
	 * ETC
	 * OBS: APESAR DE PARECER, ESSA ORDEM NAO E SEQUENCIAL POIS CADA THREAD VAI TESTAR NA SUA VEZ E CADA THREAD TESTA UM QUANTIDADE DE SENHAS*/
	
	//CONSTRUTOR DA THREAD
	public TesteSenhas2(int indice, int quantidadeTheards) {
		this.indice = indice;
		this.modulo = quantidadeTheards;
		System.out.println(this.indice+" iniciada");
	}
	
	public void run() {
		long senhaNumber = this.indice;	//O PRIMEIRO NUMERO QUE A THREAD VAI TESTAR E O INDICE DELA
		while (Main.desconhecido && senhaNumber <= 9999999999L) {	//ENQUANDO NAO ATINGIR O LIMITE MAXIMO OU ENQUANTO A SENHA ESTIVER DESCONHECIDA
			this.senha = String.format("%010d", senhaNumber);	//PEGAR O TESTE E CONVERTER PARA STRING
			if (this.senha.equals(Main.senha)) {	//COMPARA SE A O TESTE E IGUAL A SENHA
				Main.desconhecido = false;	//SE FOR, A SENHA NAO E MAIS DESCONHECIDA
				System.out.println("Thread N:"+this.indice+" descobriu a senha\nSenha: "+this.senha);
				break;
			}
			else {
				senhaNumber = senhaNumber + this.modulo;	//CASO AINDA NAO TENHA ACHADO A SENHA ELE INCREMENTE A THREAD, CADA THREAD TESTA NUMEROS DE ACORDO COM A QUANTIDADE DE THREADS
			}
		}
	}
}
