package principalPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class RutaMasCorta extends EjercicioOIA {

	private CiudadesYRutas ciudades;
	private int cantCiudades;

	public RutaMasCorta(File entrada, File salida) throws FileNotFoundException {
		super(entrada, salida);
		this.ciudades = new CiudadesYRutas(this.entrada);
		this.cantCiudades = this.ciudades.getCantNodos();
	}

	@Override
	public void resolver() throws IOException, IOException {

		int nodoInicial, nodoFinal;
		String ciudadInicial, ciudadFinal;

		Scanner scan = new Scanner(System.in);

		System.out.println("LA RUTA MAS CORTA");
		System.out.println("Ingrese la Ciudad Origen: ");
		ciudadInicial = scan.next();
		System.out.println("Ingrese la Ciudad Destino: ");
		ciudadFinal = scan.next();
		scan.close();

		nodoInicial = this.ciudades.getNumeroCiudad(ciudadInicial);
		nodoFinal = this.ciudades.getNumeroCiudad(ciudadFinal);

		if ((nodoInicial < 0 || nodoInicial > this.cantCiudades - 1)
				|| (nodoFinal < 0 || nodoFinal > this.cantCiudades - 1)) {
			System.out.println("Al menos una de las ciudades especificadas no aparece en el archivo de entrada");
			this.salida.delete();
			System.exit(0);
		}

		DijkstraRutas dijkstra = new DijkstraRutas(this.ciudades, nodoInicial);
		dijkstra.ejecutar();
		dijkstra.escribirSolucionEnConsola(nodoFinal);
		dijkstra.escribirSolucionEnArchivo(this.salida, nodoFinal);
	}

}
