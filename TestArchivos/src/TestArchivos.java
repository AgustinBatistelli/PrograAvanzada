import java.io.*;
import java.util.Scanner;

public class TestArchivos {
	public static void main(String[] args) {
		try {
			File archivo = new File("./archivosEjercicios/pruebaNumeros.txt");
			Scanner scannerArchivo = new Scanner(archivo);
			
			String linea;
			String[] datos;			
			
			while(scannerArchivo.hasNextLine()) {
				int contador = 0;
				linea = scannerArchivo.nextLine();
				datos = linea.split(" ");
				
				for(int i = 0; i < datos.length; i++) {
					contador += Integer.parseInt(datos[i]);
				}
				
				System.out.println(linea + " ----> " + contador);
			}
			scannerArchivo.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
//	public static void main(String[] args) {
//		try {
//			File archivo = new File("./archivosEjercicios/pruebaTexto.txt");
//			Scanner scannerArchivo = new Scanner(archivo);
//			
//			String linea;
//			String[] arrayStrings = new String[50];
//			int i = 0;
//			
//			while(scannerArchivo.hasNextLine()) {
//				linea = scannerArchivo.nextLine();
//				arrayStrings[i] = linea;
//				i++;
//				System.out.println(linea);
//			}
//			
//			System.out.println("Ahora itero el array");
//			
//			for(i = 0; i < arrayStrings.length; i++) {
//				System.out.println(arrayStrings[i]);
//			}
//			
//			scannerArchivo.close();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
}
