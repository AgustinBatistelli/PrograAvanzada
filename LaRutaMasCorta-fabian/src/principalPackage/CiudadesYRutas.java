package principalPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CiudadesYRutas {

	private MatrizSimetrica grafo;
	private int cantCiudades;
	private int cantRutas;
	private int dimensionLongitudRutas;
	private ArrayList<String> ciudades;
	private int[] longitudRutas;

	public CiudadesYRutas(File entrada) throws FileNotFoundException {
		FileReader file = new FileReader(entrada);
		Scanner scan = new Scanner(file);

		this.cantCiudades = 0;
		this.cantRutas = 0;
		this.ciudades = new ArrayList<String>();
		
		int ciudad1, ciudad2, distancia, indice;
		String c1, c2;
		Queue<Ruta> rutas = new LinkedList<Ruta>();
		
		while (scan.hasNextLine()) {
			c1 = scan.next();
			c2 = scan.next();
			distancia = scan.nextInt();

			rutas.offer(new Ruta(c1, c2, distancia));
			this.cantRutas++;

			if (!this.ciudades.contains(c1)) {
				this.ciudades.add(c1);
				this.cantCiudades++;
			}
			if (!this.ciudades.contains(c2)) {
				this.ciudades.add(c2);
				this.cantCiudades++;
			}
		}
		scan.close();
		
		this.grafo = new MatrizSimetrica(this.cantCiudades);
		this.dimensionLongitudRutas = (this.cantCiudades * this.cantCiudades - this.cantCiudades) / 2;
		longitudRutas = new int[this.dimensionLongitudRutas];

		Ruta ruta;
		while (!rutas.isEmpty()) {
			ruta = rutas.poll();
			c1 = ruta.getCiudad1();
			c2 = ruta.getCiudad2();
			distancia = ruta.getLongitud();
			
			ciudad1 = this.ciudades.indexOf(c1);
			ciudad2 = this.ciudades.indexOf(c2);
			if (ciudad1 < ciudad2) {
				indice = this.grafo.getIndice(ciudad1, ciudad2);
			} else {
				indice = this.grafo.getIndice(ciudad2, ciudad1);
			}
			
			this.longitudRutas[indice] = distancia;
			this.grafo.ponerArista(indice);
		}

	}

	public int getCantNodos() {
		return cantCiudades;
	}

	public int getCantAristas() {
		return cantRutas;
	}

	public int getPesoArista(int indice) {
		return longitudRutas[indice];
	}
	
	public String getNombreCiudad(int numeroCiudad) {
		return this.ciudades.get(numeroCiudad);
	}
	
	public int getNumeroCiudad(String nombreCiudad) {
		return this.ciudades.indexOf(nombreCiudad);
	}
	
	public MatrizSimetrica getGrafo() {
		return this.grafo;
	}
}
