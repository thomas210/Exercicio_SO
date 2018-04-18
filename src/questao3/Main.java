package questao3;

public class Main {
	public static void main(String[] args) {
		Mesa mesa = new Mesa();
		
		
		new Filosofo(0, mesa, 2000).start();
		new Filosofo(1, mesa, 3000).start();
		new Filosofo(2, mesa, 4000).start();
		new Filosofo(3, mesa, 2500).start();
		new Filosofo(4, mesa, 1000).start();
	}
}
