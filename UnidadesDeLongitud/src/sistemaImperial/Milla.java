package sistemaImperial;

import unidLong.UnidadDeLongitud;

public class Milla extends UnidadDeLongitud {

	public Double convertirAPie(Double cant) {
		return cant *= 5280;
	}

}
