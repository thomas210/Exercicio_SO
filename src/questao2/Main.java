package questao2;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static int parque = 0;
	public static int quantidadeParques = 5;
	public static ArrayList<Parque> parques = new ArrayList();
	
	public static void main(String[] args) {
		int quantidadeTurmas = 3;
		Random geradorTempo = new Random();
		for (int i = 0; i < Main.quantidadeParques; i++) {
			Parque p = new Parque(i, quantidadeTurmas);
			Main.parques.add(p);
		}
		for (int i = 0; i < quantidadeTurmas; i++) {
			
			new Turma(i, parques, 1000).start();;
		}
	}

}
