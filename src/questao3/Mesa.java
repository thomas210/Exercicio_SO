package questao3;

import java.util.ArrayList;

public class Mesa {
	private ArrayList<Garfo> garfos = null;
	
	public Mesa() {
		this.garfos = new ArrayList();
		for (int i = 0; i < 5; i++) {
			Garfo garfo = new Garfo();
			this.garfos.add(garfo);
		}
	}
	
	
	public synchronized boolean comer (int indice) {
		boolean res = false;
		try {
			boolean dir = this.garfos.get(indice).isDisponivel();	//CHECA SE O GARFO DA ESQUERDA ESTA DISPONIVEL
			boolean esq;
			if (indice == 0) {
				esq = this.garfos.get(4).isDisponivel();	//CHECA SE O GARFO DA DIREITA ESTA DISPONIVEL
			}else{
				esq = this.garfos.get(indice - 1).isDisponivel() ;	//CHECA SE O GARFO DA DIREITA ESTA DISPONIVEL
			}
			if (esq == true && dir == true) {
				this.garfos.get(indice).ocupado();	//PEGA GARFO ESQUERDO
				if (indice == 0) {
					this.garfos.get(4).ocupado();	//PEGA GARFO DIREITO
				}else{
					this.garfos.get(indice - 1).ocupado();	//PEGA GARFO DIREITO
				}
				System.out.println("Filosofo "+indice+" esta comendo");
				res =  true;
			}
			else {
				System.out.println("Filoso "+indice+" não pode comer");
				res = false;
			}
		}catch(Exception e) {
			
		}
		return res;	//RETORNA SE CONSEGUIU COMER
		
	}
	
	public synchronized void soltarGarfos (int indice) {
		
		this.garfos.get(indice).liberado();	//SOLTA O GARFO ESQUERDO
		if (indice == 0) {
			this.garfos.get(4).liberado();	//SOLTA O GARFO DIREITO
		}
		else {
			this.garfos.get(indice-1).liberado();	//SOLTA O GARFO DIREITO
		}
		System.out.println("Filoso "+indice+" soltou os garfos");
	}
	
	public synchronized void pensar (int indice) {	//FOI PENSAR
		System.out.println("Filosofo "+indice+" esta pensando");
	}
}
