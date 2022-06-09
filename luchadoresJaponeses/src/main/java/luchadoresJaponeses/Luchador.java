package luchadoresJaponeses;

public class Luchador {
	private double 	altura,
					peso;
	
	public Luchador(double altura, double peso) {
		this.altura = altura;
		this.peso = peso;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public boolean dominaA(Luchador luchador) {
		return (altura >= luchador.altura && peso > luchador.peso) || (altura > luchador.altura && peso >= luchador.peso);
	}
}
