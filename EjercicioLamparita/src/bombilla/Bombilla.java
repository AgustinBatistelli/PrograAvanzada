package bombilla;

public class Bombilla {
	
	private int potencia;
	
	public Bombilla(int valor) {
		potencia = valor;
	}

	public int getPotencia() {
		return potencia;
	}
	
	public Bombilla compararBombilla(Bombilla bombilla2) {
		
		if (potencia > bombilla2.potencia)
			return this;
		else
			return bombilla2; 
	}
	
}
