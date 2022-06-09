package pateando.al.arco.oia;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EjercicioOIA {
	
	private Robot robot;

	public static void main(String[] args) throws Exception {
		EjercicioOIA ejercicio = new EjercicioOIA();
		ejercicio.leer("02.in");
		ejercicio.resolver();
		ejercicio.escribir("02.out");
	}

	private void escribir(String path) throws IOException {
		GestorArchivo.escribirArchivo(path, this.robot.getResultado());
	}

	private void resolver() {
		robot.resolver();
	}

	private void leer(String path) throws FileNotFoundException {
		robot = GestorArchivo.leerArchivo(path);
	}

}
