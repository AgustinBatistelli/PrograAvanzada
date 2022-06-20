package mesadaGranito;

public class Mesada {
	private double ancho, largo;
	
	public Mesada(double ancho, double largo) {
		this.ancho = ancho;
		this.largo = largo;
	}

	public double getAncho() {
		return ancho;
	}

	public double getLargo() {
		return largo;
	}
	
	public boolean esApilable(Mesada m2) {
		return (getAncho() < m2.getAncho() && getLargo() < m2.getLargo()) || (getAncho() < m2.getLargo() && getLargo() < m2.getAncho());
	}
}
