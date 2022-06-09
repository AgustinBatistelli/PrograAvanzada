package myPackage;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		File entrada = new File("entrada.in");
		File salida = new File("salida.out");
		Probador probador = new Probador(entrada, salida);
		if(probador.probar())
			System.out.println("b");
		else
			System.out.println("p");
	}
	
}
