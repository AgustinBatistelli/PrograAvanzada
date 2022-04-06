import java.io.*;
import java.util.Scanner;

public class Ejercicio07 {	
	public void crearArchivoRandoms() {
		try {
			File f = new File("./archivos/archivoRandoms.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			
			int cantNumeros = (int) Math.floor(10000 + Math.random() * 10000); 	
			for (int i = 1; i < cantNumeros; i++) {
				int numRandom = (int) Math.floor(Math.random() * 12000);
				bw.write(numRandom + "\n");
			}
			
			bw.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void crearArchivoTabla() {
		try {
			//Abro el archivo de entrada con numeros aleatorios
			File fLectura = new File("./archivos/archivoRandoms.txt");
			Scanner archivoEntrada = new Scanner(fLectura);
			
			
			//Genero un archivo de salida con la tabla
			File fEscritura = new File("./archivos/archivoTabla.txt");
			FileWriter fw = new FileWriter(fEscritura);
			BufferedWriter archivoSalida = new BufferedWriter(fw);
			
			int numRandom = archivoEntrada.nextInt();
			int max = numRandom,
				min = numRandom,
				suma = 0,
				cantNumeros = 0;

			while(archivoEntrada.hasNextInt()) {
				numRandom = archivoEntrada.nextInt();
				if(numRandom > max) {
					max = numRandom;
				}
				
				if(numRandom < min) {
					min = numRandom;
				}
				suma += numRandom;
				cantNumeros++;
			}
			
			archivoSalida.write("+----------+-------+\n");
			archivoSalida.write(String.format("| Máximo   | %5d |\n", max));
			archivoSalida.write("+----------+-------+\n");
			archivoSalida.write(String.format("| Mínimo   | %5d |\n", min));
			archivoSalida.write("+----------+-------+\n");
			archivoSalida.write(String.format("| Promedio | %5d |\n", suma / cantNumeros));
			archivoSalida.write("+----------+-------+");
			
			archivoEntrada.close();
			archivoSalida.close();
			System.out.println("Archivo creado de tabla correctamente");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Ejercicio07 ejercicio = new Ejercicio07();
		ejercicio.crearArchivoRandoms();
		ejercicio.crearArchivoTabla();
	}
}
