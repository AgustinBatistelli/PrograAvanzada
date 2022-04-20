package unidLong.sistemaImperial;

import unidLong.UnidadDeLongitud;

public class Milla extends UnidadDeLongitud{

	public Double convertirAKm(Double cant) {
		return casosMilla(cant, KILOMETRO);
	}
	
	public Double convertirAPie(Double cant) {
		return casosMilla(cant, PIE);
	}
	
	public Double convertirAMetro(Double cant) {
		return casosMilla(cant, METRO);
	}
	
}
