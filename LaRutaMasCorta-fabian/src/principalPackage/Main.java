package principalPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		try {
			File entrada = new File("distancias.in");
			File salida = new File("rutaMasCorta.out");
			
			RutaMasCorta ruta = new RutaMasCorta(entrada, salida);
			ruta.resolver();
		} catch (FileNotFoundException e) {
			System.out.println("Error al leer el archivo de entrada distancias.in");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al crear el archivo de salida rutaMasCorta.out");
			e.printStackTrace();
		}
	}

}
