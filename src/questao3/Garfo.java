package questao3;

public class Garfo {
	private boolean disponivel;
	
	
	public Garfo() {
		this.disponivel = true;
	}
	
	public void ocupado() {
		this.disponivel = false;
	}
	
	public void liberado() {
		this.disponivel = true;
	}
	
	public boolean isDisponivel() {
		return this.disponivel;
	}
	
	
}
