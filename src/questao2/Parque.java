package questao2;

import java.util.ArrayList;

public class Parque {
	private int indice;
	private boolean cheio;
	private ArrayList<Controle> visitantes;
	private int indiceTurmaBrincando;
	private int capacidade;
	private int quantidade;
	
	public Parque(int indice, int quantThreads) {
		this.indice = indice;
		this.cheio = false;
		this.capacidade = quantThreads;
		this.quantidade = 0;
		this.visitantes = new ArrayList();
		for (int i = 0; i < this.capacidade; i++) {
			Controle controle = new Controle();
			this.visitantes.add(controle);
		}
	}
	
	public synchronized void entrar (int indice) {
		if (this.indice != Main.parque) {	//GARANTE QUE O PARQUE QUE VAI ENTRAR E O QUE TODOS VAO ENTRAR
			System.out.println("não é esse parque que é pra entrar, parque "+this.indice);
			return;
		}else if (this.visitantes.get(indice).isDentro()) {	//SE JA ESTIVER DENTRO, NAO PODE ENTRAR DENOVO
			return;
		}else {
			this.visitantes.get(indice).Entrou();	//COLOCA NO CONTROLE QUE O VISITANTE ENTROU
			System.out.println(indice+" entrou no parque "+this.indice);
			this.quantidade++;	//AUMENA A QUANTIDADE DE PARTICIPANTES
		}
		
	}
	
	public synchronized void brincar (int indice) {
		try {
			if (this.indice != Main.parque) {	//GARANTE QUE O PARQUE QUE VAI BRINCAR E O QUE TODOS VAO BRINCAR
				return;
			}
			if (this.quantidade != this.capacidade) {	//SO PODE BRINCAR SE TODOS ESTIVEREM DENTRO, CAPACIDADE É IGUAL A QUANTIDADE DE THREADS
				System.out.println(indice+" não pode brincar agora, nem todos entraram no parque "+this.indice);
				this.wait();
			}
			if(this.visitantes.get(indice).isBrincou()) {	//SE JA TIVER BRINCADO NAO PODE BRINCAR DE NOVO
				System.out.println(indice+" ja brincou no brinquedo no parque "+this.indice);
				return;
			}
			if (this.cheio) {	//SE TIVER CHEIO, ESPERE
				System.out.println(indice+" nao pode brincar agora no parque "+this.indice);
				this.wait();
			}else {
				this.cheio = true;	//AGORA ESTA CHEIO
				this.indiceTurmaBrincando = indice;	//INDICA QUEM ESTA BINCANDO
				System.out.println(indice+" esta brincando no parque "+this.indice);
			}
		}catch( Exception e) {
			
		}
	}
	
	public synchronized void pararBrincar (int indice) {
		if (this.indice != Main.parque) {	//GARANTE QUE O PARQUE QUE VAI SAIR DE BRINCAR E O QUE TODOS ESTAO
			return;
		}
		if (this.indiceTurmaBrincando == indice) {	//SO PODE PARAR DE BRINCAR QUEM TAVA BRINCANDO
			this.cheio = false;
			System.out.println(indice+" parou de brincar, parque "+this.indice);
			this.visitantes.get(indice).jaBrinquei();	//COLOCA NO CONTROLE QUEM JA BRINCOU
			this.indiceTurmaBrincando = -1;	//RESETA O INDICARDOR DE QUEM TA BRINCANDO
			this.notify();	//NOTIFICA PRO PROXIMO
		}else {
			System.out.println(indice+" nao pode parar de brincar se nao estiver brincando,parque "+this.indice);
		}
	}
	
	public synchronized void sair() {
		try {
			if (this.indice != Main.parque) {	//GARANTE QUE O PARQUE QUE VAI SAIR E O QUE TODOS VAO SAIR
				return;
			}
			for (int i = 0; i < this.visitantes.size(); i++) {	//SO PODE SAIR SE TODOS JA ESTIVEREM PORNTOS, OU SEJA, SE TODOS JA TIVEREM ENTRADO E BRINCADO
				if (!this.visitantes.get(i).isPronto()) {
					System.out.println("Nem todos estão prontos, tenha calma,parque "+this.indice);
					return;
				}
			}
			this.quantidade = 0;	//RESETA A QUANTIDADE DE PESSOAS NO PARQUE
			for (int i = 0; i < this.visitantes.size(); i++) {
				this.visitantes.get(i).resetar();	//RESETA O CONTROLE
			}
			if (Main.parque == (Main.quantidadeParques-1)) {	//DEFINE QUAL O PROXIMO PARQUE
				Main.parque = 0;
			}
			else {
				Main.parque++;
			}
			System.out.println("Proximo, parque "+Main.parque);
			this.notifyAll();
		}catch (Exception e) {
			
		}
		
	}
}

