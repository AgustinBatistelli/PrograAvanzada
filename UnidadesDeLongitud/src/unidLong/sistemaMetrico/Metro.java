package unidLong.sistemaMetrico;

import unidLong.UnidadDeLongitud;

public class Metro extends UnidadDeLongitud {
	
	public Double convertirAKm(Double cant) {
		return cant /= 1000;
	}

	public Double convertirAPie(Double cant) {
		return cant *= 3.28;
	}
}
