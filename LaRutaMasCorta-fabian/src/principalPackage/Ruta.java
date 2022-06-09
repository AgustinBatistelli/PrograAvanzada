package principalPackage;

public class Ruta {

	private String ciudad1;
	private String ciudad2;
	private int longitud;

	public Ruta(String ciudad1, String ciudad2, int longitud) {
		this.ciudad1 = ciudad1;
		this.ciudad2 = ciudad2;
		this.longitud = longitud;
	}

	public String getCiudad1() {
		return ciudad1;
	}

	public String getCiudad2() {
		return ciudad2;
	}

	public int getLongitud() {
		return longitud;
	}
}
