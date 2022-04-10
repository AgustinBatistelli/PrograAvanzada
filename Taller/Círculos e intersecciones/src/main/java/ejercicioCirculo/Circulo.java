package ejercicioCirculo;

public class Circulo {

	private Punto centro;
	private double radio;

	public Circulo(Punto centro, double radio) {
		this.centro = centro;
		this.radio = radio;
	}
	
	// max(R1, R2) - min(R1, R2) <= AB <= R1 + R2 -> hay interseccion
	// AB = 0 y R1 = R2 -> es el mismo circulo
	public boolean hayInterseccion(Circulo obj) {
		return (this.radio + obj.radio) >= centro.diferenciaEntrePuntos(obj.centro);
	}
	
}
