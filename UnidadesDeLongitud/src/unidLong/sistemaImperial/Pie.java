package unidLong.sistemaImperial;

import unidLong.UnidadDeLongitud;

public class Pie extends UnidadDeLongitud {

	public Double convertirAKm(Double cant) {
		return casosPie(cant, KILOMETRO);
	}
	
	public Double convertirAMilla(Double cant) {
		return casosPie(cant, MILLA);
	}
	
	public Double convertirAMetro(Double cant) {
		return casosPie(cant, METRO);
	}
	
}
