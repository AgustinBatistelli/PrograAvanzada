package mesada;

public class Mesada {

	private int largo;
	private int ancho;

	public Mesada(int ancho, int largo) {
		if (ancho < largo) {
			this.ancho = ancho;
			this.largo = largo;
		} else {
			this.ancho = largo;
			this.largo = ancho;
		}

	}

	public Mesada(Mesada mesada) {
		this.ancho = mesada.ancho;
		this.largo = mesada.largo;
	}

	public int getAncho() {
		return ancho;
	}

	public void setMesada(Mesada otra) {
		this.ancho = otra.ancho;
		this.largo = otra.largo;
	}

	public boolean menorIgual(Mesada otra) {
		return this.ancho <= otra.ancho && this.largo <= otra.largo;
	}

	@Override
	public String toString() {
		return "Mesada [ancho=" + ancho + ", largo=" + largo + "]";
	}

}
