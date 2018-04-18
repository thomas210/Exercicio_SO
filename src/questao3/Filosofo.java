package questao3;

public class Filosofo extends Thread{
	private int indice;
	private Mesa mesa;
	private long tempo;
	
	public Filosofo(int indice, Mesa mesa, long tempo) {
		this.indice = indice;
		this.mesa = mesa;
		this.tempo = tempo;
	}
	
	public void run() {
		while (true) {
			try {
				mesa.pensar(this.indice);	//VAI PENSAR
				sleep(this.tempo);
				if (mesa.comer(this.indice)) {	//VAI COMER
					sleep(this.tempo);
					mesa.soltarGarfos(this.indice);	//SE CONSEGUIR COMER ENTAO QUANDO ACABAR SOLTA OS GARFOS
				}
			}catch (Exception e) {
				
			}
		}
	}
}
