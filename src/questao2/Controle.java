package questao2;

public class Controle {
	
	/*CLASSE PARA CONTROLE DOS VISITANTES, SABER QUEM ENTROU E QUEM JA BRINCOU*/
	private boolean dentro;
	private boolean brincou;
	
	
	public Controle() {
		this.resetar();
	}
	
	public boolean isDentro() {
		return this.dentro;
	}
	
	public void Entrou() {
		this.dentro = true;
	}
	
	public boolean isPronto() {
		if (dentro && brincou) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean isBrincou() {
		return this.brincou;
	}
	
	public void jaBrinquei() {
		this.brincou = true;
	}
	
	public void resetar() {
		this.dentro = false;
		this.brincou = false;
	}
}
