package main;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Negocio negocio = new Negocio();
		ManejadorArchivos archivo = new ManejadorArchivos();
		try {
			int resultado = negocio.apilar(archivo.leerArchivoDeMesadas());
			archivo.escribirResultado(resultado);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
