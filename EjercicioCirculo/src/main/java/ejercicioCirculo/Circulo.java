package ejercicioCirculo;

public class Circulo {
	private Punto centro;
	private double radio;
	
	public Circulo(Punto centro, double radio) {
		super();
		this.centro = centro;
		this.radio = radio;
	}
	
	
	//considero que si ambos circulos coinciden en al menos un punto del plano, entonces intersectan
	public boolean intersectaCon(Circulo circulo2) {
		return radio + circulo2.radio >= centro.distanciaEntre(circulo2.centro);
	}
	
	
}
