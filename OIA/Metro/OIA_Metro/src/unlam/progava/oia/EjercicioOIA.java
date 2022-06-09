package unlam.progava.oia;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EjercicioOIA {
	
	private Mapa mapa;
	
	public static void main(String[] args) throws IOException {
		EjercicioOIA ejercicio = new EjercicioOIA();
		ejercicio.leer("src/unlam/progava/oia/in/00.in");
		ejercicio.resolver();
		ejercicio.escribir("src/unlam/progava/oia/out/00.out");
	}
	
	public void leer(String path) throws FileNotFoundException {
		mapa = Archivo.leerArchivo(path);
		
	}
	
	public void escribir(String path) throws IOException {
		Archivo.escribirArchivo(path, this.mapa.getResultado());
		
	}
	
	public void resolver() {
		mapa.resolver();
	}
}
