package questao2;

import java.util.ArrayList;

public class Turma extends Thread{
	private int indice;
	private ArrayList<Parque> parques;
	private long tempo;
	
	public Turma(int indice, ArrayList<Parque> parques, long tempo) {
		this.indice = indice;
		this.parques = parques;
		this.tempo = tempo;
	}
	
	public void run() {
		while(true) {
			try {
				Parque p = this.parques.get(Main.parque);	//PEGA O PARQUE DA VEZ
				p.entrar(this.indice);	//ENTRA NO PARQUE
				p.brincar(this.indice);	//BRINCA NO PARQUE
				sleep(this.tempo);
				p.pararBrincar(this.indice);	//PARA DE BRINCAR
				p.sair();	//SAI DO PARQUE
				sleep(this.tempo);	
			} catch (InterruptedException e) {

			}
		}
		
	}
}
