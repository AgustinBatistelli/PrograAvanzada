package oia;

import java.io.IOException;

import org.junit.Test;

public class CarreraTest {
	
private Carrera resolucion;
	
	public void leer(String path) throws IOException {
		resolucion = GestorArchivos.leerArchivo(path);
	}
	
	public void escribir(String path) throws IOException{
		GestorArchivos.escribirArchivo(path, this.resolucion.getResultado());
		
	}
	
	public void resolver() throws Exception {
		resolucion.resolver();
	}

	@Test
	public void test() throws Exception {
		CarreraTest ejercicio = new CarreraTest();
		ejercicio.leer("carrera.in");
		ejercicio.resolver();
		ejercicio.escribir("carrera.out");
	}

}
