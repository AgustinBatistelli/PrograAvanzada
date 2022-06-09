package unidLong.sistemaMetrico;

import unidLong.TipoUnidadLong;
import unidLong.UnidadDeLongitud;

public class Kilometro extends UnidadDeLongitud {

	public Double convertirAMetro(Double cant) {
		return cant * 1000;
	}

	public Double convertirAMetroUsandoEnum(Double cant) {
		return casosKmUsandoEnum(cant, TipoUnidadLong.METRO);
	}
}
