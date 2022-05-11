package mesadas_granito;

public class Mesada {
	
	private int ancho;
	private int largo;

	public Mesada(Integer ancho, Integer largo) {
		this.ancho = ancho;
		this.largo = largo;
	}
	
	public int getAncho() {
		return ancho;
	}
	public int getLargo() {
		return largo;
	}

	public boolean sePuedeApilar(Mesada otraMesada) {	
		return ( (this.ancho <= otraMesada.ancho && this.largo<=otraMesada.largo)
				|| (this.ancho <= otraMesada.largo && this.largo<=otraMesada.ancho)) 
					&& tieneDimension(this) && tieneDimension(otraMesada); 
	}
	
	private boolean tieneDimension(Mesada unaMesada) {
		return unaMesada.ancho > 0 && unaMesada.largo > 0;
	}
	
	
}
