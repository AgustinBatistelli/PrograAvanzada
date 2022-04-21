package ejercicioCirculo;

public class Punto {

	private double x;
	private double y;

	public Punto(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double calcularDistanciaDesde(Punto punto) {
		double cateto1 = x - punto.x;
		double cateto2 = y - punto.y;
		double hipotenusa = Math.sqrt(cateto1*cateto1 + cateto2*cateto2);
		return hipotenusa;
		}	

}
