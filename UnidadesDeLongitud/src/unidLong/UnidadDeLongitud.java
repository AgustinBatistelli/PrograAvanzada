package unidLong;

import sistemaImperial.Milla;
import sistemaImperial.Pie;
import unidLong.sistemaMetrico.Kilometro;
import unidLong.sistemaMetrico.Metro;

public abstract class UnidadDeLongitud {

	public final static String METRO = "Metro";
	public final static String KILOMETRO = "Kilometro";
	public final static String PIE = "Pie";
	public final static String MILLA = "MILLA";

	private TipoUnidadLong tipo;

	/* USANDO STRING */

	public static Double convertir(Double cant, String origen, String destino) {
		
		Double conversion = new Double(0);

		switch(origen) {

		case METRO: {

			conversion = casosMetro(cant, destino);

			break;
		}

		case KILOMETRO: {

			conversion = casosKm(cant, destino);

			break;
		}

		case PIE: {

			conversion = casosPie(cant, destino);

			break;
		}

		case MILLA: {

			conversion = casosMilla(cant, destino);

			break;
		}

		}

		return conversion;
	}

	public static Double casosMilla(Double cant, String destino) {

		switch(destino) {

		case METRO: {

			Milla milla = new Milla();
			Double cantPies = milla.convertirAPie(cant);

			Pie pie = new Pie();
			cant = pie.convertirAMetro(cantPies);

			break;
		}
		case KILOMETRO: {

			Milla milla = new Milla();
			Double cantPies = milla.convertirAPie(cant);

			Pie pie = new Pie();
			Double cantMetros = pie.convertirAMetro(cantPies);

			Metro metro = new Metro();
			cant = metro.convertirAKm(cantMetros);
			break;
		}
		case PIE: {
			Milla milla = new Milla();
			cant = milla.convertirAPie(cant);
			break;
		}
		case MILLA: {
			break;
		}

		}

		return cant;
	}

	public static Double casosPie(Double cant, String destino) {

		switch(destino) {

		case METRO: {
			Pie pie = new Pie();
			cant = pie.convertirAMetro(cant);
			break;
		}
		case KILOMETRO: {
			Pie pie = new Pie();
			Double metros = pie.convertirAMetro(cant);

			Metro m = new Metro();
			cant = m.convertirAKm(metros);
			break;
		}
		case PIE: {
			break;
		}
		case MILLA: {
			Pie pie = new Pie();
			cant = pie.convertirAMilla(cant);
			break;
		}

		}

		return cant;		
	}

	public static Double casosKm(Double cant, String destino) {

		switch(destino) {

		case METRO: {
			Kilometro km = new Kilometro();
			cant = km.convertirAMetro(cant);
			break;
		}
		case KILOMETRO: { 
			break;
		}
		case PIE: {
			Kilometro km = new Kilometro();
			Double metros = km.convertirAMetro(cant);

			Metro m = new Metro();
			Double pie = m.convertirAPie(metros);

			cant *= pie;
			break;
		}
		case MILLA: {
			Kilometro km = new Kilometro();
			Double metros = km.convertirAMetro(cant);

			Metro m = new Metro();
			Double pie = m.convertirAPie(metros);

			Pie pies = new Pie();
			Double millas = pies.convertirAMilla(pie);

			cant *= millas;
			break;
		}

		}

		return cant;
	}

	public static Double casosMetro(Double cant, String destino) {

		switch(destino) {

		case METRO: {
			break;
		}
		case KILOMETRO: {

			Metro m = new Metro();
			cant = m.convertirAKm(cant);

			break;
		}
		case PIE: {

			Metro m = new Metro();
			cant = m.convertirAPie(cant);

			break;
		}
		case MILLA: {

			Metro m = new Metro();
			Double pies = m.convertirAPie(cant);

			Pie pie = new Pie();
			cant = pie.convertirAMilla(pies);
			break;
		}

		}

		return cant;
	}

	/* USANDO ENUMS */

	public static Double convertirUsandoEnum(Double cant, TipoUnidadLong origen, TipoUnidadLong destino) {

		switch(origen.ordinal()) {

		case 0: {

			cant = casosMetroUsandoEnum(cant, destino);

			break;
		}

		case 1: {

			cant = casosKmUsandoEnum(cant, destino);

			break;
		}

		case 2: {

			cant = casosPieUsandoEnum(cant, destino);

			break;
		}

		case 3: {

			cant = casosMillaUsandoEnum(cant, destino);

			break;
		}

		}

		return cant;
	}

	public static Double casosMillaUsandoEnum(Double cant, TipoUnidadLong destino) {

		switch(destino.ordinal()) {

		case 0: {
			cant *= 1609;
			break;
		}
		case 1: {
			cant *= 1.6093;
			break;
		}
		case 2: {
			cant *= 5280;
			break;
		}
		case 3: {
			break;
		}

		}

		return cant;
	}

	public static Double casosPieUsandoEnum(Double cant, TipoUnidadLong destino) {

		switch(destino.ordinal()) {

		case 0: {
			cant /= 3.281;
			break;
		}
		case 1: {
			cant /= 3281;
			break;
		}
		case 2: {
			break;
		}
		case 3: {
			cant /= 5280;
			break;
		}

		}

		return cant;
	}

	public static Double casosKmUsandoEnum(Double cant, TipoUnidadLong destino) {

		switch(destino.ordinal()) {

		case 0: {
			cant *= 1000;
			break;
		}
		case 1: { 
			break;
		}
		case 2: {
			cant *= 3281;
			break;
		}
		case 3: {
			cant /= 1.609;
			break;
		}

		}

		return cant;
	}

	public static Double casosMetroUsandoEnum(Double cant, TipoUnidadLong destino) {

		switch(destino.ordinal()) {

		case 0: {
			break;
		}
		case 1: {
			cant /= 1000; 
			break;
		}
		case 2: {
			cant *= 3.281;
			break;
		}
		case 3: {
			cant /= 1609;
			break;
		}

		}

		return cant;

	}

	/* GETTERS Y SETTERS */

	public TipoUnidadLong getTipo() {
		return tipo;
	}

	public void setTipo(TipoUnidadLong tipo) {
		this.tipo = tipo;
	}
}
