package sistemaImperial;

import unidLong.UnidadDeLongitud;

public class Pie extends UnidadDeLongitud {

	public Double convertirAMilla(Double cant) {
		return cant /= 5280;
	}

	public Double convertirAMetro(Double cant) {
		return cant /= 3.28;
	}
	
}
