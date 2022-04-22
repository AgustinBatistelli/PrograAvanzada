package luchadoresJaponeses;

public class Luchador {
	
	private int peso;
	private int altura;
	
	public Luchador(int peso, int altura) {
		this.peso = peso;
		this.altura = altura;
	}
	
	public Luchador(Luchador otro) {
		peso = otro.peso;
		altura = otro.altura;
	}
	
	public boolean dominaA(Luchador otro) {
		
		return ((this.altura >= otro.altura && this.peso > otro.peso) || 
				(this.peso >= otro.peso && this.altura > otro.altura)); 		
	}
	
	
}
