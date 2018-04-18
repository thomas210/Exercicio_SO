package questao1;

public class Main {
	
	
	public static boolean desconhecido = true;
	public static String senha = "0000770000";
	//NUMERO MAXIMO DA SENHA = 9.999.999.999
	
	public static void main(String[] Args) {
		int quantidadeThreads = 3;
		for (int i = 0; i < quantidadeThreads; i++) {
			new TesteSenhaLong(i, quantidadeThreads).start();
		}
	}
}
