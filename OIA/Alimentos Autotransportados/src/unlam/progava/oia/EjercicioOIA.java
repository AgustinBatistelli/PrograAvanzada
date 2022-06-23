package unlam.progava.oia;

import java.io.IOException;

public class EjercicioOIA {
	
	private Sistema sistema;
	
	public static void main(String[] args) throws IOException {
		EjercicioOIA ejercicio = new EjercicioOIA();
		ejercicio.leer("src/unlam/progava/oia/in/00.in");
		ejercicio.resolver();
		ejercicio.escribir("src/unlam/progava/oia/out/00.out");
	}
	
	public void leer(String path) throws IOException {
		sistema = Archivo.leerArchivo(path);
	}
	
	public void escribir(String path) throws IOException{
		System.out.print(this.sistema.getResultado());
		Archivo.escribirArchivo(path, this.sistema.getResultado());
		
	}
	
	public void resolver() {
		sistema.resolver();
	}
}
