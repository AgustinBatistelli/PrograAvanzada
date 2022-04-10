package ejercicioCirculo;

public class Punto {

	private double x;
	private double y;

	public Punto() {
		this(0, 0);
	}

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double diferenciaEntrePuntos(Punto p) {
		return Math.sqrt(Math.pow(this.y - p.y, 2) + Math.pow(this.x - p.x, 2));
	}
}
